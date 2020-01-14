package com.alertdialog.extensions

import android.content.Context
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import com.alertdialog.R
import kotlinx.android.synthetic.main.dialog_progress.*

class ProgressDialog(context: Context) : AlertDialog(context, R.style.AlertDialogTheme) {

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_progress)

        progressBar.startAnimation(AnimationUtils.loadAnimation(context, R.anim.progress_anim))
    }
}