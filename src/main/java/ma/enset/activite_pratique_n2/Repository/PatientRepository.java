package ma.enset.activite_pratique_n2.Repository;

import jakarta.transaction.Transactional;
import ma.enset.activite_pratique_n2.entities.Patient;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository  extends  JpaRepository<Patient,Long>{

  //Chercher des patients
  List<Patient> findByNomContains(String name);

  // Mettre à jour un patient
  @Modifying
  @Transactional
  @Query("UPDATE Patient p SET p.nom = 'Zineb', p.malade = false WHERE p.id = :id")
  void updatePatient(@Param("id") Long id);
  // supprimer un patient
    @Transactional
    void deletePatientById(Long id);
}
