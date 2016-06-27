package com.chen.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.chen.myview.view.MyRegionView;
import com.chen.myview.view.MyView;

public class MainActivity extends AppCompatActivity {

    private Button myBtn;
    private MyView view;

//    private FrameLayout mainFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mainFrameLayout = (FrameLayout) findViewById(R.id.main_fl);
//
//        MyRegionView myRegionView = new MyRegionView(this);
//        mainFrameLayout.addView(myRegionView);

        myBtn = (Button) findViewById(R.id.main_btn);
        view = (MyView) findViewById(R.id.main_myview);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.reset();
            }
        });

    }
}
