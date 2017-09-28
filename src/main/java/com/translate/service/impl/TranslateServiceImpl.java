package com.translate.service.impl;

import com.translate.domain.Word;
import com.translate.reposity.WordRepository;
import com.translate.service.TranslateService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.inject.Inject;
import java.util.*;
import static com.translate.common.Constant.*;

/**
 * Translate word service implmetion
 * the English grammar:
 * First condition:last char is "y",replace the "y" to "i" then append "es";
 * Second condition:last char is "s,sh,ch,x",append "es";
 * Third condition:last char is "o",append "s" after these words like "photo,piano,radio,zoo",append "es" after "potato" or "tomato";
 * Forth condition:last char is "f" or "fe",append "s" after "belief,roof,safe,gulf",otherwise,remove the "f" or "fe" then append "ves" after
 * "half,knife,leaf,wolf,wife,life,thief";
 * Fifth conditon: seed word + "s";
 *
 * @Autor:Dave
 * @Create:2017-09-26 21:40
 */
@Service
public class TranslateServiceImpl implements TranslateService{

    @Inject
    private WordRepository repository;

    @Override
    public Word save(Word word) {
        Assert.notNull(word,"word is null!");
        if(!checkExist(word)){
            return repository.save(word);
        }
        return null;
    }

    @Override
    public List<Word> getWord(Word word) {
        Assert.notNull(word,"word is null!");
        List<Word> list = getSpecialWord(word);
        if(null == list || list.size() == 0){
            list = getGeneralWord(word);
        }
        return list;
    }

    protected boolean checkExist(Word word){
        Assert.notNull(word.getSeedWord(),"seed word is null!");
        return repository.countBySeedWord(word.getSeedWord()) != 0;
    }

    protected List<Word> getGeneralWord(Word word){
        Assert.notNull(word.getSeedWord(),"seed word is null!");
        boolean flag = false;
        List<Word> list = new ArrayList<>();
        StringBuilder seedWord = new StringBuilder(word.getSeedWord().toLowerCase());
        StringBuilder pluralWord;
        List<String> pluralWordArray = new ArrayList<>();
        int len = seedWord.length();

        if(Arrays.binarySearch(Y_CONDITION_CHAR,seedWord.charAt(len - 1)) > 0){
            pluralWord = seedWord.replace(len - 1,len,"ies");
            pluralWordArray.add(pluralWord.toString());
            flag = true;
        }

        if((Arrays.binarySearch(SH_CONDITION_CHAR,seedWord.substring(len -1)) > 0 ||
                Arrays.binarySearch(SH_CONDITION_CHAR,seedWord.substring(len - 2)) > 0) && !flag){
            pluralWord = seedWord.append("es");
            pluralWordArray.add(pluralWord.toString());
            flag = true;
        }

        if(Arrays.binarySearch(O_CONDITION_CHAR,seedWord.charAt(len - 1)) > 0 && !flag){
            pluralWordArray = getKeyList(O_CONDITION_WORDS,seedWord.toString());
            flag = true;
        }

        if((Arrays.binarySearch(F_CONDITION_CHAR,seedWord.substring(len - 1)) > 0 ||
                Arrays.binarySearch(F_CONDITION_CHAR,seedWord.substring(len - 2)) > 0) && !flag){
            pluralWordArray = getKeyList(F_CONDITION_WORDS,seedWord.toString());
            flag = true;
        }

        if(!flag){
            pluralWord = seedWord.append("s");
            pluralWordArray.add(pluralWord.toString());
        }

        for(String plural : pluralWordArray){
            word.setPluralWord(plural);
            list.add(word);
        }
        return list;
    }

    protected List<Word> getSpecialWord(Word word){
        Assert.notNull(word.getSeedWord(),"seed word is null!");
        return repository.findAllBySeedWord(word.getSeedWord());
    }

    /**
     * Get the key list by value from the map
     * @param map
     * @param value
     * @return
     */
    private static List<String> getKeyList(Map<String,String> map,String value){
        List<String> keyList = new ArrayList<>();
        for(String key : map.keySet()){
            if(map.get(key).equals(value)){
                keyList.add(key);
            }
        }
        return keyList;
    }

    public static void main(String[] args){
        StringBuilder a = new StringBuilder("tony");
        String b = a.substring(a.length() - 1);
        System.out.println(b);
    }
}
