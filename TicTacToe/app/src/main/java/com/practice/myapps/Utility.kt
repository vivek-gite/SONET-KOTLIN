package com.practice.myapps

class Utility {
    fun getQuestions(): ArrayList<Questions>{
        var list = ArrayList<Questions>()


        var q1 = Questions(1,"Killua is from where?","HXH","FMAB","One piece","AOT",1)
        var q2 = Questions(1,"What is Java?","Assembly Language","Scripting Language","Programming Language","Modern Language",3)
        var q3 = Questions(1,"Alphonse is from where?","HXH","FMAB","One piece","AOT",2)
        list.add(q1)
        list.add(q2)
        list.add(q3)

        return list
    }
}