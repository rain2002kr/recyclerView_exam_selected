package com.example.recyclerview_exam_selected

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_box1.view.*

class ItemAdapter(val id:Int, val list : List<ItemModel>) : RecyclerView.Adapter<ItemViewHolder>() {
    val selectionList = mutableListOf<Long>()
    var onItemSelectionChangeListener: ((MutableList<Long>) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(id, parent, false)
        view.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val id  = v?.tag
                if(selectionList.contains(id)){selectionList.remove(id)}
                else {selectionList.add(id as Long) }
                notifyDataSetChanged()
                onItemSelectionChangeListener?.let{it(selectionList)}

            }
        })
        return  ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.containerView.imageView.setImageResource(list[position].imageId)
        holder.containerView.textView.text = list[position].name
        holder.containerView.tag  = getItemId(position)
        holder.containerView.isActivated = selectionList.contains(getItemId(position))

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}