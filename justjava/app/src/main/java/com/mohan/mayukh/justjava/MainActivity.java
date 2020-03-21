package com.mohan.mayukh.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{

    int orderNo=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void submitOrder(View view)
{
    EditText name=(EditText)findViewById(R.id.name);
    CheckBox sugar=(CheckBox) findViewById(R.id.sugar);
    CheckBox cream=(CheckBox)findViewById(R.id.creamtoppings);
    String nam=name.getText().toString();


    if(cream.isChecked() && sugar.isChecked())
    {
        String check2=cream.getText().toString();
        String check1=sugar.getText().toString();
        display(orderNo);
        display_price(orderNo*10,nam,check1,check2);
    }
    else if(sugar.isChecked())
    {
        String check=sugar.getText().toString();
        display(orderNo);
        display_price(orderNo*7,nam,check,".");
    }
    else if(cream.isChecked())
    {
        String check1=cream.getText().toString();
        display(orderNo);
        display_price(orderNo*7,nam,check1,".");
    }
    else
    {
        display(orderNo);
        display_price(orderNo*5,nam,"Nothing",".");
    }
}
public void increment(View view)
{
    if(orderNo<100)
    {orderNo++;
    display(orderNo);}
    else if(orderNo==100)
    {
        display(orderNo);
        Toast.makeText(this,"You cannot have more than hundred cup of coffee",Toast.LENGTH_LONG).show();
    }
}
    public void decrement(View view) {
        if(orderNo==0){
            Toast.makeText(this,"You cannot have less than zero cup of coffee",Toast.LENGTH_LONG).show();
            display(orderNo);
        }
        else {
            orderNo--;
            display(orderNo);
        }
    }
public void mail(View view)
{
    EditText name=(EditText)findViewById(R.id.name);
    CheckBox sugar=(CheckBox) findViewById(R.id.sugar);
    CheckBox cream=(CheckBox)findViewById(R.id.creamtoppings);
    String nam=name.getText().toString();
    String details;
    if(cream.isChecked() && sugar.isChecked())
    {
        String check2=cream.getText().toString();
        String check1=sugar.getText().toString();
        display(orderNo);
        details=display_price(orderNo*10,nam,check1,check2);
    }
    else if(sugar.isChecked())
    {
        String check=sugar.getText().toString();
        display(orderNo);
        details=display_price(orderNo*7,nam,check,".");
    }
    else if(cream.isChecked())
    {
        String check1=cream.getText().toString();
        display(orderNo);
        details=display_price(orderNo*7,nam,check1,".");
    }
    else
    {
        display(orderNo);
        details=display_price(orderNo*5,nam,"Nothing",".");
    }
    Intent intent=new Intent(Intent.ACTION_SENDTO);
    intent.setData(Uri.parse("mailto:"));
    intent.putExtra(Intent.EXTRA_SUBJECT,"By coffee order");
    intent.putExtra(Intent.EXTRA_TEXT,details);
    if(intent.resolveActivity(getPackageManager())!=null)
    {
        startActivity(intent);
    }
}
private void display(int number)
{
    TextView quantityTextView=(TextView)findViewById(R.id.number);
    quantityTextView.setText(""+number);
}
public String display_price(int number,String nam,String check1,String check2)
{
    String message;
    TextView priceTextView=(TextView)findViewById(R.id.price);
    message="Hello "+nam+" you have ordered with\n $ "+number+" for "+orderNo+" cups of coffee\nWith specifications:\n"+check1+"\t"+check2+"\nPay up please!!\nTHANK YOU";//NumberFormat.getCurrencyInstance().format(number)
    priceTextView.setText(message);
    return message;
}
}
