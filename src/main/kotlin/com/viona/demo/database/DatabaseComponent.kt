package com.viona.demo.database

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {

    companion object {
        private const val DB_URL = "mongodb+srv://vionavio:666198@cluster0.fybrt.mongodb.net/?retryWrites=true&w=majority"
    }

    val database: MongoClient = KMongo.createClient(DB_URL)
}