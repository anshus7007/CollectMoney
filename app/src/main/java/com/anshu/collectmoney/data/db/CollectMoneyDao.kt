package com.anshu.collectmoney.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.anshu.collectmoney.data.db.entity.CollectMoneyItem

@Dao
interface CollectMoneyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: CollectMoneyItem)

    @Delete
    suspend fun delete(item: CollectMoneyItem)

    @Query("SELECT * FROM collect_money_items")
    fun getAllMoneyItems(): LiveData<List<CollectMoneyItem>>
}