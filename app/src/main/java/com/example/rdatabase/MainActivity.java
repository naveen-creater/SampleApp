package com.example.rdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rdatabase.Model.DatabaseClient;
import com.example.rdatabase.Model.StudentEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText fistName,lastname,department,college;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initView
        initView();
    }

    private void initView() {
        fistName = findViewById(R.id.firstName);
        lastname = findViewById(R.id.lastName);
        department = findViewById(R.id.department);
        college = findViewById(R.id.college);
        save = findViewById(R.id.save);
        listeners();

    }

    private void listeners() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        findViewById(R.id.getData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDatafromDatabase();
            }
        });
    }

    private void saveData() {
        boolean ffname=false,flname=false,fdept=false,fclg=false;
        String fName = null;
        String lName = null;
        String depart = null;
        String clg = null;

        if(!fistName.getText().toString().isEmpty())
        {
            fName = fistName.getText().toString().trim();
            ffname=true;
        }
        else
            fistName.setError("isEmpty");


        if(!lastname.getText().toString().isEmpty())
        {
            lName = lastname.getText().toString().trim();
            flname=true;
        }
        else
            lastname.setError("isEmpty");


        if(!department.getText().toString().isEmpty())
        {
            depart = department.getText().toString().trim();
            fdept=true;
        }
        else
            department.setError("isEmpty");


        if(!college.getText().toString().isEmpty())
        {
            clg = college.getText().toString().trim();
            fclg = true;
        }
        else
            college.setError("isEmpty");


        String finalFName = fName;
        String finalLName = lName;
        String finalDepart = depart;
        String finalClg = clg;

        if(ffname && flname && fclg && fdept)
        {
            class SaveTask extends AsyncTask<Void,Void,Void> {


                @Override
                protected Void doInBackground(Void... voids) {

                    StudentEntity studentEntity =new StudentEntity();
                    studentEntity.setFirstName(finalFName);
                    studentEntity.setLastName(finalLName);
                    studentEntity.setDepartment(finalDepart);
                    studentEntity.setCollege(finalClg);

                    DatabaseClient.getInstance(MainActivity.this).getDatabaseClient().studentDAO().insert(studentEntity);
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);

                    Toast.makeText(getApplicationContext(), "Data is Saved...", Toast.LENGTH_LONG).show();

                }
            }

            new SaveTask().execute();
        }

    }


    public void getDatafromDatabase()
    {
        class GetData extends AsyncTask<Void,Void, List<StudentEntity>>
        {

            @Override
            protected List<StudentEntity> doInBackground(Void... voids) {
                List<StudentEntity> studentEntities = DatabaseClient.getInstance(MainActivity.this).getDatabaseClient().studentDAO().getAll();
                return studentEntities;
            }

            @Override
            protected void onPostExecute(List<StudentEntity> studentEntities) {
                super.onPostExecute(studentEntities);

    //                System.out.println(studentEntities.toString());
                startActivity(new Intent(MainActivity.this,Main2Activity.class));

            }
        }
        new GetData().execute();
    }
}
