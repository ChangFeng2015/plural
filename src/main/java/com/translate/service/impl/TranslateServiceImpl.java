package com.translate.service.impl;

import com.translate.domain.Word;
import com.translate.reposity.WordRepository;
import com.translate.service.TranslateService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.inject.Inject;
import java.util.*;

/**
 * Translate word service implmetion
 *
 * @Autor:Dave
 * @Create:2017-09-26 21:40
 */
@Service
public class TranslateServiceImpl implements TranslateService{

    @Inject
    private WordRepository repository;

    private static final Character[] SECOND_CONDITION_CHAR = new Character[]{'y'};
    private static final String[] THIRD_CONDITION_CHAR = new String[]{"s","sh","ch","x"};
    private static final Character[] FORTH_CONDITION_CHAR = new Character[]{'o'};
    private static final String[] FIFTH_CONDITION_CHAR = new String[]{"f","fe"};

    private static final Map<String,String> FORTH_CONDITION_WORDS = new HashMap<>();
    private static final Map<String,String> FIFTH_CONDITION_WORDS = new HashMap<>();

    static {
        FORTH_CONDITION_WORDS.put("","");
        FORTH_CONDITION_WORDS.put("","");
        FORTH_CONDITION_WORDS.put("","");
        FORTH_CONDITION_WORDS.put("","");
        FORTH_CONDITION_WORDS.put("","");
        FORTH_CONDITION_WORDS.put("","");

        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
        FIFTH_CONDITION_WORDS.put("","");
    }

    @Override
    public Word save(Word word) {
        Assert.notNull(word,"word is null!");
        if(checkExist(word)){
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
        return repository.countBySeedWord(word.getSeedWord()) > 0;
    }

    protected List<Word> getGeneralWord(Word word){
        Assert.notNull(word.getSeedWord(),"seed word is null!");
        List<Word> list = new ArrayList<>();
        StringBuilder seedWord = new StringBuilder(word.getSeedWord().toLowerCase());
        StringBuilder pluralWord = new StringBuilder();
        List<String> pluralWordArray = new ArrayList<>();
        int len = seedWord.length();
        boolean flag = false;

        //secode condition:last char is "y",replace the "y" to "i" then append "es";
        if(Arrays.binarySearch(SECOND_CONDITION_CHAR,seedWord.charAt(len - 1)) > 0){
            pluralWord = seedWord.replace(len - 1,len,"ies");
            pluralWordArray.add(pluralWord.toString());
            flag = true;
        }
        //third condition:last char is "s,sh,ch,x",append "es";
        if((Arrays.binarySearch(THIRD_CONDITION_CHAR,seedWord.charAt(len -1)) > 0 ||
                Arrays.binarySearch(THIRD_CONDITION_CHAR,seedWord.charAt(len - 2)) > 0) && !flag){
            pluralWord = seedWord.append("es");
            pluralWordArray.add(pluralWord.toString());
        }
        //forth condition:last char is "o",append "s" after these words like "photo,piano,radio,zoo",append "es" after "potato" or "tomato";
        if(Arrays.binarySearch(FORTH_CONDITION_CHAR,seedWord.charAt(len - 1)) > 0 && !flag){
            pluralWordArray = getKeyList(FORTH_CONDITION_WORDS,seedWord.toString());
        }

        //fifth condition:last char is "f" or "fe",append "s" after "belief,roof,safe,gulf",otherwise,remove the "f" or "fe" then append "ves" after
        //"half,knife,leaf,wolf,wife,life,thief"
        if((Arrays.binarySearch(FIFTH_CONDITION_CHAR,seedWord.charAt(len - 1)) > 0 ||
                Arrays.binarySearch(FIFTH_CONDITION_CHAR,seedWord.charAt(len - 2)) > 0) && !flag){
            pluralWordArray = getKeyList(FIFTH_CONDITION_WORDS,seedWord.toString());
        }

        //first conditon: seed word + "s"
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
        a.replace(a.length() - 1,a.length(),"ies");
        System.out.println(a);
    }
}
