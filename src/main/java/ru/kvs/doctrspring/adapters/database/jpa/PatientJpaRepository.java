package ru.kvs.doctrspring.adapters.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kvs.doctrspring.domain.Patient;
import ru.kvs.doctrspring.domain.ids.PatientId;
import ru.kvs.doctrspring.domain.ids.UserId;

import java.util.List;
import java.util.Optional;

public interface PatientJpaRepository extends JpaRepository<Patient, PatientId> {
    @Query("SELECT p FROM Patient p WHERE p.doctorId=:doctorId AND p.status = 'ACTIVE' ORDER BY p.lastName")
    List<Patient> getActive(@Param("doctorId") UserId doctorId);

    Optional<Patient> findByIdAndDoctorId(PatientId id, UserId doctorId);
}
