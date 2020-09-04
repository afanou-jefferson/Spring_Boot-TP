package dev.mission.exec;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("afficherMissions")
public class ListerProchainesMissions implements Runnable {

	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		List<Mission> listeMissionFromNow = missionRepository.findAllDateDebutSupToday();

		if (!listeMissionFromNow.isEmpty()) {
			for (Mission mission : listeMissionFromNow) {
				System.out.println(mission.toString());
			}
		} else {
			System.out.println("Il n'existe pas de mission répertoriée dans le futur.");
		}
	}

}
