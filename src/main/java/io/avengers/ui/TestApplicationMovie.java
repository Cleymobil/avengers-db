package io.avengers.ui;

import java.util.Set;

import io.avengers.domain.Movie;
import io.avengers.service.MovieService;

public class TestApplicationMovie {

	public static void main(String[] args) throws Exception {

		
		
		MovieService service = new MovieService();
		 //System.out.println(service.findAll());

		// recherche tous les films pareil au nom
		 Set<Movie> movies = service.findMoviesByName("man");
		 for (Movie m : movies){
		 System.out.println(m.getName());
		}

		// chercher la data d'un film

		// MovieService service = new MovieService();
		//System.out.println(service.findMoviesByName(""));

		// System.out.println(service.findMovieData("Avengers"));

	}

}
