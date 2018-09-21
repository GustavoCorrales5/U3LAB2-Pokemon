package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class PersonajeEnemigo extends Personaje {

	/**
	 * Atributos de la clase PersonajeEnemigo int vida vida total del enemigo
	 * PImage[] forma foto del personaje enemigo int velX velocidad en x int velY
	 * velocidad en y boolean derecha validacion de cambiar de direccion PApplet app
	 * relacion con processing int max indice de variable de foto
	 */
	protected int vida;
	protected PImage[] forma;
	protected int velX;
	protected int velY;
	protected boolean derecha = true;
	protected PApplet app;
	protected int max;

	/**
	 * Metodo constructor de la clase PersonajeEnemigo que inicializa las variables
	 * de la misma
	 * 
	 * @param app
	 *            PApplet app relacion con processing
	 * @param x
	 *            int posicion x del personaje
	 * @param y
	 *            int posicion y del personaje
	 * @param vida
	 *            int vida personaje
	 * @param velX
	 *            int velX velocidad en x del personaje
	 * @param velY
	 *            int velY velocidad en y del personaje
	 */
	public PersonajeEnemigo(PApplet app, int x, int y, int vida, int velX, int velY) {
		super(app, x, y);
		this.app = app;
		posX = x;
		posY = y;
		this.vida = vida;
		this.velX = velX;
		this.velY = velY;

	}

	/**
	 * Metodo quitarVida que quita vida del personaje enemigo
	 */
	public void quitarVida() {
		--vida;
	}

	/**
	 * Metodo getVida que toma la vida del usuario
	 * 
	 * @return int vida vida del personajeEnemigo
	 */

	public int getVida() {
		return vida;
	}

	/**
	 * Metodo getPosX que devuelve la posicion en x del usuario
	 * 
	 * @return int posX posicion en x del personajeEnemigo
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Metodo getPosY que devuelve la posicion en y del usuario
	 * 
	 * @return int posY posicion en y del personajeEnemigo
	 */
	public int getPosY() {
		return posY;
	}

	@Override
	public void animar() {
		if (posY <= 400) {
			if (derecha == true && posX < app.width - 10) {
				posX += velX;
			} else if (posX >= app.width - 10) {
				derecha = false;
				posY += velY;
			}
			if (derecha == false && posX > 18) {
				posX -= velX;
			} else if (posX <= 18) {
				derecha = true;
				posY += velY;
			}
		} else {
			posX -= velX;
		}

	}

	@Override
	public void run() {
		animar();
		try {
			sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void pintar() {
		app.imageMode(PApplet.CENTER);
		if (app.frameCount % 8 == 0) {
			max++;
		}
		if (max > 1)
			max = 0;
		app.image(forma[max], posX, posY);
		app.imageMode(PApplet.CORNER);
	}

}
