package com.alertdialog.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alertdialog.R
import com.alertdialog.extensions.AlertDialog
import com.alertdialog.extensions.ProgressDialog
import com.alertdialog.extensions.SheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        alertDialogButton.setOnClickListener {
            val alertDialog = AlertDialog(this)
            alertDialog.setTitle(R.string.mobile_phone_password_wrong)
            alertDialog.show()
        }

        sheetDialogButton.setOnClickListener {
            val items = arrayOf(getString(R.string.password_login), getString(R.string.sms_login_or_register))
            val sheetDialog = SheetDialog(this, items)
            sheetDialog.setMessage(R.string.logout_prompt)
            sheetDialog.show()
            sheetDialog.onItemClickListener = {

            }
        }

        progressButton.setOnClickListener {
            val progressDialog = ProgressDialog(this)
            progressDialog.show()
        }
    }
}
