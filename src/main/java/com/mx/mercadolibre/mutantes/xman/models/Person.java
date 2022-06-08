package com.mx.mercadolibre.mutantes.xman.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * This class contains corresponding information of the people analyzed
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 *
 */
@Getter
@Setter
@ToString
@Entity
@Table
public class Person implements Serializable {

    /**
     * Serial Version
     */
    private static final long serialVersionUID = -3900940191967798828L;

    /**
     * Id is unique identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    /**
     * Adn is the characteristics tu analyzed
     */
    private String[] dna;

    /**
     * Mutant is definition to persons analyzed
     */
    @Column
    private Boolean mutant;

}
