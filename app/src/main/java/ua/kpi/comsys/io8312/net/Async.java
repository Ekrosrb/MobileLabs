package ua.kpi.comsys.io8312.net;

import ua.kpi.comsys.io8312.activities.MovieDetailInfoActivity;
import ua.kpi.comsys.io8312.adapters.ImageAdapter;
import ua.kpi.comsys.io8312.adapters.RecyclerMovieAdapter;

public class Async {
    public static void getMovies(String name, RecyclerMovieAdapter recyclerMovieAdapter){
        new AsyncMoviesInfo(recyclerMovieAdapter).execute(name);
    }

    public static void getMovieInfo(String imdbID, MovieDetailInfoActivity view){
        new AsyncMovieInfo(view).execute(imdbID);
    }

    public static void getImages(ImageAdapter adapter){
        new AsyncImages(adapter).execute();
    }
}
