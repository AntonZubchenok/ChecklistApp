package com.zubchenok.checklistapp.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.zubchenok.checklistapp.data.Repository
import com.zubchenok.checklistapp.data.entity.Item

/**
 * Created by Anton Zubchenok
 * 28.07.2018.
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

	private val repository: Repository = Repository(application)
	var allItems = repository.getItems()

	fun saveItem(item: Item) {
		repository.insertItem(item)
	}

}