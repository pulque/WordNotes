package com.lizheblogs.wordnotes.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by LiZhe on 2018-11-05.
 * com.lizheblogs.wordnotes.db
 */
@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;
    @NonNull
    @ColumnInfo(name = "chinese")
    private String mChinese;

    public Word(@NonNull String word, @NonNull String chinese) {
        this.mWord = word;
        this.mChinese = chinese;
    }

    public String getWord() {
        return this.mWord;
    }

    public String getChinese() {
        return mChinese;
    }
}
