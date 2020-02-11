package com.example.rdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rdatabase.Model.DatabaseClient;
import com.example.rdatabase.Model.StudentEntity;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDatafromDatabase();
            }
        });
    }
    public void getDatafromDatabase()
    {
        class GetData extends AsyncTask<Void,Void, List<StudentEntity>>
        {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(Main2Activity.this,"OnpreExecute is started",Toast.LENGTH_LONG).show();
            }

            @Override
            protected List<StudentEntity> doInBackground(Void... voids) {
                List<StudentEntity> studentEntities = DatabaseClient.getInstance(Main2Activity.this).getDatabaseClient().studentDAO().getAll();
                return studentEntities;
            }

            @Override
            protected void onPostExecute(List<StudentEntity> studentEntities) {
                super.onPostExecute(studentEntities);
               System.out.println(studentEntities.toString());


            }
        }

        new GetData().execute();
    }
}
