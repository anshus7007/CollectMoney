package com.anshu.collectmoney.ui.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.anshu.collectmoney.R
import com.anshu.collectmoney.data.db.entity.CollectMoneyItem
import kotlinx.android.synthetic.main.dialog_add_collectmoney_items.*

class AddCollectMoneyDialog(context:Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_collectmoney_items)

        etSave.setOnClickListener {
            val name =etName.text.toString()
            val amount= etAmountOfThePayer.text.toString()

            if(name.isEmpty()|| amount.isEmpty())
            {
                Toast.makeText(context,"Please enter all the info",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item= CollectMoneyItem(name,amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        etCancel.setOnClickListener {
            cancel()
        }
    }

}