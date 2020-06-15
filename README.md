# Networking
En este proyecto se resuelven los siguientes ejercicios:
* Escriba  un  programa  en  el  cual  usted  cree  un  objeto  URL  e  imprima  en pantalla cada uno de los datos que retornan los 8 m ́etodos de la seccion anterior.
* Escriba una aplicacion browser que pregunte una direccion URL al usuario y que lea datos de esa direccion y que los almacene en un archivo con el nombre resultado.html. Luego intente ver este archivo en el navegador.
* Escriba un servidor que reciba un numero y responda el cuadrado de este numero.
* Escriba un servidor que pueda recibir un n ́umero y responda con un operacion sobre este numero. Este servidor puede recibir un mensaje que empiece por “fun:”, si recibe este mensaje cambia la operación a las especificada. El servidor debe responder las funciones seno, coseno y tangente. Por defecto debe empezar calculando  el  coseno.  Por  ejemplo,  si  el  primer  número  que  recibe  es  0,  debe responder 1, si después recibe π/2 debe responder 0, si luego recibe “fun:sin” debe  cambiar  la  operación  actual  a  seno,  es  decir a partir de ese momento debe calcular senos. Si enseguida recibe 0 debe responder 0.
* Escriba un servidor web que soporte múltiples solicitudes seguidas (no concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo páginas html e imágenes.

## Getting Started

Para hacer uso del proyecto solo debe clonar el repositorio o descargarlo directamente, para ejectarlo lo hacemos por medio de la consola usando el siguiente comandos, debe reemplazar <programa> por el nombre del programa que quiere ejecutar.

```bash
java -cp target/TallerNetworking-1.0-SNAPSHOT.jar co.edu.escuelaing.tallernetworking.<programa>
```

### Prerequisites

Para usar el proyecto se necesitan tener las siguientes versiones de java o superior:


```
java version "1.8"
javac version "1.8"
Apache Maven 3.6.3
```

### Installing

Para usar el proyecto decargamos directamente el proyecto o lo clonamos de la siguiente manera:

En la consola nos vamos al directorio donde vamos a clonar el repositorio y ponemos el siguiente comando:

```bash
git clone https://github.com/anfegoca/ARSW-lab3.git

```
![clone](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/1.png)

En el direcctorio nos quedará la carpeta del proyecto y dentro veremos las siguiente carpetas

![direc](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/2.png)

Para modificar abrimos el proyecto con cualquier editor, en este caso usamos NetBeans

![edit](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/3.png)

Y ya podemos modificar cualquier clase del proyecto

![class](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/4.png)

## Running the tests

Para ejecutar el primer programa usamos el siguiente comando

```bash
java -cp target/TallerNetworking-1.0-SNAPSHOT.jar co.edu.escuelaing.tallernetworking.URLReader

```

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/5.png)

Para ejecutar el segundo programa usamos el siguiente comando
```bash
java -cp target/TallerNetworking-1.0-SNAPSHOT.jar co.edu.escuelaing.tallernetworking.URLReader2

```
Despues tendremos que escribir la URL de la pagina que queremos consultar

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/6.png)

Nos creará el archivo resultado.html y al abrirlo veremos lo siguiente:

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/7.png)

Para ejecutar el tercer programa usamos el siguiente comando debemos ejecutar el siguiente programa

```bash
java -cp target/TallerNetworking-1.0-SNAPSHOT.jar co.edu.escuelaing.tallernetworking.EchoServer

```
![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/8.png)

El server se quedará esperando hasta que un cliente se conecte a él, para ello ejecutamos el cliente con el siguiente comando en otra ventana de la consola de comandos

```bash
java -cp target/TallerNetworking-1.0-SNAPSHOT.jar co.edu.escuelaing.tallernetworking.EchoClient

```
![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/9.png)

Cuando el cliente se conecte se verá el siguiente mensaje en el server

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/10.png)

Ahora desde el cliente podemos calcular el cuadrado de cualquier numero, al ingresar un texto nos saldrá el siguiente mensaje

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/11.png)

Cuando ingresemos un numero, en el server veremos lo que se ingresó en el cliente

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/12.png)

En el cliente veremos el resultado

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/13.png)

Para ejecutar el cuarto programa tambien tendremos que ejecutar primero el server, para ello ejecutamos el siguiente comando
```bash
java -cp target/TallerNetworking-1.0-SNAPSHOT.jar co.edu.escuelaing.tallernetworking.EchoServerFunc

```
![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/14.png)

Ahora ejecutamos, al ejecutar en el server se podrá ver si se pudo conectar

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/15.png)

Ahora desde el cliente se podrá calcular cualquier función trigonometrica, para ello podemos meter un número, por defecto se calculará el coseno

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/16.png)

Si queremos cambiar a otra función usamos fun:sin, fun:tan, fun:cos, dependiendo de lo que queramos calcular, en el ejemplo cambiamos a seno y calculamos el seno de 0

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/17.png)

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/18.png)


Para ejecutar el último programa usamos el siguiente codigo, con esto ejecutamos el server, el cual se queda esperando las peticiones de un cliente.

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/19.png)

Esta vez el cliente va a ser el navegador, desde este vamos a localhost:35000 y le pedimos al servidor el recurso que queramos, si vamos directamente no encontrará nada

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/20.png)

Hacemos una prueba con un archivo html, para ello solicitamos el recurso prueba.html

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/21.png)

Por último hacemos una prueba con una imagen, le pedimos el recurso foto.jpg

![test](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/22.png)


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Versioning

El versionamiento se realizó a través de [github](https://github.com/anfegoca/ARSW-lab1.git)

## Authors

* **Andrés González** - [anfegoca](https://github.com/anfegoca)


## License

This project is licensed under the MIT License - see the [LICENSE.txt](LICENSE.txt) file for details

## Design

Para mas información del diseño del ultimo programa puede ver el siguiente [documento](https://github.com/anfegoca/ARSW-lab3/blob/master/resources/Networking.pdf)

## JavaDoc

La documentación del proyecto la puede encontrar [aquí](https://github.com/anfegoca/ARSW-lab3/tree/master/site/apidocs)

