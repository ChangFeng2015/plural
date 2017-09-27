package com.translate.domain;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Word Entity
 *
 * @Autor:Dave
 * @Create:2017-09-26 21:10
 */
@Entity
@Table(name = "word_list")
public class Word implements Serializable{

    @Id
    private long id;
    @Column(name = "word")
    @NotBlank
    private String seedWord;
    @Column(name = "plural_word")
    private String pluralWord;

    public Word(){}

    public Word(String seedWord){
        this.seedWord = seedWord;
    }

    public Word(String seedWord,String pluralWord){
        this.seedWord = seedWord;
        this.pluralWord = pluralWord;
    }

    public String getSeedWord() {
        return seedWord;
    }

    public void setSeedWord(String seedWord) {
        this.seedWord = seedWord;
    }

    public String getPluralWord() {
        return pluralWord;
    }

    public void setPluralWord(String pluralWord) {
        this.pluralWord = pluralWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (id != word.id) return false;
        if (!seedWord.equals(word.seedWord)) return false;
        return pluralWord != null ? pluralWord.equals(word.pluralWord) : word.pluralWord == null;
    }

    @Override
    public int hashCode() {
        return seedWord.hashCode();
    }
}
