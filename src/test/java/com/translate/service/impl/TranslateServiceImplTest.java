package com.translate.service.impl;

import java.util.List;
import com.translate.domain.Word;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

/**
 * Created by Dave on 2017/9/27.21:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TranslateServiceImplTest {
    @Inject
    private TranslateServiceImpl translateService;

    @Test
    public void save() throws Exception {
        Word data = new Word("apple","apples");
        Word result = translateService.save(data);
        Assert.assertNotNull(result);
    }

    @Test
    public void getWord() throws Exception {
        Word data = new Word("lemon");
        List<Word> result = translateService.getWord(data);
        Assert.assertNotEquals(0,result.size());
    }

}