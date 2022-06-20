package com.viona.demo.user.repository

import com.viona.demo.user.entity.User

interface UserRepository {

    fun getUserByName(name: String) : User?
    fun getUsers(): MutableList<User>
    fun addUser(name: String): List<User>
}