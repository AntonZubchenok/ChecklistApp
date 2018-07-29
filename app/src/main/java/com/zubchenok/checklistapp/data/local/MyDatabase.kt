package com.zubchenok.checklistapp.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.zubchenok.checklistapp.data.entity.Item

/**
 * Created by anton.zubchenok
 * 7/26/18.
 */

@Database(entities = [(Item::class)], version = 1)
abstract class MyDatabase : RoomDatabase() {

	abstract fun itemDao(): ItemDao

	companion object {
		private var INSTANCE: MyDatabase? = null
		private val lock = Any()

		fun getInstance(context: Context): MyDatabase {
			synchronized(lock) {
				if (INSTANCE == null) {
					INSTANCE = Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, "MyDatabase.db")
							.allowMainThreadQueries()
							.fallbackToDestructiveMigration() //delete old database if new database have another schema
							.build()
				}
				return INSTANCE!!
			}
		}
	}

}