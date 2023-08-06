package com.bharat.donee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText emailEdit1,passwordEdit1;
    Button btn1;
    TextView textLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEdit1=findViewById(R.id.emailEdit1);
        passwordEdit1=findViewById(R.id.PasswordEdit1);
        textLogin=findViewById(R.id.textLogin);
        btn1=findViewById(R.id.btn1);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailEdit1.getText().toString().trim();
                String password=passwordEdit1.getText().toString().trim();
                if(email.isEmpty() || !email.contains("@")){
                    emailEdit1.setError("Enter valid Email id");
                    return;
                }
                else if (password.isEmpty() || password.length()<8){
                    passwordEdit1.setError("Enter valid password");
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent=new Intent(loginActivity.this,HomeActivity.class);
                            startActivity(intent);

                            Toast.makeText(loginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(loginActivity.this, "Check Email and password", Toast.LENGTH_SHORT).show();
                        }


                    }
                });

            }
        });
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(loginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}