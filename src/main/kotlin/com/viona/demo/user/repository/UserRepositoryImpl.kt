package com.viona.demo.user.repository

import com.mongodb.client.MongoCollection
import com.viona.demo.database.DatabaseComponent
import com.viona.demo.user.entity.User
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {

    private val userList: MutableList<User> = mutableListOf()

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection(): MongoCollection<User> =
            databaseComponent.database.getDatabase("user").getCollection()

    override fun getUserByName(name: String): User? {
        val user = userCollection().findOne(User::name eq name)
        return user
    }

    override fun getUsers(): MutableList<User> = userCollection().find().toMutableList()

    override fun addUser(name: String): List<User>
    {
        val newUser = User(name = name)
        val insert = userCollection().insertOne(newUser)
        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw java.lang.IllegalStateException("insert gagal")
        }
    }

}