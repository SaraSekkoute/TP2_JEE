package ma.enset.activite_pratique_n2;

import ma.enset.activite_pratique_n2.Repository.PatientRepository;
import ma.enset.activite_pratique_n2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ActivitePratiqueN2Application implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;



	public static void main(String[] args) {
		SpringApplication.run(ActivitePratiqueN2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		//Ajouter des patients
		patientRepository.save(new Patient(null,"ahmed",new Date(),true,4));
		patientRepository.save(new Patient(null,"sara",new Date(),true,3));
		patientRepository.save(new Patient(null,"salma",new Date(),false,5));

		//Consulter tous les patients
		System.out.println("Consulter tous les patients");
		List<Patient> p1=patientRepository.findAll();
		p1.forEach(p->{
			System.out.println(p.toString());
		});

		//Consulter un patient
		int id_consulter=136;
		System.out.println("Consulter un patient par identifiant ("+id_consulter+") ");
		Patient p =patientRepository.findById(Long.valueOf(id_consulter)).get();
		System.out.println(p.getNom());
		System.out.println(p.getDateN());
		System.out.println(p.getScore());

		//Chercher des patients
		System.out.println("Chercher des patients par nom contient un 's'");
		List<Patient>  p2=patientRepository.findByNomContains("s");
		p2.forEach(n->{
			System.out.println(n.toString());
		});

		//Mettre à jour un patient
		Long id_update= 136L;
		System.out.println("Mettre à jour un patient par identifiant("+id_update+") ");
		patientRepository.updatePatient(id_update);

		//supprimer un patient
		Long id_delete=137L;
		System.out.println("Supprimer un patient par identifiant ("+id_delete+") ");
		patientRepository.deletePatientById(id_delete);


		List<Patient> p4=patientRepository.findAll();
		p4.forEach(p5->{
			System.out.println(p5.toString());
		});



	}
}
