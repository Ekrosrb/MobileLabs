package ua.kpi.comsys.io8312.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.dto.MovieDto;

public class MovieAdapter extends ArrayAdapter<MovieDto> {
    private final LayoutInflater inflater;
    private final int layout;
    private final List<MovieDto> movies;

    public MovieAdapter(Context context, int resource, List<MovieDto> movies){
        super(context, resource, movies);
        this.movies = movies;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(this.layout, parent, false);
        ImageView posterView = view.findViewById(R.id.poster_id);
        TextView titleView = view.findViewById(R.id.title_id);
        TextView yearView = view.findViewById(R.id.year_id);
        TextView imdbView = view.findViewById(R.id.imdb_id);
        TextView typeView = view.findViewById(R.id.type_id);

        MovieDto movie = movies.get(position);
        posterView.setImageResource(movie.getPoster());
        titleView.setText(movie.getTitle());
        yearView.setText(movie.getYear());
        imdbView.setText(movie.getImdbID());
        typeView.setText(movie.getType());

        if(parent.getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE){
            posterView.getLayoutParams().width = dpToPx(150, parent.getContext());
        }else{
            posterView.getLayoutParams().width = dpToPx(120, parent.getContext());
        }
        return view;
    }

    private int dpToPx(int dp, Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}