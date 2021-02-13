package ua.kpi.comsys.io8312.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ua.kpi.comsys.io8312.dto.MovieDto;

public class Search {
    @SerializedName("Search")
    private List<Movie> search;
    @Expose(serialize = false, deserialize = false)
    private List<MovieDto> movieDtos;
    public Search() {}

    public Search(List<Movie> search) {
        this.search = search;
        toMovieDtoArray();
    }

    public List<Movie> getSearch() {
        return search;
    }

    public void setSearch(List<Movie> search) {
        this.search = search;
        toMovieDtoArray();
    }

    public void toMovieDtoArray(){
        List<MovieDto> movieDtos = new ArrayList<>();
        for(Movie movie: search){
            String title = movie.getTitle();
            String year = movie.getYear();
            String imid = movie.getImdbID();
            String type = movie.getType();
            MovieDto movieDto = new MovieDto(
                    title.isEmpty()?"Unnamed :(":title,
                    year.isEmpty()?"":year,
                    imid.isEmpty() || imid.equals("noid")?"":imid,
                    type.isEmpty()?"": type,
                    movie.getPosterId()
            );
            movieDtos.add(movieDto);
        }
        this.movieDtos =  movieDtos;
    }

    public List<MovieDto> getMovieDtos() {
        return movieDtos;
    }
}