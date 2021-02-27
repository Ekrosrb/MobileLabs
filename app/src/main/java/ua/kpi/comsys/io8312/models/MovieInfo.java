package ua.kpi.comsys.io8312.models;

import com.google.gson.annotations.SerializedName;

public class MovieInfo {
    @SerializedName("Title")
    private final String title;
    @SerializedName("Year")
    private final String year;
    @SerializedName("Rated")
    private final String rated;
    @SerializedName("Released")
    private final String released;
    @SerializedName("Runtime")
    private final String runtime;
    @SerializedName("Genre")
    private final String genre;
    @SerializedName("Director")
    private final String director;
    @SerializedName("Writer")
    private final String writer;
    @SerializedName("Actors")
    private final String actors;
    @SerializedName("Plot")
    private final String plot;
    @SerializedName("Language")
    private final String language;
    @SerializedName("Country")
    private final String country;
    @SerializedName("Awards")
    private final String awards;
    @SerializedName("Poster")
    private final String poster;
    private final String imdbRating;
    private final String imdbVotes;
    private final String imdbID;
    @SerializedName("Type")
    private final String type;
    @SerializedName("Production")
    private final String production;

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
}