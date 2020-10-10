package com.anshu.collectmoney.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "collect_money_items")
 data class CollectMoneyItem(
    @ColumnInfo(name = "name_of_the_person")
    var name: String,
    @ColumnInfo(name = "amount_with_the_person")
    var amount: Int

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null


}