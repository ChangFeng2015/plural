package com.translate.web;

import java.util.List;
import java.util.Objects;

import com.translate.domain.Word;
import com.translate.service.TranslateService;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

/**
 * Translate word controller
 *
 * @Autor:Dave
 * @Create:2017-09-26 21:19
 */
@RestController
@RequestMapping("/v1")
public class TranslateController {

    @Inject
    private TranslateService service;

    @PostMapping("/specialWord/save")
    public Word saveSpecial(Word word){
        if(Objects.nonNull(word) && StringUtils.hasText(word.getSeedWord()) && StringUtils.hasText(word.getPluralWord())){
           return service.save(word);
        }
        return null;
    }

    @GetMapping("/word/get/{seedWord}")
    public List<Word> getWord(@PathVariable(name = "seedWord")String seedWord){
        Assert.notNull(seedWord,"Seed word is null");
        Word word = new Word(seedWord,"");
        return null;
    }

}
