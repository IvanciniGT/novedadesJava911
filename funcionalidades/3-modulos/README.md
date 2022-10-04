modulos
    aplicacion                          - MODULO
        module-info.java
        com.curso.app                   - PAQUETE
                     App.java           - CLASE
                     
    modulo1                             - MODULO
        module-info.java
        com.curso.modulo1               - PAQUETE
                         Clase.java     - CLASE

set PATH=RUTA_JAVA/bin;%PATH%
set JAVA_HOME=RUTA_JAVA

--- Compilar

javac -d compilado \
      --module-source-path modulos \
      modulos/aplicacion/com/curso/app/App.java \
      modulos/aplicacion/module-info.java \
      modulos/moduloa/com/curso/moduloa/Clase.java \
      modulos/moduloa/module-info.java
      
--- Ejecutar
java --module-path compilado -m aplicacion/com.curso.app.App








SonarQube Analisis estatico de código 
-------------------------------------

Smell codes - Que código ATUFA APESTA !!!!
    Malas prácticas

Deuda técnica (horas de trabajo): El tiempo que me costaría arreglar esos smell codes + bugs

Todas las mañanas pasar mi codigo por sonarqube:
Informe de las 20 cosas que he hecho el dia anterior que son ruinosas!
Y las corrijo... 10 minutos. Y ya no las hago más... Y APRENDO. ME HAGO MEJOR PROGRAMADOR !!!!

Complejidad cognitiva:      Cuanto le cuesta a un ser humano entender un programa
Complejidad ciclomática:    Número de caminos que tiene un código
Orden de complejidad de un algoritmo O(n) O(log(n))

if CONDICION1:
    if CONDICION 2:
        //codigo
    else:
        //codigo
    //codigo
else:
    if CONDICION 3:
        //codigo
    //codigo

Complejidad ciclomática: 4

switch (variable1)
    case A
        // CODIGO
    case B
        // CODIGO
    case C
        // CODIGO
    case default
        // CODIGO

Complejidad ciclomática: 4
    



API ????
Application Programming Interface
MODULO: App: Envío de Emails                        (antes de enviar email quiero revisarlo ortográficamente)
             Idioma... en el que lo han escrito.

MODULO: Diccionario / Corrector Ortográfico

Servicio: Diccionario con cuantas clases lo implementamos? Una por idioma

DiccionarioEspañol
DiccionarioIngles
DiccionarioFrances
                    ...

Diccionario: Interfaz
        
    Locale getLocale();
    
    Optional<String> getSignificado(String termino)
    
    boolean existe(String termino)
    
    //New style JAVA+8
    Optional<List<String>> corregir(String termino)
        Que puede ser que devuelva una lista o que no!
        
        optional.empty()
        optional.isPresent()
        optional.get()
        optional.orElse(new ArrayList<String>())
        orElseThrow()
        
    
    // OldStyle
    List<String> corregir(String termino)
        - Lista vacia
        - null
    
    manana
            mañana
            manzana
            
    
    Optional
    
    




 int[] lista = { 1 , 2 }