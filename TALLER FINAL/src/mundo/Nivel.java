package mundo;

import java.util.ArrayList;

import org.freedesktop.gstreamer.Video;

import processing.core.PApplet;

public abstract class Nivel extends Thread {

	/**
	 * Atributos de la clase Nivel que dan sus caracteristicas generales a los niveles
	 * int x posicion x del lienzo de nivel
	 * int y posicion y del lienzo de nivel
	 * PApplet app que hace la conexion con la libreria de processing PApplet
	 */
	protected int x; 
	protected int y; 
	protected PApplet app;
	/**
	 * Constructor de la clase Nivel que inicializa los atributos de esta
	 * @param app
	 */
	public Nivel(PApplet app) {
		this.app=app;
		x=0;
		y=0;
	}
	
	/**
	 * Metodo abstracto de crearImagen que inicializa las imagenes
	 */
	public abstract void crearImagen();
	/**
	 * Metodo abstracto de pintarImagen que pinta las imagenes del nivel
	 */
	public abstract void pintarimagen();
	
	/**
	 * Metodo run que pone en funcionamiento los movimientos de los objetos mediante un hilo 
	 */
	public void run() {
		
	}
	
	/**
	 * Metodo de movimientoDeMapa que mueve el fondo del mapa a medida que los personajes se mueven por el lienzo
	 */
	public void movimientoDeMapa() {
		
	}
	
	/**
	 * Metodo validarEtapa1 que valida la etapa 1 del nivel para pasar a la etapa2
	 * @return boolean f inicializado en false y cambiado a true al termianar la etapa
	 */
	public abstract boolean validarEtapa1();
	
	/**
	 * Metodo validarEtapa2 que valida la etapa 2 del nivel para pasar a la terminar el nivel
	 * @return boolean f inicializado en false y cambiado a true al termianar la etapa
	 */
	public abstract boolean validarEtapa2();
 
	/**
	 * Metodo abstracto pintar que pinta los objetos en el lienzo
	 */
	public abstract void pintar();
}
