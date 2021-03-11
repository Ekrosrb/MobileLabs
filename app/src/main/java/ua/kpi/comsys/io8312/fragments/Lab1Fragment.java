package ua.kpi.comsys.io8312.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.Date;
import java.util.Objects;

import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.playground.TimeVI;

import static java.lang.Thread.sleep;

public class Lab1Fragment extends Fragment {

    private TextView playground_text;

    public Lab1Fragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lab1_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        playground_text = Objects.requireNonNull(getActivity()).findViewById(R.id.playground_text);

        Thread realTime = new Thread(() -> {
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updatePlaygroundTextView(testTime());
            }
        });
        realTime.start();
    }

    private void updatePlaygroundTextView(StringBuffer text){
        FragmentActivity activity = getActivity();
        if(activity != null) {
            activity.runOnUiThread(() -> playground_text.setText(text));
        }
    }

    private StringBuffer testTime(){
        TimeVI time1 = new TimeVI(23, 59, 59);
        TimeVI time2 = new TimeVI();
        TimeVI time3 = new TimeVI(new Date());
        TimeVI time4 = new TimeVI(time3);
        time2.setSeconds(1);

        String add1 = time1.addTime(time2).toString();
        String sub1 = time2.subTime(time1).toString();

        String add2 = TimeVI.addTime(time3, time4).toString();
        String sub2 = TimeVI.subTime(time3, time4).toString();

        return new StringBuffer()
                .append("Playground\n")
                .append("Time 1: ").append(time1).append("\n")
                .append("Time 2: ").append(time2).append("\n")
                .append("Time 3 (real time): ").append(time3).append("\n")
                .append("Time 4 (= 3): ").append(time4).append("\n")
                .append("Add 1 (time1 + time2): ").append(add1).append("\n")
                .append("Sub 1 (time2 - time1): ").append(sub1).append("\n")
                .append("Add 2 (time3 + time4): ").append(add2).append("\n")
                .append("Sub 2 (time3 - time4): ").append(sub2).append("\n");
    }
}
