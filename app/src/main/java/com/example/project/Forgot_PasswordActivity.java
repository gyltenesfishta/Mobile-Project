package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forgot_PasswordActivity extends AppCompatActivity {
    EditText emailInput;
    Button resetPasswordButton;


    com.example.project.DB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        DB = new com.example.project.DB(this);

        emailInput = findViewById(R.id.email);
        resetPasswordButton = findViewById(R.id.reset_password);

        resetPasswordButton.setOnClickListener(v -> {

            String email = emailInput.getText().toString().trim();

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter a valid email.", Toast.LENGTH_SHORT).show();
                return;
            }
            if(DB.userExists(email)){
                Intent intent = new Intent(this, com.example.project.Verification_screenActivity.class);
                intent.putExtra("From_forgotPassword", true);
                intent.putExtra("USER_EMAIL", email);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Please check your credentials again!", Toast.LENGTH_SHORT).show();
            }



        });
    }
}