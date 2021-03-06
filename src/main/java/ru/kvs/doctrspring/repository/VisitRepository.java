package ru.kvs.doctrspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kvs.doctrspring.model.Visit;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("SELECT v FROM Visit v WHERE v.doctor.id=:doctorId AND v.status = 'ACTIVE' ORDER BY v.date DESC, v.created DESC")
    List<Visit> getActive(long doctorId);

    @Query("SELECT v FROM Visit v WHERE v.doctor.id=:doctorId AND " +
            "v.patient.id=:patientId AND v.status = 'ACTIVE' ORDER BY v.date DESC, v.created DESC")
    List<Visit> getActiveForPatient(long doctorId, long patientId);

    Visit findByIdAndDoctorId(long id, long doctorId);
}
