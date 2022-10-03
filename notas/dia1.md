JAVA

Lenguaje de programación:
- Orientado a objetos
- Tipado ESTATICO/dinamico              var INFERIR EL TIPO
- Compilación + Interpretación (Multiplataforma)
    bytecode  -> JVM 
    ^
    JAVA
    Kotlin
    SCALA

Variable
--------

Referencia a una ubicación en la memoria de la JVM

1- String texto = new String("hola");
    1ª                  new String("hola");     --->   Mete en la RAM un objeto String nuevo (HOLA)
    2ª                  String texto            --->   Define una variable... que apuntará a un STRING
    3º                  =                       --->   Que mi variable referencia al objecto STRING que acabamos de crear

2- texto = new String("ADIOS");
    1ª                  new String("ADIOS");    --->   Mete en la RAM un objeto String nuevo (ADIOS)
    2º                  texto=                  --->   Que mi variable referencia al objecto STRING que acabamos de crear
    
Cuantas cosas hay en la RAM? 
String1 - Hola                  ---> BASURA !   ....   Será eliminada por el recolector de basura.
String2 - ADIOS < ----- texto
    
                                                                        SO
                                                                        
Lenguaje C--> compilado .c  ----> compilación --> .obj --> linkado ---> bin
Lenguaje JS / python    .js ----> intérprete  --> SO
                        .py         JustInTime Compiler --> Hotspot (cache de compilaciones)        WARM UP TIME


Paradigma de programación: Una forma de escribir el código.
- Imperativo:               if, else, while, for 
- Procedurales:             Definir procedimientos o funciones (métodos) que permiten reutilizar código.
- Funcional:                Capacidad de que una variable referencie una función. 
                            Las funciones también son objetos que tengo guardados en la RAM. Esto implica:
                            - Puedo pasar funciones a otras funciones como argumentos.
                            - Una función puede devolver otra función.
                            +1.8     Operador ":"
                            Consumer<String> impresor = System.out:println;      <<< Referencia a una función
                            miprograma.imprime(impresor);

                            LAMBDA: Función anónima... sin nombre
                            
                            PAQUETE NUEVO : java.util.function
                            
- Orientación a objetos:    Agrupando esos procedimientos (clases), junto con datos, para escribir código de forma que sea
                            más facilmente legible y mantenible: CLASE, HERENCIA, INTERFAZ, POLIMORFISMO, SOBREESCRITURA

VERSIONES DE JAVA: Los primeros años de los 2000-2005-2008 ... Se fue al pozo
PYTHON y JS (Más utilizado del mundo) y C# (el JAVA bien hecho)

NodeJS / ES6 / ES7........ VM de Javascript

Google < JAVA lenguaje de desarrollo para Android

Cada 6 meses
19  ............
18          2022
17          2021
16          2021
15          2020
14          2020
13          2019
12          2019
11          2018
10          2018
9           2017    < --------- MODULOS                                                         + module
8           2014                                                                                class, interface
    < ----------------  Pues... hay que rentabilizarlo... Empamos a cobrar por JAVA 
                            Usuario normal: 25$ al año por JAVA
                            Servidor 50$ por core al mes
7           2011
    < ----------------  Compra por parte de Oracle de Sun microsystems (Procesadores SPARC + Solaris)
6           2006

            

    Oracle JDK
    Open JDK
    Temurin 
    Amazon

    JEE  <<< Jakarta Enterprise Edition
    JEE  <<< Java Enterprise Edition
    J2EE <<< Java Enterprise Edition < Colección de Estándares: JMS, JDBC, (Servlets, JSPs, JFCs)

JAVA
Hudson              A LA RUINA !!!! ----> Jenkins!
OpenOffice          A LA RUINA !!!! ----> LibreOffice
MySQL               A LA RUINA !!!! ----> MariaDB

----
ENCAPSULACION
    get / set
-----

