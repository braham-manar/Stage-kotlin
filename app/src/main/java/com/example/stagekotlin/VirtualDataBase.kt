package com.example.stagekotlin

class VirtualDataBase constructor() {

     public var credentialList : MutableList<Pair<String, String>> =  arrayListOf()



    init {
        credentialList.add(0, Pair("test@gmail.com","azerty"))
        credentialList.add(1,Pair("test1@gmail.com","azerty1"))
        credentialList.add(2,Pair("",""))
        credentialList.add(3,Pair("",""))
        credentialList.add(4,Pair("",""))
    }

}