package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtdiem;
    ImageButton ibtnplay;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    int sodiem=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
        txtdiem.setText(sodiem+"");
        CountDownTimer countDownTimer=new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number=5;
                Random random=new Random();
                int one =random.nextInt(number);
                int two =random.nextInt(number);
                int three =random.nextInt(number);
                if(sb1.getProgress()>=sb1.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "ONEWIN", Toast.LENGTH_SHORT).show();
                    if(cb1.isChecked()){
                        sodiem+=10;
                        Toast.makeText(MainActivity.this, "ban doan chinh xac", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem-=5;
                        Toast.makeText(MainActivity.this, "ban doan sai roi", Toast.LENGTH_SHORT).show();
                    }
                    txtdiem.setText(sodiem+"");
                    enablecheckbox();
                }

                if(sb2.getProgress()>=sb2.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "TWOWIN", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        sodiem+=10;
                        Toast.makeText(MainActivity.this, "ban doan chinh xac", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem-=5;
                        Toast.makeText(MainActivity.this, "ban doan sai roi", Toast.LENGTH_SHORT).show();
                    }
                    txtdiem.setText(sodiem+"");
                    enablecheckbox();
                }
                if(sb3.getProgress()>=sb3.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "THREEWIN", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        sodiem+=10;
                        Toast.makeText(MainActivity.this, "ban doan chinh xac", Toast.LENGTH_SHORT).show();
                    }else{
                        sodiem-=5;
                        Toast.makeText(MainActivity.this, "ban doan sai roi", Toast.LENGTH_SHORT).show();
                    }
                    txtdiem.setText(sodiem+"");
                    enablecheckbox();
                }
                sb1.setProgress(sb1.getProgress()+one);
                sb2.setProgress(sb2.getProgress()+two);
                sb3.setProgress(sb3.getProgress()+three);

            }

            @Override
            public void onFinish() {

            }
        };
        ibtnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked()||cb2.isChecked()||cb3.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    ibtnplay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    disablecheckbox();
                }else {
                    Toast.makeText(MainActivity.this, "vui long dat cuoc truoc khi choi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);

                }else{
                    Toast.makeText(MainActivity.this, "vui long dat cuoc truoc khi choi!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    cb1.setChecked(false);
                    cb3.setChecked(false);
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cb1.setChecked(false);
                cb2.setChecked(false);
            }
        });
    }
    private void enablecheckbox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void disablecheckbox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3 .setEnabled(false);
    }
    private void anhxa(){
        txtdiem=(TextView) findViewById(R.id.textviewdiemso);
        ibtnplay=(ImageButton) findViewById(R.id.buttonplay);
        cb1=(CheckBox) findViewById(R.id.checkbox1);
        cb2=(CheckBox) findViewById(R.id.checkbox2);
        cb3=(CheckBox) findViewById(R.id.checkbox3);
        sb1=(SeekBar) findViewById(R.id.seekbar1);
        sb2=(SeekBar) findViewById(R.id.seekbar2);
        sb3=(SeekBar) findViewById(R.id.seekbar3);
    }
}