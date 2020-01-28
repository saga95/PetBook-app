package com.sagaraharasgama.it17387972;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sagaraharasgama.it17387972.Database.DBHelper;

public class EditProfile extends AppCompatActivity {

    Button search = findViewById(R.id.btn_Search);
    Button edit = findViewById(R.id.btn_Edit);
    DBHelper dbHelper;

    EditText name = findViewById(R.id.et_Name);
    EditText dob = findViewById(R.id.et_DOB);
    EditText password = findViewById(R.id.et_Password);
    String gender;
    RadioButton famale = findViewById(R.id.rb_Female);
    RadioButton male = findViewById(R.id.rb_Male);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        readAllInfo();
        updateInfo();
    }

    private void updateInfo() {
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.addInfo(name.getText().toString(), gender, dob.getText().toString(), password.getText().toString());
                Toast.makeText(EditProfile.this, "Information Update Successfull", Toast.LENGTH_LONG ).show();
            }
        });
    }

    private void readAllInfo() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor data = dbHelper.readAllInfo(name.getText().toString());

                if (data.getCount() == 0){
                    showMessage("Error","Nothing Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (data.moveToNext()){
                    buffer.append("ID : " + data.getString(0) + "\n");
                    buffer.append("Username: " + data.getString(1)+ "\n" );
                    buffer.append("Date of Birth : " + data.getString(2) + "\n");
                    buffer.append("Gender : " + data.getString(3) + "\n");
                }

                showMessage("User Details", buffer.toString());
            }

            private void showMessage(String title, String message) {
                AlertDialog.Builder builder= new AlertDialog.Builder(getBaseContext());
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();
            }


            public void onRadioButtonClicked(View view){
                boolean checked = ((RadioButton) view).isChecked();

                switch (view.getId()){
                    case (R.id.rb_Male):
                        if (checked)
                            gender = "Male";
                        break;

                    case R.id.rb_Female:
                        if (checked)
                            gender = "Female";
                        break;
                }
            }



        });
    }
}
