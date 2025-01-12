package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    Button btnCreateAccount;
    EditText editSignupEmail;
    EditText editSignupPassword;
    TextView textView4;
    Button btnLogin;
    ImageView img;
    com.example.project.DB DB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        editSignupEmail = findViewById(R.id.editSignupEmail);
        editSignupPassword= findViewById(R.id.editSignupPassword);
        textView4 = findViewById(R.id.textView4);
        btnLogin = findViewById(R.id.btnLogin);
        img = findViewById(R.id.img);

        DB = new com.example.project.DB(this);

        Animation pulse = AnimationUtils.loadAnimation(this, R.anim.pulse);
        img.startAnimation(pulse);

        btnLogin.setOnClickListener(view->{
            String email2 = editSignupEmail.getText().toString().trim();
            String password2 = editSignupPassword.getText().toString().trim();

            if (email2.isEmpty() || password2.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                return; }
            if (!DB.userExists(email2)) {
                Toast.makeText(SignupActivity.this, "Account does not exist", Toast.LENGTH_SHORT).show();
            } else if (!DB.validateUser(email2, password2)) {
                Toast.makeText(SignupActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, Home_screenActivity.class);
                intent.putExtra("USER_EMAIL", email2);
                startActivity(intent);



            }

        });

        btnCreateAccount.setOnClickListener(view->{
            startActivity(new Intent(this, SignupActivity.class));
        });
        textView4.setOnClickListener(view->{
            startActivity(new Intent(this, Forgot_PasswordActivity.class));
        });

    }



}