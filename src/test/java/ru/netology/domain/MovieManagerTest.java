package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    MovieData movieOne = new MovieData(1, "The Green Mile");
    MovieData movieTwo = new MovieData(2, "The Shawshank Redemption");
    MovieData movieThree = new MovieData(3, "Schindler's List");
    MovieData movieFour = new MovieData(4, "The Lord of the Rings: The Return of the King");
    MovieData movieFive = new MovieData(5, "Forrest Gump");
    MovieData movieSix = new MovieData(6, "The Lord of the Rings: The Two Towers");
    MovieData movieSeven = new MovieData(7, "The Lord of the Rings: The Fellowship of the Ring");
    MovieData movieEight = new MovieData(8, "Intouchables");
    MovieData movieNine = new MovieData(9, "Pulp Fiction");
    MovieData movieTen = new MovieData(10, "Иван Васильевич меняет профессию");
    MovieData movieEleven = new MovieData(11, "The Lion King");

    @Test
    void shouldCheckMovieLimit() {
        MovieManager manager = new MovieManager();
        int actual = manager.getCountMovies();
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    void shouldAddMovie() {
        MovieManager manager = new MovieManager();
        manager.add(movieTwo);
        manager.add(movieThree);
        MovieData[] expected = {movieTwo, movieThree};
        MovieData[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNullMovie() {
        MovieManager manager = new MovieManager();
        MovieData[] expected = {};
        MovieData[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTenMovies() {
        MovieManager manager = new MovieManager();
        manager.add(movieOne);
        manager.add(movieTwo);
        manager.add(movieThree);
        manager.add(movieFour);
        manager.add(movieFive);
        manager.add(movieSix);
        manager.add(movieSeven);
        manager.add(movieEight);
        manager.add(movieNine);
        manager.add(movieTen);

        MovieData[] expected = {movieOne, movieTwo, movieThree, movieFour, movieFive, movieSix, movieSeven, movieEight, movieNine, movieTen};
        MovieData[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAllMovies() {
        MovieManager manager = new MovieManager(11);
        manager.add(movieOne);
        manager.add(movieTwo);
        manager.add(movieThree);
        manager.add(movieFour);
        manager.add(movieFive);
        manager.add(movieSix);
        manager.add(movieSeven);
        manager.add(movieEight);
        manager.add(movieNine);
        manager.add(movieTen);
        manager.add(movieEleven);

        MovieData[] expected = {movieOne, movieTwo, movieThree, movieFour, movieFive, movieSix, movieSeven, movieEight, movieNine, movieTen, movieEleven};
        MovieData[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastTenMovies() {
        MovieManager manager = new MovieManager(10);
        manager.add(movieOne);
        manager.add(movieTwo);
        manager.add(movieThree);
        manager.add(movieFour);
        manager.add(movieFive);
        manager.add(movieSix);
        manager.add(movieSeven);
        manager.add(movieEight);
        manager.add(movieNine);
        manager.add(movieTen);
        manager.add(movieEleven);

        MovieData[] expected = {movieEleven, movieTen, movieNine, movieEight, movieSeven, movieSix, movieFive, movieFour, movieThree, movieTwo};
        MovieData[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFiveMovies() {
        MovieManager manager = new MovieManager(5);
        manager.add(movieOne);
        manager.add(movieTwo);
        manager.add(movieThree);
        manager.add(movieFour);
        manager.add(movieFive);
        manager.add(movieSix);

        MovieData[] expected = {movieSix, movieFive, movieFour, movieThree, movieTwo};
        MovieData[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}