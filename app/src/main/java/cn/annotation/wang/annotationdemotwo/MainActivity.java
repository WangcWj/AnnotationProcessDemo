package cn.annotation.wang.annotationdemotwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.annotation.wang.annotationlib.MyAnnotion;

@MyAnnotion()
public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn_click);
        button.setOnClickListener(new DebouncingOnClickListener() {
            @Override
            public void doClick(View v) {
                Log.e("WANG","MainActivity.doClick." );
            }
        });


    }
}
