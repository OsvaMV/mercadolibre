package com.mx.mercadolibre.mutantes.xman.utility;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class XManUtilityTest {

    @InjectMocks
    private XManUtility xManUtility;

    @Test
    void isMutantTest(){

        Boolean result = xManUtility.isMutant(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});

        assertNotNull(result);

    }

    @Test
    void isMutantValidateMatrixErrorTest(){

        Boolean result = xManUtility.isMutant(new String[]{"ATGBGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});

        assertNotNull(result);

    }

    @Test
    void isMutantValidateMatrixError2Test(){

        Boolean result = xManUtility.isMutant(new String[]{"ATGGATT","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});

        assertNotNull(result);

    }

    @Test
    void isMutantHorizontalTest(){

        Boolean result = xManUtility.isMutant(new String[]{"CTGGAT","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});

        assertNotNull(result);

    }

}
