package com.mohan.mayukh.imadblogapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthenticationActivity extends AppCompatActivity {
    EditText text1,text2;
    ProgressDialog progressdialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        text1=(EditText)findViewById(R.id.username);
        text2=(EditText)findViewById(R.id.passwd);
        Button signin=(Button)findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isValid())
                {
                    //perform signing in
                    performsignin();
                }
            }
        });
        Button reg=(Button)findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isValid())
                {
                    //perform signing in
                    performregistration();;
                }
            }
        });
        progressdialog=new ProgressDialog(this);
        progressdialog.setIndeterminate(true);
        progressdialog.setMessage("please wait");
    }
    private boolean isValid()
    {
        if(text1.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this,"You can't left the username empty",Toast.LENGTH_LONG).show();
            return false;
        }
        if(text2.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this,"You can't left the password empty",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    private void performsignin()
    {
        new SignInTask().execute(text1.getText().toString(),text2.getText().toString());
    }
    private void performregistration()
    {
        //for registration
    }
    private void showProgressDialog(Boolean shouldShould)
    {
        if(shouldShould)
        {
            progressdialog.show();
        }
        else
        {
            progressdialog.dismiss();
        }
    }
    private void showalert(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNeutralButton("Dismiss",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
    class SignInTask extends AsyncTask<String,Void,Boolean>
    {
        String mockUsername="name";
        String mockpassword="password";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressDialog(true);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            showProgressDialog(false);
            if(aBoolean)
            {
                showalert("Welcome","You have successfully signed in!!");
            }
            else
            {
                showalert("Failed","Your username and password are incorrect");
            }
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            String username=strings[0];
            String password=strings[1];

            return username.contentEquals(mockUsername) && password.contentEquals(mockpassword);
        }
    }
}
