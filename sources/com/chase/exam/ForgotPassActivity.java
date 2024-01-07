package com.chase.exam;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Random;

public class ForgotPassActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public ObjectAnimator a = new ObjectAnimator();
    /* access modifiers changed from: private */
    public Button button1;
    private EditText edittext3;
    /* access modifiers changed from: private */
    public Intent i = new Intent();
    private ImageView imageview1;
    private ImageView imageview2;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private TextView textview1;
    private TextView textview3;
    private TextView textview4;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.forgot_pass);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.button1 = (Button) findViewById(R.id.button1);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.edittext3 = (EditText) findViewById(R.id.edittext3);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ForgotPassActivity.this.a.setTarget(ForgotPassActivity.this.button1);
                ForgotPassActivity.this.a.setPropertyName("alpha");
                ForgotPassActivity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                ForgotPassActivity.this.a.setDuration(600);
                ForgotPassActivity.this.a.setRepeatMode(2);
                ForgotPassActivity.this.a.setRepeatCount(0);
                ForgotPassActivity.this.a.start();
            }
        });
        this.textview3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ForgotPassActivity.this.i.setClass(ForgotPassActivity.this.getApplicationContext(), CreateAccActivity.class);
                ForgotPassActivity.this.startActivity(ForgotPassActivity.this.i);
            }
        });
        this.textview4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ForgotPassActivity.this.i.setClass(ForgotPassActivity.this.getApplicationContext(), LoginActivity.class);
                ForgotPassActivity.this.startActivity(ForgotPassActivity.this.i);
            }
        });
    }

    private void initializeLogic() {
        this.linear2.setElevation(7.0f);
        this.button1.setElevation(7.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadius(30.0f);
        this.linear2.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable2.setCornerRadius(30.0f);
        this.button1.setBackground(gradientDrawable2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i2, int i3) {
        return new Random().nextInt((i3 - i2) + 1) + i2;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i2 = 0; i2 < checkedItemPositions.size(); i2++) {
            if (checkedItemPositions.valueAt(i2)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i2)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i2) {
        return TypedValue.applyDimension(1, (float) i2, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
