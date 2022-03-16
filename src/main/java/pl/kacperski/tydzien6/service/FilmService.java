package pl.kacperski.tydzien6.service;

import pl.kacperski.tydzien6.model.Film;

import java.util.List;

public interface FilmService {

    List<Film> getAllFilms();

    boolean addFilm(Film film);
}
