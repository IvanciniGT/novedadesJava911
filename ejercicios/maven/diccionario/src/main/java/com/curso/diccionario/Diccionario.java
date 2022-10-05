package com.curso.diccionario;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
//import lombok.NonNull;

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

                                    // JAVA 8. No la anotación
                                    // Es la posibilidad de meter anotaciones en este trozo de código
    Optional<String> getSignificado(/*@NonNull*/ String termino);

    boolean existe(/*@NonNull*/ String termino); // Editar de correo interactivo. Pantallita.
    // Cada palabra que se escriba, saber si existe.. Si no existe: SUBARAYADA ROJO

    List<String> corregir(/*@NonNull*/ String termino); // Me da la lista deposibilidades 

}