package ua.kpi.comsys.io8312.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.adapters.RecyclerMovieAdapter;
import ua.kpi.comsys.io8312.net.Async;

public class Lab3Fragment extends Fragment {

    private SearchView search;
//    private MyFileReader fileReader;
//    private MovieAdapter movieAdapter;
    private RecyclerMovieAdapter recyclerMovieAdapter;

    public Lab3Fragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        fileReader = new MyFileReader(getContext());
//        Global.fileReader = fileReader;
//        fileReader.init();
//        fileReader.read();
        return inflater.inflate(R.layout.lab3_fragment, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Activity a = getActivity();
//        ImageView addIcon = a.findViewById(R.id.add_icon_id);
        RecyclerView movieList = a.findViewById(R.id.movieList_id);
        search = a.findViewById(R.id.search_movie_id);
        TextView noResultsMessage = a.findViewById(R.id.no_results_found_message_id);

        recyclerMovieAdapter = new RecyclerMovieAdapter(getContext(), getActivity(), noResultsMessage);
        movieList.setAdapter(recyclerMovieAdapter);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getMovies();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getMovies();
                return false;
            }
        });
        getMovies();

    }

    private void getMovies(){
        String valid = "abcdefghijklmnopqrstuvwxyz1234567890' -:";
        String query = search.getQuery().toString().toLowerCase();
        for(int i = 0; i < query.length(); i++){
            if(!valid.contains(String.valueOf(query.charAt(i)))){
                recyclerMovieAdapter.update(new ArrayList<>());
                return;
            }
        }
        if(search.getQuery().length() >= 3) {
            Async.getMovies(search.getQuery().toString(), recyclerMovieAdapter);
        }else{
            recyclerMovieAdapter.update(new ArrayList<>());
        }
    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        Activity a = getActivity();
//        ImageView addIcon = a.findViewById(R.id.add_icon_id);
//        ListView movieList = a.findViewById(R.id.movieList_id);
//        search = a.findViewById(R.id.search_movie_id);
//        TextView noResultsMessage = a.findViewById(R.id.no_results_found_message_id);
//
//        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                movieAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        if(movieAdapter == null) {
//            movieAdapter = new MovieAdapter(getContext(),
//                    R.layout.list_item,
//                    (ArrayList<MovieDto>) fileReader.getSearch().getMovieDtos());
//            Global.adapter = movieAdapter;
//        }
//
//        movieAdapter.setNoResultsMessage(noResultsMessage);
//        movieList.setAdapter(movieAdapter);
//        movieAdapter.getFilter().filter(search.getQuery());
//
//        addIcon.setOnClickListener(v -> {
//            Intent myIntent = new Intent(getActivity(), AddMovieActivity.class);
//            startActivity(myIntent);
//        });
//
//        movieList.setOnItemLongClickListener((arg0, view, pos, id) -> {
//            DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
//                switch (which) {
//                    case DialogInterface.BUTTON_POSITIVE:
//                        TextView textView = view.findViewById(R.id.title_id);
//                        movieAdapter.remove(textView.getText().toString());
//                        movieAdapter.getFilter().filter(search.getQuery());
//                        fileReader.delete(textView.getText().toString());
//                        break;
//                    case DialogInterface.BUTTON_NEGATIVE:
//                        break;
//                }
//            };
//            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//            builder.setMessage("Are you sure to delete this?")
//                    .setPositiveButton("Yes", dialogClickListener)
//                    .setNegativeButton("No", dialogClickListener)
//                    .show();
//            return true;
//        });
//
//        movieList.setOnItemClickListener((parent, view, position, id) -> {
//            TextView textView = view.findViewById(R.id.imdb_id);
//
//            if(!textView.getText().toString().isEmpty()){
//                Intent myIntent = new Intent(getActivity(), MovieDetailInfoActivity.class);
//                myIntent.putExtra("imdb", textView.getText().toString());
//                startActivity(myIntent);
//            }
//        });
//    }
}