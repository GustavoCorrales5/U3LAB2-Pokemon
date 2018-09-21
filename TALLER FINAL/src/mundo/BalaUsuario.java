package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class BalaUsuario {

	private int posX;
	private int posY;
	private PImage balaU;
	private int velocidad;
	private PApplet app;

	public BalaUsuario(PApplet app, int posX, int posY, int vel) {
		this.posX = posX;
		this.posY = posY;
		this.velocidad = vel;
		this.app = app;
		balaU = app.loadImage("Bala userPunto.png");
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void pintar() {
		app.imageMode(app.CENTER);
		app.image(balaU, posX, posY);
		app.imageMode(app.CORNER);
		posY -= velocidad;
	}

}
