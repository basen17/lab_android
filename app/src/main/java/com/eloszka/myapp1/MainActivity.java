package com.eloszka.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private Button button;
    private Button button2;
    public static final String[] memeUrls = {"" +
            "https://img.besty.pl/images/401/73/4017391.jpg.fb-min.jpg",
            "https://pobierak.jeja.pl/images_screens/1/8/LNVxhDK-_thumb200.jpg",
            "https://img-9gag-fun.9cache.com/photo/ad8YgDB_460s.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("create", "Create");

        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView) findViewById((R.id.imageView));
        button = (Button) findViewById((R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int memeNo = (int) (Math.random() * 3);
                Glide.with(getApplicationContext()).load(getMeme(memeNo)).into(imageView);
                textView.setText(String.valueOf(memeNo));

            }
        });
        button2 = (Button) findViewById((R.id.newActivity));
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("resume", "Resume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("stop", "Stop");
    }

    public String getMeme(int memeNo) {
        return memeUrls[memeNo];
    }
}