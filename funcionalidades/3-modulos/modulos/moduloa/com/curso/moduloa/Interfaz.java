package com.curso.moduloa;

public interface Interfaz{
    
    String dameTexto();
    
    public static dameOtroTexto(){
        return "OTRO TEXTO" + dameOtroTexto2();
    }

    private static dameOtroTexto2(){
        return "OTRO TEXTO2";
    }
    
    default String dameTexto3(){  // Metodos básicos internos de la interfaz
        return "OTRO TEXTO3";
    }
    
    // Van a cargar todos ficheros de la misma forma (properties)
    default String leerFicheroDicccionario(String idioma){  // Metodos básicos internos de la interfaz
        // Código
    }
    // No necesito una ClaseAbstracta

}