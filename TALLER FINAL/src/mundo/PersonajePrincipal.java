package mundo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class PersonajePrincipal extends Personaje {

	/**
	 * Atributos de la clase PersonajePrincipal 
	 * ArrayList<Nivel> niveles representando a los niveles y su relacion con los personajes 
	 * PApplet app relacion con la libreria de processing 
	 * int vida vida del personaje 
	 * int monedas monedas del personaje
	 */
	protected ArrayList<Nivel> niveles;
	protected PApplet app;
	protected int vida;
	protected int monedas;

	/**
	 * Constructor de la clase PersonajepPrincipal 
	 * @param app relacion con la libreria PApplet
	 * @param x   posicion en x del personaje
	 * @param y  posicion en y del personaje
	 */
	public PersonajePrincipal(PApplet app, int x, int y) {
		super(app, x, y);
		this.app = app;
		this.posX = x;
		this.posY = y;
		niveles = new ArrayList<Nivel>();
		vida = 100;
		monedas = 0;

	}

	/**
	 * Metodo crearNivelesParaChoques que agrega niveles para asi tener una referencia de su posicion en el espacio
	 */
	public void crearNivelesParaChoques() {
		niveles.add(new NivelUno(app));
	}

	/**
	 * Metodo bajarVida que baja la vida de tu personajePrincipal
	 * @param vidaB int vidaB vida que bajara al personaje principal
	 */
	public void bajarVida(int vidaB) {
		if (vida >= 0) {
			vida -= vidaB;
		}
	}

	/**
	 * Metodo subirVida que sube la vida de tu personajePrincipal
	 * @param vidaS int vidaS vida que subira la del personaje principal
	 */
	public void subirVida(int vidaS) {
		if (vida <= 100) {
			vida += vidaS;
		}
	}

	/**
	 * Metodo setMoneda que cambia la cantidad de monedas que posee  el personaje principal 
	 * @param moneda int  moneda numero de  monedas a sumar
	 */
	public void setMoneda(int moneda) {
		monedas += moneda;
	}

	public abstract void cargarAnimacion();

	public abstract void atacar();

	public abstract void animar();

	public abstract void run();

	public abstract void pintar();
}