Modificadores de privacidad en JAVA
 - public                       TODO EL MUNDO ACCEDE
 - protected                    SOLAMENTE DEL PAQUETE
                                Y HEREDADOS
 - private                      SOLO LA CLASE
 - friendly (no poner nada)     SOLO EL PAQUETE


 - JAVA 1.1 : private protected EN 1.2 FUERA !!!!



----
Anotaciones:
Cómo se escriben en JAVA? @NombreDeLaAnotación

Qué aportan?
- Informan sobre algo del código
- Instrucciones al compilador
- Que quiera ejecutar un código asociado 

---

Cómo veis los modificadores de privacidad en JAVA? 
SUFICIENTES? NO

En qué casos?

MAVEN !!!!
Coordenadas de una libreria:
- groupID
- artifactID
- version
    2.7.4
    2: Mayor        Incrementos de funcionaldiad que no tienen 
                    por qué respectar compatibilidad hacia atrás
    7: Minor        Incrementos de funcionalidad
    4: Micro        Arreglar bugs

<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>2.7.3</version>
    <scope>compile</scope> test | provided
</dependency>

### CAGADA 1 de la sintaxis de JAVA

Servicio Web para la gestión de un carrito de la compra de un site.
Tienda de Refrescos Lopez !!!!!

groupId: com.refrescoslopez.site
artifact: carritocompra
version: 1.0.0

paquete JAVA: 
    com.refrescoslopez.site.carritocompra
                                         .models
                                            Producto.java
                                            Carrito.java
                                         .controllers
                                            CarritoControlador.java
                                                añadirProducto(producto, usuario)
                                                    ---> persistirProducto
                                         .database
                                                   .mongo
                                                         .persistirProducto(producto, usuario)
                                                   .sql
                                                         .persistirProducto(producto, usuario)
---
package com.refrescoslopez.site.carritocompra.models;

public class Producto

persistirProducto < Publicas 

Lo meto todo en un JAR ->           com.refrescoslopez.site.carritocompra-v1.0.0.jar

-----
paquete JAVA: 
    com.refrescoslopez.site.gestionusuarios
Lo meto todo en un JAR ->           com.refrescoslopez.site.gestionusuarios-v1.0.0.jar

CarritoCompra, debe acceder a las clases/metodos de Gestión de usuarios?

UsuariosController.existeUsuarios(id) -> True o False

clase controllers.UsuariosController, cómo debe estar dado de alta en el paquete?    PUBLICA
clase persistence.PersistenciaDeUsuarios. PersistirUsuario?                          PUBLICA

Quiero que desde carrito de la compra (JAR) -> PersistirUsuario?    NUNCA JAMAS 
Hay manera de evitar esto en JAVA : HASTA JAVA 9 NO !!!
----

Arquitecturas de Microservicios!!!! < Springboot <<<< 
                                            Framework por excelencia en JAVA para microservicios

Apps. monoliticas!                      RUINA DESCOMUNAL !!!!!
    APP WEB -> WAR | EAR -> Serv. Aplicaciones JEE (tomcat, Wildfly, Weblogic, Websphere)

    Montar el site de la tienda de Refrescos Lopez

App microservicios
    Servicio usuarios registrados -> Tomcat         JAVA    .jar (embebido el tomcat)
        v1  
        v2  Paralelo con la v1
    Servicio gestión del almacen  -> Tomcat
    Servicio Facturación
    Servicio Busquedas
    Servicio Imprimir un informe global
    Servicio del carrito de la compra               PYTHON
        v2  Gestión de usuarios
        
Microservicio: Es un programa (conjunto de programa) que gestionan una funcionalidad UNICA Y REDUCIDA
Independiente del resto del sistema

Esas apps se comunicacn entre si mediante procotolo REST (HTTP), JSON


### CAGADA 2 de la JVM... y de la sintaxis (reflection)

Reflection: Atacar directamente a la memoria RAM de la VM y de ella sacar objetos 
e invocar directamente a sus propiedades, datos, incluso PRIVADOS.

