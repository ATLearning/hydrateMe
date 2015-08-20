package com.example.adan.helloagain;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    EditText totalAmount;
    double converstionAmount;
    double t;

    //Only want AlertBox Event to happen once.
    int popupboxCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        totalAmount = (EditText) findViewById(R.id.totalAmount);
    }


    //This method will calculate how much an individual should drink based on their weight
    //The amount will be printed to num2 EditText
    public void calculateWater(View v) {

        double input1 = Double.parseDouble(num1.getText().toString());

        //Figures out how many ounces of water they should drink
        double finalAnswer = input1 / 2;

        //Ounces converted into ML
        converstionAmount = finalAnswer * 28;

        //Result printed
        num2.setText(converstionAmount + "");

    }


    //onClickListener for the 250ml button
    //Each time button is pressed the amount the user has drank is increase by 250 (Recorded by totalAmount textView)
    //If user drinks more than or equal to their estimated daily water needs based off weight popup msg displayed.
    public void increaseSmall(View v){

        t = Double.parseDouble(totalAmount.getText().toString());
        totalAmount.setText(t + 250 + "");

        Double moreCalculation = Double.parseDouble(totalAmount.getText().toString());
        if(moreCalculation >= converstionAmount && popupboxCount < 1) {
            String msg = "You have reached your daily water needs!";
            showAlert(msg);
            ++popupboxCount;
        }

    }


    //onClickLIstener for the 500ml button
    //Each time button is pressed the amount the user has drank is increase by 500 (Recorded by totalAmount textView)
    //If user drinks more than or equal to their estimated daily water needs based off weight popup msg displayed.
    public void increaseLarge(View v){

        t = Double.parseDouble(totalAmount.getText().toString());
        totalAmount.setText(t + 500 + "");

        Double moreCalculation = Double.parseDouble(totalAmount.getText().toString());
        if(moreCalculation >= converstionAmount && popupboxCount < 1) {
            String msg = "You have reached your daily water needs!";
            showAlert(msg);
            ++popupboxCount;
        }
    }



    //This method creates the popup box
    //The title and, layout of it can be edited from here.
    public void showAlert(String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Congratz")
                .setMessage(message)
                .setNeutralButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }



}





