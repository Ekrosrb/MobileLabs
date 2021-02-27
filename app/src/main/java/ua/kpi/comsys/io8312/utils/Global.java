package ua.kpi.comsys.io8312.utils;

import android.content.Context;

public class Global {
//    @SuppressLint("StaticFieldLeak")
//    public static MovieAdapter adapter;
//    @SuppressLint("StaticFieldLeak")
//    public static MyFileReader fileReader;
    public static final ImageList images = new ImageList();

    public static int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}