package com.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ims.entity.Institute;
import com.ims.service.InstituteService;

@RestController
@RequestMapping("/institutes")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PostMapping
    public ResponseEntity<Institute> registerInstitute(@RequestBody Institute institute) {
        Institute registeredInstitute = instituteService.registerInstitute(institute);
        return new ResponseEntity<>(registeredInstitute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable Long id, @RequestBody Institute updatedInstitute) {
        Institute institute = instituteService.updateInstitute(id, updatedInstitute);
        if (institute != null) {
            return new ResponseEntity<>(institute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable Long id) {
        Institute institute = instituteService.getInstituteById(id);
        if (institute != null) {
            return new ResponseEntity<>(institute, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

