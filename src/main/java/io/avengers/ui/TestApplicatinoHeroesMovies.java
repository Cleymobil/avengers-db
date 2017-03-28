package io.avengers.ui;

import io.avengers.service.HeroesMoviesService;


public class TestApplicatinoHeroesMovies {
	public static void main(String[] args) throws Exception {
		
		HeroesMoviesService service = new HeroesMoviesService();
		System.out.println(service.findMoviesByHeroesname("man"));
	}
}
