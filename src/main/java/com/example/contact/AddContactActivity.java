package com.example.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class AddContactActivity extends BaseActivity implements View.OnClickListener {
    public static final String CONTACT_NAME = "contact_name";
    public static final String CONTACT_NUMBER = "contact_number";
    private EditText etName;
    private EditText etNumber;
    private Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        btnAdd = findViewById(R.id.btn_add);
        etName = findViewById(R.id.et_name);
        etNumber = findViewById(R.id.et_number);
        btnAdd.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                show();
                String name = etName.getText().toString();
                String number = etNumber.getText().toString();
                if (name.isEmpty() || number.isEmpty()) {
                    Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();

                    return;
                }
                Intent intent = getIntent();
                intent.putExtra(CONTACT_NAME, name);
                intent.putExtra(CONTACT_NUMBER, number);
                /*startActivityForResult*/
                setResult(RESULT_OK, intent);
                finish();
                hide();
                break;
            default:
                break;
        }
    }
}

