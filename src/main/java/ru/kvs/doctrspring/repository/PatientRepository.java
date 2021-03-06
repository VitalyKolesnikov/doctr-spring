package ru.kvs.doctrspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kvs.doctrspring.model.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.doctor.id=:doctorId AND p.status = 'ACTIVE' ORDER BY p.lastName")
    List<Patient> getActive(long doctorId);

    Patient findByIdAndDoctorId(long id, long doctorId);

}
