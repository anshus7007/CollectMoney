package com.anshu.collectmoney.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.anshu.collectmoney.R
import com.anshu.collectmoney.data.db.CollectMoneyDatabase
import com.anshu.collectmoney.data.db.entity.CollectMoneyItem
import com.anshu.collectmoney.data.repositories.CollectMoneyRepository
import com.anshu.collectmoney.others.CollectMoneyAdapter
import com.anshu.collectmoney.ui.CollectMoneyList.CollectMoneyViewModel
import com.anshu.collectmoney.ui.CollectMoneyList.CollectMoneyViewModelFactory
import kotlinx.android.synthetic.main.activity_collect_money.*

class CollectMoneyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collect_money)

        val database= CollectMoneyDatabase(this)
        val repository=CollectMoneyRepository(database)
        val factory= CollectMoneyViewModelFactory(repository)
        val viewmodel = ViewModelProviders.of(this,factory).get(CollectMoneyViewModel::class.java)


        val adapter= CollectMoneyAdapter(listOf(),viewmodel)
        rvCollectMoneyItems.layoutManager=LinearLayoutManager(this)
        rvCollectMoneyItems.adapter=adapter

        viewmodel.getAllMoneyItems().observe(this, Observer {
            adapter.item=it
            adapter.notifyDataSetChanged()
        })


        fab.setOnClickListener {
            AddCollectMoneyDialog(this,
            object : AddDialogListener{
                override fun onAddButtonClicked(item: CollectMoneyItem) {
                    viewmodel.upsert(item)
                }
            }).show()
        }
    }
}