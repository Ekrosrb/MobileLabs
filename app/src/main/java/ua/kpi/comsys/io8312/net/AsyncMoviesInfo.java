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
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import ua.kpi.comsys.io8312.adapters.RecyclerMovieAdapter;
import ua.kpi.comsys.io8312.models.MovieModel;

public class AsyncMoviesInfo extends AsyncTask<String, String, JSONObject> {
    private final RecyclerMovieAdapter recyclerMovieAdapter;
    private int code;
    private String query;
    public AsyncMoviesInfo(RecyclerMovieAdapter recyclerMovieAdapter){
        this.recyclerMovieAdapter = recyclerMovieAdapter;
    }
    @Override
    protected JSONObject doInBackground(String... uri) {
        JSONObject jsonMovies = null;
        query = uri[0];
        try {
            URL url = new URL("http://www.omdbapi.com/?apikey=7e9fe69e&s=" + uri[0] + "&page=1");
            HttpURLConnection https = (HttpURLConnection) url.openConnection();
            https.setRequestMethod("GET");
            https.setDoInput(true);
            code = https.getResponseCode();
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
        List<MovieModel> movieModels;
        try {
            if (code == 200 && result.getBoolean("Response")) {
                String search = result.getString("Search");
                movieModels = new GsonBuilder().create()
                        .fromJson(
                                search,
                                new TypeToken<List<MovieModel>>(){}.getType());
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.insertOrUpdate(movieModels);
                realm.commitTransaction();
            }else{
                Realm realm = Realm.getDefaultInstance();
                movieModels = realm.where(MovieModel.class).contains("title", query).findAll();
            }
            if(movieModels == null || movieModels.size() == 0){
                movieModels = new ArrayList<>();
                recyclerMovieAdapter.update(movieModels, false);
            }else{
                recyclerMovieAdapter.update(movieModels);
            }
        }catch (JSONException ignored){}
    }
}