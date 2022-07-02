package com.example.stagekotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stagekotlin.models.Company

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var _dataList: ArrayList<Company> = arrayListOf()

    fun setDataToAdapter(data: ArrayList<Company>) {
        _dataList.addAll(data)
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recycler_view, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val company: Company = _dataList[position]

        holder.tvCompanyName.text = company.companyName

        company.persons.forEach { person ->
            holder.itemKode.text = holder.itemKode.text.toString() + person.firstName + " "
        }
    }

    override fun getItemCount(): Int {

        // return 5
        return _dataList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var itemKode: TextView = itemView.findViewById(R.id.kodePertanyaan)
        var tvCompanyName: TextView = itemView.findViewById(R.id.tv_company_name)


        init {

            itemView.setOnClickListener {

            }
        }
    }


}