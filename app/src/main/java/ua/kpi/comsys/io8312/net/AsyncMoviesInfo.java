package ua.kpi.comsys.io8312.net;

import android.os.AsyncTask;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import ua.kpi.comsys.io8312.adapters.RecyclerMovieAdapter;
import ua.kpi.comsys.io8312.models.MovieModel;

public class AsyncMoviesInfo extends AsyncTask<String, String, JSONObject> {
    private final RecyclerMovieAdapter recyclerMovieAdapter;
    public AsyncMoviesInfo(RecyclerMovieAdapter recyclerMovieAdapter){
        this.recyclerMovieAdapter = recyclerMovieAdapter;
    }
    @Override
    protected JSONObject doInBackground(String... uri) {
        JSONObject jsonMovies = null;
        try {
            URL url = new URL("http://www.omdbapi.com/?apikey=7e9fe69e&s=" + uri[0] + "&page=1");
            HttpURLConnection https = (HttpURLConnection) url.openConnection();
            https.setRequestMethod("GET");
            https.setDoInput(true);
            BufferedReader in = new BufferedReader(new InputStreamReader(https.getInputStream()));
            jsonMovies = new JSONObject(in.readLine());
            in.close();
        }catch (IOException | JSONException e){
            try {
                jsonMovies = new JSONObject("{\"Response\":\"False\"}");
            } catch (JSONException ignored) {}
            e.printStackTrace();
        }
        return jsonMovies;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        try {
            if (result.getBoolean("Response")) {
                String search = result.getString("Search");
                recyclerMovieAdapter.update(new GsonBuilder().create()
                        .fromJson(
                                search,
                                new TypeToken<List<MovieModel>>(){}.getType()
                        ));
            }
        }catch (JSONException ignored){}
    }
}