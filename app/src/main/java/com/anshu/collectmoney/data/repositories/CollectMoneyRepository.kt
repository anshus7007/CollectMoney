package com.anshu.collectmoney.data.repositories

import com.anshu.collectmoney.data.db.CollectMoneyDatabase
import com.anshu.collectmoney.data.db.entity.CollectMoneyItem

class CollectMoneyRepository(private val db: CollectMoneyDatabase) {

    suspend fun upsert(item: CollectMoneyItem)=db.getCollectMoneyDao().upsert(item)

    suspend fun delete(item: CollectMoneyItem)= db.getCollectMoneyDao().delete(item)

    fun getAllMoneyItems() = db.getCollectMoneyDao().getAllMoneyItems()
}