package com.mx.mercadolibre.mutantes.xman.controller;

import com.mx.mercadolibre.mutantes.xman.models.AnalyzedTest;
import com.mx.mercadolibre.mutantes.xman.models.Person;
import org.springframework.http.ResponseEntity;

/**
 *
 * This Interface declare all functions in this services
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 *
 */
public interface IXManController {

    /**
     * This method is principal function to analyze dna persons
     *
     * @param person Is object with dna to analyze
     */
    ResponseEntity analyzedPerson (Person person);

    /**
     * This method identify total test results
     *
     * @return object {@link Person}
     */
    AnalyzedTest totalAnalyzedTest();

}
