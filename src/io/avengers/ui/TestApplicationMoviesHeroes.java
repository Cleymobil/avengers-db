package io.avengers.ui;

import io.avengers.service.MoviesHeroesService;

public class TestApplicationMoviesHeroes {

	public static void main(String[] args) throws Exception {
		MoviesHeroesService service = new MoviesHeroesService();
		System.out.println(service.findHeroesbyMovies("Avengers"));
	}

}
