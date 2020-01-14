package com.alertdialog.extensions

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alertdialog.R
import com.alertdialog.adapter.SheetDialogAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_sheet.*

class SheetDialog(context: Context, items: Array<String>) : BottomSheetDialog(context, R.style.BottomSheetDialogTheme) {

    private var sheetDialogAdapter: SheetDialogAdapter

    var onItemClickListener: ((position: Int) -> Unit)? = null
    var onCancelListener: ((title: Int) -> Unit)? = null

    init {
        val view = layoutInflater.inflate(R.layout.dialog_sheet, null)
        setContentView(view)

        recyclerView.layoutManager = LinearLayoutManager(context)
        sheetDialogAdapter = SheetDialogAdapter(context, items)
        recyclerView.adapter = sheetDialogAdapter

        sheetDialogAdapter.onItemClickListener = {
            cancel()
            onItemClickListener?.invoke(it)
        }

        cancelButton.setOnClickListener {
            cancel()
            if (onCancelListener != null)
            onCancelListener?.invoke(1)
        }
    }

    fun setMessage(message: Int) {
        messageTextView.text = context.getString(message)
        messageTextView.visibility = View.VISIBLE
        dividersView.visibility = View.VISIBLE
    }

    fun setStyle(color: Int) {
        sheetDialogAdapter.setStyle(color)
    }
}
