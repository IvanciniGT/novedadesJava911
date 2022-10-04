package com.curso.diccionario;

public interface Diccionario {
    
    String getIdioma();
    
    boolean isPorDefecto();
    
    Optional<String> getSignificado(String termino);
    
    boolean existe(String termino);
    
    List<String> corregir(String termino);

}