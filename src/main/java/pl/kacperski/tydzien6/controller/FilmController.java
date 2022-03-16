package pl.kacperski.tydzien6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kacperski.tydzien6.aspect.FilmAspectAdn;
import pl.kacperski.tydzien6.model.Film;
import pl.kacperski.tydzien6.service.FilmService;

@Controller
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/film")
    public String getCar(Model model) {
        model.addAttribute("films", filmService.getAllFilms());
        model.addAttribute("newFilm", new Film());

        return "film";
    }

    @PostMapping("/addFilm")
    @FilmAspectAdn
    public String addCar(@ModelAttribute Film film){
        filmService.addFilm(film);
        return "redirect:/film";
    }
}
