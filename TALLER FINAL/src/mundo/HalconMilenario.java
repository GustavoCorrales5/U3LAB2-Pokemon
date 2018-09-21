package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class HalconMilenario extends PersonajePrincipal {

	/**
	 * Atributos de la clase HalconMilenario 
	 * PImage[] halcon imagenes del halcon
	 * PImage bn imagen en blanco y negro de la pantalla en negativo 
	 * int max indice de imagen 
	 * int movX movimiento en x del personaje
	 * int movY movimiento en y del personaje
	 * boolean paso deteccion del paso a el siguiente nivel
	 */
	private PImage[] halcon;
	private PImage bn;
	private int max;
	private int movX;
	private int movY;
	private boolean paso;

	/**
	 * Metodo constructor de la clase HalconMilenario
	 * @param app relacion con la libreria PApplet de processing
	 * @param x int x posicion x del personaje
	 * @param y int y posicion y del personaje
	 * @param mY int my movimiento en y del personaje
	 */
	public HalconMilenario(PApplet app, int x, int y, int mY) {
		super(app, x, y);
		movX = 0;
		movY = mY;
		cargarAnimacion();
		paso = false;
		max = 1;
	}

	@Override
	public void cargarAnimacion() {
		bn = app.loadImage("nivel1BN.jpg");
		halcon = new PImage[3];
		for (int i = 0; i < halcon.length; i++) {
			halcon[i] = app.loadImage("halcon" + (i + 1) + ".png");
		}
	}

	@Override
	public void atacar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void animar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * Metodo accionesTeclas que captura las teclas seleccionadas  por el usuario para asi mover el halcon 
	 */
	public void accionesTeclas() {
		int pos = posX + posY * bn.width;

		if (app.keyCode == PApplet.RIGHT) {
			System.out.println("hola");
			if (posX > 0 && posX < 1920) {
				if (bn.get((movX * -1) + posX - 60, (movY * -1) + posY) == app.color(255, 255, 255)) {
					app.smooth();
					posX += 15;
				} else {
					posX -= 10;
				}
			} else {
				posX -= 15;
			}
		}

		if (app.keyCode == PApplet.LEFT) {
			if (posX > 0 && posX < 1920) {
				if (bn.get((movX * -1) + posX - 60, (movY * -1) + posY) == app.color(255, 255, 255)) {

					app.smooth();
					posX -= 15;

				} else {
					posX += 10;
				}
			} else {
				posX -= 15;
			}
		}
		if (posX <= 0 || posX >= app.width)
			posX *= -1;
	}

	/**
	 * Metodo pintarPersonaje que pinta el personaje y su gif mediante un framecount
	 */
	public void pintarPersonaje() {
		if (app.frameCount % 8 == 0) {
			max++;
		}
		if (max > 2)
			max = 0;
		app.image(halcon[max], posX, posY);
		app.fill(255, 0, 0);
		app.rect(480, 140, vida, 20);
	}

	/**
	 * Metodo getPaso que verifica si la posicion en y del personaje  es una determinada
	 * @return paso boolean paso en true cuando el halcon llega a cierto punto del lienzo 
	 */
	public boolean getPaso() {
		return paso;
	}

	@Override
	public void pintar() {
		System.out.println(app.keyCode);
		if (movY >= 10743) {
			paso = true;
		}
		if (movY <= 10743) {
			movY += 4;
		}
		pintarPersonaje();

	}

}