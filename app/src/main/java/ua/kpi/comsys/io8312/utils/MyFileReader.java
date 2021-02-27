package ua.kpi.comsys.io8312.utils;

import android.content.Context;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import ua.kpi.comsys.io8312.dto.MovieDto;
import ua.kpi.comsys.io8312.models.Movie;
import ua.kpi.comsys.io8312.models.MovieInfo;
import ua.kpi.comsys.io8312.models.Search;
@Deprecated
public class MyFileReader {

    private Search search;
    private final Context context;
    private final String fileName;
    public MyFileReader(Context context){
        this.context = context;
        fileName = "MovieList.txt";
    }

    public String getFilmJson() {
        return "{\"Search\":[{\"Title\":\"Long title that want to break your layout. Long title that want to break your layout. Long title that want to break your layout. Long title that want to break your layout\",\"Year\":\"2020\",\"imdbID\":\"noid\",\"Type\":\"test\",\"Poster\":\"\"},{\"Title\":\"Star Wars: Episode IV - A New Hope Star Wars: Episode IV - A New Hope \",\"Year\":\"1977\",\"imdbID\":\"tt0076759\",\"Type\":\"movie\",\"Poster\":\"poster_01.jpg\"},{\"Title\":\"Star Wars: Episode V - The Empire Strikes Back\",\"Year\":\"1980\",\"imdbID\":\"tt0080684\",\"Type\":\"movie\",\"Poster\":\"poster_02.jpg\"},{\"Title\":\"Star Wars: Episode VI - Return of the Jedi\",\"Year\":\"1983\",\"imdbID\":\"tt0086190\",\"Type\":\"movie\",\"Poster\":\"poster_03.jpg\"},{\"Title\":\"Star Wars: Episode VII - The Force Awakens\",\"Year\":\"\",\"imdbID\":\"tt2488496\",\"Type\":\"movie\",\"Poster\":\"\"},{\"Title\":\"Star Wars: Episode I - The Phantom Menace\",\"Year\":\"1999\",\"imdbID\":\"tt0120915\",\"Type\":\"movie\",\"Poster\":\"poster_05.jpg\"},{\"Title\":\"Star Wars: Episode III - Revenge of the Sith\",\"Year\":\"2005\",\"imdbID\":\"tt0121766\",\"Type\":\"movie\",\"Poster\":\"poster_06.jpg\"},{\"Title\":\"Star Wars: Episode II - Attack of the Clones\",\"Year\":\"2002\",\"imdbID\":\"tt0121765\",\"Type\":\"movie\",\"Poster\":\"poster_07.jpg\"},{\"Title\":\"Star Trek\",\"Year\":\"2009\",\"imdbID\":\"tt0796366\",\"Type\":\"movie\",\"Poster\":\"poster_08.jpg\"},{\"Title\":\"Star Wars: Episode VIII - The Last Jedi\",\"Year\":\"2017\",\"imdbID\":\"tt2527336\",\"Type\":\"\",\"Poster\":\"\"},{\"Title\":\"Rogue One: A Star Wars Story\",\"Year\":\"2016\",\"imdbID\":\"tt3748528\",\"Type\":\"movie\",\"Poster\":\"poster_10.jpg\"}]}";
    }

    public void read(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    context.openFileInput(fileName)));
            String json = br.readLine();
            br.close();
            search = new GsonBuilder().create().fromJson(json, Search.class);
            search.toMovieDtoArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        try {
            if(!isFilePresent(fileName)) {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                        context.openFileOutput("MovieList.txt", Context.MODE_PRIVATE)));
                bw.write(getFilmJson());
                bw.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MovieInfo getDetailInformation(String imdbID){
        try {
            if(!imdbID.isEmpty() && !imdbID.equals("none")) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        context.getAssets().open(imdbID + ".txt")));
                String json = br.readLine();
                br.close();
                return new GsonBuilder().create().fromJson(json, MovieInfo.class);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void write(MovieDto movieDto){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    context.openFileOutput("MovieList.txt", Context.MODE_PRIVATE)));
            List<Movie> movies = search.getSearch();
            movies.add(new Movie(movieDto.getTitle(),
                    movieDto.getYear(),
                    movieDto.getImdbID(),
                    movieDto.getType(),
                    ""));
            search.setSearch(movies);
            bw.write(new GsonBuilder().create().toJson(search));
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String title){
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    context.openFileOutput("MovieList.txt", Context.MODE_PRIVATE)));
            List<Movie> movies = search.getSearch();
            for(Movie m: movies){
                if(m.getTitle().equals(title)){
                    movies.remove(m);
                    break;
                }
            }
            search.setSearch(movies);
            bw.write(new GsonBuilder().create().toJson(search));
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isFilePresent(String fileName) {
        String path = context.getFilesDir() + "/" + fileName;
        File file = new File(path);
        return file.exists();
    }

    public Search getSearch() {
        return search;
    }
}