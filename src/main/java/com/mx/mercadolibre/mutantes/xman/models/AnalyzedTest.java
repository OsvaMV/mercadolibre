package com.mx.mercadolibre.mutantes.xman.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 * This class contains the total test results
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 *
 */
@Getter
@Setter
@ToString
public class AnalyzedTest implements Serializable {

    /**
     * Serial Version
     */
    private static final long serialVersionUID = -4889136900292409889L;

    /**
     * Total mutant people
     */
    @JsonProperty("count_mutant_dna")
    private Integer countMutantDna;

    /**
     * Total human people
     */
    @JsonProperty("count_human_dna")
    private Integer countHumanDna;

}
