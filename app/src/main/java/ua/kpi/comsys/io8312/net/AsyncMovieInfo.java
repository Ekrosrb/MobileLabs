package ua.kpi.comsys.io8312.net;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import ua.kpi.comsys.io8312.activities.MovieDetailInfoActivity;

public class AsyncMovieInfo extends AsyncTask<String, String, JSONObject> {
    @SuppressLint("StaticFieldLeak")
    private final MovieDetailInfoActivity view;
    public AsyncMovieInfo(MovieDetailInfoActivity recyclerMovieAdapter){
        this.view = recyclerMovieAdapter;
    }
    @Override
    protected JSONObject doInBackground(String... uri) {
        JSONObject jsonMovies = null;
        try {
            URL url = new URL("http://www.omdbapi.com/?apikey=7e9fe69e&&i=" + uri[0]);
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
                ua.kpi.comsys.io8312.models.MovieInfo info = new GsonBuilder().create()
                        .fromJson(result.toString(), ua.kpi.comsys.io8312.models.MovieInfo.class);
                view.setInfo(info);
            }
        }catch (JSONException ignored){}
    }

}