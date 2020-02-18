package com.example.contact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import static android.content.Intent.ACTION_CALL;

public class ContactView extends RelativeLayout implements View.OnClickListener {
    /*view*/
    private ConstraintLayout root;
    private TextView tvName;
    private TextView tvNumber;
    /*global variable*/
    private String name = "";
    private String number = "";
    private Context context;
    public ContactView(Context context) {
        this(context, null);
    }
    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View v = LayoutInflater.from(context).inflate(R.layout.view_contact, null, false);
        tvName = v.findViewById(R.id.tv_name);
        tvNumber = v.findViewById(R.id.tv_number);
        root = v.findViewById(R.id.root);
        root.setOnClickListener(this);
        if (attrs != null) {
            @SuppressLint({"ResourceType", "Recycle"})
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ContactView);
            if (typedArray.hasValue(R.styleable.ContactView_name))
                name = typedArray.getString(R.styleable.ContactView_name);
            if (typedArray.hasValue(R.styleable.ContactView_number))
                number = typedArray.getString(R.styleable.ContactView_number);
        }
        setName(name);
        setNumber(number);
        addView(v);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        tvName.setText(name);
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
        tvNumber.setText(number);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.root:
                makeCall();
                break;
        }
    }
    private void makeCall() {
        Intent intent = new Intent(ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        context.startActivity(intent);
    }
}
