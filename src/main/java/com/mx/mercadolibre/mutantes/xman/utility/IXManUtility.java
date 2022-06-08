package com.mx.mercadolibre.mutantes.xman.utility;

/**
 *
 * This Interface declare function to evaluate dna persons
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 *
 */
public interface IXManUtility {

    /**
     * This method contains logic to evaluate is dna person mutant or human
     *
     * @param dna is array with dan to evaluate
     * @return Boolean with results to evaluate dna person
     */
    Boolean isMutant(String[] dna);

}
