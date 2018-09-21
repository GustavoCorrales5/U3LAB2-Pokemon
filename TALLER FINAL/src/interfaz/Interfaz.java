package interfaz;

import com.leapmotion.leap.Controller;

import de.voidplus.leapmotion.*;
import mundo.Logica;
import processing.core.PApplet;
import processing.core.PVector;

public class Interfaz extends PApplet {

	/**
	 * Atributos de la clase interfaz seran inicializados en el metodo setup
	 * heredado de la clase PApplet Logica logica relacion con el paquete mundo al
	 * paquete interfaz LeapMotion leap relacion con el sensor leapmotion para
	 * detectar movimiento y disparos PVector fb vector que captura la posicion del
	 * vector que representa a la mano del usuario en el espacio con leapmotion
	 */
	private Logica logica;
	private LeapMotion leap;
	private LeapMotion leap2;
	private PVector fp;

	/**
	 * Constructor de la clase Interfaz
	 */
	public Interfaz() {

	}

	/**
	 * Metodo settings de la clase interfaz que inicializa el tamano del size en el
	 * que se representaran los objetos
	 */
	public void settings() {
		size(1920, 1080);
	}

	/**
	 * Metodo setup de la clase interfaz donde se inicalizan los atributos de la
	 * misma
	 */
	public void setup() {
		logica = new Logica(this);
		leap = new LeapMotion(this).allowGestures();
		leap2 = new LeapMotion(this);

	}

	/**
	 * Metodo mouseClicked de la clase interfaz heredado de la libreria PApplet que
	 * funciona cuando el usuario da clic sobre las secciones especificadas
	 * 
	 */
	public void mouseClicked() {
		logica.eventosMouse();
		System.out.println(mouseX + " " + mouseY);

	}

	/**
	 * Metodo leapOnCircleGesture usado para detectar el gesto de circulo con
	 * leapmotion y dar luz verde al halcon milenario 2 para disparar leapmotion
	 * 
	 * @param g
	 *            de tipo CircleGesture objeto que detecta el gesto circle
	 * @param state
	 *            tipo int que detecta el estado en donde esta el gesto
	 */
	public void leapOnCircleGesture(CircleGesture g, int state) {
		int id = g.getId();
		Finger finger = g.getFinger();
		PVector positionCenter = g.getCenter();
		float radius = g.getRadius();
		float progress = g.getProgress();
		long duration = g.getDuration();
		float durationSeconds = g.getDurationInSeconds();
		int direction = g.getDirection();

		switch (state) {
		case 1: // Start
			break;
		case 2: // Update
			break;
		case 3: // Stop
			System.out.println("entre");
			logica.setDisparoJugado2(true);

			// logica.setPosX(position.x);
			break;
		}

		switch (direction) {
		case 0: // Anticlockwise/Left gesture
			break;
		case 1: // Clockwise/Right gesture
			break;
		}
	}

	/**
	 * Metodo leapOnSwipeGesture usado para detectar el gesto de swipe con leap
	 * motion dar luz verde al halcon milenario 2 para disparar
	 * 
	 * @param g
	 *            de tipo SwipeGesture objeto que detecta el gesto swipe
	 * @param state
	 *            tipo int que detecta el estado en donde esta el gesto
	 */
	public void leapOnSwipeGesture(SwipeGesture g, int state) {
		int id = g.getId();
		Finger finger = g.getFinger();
		PVector position = g.getPosition();
		PVector positionStart = g.getStartPosition();
		PVector direction = g.getDirection();
		float speed = g.getSpeed();
		long duration = g.getDuration();
		float durationSeconds = g.getDurationInSeconds();

		switch (state) {
		case 1: // Start
			break;
		case 2: // Update
			break;
		case 3: // Stop
			println("SwipeGesture: " + id);
			System.out.println("Swipeeee");
			logica.setDisparoJugado2(true);
			// logica.setPosX(position.x);
			break;
		}
		logica.setDisparoJugado2(true);

	}

	/**
	 * Metodo de movimiento de la clase interfaz quew permite trackear el movimiento
	 * de la mano en el eje x para asi mover el halcon milenario de finn
	 */
	public void movimiento() {
		int fps = leap2.getFrameRate();
		for (Hand hand : leap.getHands()) {
			for (Finger finger : hand.getFingers()) {
				fp = finger.getPosition();
				logica.setPosX(fp.x);
			}
		}
	}

	/**
	 * Metodo leapOnScreenTapGesture usado para detectar el gesto de tap con leap
	 * motion dar luz verde al halcon milenario 2 para disparar
	 * 
	 * @param g
	 *            de tipo ScreenTapGesture objeto que detecta el gesto tap
	 */
	public void leapOnScreenTapGesture(ScreenTapGesture g) {
		int id = g.getId();
		Finger finger = g.getFinger();
		PVector position = g.getPosition();
		PVector direction = g.getDirection();
		long duration = g.getDuration();
		float durationSeconds = g.getDurationInSeconds();

		println("ScreenTapGesture: " + id);
		logica.setDisparoJugado2(true);

	}

	/**
	 * Metodo keyPressed de la clase interfaz heredado de la libreria PApplet que
	 * funciona cuando el usuario oprime alguna tecla
	 */
	public void keyPressed() {
		
		
		logica.eventosDelTeclado();
		
		if(key=='p') {
			logica.setDisparoJugado2(true);
		}
	}
	
	public void keyRelassed() {
		
	}

	/*
	 * Metodo draw de la clase interfaz heredado de la libreria PApplet que pinta
	 * todos los elementos del lienzo (non-Javadoc)
	 * 
	 * @see processing.core.PApplet#draw()
	 */
	public void draw() {
		logica.pintar();
		movimiento();

	}

	/*
	 * Metodo main del programa que inicializa el programa
	 * @param args argumentos
	 */
	public static void main(String[] args) {
		PApplet.main("interfaz.Interfaz");
	}
}
