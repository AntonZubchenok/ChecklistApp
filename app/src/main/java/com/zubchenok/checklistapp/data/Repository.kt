package com.zubchenok.checklistapp.data

import android.content.Context
import com.zubchenok.checklistapp.data.entity.Item
import com.zubchenok.checklistapp.data.local.MyDatabase

/**
 * Created by Anton Zubchenok
 * 28.07.2018.
 */
class Repository(context: Context) {

	companion object {
		private var INSTANCE: Repository? = null
		private val lock = Any()

		fun getInstance(context: Context): Repository {
			synchronized(lock) {
				if (INSTANCE == null) {
					INSTANCE = Repository(context)
				}
				return INSTANCE!!
			}
		}
	}

	private val database = MyDatabase.getInstance(context)

	fun getItems() = database.itemDao().getItems()

	fun getItemById(id: Int) = database.itemDao().getItemById(id)

	fun insertItem(item: Item) {
		database.itemDao().insertItem(item)
	}

	fun insertItems(items: List<Item>) {
		database.itemDao().insertItems(items)
	}

	fun updateItem(item: Item) {
		database.itemDao().updateItem(item)
	}

	fun deleteItemById(id: Int) {
		database.itemDao().deleteItemById(id)
	}

	fun deleteAllItems() {
		database.itemDao().deleteAllItems()
	}

}