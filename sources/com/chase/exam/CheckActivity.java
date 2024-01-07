package com.chase.exam;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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

public class CheckActivity extends AppCompatActivity {
    public final int REQ_CD_FP = HttpStatus.SC_SWITCHING_PROTOCOLS;
    private Timer _timer = new Timer();
    private Toolbar _toolbar;
    /* access modifiers changed from: private */
    public Button button1;
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> check_lmap = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<String, Object> check_map = new HashMap<>();
    private String decryptedText = "";
    private Intent fp = new Intent("android.intent.action.GET_CONTENT");
    /* access modifiers changed from: private */
    public double l = 0.0d;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private ListView listview1;
    private String path = "";
    private String path2 = "";
    private ProgressDialog prog;
    /* access modifiers changed from: private */
    public double score = 0.0d;
    /* access modifiers changed from: private */
    public TextView score_view;
    /* access modifiers changed from: private */
    public double size = 0.0d;
    private String str = "";
    private TimerTask t;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private TextView textview7;
    private TextView textview8;
    private TextView textview9;
    private String unzipped_file = "";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.check);
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
        this._toolbar = (Toolbar) findViewById(R.id._toolbar);
        setSupportActionBar(this._toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this._toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckActivity.this.onBackPressed();
            }
        });
        this.linear1 = (LinearLayout) findViewById(R.id.linear1);
        this.linear5 = (LinearLayout) findViewById(R.id.linear5);
        this.linear4 = (LinearLayout) findViewById(R.id.linear4);
        this.listview1 = (ListView) findViewById(R.id.listview1);
        this.button1 = (Button) findViewById(R.id.button1);
        this.linear2 = (LinearLayout) findViewById(R.id.linear2);
        this.linear3 = (LinearLayout) findViewById(R.id.linear3);
        this.textview1 = (TextView) findViewById(R.id.textview1);
        this.textview2 = (TextView) findViewById(R.id.textview2);
        this.textview3 = (TextView) findViewById(R.id.textview3);
        this.textview4 = (TextView) findViewById(R.id.textview4);
        this.score_view = (TextView) findViewById(R.id.score_view);
        this.textview7 = (TextView) findViewById(R.id.textview7);
        this.textview8 = (TextView) findViewById(R.id.textview8);
        this.textview9 = (TextView) findViewById(R.id.textview9);
        this.fp.setType("application/octet-stream");
        this.fp.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckActivity.this.l = 0.0d;
                while (CheckActivity.this.l != CheckActivity.this.size) {
                    CheckActivity.this.check_map = (HashMap) CheckActivity.this.check_lmap.get((int) CheckActivity.this.l);
                    if (CheckActivity.this.check_map.get("ans").toString().equals(CheckActivity.this.check_map.get("c_a").toString())) {
                        CheckActivity checkActivity = CheckActivity.this;
                        checkActivity.score = checkActivity.score + 1.0d;
                    }
                    CheckActivity checkActivity2 = CheckActivity.this;
                    checkActivity2.l = checkActivity2.l + 1.0d;
                }
                CheckActivity.this.score_view.setText(String.valueOf((long) CheckActivity.this.score).concat("/".concat(String.valueOf((long) CheckActivity.this.size))));
                CheckActivity.this.button1.setEnabled(false);
            }
        });
    }

    private void initializeLogic() {
        setTitle("Check answers");
        startActivityForResult(this.fp, HttpStatus.SC_SWITCHING_PROTOCOLS);
        _CardStyle(this.linear5, 4.0d, 18.0d, "#FFFFFF", false);
        _CardStyle(this.linear4, 4.0d, 18.0d, "#FFFFFF", false);
        this.score = 0.0d;
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
                    _prog(true, "Importing file", "Please wait");
                    this.path = (String) arrayList.get(0);
                    if (this.path.endsWith(".skl")) {
                        _read_zip();
                    } else {
                        SketchwareUtil.showMessage(getApplicationContext(), "Invalid file");
                        startActivityForResult(this.fp, HttpStatus.SC_SWITCHING_PROTOCOLS);
                    }
                    this.t = new TimerTask() {
                        public void run() {
                            CheckActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    CheckActivity.this._prog(false, "", "");
                                }
                            });
                        }
                    };
                    this._timer.schedule(this.t, 4000);
                    this.size = (double) this.check_lmap.size();
                    return;
                }
                finish();
                return;
            default:
                return;
        }
    }

    private void _CardStyle(View view, double d, double d2, String str2, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str2));
        gradientDrawable.setCornerRadius((float) ((int) d2));
        new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{Color.parseColor("#f44336")}), (Drawable) null, (Drawable) null);
        view.setBackground(gradientDrawable);
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation((float) ((int) d));
        }
    }

    /* access modifiers changed from: private */
    public void _prog(boolean z, String str2, String str3) {
        if (z) {
            if (this.prog == null) {
                this.prog = new ProgressDialog(this);
                this.prog.setMax(100);
                this.prog.setIndeterminate(true);
                this.prog.setCancelable(false);
                this.prog.setCanceledOnTouchOutside(false);
            }
            this.prog.setTitle(str2);
            this.prog.setMessage(str3);
            this.prog.show();
        } else if (this.prog != null) {
            this.prog.dismiss();
        }
    }

    private void _read_zip() {
        _Unzip(this.path);
        this.path2 = this.path.substring(0, this.path.length() - 4);
        this.unzipped_file = this.path2.concat("/".concat(Uri.parse(this.path2).getLastPathSegment()));
        if (FileUtil.isFile(this.unzipped_file)) {
            this.str = FileUtil.readFile(this.unzipped_file);
            this.decryptedText = new String(Base64.decode(this.str, 0));
            if (!this.decryptedText.contains("ques") || !this.decryptedText.contains("ans") || !this.decryptedText.contains("c_a")) {
                SketchwareUtil.showMessage(getApplicationContext(), "Invalid file");
                finish();
            } else {
                this.check_lmap = (ArrayList) new Gson().fromJson(this.decryptedText, new TypeToken<ArrayList<HashMap<String, Object>>>() {
                }.getType());
            }
            this.listview1.setAdapter(new Listview1Adapter(this.check_lmap));
            ((BaseAdapter) this.listview1.getAdapter()).notifyDataSetChanged();
            FileUtil.deleteFile(this.path2);
        }
    }

    private void _Unzip(String str2) {
        new ZipMan();
        ZipMan.Unzip(str2);
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

    private void _check() {
        this.l = 0.0d;
        while (this.l != this.size) {
            this.l += 1.0d;
            this.check_map = this.check_lmap.get(0);
            if (this.check_map.get("ans").toString().equals(this.check_map.get("c_a").toString())) {
                this.score += 1.0d;
            }
            this.check_lmap.remove(0);
        }
        this.score_view.setText(String.valueOf((long) this.score));
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
            LayoutInflater layoutInflater = (LayoutInflater) CheckActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(R.layout.check_lview, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear1);
            CheckActivity.this.check_map = (HashMap) CheckActivity.this.check_lmap.get(i);
            ((TextView) view.findViewById(R.id.ques)).setText(CheckActivity.this.check_map.get("ques").toString());
            ((TextView) view.findViewById(R.id.ans)).setText(CheckActivity.this.check_map.get("ans").toString());
            ((TextView) view.findViewById(R.id.c_a)).setText(CheckActivity.this.check_map.get("c_a").toString());
            return view;
        }
    }

    @Deprecated
    public void showMessage(String str2) {
        Toast.makeText(getApplicationContext(), str2, 0).show();
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
