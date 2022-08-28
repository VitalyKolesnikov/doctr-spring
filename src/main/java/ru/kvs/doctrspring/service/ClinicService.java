package ru.kvs.doctrspring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kvs.doctrspring.model.BaseEntity;
import ru.kvs.doctrspring.model.Clinic;
import ru.kvs.doctrspring.repository.ClinicRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;

    @Transactional(readOnly = true)
    public List<Clinic> getAll(Long userId) {
        List<Clinic> clinics = clinicRepository.findAllByDoctorId(userId);
        return clinics.stream()
                .filter(BaseEntity::isActive)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Clinic get(long id, long doctorId) {
        return clinicRepository.findByIdAndDoctorId(id, doctorId);
    }

}
