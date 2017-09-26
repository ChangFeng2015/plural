package com.translate.reposity;

import java.util.List;

import com.translate.domain.Word;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * word repository
 *
 * @Autor:Dave
 * @Create:2017-09-26 21:48
 */
@Repository
public interface WordRepository extends CrudRepository<Word,Long>,JpaSpecificationExecutor<Word> {
    /**
     * Get the count for seed word
     *
     * @param seedWord
     * @return
     */
    Long countBySeedWord(String seedWord);

    /**
     * Get the word by seed word
     *
     * @param seedWord
     * @return
     */
    List<Word> findAllBySeedWord(String seedWord);
}
