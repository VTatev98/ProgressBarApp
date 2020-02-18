package com.example.contact;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.ContentHandler;
import java.net.URLConnection;

public class BaseActivity extends AppCompatActivity {
    ConstraintLayout cLayout;
    ProgressBar progressBar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        progressBar = findViewById(R.id.progressBar);

    }
    void show(){
        cLayout = new ConstraintLayout(this);
        ConstraintLayout.LayoutParams linLayoutParam = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        View view = getCurrentFocus();
        ViewParent parent = view.getParent();
        parent.clearChildFocus(view);
        cLayout.addView(view,0);
        cLayout.addView(progressBar,1);
        setContentView(cLayout, linLayoutParam);
    }
    void hide(){
        cLayout.removeView(progressBar);
    }

}
