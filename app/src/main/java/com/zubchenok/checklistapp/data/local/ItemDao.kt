package com.zubchenok.checklistapp.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.zubchenok.checklistapp.data.entity.Item

/**
 * Created by anton.zubchenok
 * 7/26/18.
 */

@Dao
interface ItemDao {

	@Query("SELECT * FROM Items")
	fun getItems(): LiveData<List<Item>>

	@Query("SELECT * FROM Items WHERE id = :itemId")
	fun getItemById(itemId: Int): LiveData<Item?>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertItem(item: Item)

	//Not sure it will work
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertItems(items: List<Item>)

	@Update
	fun updateItem(item: Item): Int

	@Query("DELETE FROM Items WHERE id = :itemId")
	fun deleteItemById(itemId: Int): Int

	@Query("DELETE FROM Items")
	fun deleteAllItems()

}