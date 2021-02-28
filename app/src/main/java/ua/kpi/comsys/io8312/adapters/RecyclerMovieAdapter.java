package ua.kpi.comsys.io8312.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.activities.MovieDetailInfoActivity;
import ua.kpi.comsys.io8312.models.MovieModel;
import ua.kpi.comsys.io8312.utils.Global;

public class RecyclerMovieAdapter extends RecyclerView.Adapter<RecyclerMovieAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<MovieModel> movies;
    private final Activity activity;
    private final TextView noDataMessage;
    public RecyclerMovieAdapter(Context context, Activity activity, TextView noDataMessage){
        this.inflater = LayoutInflater.from(context);
        this.movies = new ArrayList<>();
        this.activity = activity;
        this.noDataMessage = noDataMessage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieModel m = movies.get(position);
        holder.titleView.setText(m.getTitle());
        holder.yearView.setText(m.getYear());
        holder.typeView.setText(m.getType());
        if(activity.getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE){
            Picasso.with(inflater.getContext())
                    .load(m.getPoster()).resize(150, 400).centerInside()
                    .into(holder.posterView);
            holder.posterView.getLayoutParams().width = Global.dpToPx(150, inflater.getContext());
        }else{
            Picasso.with(inflater.getContext())
                    .load(m.getPoster()).resize(120, 350).centerInside()
                    .into(holder.posterView);
            holder.posterView.getLayoutParams().width = Global.dpToPx(120, inflater.getContext());
        }
        holder.view.setOnClickListener(v -> {
            Intent myIntent = new Intent(activity, MovieDetailInfoActivity.class);
            myIntent.putExtra("imdbID", m.getImdbID());
            activity.startActivity(myIntent);
        });

    }

    public void update(List<MovieModel> movies){
        if(movies.size() > 0){
            this.movies.clear();
            this.movies.addAll(movies);
            noDataMessage.setVisibility(View.INVISIBLE);
        }else{
            this.movies.clear();
            noDataMessage.setVisibility(View.VISIBLE);
        }
        notifyDataSetChanged();
    }

    public void update(List<MovieModel> movies, boolean isConnection){
        if(movies.size() > 0){
            this.movies.clear();
            this.movies.addAll(movies);
            noDataMessage.setVisibility(View.INVISIBLE);
        }else{
            this.movies.clear();
            if(!isConnection){
                noDataMessage.setText(R.string.no_internet_connection);
            }else{
                noDataMessage.setText(R.string.no_result_s_found);
            }
            noDataMessage.setVisibility(View.VISIBLE);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final View view;
        final ImageView posterView;
        final TextView titleView;
        final TextView yearView;
        final TextView typeView;
        public ViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
            posterView = view.findViewById(R.id.poster_id);
            titleView = view.findViewById(R.id.title_id);
            yearView = view.findViewById(R.id.year_id);
            typeView = view.findViewById(R.id.type_id);
        }
    }
}