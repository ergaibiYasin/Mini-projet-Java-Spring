package com.test.interview.dreamcaserastfulapi.controller;

import com.test.interview.dreamcaserastfulapi.model.Case;
import com.test.interview.dreamcaserastfulapi.repository.CaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/cases")
public class CaseController {

    private final CaseRepository caseRepository;

    public CaseController (CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    // Get method for getting a case by id
    @GetMapping("/{id}")
    public ResponseEntity<Case> getCaseById(@PathVariable Long id) {
        Optional<Case> optionalCase = caseRepository.findById(id);
        // Check if case with given ID exists in repository
        if (optionalCase.isPresent()) {
            // If it exists, return a ResponseEntity with the case as the body and 200 OK status
            return ResponseEntity.ok(optionalCase.get());
        }
        // If it doesn't exist, return 404 Not Found response
        return ResponseEntity.notFound().build();
    }

    // PUT method for updating a case by id
    @PutMapping("/{id}")
    public ResponseEntity<Case> updateCase(@PathVariable Long id, @RequestBody Case updatedCase) {
        Optional<Case> optionalCase = caseRepository.findById(id);
        // Check if case with given ID exists in repository
        if (optionalCase.isPresent()) {
            // update the fields of the existing case with the fields of the updated case
            Case existingCase = optionalCase.get();
            existingCase.setTitle(updatedCase.getTitle());
            existingCase.setDescription(updatedCase.getDescription());
            existingCase.setLastUpdateDate(LocalDateTime.now());
            // save the updated case to the database and return 200 OK
            Case savedCase = caseRepository.save(existingCase);
            return ResponseEntity.ok(savedCase);
        }
        // If it doesn't exist, return 404 Not Found response
        return ResponseEntity.notFound().build();

    }

    // POST method for creating a case
    @PostMapping("")
    public ResponseEntity<Case> createCase(@RequestBody Case newCase) {
        // Set the creation date and last update date for the new case
        newCase.setCreationDate(LocalDateTime.now());
        newCase.setLastUpdateDate(LocalDateTime.now());
        // Save the new case to the database
        Case savedCase = caseRepository.save(newCase);
        // Return a response with the new case and a HTTP status code of 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCase);
    }

    // DELETE method for deleting a case by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaseById(@PathVariable Long id) {
        Optional<Case> optionalCase = caseRepository.findById(id);
        // Check if case with given ID exists in repository
        if (optionalCase.isPresent()) {
            // If it exists, delete it and return 204 No Content response
            caseRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        // If it doesn't exist, return 404 Not Found response
        return ResponseEntity.notFound().build();
    }
}
