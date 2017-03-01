package io.avengers.ui;

import io.avengers.service.HeroDataService;

public class TestApplicationHeroData {

	public static void main(String[] args) throws Exception {
		HeroDataService service = new HeroDataService();
		System.out.println(service.findHeroData("Hulk").getIrl());

	}
}
