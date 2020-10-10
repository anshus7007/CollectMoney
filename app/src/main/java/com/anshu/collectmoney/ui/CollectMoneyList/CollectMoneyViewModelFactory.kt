package com.anshu.collectmoney.ui.CollectMoneyList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anshu.collectmoney.data.repositories.CollectMoneyRepository

@Suppress("UNCHECKED_CAST")
class CollectMoneyViewModelFactory(
    private val repository: CollectMoneyRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CollectMoneyViewModel(repository) as T
    }
}