# Parcial AREP               
Haciendo uso Java, Maven, Git, Heroku y Spark se desarrolló el siguiente ejercicio:

1. Construir un servicio WEB (puede usar Spark o Sockets) que reciba un número y una cadena de tres caracteres. La cadena puede ser una de tres opciones: "cos", "sin", "tan". El servicio asume que el número que recibe está en radianes y retorna una estructura JSON con el valor de la función trigonométrica correspondiente. 
2. Construya otro servicio Web (puede usar Spark o Sockets) que sea una fachada del servicios construido en el primer punto. Es decir, este servicio recibe los mismos parámetros y regresa el mismo resultado, pero para hacer el cálculo debe invocar via http al servicio web que se constuyó en el primer punto.
3. Su diseño debe soportar la composición de nuevas operaciones para modificar servicios existentes o componer nuevos servicios. Por ejemplo, piense que en el futuro podemos solicitar que se creen nuevos servicios sobre  el API web, es decir,  debe ser fácilmente extensible.
4. El diseño de los servicios WEB debe tener en cuenta buenas prácticas de diseño OO.
5. Despliegue los servicios en Heroku en dynos separados.
6. Construya un cliente JAVA para probar los dos servicios.
7. El cliente y los servicios debe entregarlos en dos proyectos estructurado con Maven. El primero con el servicio fachada y el cliente. Y el segundo con el servicio web concreto.
8. El cliente debe traer "quemada" en el código fuente la url de su aplicación desplegada en Heroku.

## Comenzando
Para obtener una copia del proyecto en nuestra máquina local y así poder realizar tareas de desarrollo, pruebas o ejecuciones, debemos clonarlo utilizando el siguiente comando:
```
git clone https://github.com/germanAOQ/Parcial-AREP-1-segundaParte.git
```
### Pre-requisitos
Para hacer uso del software es necesario tener instalado:
* Maven: Automatiza y estandariza el flujo de vida de la construcción de software.                 
    Siga las instrucciones en http://maven.apache.org/download.cgi#Installation
* Git: Administrador descentralizado de configuraciones.                     
    Siga las instrucciones en http://git-scm.com/book/en/v2/Getting-Started-Installing-Git
* Toolbelt de Heroku: Paquete de la CLI de Heroku
    Siga las instrucciones en https://devcenter.heroku.com/articles/heroku-cli
### Instalación
Una vez clonado el proyecto, en la carpeta donde hayamos hecho el procedimiento, abrimos la shell del sistema operativo en la que estemos y accedemos al directorio de este:
```
cd Parcial-AREP-1-segundaParte
```
Ejecutamos la fase **package**, la cual ejecutara las fases previas del ciclo de vida: **validate, compile y test** y empaquetará el código ya compilado en un formato que se le haya especificado en el archivo de configuración, POM.xml
```
mvn package
```
Para ejecutar el proyecto se debe utilizar el siguiente comando, cabe resaltar que este comando se ejecuta en un sistema operativo Windows y haciendo uso de PowerShell
```
web: java $JAVA_OPTS -cp target/classes:target/dependency/* edu.escuelaing.arep.fachada.Fachada
```
Una vez hecha la ejecución, se podrá acceder a la aplicación localmente através de la siguiente dirección:
```
http://localhost:4567/
```
### Primera parte
La primera parte de la aplicación se encuetra en el siguiente repositorio:        
                     
[](https://github.com/germanAOQ/Parcial-AREP-1-primeraParte.git)                  

En esta primera parte se construye un servicio web utilizando SparkJava. Este servicio realiza las operaciones trigonométricas a ser consumidas por el segundo servicio.

### Uso
Para hacer uso de el servicio web se deben utilizar dos parámetros: **val** y **trifunction**, además se debe usar la ruta: **/fachada**                    
Por ejemplo:
```
http://young-dawn-26500.herokuapp.com/fachada?val=2.5&trifunction=cos
```
Para hacer uso de la primera parte de la apliación es similar, se debe cambiar el host y la ruta por **trigcalculator**:
```
http://radiant-brook-00421.herokuapp.com/trigcalculator?val=2.5&trifunction=cos
```

## Pruebas
Se presentan tres pruebas, una por cada función trigonométrica:

En la primera prueba se evalua cos:
![test1](/image/test1.PNG)

En la segunda prueba se evalua sin:
![test2](/image/test2.PNG)

En la primera prueba se evalua tan:
![test3](/image/test3.PNG)

## Arquitectura de la aplicación
![Arquitectura](/image/DeploymentDiagram.png)
## Documentación

### Generar documentación
Para generar la documentación se debe agregar al código del archivo de configuración de Maven, POM.xml, el siguiente plugin:
```
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-javadoc-plugin</artifactId>
	<executions>
		<execution>
			<id>attach-javadocs</id>
			<goals>
				<goal>jar</goal>
			</goals>
		</execution>
	</executions>
</plugin>

```
Uno vez agregado el plugin anterior, se ejecuta el siguiente comando para generar el javadoc
```
mvn install
```
Finalmente, en la carpeta target quedará creado un archivo con el nombre **apidocs**, lugar en donde se encontrará la documentación.

## Construido con 
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Git](https://github.com/) - Control de versionamiento
* [Heroku](https://heroku.com) - Plataforma de despliegue [![Deploy](https://www.herokucdn.com/deploy/button.png)](http://young-dawn-26500.herokuapp.com/fachada?val=2.5&trifunction=cos)

## Autores 
* [Germán Andrés Ospina Quintero](https://github.com/germanAOQ)

## Licencia 📄
Este proyecto esta licenciado por GNU General Public License v3.0
