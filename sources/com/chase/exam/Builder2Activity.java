package com.chase.exam;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.ByteArrayOutputStream;
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
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

public class Builder2Activity extends AppCompatActivity {
    private String Ques = "";
    public final int REQ_CD_CHOOSE = HttpStatus.SC_SWITCHING_PROTOCOLS;
    /* access modifiers changed from: private */
    public Timer _timer = new Timer();
    /* access modifiers changed from: private */
    public ObjectAnimator a = new ObjectAnimator();
    /* access modifiers changed from: private */
    public EditText a_;
    /* access modifiers changed from: private */
    public TextView add_img1;
    /* access modifiers changed from: private */
    public ObjectAnimator b = new ObjectAnimator();
    /* access modifiers changed from: private */
    public EditText b_;
    private TextView btn_save;
    /* access modifiers changed from: private */
    public EditText c_;
    /* access modifiers changed from: private */
    public Intent choose = new Intent("android.intent.action.GET_CONTENT");
    private double click = 0.0d;
    /* access modifiers changed from: private */
    public TextView correct_answer;
    /* access modifiers changed from: private */
    public AlertDialog crop_dialog;
    /* access modifiers changed from: private */
    public CropImageView crp;
    private LinearLayout cv_cont;
    private LinearLayout cv_data;
    private LinearLayout cv_img;
    private LinearLayout cv_qname;
    /* access modifiers changed from: private */
    public AlertDialog.Builder d1;
    /* access modifiers changed from: private */
    public EditText d_;
    /* access modifiers changed from: private */
    public String decode_img = "";
    /* access modifiers changed from: private */
    public AlertDialog.Builder del;
    /* access modifiers changed from: private */
    public AlertDialog.Builder del_quiz;
    private TextView desc;
    private String destination = "";
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> dmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<String, Object> dmapv = new HashMap<>();
    private TextView dura;
    /* access modifiers changed from: private */
    public TextView fname;
    private Intent i = new Intent();
    private String image1 = "";
    private String imageString = "";
    private ImageView imageview;
    /* access modifiers changed from: private */
    public ImageView imageview1;
    private ImageView imageview13;
    private ImageView imageview14;
    private ImageView imageview3;
    /* access modifiers changed from: private */
    public ImageView imageview6;
    /* access modifiers changed from: private */
    public TextView items;
    private LinearLayout lin;
    private LinearLayout lin_des;
    private LinearLayout lincrope;
    private LinearLayout linear1;
    private LinearLayout linear10;
    private LinearLayout linear11;
    private LinearLayout linear17;
    private LinearLayout linear19;
    private LinearLayout linear2;
    private LinearLayout linear20;
    private LinearLayout linear26;
    /* access modifiers changed from: private */
    public LinearLayout linear28;
    private LinearLayout linear33;
    /* access modifiers changed from: private */
    public LinearLayout linear4;
    private LinearLayout linear43;
    private LinearLayout linear44;
    /* access modifiers changed from: private */
    public LinearLayout linear45;
    private LinearLayout linear46;
    private LinearLayout linear49;
    private LinearLayout linear5;
    private LinearLayout linear50;
    private LinearLayout linear6;
    private LinearLayout linear8;
    private LinearLayout linear9;
    /* access modifiers changed from: private */
    public ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> list2 = new ArrayList<>();
    /* access modifiers changed from: private */
    public AlertDialog.Builder list_size;
    /* access modifiers changed from: private */
    public ListView listview1;
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public double n = 0.0d;
    /* access modifiers changed from: private */
    public EditText note_;
    /* access modifiers changed from: private */
    public double pos = 0.0d;
    private ProgressDialog prog;
    private TextView qname_;
    /* access modifiers changed from: private */
    public EditText ques;
    private String quizConf = "";
    private String quizName = "";
    /* access modifiers changed from: private */
    public AlertDialog.Builder save_file;
    private String source = "";
    /* access modifiers changed from: private */
    public SharedPreferences sp;
    /* access modifiers changed from: private */
    public Spinner spinner2;
    /* access modifiers changed from: private */
    public Spinner spinner3;
    /* access modifiers changed from: private */
    public TimerTask t;
    private TextView textview11;
    /* access modifiers changed from: private */
    public TextView textview12;
    private TextView textview14;
    private TextView textview15;
    private TextView textview2;
    private TextView textview4;
    private TextView textview5;
    private TextView textview6;
    private TextView textview9;
    /* access modifiers changed from: private */
    public HashMap<String, Object> vmap = new HashMap<>();
    private ScrollView vscroll6;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.builder2);
        initialize(bundle);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1 || ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1000);
            return;
        }
        initializeLogic();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1000) {
            initializeLogic();
        }
    }

    private void initialize(Bundle bundle) {
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear44 = (LinearLayout) findViewById(R.id.linear44);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.fname = (TextView) findViewById(R.id.fname);
        this.linear6 = (LinearLayout) findViewById(R.id.linear6);
        this.imageview14 = (ImageView) findViewById(R.id.imageview14);
        this.imageview6 = (ImageView) findViewById(R.id.imageview6);
        this.spinner3 = (Spinner) findViewById(R.id.spinner3);
        this.linear49 = (LinearLayout) findViewById(R.id.linear49);
        this.linear45 = (LinearLayout) findViewById(R.id.linear45);
        this.vscroll6 = (ScrollView) findViewById(R.id.vscroll6);
        this.linear28 = (LinearLayout) findViewById(R.id.linear28);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.lin_des = (LinearLayout) findViewById(R.id.lin_des);
        this.linear17 = (LinearLayout) findViewById(R.id.linear17);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.add_img1 = (TextView) findViewById(R.id.add_img1);
        this.ques = (EditText) findViewById(R.id.ques);
        this.linear19 = (LinearLayout) findViewById(R.id.linear19);
        this.linear11 = (LinearLayout) findViewById(R.id.linear11);
        this.linear26 = (LinearLayout) findViewById(R.id.linear26);
        this.linear43 = (LinearLayout) findViewById(R.id.linear43);
        this.linear20 = (LinearLayout) findViewById(R.id.linear20);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.a_ = (EditText) findViewById(R.id.a_);
        this.textview5 = (TextView) findViewById(R.id.textview5);
        this.b_ = (EditText) findViewById(R.id.b_);
        this.textview6 = (TextView) findViewById(R.id.textview6);
        this.c_ = (EditText) findViewById(R.id.c_);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.d_ = (EditText) findViewById(R.id.d_);
        this.linear33 = (LinearLayout) findViewById(R.id.linear33);
        this.linear50 = (LinearLayout) findViewById(R.id.linear50);
        this.textview11 = (TextView) findViewById(R.id.textview11);
        this.correct_answer = (TextView) findViewById(R.id.correct_answer);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);
        this.note_ = (EditText) findViewById(R.id.note_);
        this.textview12 = (TextView) findViewById(R.id.textview12);
        this.imageview13 = (ImageView) findViewById(R.id.imageview13);
        this.linear46 = (LinearLayout) findViewById(R.id.linear46);
        this.listview1 = (ListView) findViewById(R.id.listview1);
        this.cv_cont = (LinearLayout) findViewById(R.id.cv_cont);
        this.cv_img = (LinearLayout) findViewById(R.id.cv_img);
        this.cv_qname = (LinearLayout) findViewById(R.id.cv_qname);
        this.cv_data = (LinearLayout) findViewById(R.id.cv_data);
        this.imageview = (ImageView) findViewById(R.id.imageview);
        this.qname_ = (TextView) findViewById(R.id.qname_);
        this.textview15 = (TextView) findViewById(R.id.textview15);
        this.items = (TextView) findViewById(R.id.items);
        this.desc = (TextView) findViewById(R.id.desc);
        this.textview14 = (TextView) findViewById(R.id.textview14);
        this.dura = (TextView) findViewById(R.id.dura);
        this.sp = getSharedPreferences("sp", 0);
        this.d1 = new AlertDialog.Builder(this);
        this.del = new AlertDialog.Builder(this);
        this.choose.setType("image/*");
        this.choose.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        this.save_file = new AlertDialog.Builder(this);
        this.del_quiz = new AlertDialog.Builder(this);
        this.list_size = new AlertDialog.Builder(this);
        this.imageview3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Builder2Activity.this.ques.getText().toString().equals("") || Builder2Activity.this.a_.getText().toString().equals("") || Builder2Activity.this.b_.getText().toString().equals("") || Builder2Activity.this.c_.getText().toString().equals("") || Builder2Activity.this.d_.getText().toString().equals("") || Builder2Activity.this.correct_answer.getText().toString().equals("")) {
                    Builder2Activity.this.d1.setTitle("Progress will be saved");
                    Builder2Activity.this.d1.setMessage("Leave question editor?");
                    Builder2Activity.this.d1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Builder2Activity.this._prog(true, "", "Please wait");
                            Builder2Activity.this.t = new TimerTask() {
                                public void run() {
                                    Builder2Activity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            Builder2Activity.this._prog(false, "", "");
                                            SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Questions saved");
                                            Builder2Activity.this.finish();
                                        }
                                    });
                                }
                            };
                            Builder2Activity.this._timer.schedule(Builder2Activity.this.t, 2500);
                        }
                    });
                    Builder2Activity.this.d1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    Builder2Activity.this.d1.create().show();
                    return;
                }
                SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Question not yet saved");
            }
        });
        this.imageview14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder2Activity.this.del_quiz.setTitle("Warning!");
                Builder2Activity.this.del_quiz.setMessage("Delete this entire quiz?");
                Builder2Activity.this.del_quiz.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Builder2Activity.this._prog(true, "", "Please wait");
                        Builder2Activity.this.t = new TimerTask() {
                            public void run() {
                                Builder2Activity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                        Builder2Activity.this._prog(false, "", "");
                                        Builder2Activity.this.dmap.clear();
                                        Builder2Activity.this.lmap.clear();
                                        Builder2Activity.this.sp.edit().remove("data").commit();
                                        Builder2Activity.this.sp.edit().remove("quiz").commit();
                                        SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Quiz deleted");
                                        Builder2Activity.this.finish();
                                    }
                                });
                            }
                        };
                        Builder2Activity.this._timer.schedule(Builder2Activity.this.t, 2500);
                    }
                });
                Builder2Activity.this.del_quiz.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                Builder2Activity.this.del_quiz.create().show();
            }
        });
        this.imageview6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder2Activity builder2Activity = Builder2Activity.this;
                builder2Activity.n = builder2Activity.n + 1.0d;
                if (Builder2Activity.this.n == 1.0d) {
                    Builder2Activity.this.imageview6.setImageResource(R.drawable.ic_done_white);
                    Builder2Activity.this.a.setTarget(Builder2Activity.this.linear45);
                    Builder2Activity.this.a.setPropertyName("translationX");
                    Builder2Activity.this.a.setFloatValues(new float[]{SketchwareUtil.getDip(Builder2Activity.this.getApplicationContext(), -321) - ((float) SketchwareUtil.getDisplayWidthPixels(Builder2Activity.this.getApplicationContext())), (float) (0 - SketchwareUtil.getDisplayWidthPixels(Builder2Activity.this.getApplicationContext()))});
                    Builder2Activity.this.a.setDuration(210);
                    Builder2Activity.this.a.setRepeatMode(2);
                    Builder2Activity.this.a.setRepeatCount(0);
                    Builder2Activity.this.a.setInterpolator(new LinearInterpolator());
                    Builder2Activity.this.a.start();
                } else if (Builder2Activity.this.n == 2.0d) {
                    Builder2Activity.this.imageview6.setImageResource(R.drawable.ic_format_list_numbered_white);
                    Builder2Activity.this.a.setTarget(Builder2Activity.this.linear45);
                    Builder2Activity.this.a.setFloatValues(new float[]{(float) (0 - SketchwareUtil.getDisplayWidthPixels(Builder2Activity.this.getApplicationContext())), SketchwareUtil.getDip(Builder2Activity.this.getApplicationContext(), -321) - ((float) SketchwareUtil.getDisplayWidthPixels(Builder2Activity.this.getApplicationContext()))});
                    Builder2Activity.this.a.start();
                    Builder2Activity.this.n = 0.0d;
                }
            }
        });
        this.spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    if (Builder2Activity.this.lmap.size() <= 0) {
                        SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Quiz is empty");
                        ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                        Builder2Activity.this.spinner3.setSelection(2);
                    } else if (((double) Builder2Activity.this.lmap.size()) != Double.parseDouble(Builder2Activity.this.items.getText().toString())) {
                        Builder2Activity.this.list_size.setTitle("Items not yet complete");
                        Builder2Activity.this.list_size.setMessage("Save quiz file now?");
                        Builder2Activity.this.list_size.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Builder2Activity.this.save_file.setTitle("Filename");
                                final EditText editText = new EditText(Builder2Activity.this);
                                editText.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                                Builder2Activity.this.save_file.setView(editText);
                                Builder2Activity.this.save_file.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Builder2Activity.this.fname.setText(editText.getText());
                                        if (Builder2Activity.this.fname.getText().toString().trim().equals("")) {
                                            SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "File name is empty!");
                                            ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                                            Builder2Activity.this.spinner3.setSelection(2);
                                            return;
                                        }
                                        Builder2Activity.this._prog(true, "Saving", "Please wait");
                                        Builder2Activity.this.lmap.add(Builder2Activity.this.dmapv);
                                        Builder2Activity.this._save_zip();
                                        Builder2Activity.this.sp.edit().remove("data").commit();
                                        Builder2Activity.this.sp.edit().remove("quiz").commit();
                                        Builder2Activity.this.vmap.clear();
                                        Builder2Activity.this.dmapv.clear();
                                        Builder2Activity.this.dmap.clear();
                                        Builder2Activity.this.lmap.clear();
                                        Builder2Activity.this.t = new TimerTask() {
                                            public void run() {
                                                Builder2Activity.this.runOnUiThread(new Runnable() {
                                                    public void run() {
                                                        Builder2Activity.this._prog(false, "", "");
                                                        SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "File saved at /Internal Storage/Quiz Manager/quiz");
                                                        Builder2Activity.this.finish();
                                                    }
                                                });
                                            }
                                        };
                                        Builder2Activity.this._timer.schedule(Builder2Activity.this.t, 3700);
                                    }
                                });
                                Builder2Activity.this.save_file.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                                        Builder2Activity.this.spinner3.setSelection(2);
                                    }
                                });
                                Builder2Activity.this.save_file.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                    public void onDismiss(DialogInterface dialogInterface) {
                                        ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                                        Builder2Activity.this.spinner3.setSelection(2);
                                    }
                                });
                                Builder2Activity.this.save_file.create().show();
                            }
                        });
                        Builder2Activity.this.list_size.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                                Builder2Activity.this.spinner3.setSelection(2);
                            }
                        });
                        Builder2Activity.this.list_size.setOnDismissListener(new DialogInterface.OnDismissListener() {
                            public void onDismiss(DialogInterface dialogInterface) {
                                ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                                Builder2Activity.this.spinner3.setSelection(2);
                            }
                        });
                        Builder2Activity.this.list_size.create().show();
                    } else {
                        Builder2Activity.this.save_file.setTitle("Filename");
                        final EditText editText = new EditText(Builder2Activity.this);
                        editText.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                        Builder2Activity.this.save_file.setView(editText);
                        Builder2Activity.this.save_file.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Builder2Activity.this.fname.setText(editText.getText());
                                if (Builder2Activity.this.fname.getText().toString().trim().equals("")) {
                                    SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "File name is empty!");
                                    ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                                    Builder2Activity.this.spinner3.setSelection(2);
                                    return;
                                }
                                Builder2Activity.this._prog(true, "Saving", "Please wait");
                                Builder2Activity.this.lmap.add(Builder2Activity.this.dmapv);
                                Builder2Activity.this._save_zip();
                                Builder2Activity.this.sp.edit().remove("data").commit();
                                Builder2Activity.this.sp.edit().remove("quiz").commit();
                                Builder2Activity.this.vmap.clear();
                                Builder2Activity.this.dmapv.clear();
                                Builder2Activity.this.dmap.clear();
                                Builder2Activity.this.lmap.clear();
                                Builder2Activity.this.t = new TimerTask() {
                                    public void run() {
                                        Builder2Activity.this.runOnUiThread(new Runnable() {
                                            public void run() {
                                                Builder2Activity.this._prog(false, "", "");
                                                SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "File saved at /Internal Storage/Quiz Manager/quiz");
                                                Builder2Activity.this.finish();
                                            }
                                        });
                                    }
                                };
                                Builder2Activity.this._timer.schedule(Builder2Activity.this.t, 3700);
                            }
                        });
                        Builder2Activity.this.save_file.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ((ArrayAdapter) Builder2Activity.this.spinner3.getAdapter()).notifyDataSetChanged();
                                Builder2Activity.this.spinner3.setSelection(2);
                            }
                        });
                        Builder2Activity.this.save_file.create().show();
                    }
                } else if (i == 1) {
                    Builder2Activity.this._prog(true, "", "Please wait");
                    Builder2Activity.this.t = new TimerTask() {
                        public void run() {
                            Builder2Activity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    Builder2Activity.this._prog(false, "", "");
                                    SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Questions saved");
                                    Builder2Activity.this.finish();
                                }
                            });
                        }
                    };
                    Builder2Activity.this._timer.schedule(Builder2Activity.this.t, 2500);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.linear45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.linear28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder2Activity.this.b.setTarget(Builder2Activity.this.linear28);
                Builder2Activity.this.b.setPropertyName("alpha");
                Builder2Activity.this.b.setFloatValues(new float[]{0.0f, 1.0f});
                Builder2Activity.this.b.setDuration(600);
                Builder2Activity.this.b.setRepeatMode(2);
                Builder2Activity.this.b.setRepeatCount(0);
                Builder2Activity.this.b.start();
                if (Builder2Activity.this.ques.getText().toString().trim().equals("") || Builder2Activity.this.a_.getText().toString().trim().equals("") || Builder2Activity.this.b_.getText().toString().trim().equals("") || Builder2Activity.this.c_.getText().toString().trim().equals("") || Builder2Activity.this.d_.getText().toString().trim().equals("") || Builder2Activity.this.correct_answer.getText().toString().trim().equals("Select")) {
                    SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Please fill in all fields");
                    if (Builder2Activity.this.ques.getText().toString().trim().equals("")) {
                        Builder2Activity.this.ques.setError("Add question");
                    }
                    if (Builder2Activity.this.a_.getText().toString().trim().equals("")) {
                        Builder2Activity.this.a_.setError("Add option");
                    }
                    if (Builder2Activity.this.b_.getText().toString().trim().equals("")) {
                        Builder2Activity.this.b_.setError("Add option");
                        if (Builder2Activity.this.c_.getText().toString().trim().equals("")) {
                            Builder2Activity.this.c_.setError("Add option");
                        }
                        if (Builder2Activity.this.d_.getText().toString().trim().equals("")) {
                            Builder2Activity.this.d_.setError("Add option");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (Builder2Activity.this.sp.getString("isPicked", "").equals("yes")) {
                    Builder2Activity.this._add_map();
                    Builder2Activity.this.lmap.remove((int) Builder2Activity.this.pos);
                } else {
                    Builder2Activity.this._add_map();
                }
                Builder2Activity.this.sp.edit().putString("isPicked", "no").commit();
            }
        });
        this.linear4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder2Activity.this.startActivityForResult(Builder2Activity.this.choose, HttpStatus.SC_SWITCHING_PROTOCOLS);
            }
        });
        this.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                Builder2Activity.this.correct_answer.setText((CharSequence) Builder2Activity.this.list.get(i));
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Builder2Activity.this.sp.edit().putString("isPicked", "yes").commit();
                Builder2Activity.this.pos = (double) i;
                Builder2Activity.this.vmap = (HashMap) Builder2Activity.this.lmap.get(i);
                Builder2Activity.this.ques.setText(Builder2Activity.this.vmap.get("ques").toString());
                Builder2Activity.this.a_.setText(Builder2Activity.this.vmap.get("a").toString());
                Builder2Activity.this.b_.setText(Builder2Activity.this.vmap.get("b").toString());
                Builder2Activity.this.c_.setText(Builder2Activity.this.vmap.get("c").toString());
                Builder2Activity.this.d_.setText(Builder2Activity.this.vmap.get("d").toString());
                Builder2Activity.this.correct_answer.setText(Builder2Activity.this.vmap.get("c_a").toString());
                Builder2Activity.this.note_.setText(Builder2Activity.this.vmap.get("note").toString());
                Builder2Activity.this.decode_img = Builder2Activity.this.vmap.get("img1").toString();
                if (Builder2Activity.this.decode_img.equals("none")) {
                    Builder2Activity.this.ques.requestFocus();
                    Builder2Activity.this.imageview1.setImageResource(R.drawable.ic_action_white_add_photo_5);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setColor(Color.parseColor("#2196F3"));
                    gradientDrawable.setCornerRadius(18.0f);
                    Builder2Activity.this.linear4.setBackground(gradientDrawable);
                    Builder2Activity.this.linear4.setElevation(6.0f);
                    Builder2Activity.this.add_img1.setVisibility(0);
                } else {
                    Builder2Activity.this.sp.edit().putString("img_value", "picked").commit();
                    byte[] decode = Base64.decode(Builder2Activity.this.decode_img, 0);
                    Builder2Activity.this.imageview1.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    Builder2Activity.this.linear4.setBackgroundResource(0);
                }
                Builder2Activity.this.imageview6.setImageResource(R.drawable.ic_format_list_numbered_white);
                Builder2Activity.this.a.setTarget(Builder2Activity.this.linear45);
                Builder2Activity.this.a.setFloatValues(new float[]{(float) (0 - SketchwareUtil.getDisplayWidthPixels(Builder2Activity.this.getApplicationContext())), SketchwareUtil.getDip(Builder2Activity.this.getApplicationContext(), -321) - ((float) SketchwareUtil.getDisplayWidthPixels(Builder2Activity.this.getApplicationContext()))});
                Builder2Activity.this.a.start();
                Builder2Activity.this.n = 0.0d;
                Builder2Activity.this.textview12.setText("Save");
                if (Builder2Activity.this.vmap.get("c_a").toString().equals("a")) {
                    Builder2Activity.this.spinner2.setSelection(1);
                } else {
                    if (Builder2Activity.this.vmap.get("c_a").toString().equals("b")) {
                        Builder2Activity.this.spinner2.setSelection(2);
                    }
                    if (Builder2Activity.this.vmap.get("c_a").toString().equals("c")) {
                        Builder2Activity.this.spinner2.setSelection(3);
                    }
                    if (Builder2Activity.this.vmap.get("c_a").toString().equals("d")) {
                        Builder2Activity.this.spinner2.setSelection(4);
                    }
                }
                ((BaseAdapter) Builder2Activity.this.listview1.getAdapter()).notifyDataSetChanged();
                Builder2Activity.this.linear28.setEnabled(true);
                Builder2Activity.this.add_img1.setVisibility(0);
            }
        });
    }

    private void initializeLogic() {
        _ATPHMaterialInput(this.lin_des, this.ques, "Write your question here:", "quest");
        _ATPHMaterialInput(this.linear20, this.a_, "Option A", "aa");
        _ATPHMaterialInput(this.linear8, this.b_, "Option B", "bb");
        _ATPHMaterialInput(this.linear9, this.c_, "Option C", "cc");
        _ATPHMaterialInput(this.linear10, this.d_, "Option D", "dd");
        _ATPHMaterialInput(this.linear50, this.note_, "Add notes (optional):", "nn");
        if (!this.sp.getString("data", "").equals("")) {
            this.dmap = (ArrayList) new Gson().fromJson(this.sp.getString("data", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
            _prog(true, "", "Please wait");
            this.t = new TimerTask() {
                public void run() {
                    Builder2Activity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            Builder2Activity.this._prog(false, "", "");
                        }
                    });
                }
            };
            this._timer.schedule(this.t, 2500);
        }
        if (!this.sp.getString("quiz", "").equals("")) {
            this.lmap = (ArrayList) new Gson().fromJson(this.sp.getString("quiz", ""), new TypeToken<ArrayList<HashMap<String, Object>>>() {
            }.getType());
        }
        this.listview1.setAdapter(new Listview1Adapter(this.lmap));
        ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        this.fname.setVisibility(4);
        this.correct_answer.setVisibility(4);
        this.textview2.setText(this.sp.getString("title", ""));
        this.linear28.setElevation(4.0f);
        this.linear4.setElevation(4.0f);
        this.linear5.setElevation(4.0f);
        this.lin_des.setElevation(4.0f);
        this.linear19.setElevation(4.0f);
        this.linear11.setElevation(4.0f);
        this.linear45.setElevation(100.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2196F3"));
        gradientDrawable.setCornerRadius(18.0f);
        this.linear4.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable2.setCornerRadius(18.0f);
        this.linear11.setBackground(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable3.setCornerRadius(18.0f);
        this.lin_des.setBackground(gradientDrawable3);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable4.setCornerRadius(18.0f);
        this.linear19.setBackground(gradientDrawable4);
        this.n = 0.0d;
        this.dmapv = this.dmap.get(0);
        this.qname_.setText(this.dmapv.get("qname").toString());
        this.dura.setText(this.dmapv.get("dura").toString());
        this.items.setText(this.dmapv.get("items").toString());
        this.desc.setText(this.dmapv.get("desc").toString());
        this.imageString = this.dmapv.get("img").toString();
        if (this.imageString.equals("none")) {
            this.imageview.setImageResource(R.drawable.up_);
        } else {
            byte[] decode = Base64.decode(this.imageString, 0);
            this.imageview.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        }
        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(9, 9, 9, 9);
        cardView.setLayoutParams(layoutParams);
        cardView.setCardBackgroundColor(-1);
        cardView.setRadius(15.0f);
        cardView.setCardElevation(8.0f);
        cardView.setMaxCardElevation(12.0f);
        cardView.setPreventCornerOverlap(true);
        ((ViewGroup) this.cv_cont.getParent()).removeView(this.cv_cont);
        this.linear46.removeAllViews();
        this.linear46.addView(cardView);
        cardView.addView(this.cv_cont);
        this.list.add("Select");
        this.list.add("A");
        this.list.add("B");
        this.list.add("C");
        this.list.add("D");
        this.spinner2.setAdapter(new ArrayAdapter(this, 17367043, 16908308, this.list) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) super.getView(i, view, viewGroup);
                textView.setTextColor(Color.parseColor("#212121"));
                textView.setTextSize(14.0f);
                return textView;
            }

            public View getDropDownView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
                textView.setTextColor(Color.parseColor("#212121"));
                textView.setTextSize(14.0f);
                return textView;
            }
        });
        ((ArrayAdapter) this.spinner2.getAdapter()).notifyDataSetChanged();
        this.list2.add("Save .sml file");
        this.list2.add("Finish later");
        this.list2.add(HTTP.CONN_CLOSE);
        this.spinner3.setAdapter(new ArrayAdapter(this, 17367043, 16908308, this.list2) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) super.getView(i, view, viewGroup);
                textView.setTextColor(Color.parseColor("#212121"));
                textView.setTextSize(14.0f);
                return textView;
            }

            public View getDropDownView(int i, View view, ViewGroup viewGroup) {
                TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
                textView.setTextColor(Color.parseColor("#212121"));
                textView.setTextSize(14.0f);
                return textView;
            }
        });
        this.spinner3.setSelection(2);
        ((ArrayAdapter) this.spinner3.getAdapter()).notifyDataSetChanged();
        this.ques.requestFocus();
        this.sp.edit().putString("img_value", "none").commit();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        switch (i2) {
            case HttpStatus.SC_SWITCHING_PROTOCOLS /*101*/:
                if (i3 == -1) {
                    ArrayList arrayList = new ArrayList();
                    if (intent != null) {
                        if (intent.getClipData() != null) {
                            for (int i4 = 0; i4 < intent.getClipData().getItemCount(); i4++) {
                                arrayList.add(FileUtil.convertUriToFilePath(getApplicationContext(), intent.getClipData().getItemAt(i4).getUri()));
                            }
                        } else {
                            arrayList.add(FileUtil.convertUriToFilePath(getApplicationContext(), intent.getData()));
                        }
                    }
                    _showSelection((String) arrayList.get(0));
                    this.linear4.setBackgroundResource(0);
                    this.add_img1.setVisibility(4);
                    this.sp.edit().putString("img_value", "picked").commit();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        if (this.ques.getText().toString().equals("") || this.a_.getText().toString().equals("") || this.b_.getText().toString().equals("") || this.c_.getText().toString().equals("") || this.d_.getText().toString().equals("") || this.correct_answer.getText().toString().equals("")) {
            this.d1.setTitle("Progress will be saved");
            this.d1.setMessage("Leave question editor?");
            this.d1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Builder2Activity.this._prog(true, "", "Please wait");
                    Builder2Activity.this.t = new TimerTask() {
                        public void run() {
                            Builder2Activity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    Builder2Activity.this._prog(false, "", "");
                                    SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Questions saved");
                                    Builder2Activity.this.finish();
                                }
                            });
                        }
                    };
                    Builder2Activity.this._timer.schedule(Builder2Activity.this.t, 2500);
                }
            });
            this.d1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.d1.create().show();
            return;
        }
        SketchwareUtil.showMessage(getApplicationContext(), "Question not yet saved");
    }

    public void onStop() {
        super.onStop();
        this.sp.edit().putString("quiz", new Gson().toJson((Object) this.lmap)).commit();
    }

    private void _showSelection(String str) {
        if (this.crop_dialog == null) {
            this.crop_dialog = new AlertDialog.Builder(this).create();
            View inflate = getLayoutInflater().inflate(R.layout.view, (ViewGroup) null);
            this.crop_dialog.setView(inflate);
            this.crp = new CropImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 16, 0, 0);
            this.crp.setLayoutParams(layoutParams);
            this.crp.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.crp.setAdjustViewBounds(true);
            ((LinearLayout) inflate.findViewById(R.id.linear_crop)).addView(this.crp, 0);
            ((TextView) inflate.findViewById(R.id.textview_save)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Builder2Activity.this.imageview1.setImageBitmap(Builder2Activity.this.crp.getCroppedImage());
                    Builder2Activity.this.showMessage("Done");
                    Builder2Activity.this.crop_dialog.dismiss();
                }
            });
            this.crop_dialog.show();
        } else {
            this.crop_dialog.show();
        }
        this.crp.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(str, 1024, 1024));
    }

    private void _LibraryCropImg() {
    }

    public static class CropImageView extends ImageView {
        public static final int GUIDELINES_OFF = 0;
        public static final int GUIDELINES_ON = 2;
        public static final int GUIDELINES_ON_TOUCH = 1;
        private static final String TAG = CropImageView.class.getName();
        private int mAspectRatioX = 1;
        private int mAspectRatioY = 1;
        private RectF mBitmapRect = new RectF();
        private Paint mBorderPaint;
        private float mBorderThickness;
        private float mCornerLength;
        private Paint mCornerPaint;
        private float mCornerThickness;
        private boolean mFixAspectRatio;
        private Paint mGuidelinePaint;
        private int mGuidelinesMode = 1;
        private float mHandleRadius;
        private Handle mPressedHandle;
        private float mSnapRadius;
        private Paint mSurroundingAreaOverlayPaint;
        private PointF mTouchOffset = new PointF();

        public CropImageView(Context context) {
            super(context);
            init(context, (AttributeSet) null);
        }

        public CropImageView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init(context, attributeSet);
        }

        public CropImageView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init(context, attributeSet);
        }

        private void init(Context context, AttributeSet attributeSet) {
            this.mGuidelinesMode = 1;
            this.mFixAspectRatio = false;
            this.mAspectRatioX = 1;
            this.mAspectRatioY = 1;
            Resources resources = context.getResources();
            this.mBorderPaint = PaintUtil.newBorderPaint(resources);
            this.mGuidelinePaint = PaintUtil.newGuidelinePaint(resources);
            this.mSurroundingAreaOverlayPaint = PaintUtil.newSurroundingAreaOverlayPaint(resources);
            this.mCornerPaint = PaintUtil.newCornerPaint(resources);
            this.mHandleRadius = 24.0f;
            this.mSnapRadius = 3.0f;
            this.mBorderThickness = 3.0f;
            this.mCornerThickness = 5.0f;
            this.mCornerLength = 20.0f;
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.mBitmapRect = getBitmapRect();
            initCropWindow(this.mBitmapRect);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            drawDarkenedSurroundingArea(canvas);
            drawGuidelines(canvas);
            drawBorder(canvas);
            drawCorners(canvas);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!isEnabled()) {
                return false;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    onActionDown(motionEvent.getX(), motionEvent.getY());
                    return true;
                case 1:
                case 3:
                    getParent().requestDisallowInterceptTouchEvent(false);
                    onActionUp();
                    return true;
                case 2:
                    onActionMove(motionEvent.getX(), motionEvent.getY());
                    getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        public void setGuidelines(int i) {
            this.mGuidelinesMode = i;
            invalidate();
        }

        public void setFixedAspectRatio(boolean z) {
            this.mFixAspectRatio = z;
            requestLayout();
        }

        public void setAspectRatio(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            }
            this.mAspectRatioX = i;
            this.mAspectRatioY = i2;
            if (this.mFixAspectRatio) {
                requestLayout();
            }
        }

        public Bitmap getCroppedImage() {
            float f = 0.0f;
            Drawable drawable = getDrawable();
            if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                return null;
            }
            float[] fArr = new float[9];
            getImageMatrix().getValues(fArr);
            float f2 = fArr[0];
            float f3 = fArr[4];
            float f4 = fArr[2];
            float f5 = fArr[5];
            float abs = f4 < 0.0f ? Math.abs(f4) : 0.0f;
            if (f5 < 0.0f) {
                f = Math.abs(f5);
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            float coordinate = (abs + Edge.LEFT.getCoordinate()) / f2;
            float coordinate2 = (f + Edge.TOP.getCoordinate()) / f3;
            return Bitmap.createBitmap(bitmap, (int) coordinate, (int) coordinate2, (int) Math.min(Edge.getWidth() / f2, ((float) bitmap.getWidth()) - coordinate), (int) Math.min(Edge.getHeight() / f3, ((float) bitmap.getHeight()) - coordinate2));
        }

        private RectF getBitmapRect() {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return new RectF();
            }
            float[] fArr = new float[9];
            getImageMatrix().getValues(fArr);
            float f = fArr[0];
            float f2 = fArr[4];
            float f3 = fArr[2];
            float f4 = fArr[5];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int round = Math.round(f * ((float) intrinsicWidth));
            int round2 = Math.round(((float) intrinsicHeight) * f2);
            float max = Math.max(f3, 0.0f);
            float max2 = Math.max(f4, 0.0f);
            return new RectF(max, max2, Math.min(((float) round) + max, (float) getWidth()), Math.min(((float) round2) + max2, (float) getHeight()));
        }

        private void initCropWindow(RectF rectF) {
            if (this.mFixAspectRatio) {
                initCropWindowWithFixedAspectRatio(rectF);
                return;
            }
            float width = rectF.width() * 0.1f;
            float height = rectF.height() * 0.1f;
            Edge.LEFT.setCoordinate(rectF.left + width);
            Edge.TOP.setCoordinate(rectF.top + height);
            Edge.RIGHT.setCoordinate(rectF.right - width);
            Edge.BOTTOM.setCoordinate(rectF.bottom - height);
        }

        private void initCropWindowWithFixedAspectRatio(RectF rectF) {
            if (AspectRatioUtil.calculateAspectRatio(rectF) > getTargetAspectRatio()) {
                float calculateWidth = AspectRatioUtil.calculateWidth(rectF.height(), getTargetAspectRatio());
                Edge.LEFT.setCoordinate(rectF.centerX() - (calculateWidth / 2.0f));
                Edge.TOP.setCoordinate(rectF.top);
                Edge.RIGHT.setCoordinate((calculateWidth / 2.0f) + rectF.centerX());
                Edge.BOTTOM.setCoordinate(rectF.bottom);
                return;
            }
            float calculateHeight = AspectRatioUtil.calculateHeight(rectF.width(), getTargetAspectRatio());
            Edge.LEFT.setCoordinate(rectF.left);
            Edge.TOP.setCoordinate(rectF.centerY() - (calculateHeight / 2.0f));
            Edge.RIGHT.setCoordinate(rectF.right);
            Edge.BOTTOM.setCoordinate((calculateHeight / 2.0f) + rectF.centerY());
        }

        private void drawDarkenedSurroundingArea(Canvas canvas) {
            RectF rectF = this.mBitmapRect;
            float coordinate = Edge.LEFT.getCoordinate();
            float coordinate2 = Edge.TOP.getCoordinate();
            float coordinate3 = Edge.RIGHT.getCoordinate();
            float coordinate4 = Edge.BOTTOM.getCoordinate();
            canvas.drawRect(rectF.left, rectF.top, rectF.right, coordinate2, this.mSurroundingAreaOverlayPaint);
            canvas.drawRect(rectF.left, coordinate4, rectF.right, rectF.bottom, this.mSurroundingAreaOverlayPaint);
            canvas.drawRect(rectF.left, coordinate2, coordinate, coordinate4, this.mSurroundingAreaOverlayPaint);
            canvas.drawRect(coordinate3, coordinate2, rectF.right, coordinate4, this.mSurroundingAreaOverlayPaint);
        }

        private void drawGuidelines(Canvas canvas) {
            if (shouldGuidelinesBeShown()) {
                float coordinate = Edge.LEFT.getCoordinate();
                float coordinate2 = Edge.TOP.getCoordinate();
                float coordinate3 = Edge.RIGHT.getCoordinate();
                float coordinate4 = Edge.BOTTOM.getCoordinate();
                float width = Edge.getWidth() / 3.0f;
                float f = coordinate + width;
                canvas.drawLine(f, coordinate2, f, coordinate4, this.mGuidelinePaint);
                float f2 = coordinate3 - width;
                canvas.drawLine(f2, coordinate2, f2, coordinate4, this.mGuidelinePaint);
                float height = Edge.getHeight() / 3.0f;
                float f3 = coordinate2 + height;
                canvas.drawLine(coordinate, f3, coordinate3, f3, this.mGuidelinePaint);
                float f4 = coordinate4 - height;
                canvas.drawLine(coordinate, f4, coordinate3, f4, this.mGuidelinePaint);
            }
        }

        private void drawBorder(Canvas canvas) {
            canvas.drawRect(Edge.LEFT.getCoordinate(), Edge.TOP.getCoordinate(), Edge.RIGHT.getCoordinate(), Edge.BOTTOM.getCoordinate(), this.mBorderPaint);
        }

        private void drawCorners(Canvas canvas) {
            float coordinate = Edge.LEFT.getCoordinate();
            float coordinate2 = Edge.TOP.getCoordinate();
            float coordinate3 = Edge.RIGHT.getCoordinate();
            float coordinate4 = Edge.BOTTOM.getCoordinate();
            float f = (this.mCornerThickness - this.mBorderThickness) / 2.0f;
            float f2 = this.mCornerThickness - (this.mBorderThickness / 2.0f);
            canvas.drawLine(coordinate - f, coordinate2 - f2, coordinate - f, coordinate2 + this.mCornerLength, this.mCornerPaint);
            canvas.drawLine(coordinate - f2, coordinate2 - f, coordinate + this.mCornerLength, coordinate2 - f, this.mCornerPaint);
            canvas.drawLine(coordinate3 + f, coordinate2 - f2, coordinate3 + f, coordinate2 + this.mCornerLength, this.mCornerPaint);
            canvas.drawLine(coordinate3 + f2, coordinate2 - f, coordinate3 - this.mCornerLength, coordinate2 - f, this.mCornerPaint);
            canvas.drawLine(coordinate - f, coordinate4 + f2, coordinate - f, coordinate4 - this.mCornerLength, this.mCornerPaint);
            canvas.drawLine(coordinate - f2, coordinate4 + f, coordinate + this.mCornerLength, coordinate4 + f, this.mCornerPaint);
            canvas.drawLine(coordinate3 + f, coordinate4 + f2, coordinate3 + f, coordinate4 - this.mCornerLength, this.mCornerPaint);
            canvas.drawLine(coordinate3 + f2, coordinate4 + f, coordinate3 - this.mCornerLength, coordinate4 + f, this.mCornerPaint);
        }

        private boolean shouldGuidelinesBeShown() {
            if (this.mGuidelinesMode != 2) {
                return this.mGuidelinesMode == 1 && this.mPressedHandle != null;
            }
            return true;
        }

        private float getTargetAspectRatio() {
            return ((float) this.mAspectRatioX) / ((float) this.mAspectRatioY);
        }

        private void onActionDown(float f, float f2) {
            float coordinate = Edge.LEFT.getCoordinate();
            float coordinate2 = Edge.TOP.getCoordinate();
            float coordinate3 = Edge.RIGHT.getCoordinate();
            float coordinate4 = Edge.BOTTOM.getCoordinate();
            this.mPressedHandle = HandleUtil.getPressedHandle(f, f2, coordinate, coordinate2, coordinate3, coordinate4, this.mHandleRadius);
            if (this.mPressedHandle != null) {
                HandleUtil.getOffset(this.mPressedHandle, f, f2, coordinate, coordinate2, coordinate3, coordinate4, this.mTouchOffset);
                invalidate();
            }
        }

        private void onActionUp() {
            if (this.mPressedHandle != null) {
                this.mPressedHandle = null;
                invalidate();
            }
        }

        private void onActionMove(float f, float f2) {
            if (this.mPressedHandle != null) {
                float f3 = f + this.mTouchOffset.x;
                float f4 = f2 + this.mTouchOffset.y;
                if (this.mFixAspectRatio) {
                    this.mPressedHandle.updateCropWindow(f3, f4, getTargetAspectRatio(), this.mBitmapRect, this.mSnapRadius);
                } else {
                    this.mPressedHandle.updateCropWindow(f3, f4, this.mBitmapRect, this.mSnapRadius);
                }
                invalidate();
            }
        }
    }

    public static class PaintUtil {
        public static Paint newBorderPaint(Resources resources) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3.0f);
            paint.setColor(Color.parseColor("#AAFFFFFF"));
            return paint;
        }

        public static Paint newGuidelinePaint(Resources resources) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(1.0f);
            paint.setColor(Color.parseColor("#AAFFFFFF"));
            return paint;
        }

        public static Paint newSurroundingAreaOverlayPaint(Resources resources) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#B0000000"));
            return paint;
        }

        public static Paint newCornerPaint(Resources resources) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5.0f);
            paint.setColor(Color.parseColor("#FFFFFF"));
            return paint;
        }
    }

    public static class MathUtil {
        public static float calculateDistance(float f, float f2, float f3, float f4) {
            float f5 = f3 - f;
            float f6 = f4 - f2;
            return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
        }
    }

    public static class HandleUtil {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$chase$exam$Builder2Activity$Handle;

        static /* synthetic */ int[] $SWITCH_TABLE$com$chase$exam$Builder2Activity$Handle() {
            int[] iArr = $SWITCH_TABLE$com$chase$exam$Builder2Activity$Handle;
            if (iArr == null) {
                iArr = new int[Handle.values().length];
                try {
                    iArr[Handle.BOTTOM.ordinal()] = 8;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Handle.BOTTOM_LEFT.ordinal()] = 3;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Handle.BOTTOM_RIGHT.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Handle.CENTER.ordinal()] = 9;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Handle.LEFT.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[Handle.RIGHT.ordinal()] = 7;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[Handle.TOP.ordinal()] = 6;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[Handle.TOP_LEFT.ordinal()] = 1;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[Handle.TOP_RIGHT.ordinal()] = 2;
                } catch (NoSuchFieldError e9) {
                }
                $SWITCH_TABLE$com$chase$exam$Builder2Activity$Handle = iArr;
            }
            return iArr;
        }

        public static Handle getPressedHandle(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            Handle handle;
            Handle handle2;
            float f8;
            float calculateDistance = MathUtil.calculateDistance(f, f2, f3, f4);
            if (calculateDistance < Float.POSITIVE_INFINITY) {
                handle = Handle.TOP_LEFT;
            } else {
                calculateDistance = Float.POSITIVE_INFINITY;
                handle = null;
            }
            float calculateDistance2 = MathUtil.calculateDistance(f, f2, f5, f4);
            if (calculateDistance2 < calculateDistance) {
                handle = Handle.TOP_RIGHT;
                calculateDistance = calculateDistance2;
            }
            float calculateDistance3 = MathUtil.calculateDistance(f, f2, f3, f6);
            if (calculateDistance3 < calculateDistance) {
                handle = Handle.BOTTOM_LEFT;
                calculateDistance = calculateDistance3;
            }
            float calculateDistance4 = MathUtil.calculateDistance(f, f2, f5, f6);
            if (calculateDistance4 < calculateDistance) {
                handle2 = Handle.BOTTOM_RIGHT;
                f8 = calculateDistance4;
            } else {
                float f9 = calculateDistance;
                handle2 = handle;
                f8 = f9;
            }
            if (f8 <= f7) {
                return handle2;
            }
            if (isInHorizontalTargetZone(f, f2, f3, f5, f4, f7)) {
                return Handle.TOP;
            }
            if (isInHorizontalTargetZone(f, f2, f3, f5, f6, f7)) {
                return Handle.BOTTOM;
            }
            if (isInVerticalTargetZone(f, f2, f3, f4, f6, f7)) {
                return Handle.LEFT;
            }
            if (isInVerticalTargetZone(f, f2, f5, f4, f6, f7)) {
                return Handle.RIGHT;
            }
            if (isWithinBounds(f, f2, f3, f4, f5, f6)) {
                return Handle.CENTER;
            }
            return null;
        }

        public static void getOffset(Handle handle, float f, float f2, float f3, float f4, float f5, float f6, PointF pointF) {
            float f7;
            float f8 = 0.0f;
            switch ($SWITCH_TABLE$com$chase$exam$Builder2Activity$Handle()[handle.ordinal()]) {
                case 1:
                    f7 = f3 - f;
                    f8 = f4 - f2;
                    break;
                case 2:
                    f7 = f5 - f;
                    f8 = f4 - f2;
                    break;
                case 3:
                    f7 = f3 - f;
                    f8 = f6 - f2;
                    break;
                case 4:
                    f7 = f5 - f;
                    f8 = f6 - f2;
                    break;
                case 5:
                    f7 = f3 - f;
                    break;
                case 6:
                    f7 = 0.0f;
                    f8 = f4 - f2;
                    break;
                case 7:
                    f7 = f5 - f;
                    break;
                case 8:
                    f7 = 0.0f;
                    f8 = f6 - f2;
                    break;
                case 9:
                    f7 = ((f5 + f3) / 2.0f) - f;
                    f8 = ((f4 + f6) / 2.0f) - f2;
                    break;
                default:
                    f7 = 0.0f;
                    break;
            }
            pointF.x = f7;
            pointF.y = f8;
        }

        private static boolean isInHorizontalTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
            return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
        }

        private static boolean isInVerticalTargetZone(float f, float f2, float f3, float f4, float f5, float f6) {
            return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
        }

        private static boolean isWithinBounds(float f, float f2, float f3, float f4, float f5, float f6) {
            return f >= f3 && f <= f5 && f2 >= f4 && f2 <= f6;
        }
    }

    public static class AspectRatioUtil {
        public static float calculateAspectRatio(float f, float f2, float f3, float f4) {
            return (f3 - f) / (f4 - f2);
        }

        public static float calculateAspectRatio(RectF rectF) {
            return rectF.width() / rectF.height();
        }

        public static float calculateLeft(float f, float f2, float f3, float f4) {
            return f2 - ((f3 - f) * f4);
        }

        public static float calculateTop(float f, float f2, float f3, float f4) {
            return f3 - ((f2 - f) / f4);
        }

        public static float calculateRight(float f, float f2, float f3, float f4) {
            return ((f3 - f2) * f4) + f;
        }

        public static float calculateBottom(float f, float f2, float f3, float f4) {
            return ((f3 - f) / f4) + f2;
        }

        public static float calculateWidth(float f, float f2) {
            return f2 * f;
        }

        public static float calculateHeight(float f, float f2) {
            return f / f2;
        }
    }

    public enum Handle {
        TOP_LEFT(new CornerHandleHelper(Edge.TOP, Edge.LEFT)),
        TOP_RIGHT(new CornerHandleHelper(Edge.TOP, Edge.RIGHT)),
        BOTTOM_LEFT(new CornerHandleHelper(Edge.BOTTOM, Edge.LEFT)),
        BOTTOM_RIGHT(new CornerHandleHelper(Edge.BOTTOM, Edge.RIGHT)),
        LEFT(new VerticalHandleHelper(Edge.LEFT)),
        TOP(new HorizontalHandleHelper(Edge.TOP)),
        RIGHT(new VerticalHandleHelper(Edge.RIGHT)),
        BOTTOM(new HorizontalHandleHelper(Edge.BOTTOM)),
        CENTER(new CenterHandleHelper());
        
        private HandleHelper mHelper;

        private Handle(HandleHelper handleHelper) {
            this.mHelper = handleHelper;
        }

        public void updateCropWindow(float f, float f2, RectF rectF, float f3) {
            this.mHelper.updateCropWindow(f, f2, rectF, f3);
        }

        public void updateCropWindow(float f, float f2, float f3, RectF rectF, float f4) {
            this.mHelper.updateCropWindow(f, f2, f3, rectF, f4);
        }
    }

    static abstract class HandleHelper {
        private static final float UNFIXED_ASPECT_RATIO_CONSTANT = 1.0f;
        private EdgePair mActiveEdges = new EdgePair(this.mHorizontalEdge, this.mVerticalEdge);
        private Edge mHorizontalEdge;
        private Edge mVerticalEdge;

        /* access modifiers changed from: package-private */
        public abstract void updateCropWindow(float f, float f2, float f3, RectF rectF, float f4);

        HandleHelper(Edge edge, Edge edge2) {
            this.mHorizontalEdge = edge;
            this.mVerticalEdge = edge2;
        }

        /* access modifiers changed from: package-private */
        public void updateCropWindow(float f, float f2, RectF rectF, float f3) {
            EdgePair activeEdges = getActiveEdges();
            Edge edge = activeEdges.primary;
            Edge edge2 = activeEdges.secondary;
            if (edge != null) {
                edge.adjustCoordinate(f, f2, rectF, f3, UNFIXED_ASPECT_RATIO_CONSTANT);
            }
            if (edge2 != null) {
                edge2.adjustCoordinate(f, f2, rectF, f3, UNFIXED_ASPECT_RATIO_CONSTANT);
            }
        }

        /* access modifiers changed from: package-private */
        public EdgePair getActiveEdges() {
            return this.mActiveEdges;
        }

        /* access modifiers changed from: package-private */
        public EdgePair getActiveEdges(float f, float f2, float f3) {
            if (getAspectRatio(f, f2) > f3) {
                this.mActiveEdges.primary = this.mVerticalEdge;
                this.mActiveEdges.secondary = this.mHorizontalEdge;
            } else {
                this.mActiveEdges.primary = this.mHorizontalEdge;
                this.mActiveEdges.secondary = this.mVerticalEdge;
            }
            return this.mActiveEdges;
        }

        private float getAspectRatio(float f, float f2) {
            float coordinate = this.mVerticalEdge == Edge.LEFT ? f : Edge.LEFT.getCoordinate();
            float coordinate2 = this.mHorizontalEdge == Edge.TOP ? f2 : Edge.TOP.getCoordinate();
            if (this.mVerticalEdge != Edge.RIGHT) {
                f = Edge.RIGHT.getCoordinate();
            }
            if (this.mHorizontalEdge != Edge.BOTTOM) {
                f2 = Edge.BOTTOM.getCoordinate();
            }
            return AspectRatioUtil.calculateAspectRatio(coordinate, coordinate2, f, f2);
        }
    }

    static class HorizontalHandleHelper extends HandleHelper {
        private Edge mEdge;

        HorizontalHandleHelper(Edge edge) {
            super(edge, (Edge) null);
            this.mEdge = edge;
        }

        /* access modifiers changed from: package-private */
        public void updateCropWindow(float f, float f2, float f3, RectF rectF, float f4) {
            this.mEdge.adjustCoordinate(f, f2, rectF, f4, f3);
            float coordinate = Edge.LEFT.getCoordinate();
            float coordinate2 = Edge.RIGHT.getCoordinate();
            float calculateWidth = (AspectRatioUtil.calculateWidth(Edge.getHeight(), f3) - Edge.getWidth()) / 2.0f;
            Edge.LEFT.setCoordinate(coordinate - calculateWidth);
            Edge.RIGHT.setCoordinate(coordinate2 + calculateWidth);
            if (Edge.LEFT.isOutsideMargin(rectF, f4) && !this.mEdge.isNewRectangleOutOfBounds(Edge.LEFT, rectF, f3)) {
                Edge.RIGHT.offset(-Edge.LEFT.snapToRect(rectF));
                this.mEdge.adjustCoordinate(f3);
            }
            if (Edge.RIGHT.isOutsideMargin(rectF, f4) && !this.mEdge.isNewRectangleOutOfBounds(Edge.RIGHT, rectF, f3)) {
                Edge.LEFT.offset(-Edge.RIGHT.snapToRect(rectF));
                this.mEdge.adjustCoordinate(f3);
            }
        }
    }

    static class VerticalHandleHelper extends HandleHelper {
        private Edge mEdge;

        VerticalHandleHelper(Edge edge) {
            super((Edge) null, edge);
            this.mEdge = edge;
        }

        /* access modifiers changed from: package-private */
        public void updateCropWindow(float f, float f2, float f3, RectF rectF, float f4) {
            this.mEdge.adjustCoordinate(f, f2, rectF, f4, f3);
            float coordinate = Edge.TOP.getCoordinate();
            float coordinate2 = Edge.BOTTOM.getCoordinate();
            float calculateHeight = (AspectRatioUtil.calculateHeight(Edge.getWidth(), f3) - Edge.getHeight()) / 2.0f;
            Edge.TOP.setCoordinate(coordinate - calculateHeight);
            Edge.BOTTOM.setCoordinate(coordinate2 + calculateHeight);
            if (Edge.TOP.isOutsideMargin(rectF, f4) && !this.mEdge.isNewRectangleOutOfBounds(Edge.TOP, rectF, f3)) {
                Edge.BOTTOM.offset(-Edge.TOP.snapToRect(rectF));
                this.mEdge.adjustCoordinate(f3);
            }
            if (Edge.BOTTOM.isOutsideMargin(rectF, f4) && !this.mEdge.isNewRectangleOutOfBounds(Edge.BOTTOM, rectF, f3)) {
                Edge.TOP.offset(-Edge.BOTTOM.snapToRect(rectF));
                this.mEdge.adjustCoordinate(f3);
            }
        }
    }

    static class CenterHandleHelper extends HandleHelper {
        CenterHandleHelper() {
            super((Edge) null, (Edge) null);
        }

        /* access modifiers changed from: package-private */
        public void updateCropWindow(float f, float f2, RectF rectF, float f3) {
            float coordinate = Edge.LEFT.getCoordinate();
            float coordinate2 = Edge.TOP.getCoordinate();
            float coordinate3 = f - ((coordinate + Edge.RIGHT.getCoordinate()) / 2.0f);
            float coordinate4 = f2 - ((coordinate2 + Edge.BOTTOM.getCoordinate()) / 2.0f);
            Edge.LEFT.offset(coordinate3);
            Edge.TOP.offset(coordinate4);
            Edge.RIGHT.offset(coordinate3);
            Edge.BOTTOM.offset(coordinate4);
            if (Edge.LEFT.isOutsideMargin(rectF, f3)) {
                Edge.RIGHT.offset(Edge.LEFT.snapToRect(rectF));
            } else if (Edge.RIGHT.isOutsideMargin(rectF, f3)) {
                Edge.LEFT.offset(Edge.RIGHT.snapToRect(rectF));
            }
            if (Edge.TOP.isOutsideMargin(rectF, f3)) {
                Edge.BOTTOM.offset(Edge.TOP.snapToRect(rectF));
            } else if (Edge.BOTTOM.isOutsideMargin(rectF, f3)) {
                Edge.TOP.offset(Edge.BOTTOM.snapToRect(rectF));
            }
        }

        /* access modifiers changed from: package-private */
        public void updateCropWindow(float f, float f2, float f3, RectF rectF, float f4) {
            updateCropWindow(f, f2, rectF, f4);
        }
    }

    static class CornerHandleHelper extends HandleHelper {
        CornerHandleHelper(Edge edge, Edge edge2) {
            super(edge, edge2);
        }

        /* access modifiers changed from: package-private */
        public void updateCropWindow(float f, float f2, float f3, RectF rectF, float f4) {
            EdgePair activeEdges = getActiveEdges(f, f2, f3);
            Edge edge = activeEdges.primary;
            Edge edge2 = activeEdges.secondary;
            edge.adjustCoordinate(f, f2, rectF, f4, f3);
            edge2.adjustCoordinate(f3);
            if (edge2.isOutsideMargin(rectF, f4)) {
                edge2.snapToRect(rectF);
                edge.adjustCoordinate(f3);
            }
        }
    }

    public enum Edge {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM;
        
        public static final int MIN_CROP_LENGTH_PX = 40;
        private float mCoordinate;

        public void setCoordinate(float f) {
            this.mCoordinate = f;
        }

        public void offset(float f) {
            this.mCoordinate += f;
        }

        public float getCoordinate() {
            return this.mCoordinate;
        }

        public void adjustCoordinate(float f, float f2, RectF rectF, float f3, float f4) {
            switch ($SWITCH_TABLE$com$chase$exam$Builder2Activity$Edge()[ordinal()]) {
                case 1:
                    this.mCoordinate = adjustLeft(f, rectF, f3, f4);
                    return;
                case 2:
                    this.mCoordinate = adjustTop(f2, rectF, f3, f4);
                    return;
                case 3:
                    this.mCoordinate = adjustRight(f, rectF, f3, f4);
                    return;
                case 4:
                    this.mCoordinate = adjustBottom(f2, rectF, f3, f4);
                    return;
                default:
                    return;
            }
        }

        public void adjustCoordinate(float f) {
            float coordinate = LEFT.getCoordinate();
            float coordinate2 = TOP.getCoordinate();
            float coordinate3 = RIGHT.getCoordinate();
            float coordinate4 = BOTTOM.getCoordinate();
            switch ($SWITCH_TABLE$com$chase$exam$Builder2Activity$Edge()[ordinal()]) {
                case 1:
                    this.mCoordinate = AspectRatioUtil.calculateLeft(coordinate2, coordinate3, coordinate4, f);
                    return;
                case 2:
                    this.mCoordinate = AspectRatioUtil.calculateTop(coordinate, coordinate3, coordinate4, f);
                    return;
                case 3:
                    this.mCoordinate = AspectRatioUtil.calculateRight(coordinate, coordinate2, coordinate4, f);
                    return;
                case 4:
                    this.mCoordinate = AspectRatioUtil.calculateBottom(coordinate, coordinate2, coordinate3, f);
                    return;
                default:
                    return;
            }
        }

        public boolean isNewRectangleOutOfBounds(Edge edge, RectF rectF, float f) {
            float snapOffset = edge.snapOffset(rectF);
            switch ($SWITCH_TABLE$com$chase$exam$Builder2Activity$Edge()[ordinal()]) {
                case 1:
                    if (edge.equals(TOP)) {
                        float f2 = rectF.top;
                        float coordinate = BOTTOM.getCoordinate() - snapOffset;
                        float coordinate2 = RIGHT.getCoordinate();
                        return isOutOfBounds(f2, AspectRatioUtil.calculateLeft(f2, coordinate2, coordinate, f), coordinate, coordinate2, rectF);
                    } else if (edge.equals(BOTTOM)) {
                        float f3 = rectF.bottom;
                        float coordinate3 = TOP.getCoordinate() - snapOffset;
                        float coordinate4 = RIGHT.getCoordinate();
                        return isOutOfBounds(coordinate3, AspectRatioUtil.calculateLeft(coordinate3, coordinate4, f3, f), f3, coordinate4, rectF);
                    }
                    break;
                case 2:
                    if (edge.equals(LEFT)) {
                        float f4 = rectF.left;
                        float coordinate5 = RIGHT.getCoordinate() - snapOffset;
                        float coordinate6 = BOTTOM.getCoordinate();
                        return isOutOfBounds(AspectRatioUtil.calculateTop(f4, coordinate5, coordinate6, f), f4, coordinate6, coordinate5, rectF);
                    } else if (edge.equals(RIGHT)) {
                        float f5 = rectF.right;
                        float coordinate7 = LEFT.getCoordinate() - snapOffset;
                        float coordinate8 = BOTTOM.getCoordinate();
                        return isOutOfBounds(AspectRatioUtil.calculateTop(coordinate7, f5, coordinate8, f), coordinate7, coordinate8, f5, rectF);
                    }
                    break;
                case 3:
                    if (edge.equals(TOP)) {
                        float f6 = rectF.top;
                        float coordinate9 = BOTTOM.getCoordinate() - snapOffset;
                        float coordinate10 = LEFT.getCoordinate();
                        return isOutOfBounds(f6, coordinate10, coordinate9, AspectRatioUtil.calculateRight(coordinate10, f6, coordinate9, f), rectF);
                    } else if (edge.equals(BOTTOM)) {
                        float f7 = rectF.bottom;
                        float coordinate11 = TOP.getCoordinate() - snapOffset;
                        float coordinate12 = LEFT.getCoordinate();
                        return isOutOfBounds(coordinate11, coordinate12, f7, AspectRatioUtil.calculateRight(coordinate12, coordinate11, f7, f), rectF);
                    }
                    break;
                case 4:
                    if (edge.equals(LEFT)) {
                        float f8 = rectF.left;
                        float coordinate13 = RIGHT.getCoordinate() - snapOffset;
                        float coordinate14 = TOP.getCoordinate();
                        return isOutOfBounds(coordinate14, f8, AspectRatioUtil.calculateBottom(f8, coordinate14, coordinate13, f), coordinate13, rectF);
                    } else if (edge.equals(RIGHT)) {
                        float f9 = rectF.right;
                        float coordinate15 = LEFT.getCoordinate() - snapOffset;
                        float coordinate16 = TOP.getCoordinate();
                        return isOutOfBounds(coordinate16, coordinate15, AspectRatioUtil.calculateBottom(coordinate15, coordinate16, f9, f), f9, rectF);
                    }
                    break;
            }
            return true;
        }

        private boolean isOutOfBounds(float f, float f2, float f3, float f4, RectF rectF) {
            return f < rectF.top || f2 < rectF.left || f3 > rectF.bottom || f4 > rectF.right;
        }

        public float snapToRect(RectF rectF) {
            float f = this.mCoordinate;
            switch ($SWITCH_TABLE$com$chase$exam$Builder2Activity$Edge()[ordinal()]) {
                case 1:
                    this.mCoordinate = rectF.left;
                    break;
                case 2:
                    this.mCoordinate = rectF.top;
                    break;
                case 3:
                    this.mCoordinate = rectF.right;
                    break;
                case 4:
                    this.mCoordinate = rectF.bottom;
                    break;
            }
            return this.mCoordinate - f;
        }

        public float snapOffset(RectF rectF) {
            float f;
            float f2 = this.mCoordinate;
            switch ($SWITCH_TABLE$com$chase$exam$Builder2Activity$Edge()[ordinal()]) {
                case 1:
                    f = rectF.left;
                    break;
                case 2:
                    f = rectF.top;
                    break;
                case 3:
                    f = rectF.right;
                    break;
                default:
                    f = rectF.bottom;
                    break;
            }
            return f - f2;
        }

        public static float getWidth() {
            return RIGHT.getCoordinate() - LEFT.getCoordinate();
        }

        public static float getHeight() {
            return BOTTOM.getCoordinate() - TOP.getCoordinate();
        }

        public boolean isOutsideMargin(RectF rectF, float f) {
            switch ($SWITCH_TABLE$com$chase$exam$Builder2Activity$Edge()[ordinal()]) {
                case 1:
                    if (this.mCoordinate - rectF.left >= f) {
                        return false;
                    }
                    return true;
                case 2:
                    if (this.mCoordinate - rectF.top >= f) {
                        return false;
                    }
                    return true;
                case 3:
                    if (rectF.right - this.mCoordinate >= f) {
                        return false;
                    }
                    return true;
                default:
                    if (rectF.bottom - this.mCoordinate < f) {
                        return true;
                    }
                    return false;
            }
        }

        private static float adjustLeft(float f, RectF rectF, float f2, float f3) {
            float f4;
            float f5 = Float.POSITIVE_INFINITY;
            if (f - rectF.left < f2) {
                return rectF.left;
            }
            if (f >= RIGHT.getCoordinate() - 40.0f) {
                f4 = RIGHT.getCoordinate() - 40.0f;
            } else {
                f4 = Float.POSITIVE_INFINITY;
            }
            if ((RIGHT.getCoordinate() - f) / f3 <= 40.0f) {
                f5 = RIGHT.getCoordinate() - (40.0f * f3);
            }
            return Math.min(f, Math.min(f4, f5));
        }

        private static float adjustRight(float f, RectF rectF, float f2, float f3) {
            float f4;
            float f5 = Float.NEGATIVE_INFINITY;
            if (rectF.right - f < f2) {
                return rectF.right;
            }
            if (f <= LEFT.getCoordinate() + 40.0f) {
                f4 = LEFT.getCoordinate() + 40.0f;
            } else {
                f4 = Float.NEGATIVE_INFINITY;
            }
            if ((f - LEFT.getCoordinate()) / f3 <= 40.0f) {
                f5 = LEFT.getCoordinate() + (40.0f * f3);
            }
            return Math.max(f, Math.max(f4, f5));
        }

        private static float adjustTop(float f, RectF rectF, float f2, float f3) {
            float f4;
            float f5 = Float.POSITIVE_INFINITY;
            if (f - rectF.top < f2) {
                return rectF.top;
            }
            if (f >= BOTTOM.getCoordinate() - 40.0f) {
                f4 = BOTTOM.getCoordinate() - 40.0f;
            } else {
                f4 = Float.POSITIVE_INFINITY;
            }
            if ((BOTTOM.getCoordinate() - f) * f3 <= 40.0f) {
                f5 = BOTTOM.getCoordinate() - (40.0f / f3);
            }
            return Math.min(f, Math.min(f4, f5));
        }

        private static float adjustBottom(float f, RectF rectF, float f2, float f3) {
            float f4;
            float f5 = Float.NEGATIVE_INFINITY;
            if (rectF.bottom - f < f2) {
                return rectF.bottom;
            }
            if (f <= TOP.getCoordinate() + 40.0f) {
                f4 = TOP.getCoordinate() + 40.0f;
            } else {
                f4 = Float.NEGATIVE_INFINITY;
            }
            if ((f - TOP.getCoordinate()) * f3 <= 40.0f) {
                f5 = TOP.getCoordinate() + (40.0f / f3);
            }
            return Math.max(f, Math.max(f5, f4));
        }
    }

    public static class EdgePair {
        public Edge primary;
        public Edge secondary;

        public EdgePair(Edge edge, Edge edge2) {
            this.primary = edge;
            this.secondary = edge2;
        }
    }

    private void _ATPHMaterialInput(View view, TextView textView, String str, String str2) {
        ((LinearLayout) view).removeView(textView);
        TextInputLayout textInputLayout = new TextInputLayout(this);
        textInputLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        textInputLayout.setPadding((int) getDip(0), (int) getDip(0), (int) getDip(0), (int) getDip(0));
        textInputLayout.setGravity(17);
        textInputLayout.setHintEnabled(true);
        textInputLayout.setHint(str);
        textInputLayout.setBoxBackgroundMode(2);
        textInputLayout.setBoxStrokeColor(-14575885);
        textInputLayout.setBoxCornerRadii(5.0f, 5.0f, 5.0f, 5.0f);
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setHintAnimationEnabled(true);
        textInputLayout.addView(textView);
        ((LinearLayout) view).addView(textInputLayout);
    }

    /* access modifiers changed from: private */
    public void _prog(boolean z, String str, String str2) {
        if (z) {
            if (this.prog == null) {
                this.prog = new ProgressDialog(this);
                this.prog.setMax(100);
                this.prog.setIndeterminate(true);
                this.prog.setCancelable(false);
                this.prog.setCanceledOnTouchOutside(false);
            }
            this.prog.setTitle(str);
            this.prog.setMessage(str2);
            this.prog.show();
        } else if (this.prog != null) {
            this.prog.dismiss();
        }
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
        this.source = FileUtil.getExternalStorageDir().concat("/Quiz Manager/".concat("/quiz/".concat(this.fname.getText().toString().trim())));
        FileUtil.writeFile(this.source, new Gson().toJson((Object) this.lmap));
        this.destination = this.source.concat(".sml");
        _zip(this.source, this.destination);
        if (FileUtil.isFile(this.destination)) {
            FileUtil.deleteFile(this.source);
        }
    }

    /* access modifiers changed from: private */
    public void _add_map() {
        if (this.sp.getString("img_value", "").equals("none")) {
            this.image1 = "none";
        } else if (this.sp.getString("img_value", "").equals("picked")) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((BitmapDrawable) this.imageview1.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            this.image1 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        }
        this.vmap = new HashMap<>();
        this.vmap.put("ques", this.ques.getText().toString().trim());
        this.vmap.put("a", this.a_.getText().toString().trim());
        this.vmap.put("b", this.b_.getText().toString().trim());
        this.vmap.put("c", this.c_.getText().toString().trim());
        this.vmap.put("d", this.d_.getText().toString().trim());
        this.vmap.put("c_a", this.correct_answer.getText().toString().toLowerCase());
        this.vmap.put("note", this.note_.getText().toString().trim());
        this.vmap.put("img1", this.image1);
        this.lmap.add(this.vmap);
        this.sp.edit().putString("img_value", "none").commit();
        ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
        SketchwareUtil.showMessage(getApplicationContext(), "Question added");
        this.ques.setText("");
        this.a_.setText("");
        this.b_.setText("");
        this.c_.setText("");
        this.d_.setText("");
        this.note_.setText("");
        this.correct_answer.setText("Select");
        this.ques.requestFocus();
        this.imageview1.setImageResource(R.drawable.ic_action_white_add_photo_5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2196F3"));
        gradientDrawable.setCornerRadius(18.0f);
        this.linear4.setBackground(gradientDrawable);
        this.linear4.setElevation(4.0f);
        this.spinner2.setSelection(0);
        this.add_img1.setVisibility(0);
        this.textview12.setText("Next page");
        if (((double) this.lmap.size()) > Double.parseDouble(this.items.getText().toString()) || ((double) this.lmap.size()) == Double.parseDouble(this.items.getText().toString())) {
            this.linear28.setEnabled(false);
            SketchwareUtil.showMessage(getApplicationContext(), "Last item added");
        }
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

        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) Builder2Activity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.b2_list, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            ImageView imageView = (ImageView) view.findViewById(R.id.edit);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.delete);
            Builder2Activity.this.vmap = (HashMap) Builder2Activity.this.lmap.get(i);
            ((TextView) view.findViewById(R.id.textview2)).setText(String.valueOf((long) (i + 1)).concat("."));
            ((TextView) view.findViewById(R.id.textview1)).setText(Builder2Activity.this.vmap.get("ques").toString());
            ((LinearLayout) view.findViewById(R.id.linear2)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Builder2Activity.this.del.setMessage("Delete item?");
                    AlertDialog.Builder access$3 = Builder2Activity.this.del;
                    final int i = i;
                    access$3.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Builder2Activity.this.lmap.remove(i);
                            Listview1Adapter.this.notifyDataSetChanged();
                            Builder2Activity.this.linear28.setEnabled(true);
                            SketchwareUtil.showMessage(Builder2Activity.this.getApplicationContext(), "Deleted");
                        }
                    });
                    Builder2Activity.this.del.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    Builder2Activity.this.del.create().show();
                }
            });
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
