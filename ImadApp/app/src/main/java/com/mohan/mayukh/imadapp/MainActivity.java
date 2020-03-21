package com.mohan.mayukh.imadapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText name=(EditText)findViewById(R.id.name);
        final TextView text=(TextView)findViewById(R.id.text);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_SHORT).show();
                String nam=name.getText().toString();
                if(nam.isEmpty())
                {
                    //show an alert
                    alert();
                }
                else
                {
                    text.setText("Hi "+nam+" I am your application");
                }
            }
        });

    }


    /*public void tap(View view)
    {
        String nam=name.getText().toString();
        text.setText("Hi "+nam+" I am your application");
    }*/
    public void alert()
    {
        //Building the dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Empty!");
        builder.setMessage("No string to replace");
        builder.setNeutralButton("cancel",new DialogInterface.OnClickListener(){
        @Override
        //it will create cancel button to remove the dialog box
        public void onClick(DialogInterface dialog,int which){
        dialog.dismiss();
        }
    });
        //show the dialog
        builder.show();
    }
}
