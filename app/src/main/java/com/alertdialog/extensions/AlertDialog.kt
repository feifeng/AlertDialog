package com.alertdialog.extensions

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.alertdialog.R
import kotlinx.android.synthetic.main.dialog_alert.*

class AlertDialog(context: Context) : AlertDialog(context, R.style.AlertDialogTheme) {

    private var titleId: Int = 0

    init {
        setCancelable(false)
    }

    override fun setTitle(titleId: Int) {
        super.setTitle(titleId)
        this.titleId = titleId
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_alert)
        titleTextView.text = context.getString(titleId)

        confirmButton.setOnClickListener {
            cancel()
        }
    }
}