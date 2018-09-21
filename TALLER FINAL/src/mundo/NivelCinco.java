package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class NivelCinco extends Nivel {
	/**
	 * Atributos de la clase NivelCinco
	 * int x posicion en x del fondo 
	 * int y posicion en y del fondo 
	 * PImage[] fondo fondos de pantalla del nivel cuatro 
	 * int in indice de imagen de historia usado para cambiar la pantalla

	 */
	private int x, y;
	private PImage fondo[];
	private int in;

	/**
	 * Constructor de la clase NivelCinco que inicializa los atributos de la clase
	 * @param app de tipo PApplet es la relacion con la libreria PApplet 
	 */
	public NivelCinco(PApplet app) {
		super(app);
		x = 0;
		y = 0;
		in=0;
		crearImagen();

	}

	@Override
	public void crearImagen() {
		fondo = new PImage[2];
		fondo[0] = app.loadImage("pantalla-ganaste.jpg");
		fondo[1] = app.loadImage("pantalla-ganaste1.jpg");

	}

	@Override
	public void pintarimagen() {
		app.image(fondo[0], 0, 0);

		if (app.mouseX > 713 && app.mouseX < 1205 && app.mouseY > 654 && app.mouseY < 747) {
			app.image(fondo[1], 0, 0);
			in=1;
		} else {
			app.image(fondo[0], 0, 0);
			in=0;
		}

	}

	/**
	 * Metodo eventoMouse que valida el  clic del usuario en un lugar especifico de la pantalla para asi cambiar de pagina de ganar
	 */
	public void eventoMouse() {
		if (in == 1) {
			if (app.mouseX > 993 && app.mouseX < 1196 && app.mouseY > 648 && app.mouseY < 747) {
				app.exit();
			}
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
