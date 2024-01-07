package com.chase.exam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Random;

public class QuizModeActivity extends AppCompatActivity {
    private Toolbar _toolbar;
    private Button button1;
    private Button button2;
    /* access modifiers changed from: private */
    public Intent i = new Intent();
    private LinearLayout linear1;
    /* access modifiers changed from: private */
    public SharedPreferences sp;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quiz_mode);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this._toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(this._toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this._toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizModeActivity.this.onBackPressed();
            }
        });
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.button1 = (Button) findViewById(R.id.button1);
        this.button2 = (Button) findViewById(R.id.button2);
        this.sp = getSharedPreferences("sp", 0);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizModeActivity.this.i.setClass(QuizModeActivity.this.getApplicationContext(), QuizActivity.class);
                QuizModeActivity.this.startActivity(QuizModeActivity.this.i);
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizModeActivity.this.sp.edit().remove("quiz_data").commit();
                QuizModeActivity.this.sp.edit().remove("key").commit();
                QuizModeActivity.this.finish();
            }
        });
    }

    private void initializeLogic() {
        setTitle("Quiz mode");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2196F3"));
        gradientDrawable.setCornerRadius(10.0f);
        this.button1.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#2196F3"));
        gradientDrawable2.setCornerRadius(10.0f);
        this.button2.setBackground(gradientDrawable2);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onStart() {
        super.onStart();
        if (this.sp.getString("key", "").equals("")) {
            this.button2.setVisibility(8);
            return;
        }
        this.button1.setVisibility(8);
        this.button2.setVisibility(0);
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