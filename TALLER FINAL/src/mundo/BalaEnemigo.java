package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class BalaEnemigo extends Thread {

	private int posX;
	private int posY;
	private PImage balaE;
	private int velocidad;

	private PApplet app;

	public BalaEnemigo(PApplet app, int posX, int posY, int vel) {
		this.posX = posX;
		this.posY = posY;
		this.velocidad = vel;
		this.balaE = app.loadImage("Bala enemigoPunto.png");
		this.app = app;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void pintar() {
		app.image(balaE, posX, posY);
	}

	public void run() {
		mover();
		try {
			sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mover() {
		posY += velocidad;
	}

}
