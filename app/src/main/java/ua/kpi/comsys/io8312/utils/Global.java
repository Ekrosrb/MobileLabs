package ua.kpi.comsys.io8312.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;

import ua.kpi.comsys.io8312.adapters.MovieAdapter;

public class Global {
    @SuppressLint("StaticFieldLeak")
    public static MovieAdapter adapter;
    public static MyFileReader fileReader;

    public static int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static int pxToDp(int px, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}