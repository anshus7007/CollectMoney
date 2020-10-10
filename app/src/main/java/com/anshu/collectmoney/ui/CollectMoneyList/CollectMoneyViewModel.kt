package com.anshu.collectmoney.ui.CollectMoneyList

import com.anshu.collectmoney.data.repositories.CollectMoneyRepository
import androidx.lifecycle.ViewModel
import com.anshu.collectmoney.data.db.entity.CollectMoneyItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CollectMoneyViewModel(
    private val repository: CollectMoneyRepository
): ViewModel() {

    fun upsert(item: CollectMoneyItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }
    fun delete(item: CollectMoneyItem)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllMoneyItems() = repository.getAllMoneyItems();
}