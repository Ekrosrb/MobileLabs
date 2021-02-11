package ua.kpi.comsys.io8312.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;

import ua.kpi.comsys.io8312.R;

public class Movie {
    @SerializedName("Title")
    private  String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("imdbID")
    private String imdbID;
    @SerializedName("Type")
    private String type;
    @SerializedName("Poster")
    private String poster;

    public Movie() {}

    public Movie(String title, String year, String imdbID, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }

    public int getPosterId(){
        try {
            String str = poster.split("\\.")[0].toLowerCase();
            System.out.println(str);
            Field field = R.drawable.class.getDeclaredField(str);
            return field.getInt(field);
        } catch (NoSuchFieldException e) {
            return R.drawable.third_icon;
        } catch (IllegalAccessException e) {
            return R.drawable.third_icon;
        }
    }
}