package com.lizheblogs.wordnotes.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by LiZhe on 2018-11-05.
 * com.lizheblogs.wordnotes.db
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    private static volatile WordRoomDatabase INSTANCE;

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Word word = new Word("Hello", "你好");
            mDao.insert(word);
            word = new Word("World", "世界");
            mDao.insert(word);
            word = new Word("q", "世界");
            mDao.insert(word);
            word = new Word("w", "世界");
            mDao.insert(word);
            word = new Word("qq", "世界");
            mDao.insert(word);
            word = new Word("ww", "世界");
            mDao.insert(word);
            word = new Word("aa", "世界");
            mDao.insert(word);
            word = new Word("dd", "世界");
            mDao.insert(word);
            word = new Word("ff", "世界");
            mDao.insert(word);
            word = new Word("vv", "世界");
            mDao.insert(word);
            word = new Word("sx", "世界");
            mDao.insert(word);
            word = new Word("qw", "世界");
            mDao.insert(word);
            word = new Word("asd", "世界");
            mDao.insert(word);
            word = new Word("4ee2", "世界");
            mDao.insert(word);
            word = new Word("wee2", "世界");
            mDao.insert(word);
            word = new Word("vr4", "世界");
            mDao.insert(word);
            word = new Word("66y", "世界");
            mDao.insert(word);
            word = new Word("bgf", "世界");
            mDao.insert(word);
            return null;
        }
    }

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WordDao wordDao();
}
