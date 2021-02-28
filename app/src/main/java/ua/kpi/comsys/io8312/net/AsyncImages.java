package ua.kpi.comsys.io8312.net;

import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;

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
import ua.kpi.comsys.io8312.adapters.ImageAdapter;
import ua.kpi.comsys.io8312.models.ImageModel;
import ua.kpi.comsys.io8312.utils.Global;

public class AsyncImages extends AsyncTask<String, String, JSONObject> {
    private final ImageAdapter view;
    private int code;
    public AsyncImages(ImageAdapter view){
        this.view = view;
    }
    @Override
    protected JSONObject doInBackground(String... uri) {
        JSONObject jsonMovies = null;
        try {
            URL url = new URL("https://pixabay.com/api/?key=19193969-87191e5db266905fe8936d565&q=small+animals&image_type=photo&per_page=18");
            HttpURLConnection https = (HttpURLConnection) url.openConnection();
            https.setRequestMethod("GET");
            https.setDoInput(true);
            BufferedReader in = new BufferedReader(new InputStreamReader(https.getInputStream()));
            jsonMovies = new JSONObject(in.readLine());
            in.close();
            code = https.getResponseCode();
        }catch (IOException | JSONException e){
            jsonMovies = new JSONObject();
            e.printStackTrace();
        }
        return jsonMovies;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        List<ImageModel> images;
        try {
            if(code == 200) {
                images = new GsonBuilder().create().fromJson(result.getString("hits"), new TypeToken<List<ImageModel>>() {
                }.getType());
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.delete(ImageModel.class);
                realm.insert(images);
                realm.commitTransaction();
            }else{
                Realm realm = Realm.getDefaultInstance();
                images = realm.where(ImageModel.class).findAll();
            }
            view.setNoConnectionMessageVisibility(View.INVISIBLE);
            if(images == null || images.size() == 0){
                images = new ArrayList<>();
                view.setNoConnectionMessageVisibility(View.VISIBLE);
            }
            Global.images.clear();
            for(ImageModel image: images){
                Global.images.addImage(Uri.parse(image.getWebformatURL()));
            }
            view.notifyDataSetChanged();
        }catch (JSONException ignored){}
    }
}