
# Compilar: 

# Ejecutar en la carpeta superior a la carpeta "modulos", donde se encuentran los modulos.
javac -d compilado \
    --module-source-path modulos \              # Directorio raiz donde están las carpetas de los modulos
    modulos/diccionario/module-info.java \
    modulos/app/module-info.java \
    modulos/app/com/curso/app/App.java

* NOTA, falta copiar los ficheros de diccionarios (.properties) dentro de compilado/dicccionario

# Ejecutar:

java --module-path compilado -m app/com.curso.app.App



// mongodb BBDD noSQL.  Documentos JSON, estructura jerárquica
            Oracle o MySQL
                0 Analisis completo del sistema
                1 Definir esquema de datos // modelo de la BBDD COMPLETA

metodologia en cascada - sistema monolitico
mongo -> AGIL, MICROSERVICIOS (RestFul)
        Programo microservicio
            Empiezo a programar... ni puta ide de lo que voy a necesitar 
            Cuando acabo, de montar mi trocito ( 3 colecciones ~ tabla )
                monto un esquema de validación en MONGO
                
Sistema no monolitico / TOTALMENTE PARCELADO, con modulos con un API MUY DEFINIDA

SCRUM

Site tienda

USUARIOS - modulo       JAVA    MySQL
    Interfaz : GestorDeUsuarios.   UsersControllers -> Mi implementación 2 o 3
    Interfaz:                      User No voy a dar implemetaciones
    login
    nuevo usuario
    borrar usuarios
    buscar usuario
    listar usuarios
    modificar usuario
    .... 4 cosas mas
    

CARRITO DE LA COMPRA        PYTHON
    
PRODUCTOS                    JS                   Mongo

GENERACION DE FACTURAS

PEDIDOS

API muy clara JAVA 1

Interfaces  de comunicación: Listado de metodos a los que puedes llamar, lo que te devuelven y lo que tienes que suministrar

Yo puedo hacer mi trabajo y tu el tuyo, de manera independiente.

Weblogic ---- 2 pastizales
    Coherence
    JMS
        RabittMQ Kafka
Webspheres --- 3 pastizales
JBoss --- 1 pastizal

NINGUNO

TOMCAT . ejb, ear


JEE

legacy es el legacy 

COBOL !!!


Frontend / backend
  JS        JAVA
  
  JSPs - DEP
  JSFc - DEP


WebComponents - W3C - HTML
WebSockets - HTTP

