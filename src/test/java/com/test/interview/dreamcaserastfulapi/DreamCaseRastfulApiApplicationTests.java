package com.test.interview.dreamcaserastfulapi;

import com.test.interview.dreamcaserastfulapi.controller.CaseController;
import com.test.interview.dreamcaserastfulapi.model.Case;
import com.test.interview.dreamcaserastfulapi.repository.CaseRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DreamCaseRastfulApiApplicationTests {

	@Mock
	private CaseRepository caseRepository;

	@InjectMocks
	private CaseController caseController;

	private Case testCase;

	@Before
	public void setUp() {
		testCase = new Case();
		testCase.setId(1L);
		testCase.setTitle("Test Case");
		testCase.setDescription("Test Description");
		testCase.setCreationDate(LocalDateTime.now());
		testCase.setLastUpdateDate(LocalDateTime.now());
	}

	// Tests that the createCase method of the CaseController correctly creates a new case
	@Test
	public void testCreateCase() {
		Case newCase = new Case();
		newCase.setTitle("New Title");
		newCase.setDescription("New Description");

		when(caseRepository.save(any(Case.class))).thenReturn(newCase);

		ResponseEntity<Case> response = caseController.createCase(newCase);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(newCase, response.getBody());
	}

	// Tests that the getCaseById method of the CaseController returns a NOT_FOUND status for a non-existent ID
	@Test
	public void testGetCaseByIdNotFound() {
		Long id = 2L;
		when(caseRepository.findById(id)).thenReturn(Optional.empty());
		ResponseEntity<Case> response = caseController.getCaseById(id);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	// Tests that the updateCase method of the CaseController returns a NOT_FOUND status for a non-existent ID
	@Test
	public void testUpdateCaseNotFound() {
		Long id = 2L;
		Case updatedCase = new Case();
		updatedCase.setTitle("Updated Title");
		updatedCase.setDescription("Updated Description");

		when(caseRepository.findById(id)).thenReturn(Optional.empty());

		ResponseEntity<Case> response = caseController.updateCase(id, updatedCase);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}
