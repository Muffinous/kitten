# ![re](https://user-images.githubusercontent.com/45390300/56307681-b93e0d00-6145-11e9-9af5-3b559c8ca493.gif)Software Requirements Specification

Tabla de contenidos
===================
- [1. Introducción](#Introducción)
	- [1.1 Objetivo](#Objetivo)
	- [1.2 Información](#Información)
	- [1.3 Scope of Project](#ScopeOfProject) 
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
- [5. Referencias.](#Referencias)

# 1. Introducción.<a name="Introducción"></a>
Este documento constará de las especificaciones de los requerimentos de software y los procedimientos necesarios a seguir para desarrollar el famoso videojuego retro Snake (de un solo jugador).

## 1.1 Objetivo.<a name="Objetivo"></a>
El objetivo de este documento es recopilar toda la información necesaria para comprender el programa.
El jugador será una serpiente cuyo objetivo es sobrevivir comiendo manzanas sin chocarse con las paredes o comerse su propia cola, ya que esto provocará que muera y por lo tanto, se reinicie el juego. 

## 1.2. Información <a name="Información"></a>

La serpiente estará compuesta por cabeza, cuerpo y cola; A medida que el jugador vaya devorando las manzanas el cuerpo irá creciendo y el jugador ganará 120 puntos. Para llevar esto a cabo, tendremos que saber cuando ha comido una fruta.

La manera de saber esto consiste en que en el momento que la cabeza esté en la misma posición (x,y) que la fruta, consideraremos que la serpiente consumió la fruta. En este instante, la fruta desaparecerá, la serpiente crecerá y aparecerá una nueva fruta en una posición aleatoria del mapa.

Por último, el jugador podrá controlar la dirección de la serpiente a su voluntad mediante por el método WASD, o si prefiere, con las flechas direccionales.

## 1.3. Scope of Project.<a name="ScopeOfProject"></a>

El trabajo principal consiste en experimentar los pasos para crear un proyecto desde cero en el entorno de java. Crear un SRS que explique todo la proyección de las ideas tanto del usuario como del diseñador. 

# 2. Descripción del diseño. <a name="Diseño"></a> 

## 2.1 Tecnología y entorno de desarrollo. <a name="EntornoDesarrollo"></a>
El desarrollo del proyecto se ha llevado a cabo en Netbeans IDE 8.2 utilizando el lenguaje de programación orientado a objetos Java, haciendo uso de clases y objetos.

## 2.2 Resumen de requisitos funcionales. <a name="RF"></a>
| Identificador	| Nombre del requisito			|  Priorización	|
|---------------|---------------------------------------|---------------|
|	RF1	|	Menú				|     Should	|
|	RF2	|	Control de la dirección		|     Must	|
|	RF3	|	Variedad de nivel de dificultad	|     Won't	|
|	RF4	|	Fruta				|     Must	|
|	RF5	|	Movimiento libre		|     Must	|
|	RF6	|	Game Over			|     Must	|
|	RF7	|	Incremento del tamaño		|     Should	|
|	RF8	|	Constante movimiento		|     Must	|


## 2.3 Requisitos no funcionales. <a name="RNF"></a>

	1. El personaje del videojuego será una serpiente encerrada en un laboratorio del área 51 dónde se estudiará su comportamiento instintivo de un depredador a la hora de buscar alimentos.
	2. Este sistema debería proporcionar la capacidad de operar en un compilador de java junto con la seguridad.
	3. La interfaz tendrá que ser intuitiva de cara al usuario medio, además de un código pulido para obtener respuestas rápidas.
	4. El fondo del menú será la imagen de una serpiente.
	
## 2.4 Especificacion de Requisitos Funcionales <a name="EspecificacionRF"></a>

	RF1. El videojuego tendrá un menú que incluirá distintas opciones, entre las cuales están: Comenzar una partida, seleccionar el nivel de dificultad, las instrucciones y por último, la posibilidad de salir del juego.
	RF2. El jugador podrá controlar la dirección de la serpiente con las teclas “A”,”S”,”D” y ”W”. De manera intuitiva la tecla A será para la izquierda, la S para abajo, la D para la derecha y por último, la W hacia arriba. (o con las teclas de dirección del teclado).
	RF3. El juego contará con tres niveles de dificultad: easy, medium y god.
	RF4. Se generará una fruta en una posición aleatoria del mapa.
	
**Acerca del movimiento de la serpiente tendremos varios requisitos funcionales:** 

	RF5. El jugador dispondrá de un espacio libre, pero limitado para mover la serpiente a su voluntad.
	RF6. No existen las vidas, por lo que en cuanto la serpiente se choque con un obstáculo o consigo misma, el juego termina e inmediatamente se regresará al menú principal. 
	RF7. Cada vez que la serpiente coma una fruta crecerá e incrementando la posibilidad de que se choque consigo misma.
	RF8.La serpiente estará en un campo electromagnético que provocará a sus receptores una tensión constante de amenaza y tendrá que estar desplazándose continuamente.
	
## 2.5 Casos de uso. <a name="CasosUso"></a>
	A continuación, se detallarán distintos casos de uso como: Elegir dificultad, Iniciar o salir del juego. 
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



## 2.6 Diagramas de casos de uso. <a name="DiagramasCasosUso"></a>

![caso de uso (1)](https://github.com/Muffinous/kitten/blob/master/Diagrams/Casos%20de%20uso.png)


Start Game/Choose Level    :<br/>
![START](https://github.com/Muffinous/kitten/blob/master/Diagrams/Start.png) 
![CHOOSE](https://github.com/Muffinous/kitten/blob/master/Diagrams/Dificultad.png)

INSTRUCTIONS/EXIT :<br/>
![INSTRUCTION](https://github.com/Muffinous/kitten/blob/master/Diagrams/Instrucciones.png)
![EXIT](https://github.com/Muffinous/kitten/blob/master/Diagrams/Exit.png)

# 3. Modelo vista-controlador. <a name="MVC"></a>

MVC:<br/>
![change (1)](https://github.com/Muffinous/kitten/blob/master/Diagrams/DiagramaDeClase.png)

# 4. Arquitectura del sistema. <a name="AS"></a>
Para explicar la arquitectura del sistema, a continuación, se detallarán los componentes del juego.
## 1. Componentes del juego. <a name= "CJ"></a>
El proyecto está dividido en tres paquetes: 
	
	Menu: Contiene tres clases, las cuales interactúan entre sí para mostrar el menu principal con las opciones explicadas anteriormente. 
		Class App: Es el Main, el cual crea un objeto de la vista Menu.	
		
		Class Menu: Extiende de JFrame y se encarga de dibujar los botones disponibles (start, instructions, difficulty and exit). 
		A su vez, implementa un Action Listener (clase ActionListen).
		
		Class ActionListen: Es una clase ActionListener, la cual se encarga de conectar el juego con el menu si el jugador selecciona la opción "start" y por lo tanto, 
		saber qué boton ha pulsado el jugador en el menú y realizar las acciones correspondientes.
		
	Images: Aquí se guardan las imagenes necesarias para el juego; por ejemplo: el fondo del menú, gifs..
	
	Snakegame: Contiene todo el código necesario para llevar a cabo el juego.
	
		Class apple: Contiene la información necesaria para la manzana y el método para crear una nueva en una posición random del tablero.
		
		Class board: Contiene la información del tablero y toda la parte GUI para el mismo.
		
		Si el jugador presiona start, el menú llamará al board. Además, contiene los métodos para ver si la serpiente colisiona, come la manzana y el score del jugador.
		
		Class snake: Contiene la información necesaria para la serpiente.
		
# 5. Referencias. <a name= "Referencias"></a>
	Para realizar este proyecto hemos usado el ejemplo de SRS que se colgó en el aula virtual.
	
