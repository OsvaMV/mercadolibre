package com.mx.mercadolibre.mutantes.xman.service;
import com.mx.mercadolibre.mutantes.xman.models.AnalyzedTest;
import com.mx.mercadolibre.mutantes.xman.models.Person;
import com.mx.mercadolibre.mutantes.xman.repository.IXManRepository;
import com.mx.mercadolibre.mutantes.xman.utility.IXManUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class XManServiceTest {

    @Mock
    private IXManUtility ixManUtility;

    @Mock
    private IXManRepository ixManRepository;

    @InjectMocks
    private XManService xManService;

    @Test
    void analyzedPersonTrueTest(){

        Person person = new Person();

        person.setDna(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});

        when(ixManUtility.isMutant(person.getDna())).thenReturn(true);

        Boolean result = xManService.analyzedPerson(person);

        assertNotNull(result);

    }

    @Test
    void analyzedPersonFalseTest(){

        Person person = new Person();

        person.setDna(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});

        when(ixManUtility.isMutant(person.getDna())).thenReturn(false);

        Boolean result = xManService.analyzedPerson(person);

        assertNotNull(result);

    }

    @Test
    void totalAnalyzedTestTest(){

        Person person1 = new Person();
        Person person2 = new Person();

        person1.setMutant(true);
        person2.setMutant(false);

        List<Person> personList = new ArrayList<>();

        personList.add(person1);
        personList.add(person2);


        when(ixManRepository.findAll()).thenReturn(personList);

        AnalyzedTest analyzedTest = xManService.totalAnalyzedTest();

        assertNotNull(analyzedTest);

    }

}
