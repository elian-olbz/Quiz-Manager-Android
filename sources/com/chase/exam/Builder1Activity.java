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
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpStatus;

public class Builder1Activity extends AppCompatActivity {
    public final int REQ_CD_CHOOSE = HttpStatus.SC_SWITCHING_PROTOCOLS;
    /* access modifiers changed from: private */
    public Timer _timer = new Timer();
    /* access modifiers changed from: private */
    public ObjectAnimator a = new ObjectAnimator();
    private TextView add_img1;
    private TextView btn_save;
    /* access modifiers changed from: private */
    public Intent choose = new Intent("android.intent.action.GET_CONTENT");
    private String coverImg = "";
    /* access modifiers changed from: private */
    public AlertDialog crop_dialog;
    /* access modifiers changed from: private */
    public CropImageView crp;
    /* access modifiers changed from: private */
    public AlertDialog.Builder del;
    /* access modifiers changed from: private */
    public EditText desc_;
    private String descrp = "";
    /* access modifiers changed from: private */
    public TextView disp_duration;
    /* access modifiers changed from: private */
    public TextView disp_items;
    private String durat = "";
    /* access modifiers changed from: private */
    public AlertDialog.Builder edit;
    /* access modifiers changed from: private */
    public ImageView edit_duration;
    /* access modifiers changed from: private */
    public ImageView edit_items;
    /* access modifiers changed from: private */
    public AlertDialog.Builder exit;
    /* access modifiers changed from: private */
    public String imageString = "";
    /* access modifiers changed from: private */
    public ImageView imageview1;
    /* access modifiers changed from: private */
    public ImageView imageview10;
    /* access modifiers changed from: private */
    public ImageView imageview11;
    private ImageView imageview3;
    private ImageView imageview9;
    /* access modifiers changed from: private */
    public Intent in = new Intent();
    private String items = "";
    private LinearLayout lin;
    private LinearLayout lin_des;
    private LinearLayout lin_dura;
    private LinearLayout lin_items;
    private LinearLayout lin_name;
    private LinearLayout lincrope;
    private LinearLayout linear1;
    private LinearLayout linear16;
    private LinearLayout linear17;
    /* access modifiers changed from: private */
    public LinearLayout linear19;
    private LinearLayout linear2;
    private LinearLayout linear22;
    private LinearLayout linear23;
    private LinearLayout linear24;
    /* access modifiers changed from: private */
    public LinearLayout linear25;
    private LinearLayout linear26;
    private LinearLayout linear28;
    private LinearLayout linear29;
    private LinearLayout linear4;
    private ArrayList<String> list = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public CheckBox lock;
    /* access modifiers changed from: private */
    public TextView min_unit;
    private String name = "";
    /* access modifiers changed from: private */
    public EditText name_;
    /* access modifiers changed from: private */
    public EditText pass;
    private ProgressDialog prog;
    /* access modifiers changed from: private */
    public EditText qname_;
    private String quizConf = "";
    /* access modifiers changed from: private */
    public double s = 0.0d;
    /* access modifiers changed from: private */
    public SharedPreferences sp;
    /* access modifiers changed from: private */
    public TimerTask t;
    private TextView textview1;
    private TextView textview7;
    private TextView textview8;
    private TextView textview9;
    /* access modifiers changed from: private */
    public HashMap<String, Object> vmap = new HashMap<>();
    private ScrollView vscroll2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.builder1);
        initialize(bundle);
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1000);
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
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
        this.linear19 = (LinearLayout) findViewById(R.id.linear19);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.imageview10 = (ImageView) findViewById(R.id.imageview10);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.lin_name = (LinearLayout) findViewById(R.id.lin_name);
        this.lin_des = (LinearLayout) findViewById(R.id.lin_des);
        this.lin_dura = (LinearLayout) findViewById(R.id.lin_dura);
        this.lin_items = (LinearLayout) findViewById(R.id.lin_items);
        this.linear26 = (LinearLayout) findViewById(R.id.linear26);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.add_img1 = (TextView) findViewById(R.id.add_img1);
        this.linear16 = (LinearLayout) findViewById(R.id.linear16);
        this.linear17 = (LinearLayout) findViewById(R.id.linear17);
        this.name_ = (EditText) findViewById(R.id.name_);
        this.qname_ = (EditText) findViewById(R.id.qname_);
        this.linear28 = (LinearLayout) findViewById(R.id.linear28);
        this.desc_ = (EditText) findViewById(R.id.desc_);
        this.textview7 = (TextView) findViewById(R.id.textview7);
        this.disp_duration = (TextView) findViewById(R.id.disp_duration);
        this.min_unit = (TextView) findViewById(R.id.min_unit);
        this.linear22 = (LinearLayout) findViewById(R.id.linear22);
        this.edit_duration = (ImageView) findViewById(R.id.edit_duration);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.disp_items = (TextView) findViewById(R.id.disp_items);
        this.linear23 = (LinearLayout) findViewById(R.id.linear23);
        this.edit_items = (ImageView) findViewById(R.id.edit_items);
        this.linear24 = (LinearLayout) findViewById(R.id.linear24);
        this.linear25 = (LinearLayout) findViewById(R.id.linear25);
        this.lock = (CheckBox) findViewById(R.id.lock);
        this.linear29 = (LinearLayout) findViewById(R.id.linear29);
        this.imageview11 = (ImageView) findViewById(R.id.imageview11);
        this.pass = (EditText) findViewById(R.id.pass);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.imageview9 = (ImageView) findViewById(R.id.imageview9);
        this.exit = new AlertDialog.Builder(this);
        this.edit = new AlertDialog.Builder(this);
        this.sp = getSharedPreferences("sp", 0);
        this.del = new AlertDialog.Builder(this);
        this.choose.setType("image/*");
        this.choose.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        this.linear19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder1Activity.this.a.setTarget(Builder1Activity.this.linear19);
                Builder1Activity.this.a.setPropertyName("alpha");
                Builder1Activity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                Builder1Activity.this.a.setDuration(600);
                Builder1Activity.this.a.setRepeatMode(2);
                Builder1Activity.this.a.setRepeatCount(0);
                Builder1Activity.this.a.start();
                if (Builder1Activity.this.sp.getString("cover_value", "").equals("none")) {
                    Builder1Activity.this.imageString = "none";
                } else if (Builder1Activity.this.sp.getString("cover_value", "").equals("picked")) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((BitmapDrawable) Builder1Activity.this.imageview1.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    Builder1Activity.this.imageString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                }
                if (Builder1Activity.this.name_.getText().toString().trim().equals("") || Builder1Activity.this.qname_.getText().toString().trim().equals("") || Builder1Activity.this.desc_.getText().toString().trim().equals("") || Builder1Activity.this.disp_duration.getText().toString().trim().equals("") || Builder1Activity.this.disp_items.getText().toString().trim().equals("")) {
                    SketchwareUtil.showMessage(Builder1Activity.this.getApplicationContext(), "Please fill in all fields");
                    if (Builder1Activity.this.disp_duration.getText().toString().trim().equals("")) {
                        Builder1Activity.this.edit_duration.setColorFilter(-769226, PorterDuff.Mode.MULTIPLY);
                    } else {
                        Builder1Activity.this.edit_duration.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
                    }
                    if (Builder1Activity.this.disp_items.getText().toString().trim().equals("")) {
                        Builder1Activity.this.edit_items.setColorFilter(-769226, PorterDuff.Mode.MULTIPLY);
                    } else {
                        Builder1Activity.this.edit_items.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
                    }
                    if (Builder1Activity.this.name_.getText().toString().trim().equals("")) {
                        Builder1Activity.this.name_.setError("Input name");
                    }
                    if (Builder1Activity.this.qname_.getText().toString().trim().equals("")) {
                        Builder1Activity.this.qname_.setError("Input quiz name");
                    }
                    if (Builder1Activity.this.desc_.getText().toString().trim().equals("")) {
                        Builder1Activity.this.desc_.setError("Set a description");
                    }
                } else if (!Builder1Activity.this.lock.isChecked()) {
                    Builder1Activity.this.exit.setTitle("Save");
                    Builder1Activity.this.exit.setMessage("Proceed to question editor?");
                    Builder1Activity.this.exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Builder1Activity.this.vmap = new HashMap();
                            Builder1Activity.this.vmap.put("sec", "none");
                            Builder1Activity.this._write_map();
                            Builder1Activity.this.lmap.add(Builder1Activity.this.vmap);
                            Builder1Activity.this.sp.edit().putString("cover_value", "none").commit();
                            Builder1Activity.this.sp.edit().putString("data", new Gson().toJson((Object) Builder1Activity.this.lmap)).commit();
                            Builder1Activity.this.sp.edit().putString("title", Builder1Activity.this.qname_.getText().toString().trim()).commit();
                            Builder1Activity.this.in.setClass(Builder1Activity.this.getApplicationContext(), Builder2Activity.class);
                            Builder1Activity.this.startActivity(Builder1Activity.this.in);
                            Builder1Activity.this.finish();
                        }
                    });
                    Builder1Activity.this.exit.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    Builder1Activity.this.exit.create().show();
                } else if (Builder1Activity.this.pass.getText().toString().trim().equals("")) {
                    Builder1Activity.this.pass.setError("Password is empty");
                } else if (Builder1Activity.this.pass.getText().toString().trim().length() < 4) {
                    Builder1Activity.this.pass.setError("Password too short");
                } else {
                    Builder1Activity.this.exit.setTitle("Save");
                    Builder1Activity.this.exit.setMessage("Proceed to question editor?");
                    Builder1Activity.this.exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Builder1Activity.this.vmap = new HashMap();
                            Builder1Activity.this.vmap.put("sec", Builder1Activity.this.pass.getText().toString());
                            Builder1Activity.this._write_map();
                            Builder1Activity.this.lmap.add(Builder1Activity.this.vmap);
                            Builder1Activity.this.sp.edit().putString("cover_value", "none").commit();
                            Builder1Activity.this.sp.edit().putString("data", new Gson().toJson((Object) Builder1Activity.this.lmap)).commit();
                            Builder1Activity.this.sp.edit().putString("title", Builder1Activity.this.qname_.getText().toString().trim()).commit();
                            Builder1Activity.this.in.setClass(Builder1Activity.this.getApplicationContext(), Builder2Activity.class);
                            Builder1Activity.this.startActivity(Builder1Activity.this.in);
                            Builder1Activity.this.finish();
                        }
                    });
                    Builder1Activity.this.exit.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    Builder1Activity.this.exit.create().show();
                }
            }
        });
        this.imageview3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!Builder1Activity.this.name_.getText().toString().equals("") || !Builder1Activity.this.qname_.getText().toString().equals("") || !Builder1Activity.this.desc_.getText().toString().equals("") || !Builder1Activity.this.disp_duration.getText().toString().equals("") || !Builder1Activity.this.disp_items.getText().toString().equals("")) {
                    Builder1Activity.this.exit.setTitle("Exit");
                    Builder1Activity.this.exit.setMessage("Discard Quiz configuration?");
                    Builder1Activity.this.exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Builder1Activity.this.finish();
                        }
                    });
                    Builder1Activity.this.exit.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    Builder1Activity.this.exit.create().show();
                    return;
                }
                Builder1Activity.this.finish();
            }
        });
        this.imageview10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!Builder1Activity.this.name_.getText().toString().trim().equals("") || !Builder1Activity.this.qname_.getText().toString().trim().equals("") || !Builder1Activity.this.desc_.getText().toString().trim().equals("") || !Builder1Activity.this.disp_duration.getText().toString().trim().equals("") || !Builder1Activity.this.disp_items.getText().toString().trim().equals("")) {
                    Builder1Activity.this.a.setTarget(Builder1Activity.this.imageview10);
                    Builder1Activity.this.a.setPropertyName("alpha");
                    Builder1Activity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                    Builder1Activity.this.a.setDuration(600);
                    Builder1Activity.this.a.setRepeatMode(2);
                    Builder1Activity.this.a.setRepeatCount(0);
                    Builder1Activity.this.a.start();
                    Builder1Activity.this.del.setTitle("Delete");
                    Builder1Activity.this.del.setMessage("Clear changes?");
                    Builder1Activity.this.del.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Builder1Activity.this._prog(true, "", "Please wait");
                            Builder1Activity.this.t = new TimerTask() {
                                public void run() {
                                    Builder1Activity.this.runOnUiThread(new Runnable() {
                                        public void run() {
                                            Builder1Activity.this._prog(false, "", "");
                                            Builder1Activity.this.in.setClass(Builder1Activity.this.getApplicationContext(), Builder1Activity.class);
                                            Builder1Activity.this.startActivity(Builder1Activity.this.in);
                                            Builder1Activity.this.finish();
                                        }
                                    });
                                }
                            };
                            Builder1Activity.this._timer.schedule(Builder1Activity.this.t, 2000);
                        }
                    });
                    Builder1Activity.this.del.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    Builder1Activity.this.del.create().show();
                }
            }
        });
        this.linear4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder1Activity.this.startActivityForResult(Builder1Activity.this.choose, HttpStatus.SC_SWITCHING_PROTOCOLS);
            }
        });
        this.lin_dura.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder1Activity.this.edit.setMessage("Set quiz duration (in minutes)");
                final EditText editText = new EditText(Builder1Activity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                editText.setInputType(2);
                editText.setLayoutParams(layoutParams);
                Builder1Activity.this.edit.setView(editText);
                Builder1Activity.this.edit.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Builder1Activity.this.disp_duration.setText(editText.getText());
                        Builder1Activity.this.disp_duration.setVisibility(0);
                        Builder1Activity.this.min_unit.setVisibility(0);
                    }
                });
                Builder1Activity.this.edit.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                Builder1Activity.this.edit.create().show();
            }
        });
        this.lin_items.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder1Activity.this.edit.setMessage("Set the no. of items");
                final EditText editText = new EditText(Builder1Activity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                editText.setInputType(2);
                editText.setLayoutParams(layoutParams);
                Builder1Activity.this.edit.setView(editText);
                Builder1Activity.this.edit.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Builder1Activity.this.disp_items.setText(editText.getText());
                        Builder1Activity.this.disp_items.setVisibility(0);
                    }
                });
                Builder1Activity.this.edit.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                Builder1Activity.this.edit.create().show();
            }
        });
        this.edit_duration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder1Activity.this.a.setTarget(Builder1Activity.this.edit_duration);
                Builder1Activity.this.a.setPropertyName("alpha");
                Builder1Activity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                Builder1Activity.this.a.setDuration(600);
                Builder1Activity.this.a.setRepeatMode(2);
                Builder1Activity.this.a.setRepeatCount(0);
                Builder1Activity.this.a.start();
                Builder1Activity.this.edit.setMessage("Set quiz duration (in minutes)");
                final EditText editText = new EditText(Builder1Activity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                editText.setInputType(2);
                editText.setLayoutParams(layoutParams);
                Builder1Activity.this.edit.setView(editText);
                Builder1Activity.this.edit.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Builder1Activity.this.disp_duration.setText(editText.getText());
                        Builder1Activity.this.disp_duration.setVisibility(0);
                        Builder1Activity.this.min_unit.setVisibility(0);
                    }
                });
                Builder1Activity.this.edit.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                Builder1Activity.this.edit.create().show();
            }
        });
        this.edit_items.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Builder1Activity.this.a.setTarget(Builder1Activity.this.edit_items);
                Builder1Activity.this.a.setPropertyName("alpha");
                Builder1Activity.this.a.setFloatValues(new float[]{0.0f, 1.0f});
                Builder1Activity.this.a.setDuration(600);
                Builder1Activity.this.a.setRepeatMode(2);
                Builder1Activity.this.a.setRepeatCount(0);
                Builder1Activity.this.a.start();
                Builder1Activity.this.edit.setMessage("Set the no. of items");
                final EditText editText = new EditText(Builder1Activity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                editText.setInputType(2);
                editText.setLayoutParams(layoutParams);
                Builder1Activity.this.edit.setView(editText);
                Builder1Activity.this.edit.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Builder1Activity.this.disp_items.setText(editText.getText());
                        Builder1Activity.this.disp_items.setVisibility(0);
                    }
                });
                Builder1Activity.this.edit.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                Builder1Activity.this.edit.create().show();
            }
        });
        this.lock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Builder1Activity.this.lock.isChecked()) {
                    Builder1Activity.this.linear25.setVisibility(0);
                    Builder1Activity.this.pass.requestFocus();
                    return;
                }
                Builder1Activity.this.linear25.setVisibility(8);
            }
        });
        this.imageview11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Builder1Activity.this.s == 0.0d) {
                    Builder1Activity.this.imageview11.setImageResource(R.drawable.ic_visibility_grey);
                    Builder1Activity builder1Activity = Builder1Activity.this;
                    builder1Activity.s = builder1Activity.s + 1.0d;
                    Builder1Activity.this.pass.setInputType(1);
                    return;
                }
                Builder1Activity.this.imageview11.setImageResource(R.drawable.ic_visibility_off_grey);
                Builder1Activity.this.s = 0.0d;
                Builder1Activity.this.pass.setInputType(129);
            }
        });
    }

    private void initializeLogic() {
        setTitle("Quiz Configuration");
        _ATPHMaterialInput(this.linear16, this.name_, "Name:", "Name");
        _ATPHMaterialInput(this.linear17, this.qname_, "Quiz Name:", "qname:");
        _ATPHMaterialInput(this.linear28, this.desc_, "Subject/Description:", "desc");
        _ATPHMaterialInput(this.linear29, this.pass, "Password:", "pass_");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadius(18.0f);
        this.lin_dura.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable2.setCornerRadius(18.0f);
        this.lin_items.setBackground(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable3.setCornerRadius(18.0f);
        this.lin_des.setBackground(gradientDrawable3);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable4.setCornerRadius(18.0f);
        this.lin_name.setBackground(gradientDrawable4);
        GradientDrawable gradientDrawable5 = new GradientDrawable();
        gradientDrawable5.setColor(Color.parseColor("#2196F3"));
        gradientDrawable5.setCornerRadius(18.0f);
        this.linear4.setBackground(gradientDrawable5);
        GradientDrawable gradientDrawable6 = new GradientDrawable();
        gradientDrawable6.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable6.setCornerRadius(18.0f);
        this.linear26.setBackground(gradientDrawable6);
        this.linear26.setElevation(4.0f);
        this.lin_dura.setElevation(4.0f);
        this.lin_items.setElevation(4.0f);
        this.lin_des.setElevation(4.0f);
        this.lin_name.setElevation(4.0f);
        this.linear1.setElevation(4.0f);
        this.linear4.setElevation(4.0f);
        this.disp_items.setVisibility(4);
        this.min_unit.setVisibility(4);
        this.disp_duration.setVisibility(4);
        this.linear25.setVisibility(8);
        this.edit_duration.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        this.edit_items.setColorFilter(-14575885, PorterDuff.Mode.MULTIPLY);
        this.sp.edit().putString("cover_value", "none").commit();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case HttpStatus.SC_SWITCHING_PROTOCOLS /*101*/:
                if (i2 == -1) {
                    ArrayList arrayList = new ArrayList();
                    if (intent != null) {
                        if (intent.getClipData() != null) {
                            for (int i3 = 0; i3 < intent.getClipData().getItemCount(); i3++) {
                                arrayList.add(FileUtil.convertUriToFilePath(getApplicationContext(), intent.getClipData().getItemAt(i3).getUri()));
                            }
                        } else {
                            arrayList.add(FileUtil.convertUriToFilePath(getApplicationContext(), intent.getData()));
                        }
                    }
                    _showSelection((String) arrayList.get(0));
                    this.linear4.setBackgroundResource(0);
                    this.add_img1.setVisibility(4);
                    this.sp.edit().putString("cover_value", "picked").commit();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onBackPressed() {
        if (!this.name_.getText().toString().equals("") || !this.qname_.getText().toString().equals("") || !this.desc_.getText().toString().equals("") || !this.disp_duration.getText().toString().equals("") || !this.disp_items.getText().toString().equals("")) {
            this.exit.setTitle("Exit");
            this.exit.setMessage("Discard Quiz configuration?");
            this.exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Builder1Activity.this.finish();
                }
            });
            this.exit.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.exit.create().show();
            return;
        }
        finish();
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
                    Builder1Activity.this.imageview1.setImageBitmap(Builder1Activity.this.crp.getCroppedImage());
                    Builder1Activity.this.showMessage("Done");
                    Builder1Activity.this.crop_dialog.dismiss();
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
        private static /* synthetic */ int[] $SWITCH_TABLE$com$chase$exam$Builder1Activity$Handle;

        static /* synthetic */ int[] $SWITCH_TABLE$com$chase$exam$Builder1Activity$Handle() {
            int[] iArr = $SWITCH_TABLE$com$chase$exam$Builder1Activity$Handle;
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
                $SWITCH_TABLE$com$chase$exam$Builder1Activity$Handle = iArr;
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
            switch ($SWITCH_TABLE$com$chase$exam$Builder1Activity$Handle()[handle.ordinal()]) {
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
            switch ($SWITCH_TABLE$com$chase$exam$Builder1Activity$Edge()[ordinal()]) {
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
            switch ($SWITCH_TABLE$com$chase$exam$Builder1Activity$Edge()[ordinal()]) {
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
            switch ($SWITCH_TABLE$com$chase$exam$Builder1Activity$Edge()[ordinal()]) {
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
            switch ($SWITCH_TABLE$com$chase$exam$Builder1Activity$Edge()[ordinal()]) {
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
            switch ($SWITCH_TABLE$com$chase$exam$Builder1Activity$Edge()[ordinal()]) {
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
            switch ($SWITCH_TABLE$com$chase$exam$Builder1Activity$Edge()[ordinal()]) {
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

    /* access modifiers changed from: private */
    public void _write_map() {
        this.vmap.put("name", this.name_.getText().toString().trim());
        this.vmap.put("qname", this.qname_.getText().toString().trim());
        this.vmap.put("desc", this.desc_.getText().toString().trim());
        this.vmap.put("dura", this.disp_duration.getText().toString().trim());
        this.vmap.put("items", this.disp_items.getText().toString().trim());
        this.vmap.put("img", this.imageString);
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
