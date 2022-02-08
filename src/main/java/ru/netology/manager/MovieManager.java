package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int recentMovies = 10;

    //конструкторы
    public MovieManager() { //конструктор без параметров
    }

    public MovieManager(int recentMovies) { //конст.с  параметром
        this.recentMovies = recentMovies;
    }

    public void addMovie(Movie movie) {
        // создаём новый массив размером на единицу больше
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        //копируем
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

//    //найди все элементы, которые ты заполнил
//    public Movie[] () {
//        return movies;
//    }

    //вывод последних фильмов
    public Movie[] getRecentMovie() {
        int resultLength;
        if (movies.length > recentMovies) {
            resultLength = recentMovies;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i=0; i < resultLength; i++){
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}
