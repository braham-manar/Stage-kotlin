package com.example.stagekotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stagekotlin.models.Company
import com.example.stagekotlin.models.Person
import kotlinx.android.synthetic.main.fragment_recycle_.*


class Recycle_Fragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycle_, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList : ArrayList<String> = arrayListOf()

        dataList.add("1")
        dataList.add("2 ")
        dataList.add("3")
        dataList.add("4")
        dataList.add("hfjfh")
        dataList.add("hfjfh")
        dataList.add("hfjfh")
        dataList.add("hfjfh")
        dataList.add("hfjfh")
        dataList.add("hfjfh")



        var companyList : ArrayList<Company> = arrayListOf()

        var personList  : ArrayList<Person> = arrayListOf()

        var person1 = Person("manar" , "braham",22)
        var person2 = Person("manar 2" , "braham 2",22)
         personList.add(person1)
         personList.add(person2)

        var company1 = Company("company name 1", "sousse", personList )
        var company2 = Company("company name 2", "sousse2", personList )
        var company3 = Company("company name 3", "sousse3", personList )

           companyList.add(company1)
           companyList.add(company2)
           companyList.add(company3)


        recycle_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = RecyclerAdapter()
            ( adapter  as RecyclerAdapter).setDataToAdapter(companyList)
        }

    }



}