package com.example.contact;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

public class ProgressBarHandler {
    private ProgressBar mProgressBar;
    private Context mContext;
    private View _baseView;
    private View _hideView;
    public ProgressBarHandler(Context context,View baseView, View hideView) {
        mContext = context;
        _baseView = baseView;
        _hideView = hideView;

        ViewGroup layout = (ViewGroup) _baseView;//((Activity) context).findViewById(android.R.id.content).getRootView();

        mProgressBar = new ProgressBar(context, null, android.R.attr.progressBarStyleLarge);
        mProgressBar.setIndeterminate(true);

        ConstraintLayout.LayoutParams params = new
                ConstraintLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        ConstraintLayout rl = new ConstraintLayout(context);

       // rl.setGravity(Gravity.CENTER);
        rl.addView(mProgressBar);

        layout.addView(rl, params);

        hide();
    }

    public void show() {
        mProgressBar.setVisibility(View.VISIBLE);
        _hideView.setVisibility(View.INVISIBLE);
    }

    public void hide() {
        mProgressBar.setVisibility(View.INVISIBLE);
        _hideView.setVisibility(View.VISIBLE);
    }
}
