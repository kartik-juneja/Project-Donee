package com.bharat.donee;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class raise extends Fragment {
    TextView profile;
    RadioButton radioButton1,radioButton2;
    Button button;
    Button btn1;
    EditText nameEdit1,phoneEdit1,emailEdit1,passwordEdit1;
    RadioButton genderradioButton;
    RadioGroup radioGroup;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.raise, container, false);
        profile=view.findViewById(R.id.profile);
        radioButton1=view.findViewById(R.id.radioButton1);
        radioButton2=view.findViewById(R.id.radioButton2);
        btn1=view.findViewById(R.id.btn1);
        passwordEdit1=view.findViewById(R.id.PasswordEdit1);
        phoneEdit1=view.findViewById(R.id.phoneEdit1);
        emailEdit1=view.findViewById(R.id.emailEdit1);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm=getActivity().getSupportFragmentManager();
                fm.popBackStack("Home",FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });

            return view;

    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch(view.getId()) {
            case R.id.radioButton1:
                if (checked)

                    break;
            case R.id.radioButton2:
                if (checked)
                    break;
        }
    }
}