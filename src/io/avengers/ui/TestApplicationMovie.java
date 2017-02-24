package io.avengers.ui;


import io.avengers.service.MovieService;

public class TestApplicationMovie {

	public static void main(String[] args) throws Exception {
		// MovieService service = new MovieService();
		// System.out.println(service.findAll());
		MovieService service = new MovieService();
		System.out.println(service.findMoviesByName("man"));
	}

}
