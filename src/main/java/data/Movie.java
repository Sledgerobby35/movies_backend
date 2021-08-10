package data;

import java.sql.Date;

public class Movie {
    public int id;
    public String title;
    public String poster;
    public String year;
    public String genre;
    public String director;
    public int rating;
    public String actors;
    public String plot;

    public Movie() {
    }

    public Movie(int id, String title, String poster, String year, String genre,
                 String director, int rating, String actors, String plot) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.rating = rating;
        this.actors = actors;
        this.plot = plot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
