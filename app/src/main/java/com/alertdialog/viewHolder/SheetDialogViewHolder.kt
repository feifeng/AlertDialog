package com.alertdialog.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dialog_sheet_item.view.*

class SheetDialogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var itemTextView: TextView = view.itemTextView
    var dividersView: View = view.dividersView
}
