package io.avengers.jpa;

import javax.persistence.EntityManager;

import io.avengers.domain.Hero;
import io.avengers.domain.Team;

public class JpaApplication {

	public static void main(String[] args) {
		System.out.println("ddl complete");
		try {
			new JpaApplication().createData();
		} finally {
			EmFactory.getInstance().close();
		}
	}

	public void createData() {
		// We start

		EntityManager em = EmFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			System.out.println("  ========== STARTING WORK ======= ");

			Team avengers = new Team("Avengers", "people who cares");
			em.persist(avengers);
			Hero hulk = new Hero("Hulk", "tururu", avengers.getId());
			hulk.setT(avengers);
			Hero ironman = new Hero("Ironman", "tonton", avengers.getId());
			ironman.setT(avengers);
			em.persist(hulk);
			em.persist(ironman);

			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
