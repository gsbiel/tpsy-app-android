package com.example.tipsy_app.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.tipsy_app.R;

public class Stepper extends LinearLayout {

    public Stepper(Context context) {
        super(context);
        this.init(null, context);
    }

    public Stepper(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init(attrs, context);
    }

    public Stepper(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(attrs, context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Stepper(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.init(attrs, context);
    }

    private void init(@Nullable AttributeSet set, Context context){
        inflate(context,R.layout.stepper, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
    }
}
