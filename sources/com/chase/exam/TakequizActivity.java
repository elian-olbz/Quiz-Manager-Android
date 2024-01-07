package com.chase.exam;

import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import org.apache.http.HttpStatus;

public class TakequizActivity extends AppCompatActivity {
    public final int REQ_CD_SFP = HttpStatus.SC_SWITCHING_PROTOCOLS;
    private Timer _timer = new Timer();
    private Toolbar _toolbar;
    /* access modifiers changed from: private */
    public ObjectAnimator an = new ObjectAnimator();
    /* access modifiers changed from: private */
    public Button button2;
    /* access modifiers changed from: private */
    public EditText col;
    private String cover = "";
    /* access modifiers changed from: private */
    public AlertDialog.Builder d;
    private TextView desc;
    private TextView dura;
    /* access modifiers changed from: private */
    public EditText edittext3;
    private String hint1 = "";
    /* access modifiers changed from: private */
    public EditText hs;
    private Intent i = new Intent();
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview3;
    private TextView items;
    private ArrayList<String> level_list = new ArrayList<>();
    private LinearLayout linear1;
    /* access modifiers changed from: private */
    public LinearLayout linear10;
    private LinearLayout linear14;
    private LinearLayout linear15;
    private LinearLayout linear16;
    private LinearLayout linear18;
    private LinearLayout linear19;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear7;
    private LinearLayout linear8;
    /* access modifiers changed from: private */
    public LinearLayout linear9;
    /* access modifiers changed from: private */
    public LinearLayout linear_col;
    /* access modifiers changed from: private */
    public LinearLayout linear_hs;
    private TextView name;
    private ArrayList<HashMap<String, Object>> olmap = new ArrayList<>();
    private HashMap<String, Object> omap = new HashMap<>();
    private String path = "";
    private String path2 = "";
    private ProgressDialog prog;
    private TextView qname;
    private String quiz = "";
    /* access modifiers changed from: private */
    public Intent sfp = new Intent("android.intent.action.GET_CONTENT");
    /* access modifiers changed from: private */
    public SharedPreferences sp;
    private Spinner spinner2;
    private TimerTask t;
    private TextView textview12;
    private TextView textview13;
    private TextView textview15;
    private String unit = "";
    private String unzipped_path = "";
    private ScrollView vscroll1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.takequiz);
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
        this._toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(this._toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this._toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TakequizActivity.this.onBackPressed();
            }
        });
        this.vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
        this.linear8 = (LinearLayout) findViewById(R.id.linear8);
        this.linear14 = (LinearLayout) findViewById(R.id.linear14);
        this.linear7 = (LinearLayout) findViewById(R.id.linear7);
        this.linear19 = (LinearLayout) findViewById(R.id.linear19);
        this.button2 = (Button) findViewById(R.id.button2);
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.imageview1 = (ImageView) findViewById(R.id.imageview1);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.qname = (TextView) findViewById(R.id.qname);
        this.desc = (TextView) findViewById(R.id.desc);
        this.name = (TextView) findViewById(R.id.name);
        this.items = (TextView) findViewById(R.id.items);
        this.dura = (TextView) findViewById(R.id.dura);
        this.linear18 = (LinearLayout) findViewById(R.id.linear18);
        this.linear16 = (LinearLayout) findViewById(R.id.linear16);
        this.linear15 = (LinearLayout) findViewById(R.id.linear15);
        this.linear_hs = (LinearLayout) findViewById(R.id.linear_hs);
        this.linear_col = (LinearLayout) findViewById(R.id.linear_col);
        this.edittext3 = (EditText) findViewById(R.id.edittext3);
        this.textview15 = (TextView) findViewById(R.id.textview15);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);
        this.hs = (EditText) findViewById(R.id.hs);
        this.col = (EditText) findViewById(R.id.col);
        this.linear9 = (LinearLayout) findViewById(R.id.linear9);
        this.linear10 = (LinearLayout) findViewById(R.id.linear10);
        this.imageview2 = (ImageView) findViewById(R.id.imageview2);
        this.textview12 = (TextView) findViewById(R.id.textview12);
        this.imageview3 = (ImageView) findViewById(R.id.imageview3);
        this.textview13 = (TextView) findViewById(R.id.textview13);
        this.sfp.setType("application/octet-stream");
        this.sfp.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        this.d = new AlertDialog.Builder(this);
        this.sp = getSharedPreferences("sp", 0);
        this.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TakequizActivity.this.an.setTarget(TakequizActivity.this.button2);
                TakequizActivity.this.an.setPropertyName("alpha");
                TakequizActivity.this.an.setFloatValues(new float[]{0.0f, 1.0f});
                TakequizActivity.this.an.setDuration(600);
                TakequizActivity.this.an.setRepeatMode(2);
                TakequizActivity.this.an.setRepeatCount(0);
                TakequizActivity.this.an.start();
                if (!TakequizActivity.this.sp.getString("mode", "").equals("quiz")) {
                    TakequizActivity.this._rev_mode();
                    TakequizActivity.this.finish();
                } else if (TakequizActivity.this.edittext3.getText().toString().trim().equals("") || (TakequizActivity.this.hs.getText().toString().trim().equals("") && TakequizActivity.this.col.getText().toString().trim().equals(""))) {
                    if (TakequizActivity.this.edittext3.getText().toString().trim().equals("")) {
                        TakequizActivity.this.edittext3.setError("Input name");
                    }
                    if (TakequizActivity.this.hs.getText().toString().trim().equals("")) {
                        TakequizActivity.this.hs.setError("Input details");
                    }
                    if (TakequizActivity.this.col.getText().toString().trim().equals("")) {
                        TakequizActivity.this.col.setError("Input details");
                    }
                    SketchwareUtil.showMessage(TakequizActivity.this.getApplicationContext(), "Please fill in all fields");
                } else {
                    TakequizActivity.this.sp.edit().putString("s_name", TakequizActivity.this.edittext3.getText().toString()).commit();
                    if (TakequizActivity.this.hs.isEnabled()) {
                        TakequizActivity.this.sp.edit().putString("s_inf", TakequizActivity.this.hs.getText().toString()).commit();
                    } else if (TakequizActivity.this.col.isEnabled()) {
                        TakequizActivity.this.sp.edit().putString("s_inf", TakequizActivity.this.col.getText().toString()).commit();
                    }
                    TakequizActivity.this._quiz_mode();
                    TakequizActivity.this.finish();
                }
            }
        });
        this.spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    TakequizActivity.this.linear_hs.setVisibility(0);
                    TakequizActivity.this.linear_col.setVisibility(8);
                    TakequizActivity.this.hs.setEnabled(true);
                    TakequizActivity.this.col.setEnabled(false);
                    TakequizActivity.this.col.setText("");
                    return;
                }
                if (i == 1) {
                    TakequizActivity.this.linear_hs.setVisibility(0);
                    TakequizActivity.this.linear_col.setVisibility(8);
                    TakequizActivity.this.hs.setEnabled(true);
                    TakequizActivity.this.col.setEnabled(true);
                    TakequizActivity.this.col.setText("");
                }
                if (i == 2) {
                    TakequizActivity.this.linear_hs.setVisibility(8);
                    TakequizActivity.this.linear_col.setVisibility(0);
                    TakequizActivity.this.col.setEnabled(true);
                    TakequizActivity.this.hs.setEnabled(false);
                    TakequizActivity.this.hs.setText("");
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.linear9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TakequizActivity.this.an.setTarget(TakequizActivity.this.linear9);
                TakequizActivity.this.an.setPropertyName("alpha");
                TakequizActivity.this.an.setFloatValues(new float[]{0.0f, 1.0f});
                TakequizActivity.this.an.setDuration(500);
                TakequizActivity.this.an.setRepeatMode(2);
                TakequizActivity.this.an.setRepeatCount(0);
                TakequizActivity.this.an.start();
                TakequizActivity.this.d.setTitle("Select mode");
                TakequizActivity.this.d.setMessage("Please select to continue.");
                TakequizActivity.this.d.setPositiveButton("Quiz", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TakequizActivity.this.sp.edit().putString("mode", "quiz").commit();
                        TakequizActivity.this.setTitle("Quiz Mode");
                    }
                });
                TakequizActivity.this.d.setNegativeButton("Review", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TakequizActivity.this.sp.edit().putString("mode", "game").commit();
                        TakequizActivity.this.setTitle("Review Mode");
                    }
                });
                TakequizActivity.this.d.create().show();
            }
        });
        this.linear10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TakequizActivity.this.an.setTarget(TakequizActivity.this.linear10);
                TakequizActivity.this.an.setPropertyName("alpha");
                TakequizActivity.this.an.setFloatValues(new float[]{0.0f, 1.0f});
                TakequizActivity.this.an.setDuration(500);
                TakequizActivity.this.an.setRepeatMode(2);
                TakequizActivity.this.an.setRepeatCount(0);
                TakequizActivity.this.an.start();
                TakequizActivity.this.startActivityForResult(TakequizActivity.this.sfp, HttpStatus.SC_SWITCHING_PROTOCOLS);
            }
        });
    }

    private void initializeLogic() {
        startActivityForResult(this.sfp, HttpStatus.SC_SWITCHING_PROTOCOLS);
        setTitle("Quiz Mode");
        _ATPHMaterialInput(this.linear16, this.edittext3, "Name:", "nm");
        _ATPHMaterialInput(this.linear_hs, this.hs, "Grade/Section:", "hs_");
        this.linear_col.setVisibility(8);
        _ATPHMaterialInput(this.linear_col, this.col, "Course/Year/Block:", "col_");
        CardView cardView = new CardView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(9, 9, 9, 9);
        cardView.setLayoutParams(layoutParams);
        cardView.setCardBackgroundColor(-1);
        cardView.setRadius(18.0f);
        cardView.setCardElevation(4.0f);
        cardView.setMaxCardElevation(6.0f);
        cardView.setPreventCornerOverlap(true);
        ((ViewGroup) this.linear1.getParent()).removeView(this.linear1);
        this.linear7.removeAllViews();
        this.linear7.addView(cardView);
        cardView.addView(this.linear1);
        CardView cardView2 = new CardView(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(9, 9, 9, 9);
        cardView2.setLayoutParams(layoutParams2);
        cardView2.setCardBackgroundColor(-1);
        cardView2.setRadius(18.0f);
        cardView2.setCardElevation(4.0f);
        cardView2.setMaxCardElevation(6.0f);
        cardView2.setPreventCornerOverlap(true);
        ((ViewGroup) this.linear18.getParent()).removeView(this.linear18);
        this.linear19.removeAllViews();
        this.linear19.addView(cardView2);
        cardView2.addView(this.linear18);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2196F3"));
        gradientDrawable.setCornerRadius(10.0f);
        this.button2.setBackground(gradientDrawable);
        this.button2.setElevation(8.0f);
        this.d.setTitle("Select mode");
        this.d.setMessage("Please select to continue.");
        this.d.setPositiveButton("Quiz", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                TakequizActivity.this.sp.edit().putString("mode", "quiz").commit();
                TakequizActivity.this.setTitle("Quiz Mode");
            }
        });
        this.d.setNegativeButton("Review", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                TakequizActivity.this.sp.edit().putString("mode", "review").commit();
                TakequizActivity.this.setTitle("Review Mode");
            }
        });
        this.d.create().show();
        this.level_list.add("Elementary");
        this.level_list.add("High School");
        this.level_list.add("College");
        this.spinner2.setAdapter(new ArrayAdapter(this, 17367043, 16908308, this.level_list) {
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
                    _prog(true, "Importing file", "Please wait");
                    this.path = (String) arrayList.get(0);
                    if (this.path.endsWith(".sml")) {
                        _read_zip();
                    } else {
                        SketchwareUtil.showMessage(getApplicationContext(), "Invalid file");
                        startActivityForResult(this.sfp, HttpStatus.SC_SWITCHING_PROTOCOLS);
                    }
                    this.t = new TimerTask() {
                        public void run() {
                            TakequizActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    TakequizActivity.this._prog(false, "", "");
                                }
                            });
                        }
                    };
                    this._timer.schedule(this.t, 5000);
                    return;
                }
                finish();
                return;
            default:
                return;
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

    private void _CardStyle(View view, double d2, double d3, String str, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius((float) ((int) d3));
        new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#f44336")}), (Drawable) null, (Drawable) null);
        view.setBackground(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation((float) ((int) d2));
        }
    }

    private void _read_zip() {
        _Unzip(this.path);
        this.path2 = this.path.substring(0, this.path.length() - 4);
        this.unzipped_path = this.path2.concat("/".concat(Uri.parse(this.path2).getLastPathSegment()));
        if (FileUtil.isFile(this.unzipped_path)) {
            this.quiz = FileUtil.readFile(this.unzipped_path);
            if (!this.quiz.contains("sec") || !this.quiz.contains("name") || !this.quiz.contains("qname") || !this.quiz.contains("desc") || !this.quiz.contains("dura") || !this.quiz.contains("items") || !this.quiz.contains("img")) {
                SketchwareUtil.showMessage(getApplicationContext(), "Invalid file");
                finish();
            } else {
                this.olmap = (ArrayList) new Gson().fromJson(this.quiz, new TypeToken<ArrayList<HashMap<String, Object>>>() {
                }.getType());
                this.omap = this.olmap.get(this.olmap.size() - 1);
                this.cover = this.omap.get("img").toString();
                if (this.cover.equals("none")) {
                    this.imageview1.setImageResource(R.drawable.up_);
                } else {
                    byte[] decode = Base64.decode(this.cover, 0);
                    this.imageview1.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                }
                if (Double.parseDouble(this.omap.get("items").toString()) > 1.0d) {
                    this.unit = "items";
                } else {
                    this.unit = "item";
                }
                this.qname.setText(this.omap.get("qname").toString());
                this.desc.setText(this.omap.get("desc").toString());
                this.name.setText(this.omap.get("name").toString());
                this.dura.setText(this.omap.get("dura").toString().concat("min."));
                this.items.setText(this.omap.get("items").toString().concat(" ".concat(this.unit)));
                this.sp.edit().putString("sec", this.omap.get("dura").toString()).commit();
                this.sp.edit().putString("dura", this.omap.get("sec").toString()).commit();
            }
            FileUtil.deleteFile(this.path2);
        }
    }

    private void _Unzip(String str) {
        new ZipMan();
        ZipMan.Unzip(str);
    }

    public static class ZipMan {
        public static void main(String[] strArr) throws Exception {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("/sdcard/aan.zip"));
            zipOutputStream.setLevel(9);
            System.out.println("Begin to compress folder : " + "/sdcard/aan" + " to " + "/sdcard/aan.zip");
            _Zip(zipOutputStream, "/sdcard/aan", "/sdcard/aan");
            zipOutputStream.close();
            System.out.println("Program ended successfully!");
        }

        private static void _Zip(ZipOutputStream zipOutputStream, String str, String str2) throws Exception {
            File file = new File(str);
            if (!file.exists()) {
                System.out.println("File or directory not found " + str);
            } else if (file.isDirectory()) {
                if (!str.equalsIgnoreCase(str2)) {
                    String str3 = String.valueOf(str.substring(str2.length() + 1, str.length())) + File.separatorChar;
                    System.out.println("Adding folder entry " + str3);
                    zipOutputStream.putNextEntry(new ZipEntry(str3));
                }
                File[] listFiles = file.listFiles();
                for (File absolutePath : listFiles) {
                    _Zip(zipOutputStream, absolutePath.getAbsolutePath(), str2);
                }
            } else {
                String substring = str.substring(str2.length() + 1, str.length());
                System.out.print("Adding file entry " + substring + "...");
                zipOutputStream.putNextEntry(new ZipEntry(substring));
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        fileInputStream.close();
                        zipOutputStream.closeEntry();
                        System.out.println("OK!");
                        return;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            }
        }

        /* access modifiers changed from: private */
        public static void Unzip(String str) {
            try {
                File file = new File(str);
                String substring = str.substring(0, str.length() - 4);
                new File(substring).mkdir();
                System.out.println(String.valueOf(substring) + " created");
                ZipFile zipFile = new ZipFile(file);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    File file2 = new File(substring, zipEntry.getName());
                    file2.getParentFile().mkdirs();
                    if (!zipEntry.isDirectory()) {
                        System.out.println("Extracting " + file2);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                        byte[] bArr = new byte[1024];
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 1024);
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                    }
                }
            } catch (IOException e) {
                System.out.println("IOError :" + e);
            }
        }
    }

    /* access modifiers changed from: private */
    public void _quiz_mode() {
        this.olmap.remove(this.olmap.size() - 1);
        this.sp.edit().putString("quiz_data", new Gson().toJson((Object) this.olmap)).commit();
        this.i.setClass(getApplicationContext(), QuizModeActivity.class);
        startActivity(this.i);
    }

    /* access modifiers changed from: private */
    public void _rev_mode() {
        this.olmap.remove(this.olmap.size() - 1);
        this.sp.edit().putString("quiz_data", new Gson().toJson((Object) this.olmap)).commit();
        this.i.setClass(getApplicationContext(), GameModeActivity.class);
        startActivity(this.i);
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
