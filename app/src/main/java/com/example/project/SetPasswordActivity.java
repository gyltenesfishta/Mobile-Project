package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class SetPasswordActivity extends AppCompatActivity {
    EditText newpass, confirmpass;
    Button changepassword;
    String email;
    com.example.project.DB DB;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        newpass = findViewById(R.id.newpassword);
        confirmpass = findViewById(R.id.confirmpassword);
        changepassword = findViewById(R.id.changepassword);
        email = getIntent().getStringExtra("Email");

        DB = new com.example.project.DB(this);




        changepassword.setOnClickListener(view->{
            String reset1 = newpass.getText().toString().trim();
            String reset2 = confirmpass.getText().toString().trim();
            if(Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{6,20}$").matcher(reset1).matches())
            {
                if(reset1.equals(reset2)){
                    DB.updateUserPassword(email, reset1);
                    Toast.makeText(this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, com.example.project.SignupActivity.class));
                }else{
                    Toast.makeText(this, "Password don't match", Toast.LENGTH_SHORT).show();
                }
            }else {
                newpass.setError("Password must contain 1 lowercase, 1 uppercase, 1 digit, 1 special character, and be 6-20 characters long.");

            }

        });




    }
}