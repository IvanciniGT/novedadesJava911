package com.curso.diccionario;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface Diccionario {
    static String getIdiomaPorDefecto() {
        String nombreFicheroDeEntradas="default";
        URL rutaFicheroDeEntradas=Diccionario.class.getClassLoader().getResource(nombreFicheroDeEntradas);
        String ficheroDeEntradas= Objects.requireNonNull(rutaFicheroDeEntradas).getFile();
        try {
            return  Files.readString(Path.of(ficheroDeEntradas));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String getIdioma();

    // Estos métodos default se usan para dotar a los interfaces de nuevos
    // métodos, sin necesitar cambiar todas las implemntaciones
    // FACILITAR EL MNTO DE LA APP
    default boolean isPorDefecto() {
        return getIdioma().equals(Diccionario.getIdiomaPorDefecto());
    }

    Optional<String> getSignificado(String termino);

    boolean existe(String termino); // Editar de correo interactivo. Pantallita.
    // Cada palabra que se escriba, saber si existe.. Si no existe: SUBARAYADA ROJO

    List<String> corregir(String termino); // Me da la lista deposibilidades 

}