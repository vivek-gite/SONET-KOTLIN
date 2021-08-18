package com.practice.ngitapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1,exportSchema = false) //exportSchema=false tells
                        // that not to create any temporary file for any system failure
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao
}