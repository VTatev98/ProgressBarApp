package com.example.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.contact.AddContactActivity.CONTACT_NAME;
import static com.example.contact.AddContactActivity.CONTACT_NUMBER;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final int REQUEST_ADD_CONTACT = 1;
    private ImageView ivAdd;
    private LinearLayout llContacts;
    private List<Contact> contactList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivAdd = findViewById(R.id.iv_add);
        llContacts = findViewById(R.id.ll_contacts);
        ivAdd.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_add:
                goToAddContactActivity();
                break;
            default:
                break;
        }
    }
    private void goToAddContactActivity() {
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivityForResult(intent, REQUEST_ADD_CONTACT);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_ADD_CONTACT:
                    String name = data.getStringExtra(CONTACT_NAME);
                    String number = data.getStringExtra(CONTACT_NUMBER);
                    drawContactView(name, number);
                    break;
            }
        }
    }
    private void drawContactView(String name, String number) {
        //...
        Contact contact = new Contact(name, number);
        contactList.add(contact);
        ContactView contactView = new ContactView(this);
        contactView.setName(name);
        contactView.setNumber(number);
        llContacts.addView(contactView);
    }
}
