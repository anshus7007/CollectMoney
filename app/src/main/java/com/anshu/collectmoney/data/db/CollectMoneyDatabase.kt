package com.anshu.collectmoney.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.anshu.collectmoney.data.db.entity.CollectMoneyItem

@Database(
    entities = [CollectMoneyItem::class],
    version = 1)
abstract class CollectMoneyDatabase: RoomDatabase() {
    abstract fun getCollectMoneyDao() : CollectMoneyDao

    //static in java
    //creates single instance at a time
    //database class is used at different places in app so there should only be one call from any part of app
    //therefore companion object is used
    companion object{
        @Volatile
        private var instance: CollectMoneyDatabase?  = null

        private val LOCK = Any()
        //val db=CollectMoneyDatabase(this)::::invoke function will be called
        //if instance is null it'll create a new instance
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK)
        {
            //if instance is null createDatabase will be called
            instance ?: createDatabase(context).also {
                //result returned from createDatabase is stored in it
                instance =it
            }

        }
            //new instance will be create of this database class and result will be returned
            private  fun createDatabase(context: Context)=
                Room.databaseBuilder(context.applicationContext, CollectMoneyDatabase::class.java,
                "CollectMoneyDB.db").build()
        }

    }


