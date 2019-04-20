# ![re](https://user-images.githubusercontent.com/45390300/56307681-b93e0d00-6145-11e9-9af5-3b559c8ca493.gif)Software Requirements Specification

Tabla de contenidos
===================
-   [1. Introducción](#Introducción)
	- [1.1 Objetivo](#Objetivo)
	- [1.2 Información](#Información)
	- [1.3 Scope of Project](#ScopeOfProject)
 	- [1.4 Referencias](#Referencias)  
	- [1.5 Visión general del documento](#VisionGeneral)
- [2. Descripción del diseño.]	<br/>
	- [2.1 Tecnología y entorno de desarrollo] <br/>
	- [2.2 Resumen de requisitos funcionales]	<br/> 
	- [2.3 Requisitos no funcionales]	<br/>
	- [2.4 Especificación de Requisitos Funcionales] <br/>
	- [2.5 Casos de uso] <br/>	
	- [2.6 Diagramas de los casos de uso] <br/>	
**3. Modelo vista-controlador.**	<br/>
**4. Arquitectura del sistema.**	<br/>
	1. Componentes del juego.	<br/>
	2. Arquitectura del juego. 	<br/>
**5. Referencias.**	<br/>

# 1. Introducción.<a name="Introducción"></a>
===============
La documentación de este proyecto incluye cómo usar el proyecto y lo necesario para entender el desarrollo del mismo.

## 1.1 Objetivo.<a name="Objetivo"></a>

Este documento constará de la información y los procedimientos necesarios a seguir para desarrollar el famoso videojuego retro Snake (de un solo jugador).
El jugador será una serpiente cuyo objetivo es sobrevivir comiendo manzanas sin chocarse con las paredes o comerse su propia cola, ya que esto provocará que muera y por lo tanto, se reinicie el juego. 

## 1.2. Información <a name="Información"></a>

La serpiente estará compuesta por la cabeza y el cuerpo; en el momento que la serpiente se encuentre con una fruta y la “coma", esta crecerá y el jugador ganará 120 puntos. Para llevar esto a cabo tendremos que saber cuándo la serpiente ha comido una fruta.
La manera de saber esto consiste en que en el momento que la cabeza esté en la misma posición (x,y) que la fruta, consideraremos que la serpiente la ha comido. En este instante, la fruta desaparecerá, la serpiente crecerá y aparecerá una nueva fruta en una posición aleatoria del mapa.
Además, el movimiento de la serpiente se basa en lo que el usuario decide, es decir, la serpiente se moverá en una dirección dada y cada dirección nueva hará que la cabeza gire seguida del cuerpo.

## 1.3. Scope of Project.<a name="ScopeOfProject"></a>

El trabajo principal es escribir un juego de serpiente usando la programación de java. Este juego generará diversos problemas relacionados con las matemáticas. El jugador tiene que responder las preguntas controlando una serpiente con las teclas del teclado para comer la manzana de respuesta. Cada manzana de respuesta correcta que se come prolonga la vida de la serpiente.

## 1.4. Referencias. <a name="Referencias"></a>

## 1.5. Visión general del documento. <a name="VisionGeneral"></a>

# 2. Descripción del diseño.<br/>
| Nombre Del Requisito | Descripción | Prioridad |
|:--------------------:|-------------|:---------:|
|    Menú principal    |             |    Must   |

## 1. Tecnología y entorno de desarrollo. <br/>
El desarrollo del proyecto se ha llevado a cabo en Netbeans IDE 8.2 utilizando el lenguaje de programación orientado a objetos Java, haciendo uso de clases y objetos.

## 2. Requisitos funcionales. <br/>
| Identificador | Descripción |
|---------------|-------------------------------------------------------------------------------|
|	RF1	|	Menu
|	RF2	|
|	RF3	|
|	RF4	|
|	RF5	|

	1. El videojuego tendrá un menú que incluirá distintas opciones, entre las cuales están: el comenzar una partida, seleccionar el nivel de dificultad, las instrucciones y por último, la posibilidad de salir del juego.
	2. Al pulsar la tecla “Enter” en el menú el juego iniciará automáticamente.
	3. El jugador podrá controlar la dirección de la serpiente con las teclas “A”,”S”,”D” y ”W”. De manera intuitiva la tecla A será para la izquierda, la S para abajo, la D para la derecha y por último, la D hacia arriba. (o con las teclas de dirección del teclado)
	4. Existirá la posibilidad de parar el juego y ver el menú al pulsar la tecla “ESC”. La única diferencia al menú principal es que este tendrá la posibilidad de reanudar el juego. y no tendrá la posibilidad de cambiar la dificultad.
	5. El juego tendrá sonido, el cual podrá ser muteado gracias a un icono en la esquina superior derecha.
	6. El juego contará con varios niveles, los cuales se irán superando al llegar a la puntuación necesaria.
	7. Por cada nivel que supere el jugador, la velocidad de la serpiente incrementará. 
	8. Se generará una fruta en una posición aleatoria del mapa.
	9. Habrá varios tipos de fruta, no solo una generándose de manera aleatoria.
	10. Acerca del movimiento de la serpiente tendremos varios requisitos funcionales: 
		1. La serpiente debe poder moverse por toda la pantalla.
		2. No existen las vidas, por lo que en cuanto la serpiente se choque con un obstáculo o consigo misma, eljuego termina y se mostrará en la pantalla “Game Over”. 
		3. Cada vez que la serpiente coma una fruta crecerá haciéndose más larga e incrementando la posibilidad de que se choque consigo misma.
		4.La serpiente estará en constante movimiento.

## 3. Requisitos no funcionales. <br/>

	1. El protagonista del videojuego será una serpiente.
	2. Este sistema debería proporcionar la capacidad de operar en un compilador de java junto con la seguridad.
	3. La interfaz fácil de usar y la respuesta rápida.
	4. El fondo del menú será una imagen de una serpiente.
	
## 4. Especificacion de Requisitos Funcionales.

## 5. Casos de uso. <br/> 
	A continuación, se detallarán distintos casos de uso como: Iniciar el juego, salir del juego o elegir nivel. 
	
| Nombre del caso de uso  | **Iniciar el juego**                                                                                               |
|-----------------|------------------------------------------------------------------------------------------------------------------|
| Actor           | Usuario                                                                                                          |
| Pre-Condición   | El usuario irá al menú principal para elegir el juego para comenzar.                                             |
| Post-Condición: | Se iniciará el juego.                                                                                            |
| Descripcion:    | El usuario abre el menú principal y elige el nivel. Luego, haga clic en el botón de inicio y comenzará el juego. |

| Nombre del caso de uso  | Sonido escendido / apagado                                                   |
|-----------------|----------------------------------------------------------------------------- |
| Actor           | Usuario: 								         |
| Descripcion:    | El jugador puede encender o apagar el sonido durante el juego.               |
| Pre-Condición   | Hacer click en el boton de sonido para escender o apagar.                    |
| Post-Condición: | Despues de hacer click en el boton  el sonido estará escendido o apagado.    |


| Nombre del caso de uso  | Elegir nivel                                                                  |
|-----------------|-------------------------------------------------------------------------------|
| Actor           | Usuario: El usuario podrá elegir el nivel a su propia decisión.               |
| Descripcion:    | Cuando el usuario haga clic en Elegir nivel, el nivel se asignará al usuario. |
| Pre-Condición   | El usuario elegirá el nivel por menú.                                         |
| Post-Condición: | El nivel asignará al usuario qué nivel elige el usuario.                      |

| Nombre del caso de uso  | Salir del juego                                                                                                                                                                           |
|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor           | Jugador.							  | 
| Descripcion:    | Cuando el jugador haga clic en el botón de nsalida después de hacer clic en el botón de salir, aparecerá el mensaje preguntando si está seguro de querer salir, permitiendole seleccionar si o no; en el caso de que la opción seleccionada sea sí el juego terminará. |
| Pre-Condición   | El jugador haga clic en la opción de salida.             |                                                                                                                                      
| Post-Condición: | El juego se terminará.                                   |                                                                                                                                   

	
| Nombre del caso de uso | Iniciar el juego                                                                   |
|------------------------|------------------------------------------------------------------------------------|
| Actor                  | Usuario                                                                            |
| Descripción.           | El usuario seleccionará la opción de iniciar el juego para poder comenzar a jugar. |
| Pre-condicion          | El usuario irá al menú principal para elegir el juego para comenzar.               |
| Post-condicion         | El juego iniciará.                                                                 |

| Flujo de datos                             | Información                           |
|--------------------------------------------|---------------------------------------|
| El usuario irá al menú principal.          | El sistema muestra el menú principal. |
| El usuario seleccionará la opción "Start". | El sistema correrá el juego.          |

| Requisito Funcional | Actor                                                                 |
|-----------------|-------------------------------------------------------------------------------|
|	| Sistema |
|	| Sistema |


## 6.Diagramas Casos de uso :<br/>

![caso de uso (1)](https://user-images.githubusercontent.com/45390300/56460003-319e0b80-639c-11e9-8674-8230c95870a1.png)


Start Game/Choose Level    :<br/>
![START (2)](https://user-images.githubusercontent.com/45390300/56459772-e1717a00-6398-11e9-8fe5-4d2b070c8c82.png) 
![CHOOSE](https://user-images.githubusercontent.com/45390300/56459801-462cd480-6399-11e9-87de-263651f54aec.png)

INSTRUCTIONS/EXIT :<br/>
![INSTRUCTION](https://user-images.githubusercontent.com/45390300/56459887-83459680-639a-11e9-93a8-133d71cdb6b5.png)
![EXIT](https://user-images.githubusercontent.com/45390300/56459949-76757280-639b-11e9-9610-6b0491f1f9b2.png)


UML:<br/>
![change (1)](https://user-images.githubusercontent.com/45390300/56377803-86f6e300-620b-11e9-9e76-d98071f4bb14.jpg)

