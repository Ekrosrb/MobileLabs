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

import io.realm.Realm;
import ua.kpi.comsys.io8312.activities.MovieDetailInfoActivity;
import ua.kpi.comsys.io8312.models.MovieInfo;

public class AsyncMovieInfo extends AsyncTask<String, String, JSONObject> {
    @SuppressLint("StaticFieldLeak")
    private final MovieDetailInfoActivity view;
    private int code;
    private String query;
    public AsyncMovieInfo(MovieDetailInfoActivity recyclerMovieAdapter){
        this.view = recyclerMovieAdapter;
    }
    @Override
    protected JSONObject doInBackground(String... uri) {
        JSONObject jsonMovies = null;
        query = uri[0];
        try {
            URL url = new URL("http://www.omdbapi.com/?apikey=7e9fe69e&&i=" + uri[0]);
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
        try {
            if (code == 200 && result.getBoolean("Response")) {
                MovieInfo info = new GsonBuilder().create()
                        .fromJson(result.toString(), MovieInfo.class);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.insertOrUpdate(info);
                realm.commitTransaction();
                view.setInfo(info, true);
            }else{
                Realm realm = Realm.getDefaultInstance();
                MovieInfo realmResults = realm.where(MovieInfo.class).equalTo("imdbID", query).findFirst();
                view.setInfo(realmResults, false);
            }
        }catch (JSONException ignored){}
    }

}