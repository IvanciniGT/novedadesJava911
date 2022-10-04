package com.curso.diccionario;
//import 

public abstract class AbstractDiccionario implements Diccionario {
    
    private String idioma;
    private Map<String, String> terminos;
    private boolean diccionarioPorDefecto
    
    protected AbstractDiccionario(String idioma, boolean diccionarioPorDefecto) {
        this.idioma=idioma;
        this.diccionarioPorDefecto=diccionarioPorDefecto
        this.terminos=cargarTerminos(); // Esta clase la extenderán otras... Todas leeran el ficheor igual? QUIZAS O NO
    }
    
    protected Map<String,String> cargarTerminos() {

        Properties terminosLeidos = new Properties();

        try(FileReader reader = new FileReader(getClass().getClassLoader().getResource("diccionarios/diccionario."+this.idioma+".properties"))){
            terminosLeidos.load(reader);
        }

        return terminosLeidos.entrySet()
                     .stream()
                     .collect(Collectors.toMap(e -> e.getKey().toString().toLowerCase(), 
                                               e -> e.getValue().toString()));
    }
    
    @Override
    public String getIdioma(){
        return this.idioma;
    }
    
    @Override
    public boolean isPorDefecto(){
        return this.diccionarioPorDefecto;
    }
    
    @Override
    public Optional<String> getSignificado(String termino){
        return Optional.ofNullable(this.terminos.get(termino.toLowerCase()));
    }
    
    @Override
    public boolean existe(String termino){
        return this.terminos.containsKey(termino.toLowerCase());
    }
    
    @Override
    public List<String> corregir(String terminoACorregir){
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
        terminoACorregir=terminoACorregir.toLowerCase();
        
        return this.terminos
            .keySet().parallelStream()                                                                                              // Me quedo con las claves
            .map(        entrada              -> new EntradaPuntuada(entrada, this.getDiferencias(terminoACorregir, entrada))  )    // calculo diferencias
            .filter(     entradaPuntuada      -> entradaPuntuada.puntuacion < 3 )                                                   // solo con las que tienen menos de 3 diferencias
            .sorted(     (entradaPuntuada1, entradaPuntuada2) -> entradaPuntuada1.puntuacion.compareTo(entradaPuntuada2.puntuacion)  ) // ordeno por diferencias
            .limit(5)                                                                                               // me quedo con 5
            .map(        entradaPuntuada      -> entradaPuntuada.termino )                                          // Me olvido de las diferencias. Me quedo con la palabra                               
            .collect(Collectors.toList());                                                                          // Convierto en lista
    }

    protected int getDiferencias(String x, String y){
        int[][] dp = new int[x.length() + 1][y.length() + 1];
    
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1] 
                     + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
                      dp[i - 1][j] + 1, 
                      dp[i][j - 1] + 1);
                }
            }
        }
    
        return dp[x.length()][y.length()];
    }
    
    private class EntradaPuntuada{
        
        public String entrada;
        public int puntuacion;
        
        public EntradaPuntuada(String entrada, int puntuacion){
            this.entrada=entrada;
            this.puntuacion=puntuacion;
        }
    }
}