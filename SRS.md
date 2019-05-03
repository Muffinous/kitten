# ![re](https://user-images.githubusercontent.com/45390300/56307681-b93e0d00-6145-11e9-9af5-3b559c8ca493.gif)Software Requirements Specification

Tabla de contenidos
===================
- [1. Introducción](#Introducción)
	- [1.1 Objetivo](#Objetivo)
	- [1.2 Información](#Información)
	- [1.3 Scope of Project](#ScopeOfProject)
 	- [1.4 Referencias](#Referencias)  
	- [1.5 Visión general del documento](#VisionGeneral)
- [2. Descripción del diseño.](#Diseño)
	- [2.1 Tecnología y entorno de desarrollo](#EntornoDesarrollo)
	- [2.2 Resumen de requisitos funcionales](#RF)
	- [2.3 Requisitos no funcionales](#RNF)
	- [2.4 Especificación de Requisitos Funcionales](#EspecificacionRF)
	- [2.5 Casos de uso](#CasosUso)	
	- [2.6 Diagramas de los casos de uso](#DiagramasCasosUso)
- [3. Modelo vista-controlador.](#MVC)
- [4. Arquitectura del sistema.](#AS)
	- [1. Componentes del juego.](#CJ)
	- [2. Arquitectura del juego.](#AJ)
- [5. Referencias.](#Referencias)

# 1. Introducción.<a name="Introducción"></a>

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

# 2. Descripción del diseño. <a name="Diseño"></a> 

## 1. Tecnología y entorno de desarrollo. <a name="EntornoDesarrollo"></a>
El desarrollo del proyecto se ha llevado a cabo en Netbeans IDE 8.2 utilizando el lenguaje de programación orientado a objetos Java, haciendo uso de clases y objetos.

## 2. Resumen de requisitos funcionales. <a name="RF"></a>
| Identificador	| Nombre del requisito			|  Priorización	|
|---------------|---------------------------------------|---------------|
|	RF1	|	Menú				|     Should	|
|	RF2	|	Inicio automático		|     Could	|
|	RF3	|	Control de la dirección		|     Must	|
|	RF4	|	Posibilidad de parar el juego	|     Could	|
|	RF5	|	Variedad de niveles		|     Won't	|
|	RF6	|	Incremento de la velocidad	|     Should	|
|	RF7	|	Fruta				|     Must	|
|	RF8	|	Movimiento libre		|     Must	|
|	RF9	|	Game Over			|     Must	|
|	RF10	|	Incremento del tamaño		|     Should	|
|	RF11	|	Constante movimiento		|     Must	|


## 3. Requisitos no funcionales. <a name="RNF"></a>

	1. El personaje del videojuego será una serpiente encerrada en un laboratorio del área 51 dónde se estudiará su comportamiento instintivo de un depredador a la hora de buscar alimentos.
	2. Este sistema debería proporcionar la capacidad de operar en un compilador de java junto con la seguridad.
	3. La interfaz tendrá que ser intuitiva de cara al usuario medio, además de un código purificado para obtener respuestas rápidas.
	4. El fondo del menú será la imagen de una serpiente.
	
## 4. Especificacion de Requisitos Funcionales <a name="EspecificacionRF"></a>
	
	RF1. El videojuego tendrá un menú que incluirá distintas opciones, entre las cuales están: Comenzar una partida, seleccionar el nivel de dificultad, las instrucciones y por último, la posibilidad de salir del juego.
	RF2. El jugador podrá controlar la dirección de la serpiente con las teclas “A”,”S”,”D” y ”W”. De manera intuitiva la tecla A será para la izquierda, la S para abajo, la D para la derecha y por último, la D hacia arriba. (o con las teclas de dirección del teclado)
	RF3. Existirá la posibilidad de parar el juego y ver el menú al pulsar la tecla “ESC”. La única diferencia al menú principal es que este tendrá la posibilidad de reanudar el juego. y no tendrá la posibilidad de cambiar la dificultad.
	RF4. El juego contará con varios niveles, los cuales se irán superando al llegar a la puntuación necesaria.
	RF5. Por cada nivel que supere el jugador, la velocidad de la serpiente incrementará. 
	RF6. Se generará una fruta en una posición aleatoria del mapa.
	
**Acerca del movimiento de la serpiente tendremos varios requisitos funcionales:** 

	RF7. El jugador dispondrá de un espacio libre y limitado para mover la serpiente a su voluntad.
	RF8. No existen las vidas, por lo que en cuanto la serpiente se choque con un obstáculo o consigo misma, el juego termina y se mostrará en la pantalla “Game Over”. 
	RF9. Cada vez que la serpiente coma una fruta crecerá haciéndose más larga e incrementando la posibilidad de que se choque consigo misma.
	RF10.La serpiente estará en un campo electromagnético que provocará a sus receptores una tensión constante de amenaza y tendrá que desplazándose continuamente.
	
## 5. Casos de uso. <a name="CasosUso"></a>
	A continuación, se detallarán distintos casos de uso como: Iniciar el juego, salir del juego o elegir nivel. 
| Nombre del caso de uso | Iniciar el juego  |
|---------------------------|---------------------------------------------------------------------------------------|
| Actor | Usuario  |
| Descripción.  | El usuario seleccionará la opción de iniciar el juego para poder comenzar a jugar.  |
| Pre-condición | El usuario irá al menú principal para elegir el juego para comenzar.  |
| Post-condición | El juego iniciará.  |
| **Flujo de datos.** | **Información.**  |
| El usuario arrancará el juego. | El sistema arrancará el juego y mostrará el menú principal.  |
| El usuario seleccionará la opción "Start". | El sistema correrá el juego.  |
				   

| Nombre del caso de uso | Elegir Dificultad  |
|--------------------------|---------------------------------------------------------------------------------------|
| Actor | Usuario  |
| Descripcion: | Cuando el usuario haga clic en Elegir nivel, el nivel se asignará al usuario.  |
| Pre-Condición | El usuario elegirá el nivel por menú.  |
| Post-Condición: | El nivel asignará al usuario qué nivel elige el usuario.  |
| **Flujo de datos.** | **Información.**  |
| El jugador pinchará en el botón de *Elegir Nivel* | El sistema mostrará un submenú dónde podrá elegir el nivel de dificultad  |
| El usuario elige el nivel de dificultad | Por último, el sistema actualiza la dificultad del juego y vuelve al menú principal  |

| Nombre del caso de uso | Salir del Juego  |
|--------------------------|---------------------------------------------------------------------------------------|
| Actor | Jugador  |
| Descripción | Cuando el jugador haga clic en el botón de salida después de hacer clic en el botón de salir, aparecerá un diálogo preguntando si está seguro junto a dos botones para responder si o no; en el caso de que la opción seleccionada sea sí el juego terminará.  |
| Pre-Condición | El jugador selecciona la opción de salida.  |
| Post-Condición | El juego se terminará.  |
| **Flujo de datos.** | **Información.**  |
| El jugador pulsa el botón de *Exit*. | El sistema mostrará un diálogo de usuario esperando la respuesta del jugador.  |
| El usuario elige la opción de salir. | El sistema cierra el juego.  |



## 6.Diagramas de casos de uso. <a name="DiagramasCasosUso"></a>

![caso de uso (1)](https://github.com/Muffinous/kitten/blob/master/Casos%20de%20uso.png)


Start Game/Choose Level    :<br/>
![START (2)](https://user-images.githubusercontent.com/45390300/56459772-e1717a00-6398-11e9-8fe5-4d2b070c8c82.png) 
![CHOOSE](https://user-images.githubusercontent.com/45390300/56459801-462cd480-6399-11e9-87de-263651f54aec.png)

INSTRUCTIONS/EXIT :<br/>
![INSTRUCTION](https://user-images.githubusercontent.com/45390300/56459887-83459680-639a-11e9-93a8-133d71cdb6b5.png)
![EXIT](https://user-images.githubusercontent.com/45390300/56459949-76757280-639b-11e9-9610-6b0491f1f9b2.png)


UML:<br/>
![change (1)](https://github.com/Muffinous/kitten/blob/master/diagrama.png)

# 3. Modelo vista-controlador. <a name="MVC"></a>
# 4. Arquitectura del sistema. <a name="AS"></a>
## 1. Componentes del juego. <a name= "CJ"></a>
## 2. Arquitectura del juego. <a name= "AJ"></a>
# 5. Referencias. <a name= "Referencias"></a>
