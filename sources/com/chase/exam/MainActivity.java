package com.chase.exam;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.chase.exam.R;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public DrawerLayout _drawer;
    private LinearLayout _drawer_about;
    private ImageView _drawer_imageview1;
    private ImageView _drawer_imageview2;
    private ImageView _drawer_imageview4;
    private ImageView _drawer_imageview5;
    private ImageView _drawer_imageview6;
    private ImageView _drawer_imageview8;
    private ImageView _drawer_imageview9;
    private LinearLayout _drawer_linear1;
    private LinearLayout _drawer_linear18;
    private LinearLayout _drawer_linear19;
    private LinearLayout _drawer_linear2;
    private LinearLayout _drawer_linear21;
    private LinearLayout _drawer_linear22;
    private LinearLayout _drawer_linear23;
    private LinearLayout _drawer_linear24;
    private LinearLayout _drawer_linear25;
    private LinearLayout _drawer_privacy;
    private LinearLayout _drawer_profile;
    private LinearLayout _drawer_rate;
    private LinearLayout _drawer_settings;
    private LinearLayout _drawer_share;
    private TextView _drawer_textview1;
    private TextView _drawer_textview2;
    private TextView _drawer_textview4;
    private TextView _drawer_textview5;
    private TextView _drawer_textview6;
    private TextView _drawer_textview7;
    private TextView _drawer_textview8;
    private TextView _drawer_textview9;
    private ScrollView _drawer_vscroll1;
    private Timer _timer = new Timer();
    private Toolbar _toolbar;
    /* access modifiers changed from: private */
    public ObjectAnimator a = new ObjectAnimator();
    /* access modifiers changed from: private */
    public LinearLayout account;
    /* access modifiers changed from: private */
    public LinearLayout check;
    /* access modifiers changed from: private */
    public LinearLayout create;
    private AlertDialog.Builder d;
    private AlertDialog.Builder d1;
    private String error = "";
    /* access modifiers changed from: private */
    public LinearLayout feedback;
    /* access modifiers changed from: private */
    public Intent i = new Intent();
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview5;
    private ImageView imageview6;
    private Intent in = new Intent();
    private LinearLayout linear13;
    private LinearLayout linear14;
    private LinearLayout linear3;
    private LinearLayout linear5h;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> mylist = new ArrayList<>();
    /* access modifiers changed from: private */
    public String share = "";
    /* access modifiers changed from: private */
    public SharedPreferences sp;
    private TimerTask t;
    /* access modifiers changed from: private */
    public LinearLayout take;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;
    private TextView textview6;
    /* access modifiers changed from: private */
    public LinearLayout tutorial;
    /* access modifiers changed from: private */
    public ScrollView vscroll1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
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
                MainActivity.this.onBackPressed();
            }
        });
        this._drawer = (DrawerLayout) findViewById(R.id._drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this._drawer, this._toolbar, R.string.app_name, R.string.app_name);
        this._drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id._nav_view);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear5h = (LinearLayout) findViewById(R.id.linear5h);
        this.linear13 = (LinearLayout) findViewById(R.id.linear13);
        this.linear14 = (LinearLayout) findViewById(R.id.linear14);
        this.create = (LinearLayout) findViewById(R.id.create);
        this.take = (LinearLayout) findViewById(R.id.take);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.check = (LinearLayout) findViewById(R.id.check);
        this.account = (LinearLayout) findViewById(R.id.account);
        this.imageview4 = (ImageView) findViewById(R.id.imageview4);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.imageview5 = (ImageView) findViewById(R.id.imageview5);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.feedback = (LinearLayout) findViewById(R.id.feedback);
        this.tutorial = (LinearLayout) findViewById(R.id.tutorial);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.imageview6 = (ImageView) findViewById(R.id.imageview6);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this._drawer_linear25 = (LinearLayout) linearLayout.findViewById(R.id.linear25);
        this._drawer_linear1 = (LinearLayout) linearLayout.findViewById(R.id.linear1);
        this._drawer_linear2 = (LinearLayout) linearLayout.findViewById(R.id.linear2);
        this._drawer_vscroll1 = (ScrollView) linearLayout.findViewById(R.id.vscroll1);
        this._drawer_imageview8 = (ImageView) linearLayout.findViewById(R.id.imageview8);
        this._drawer_textview7 = (TextView) linearLayout.findViewById(R.id.textview7);
        this._drawer_textview8 = (TextView) linearLayout.findViewById(R.id.textview8);
        this._drawer_linear18 = (LinearLayout) linearLayout.findViewById(R.id.linear18);
        this._drawer_profile = (LinearLayout) linearLayout.findViewById(R.id.profile);
        this._drawer_linear24 = (LinearLayout) linearLayout.findViewById(R.id.linear24);
        this._drawer_settings = (LinearLayout) linearLayout.findViewById(R.id.settings);
        this._drawer_linear19 = (LinearLayout) linearLayout.findViewById(R.id.linear19);
        this._drawer_share = (LinearLayout) linearLayout.findViewById(R.id.share);
        this._drawer_linear21 = (LinearLayout) linearLayout.findViewById(R.id.linear21);
        this._drawer_rate = (LinearLayout) linearLayout.findViewById(R.id.rate);
        this._drawer_linear22 = (LinearLayout) linearLayout.findViewById(R.id.linear22);
        this._drawer_privacy = (LinearLayout) linearLayout.findViewById(R.id.privacy);
        this._drawer_linear23 = (LinearLayout) linearLayout.findViewById(R.id.linear23);
        this._drawer_about = (LinearLayout) linearLayout.findViewById(R.id.about);
        this._drawer_imageview9 = (ImageView) linearLayout.findViewById(R.id.imageview9);
        this._drawer_textview9 = (TextView) linearLayout.findViewById(R.id.textview9);
        this._drawer_imageview1 = (ImageView) linearLayout.findViewById(R.id.imageview1);
        this._drawer_textview1 = (TextView) linearLayout.findViewById(R.id.textview1);
        this._drawer_imageview2 = (ImageView) linearLayout.findViewById(R.id.imageview2);
        this._drawer_textview2 = (TextView) linearLayout.findViewById(R.id.textview2);
        this._drawer_imageview4 = (ImageView) linearLayout.findViewById(R.id.imageview4);
        this._drawer_textview4 = (TextView) linearLayout.findViewById(R.id.textview4);
        this._drawer_imageview6 = (ImageView) linearLayout.findViewById(R.id.imageview6);
        this._drawer_textview6 = (TextView) linearLayout.findViewById(R.id.textview6);
        this._drawer_imageview5 = (ImageView) linearLayout.findViewById(R.id.imageview5);
        this._drawer_textview5 = (TextView) linearLayout.findViewById(R.id.textview5);
        this.sp = getSharedPreferences("sp", 0);
        this.d = new AlertDialog.Builder(this);
        this.d1 = new AlertDialog.Builder(this);
        this.create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.a.setTarget(MainActivity.this.create);
                MainActivity.this.a.setPropertyName("alpha");
                MainActivity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                MainActivity.this.a.setDuration(900);
                MainActivity.this.a.setRepeatMode(2);
                MainActivity.this.a.setRepeatCount(0);
                MainActivity.this.a.start();
                if (MainActivity.this.sp.getString("data", "").equals("")) {
                    MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), Builder1Activity.class);
                    MainActivity.this.startActivity(MainActivity.this.i);
                    return;
                }
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), Builder2Activity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
            }
        });
        this.take.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.a.setTarget(MainActivity.this.take);
                MainActivity.this.a.setPropertyName("alpha");
                MainActivity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                MainActivity.this.a.setDuration(900);
                MainActivity.this.a.setRepeatMode(2);
                MainActivity.this.a.setRepeatCount(0);
                MainActivity.this.a.start();
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), TakequizActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
            }
        });
        this.check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.a.setTarget(MainActivity.this.check);
                MainActivity.this.a.setPropertyName("alpha");
                MainActivity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                MainActivity.this.a.setDuration(900);
                MainActivity.this.a.setRepeatMode(2);
                MainActivity.this.a.setRepeatCount(0);
                MainActivity.this.a.start();
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), CheckActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
            }
        });
        this.account.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.a.setTarget(MainActivity.this.account);
                MainActivity.this.a.setPropertyName("alpha");
                MainActivity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                MainActivity.this.a.setDuration(900);
                MainActivity.this.a.setRepeatMode(2);
                MainActivity.this.a.setRepeatCount(0);
                MainActivity.this.a.start();
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), LoginActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
            }
        });
        this.feedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.a.setTarget(MainActivity.this.feedback);
                MainActivity.this.a.setPropertyName("alpha");
                MainActivity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                MainActivity.this.a.setDuration(900);
                MainActivity.this.a.setRepeatMode(2);
                MainActivity.this.a.setRepeatCount(0);
                MainActivity.this.a.start();
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), FeedbackActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
            }
        });
        this.tutorial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.a.setTarget(MainActivity.this.tutorial);
                MainActivity.this.a.setPropertyName("alpha");
                MainActivity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                MainActivity.this.a.setDuration(900);
                MainActivity.this.a.setRepeatMode(2);
                MainActivity.this.a.setRepeatCount(0);
                MainActivity.this.a.start();
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), TutorialActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
            }
        });
        this._drawer_linear25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this._drawer.closeDrawer((int) GravityCompat.START);
            }
        });
        this._drawer_linear2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this._drawer_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), ProfileActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
                MainActivity.this._drawer.closeDrawer((int) GravityCompat.START);
            }
        });
        this._drawer_settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), SettingsActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
                MainActivity.this._drawer.closeDrawer((int) GravityCompat.START);
            }
        });
        this._drawer_share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.vscroll1.isEnabled()) {
                    MainActivity.this.share = "HELLO WORLD";
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", MainActivity.this.share);
                    MainActivity.this.startActivity(Intent.createChooser(intent, "share using"));
                }
                MainActivity.this._drawer.closeDrawer((int) GravityCompat.START);
            }
        });
        this._drawer_rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), RateActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
                MainActivity.this._drawer.closeDrawer((int) GravityCompat.START);
            }
        });
        this._drawer_privacy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.i.setClass(MainActivity.this.getApplicationContext(), PrivacyActivity.class);
                MainActivity.this.startActivity(MainActivity.this.i);
                MainActivity.this._drawer.closeDrawer((int) GravityCompat.START);
            }
        });
        this._drawer_about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this._drawer.closeDrawer((int) GravityCompat.START);
            }
        });
    }

    private void initializeLogic() {
        this.i.setClass(getApplicationContext(), SplashActivity.class);
        startActivity(this.i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadius(30.0f);
        this.take.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable2.setCornerRadius(30.0f);
        this.create.setBackground(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable3.setCornerRadius(30.0f);
        this.feedback.setBackground(gradientDrawable3);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable4.setCornerRadius(30.0f);
        this.check.setBackground(gradientDrawable4);
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable5.setCornerRadius(30.0f);
        this.tutorial.setBackground(gradientDrawable5);
        GradientDrawable gradientDrawable6 = new GradientDrawable();
        gradientDrawable6.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable6.setCornerRadius(30.0f);
        this.account.setBackground(gradientDrawable6);
        this.take.setElevation(18.0f);
        this.create.setElevation(18.0f);
        this.feedback.setElevation(18.0f);
        this.check.setElevation(18.0f);
        this.tutorial.setElevation(18.0f);
        this.account.setElevation(18.0f);
        ((LinearLayout) findViewById(R.id._nav_view)).setBackgroundDrawable(new ColorDrawable(0));
        this.imageview1.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        this.imageview2.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        this.imageview3.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        this.imageview4.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        this.imageview6.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        this.imageview5.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        this.d.setTitle("Exit");
        this.d.setMessage("Do you want to quit the app?");
        this.d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        this.d.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.d.create().show();
    }

    private void _Dialog_setTitle(AlertDialog.Builder builder, String str) {
        try {
            builder.setCustomTitle(LayoutInflater.from(builder.getContext()).inflate(((Integer) R.layout.class.getDeclaredField(str).get((Object) null)).intValue(), (ViewGroup) null));
        } catch (Exception e) {
            showMessage(e.toString());
        }
    }

    private void _Dialog_setContent(AlertDialog.Builder builder, String str) {
        try {
            builder.setView(((Integer) R.layout.class.getDeclaredField(str).get((Object) null)).intValue());
        } catch (Exception e) {
            showMessage(e.toString());
        }
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
