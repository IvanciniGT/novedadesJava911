

MAVEN

    proyecto:
        pom.xml
        src
            main
                java
                resources
            test
                java
                resources
        
        target
    
    mvn GOALs
    
    GOALs: cliclo de vida de un app JAVA de maven
    
    clean                           Borra el target
    compile                         Compila lo que tenemos en: src/main/java        target/classes
        test-compile                Compila lo que tenemos en: src/main/test        target/test-classes
            test                    Ejecuta las pruebas unitarias                   target/surefire-reports/*.xml
                package             Genera el .jar o .war o .ear                    target/
                    install         Copiar el arfactor generado -> ~/.m2
                    
    REPO DE MAVEN LOCAL!
    Carpeta ~/.m2 ?                 Carpeta donde se descargan las dependencias, y dejo mis artefactos
    
    
SonarQube:

% Cobertura de código: % de código respaldado por pruebas unitarias. -> < 80%-90% No pasa !

Legacy flipante! No hay ni una prueba !!! Sonar... 
    para que solo controlo el % cobertuyra en lo nuevo que se metió desde una fecha.
    
    
    
JAVA 9 - Modulo:
    .jar (DEPENDENCIAS DE UN PROYECTO o NUESTRO PROPIO PROYECTO) -> Modulo
    
    Cuando necesitamos usar en un proyecto(un modulo) otro modulo:      MAVEN
        - Necesito el JAR (dependencia)                                     DEPENDENCY
        - Darlo de alta en el module-info.java                              A manita!   -> UnnamedModule J9
    
    Ahora, (hace más de 10 años) que tengo JAVA 9, mi proyecto, lo voy a dividir en MODULOS.
    
    
    Modulo de MAVEN:
        Posibilidad de trabajar con un proyecto dividido en modulos.

Metodologia en Cascada
Requisitos -> Plan + analisis > desarrollo > pruebas -> documentacion -> instalacion/implantación
                                            1 vez al final del proyecto
                                            
Metodologías ágiles: SCRUM 
- Entregar el producto de forma incremental -> Feedback muy rápido 
- Muchas reuniones

Spring 1  Al mes de comenzar      Versión 100% funcional del sistema       10% funcionalidad (pantalla de login)
        PRODUCCION -> Pruebas !!!!      pantalla de login
Spring 2  Al 45 dias              Versión 100% funcional del sistema       15% funcionalidad (pantalla de busqueda)
        PRODUCCION -> Pruebas !!!!      pantalla de busqueda? + pantalla de login

AUTOMATIZAR


----

9
Modulos
Metodos interfaces / private
JShell
Api nueva HTTP* Empezo
.of Collections 

10
var 
.copyOf Collections
Optional .orElseThrow()

11
API HTTP 2
.readString             Files
.writeString
Lambda : var
java Fichero.java -> autocompilado
Cambio en el GC -> Reutiliza asignaciones de memoria, evitando generar tanta basura
---

API HTTP 2              Request-> response
    WebSockets          Connection              Push -> Respuesta

CLIENTE : Una petición :        HttpRequest.builder
HttpRequest request = HttpRequest.newBuilder()
                                 .uri(URI.create("http://foo.com/"))
                                 .POST()
                                 .header("key", "value")
                                 .build();


CLIENTE: La respuesta:          HttpResponse

