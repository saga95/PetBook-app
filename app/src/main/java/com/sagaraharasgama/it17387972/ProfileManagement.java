package com.sagaraharasgama.it17387972;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sagaraharasgama.it17387972.Database.DBHelper;

public class ProfileManagement extends AppCompatActivity {

    Button btnRegister = findViewById(R.id.btn_Register);
    DBHelper dbHelper;
    EditText name = findViewById(R.id.et_Name);
    EditText dob = findViewById(R.id.et_DOB);
    EditText password = findViewById(R.id.et_Password);
    RadioGroup gender = findViewById(R.id.rg_Gender);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        addInfo();
    }

    private void addInfo() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean inserted = dbHelper.addInfo(name.getText().toString(), dob.getText().toString(), gender.getTag().toString(), password.getText().toString());
                if (inserted == true) {
                    Toast.makeText(ProfileManagement.this, "User Added Successfully!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ProfileManagement.this, "Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
