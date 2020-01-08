package com.example.recyclerview_exam_selected

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf(
            ItemModel(R.drawable.img2, "1번 이미지"),
            ItemModel(R.drawable.img3, "2번 이미지"),
            ItemModel(R.drawable.img4, "3번 이미지"),
            ItemModel(R.drawable.img5, "4번 이미지"),
            ItemModel(R.drawable.img6, "5번 이미지"),
            ItemModel(R.drawable.img7, "6번 이미지")
            )

        val adpter = ItemAdapter(R.layout.item_box1, list)

        adpter.onItemSelectionChangeListener = {
            println("선택된 ID : $it")
        }
        container.adapter = adpter
        container.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)

    }
}
