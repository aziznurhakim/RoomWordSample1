package com.example.roomwordsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

class WordDao {
    fun insert(word: word.Word) {

    }

    @Dao
    interface WordDao {

        @Query("SELECT * FROM word_table ORDER BY word ASC")
        fun getAlphabetizedWords(): Flow<List<word.Word>>


        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(word: word.Word)

        @Query("DELETE FROM word_table")
        suspend fun deleteAll()


    }

    class Flow<T> {

    }


}