Monitorización de un Sistema (app web) :
Dump memoria JVM: Coger toda la memoria de JVM y tirarla a un fichero---> Tarjetas de credito, Emails
Cualquier tio/a que tenga acceso al servidor de producción... Sin ni una puñetera contraseña !

Class.forName("String una clase") < reflection

Object. lista de todas sus propiedades (privadas)

### CAGADA 3 de la JVM 

Cuando arranco la JVM que se carga? que va ahi dentro? 
Criptografía - Lo necesito? a veces... a veces no... para que voy a cargarlo si no lo quiero

JAVA tiene un huevo de paquetes básicos. Necesito todos en todos los proyectos? NI DE COÑA

JVM :   rt.jar
        tools.jar

------

Surge el concepto de MODULO en JAVA 9 - PROYECTO Jigsaw:
- Hacer que la JVM y el JDK se puedan descomponer en proyectos más pequeños 
    -> Mantenimiento más sencillo de la VM
    -> Despliegues más pequeños
- Mejorar la seguridad de las apps en JVM
- Mejora el rendimiento
- Facilitar a los eq. de desarrollo la creación y mnto de grandes librerias de apps.

----
Puedo listar los módulos de la JVM con : 
$ java --list-modules

Módulo java.desktop: AWT -> Swing... Quiero esto ? Para nada !
                     Applets -> @Deprecated
---

En Java9 surge la palabra: module!

Un módulo es un conjunto de paquetes:

    modulos:
        paquetes:
            clases
            interfaces
            
Los módulos tienen UN fichero descriptivo del modulo: module-info.java
Que se compila : -> module-info.class
Ese fichero contiene información del módulo.

Dentro de un módulo, tenemos paquetes... igual que siempre... No cambia nada.
Pero un modulo además, puede tener sus propios ficheros de datos/recursos:
    Configuración
    Imagen
    ...

Cada módulo incluye (define):
- Nombre:               Nombre del módulo
- Dependencias:         Otros módulos de los que éste depende
- Paquetes públicos:    Los paquetes publicos del módulo (17)
                        que se desea que seán visibles desde otros módulos (2)
                        > API muchos mñás limpia y segura!
                        por defecto: NADA ES VISIBLE PARA OTROS !
- Permisos de Reflection: por defecto TODO ESTA CAPADO !!!!
---
- Servicios: - Aprender que es un servicio (API nuevo en JAVA)
    - Servicios consume este modulo
    - Servicios provee este modulo
---
Los modulos pueden ser de 4 tipos:
- Modulos de Sistema: los que salen con --list-modules:
    - No todas las implementaciones de la JVM ofrecen los mismos módulos.
- Modulos de aplicación: Esto son los que creamos nosotros.
- Módulos automáticos: Modulos no oficiales que queremos usar: DEPENDENCIAS
                        Un jar (o 500) que añado en mi classpath.
                       Su nombre se obtiene del fichero .jar
- Modulo Sin nombre... Para compatibilidad hacia atrás.
    - Las clases que están sueltas, sin ir en ningún JAR van a este módulo.
----
Dependencias entre módulos: Gestión de dependencias como la de maven... 
                            pero a lo bestia.
    MAVEN: Quiero un jar.. en mi classpath.. descarga
            scope: Ambito de uso de la dependencia (Pruebas, compilar, incluya en mi artefacto)


module MIMODULO{
    requires OTRO_MODULO;            // Tanto en tiempo de compilación, como de ejecución
        PROVIDED
    requires static OTRO_MODULO;     // Tanto en tiempo de compilación
    requires transitive OTRO_MODULO; // Tanto en tiempo de compilación y que se incluya como parte de mi modulo
        VACIO DE MAVEN
    
    exports com.tiendalopez.site.apipublica;
    exports com.tiendalopez.site.api-privada to com.tiendalopez.reports;
}

---
Interfaces √√√√√√√√
Nuevo API HTTP
Gestión de procesos
JShell
Cambios menores sintaxis        ANECDOTICOS 