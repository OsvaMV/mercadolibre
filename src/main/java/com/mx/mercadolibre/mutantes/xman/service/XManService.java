package com.mx.mercadolibre.mutantes.xman.service;

import com.mx.mercadolibre.mutantes.xman.models.AnalyzedTest;
import com.mx.mercadolibre.mutantes.xman.models.Person;
import com.mx.mercadolibre.mutantes.xman.repository.IXManRepository;
import com.mx.mercadolibre.mutantes.xman.utility.IXManUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * This class is Service to logic implements in all functions
 *
 * @author Osvaldo Mata Vega
 * @version 0.1
 */
@Service
@RequiredArgsConstructor
public class XManService implements IXManService {

    /**
     * Instance to access utility logic
     */
    private final IXManUtility ixManUtility;

    /**
     * Instance to use repository functions
     */
    private final IXManRepository ixManRepository;

    /**
     * This method is principal function to analyze dna persons
     *
     * @param person Is object with dna to analyze
     */
    @Override
    public Boolean analyzedPerson(Person person) {

        if (ixManUtility.isMutant(person.getDna())) {
            person.setMutant(true);
            ixManRepository.save(person);
            return true;
        } else {
            person.setMutant(false);
            ixManRepository.save(person);
            return false;
        }

    }

    /**
     * This method identify total test results
     *
     * @return object {@link Person}
     */
    @Override
    public AnalyzedTest totalAnalyzedTest() {

        List<Person> personList = (List<Person>) ixManRepository.findAll();

        AnalyzedTest analyzedTest = new AnalyzedTest();

        AtomicReference<Integer> countMutant = new AtomicReference<>(0);
        AtomicReference<Integer> countHuman = new AtomicReference<>(0);

        personList.forEach(pl -> {
            if(pl.getMutant()){
                countMutant.getAndSet(countMutant.get() + 1);
            }else {
                countHuman.getAndSet(countHuman.get() + 1);
            }
        });

        analyzedTest.setCountMutantDna(countMutant.get());
        analyzedTest.setCountHumanDna(countHuman.get());

        return analyzedTest;
    }

}
