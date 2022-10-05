package com.curso.diccionario.impl;

import com.curso.diccionario.Diccionario;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractDiccionario implements Diccionario {

    private final String idioma;
    private final Map<String, String> terminos;
    private static final int MAX_DIFERENCE=2;

    protected AbstractDiccionario(String idioma) {
        this.idioma = idioma;
        this.terminos = cargarTerminos(); // Esta clase la extenderán otras... Todas leeran el ficheor igual? QUIZAS O NO
    }

    protected Map<String, String> cargarTerminos() {

        Properties terminosLeidos = new Properties();
        String nombreFicheroDeEntradas="diccionario." + this.idioma + ".properties";
        URL rutaFicheroDeEntradas=getClass().getClassLoader().getResource(nombreFicheroDeEntradas);
        String ficheroDeEntradas=Objects.requireNonNull(rutaFicheroDeEntradas).getFile();

        try (FileReader reader = new FileReader(ficheroDeEntradas) ) {
            terminosLeidos.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return terminosLeidos.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString().toLowerCase(),
                        e -> e.getValue().toString()));
    }

    @Override
    public String getIdioma() {
        return this.idioma;
    }

    @Override
    public Optional<String> getSignificado(String termino) {
        return Optional.ofNullable(this.terminos.get(termino.toLowerCase()));
    }

    @Override
    public boolean existe(String termino) {
        return this.terminos.containsKey(termino.toLowerCase());
    }

    @Override
    public List<String> corregir(String terminoACorregir) {
        if(existe(terminoACorregir))return new ArrayList<>();
        /*
        manana < A corregir
        
        TERIMNOS:
        abedul      jklhkjhkjh
        manzana     jklhjkhkjhjkkj
        mañana      kljhkjhjkhjkhkjhkljhkj
        manzano     jkjkhkjlhkjhkhk
        
        abedul   | [  6  , abedul  ]  | [  1  , manzana ]. *    | manzana
        manzana  | [  1  , manzana ]  | [  1  , mañana  ]. **   | mañana
        mañana   | [  1  , mañana  ]  | [  2  , manzano ]. ***  | manzano
        manzano  | [  2  , manzano ]  | [  6  , abedul  ]
                    Entrada puntuada
        */
        String finalTerminoACorregir = terminoACorregir.toLowerCase();
        return this.terminos
                .keySet().parallelStream()                                                                                              // Me quedo con las claves
                .map(entrada -> new EntradaPuntuada(entrada, this.getDiferencias(finalTerminoACorregir, entrada)))    // calculo diferencias
                .filter(entradaPuntuada -> entradaPuntuada.puntuacion < AbstractDiccionario.MAX_DIFERENCE)                                                   // solo con las que tienen menos de 3 diferencias
                //.sorted((entradaPuntuada1, entradaPuntuada2) -> entradaPuntuada1.puntuacion.compareTo(entradaPuntuada2.puntuacion)) // ordeno por diferencias
                .sorted(Comparator.comparing(entradaPuntuada -> entradaPuntuada.puntuacion)) // ordeno por diferencias
                .limit(5)                                                                                               // me quedo con 5
                .map(entradaPuntuada -> entradaPuntuada.entrada)                                          // Me olvido de las diferencias. Me quedo con la palabra
                .collect(Collectors.toList());                                                                          // Convierto en lista
    }

    protected int getDiferencias(String x, String y) {
        if(Math.abs(x.length()-y.length())>=AbstractDiccionario.MAX_DIFERENCE)return AbstractDiccionario.MAX_DIFERENCE;

        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    protected final int costOfSubstitution(final char a, final char b) {
        return a == b ? 0 : 1;
    }

    protected final int min(final int number1, final int number2, final int number3) {
        return Math.min(number1, Math.min(number2, number3));
    }

    private static class EntradaPuntuada {

        public String entrada;
        public Integer puntuacion;

        public EntradaPuntuada(String entrada, int puntuacion) {
            this.entrada = entrada;
            this.puntuacion = puntuacion;
        }
    }
}