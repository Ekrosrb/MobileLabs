package ua.kpi.comsys.io8312.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ua.kpi.comsys.io8312.dto.MovieDto;
@Deprecated
public class Search {
    @SerializedName("Search")
    private List<Movie> search;
    private int totalResults;
    @SerializedName("Response")
    private boolean response;
    @Expose(serialize = false, deserialize = false)
    private List<MovieDto> movieDtos;
    public Search() {}

    public Search(List<Movie> search, int totalResults, boolean response) {
        this.search = search;
        this.totalResults = totalResults;
        this.response = response;
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

    public int getTotalResults() {
        return totalResults;
    }

    public boolean isResponse() {
        return response;
    }

}