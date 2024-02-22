package com.ims.service;


import com.ims.entity.Institute;

public interface InstituteService {
    Institute registerInstitute(Institute institute);
    Institute updateInstitute(Long id, Institute updatedInstitute);
    Institute getInstituteById(Long id);
}
