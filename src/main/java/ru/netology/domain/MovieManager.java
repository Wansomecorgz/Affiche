package ru.netology.domain;

public class MovieManager {
    private MovieData[] movies = new MovieData[0];
    private int countMovies = 10;

    public MovieManager() {
    }

    public MovieManager(int countMovies) {
        this.countMovies = countMovies;
    }

    public MovieData[] getMovies() {
        return movies;
    }

    public void setMovies(MovieData[] movies) {
        this.movies = movies;
    }

    public int getCountMovies() {
        return countMovies;
    }

    public void setCountMovies(int countMovies) {
        this.countMovies = countMovies;
    }

    public void add(MovieData movie) {
        MovieData[] tmp = new MovieData[movies.length + 1];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[movies.length] = movie;
        movies = tmp;
    }

    public void findAll() {
        getMovies();
    }

    public MovieData[] findLast() {
        if (countMovies > movies.length) {
            countMovies = movies.length;
        }
        MovieData[] tmp = new MovieData[countMovies];
        for (int i = 0, j = movies.length - 1; i < countMovies; i++, j--) {
            tmp[i] = movies[j];
        }
        movies = tmp;
        return tmp;
    }
}
