package com.mx.mercadolibre.mutantes.xman.models;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(MockitoExtension.class)
class AnalyzedTestTest {

    private final AnalyzedTest analyzedTest = new AnalyzedTest();

    @Test
    void testAnalyzedTest () throws IOException {

        analyzedTest.setCountHumanDna(1);
        analyzedTest.setCountMutantDna(1);

        assertNotNull(analyzedTest.getCountHumanDna());
        assertNotNull(analyzedTest.getCountMutantDna());

        log.info(analyzedTest.toString());

    }

}

