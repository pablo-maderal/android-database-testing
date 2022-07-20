package com.pobs.database_testing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    private Button updatesBtn, demoBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        //TODO Features btn will need to lead to some type of activity with recyclerview in later versions
        // TODO  Change hardcoded string values to resource values

        initializeViews();
    }


    private void initializeViews() {
        updatesBtn = findViewById(R.id.activity_mainmenu_updates_btn);
        demoBtn = findViewById(R.id.activity_mainmenu_demos_btn);

        updatesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenu.this, "Feature coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        demoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, PollDemo.class);
                startActivity(intent);
            }
        });

    }
}
