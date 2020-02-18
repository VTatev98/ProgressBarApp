package com.example.contact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.constraintlayout.widget.ConstraintLayout;

public class LoaderView extends ConstraintLayout {
    ProgressBar progressBar  =(ProgressBar)findViewById(R.id.progressBar);;
    private Context context;
    public LoaderView(Context context) {
        this(context, null);
    }
    public LoaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View v = LayoutInflater.from(context).inflate(R.layout.loader_view, null, false);
        addView(v);
    }
    public void show(){
        progressBar.setVisibility(View.VISIBLE);
    }
    public void hide(){
        progressBar.setVisibility(View.INVISIBLE);
    }

}
