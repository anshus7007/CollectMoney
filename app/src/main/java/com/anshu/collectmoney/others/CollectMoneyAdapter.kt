package com.anshu.collectmoney.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anshu.collectmoney.R
import com.anshu.collectmoney.data.db.entity.CollectMoneyItem
import com.anshu.collectmoney.ui.CollectMoneyList.CollectMoneyViewModel
import kotlinx.android.synthetic.main.collect_money_item.view.*

class CollectMoneyAdapter(
     var item: List<CollectMoneyItem>,
     private val viewModel: CollectMoneyViewModel

) : RecyclerView.Adapter<CollectMoneyAdapter.CollectMoneyViewHolder>(){


            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectMoneyViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.collect_money_item,parent,false)
                return CollectMoneyViewHolder(view)
            }

            override fun onBindViewHolder(holder: CollectMoneyViewHolder, position: Int) {
                val currItem=item[position]

                holder.itemView.tvNameOfThePayer.text=currItem.name
                holder.itemView.tvAmount.text="${currItem.amount}"

                holder.itemView.ivDelete.setOnClickListener {
                    viewModel.delete(currItem)
                }
                holder.itemView.ivAdd.setOnClickListener {
                    currItem.amount++
                    viewModel.upsert(currItem)
                }
                holder.itemView.ivMinus.setOnClickListener {
                    if(currItem.amount>0) {
                        currItem.amount--
                        viewModel.upsert(currItem)
                    }
                }
            }

            override fun getItemCount(): Int {
                return item.size
            }
    class CollectMoneyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}