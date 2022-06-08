package com.mx.mercadolibre.mutantes.xman.controller;

import com.mx.mercadolibre.mutantes.xman.models.AnalyzedTest;
import com.mx.mercadolibre.mutantes.xman.models.Person;
import com.mx.mercadolibre.mutantes.xman.service.IXManService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is controller to access into different functions
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 */
@RestController
@RequestMapping("/x-man")
@RequiredArgsConstructor
public class XManController implements IXManController {

    /**
     * Is instance to access logic implements
     */
    private final IXManService ixManService;

    /**
     * This method is principal function to analyze dna persons
     *
     * @param person Is object with dna to analyze
     */
    @Override
    @PostMapping("/mutant/")
    public ResponseEntity analyzedPerson(@RequestBody Person person) {

        if (ixManService.analyzedPerson(person)) {
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

    }

    /**
     * This method identify total test results
     *
     * @return object {@link Person}
     */
    @Override
    @GetMapping("/stats")
    public AnalyzedTest totalAnalyzedTest() {
        return ixManService.totalAnalyzedTest();
    }
}
