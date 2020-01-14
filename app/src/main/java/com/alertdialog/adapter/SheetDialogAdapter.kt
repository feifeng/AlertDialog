package com.alertdialog.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alertdialog.R
import com.alertdialog.viewHolder.SheetDialogViewHolder

class SheetDialogAdapter(private val context: Context, private val items: Array<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var onItemClickListener: (position: Int) -> Unit
    var color: Int = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.dialog_sheet_item, viewGroup, false)
        return SheetDialogViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is SheetDialogViewHolder) {

            viewHolder.itemTextView.text = items[position]
            viewHolder.dividersView.visibility = if (position == items.size - 1) View.GONE else View.VISIBLE

            if (color != 0) {
                viewHolder.itemTextView.setTextColor(color)
            }

            viewHolder.itemTextView.setOnClickListener {
                onItemClickListener.invoke(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (items.isEmpty()) 1 else items.size
    }

    fun setStyle(color: Int) {
        this.color = context.resources.getColor(color)
        notifyDataSetChanged()
    }
}
