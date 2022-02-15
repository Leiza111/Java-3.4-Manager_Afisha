package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private  Movie first = new Movie(1, "First films", "drama");
    private Movie second = new Movie(2, "Second films", "comedy");
    private Movie third = new Movie(3, "Third films", "fantasy");
    private Movie fourth = new Movie(4, "Fourth films", "drama");
    private Movie fifth = new Movie(5, "Fifth films", "fantasy");
    private Movie sixth = new Movie(6, "Sixth films", "cartoon");
    private Movie seventh = new Movie(7, "Seventh films", "comedy");
    private Movie eighth = new Movie(8, "Eightht films", "drama");
    private Movie ninth = new Movie(9, "Ninth films", "fantasy");
    private Movie tenth = new Movie(10, "Tenth films", "drama");
    private Movie eleventh = new Movie(11, "eleven films", "fantasy");

    @Test
    public void shouldGiveFilmsLimit(){
        MovieManager man = new MovieManager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);

        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getRecentMovie();
        assertArrayEquals(expected, actual);
            }

    @Test
    public void shouldGiveFilmsLessLimit(){
        MovieManager man = new MovieManager(7);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);

        Movie[] expected = new Movie[]{seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getRecentMovie();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveFilmsLimitBorders9(){
        MovieManager man = new MovieManager(9);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);


        Movie[] expected = new Movie[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.getRecentMovie();
        assertArrayEquals(expected, actual);
    }
//фильмов больше чем лимит
    @Test
    public void shouldGiveFilmsLimitBorders11(){
        MovieManager man = new MovieManager();
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);

        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, };
        Movie[] actual = manager.getRecentMovie();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveFilmsLimitBorders1(){
        MovieManager man = new MovieManager(1);
        manager.addMovie(first);

        Movie[] expected = new Movie[]{first};
        Movie[] actual = manager.getRecentMovie();
        assertArrayEquals(expected, actual);
    }
    //фильмов меньше чем лимит
    @Test
    public void shouldGiveFilmsLimitBorders0(){
        MovieManager man = new MovieManager(0);

        Movie[] expected = new Movie[]{};
        Movie[] actual = manager.getRecentMovie();
        assertArrayEquals(expected, actual);
    }

}