package com.example.firstmidterm;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//我是H1810B的丁晓刚 2019-5-30 18:23:19
public class MainActivity extends AppCompatActivity {

    /**
     * 欢迎
     */
    private TextView mWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        CountDownTimer countDownTimer = new CountDownTimer(6000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mWelcome.setText("倒计时:"+(millisUntilFinished/1000)+"秒");
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(MainActivity.this,ShowActivity.class));
            }
        }.start();
    }

    private void initView() {
        mWelcome = (TextView) findViewById(R.id.welcome);
    }
}
