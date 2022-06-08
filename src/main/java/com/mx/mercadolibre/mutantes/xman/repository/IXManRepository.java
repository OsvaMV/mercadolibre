package com.mx.mercadolibre.mutantes.xman.repository;

import com.mx.mercadolibre.mutantes.xman.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * This Interface repository to functions
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 *
 */
@Repository
public interface IXManRepository extends CrudRepository<Person, Integer> {
}
