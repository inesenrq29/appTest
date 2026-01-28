package com.ienrique.appTest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextView textCenter;
    ImageView imageCenter;
    Button btnNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initializeViews();

        int a = 5;


        textCenter.setText(R.string.hello_world);
        btnNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navigationIntent = new Intent(MainActivity.this, NavigationActivity.class);
                Client[] clients = {new Client(1, "client1"), new Client(2, "client2")};
                navigationIntent.putExtra("dataClient", clients);
                startActivity(navigationIntent);
            }
        });
    }

    public void initializeViews() {
        textCenter = findViewById(R.id.text_center);
        imageCenter = findViewById(R.id.main_image);
        btnNavigation = findViewById(R.id.btn_nav);


    }

    public void buttonClick(View view) {
        textCenter.setText("Bouton cliqué !");
        Picasso.get().load("https://assets.nationalbankopen.com/production/news/Carlos-Alcaraz-2025-French-Open-Martin-Sidorjak-2.jpg").into(imageCenter);
    }
}