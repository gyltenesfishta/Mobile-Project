package com.example.project;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home_screenActivity extends AppCompatActivity {
    String email;

    com.example.project.DB DB;

    TextView headerView;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        com.example.project.Notification.createNotificationChannel(this);


        email = getIntent().getStringExtra("USER_EMAIL");
        DB = new com.example.project.DB(this);
        headerView = findViewById(R.id.header);
        loginNotification();


        String username = DB.getUsername(email);
        if (username != null) {
            headerView.setText("Hello " + username + ",");
        } else {
            headerView.setText("Hello,");  // Default if user not found
        }


    }

    private void loginNotification() {

        com.example.project.Notification.sendNotification(
                this,
                "Welcome!",
                "Thanks for logging in! Start your finding your appointment now."
        );
    }

}