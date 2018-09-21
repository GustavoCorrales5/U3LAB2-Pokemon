package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class NivelCuatro extends Nivel {

	/**
	 * Atributos de la clase NivelCuatro 
	 * PImage fondo fondo de pantalla del nivel cuatro 
	 * PImage []botones que carga todas las botones del nivel cuatro
	 * int x posicion en x del fondo 
	 * int y posicion en y del fondo 
	 * int movX movimiento del lienzo en el fondo en x 
	 * int movY movimiento del lienzo en el fondo en y
	 * int puntaje1 puntaje de primer tipo recolectado tras matar un enemigo
	 * int puntaje2 puntaje de segundo tipo recolectado tras matar un enemigo
	 * PImage rey personaje rey 
	 * PImage finn personaje finn 
	 * PImage punto logo de la moneda donde se alojaran los puntajes de los usuarios
	 */
	private PImage fondo;
	private PImage[] botones;
	private int x, y;
	private static int movX;
	private static int movY;
	private int puntaje1, puntaje2;
	private PImage rey;
	private PImage finn;

	private PImage punto;

	/**
	 * Constructor de la clase NivelCuatro que inicializa los atributos de la clase
	 * @param app de tipo PApplet es la relacion con la libreria PApplet 
	 */
	public NivelCuatro(PApplet app) {
		super(app);
		botones = new PImage[2];
		this.x = x;
		this.y = -10743;
		crearImagen();
		puntaje1 = 0;
		puntaje2 = 0;

	}

	/**
	 * Metodo sumarPuntaje1 que suma 1 punto a la variable puntaje 1 cada vez que es llamado
	 */
	public void sumarPuntaje1() {
		puntaje1 += 1;
	}
	/**
	 * Metodo sumarPuntaje2 que suma 1 punto a la variable puntaje 1 cada vez que es llamado
	 */
	public void sumarPuntaje2() {
		puntaje2 += 1;
	}

	/**
	 * Metodo getPosY que devuelve la posicion en y del nivel cuatro 
	 * @return y int y posicion en y del nivel
	 */
	public int getPosY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void crearImagen() {
		rey = app.loadImage("ReyPunto.png");
		finn = app.loadImage("FinnPunto.png");
		fondo = app.loadImage("nivel1.jpg");
		punto = app.loadImage("logoMoneda1.png");
		botones[0] = app.loadImage("2Punto.png");
		botones[1] = app.loadImage("1Punto.png");
	}

	/**
	 * Metodo movimientoLienzo que mueve el fondo del lienzo para dar la sensacion de movimiento
	 */
	public void movimientoLienzo() {
		if (y <= 10743) {
			y += 4;
		}
	}

	@Override
	public void pintarimagen() {
		app.image(fondo, x, y);
		app.image(punto, 79, 123);
		app.image(rey, 366, 100);
		app.image(finn, 1491, 100);
		movimientoLienzo();
		System.out.println(app.mouseX);
	}

	/**
	 * Metodo pintarPuntaje que pinta el puntaje que ha obtenido el usuario 
	 */
	public void pintarPuntaje() {
		app.fill(255, 255, 255);
		app.textSize(30);
		app.text(puntaje1, 170, 170);
		app.noFill();
	}

	@Override
	public boolean validarEtapa1() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validarEtapa2() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pintar() {
		pintarimagen();
		pintarPuntaje();
	}

}
