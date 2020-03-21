package com.mohan.mayukh.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer1,mediaPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer1=MediaPlayer.create(MainActivity.this,R.raw.the_chainsmokers);
        mediaPlayer2=MediaPlayer.create(MainActivity.this,R.raw.number_one);
        Button play=(Button)findViewById(R.id.play);
        Button pause=(Button)findViewById(R.id.pause);
        Button play2=(Button)findViewById(R.id.play2);
        Button pause2=(Button)findViewById(R.id.pause2);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mediaPlayer1.start();
                mediaPlayer1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this,"I've Completed",Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(MainActivity.this,"play",Toast.LENGTH_LONG).show();
            }
        });
        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mediaPlayer1.pause();
                //Toast.makeText(MainActivity.this,"pause",Toast.LENGTH_LONG).show();
            }
        });
        play2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mediaPlayer2.start();
                mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(MainActivity.this,"I've Completed",Toast.LENGTH_SHORT).show();
                    }
                });
                //Toast.makeText(MainActivity.this,"play",Toast.LENGTH_LONG).show();
            }
        });
        pause2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                mediaPlayer2.pause();
                //Toast.makeText(MainActivity.this,"pause",Toast.LENGTH_LONG).show();
            }
        });
    }
}
