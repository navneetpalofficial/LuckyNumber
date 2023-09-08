package com.example.luckeyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView textView2;
    TextView luckynumbertxt;
    Button share_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = findViewById(R.id.textView2);
        luckynumbertxt = findViewById(R.id.lucky_number_txt);
        share_number = findViewById(R.id.share_number);
        //Getting data for username
        Intent i = getIntent();
        String userName = i.getStringExtra("name");
       //Random number Generated
        int random_Num = generateRandomNumber();
        luckynumbertxt.setText(""+random_Num);
        //Share the name and LuckyNumber
        share_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               shareData(userName,random_Num);
            }
        });
    }
  public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;

    }
 public void shareData(String username,int randomNum) {
     //Implicit Intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String number = String.valueOf(randomNum);  //Convert int to string
        i.putExtra(Intent.EXTRA_SUBJECT,username + "got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is: "+number);
        startActivity(Intent.createChooser(i,"Choose a platform"));

    }
}