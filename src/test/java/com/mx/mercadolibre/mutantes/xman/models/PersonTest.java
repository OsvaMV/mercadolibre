package com.mx.mercadolibre.mutantes.xman.models;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(MockitoExtension.class)
class PersonTest {

    private final Person person = new Person();

    @Test
    void testAnalyzedTest () throws IOException {

        person.setId(1);
        person.setMutant(true);
        person.setDna(new String[]{"ATCG", "ATCG"});

        assertNotNull(person.getDna());
        assertNotNull(person.getMutant());

        log.info(person.toString());

    }

}
