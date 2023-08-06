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

public class MainActivity extends AppCompatActivity {
    EditText nameEdit,phoneEdit, emailEdit,passwordEdit,ConfirmEdit;
    Button btn;
    TextView textRegister;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    private long pressedtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdit=findViewById(R.id.nameEdit);
        phoneEdit=findViewById(R.id.phoneEdit);
        emailEdit= findViewById(R.id.emailEdit);
        passwordEdit=findViewById(R.id.PasswordEdit);
        ConfirmEdit=findViewById(R.id.ConfirmEdit);
        textRegister=findViewById(R.id.textRegister);
        btn=findViewById(R.id.btn);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= nameEdit.getText().toString().trim();
                String email=emailEdit.getText().toString().trim();
                String phone=phoneEdit.getText().toString().trim();
                String password=passwordEdit.getText().toString().trim();
                String confirm=ConfirmEdit.getText().toString().trim();
                if (name.isEmpty()){
                    nameEdit.setError("Please Enter your Name ");
                    return;

                }

                else if(phone.isEmpty() || phone.length()==9) {
                    phoneEdit.setError("Enter valid phone number");
                    return;
                }

                else if(email.isEmpty() || !email.contains("@")){
                    emailEdit.setError("Enter valid Email id");
                    return;
                }
               else if (password.isEmpty() || password.length()<8){
                    passwordEdit.setError("Enter valid password");
                    return;
                }
                else if (confirm.isEmpty() || !confirm.equals(password)){
                    ConfirmEdit.setError("Enter valid confirm password");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "Registaration successful", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        });
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,loginActivity.class);
                startActivity(intent);

            }
        });

    }
    public void onBackpressed(){
        if (pressedtime+2000>System.currentTimeMillis()){
            super.onBackPressed();
            finish();
        }
        else {
            Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT).show();
        }
        pressedtime=System.currentTimeMillis();
    }
}