package com.mohan.mayukh.pratice_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int number=0;
    int number1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void tpt1(View view)
    {
        TextView pt=(TextView)findViewById(R.id.num1);
        number+=3;
        pt.setText(""+number);
    }
    public void wpt1(View view)
    {
        TextView pt=(TextView)findViewById(R.id.num1);
        number+=2;
        pt.setText(""+number);
    }
    public void fpt1(View view)
    {
        TextView pt=(TextView)findViewById(R.id.num1);
        number++;
        pt.setText(""+number);
    }
    public void tpt2(View view)
    {
        TextView pt=(TextView)findViewById(R.id.num2);
        number1+=3;
        pt.setText(""+number1);
    }
    public void wpt2(View view)
    {
        TextView pt=(TextView)findViewById(R.id.num2);
        number1+=2;
        pt.setText(""+number1);
    }
    public void fpt2(View view)
    {
        TextView pt=(TextView)findViewById(R.id.num2);
        number1++;
        pt.setText(""+number1);
    }
    public void reset(View view)
    {
        TextView pt1=(TextView)findViewById(R.id.num1);
        TextView pt2=(TextView)findViewById(R.id.num2);
        number=0;
        number1=0;
        pt1.setText(""+number);
        pt2.setText(""+number1);
    }
}
