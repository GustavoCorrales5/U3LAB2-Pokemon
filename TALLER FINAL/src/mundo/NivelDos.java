package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class NivelDos extends Nivel {

	/**
	 * Atributos de la clase NivelDos
	 * PImage historia[] que carga todas las pantallas de la historia del juego 
	 * int in indice de imagen de historia usado para cambiar la pantalla
	 */
	private PImage historia[];
	private int in;

	/**
	 * Constructor de la clase NivelDos que inicializa los atributos de la clase
	 * @param app de tipo PApplet es la relacion con la libreria PApplet 
	 */
	public NivelDos(PApplet app) {
		super(app);

		historia = new PImage[8];
		crearImagen();
		in = 0;

	}

	@Override
	public void crearImagen() {
		historia[0] = app.loadImage("Historia.jpg");
		historia[1] = app.loadImage("HistoriaBoton.jpg");
		historia[2] = app.loadImage("HistoriaBoton2.jpg");
		historia[3] = app.loadImage("Historia1.jpg");
		historia[4] = app.loadImage("Historia1Boton.jpg");
		historia[5] = app.loadImage("Historia1Boton2.jpg");
		historia[6] = app.loadImage("Historia2.jpg");
		historia[7] = app.loadImage("Historia2Boton.jpg");
	}

	@Override
	public void pintarimagen() {
		app.imageMode(PApplet.CORNER);
		if (app.mouseX > 1602 && app.mouseX < 1740 && app.mouseY > 871 && app.mouseY < 951) {
			app.image(historia[1], 0, 0);
		} else {
			app.image(historia[0], 0, 0);
		}

		if (in == 3) {
			app.image(historia[3], 0, 0);
			if (app.mouseX > 1602 && app.mouseX < 1740 && app.mouseY > 871 && app.mouseY < 951) {
				app.image(historia[4], 0, 0);
			} else if (app.mouseX > 212 && app.mouseX < 358 && app.mouseY > 871 && app.mouseY < 951) {
				app.image(historia[5], 0, 0);
			} else {
				app.image(historia[3], 0, 0);

			}
		}

		if (in == 6) {
			app.image(historia[6], 0, 0);
			if (app.mouseX > 212 && app.mouseX < 358 && app.mouseY > 871 && app.mouseY < 951) {
				app.image(historia[7], 0, 0);
			} else {
				app.image(historia[6], 0, 0);
			}
		}

		app.imageMode(PApplet.CORNER);
	}

	public void eventoMouse() {

		if (app.mouseX > 1602 && app.mouseX < 1740 && app.mouseY > 871 && app.mouseY < 951) {
			in = 3;
		}

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
	}

}
