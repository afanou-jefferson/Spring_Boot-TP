package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("afficherMissionsTJM")
public class ListerProchainesMissionsParTJM implements Runnable {

	private MissionRepository missionRepository;

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		Scanner myScanner = new Scanner(System.in); // Create a Scanner object

		System.out.println("Veuillez entrer le TJM minimum requis");

		Double tjmMin = Double.parseDouble(myScanner.nextLine()); // On cast l'input en integer

		List<Mission> listeQuery = missionRepository.findAllMissionTJMSup(BigDecimal.valueOf(tjmMin));

		for (Mission mission : listeQuery) {
			System.out.println(mission.toString());
		}

	}

}
