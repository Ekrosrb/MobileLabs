package ua.kpi.comsys.io8312.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.dto.MovieDto;
import ua.kpi.comsys.io8312.utils.Global;

public class MovieAdapter extends ArrayAdapter<MovieDto> implements Filterable, Serializable {
    private final LayoutInflater inflater;
    private final int layout;
    private MovieFilter filter;
    private List<MovieDto> movies;
    private final List<MovieDto> allMovies;
    private TextView noResultsMessage;

    public MovieAdapter(Context context, int resource, List<MovieDto> movies){
        super(context, resource, movies);
        this.movies = movies;
        this.allMovies = movies;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public void add(@Nullable MovieDto object) { allMovies.add(object); }

    @Override
    public void remove(@Nullable MovieDto object) { allMovies.remove(object); }

    public void remove(String title){
        for(MovieDto m: allMovies){
            if (m.getTitle().equals(title)){
                remove(m);
                return;
            }
        }
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    public @NotNull View getView(int position, View convertView, @NotNull ViewGroup parent){
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
            posterView.getLayoutParams().width = Global.dpToPx(150, parent.getContext());
        }else{
            posterView.getLayoutParams().width = Global.dpToPx(120, parent.getContext());
        }
        return view;
    }

    public void setNoResultsMessage(TextView noResultsMessage){
        this.noResultsMessage = noResultsMessage;
    }

    @Override
    public @NotNull Filter getFilter() {
        if(filter == null)
        {
            filter=new MovieFilter();
        }
        return filter;
    }

    class MovieFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results=new FilterResults();

            if(constraint != null && !constraint.toString().isEmpty()) {
                constraint=constraint.toString().toUpperCase();
                List<MovieDto> filters = new ArrayList<>();
                for(int i=0;i<allMovies.size();i++) {
                    if(allMovies.get(i).getTitle().toUpperCase().contains(constraint)) {
                        filters.add(allMovies.get(i));
                    }
                }
                results.count=filters.size();
                results.values=filters;
            } else {
                results.count=allMovies.size();
                results.values=allMovies;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movies = (List<MovieDto>) results.values;
            if(noResultsMessage != null) {
                if (getCount() == 0) {
                    noResultsMessage.setVisibility(View.VISIBLE);
                } else {
                    noResultsMessage.setVisibility(View.INVISIBLE);
                }
            }
            notifyDataSetChanged();
        }
    }
}