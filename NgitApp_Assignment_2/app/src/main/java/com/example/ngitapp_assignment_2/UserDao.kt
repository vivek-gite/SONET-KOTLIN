package com.example.ngitapp_assignment_2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM user_table")
    fun fetchUser(): LiveData<List<UserEntity>> //Here LiveData will change the list in realtime

    @Query("SELECT * FROM user_table WHERE roll_number LIKE :rollNo")
    suspend fun fetchCredentials(rollNo:String): List<UserEntity>

    //Delete User by Roll Number
    @Query("DELETE FROM user_table WHERE roll_number LIKE :rollNo") // we can write like
    // this also"DELETE FROM user_table WHERE roll_number = :rollNo"
    suspend fun deleteByRollNo(rollNo: String)


    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Update
    suspend fun updateUser(user: UserEntity)

}