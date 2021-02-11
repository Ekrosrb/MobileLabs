package ua.kpi.comsys.io8312.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.adapters.MovieAdapter;
import ua.kpi.comsys.io8312.utils.MyFileReader;

public class Lab3Fragment extends Fragment {

    private ListView movieList;

    public Lab3Fragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lab3_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        MyFileReader fr = new MyFileReader(getContext());
        fr.init();
        fr.read();

        movieList = getActivity().findViewById(R.id.moviesList_id);

        MovieAdapter movieAdapter = new MovieAdapter(getContext(), R.layout.list_item, fr.getSearch().toMovieDtoArray());
        movieList.setAdapter(movieAdapter);

    }
}