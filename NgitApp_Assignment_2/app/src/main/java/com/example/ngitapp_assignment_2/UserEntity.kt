package com.example.ngitapp_assignment_2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name = "first_name")
    var firstName:String,
    @ColumnInfo(name = "last_name")
    var lastName:String,
    @ColumnInfo(name = "roll_number")
    var rollNumber:String,
    @ColumnInfo(name = "password")
    var password:String
)
