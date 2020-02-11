package com.example.rdatabase.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

public class DatabaseClient {
    private Context mContext;
    private static DatabaseClient mInstance;
    //student database create instance
    private StudentDatabase studentDatabase;

    private DatabaseClient(Context cntx)
    {
        this.mContext = cntx;

        studentDatabase = Room.databaseBuilder(mContext,StudentDatabase.class,"mytodo").build();
    }

    public static synchronized DatabaseClient getInstance(Context ctx)
    {
        if(mInstance == null)
        {
            mInstance = new DatabaseClient(ctx);
        }
        return mInstance;
    }
        public StudentDatabase getDatabaseClient()
        {
            return studentDatabase;
        }
}
