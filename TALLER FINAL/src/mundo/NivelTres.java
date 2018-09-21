package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class NivelTres extends Nivel {

	/**
	 * Atributos de la clase NivelDos
	 * PImage fondo fondo de pantalla del nivel tres
	 * PImage []botones que carga todas las botones del nivel tres
	 * PImage []instrucciones que carga todas las instrucciones del nivel tres
	 * int in indice de imagen de historia usado para cambiar la pantalla

	 */
	private PImage fondo;
	private PImage[] botones;
	private PImage[] instrucciones;

	private int in;

	/**
	 * Constructor de la clase NivelTres que inicializa los atributos de la clase
	 * @param app de tipo PApplet es la relacion con la libreria PApplet 
	 */
	public NivelTres(PApplet app) {
		super(app);

		instrucciones = new PImage[3];

		in = 0;
		crearImagen();

	}

	@Override
	public void crearImagen() {
		instrucciones[0] = app.loadImage("instrucciones.jpg");

		instrucciones[1] = app.loadImage("instrucciones03.jpg");

		instrucciones[2] = app.loadImage("instrucciones6.jpg");

	}

	@Override
	public void pintarimagen() {
		app.imageMode(PApplet.CORNER);
		// boton jugar
	
		switch (in) {
		case 0:
			app.image(instrucciones[in], 0, 0);

			break;
		case 1:
			app.image(instrucciones[in], 0, 0);
			break;
		case 2:
			app.image(instrucciones[in], 0, 0);

			break;
		case 3:
			app.image(instrucciones[4], 0, 0);

			break;
		case 4:
			app.image(instrucciones[in], 0, 0);

			break;
		case 5:
			app.image(instrucciones[in], 0, 0);

			break;
		case 6:
			app.image(instrucciones[in], 0, 0);

			break;

		}

		app.imageMode(PApplet.CORNER);
	}

	/**
	 * Metodo eventoMouse que valida el  clic del usuario en un lugar especifico de la pantalla para asi cambiar de pagina de la historia
	 */
	public void eventoMouse() {
		if (app.mouseX > 367 && app.mouseX < 685 && app.mouseY > 819 && app.mouseY < 894) {
			in = 1;
		}
		if (app.mouseX > 891 && app.mouseX < 1027 && app.mouseY > 983 && app.mouseY < 1040) {
			in = 0;
		}
		if (app.mouseX > 1209 && app.mouseX < 1524 && app.mouseY > 822 && app.mouseY < 894) {
			in = 2;
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
