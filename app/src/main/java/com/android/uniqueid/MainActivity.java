package com.android.uniqueid;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.imei);

        @SuppressLint("HardwareIds")
        String androidID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        textView.append("\nAndroid Id : " + androidID);

        textView.append("\nUnique Number : " + getDeviceID());

        textView.append("\n" + getDeviceName());
    }

    public static String getDeviceID() {
        String devIDShort = "" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +
                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +
                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
                Build.USER.length() % 10;
        return devIDShort;
    }

    public static String getDeviceName() {
        String devIDShort =
                "\n\nBoard: " + Build.BOARD + " " + "\nBranch: " + Build.BRAND +
                        "\nCPU: " + Build.CPU_ABI + "\nDevice: " + Build.DEVICE +
                        "\nDisplay: " + Build.DISPLAY + "\nHost: " + Build.HOST +
                        "\nId: " + Build.ID + "\nManufacturer: " + Build.MANUFACTURER +
                        "\nModel: " + Build.MODEL + "\nProduct: " + Build.PRODUCT +
                        "\nTags: " + Build.TAGS + "\nType: " + Build.TYPE +
                        "\nUser: " + Build.USER + "\n\nFunction : length()%10";
        return devIDShort;
    }
}