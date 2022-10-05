package com.curso.diccionario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

class DiccionarioTest {

    private static Diccionario diccionario;

    @BeforeAll
    static void getDiccionario(){
        Iterable<Diccionario> diccionarios = ServiceLoader.load(Diccionario.class);
        DiccionarioTest.diccionario=StreamSupport.stream(diccionarios.spliterator(), true).filter( diccionario-> diccionario.getClass().getName().contains("Espanol") ).findFirst().orElseThrow();
    }

    @Test
    void getIdiomaPorDefecto() {
    }

    @Test
    void getIdioma() {
        assertEquals("ES",DiccionarioTest.diccionario.getIdioma());
    }

    @Test
    void isPorDefecto() {
        assertTrue(DiccionarioTest.diccionario.isPorDefecto());
    }

    @Test
    void getSignificado() {
        Optional<String> significado=DiccionarioTest.diccionario.getSignificado("HOLA");
        Logger.getAnonymousLogger().log(Level.INFO, significado.orElse("NO SE HA ENCONTRADO"));
        assertTrue(significado.isPresent());
    }

    @Test
    void existe() {
        assertTrue(DiccionarioTest.diccionario.existe("Hola"));
    }

    @Test
    void no_existe() {
        assertFalse(DiccionarioTest.diccionario.existe("acelgibero"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"manana","acelgo","oya","monjo","pelita","cordenada"}) // six numbers
    void corregir(String termino) {
        for(int i = 0;i<1;i++) {
            var correcciones = DiccionarioTest.diccionario.corregir(termino);
            Logger.getAnonymousLogger().log(Level.INFO, correcciones.toString());
            assertTrue(correcciones.size() > 0);
        }
    }
}