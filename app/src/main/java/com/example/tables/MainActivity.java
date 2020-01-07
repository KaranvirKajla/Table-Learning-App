package com.example.tables;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
TextView entryText;
    public static int tableMax=20;
   public static int tableLength=10;
    SeekBar seekBar;
    ListView listView;

    public void settings(View view){
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }



    @Override
    protected void onResume() {
        super.onResume();
        seekBar= findViewById(R.id.seekBar);
        seekBar.setMax(tableMax);
        //seekBar.setMin(1);

        listView = findViewById(R.id.listView);
//         ArrayList<String> arrayList = new ArrayList<>();
      /*  Intent intent = getIntent();
            String x= intent.getStringExtra(Settings.A);
            String y = intent.getStringExtra(Settings.B);*/

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ArrayList<String> arrayList = new ArrayList<>();
                for(int i=0;i<=tableLength;i++){
                    String text = progress + " X "+i+" = "+progress*i;
                    arrayList.add(text);
                }
                ArrayAdapter<String> arrayAdapter =new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                entryText.setVisibility(View.GONE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entryText = findViewById(R.id.entryText);
        String str = "Welcome to the table learning app.You can see table of any number by changing the settings. Seek the scrollbar to get the tables.";
        entryText.setText(str);
        mediaPlayer= MediaPlayer.create(this,R.raw.speech);
        mediaPlayer.start();

    }

}
