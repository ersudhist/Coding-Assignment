package com.ims.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.entity.Institute;
import com.ims.repository.InstituteRepository;

@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    @Override
    public Institute registerInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    @Override
    public Institute updateInstitute(Long id, Institute updatedInstitute) {
        Optional<Institute> existingInstituteOptional = instituteRepository.findById(id);
        if (existingInstituteOptional.isPresent()) {
            Institute existingInstitute = existingInstituteOptional.get();
            existingInstitute.setName(updatedInstitute.getName());
            existingInstitute.setLocation(updatedInstitute.getLocation());
            existingInstitute.setContactInformation(updatedInstitute.getContactInformation());
            existingInstitute.setAdditionalDetails(updatedInstitute.getAdditionalDetails());
            return instituteRepository.save(existingInstitute);
        } else {
            return null; // Handle error when institute not found
        }
    }

    @Override
    public Institute getInstituteById(Long id) {
        return instituteRepository.findById(id).orElse(null);
    }
}

