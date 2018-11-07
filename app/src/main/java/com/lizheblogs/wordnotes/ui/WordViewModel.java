package com.lizheblogs.wordnotes.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.lizheblogs.wordnotes.db.Word;
import com.lizheblogs.wordnotes.db.WordRepository;

import java.util.List;

/**
 * Created by LiZhe on 2018-11-06.
 * com.lizheblogs.wordnotes.ui
 */
public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }


}
