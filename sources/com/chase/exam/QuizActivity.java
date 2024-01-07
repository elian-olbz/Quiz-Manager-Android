package com.chase.exam;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class QuizActivity extends AppCompatActivity {
    private Timer _timer = new Timer();
    /* access modifiers changed from: private */
    public ObjectAnimator a = new ObjectAnimator();
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> ans_lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<String, Object> ans_map = new HashMap<>();
    /* access modifiers changed from: private */
    public String answer = "";
    /* access modifiers changed from: private */
    public Button button1;
    /* access modifiers changed from: private */
    public TextView c_a;
    /* access modifiers changed from: private */
    public CheckBox checkbox1;
    /* access modifiers changed from: private */
    public CheckBox checkbox2;
    /* access modifiers changed from: private */
    public CheckBox checkbox3;
    /* access modifiers changed from: private */
    public CheckBox checkbox4;
    private LinearLayout child1;
    /* access modifiers changed from: private */
    public LinearLayout child2;
    /* access modifiers changed from: private */
    public double click = 0.0d;
    /* access modifiers changed from: private */
    public double click2 = 0.0d;
    private LinearLayout container;
    private String destination = "";
    /* access modifiers changed from: private */
    public String f_x = "";
    /* access modifiers changed from: private */
    public String f_y = "";
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> final_lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<String, Object> final_map = new HashMap<>();
    /* access modifiers changed from: private */
    public TextView fname;
    /* access modifiers changed from: private */
    public AlertDialog.Builder ifDone;
    /* access modifiers changed from: private */
    public String imageString = "";
    /* access modifiers changed from: private */
    public ImageView imageview1;
    private ImageView imageview3;
    /* access modifiers changed from: private */
    public ImageView imageview6;
    /* access modifiers changed from: private */
    public ImageView imageview7;
    /* access modifiers changed from: private */
    public String img1 = "";
    private String json = "";
    /* access modifiers changed from: private */
    public double l = 0.0d;
    private LinearLayout linear1;
    private LinearLayout linear3;
    private LinearLayout linear5;
    private LinearLayout linear50;
    private LinearLayout linear51;
    /* access modifiers changed from: private */
    public LinearLayout linear52;
    private LinearLayout linear6;
    /* access modifiers changed from: private */
    public ListView listview1;
    /* access modifiers changed from: private */
    public ListView listview2;
    private ArrayList<HashMap<String, Object>> lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public double loc2 = 0.0d;
    /* access modifiers changed from: private */
    public double location = 0.0d;
    /* access modifiers changed from: private */
    public double n = 0.0d;
    private double q = 0.0d;
    /* access modifiers changed from: private */
    public TextView ques;
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> quiz_lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<String, Object> quiz_map = new HashMap<>();
    /* access modifiers changed from: private */
    public HashMap<String, Object> s_map = new HashMap<>();
    private double score = 0.0d;
    /* access modifiers changed from: private */
    public double size = 0.0d;
    private String source = "";
    /* access modifiers changed from: private */
    public SharedPreferences sp;
    private AlertDialog.Builder submit;
    private Button submit_butn;
    private TimerTask t;
    private TextView textview20;
    /* access modifiers changed from: private */
    public TextView textview21;
    private TextView textview8;
    private TextView textview9;
    /* access modifiers changed from: private */
    public double time = 0.0d;
    private ScrollView vscroll1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.quiz);
        initialize(bundle);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
            return;
        }
        initializeLogic();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle bundle) {
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.container = (LinearLayout) findViewById(R.id.container);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview20 = (TextView) findViewById(R.id.textview20);
        this.fname = (TextView) findViewById(R.id.fname);
        this.linear50 = (LinearLayout) findViewById(R.id.linear50);
        this.imageview6 = (ImageView) findViewById(R.id.imageview6);
        this.child1 = (LinearLayout) findViewById(R.id.child1);
        this.child2 = (LinearLayout) findViewById(R.id.child2);
        this.linear52 = (LinearLayout) findViewById(R.id.linear52);
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.button1 = (Button) findViewById(R.id.button1);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        this.checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        this.checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        this.checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
        this.c_a = (TextView) findViewById(R.id.c_a);
        this.textview21 = (TextView) findViewById(R.id.textview21);
        this.ques = (TextView) findViewById(R.id.ques);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.linear51 = (LinearLayout) findViewById(R.id.linear51);
        this.submit_butn = (Button) findViewById(R.id.submit_butn);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.imageview7 = (ImageView) findViewById(R.id.imageview7);
        this.listview1 = (ListView) findViewById(R.id.listview1);
        this.listview2 = (ListView) findViewById(R.id.listview2);
        this.sp = getSharedPreferences("sp", 0);
        this.submit = new AlertDialog.Builder(this);
        this.ifDone = new AlertDialog.Builder(this);
        this.imageview6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizActivity quizActivity = QuizActivity.this;
                quizActivity.click = quizActivity.click + 1.0d;
                if (QuizActivity.this.click == 1.0d) {
                    QuizActivity.this.imageview6.setImageResource(R.drawable.ic_done_white);
                    QuizActivity.this.a.setTarget(QuizActivity.this.child2);
                    QuizActivity.this.a.setPropertyName("translationX");
                    QuizActivity.this.a.setFloatValues(new float[]{SketchwareUtil.getDip(QuizActivity.this.getApplicationContext(), -321) - ((float) SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext())), (float) (0 - SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext()))});
                    QuizActivity.this.a.setDuration(210);
                    QuizActivity.this.a.setRepeatMode(2);
                    QuizActivity.this.a.setRepeatCount(0);
                    QuizActivity.this.a.setInterpolator(new LinearInterpolator());
                    QuizActivity.this.a.start();
                } else if (QuizActivity.this.click == 2.0d) {
                    QuizActivity.this.imageview6.setImageResource(R.drawable.ic_format_list_numbered_white);
                    QuizActivity.this.a.setTarget(QuizActivity.this.child2);
                    QuizActivity.this.a.setFloatValues(new float[]{(float) (0 - SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext())), SketchwareUtil.getDip(QuizActivity.this.getApplicationContext(), -321) - ((float) SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext()))});
                    QuizActivity.this.a.start();
                    QuizActivity.this.click = 0.0d;
                }
            }
        });
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!QuizActivity.this.answer.equals("")) {
                    if (QuizActivity.this.sp.getString("isClicked", "").equals("no")) {
                        QuizActivity.this.quiz_lmap.remove(0);
                        if (QuizActivity.this.n < QuizActivity.this.size) {
                            QuizActivity.this._map_put();
                            QuizActivity.this._falseCheckboxes();
                            QuizActivity.this._pickQuestion();
                        } else {
                            if (QuizActivity.this.n == QuizActivity.this.size) {
                                QuizActivity.this._map_put();
                                QuizActivity.this._falseCheckboxes();
                            }
                            QuizActivity.this.button1.setEnabled(false);
                            QuizActivity.this.sp.edit().putString("key", "ok").commit();
                        }
                        ((BaseAdapter) QuizActivity.this.listview1.getAdapter()).notifyDataSetChanged();
                        ((BaseAdapter) QuizActivity.this.listview2.getAdapter()).notifyDataSetChanged();
                    } else if (QuizActivity.this.sp.getString("isClicked", "").equals("yes")) {
                        if (QuizActivity.this.sp.getString("fromList", "").equals("one")) {
                            QuizActivity.this.quiz_lmap.remove((int) QuizActivity.this.location);
                            if (QuizActivity.this.n < QuizActivity.this.size) {
                                QuizActivity.this._map_put();
                                QuizActivity.this._falseCheckboxes();
                                QuizActivity.this._pickQuestion();
                            } else {
                                if (QuizActivity.this.n == QuizActivity.this.size) {
                                    QuizActivity.this._map_put();
                                    QuizActivity.this._falseCheckboxes();
                                }
                                QuizActivity.this.button1.setEnabled(false);
                                QuizActivity.this.sp.edit().putString("key", "ok").commit();
                            }
                            ((BaseAdapter) QuizActivity.this.listview1.getAdapter()).notifyDataSetChanged();
                            ((BaseAdapter) QuizActivity.this.listview2.getAdapter()).notifyDataSetChanged();
                        } else if (QuizActivity.this.sp.getString("fromList", "").equals("two")) {
                            QuizActivity.this.ans_lmap.remove((int) QuizActivity.this.loc2);
                            if (QuizActivity.this.n < QuizActivity.this.size) {
                                QuizActivity.this._map_put();
                                QuizActivity.this._falseCheckboxes();
                                QuizActivity.this._pickQuestion();
                            } else {
                                if (QuizActivity.this.n == QuizActivity.this.size) {
                                    QuizActivity.this._map_put();
                                    QuizActivity.this._falseCheckboxes();
                                }
                                QuizActivity.this.button1.setEnabled(false);
                                QuizActivity.this.sp.edit().putString("key", "ok").commit();
                            }
                            ((BaseAdapter) QuizActivity.this.listview1.getAdapter()).notifyDataSetChanged();
                            ((BaseAdapter) QuizActivity.this.listview2.getAdapter()).notifyDataSetChanged();
                        }
                    }
                    QuizActivity.this.sp.edit().putString("isClicked", "no").commit();
                    return;
                }
                SketchwareUtil.showMessage(QuizActivity.this.getApplicationContext(), "No answer selected");
            }
        });
        this.checkbox1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizActivity.this._select(QuizActivity.this.checkbox1, "a");
            }
        });
        this.checkbox2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizActivity.this._select(QuizActivity.this.checkbox2, "b");
            }
        });
        this.checkbox3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizActivity.this._select(QuizActivity.this.checkbox3, "c");
            }
        });
        this.checkbox4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizActivity.this._select(QuizActivity.this.checkbox4, "d");
            }
        });
        this.submit_butn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (QuizActivity.this.n != QuizActivity.this.size) {
                    QuizActivity.this.ifDone.setTitle("Quiz not yet done");
                    QuizActivity.this.ifDone.setMessage("Proceed to submit now?");
                    QuizActivity.this.ifDone.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            QuizActivity.this._save_dialog();
                        }
                    });
                    QuizActivity.this.ifDone.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    QuizActivity.this.ifDone.create().show();
                    return;
                }
                QuizActivity.this._save_dialog();
            }
        });
        this.imageview7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QuizActivity quizActivity = QuizActivity.this;
                quizActivity.click2 = quizActivity.click2 + 1.0d;
                if (QuizActivity.this.click2 == 1.0d) {
                    QuizActivity.this.listview1.setVisibility(8);
                    QuizActivity.this.listview2.setVisibility(0);
                    QuizActivity.this.imageview7.setImageResource(R.drawable.ic_assignment_turned_in_white);
                } else if (QuizActivity.this.click2 == 2.0d) {
                    QuizActivity.this.listview1.setVisibility(0);
                    QuizActivity.this.listview2.setVisibility(8);
                    QuizActivity.this.imageview7.setImageResource(R.drawable.ic_assignment_white1);
                    QuizActivity.this.click2 = 0.0d;
                }
            }
        });
        this.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                QuizActivity.this.button1.setEnabled(true);
                QuizActivity.this.sp.edit().putString("isClicked", "yes").commit();
                QuizActivity.this.sp.edit().putString("fromList", "one").commit();
                QuizActivity.this.quiz_map = (HashMap) QuizActivity.this.quiz_lmap.get(i);
                QuizActivity.this.ques.setText(QuizActivity.this.quiz_map.get("ques").toString());
                QuizActivity.this.checkbox1.setText(QuizActivity.this.quiz_map.get("a").toString());
                QuizActivity.this.checkbox2.setText(QuizActivity.this.quiz_map.get("b").toString());
                QuizActivity.this.checkbox3.setText(QuizActivity.this.quiz_map.get("c").toString());
                QuizActivity.this.checkbox4.setText(QuizActivity.this.quiz_map.get("d").toString());
                QuizActivity.this.c_a.setText(QuizActivity.this.quiz_map.get("c_a").toString());
                QuizActivity.this.textview21.setText(String.valueOf((long) QuizActivity.this.n));
                QuizActivity.this.img1 = QuizActivity.this.quiz_map.get("img1").toString();
                QuizActivity.this.imageString = QuizActivity.this.img1;
                if (QuizActivity.this.img1.equals("none")) {
                    QuizActivity.this.linear52.setVisibility(8);
                    QuizActivity.this.sp.edit().putString("isImg", "n").commit();
                } else {
                    QuizActivity.this.sp.edit().putString("isImg", "y").commit();
                    QuizActivity.this.linear52.setVisibility(0);
                    byte[] decode = Base64.decode(QuizActivity.this.img1, 0);
                    QuizActivity.this.imageview1.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                }
                QuizActivity.this.location = (double) i;
                QuizActivity.this._falseCheckboxes();
                QuizActivity.this.imageview6.setImageResource(R.drawable.ic_format_list_numbered_white);
                QuizActivity.this.a.setTarget(QuizActivity.this.child2);
                QuizActivity.this.a.setFloatValues(new float[]{(float) (0 - SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext())), SketchwareUtil.getDip(QuizActivity.this.getApplicationContext(), -321) - ((float) SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext()))});
                QuizActivity.this.a.start();
                QuizActivity.this.click = 0.0d;
            }
        });
        this.listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                QuizActivity.this.button1.setEnabled(true);
                QuizActivity.this.sp.edit().putString("fromList", "two").commit();
                QuizActivity.this.sp.edit().putString("isClicked", "yes").commit();
                QuizActivity.this.ans_map = (HashMap) QuizActivity.this.ans_lmap.get(i);
                QuizActivity.this.loc2 = (double) i;
                QuizActivity.this.ques.setText(QuizActivity.this.ans_map.get("ques").toString());
                QuizActivity.this.checkbox1.setText(QuizActivity.this.ans_map.get("a").toString());
                QuizActivity.this.checkbox2.setText(QuizActivity.this.ans_map.get("b").toString());
                QuizActivity.this.checkbox3.setText(QuizActivity.this.ans_map.get("c").toString());
                QuizActivity.this.checkbox4.setText(QuizActivity.this.ans_map.get("d").toString());
                QuizActivity.this.c_a.setText(QuizActivity.this.ans_map.get("c_a").toString());
                QuizActivity.this.textview21.setText(String.valueOf((long) QuizActivity.this.n));
                QuizActivity.this.img1 = QuizActivity.this.ans_map.get("img1").toString();
                QuizActivity.this.imageString = QuizActivity.this.img1;
                if (QuizActivity.this.img1.equals("none")) {
                    QuizActivity.this.linear52.setVisibility(8);
                    QuizActivity.this.sp.edit().putString("isImg", "n").commit();
                } else {
                    QuizActivity.this.linear52.setVisibility(0);
                    QuizActivity.this.sp.edit().putString("isImg", "y").commit();
                    byte[] decode = Base64.decode(QuizActivity.this.img1, 0);
                    QuizActivity.this.imageview1.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                }
                QuizActivity.this._falseCheckboxes();
                QuizActivity.this.imageview6.setImageResource(R.drawable.ic_format_list_numbered_white);
                QuizActivity.this.a.setTarget(QuizActivity.this.child2);
                QuizActivity.this.a.setFloatValues(new float[]{(float) (0 - SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext())), SketchwareUtil.getDip(QuizActivity.this.getApplicationContext(), -321) - ((float) SketchwareUtil.getDisplayWidthPixels(QuizActivity.this.getApplicationContext()))});
                QuizActivity.this.a.start();
                QuizActivity.this.click = 0.0d;
            }
        });
    }

    private void initializeLogic() {
        this.child2.setElevation(100.0f);
        this.json = this.sp.getString("quiz_data", "");
        this.quiz_lmap = (ArrayList) new Gson().fromJson(this.json, new TypeToken<ArrayList<HashMap<String, Object>>>() {
        }.getType());
        this.n = 0.0d;
        this.q = 0.0d;
        this.size = (double) this.quiz_lmap.size();
        _pickQuestion();
        this.time = 5.0d;
        this.t = new TimerTask() {
            public void run() {
                QuizActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        QuizActivity access$0 = QuizActivity.this;
                        access$0.time = access$0.time - 1.0d;
                        if (QuizActivity.this.time == 0.0d) {
                            QuizActivity.this.sp.edit().putString("key", "ok").commit();
                            QuizActivity.this.finish();
                        }
                    }
                });
            }
        };
        this._timer.scheduleAtFixedRate(this.t, 1000, 60000);
        this.click = 0.0d;
        this.click2 = 0.0d;
        this.fname.setVisibility(8);
        this.listview2.setVisibility(4);
        this.c_a.setVisibility(8);
        this.listview1.setAdapter(new Listview1Adapter(this.quiz_lmap));
        ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        this.listview2.setAdapter(new Listview2Adapter(this.ans_lmap));
        ((BaseAdapter) this.listview2.getAdapter()).notifyDataSetChanged();
        this.imageview7.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2196F3"));
        gradientDrawable.setCornerRadius(10.0f);
        this.button1.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#2196F3"));
        gradientDrawable2.setCornerRadius(10.0f);
        this.submit_butn.setBackground(gradientDrawable2);
        this.sp.edit().putString("isClicked", "no").commit();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: private */
    public void _pickQuestion() {
        this.sp.edit().putString("isClicked", "no").commit();
        this.n += 1.0d;
        this.quiz_map = this.quiz_lmap.get(0);
        this.ques.setText(this.quiz_map.get("ques").toString());
        this.checkbox1.setText(this.quiz_map.get("a").toString());
        this.checkbox2.setText(this.quiz_map.get("b").toString());
        this.checkbox3.setText(this.quiz_map.get("c").toString());
        this.checkbox4.setText(this.quiz_map.get("d").toString());
        this.c_a.setText(this.quiz_map.get("c_a").toString());
        this.textview21.setText(String.valueOf((long) this.n));
        this.img1 = this.quiz_map.get("img1").toString();
        this.imageString = this.img1;
        if (this.img1.equals("none")) {
            this.linear52.setVisibility(8);
            this.sp.edit().putString("isImg", "n").commit();
            return;
        }
        this.sp.edit().putString("isImg", "y").commit();
        this.linear52.setVisibility(0);
        byte[] decode = Base64.decode(this.img1, 0);
        this.imageview1.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
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

    /* access modifiers changed from: private */
    public void _map_put() {
        this.ans_map = new HashMap<>();
        this.ans_map.put("ques", this.ques.getText().toString());
        this.ans_map.put("a", this.checkbox1.getText().toString());
        this.ans_map.put("b", this.checkbox2.getText().toString());
        this.ans_map.put("c", this.checkbox3.getText().toString());
        this.ans_map.put("d", this.checkbox4.getText().toString());
        this.ans_map.put("ans", this.answer);
        this.ans_map.put("c_a", this.c_a.getText().toString());
        if (this.sp.getString("isImg", "").equals("y")) {
            this.ans_map.put("img1", this.imageString);
        } else if (this.sp.getString("isImg", "").equals("n")) {
            this.ans_map.put("img1", "none");
        }
        this.ans_lmap.add(this.ans_map);
        this.answer = "";
    }

    private void _zip(String str, String str2) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            zip(zipOutputStream, str, (String) null);
            zipOutputStream.close();
        } catch (IOException e) {
        }
    }

    private void zip(ZipOutputStream zipOutputStream, String str, String str2) throws IOException {
        String str3;
        File file = new File(str);
        StringBuilder append = new StringBuilder(String.valueOf(str2 != null ? String.valueOf(str2) + File.separator : "")).append(file.getName());
        if (file.isDirectory()) {
            str3 = File.separator;
        } else {
            str3 = "";
        }
        ZipEntry zipEntry = new ZipEntry(append.append(str3).toString());
        zipOutputStream.putNextEntry(zipEntry);
        if (file.isFile()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            zipOutputStream.write(bArr, 0, fileInputStream.read(bArr));
            return;
        }
        for (File absolutePath : file.listFiles()) {
            zip(zipOutputStream, absolutePath.getAbsolutePath(), zipEntry.getName());
        }
    }

    /* access modifiers changed from: private */
    public void _save_zip() {
        this.source = FileUtil.getExternalStorageDir().concat("/Quiz Manager/".concat("/check/".concat(this.fname.getText().toString().trim())));
        FileUtil.writeFile(this.source, this.f_y);
        this.destination = this.source.concat(".skl");
        _zip(this.source, this.destination);
        if (FileUtil.isFile(this.destination)) {
            FileUtil.deleteFile(this.source);
        }
    }

    /* access modifiers changed from: private */
    public void _save_dialog() {
        this.submit.setMessage("Filename");
        final EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.submit.setView(editText);
        this.submit.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!QuizActivity.this.fname.getText().toString().trim().equals("")) {
                    QuizActivity.this.fname.setText(editText.getText());
                    QuizActivity.this.l = 0.0d;
                    while (QuizActivity.this.l != ((double) QuizActivity.this.ans_lmap.size())) {
                        QuizActivity.this.s_map = (HashMap) QuizActivity.this.ans_lmap.get((int) QuizActivity.this.l);
                        QuizActivity.this.final_map = new HashMap();
                        QuizActivity.this.final_map.put("ques", QuizActivity.this.s_map.get("ques").toString());
                        QuizActivity.this.final_map.put("ans", QuizActivity.this.s_map.get("ans").toString());
                        QuizActivity.this.final_map.put("c_a", QuizActivity.this.s_map.get("c_a").toString());
                        QuizActivity.this.final_lmap.add(QuizActivity.this.final_map);
                        QuizActivity quizActivity = QuizActivity.this;
                        quizActivity.l = quizActivity.l + 1.0d;
                    }
                    QuizActivity.this.f_x = new Gson().toJson((Object) QuizActivity.this.final_lmap);
                    QuizActivity.this.f_y = Base64.encodeToString(QuizActivity.this.f_x.getBytes(), 0);
                    QuizActivity.this._save_zip();
                    SketchwareUtil.showMessage(QuizActivity.this.getApplicationContext(), "File saved at /Internal Storage/Quiz Manager/check");
                    return;
                }
                SketchwareUtil.showMessage(QuizActivity.this.getApplicationContext(), "Empty file name");
            }
        });
        this.submit.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.submit.create().show();
    }

    public class Listview1Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview1Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        public int getCount() {
            return this._data.size();
        }

        public HashMap<String, Object> getItem(int i) {
            return this._data.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) QuizActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.quiz_view, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            QuizActivity.this.quiz_map = (HashMap) QuizActivity.this.quiz_lmap.get(i);
            ((TextView) view.findViewById(R.id.ques)).setText(QuizActivity.this.quiz_map.get("ques").toString());
            ((TextView) view.findViewById(R.id.textview1)).setText(String.valueOf(i + 1).concat("."));
            return view;
        }
    }

    public class Listview2Adapter extends BaseAdapter {
        ArrayList<HashMap<String, Object>> _data;

        public Listview2Adapter(ArrayList<HashMap<String, Object>> arrayList) {
            this._data = arrayList;
        }

        public int getCount() {
            return this._data.size();
        }

        public HashMap<String, Object> getItem(int i) {
            return this._data.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) QuizActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.quiz_view, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            QuizActivity.this.ans_map = (HashMap) QuizActivity.this.ans_lmap.get(i);
            ((TextView) view.findViewById(R.id.ques)).setText(QuizActivity.this.ans_map.get("ques").toString());
            ((TextView) view.findViewById(R.id.textview1)).setText(String.valueOf((long) (i + 1)).concat("."));
            return view;
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
