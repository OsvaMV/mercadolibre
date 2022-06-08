package com.mx.mercadolibre.mutantes.xman.service;

import com.mx.mercadolibre.mutantes.xman.models.AnalyzedTest;
import com.mx.mercadolibre.mutantes.xman.models.Person;

/**
 *
 * This Interface declare all functions in this services
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 *
 */
public interface IXManService {

    /**
     * This method is principal function to analyze dna persons
     *
     * @param person Is object with dna to analyze
     */
    Boolean analyzedPerson(Person person);

    /**
     * This method identify total test results
     *
     * @return object {@link Person}
     */
    AnalyzedTest totalAnalyzedTest();

}
