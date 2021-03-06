package ua.kpi.comsys.io8312.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import ua.kpi.comsys.io8312.R;
import ua.kpi.comsys.io8312.models.MovieInfo;
import ua.kpi.comsys.io8312.net.Async;

public class MovieDetailInfoActivity extends AppCompatActivity {

    private TextView title;
    private TextView year;
    private TextView rated;
    private TextView released;
    private TextView runtime;
    private TextView genre;
    private TextView director;
    private TextView writer;
    private TextView actors;
    private TextView plot;
    private TextView language;
    private TextView country;
    private TextView awards;
    private ImageView poster;
    private TextView imdbRating;
    private TextView imdbVotes;
    private TextView type;
    private TextView production;
    private TextView noDataMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_all_info);

        String imdb = getIntent().getStringExtra("imdbID");

        title = findViewById(R.id.title_info_id);
        year = findViewById(R.id.year_info_id);
        rated = findViewById(R.id.rated_info_id);
        released = findViewById(R.id.released_info_id);
        runtime = findViewById(R.id.runtime_info_id);
        genre = findViewById(R.id.genre_info_id);
        director = findViewById(R.id.director_info_id);
        writer = findViewById(R.id.writer_info_id);
        actors = findViewById(R.id.actors_info_id);
        plot = findViewById(R.id.plot_info_id);
        language = findViewById(R.id.language_info_id);
        country = findViewById(R.id.country_info_id);
        awards = findViewById(R.id.awards_info_id);
        poster = findViewById(R.id.poster_info_id);
        imdbRating = findViewById(R.id.imdb_rating_info_id);
        imdbVotes = findViewById(R.id.imdb_votes_info_id);
        type = findViewById(R.id.type_info_id);
        production = findViewById(R.id.production_info_id);
        noDataMessage = findViewById(R.id.no_connection_info_message);

        Async.getMovieInfo(imdb, this);

    }

    @SuppressLint("SetTextI18n")
    public void setInfo(MovieInfo info, boolean isConnection){
        if(!isConnection && info == null){
            noDataMessage.setText(R.string.no_internet_connection);
            noDataMessage.setVisibility(View.VISIBLE);
        }else if(info == null){
            noDataMessage.setText("could not find information on this movie");
            noDataMessage.setVisibility(View.VISIBLE);
        }else {
            noDataMessage.setVisibility(View.INVISIBLE);
            title.setText(info.getTitle());
            year.setText("Year:    " + info.getYear());
            rated.setText("Rated:    " + info.getRated());
            released.setText("Released:    " + info.getReleased());
            runtime.setText("Runtime:    " + info.getRuntime());

            genre.setText("Genre:    " + info.getGenre());
            director.setText("Director:    " + info.getDirector());
            writer.setText("Writer:    " + info.getWriter());
            actors.setText("Actors:    " + info.getActors());

            plot.setText("Plot:    " + info.getPlot());
            language.setText("Language:    " + info.getLanguage());
            country.setText("Country:    " + info.getCountry());
            awards.setText("Awards:    " + info.getAwards());

            Picasso.with(getApplicationContext())
                    .load(info.getPoster()).resize(300, 300).centerInside()
                    .into(poster);

            imdbRating.setText("imdb rating:    " + info.getImdbRating() + "/10");
            imdbVotes.setText("imdb voted:    " + info.getImdbVotes());

            type.setText("Type:    " + info.getType());
            production.setText("Production:    " + info.getProduction());
        }
    }
}