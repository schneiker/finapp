package com.example.financas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Financa::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun financaDao(): FinancaDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "financas_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
