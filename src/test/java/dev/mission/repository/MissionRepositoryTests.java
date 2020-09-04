package dev.mission.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;

@DataJpaTest
class MissionRepositoryTests {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	MissionRepository missionRepository;

	@Test
	@Transactional
	void findByDateDebutGreaterThanEqual() {

		Mission missionToInsert = new Mission();
		missionToInsert.setLibelle("Mission 1");
		missionToInsert.setTauxJournalier(new BigDecimal("100.90"));
		missionToInsert.setDateDebut(LocalDate.of(2030, 1, 1));
		missionToInsert.setDateFin(LocalDate.of(2030, 3, 4));

		missionRepository.save(missionToInsert);

		// execution Via @Transactionnal ?

		List<Mission> listeQuery = missionRepository.findByDateDebutGreaterThanEqual(LocalDate.of(2025, 3, 4));

		assertThat(listeQuery).isNotEmpty();

	}

	@Test
	@Transactional
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		Mission missionToInsert = new Mission();
		missionToInsert.setLibelle("Mission 1");
		missionToInsert.setTauxJournalier(new BigDecimal("100.90"));
		missionToInsert.setDateDebut(LocalDate.of(2030, 1, 1));
		missionToInsert.setDateFin(LocalDate.of(2030, 3, 4));

		missionRepository.save(missionToInsert);

		BigDecimal myTjm = BigDecimal.valueOf(900.0);
		List<Mission> listeQuery = missionRepository
				.findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual(LocalDate.of(2025, 3, 4), myTjm);

		assertThat(listeQuery).isEmpty();
	}
}