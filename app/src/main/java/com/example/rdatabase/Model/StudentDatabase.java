package com.example.rdatabase.Model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//Todo --> database class

@Database(entities = {StudentEntity.class},version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDAO studentDAO();

}
