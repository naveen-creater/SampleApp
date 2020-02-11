package com.example.rdatabase.Model;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Todo -->Student DAO interface

@Dao
public interface StudentDAO {

    @Query("SELECT * FROM studententity")
    List<StudentEntity> getAll();

    @Insert
    void insert(StudentEntity studentEntity);

    @Delete
    void delete(StudentEntity studentEntity);

    @Update
    void update(StudentEntity studentEntity);
}
