package ua.kpi.comsys.io8312.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;

import ua.kpi.comsys.io8312.R;

public class MovieInfo {
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Rated")
    private String rated;
    @SerializedName("Released")
    private String released;
    @SerializedName("Runtime")
    private String runtime;
    @SerializedName("Genre")
    private String genre;
    @SerializedName("Director")
    private String director;
    @SerializedName("Writer")
    private String writer;
    @SerializedName("Actors")
    private String actors;
    @SerializedName("Plot")
    private String plot;
    @SerializedName("Language")
    private String language;
    @SerializedName("Country")
    private String country;
    @SerializedName("Awards")
    private String awards;
    @SerializedName("Poster")
    private String poster;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    @SerializedName("Type")
    private String type;
    @SerializedName("Production")
    private String production;

    public MovieInfo() { }

    public MovieInfo(String title, String year, String rated, String released, String runtime,
                     String genre, String director, String writer, String actors, String plot,
                     String language, String country, String awards, String poster,
                     String imdbRating, String imdbVotes, String imdbID, String type,
                     String production) {

        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.type = type;
        this.production = production;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getProduction() {
        return production;
    }

    public int getPosterId(){
        try {
            String str = poster.split("\\.")[0].toLowerCase();
            Field field = R.drawable.class.getDeclaredField(str);
            return field.getInt(field);
        } catch (NoSuchFieldException e) {
            return R.drawable.third_icon;
        } catch (IllegalAccessException e) {
            return R.drawable.third_icon;
        }
    }
}