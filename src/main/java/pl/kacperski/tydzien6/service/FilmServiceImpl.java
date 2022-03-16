package pl.kacperski.tydzien6.service;


import org.springframework.stereotype.Service;
import pl.kacperski.tydzien6.model.Film;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {


    private List<Film> filmList = new ArrayList<>();

    public FilmServiceImpl() {
        filmList.add(new Film("OBCY - 8. PASAŻER NOSTROMO", 1979, "Ridley Scott"));
        filmList.add(new Film("OBCY - DECYDUJĄCE STARCIE", 1986, "James Cameron"));
        filmList.add(new Film("OBCY 3", 1992, "David Fincher"));
    }

    private List<Film> listOfFilms() {
        return filmList;
    }

    @Override
    public List<Film> getAllFilms() {
        return listOfFilms();
    }

    @Override
    public boolean addFilm(Film film) {
        return listOfFilms().add(film);
    }
}
