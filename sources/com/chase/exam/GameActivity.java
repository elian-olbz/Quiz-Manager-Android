package com.chase.exam;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private Timer _timer = new Timer();
    private Toolbar _toolbar;
    /* access modifiers changed from: private */
    public String answer = "";
    private Button button1;
    /* access modifiers changed from: private */
    public CheckBox checkbox1;
    /* access modifiers changed from: private */
    public CheckBox checkbox2;
    /* access modifiers changed from: private */
    public CheckBox checkbox3;
    /* access modifiers changed from: private */
    public CheckBox checkbox4;
    private ArrayList<HashMap<String, Object>> game_lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<String, Object> game_map = new HashMap<>();
    private ImageView imageview1;
    private String img1 = "";
    private String json = "";
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    /* access modifiers changed from: private */
    public double n = 0.0d;
    private double q = 0.0d;
    /* access modifiers changed from: private */
    public double score = 0.0d;
    /* access modifiers changed from: private */
    public double size = 0.0d;
    /* access modifiers changed from: private */
    public SharedPreferences sp;
    private TimerTask t;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    /* access modifiers changed from: private */
    public TextView textview4;
    /* access modifiers changed from: private */
    public TextView textview5;
    /* access modifiers changed from: private */
    public double time = 0.0d;
    private ScrollView vscroll1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.game);
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
                GameActivity.this.onBackPressed();
            }
        });
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.button1 = (Button) findViewById(R.id.button1);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        this.checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        this.checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        this.checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
        this.sp = getSharedPreferences("sp", 0);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GameActivity.this.answer.equals("")) {
                    SketchwareUtil.showMessage(GameActivity.this.getApplicationContext(), "No answer selected");
                    return;
                }
                if (GameActivity.this.game_map.get("c_a").toString().equals(GameActivity.this.answer)) {
                    SketchwareUtil.showMessage(GameActivity.this.getApplicationContext(), "Correct answer");
                    GameActivity gameActivity = GameActivity.this;
                    gameActivity.score = gameActivity.score + 1.0d;
                } else {
                    SketchwareUtil.showMessage(GameActivity.this.getApplicationContext(), "Wrong answer");
                }
                GameActivity.this.textview4.setText(String.valueOf((long) GameActivity.this.score).concat("/".concat(String.valueOf((long) GameActivity.this.n))));
                if (GameActivity.this.n == GameActivity.this.size) {
                    GameActivity.this.sp.edit().putString("score", GameActivity.this.textview4.getText().toString()).commit();
                    GameActivity.this.finish();
                    return;
                }
                GameActivity.this.answer = "";
                GameActivity.this._falseCheckboxes();
                GameActivity.this._pickQuestion();
            }
        });
        this.checkbox1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GameActivity.this._select(GameActivity.this.checkbox1, "a");
            }
        });
        this.checkbox2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GameActivity.this._select(GameActivity.this.checkbox2, "b");
            }
        });
        this.checkbox3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GameActivity.this._select(GameActivity.this.checkbox3, "c");
            }
        });
        this.checkbox4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GameActivity.this._select(GameActivity.this.checkbox4, "d");
            }
        });
    }

    private void initializeLogic() {
        this.json = this.sp.getString("quiz_data", "");
        this.game_lmap = (ArrayList) new Gson().fromJson(this.json, new TypeToken<ArrayList<HashMap<String, Object>>>() {
        }.getType());
        this.n = 0.0d;
        this.q = 0.0d;
        this.score = 0.0d;
        this.size = (double) this.game_lmap.size();
        _pickQuestion();
        this.time = 5.0d;
        this.t = new TimerTask() {
            public void run() {
                GameActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        GameActivity access$0 = GameActivity.this;
                        access$0.time = access$0.time - 1.0d;
                        GameActivity.this.textview5.setText(String.valueOf((long) GameActivity.this.time));
                        if (GameActivity.this.time == 0.0d) {
                            GameActivity.this.sp.edit().putString("score", GameActivity.this.textview4.getText().toString()).commit();
                            GameActivity.this.finish();
                        }
                    }
                });
            }
        };
        this._timer.scheduleAtFixedRate(this.t, 1000, 60000);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2196F3"));
        gradientDrawable.setCornerRadius(10.0f);
        this.button1.setBackground(gradientDrawable);
        this.button1.setElevation(8.0f);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: private */
    public void _pickQuestion() {
        this.n += 1.0d;
        this.q = (double) SketchwareUtil.getRandom(0, this.game_lmap.size() - 1);
        this.game_map = this.game_lmap.get((int) this.q);
        this.textview1.setText(String.valueOf((long) this.n));
        this.textview2.setText(this.game_map.get("ques").toString());
        this.checkbox1.setText(this.game_map.get("a").toString());
        this.checkbox2.setText(this.game_map.get("b").toString());
        this.checkbox3.setText(this.game_map.get("c").toString());
        this.checkbox4.setText(this.game_map.get("d").toString());
        this.img1 = this.game_map.get("img1").toString();
        if (this.img1.equals("none")) {
            this.linear5.setVisibility(8);
        } else {
            this.linear5.setVisibility(0);
            byte[] decode = Base64.decode(this.img1, 0);
            this.imageview1.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        }
        this.game_lmap.remove((int) this.q);
    }

    /* access modifiers changed from: private */
    public void _select(CheckBox checkBox, String str) {
        if (checkBox.isChecked()) {
            this.answer = str;
            _falseCheckboxes();
            checkBox.setChecked(true);
            return;
        }
        this.answer = "";
    }

    /* access modifiers changed from: private */
    public void _falseCheckboxes() {
        this.checkbox1.setChecked(false);
        this.checkbox2.setChecked(false);
        this.checkbox3.setChecked(false);
        this.checkbox4.setChecked(false);
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
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
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
