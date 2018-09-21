package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class NaveEnemiga2 extends PersonajeEnemigo{
	/**
	 * Metodo constructor de la clase NaveEnemiga2 que inicializa los atributos pasados por argumento desde la clase Logica
	 * @param app relacion con la libreria de processing PApplet
	 * @param x   int  x posicion x del personaje enemigo
	 * @param y   int y  posicion y del personaje enemigo
	 * @param vida int vida vida del personaje enemigo
	 * @param velX int velX velocidad en x del personajeEnemigo
	 * @param velY int velY velocidad en y del personajeEnemigo
	 */
	public NaveEnemiga2(PApplet app, int x, int y, int vida, int velX, int velY) {
		super(app, x, y, vida, velX, velY);
		// TODO Auto-generated constructor stub
	}

}
