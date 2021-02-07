package ua.kpi.comsys.io8312.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import im.dacer.androidcharts.PieHelper;
import im.dacer.androidcharts.PieView;
import ua.kpi.comsys.io8312.R;

public class Lab2Fragment extends Fragment {

    private GraphView graph;
    private PieView pieView;

    public Lab2Fragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lab2_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        pieView = Objects.requireNonNull(getActivity()).findViewById(R.id.pie_view);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch switchDiagram = Objects.requireNonNull(getActivity())
                .findViewById(R.id.switch_diagram);
        switchDiagram.setChecked(false);
        graph = getActivity().findViewById(R.id.graph);
        switchDiagram.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                graph.setVisibility(View.INVISIBLE);
                pieView.setVisibility(View.VISIBLE);
            }else{
                pieView.setVisibility(View.INVISIBLE);
                graph.setVisibility(View.VISIBLE);
            }
        });

        double a = 0.01;
        double b = 4;
        List<DataPoint> dataPoints = new ArrayList<>();

        for(double i = a; i <= b; i+=0.01){
            dataPoints.add(new DataPoint(i, Math.log(i)));
        }
        DataPoint[] stateData = new DataPoint[dataPoints.size()];
        dataPoints.toArray(stateData);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(stateData);
        graph.addSeries(series);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setMaxX(4);
        graph.getViewport().setMinX(-4);
        graph.getViewport().setMaxY(4);
        graph.getViewport().setMinY(-4);
        graph.getViewport().setScalable(false);
        graph.getViewport().setScalableY(false);
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<>();
        pieHelperArrayList.add(new PieHelper(10, Color.YELLOW));
        pieHelperArrayList.add(new PieHelper(20, Color.GREEN));
        pieHelperArrayList.add(new PieHelper(25, Color.BLUE));
        pieHelperArrayList.add(new PieHelper(5, Color.RED));
        pieHelperArrayList.add(new PieHelper(40, Color.CYAN));
        pieView.setDate(pieHelperArrayList);
    }
}