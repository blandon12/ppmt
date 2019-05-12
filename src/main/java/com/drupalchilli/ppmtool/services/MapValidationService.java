package com.drupalchilli.ppmtool.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationService {

    ResponseEntity<?> run(BindingResult result);
}
