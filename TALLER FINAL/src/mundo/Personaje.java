package mundo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Personaje extends Thread {

	/**
	 * Atributos de la clase Personaje 
	 * int posX posicion x del personaje
	 * int posY posicion y del personaje 
	 * PApplet app relacion con la libreria de processing PApplet
	 */
	protected int posX;
	protected int posY;
	protected PApplet app;

    /**
     * Metodo constructor de la clase Personaje que inicializa sus atributos
     * @param app PApplet app relacion con la libreria de processing PApplet
     * @param x   int x posicion en x del personaje
     * @param y  int y posicion y del personaje 
     */
	public Personaje(PApplet app, int x, int y) {
		this.app = app;		
		
	}

	/**
	 * Metodo getPosX que devuelve la posicion en x del personaje
	 * @return posX int posX posicion x del personaje
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Metodo getPosY que devuelve la posicion en y del personaje
	 * @return posY int posY posicion y del personaje
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Metodo abstracto que inicializa las imagenes del personaje para asi convertirlas en una animacion utilizando framecount
	 */
	public abstract void animar();

	/**
	 * Metodo abstracto run que iniciliza el hilo para el movimiento de mis personajes
	 */
	public abstract void run();
    /**
     * Metodo pintar que pinta al personaje y su gif
     */
	public abstract void pintar();


	


	
	
	
}
