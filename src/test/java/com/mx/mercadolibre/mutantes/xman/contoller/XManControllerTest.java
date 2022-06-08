package com.mx.mercadolibre.mutantes.xman.contoller;

import com.mx.mercadolibre.mutantes.xman.controller.XManController;
import com.mx.mercadolibre.mutantes.xman.models.AnalyzedTest;
import com.mx.mercadolibre.mutantes.xman.models.Person;
import com.mx.mercadolibre.mutantes.xman.service.IXManService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class XManControllerTest {

    @InjectMocks
    private XManController xManController;

    @Mock
    private IXManService ixManService;

    @Test
    void analyzedPersonTrueTest(){

        when(ixManService.analyzedPerson(any(Person.class))).thenReturn(true);

        ResponseEntity responseEntity = xManController.analyzedPerson(new Person());

        assertNotNull(responseEntity);

    }

    @Test
    void analyzedPersonFalseTest(){

        when(ixManService.analyzedPerson(any(Person.class))).thenReturn(false);

        ResponseEntity responseEntity = xManController.analyzedPerson(new Person());

        assertNotNull(responseEntity);

    }

    @Test
    void totalAnalyzedTestTest(){

        when(ixManService.totalAnalyzedTest()).thenReturn(new AnalyzedTest());

        AnalyzedTest analyzedTest = xManController.totalAnalyzedTest();

        assertNotNull(analyzedTest);

    }

}
