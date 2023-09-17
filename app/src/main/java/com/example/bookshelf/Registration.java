package com.example.bookshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.bookshelf.databinding.ActivityRegistrationBinding;
import com.google.android.material.textfield.TextInputEditText;

public class Registration extends AppCompatActivity {

   ActivityRegistrationBinding binding;
   DBhelper databaseHelper;


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
  databaseHelper=new DBhelper(this);
  binding.btnRegister.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          String UserName=binding.EEusername.getText().toString();
          String Email=binding.EEmail.getText().toString();
          String Password=binding.EPassword.getText().toString();
          String Cpassword=binding.Ecpassword.getText().toString();
          String UserRole=binding.roleSpinner.getSelectedItem().toString();

          if(UserName.equals("") || Email.equals("")||Password.equals("") || Cpassword.equals("") || UserRole.equals("")){
              Toast.makeText(Registration.this,"Please Fill the All Fields",Toast.LENGTH_SHORT).show();
          }
          else {
              if(Password.equals(Cpassword)){
                Boolean InsertResult=databaseHelper.insertData(UserName,Email,Password,UserRole);
                if (InsertResult==true){
                    Toast.makeText(Registration.this,"Register Sucessful",Toast.LENGTH_SHORT).show();
                }
                if(UserRole.equals("Admin")){
                    Intent intentadminpanel=new Intent(getApplicationContext(), AdminPanel.class);
                    startActivity(intentadminpanel);
                } else if (UserRole.equals("Customer")) {
                    Intent intentcoustomer=new Intent(getApplicationContext(), Login.class);
                    startActivity(intentcoustomer);
                }
                else {
                    Toast.makeText(Registration.this,"Registration Faild.",Toast.LENGTH_SHORT).show();
                }

              }
              else {
                  Toast.makeText(Registration.this,"Invalid Password please enter correct password",Toast.LENGTH_SHORT).show();
              }
          }



      }

  });


      binding.loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}