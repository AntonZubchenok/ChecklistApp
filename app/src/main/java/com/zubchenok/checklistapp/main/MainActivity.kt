package com.zubchenok.checklistapp.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zubchenok.checklistapp.R
import com.zubchenok.checklistapp.data.entity.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private val viewModel: MainViewModel by lazy {
		ViewModelProviders.of(this).get(MainViewModel::class.java)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)


		viewModel.allItems.observe(this, Observer {
			if (it != null && !it.isEmpty()) {
				text_view.text = it[0].text
			}
		})

		btn_add_item.setOnClickListener {
			viewModel.saveItem(Item(12, "test text", false))
		}
	}
}
