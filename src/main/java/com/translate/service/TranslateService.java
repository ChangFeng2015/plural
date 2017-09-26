package com.translate.service;

import java.util.List;
import com.translate.domain.Word;

/**
 * Translate word service
 *
 * @Autor:Dave
 * @Create:2017-09-26 21:32
 */

public interface TranslateService {
    /**
     * save word
     * @param word
     */
    Word save(Word word);

    /**
     * get word
     * @param word
     * @return
     */
    List<Word> getWord(Word word);
}
