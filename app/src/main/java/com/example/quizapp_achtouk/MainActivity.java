package com.example.quizapp_achtouk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    // Declaration
    EditText etLogin, etPassword;
    Button bLogin;
    Button bRegister;

    // Firebase authentication instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialization
        etLogin = findViewById(R.id.etlogin);
        etPassword = findViewById(R.id.etpasswd);
        bLogin = findViewById(R.id.blogin);
        bRegister = findViewById(R.id.bRegister); // Add this line

        // Firebase authentication instance
        mAuth = FirebaseAuth.getInstance();

        // Button click listener for sign-in
        bLogin.setOnClickListener(view -> {
            String email = etLogin.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (!email.isEmpty() && !password.isEmpty()) {
                signIn(email, password);
            } else {
                Toast.makeText(MainActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            }
        });


        // TextView click listener for registration
        bRegister.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, Register.class)));
    }

    // Method to sign in with email and password using Firebase Authentication
    private void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(MainActivity.this, "Authentication success.",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Quiz1.class));
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(MainActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
