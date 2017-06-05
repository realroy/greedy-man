package com.example.oldroy.greedyman.models

class User {
    var name = ""
    var password = ""
    var friends = ArrayList<String>()
    override fun toString(): String {
        return "User = {" +
                "\tname: $name," +
                "\tpassword: $password," +
                "\tfriends: $friends" +
                "}"
    }
}