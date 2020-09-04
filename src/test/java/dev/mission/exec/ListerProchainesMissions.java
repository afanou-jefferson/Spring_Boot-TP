package dev.mission.exec;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@SpringBootApplication
class ListerProchainesMissions {

	@Autowired
	MissionRepository missionRepo;

	@Test
	void testAfficherMissionFromNow() { // TODO Not working see later
		List<Mission> listeQuery = missionRepo.findAllDateDebutSupToday();
		assertThat(listeQuery).isNotEmpty();
	}

}
