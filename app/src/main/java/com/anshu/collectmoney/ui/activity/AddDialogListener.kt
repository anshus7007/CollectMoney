package com.anshu.collectmoney.ui.activity

import com.anshu.collectmoney.data.db.entity.CollectMoneyItem

interface AddDialogListener {
    fun onAddButtonClicked(item:CollectMoneyItem)
}