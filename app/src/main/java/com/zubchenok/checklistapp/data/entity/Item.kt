package com.zubchenok.checklistapp.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * Created by anton.zubchenok
 * 7/26/18.
 */

@Entity(tableName = "items")
data class Item(
		@PrimaryKey(autoGenerate = true)
		var id: Int? = null,

		@NonNull
		var text: String,

		@NonNull
		var isChecked: Boolean
)