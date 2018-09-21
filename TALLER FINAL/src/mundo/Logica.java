package mundo;

import java.util.ArrayList;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Gesture.Type;
import com.leapmotion.leap.HandList;

import ddf.minim.AudioPlayer;
import ddf.minim.AudioSample;
import ddf.minim.Minim;
import ddf.minim.Playable;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import de.voidplus.leapmotion.*;

public class Logica {

	/**
	 * Atributos de la clase Logica que seran inicializados en el constructor de la
	 * clase Logica PApplet app conexion con la libreria de Processing PApplet int
	 * pantalla variable que determina el lugar en donde se ubica el juego o el
	 * estado del juego ArrayList<Personaje> personajes lista de personajes que
	 * guarda todos mis personajes ArratList<Nivel> niveles lista de niveles donde
	 * se ubican los diferentes niveles del juego Minim minim relacion con la
	 * libreria Minim para reproducir sonidos AudioPlayer musicaDeFondo musica de
	 * fondo que sonara a lo largo del juego ArrayList<BalaEnemigo> balasE lista de
	 * las balas de los enemigos que se actualizan cada 4 frames
	 * ArrayList<BalaUsuario> balasU lista de las balas de los usuarios que tendran
	 * un limite AudioSample balaUser sonido de la bala del usuario AudioSample
	 * balaEnemigo sonido bala enemigo boolean disparoJugado2 booleano que detecta
	 * un movimiento en leapmotion PImage instrucciones2 que pinta las
	 * instrucciones2 AudioPlayer musicaWin musica de victoria
	 * 
	 */
	private LeapMotion leap;

	private PApplet app;
	private int pantalla;
	private ArrayList<Personaje> personajes;
	private ArrayList<Nivel> niveles;
	private Minim minim;
	private AudioPlayer musicaDeFondo;
	private ArrayList<BalaEnemigo> balasE;
	private ArrayList<BalaUsuario> balasU;
	private AudioSample balaUser;
	private AudioSample balaEnemigo;
	private boolean disparoJugado2;
	private PImage instrucciones2;
	private AudioPlayer musicaWin;

	/**
	 * Constructor de la clase Logica que inicializa todos los atributos de la clase
	 * Logica
	 * 
	 * @param app.
	 *            PApplet app conexion con la libreria de processing
	 */
	public Logica(PApplet app) {
		this.app = app;
		personajes = new ArrayList<Personaje>();
		niveles = new ArrayList<Nivel>();
		minim = new Minim(app);
		balasE = new ArrayList<BalaEnemigo>();
		balasU = new ArrayList<BalaUsuario>();
		pantalla = 0;
		leap = new LeapMotion(app).allowGestures("swipe");
		disparoJugado2 = false;

		instrucciones2 = app.loadImage("Historia1.jpg");
		crearNiveles();
		crearPersonajes();
		cargarMusicaDeFondo();
	}

	/**
	 * Metodo cargarMusicaDeFondo que carga e inicializa algunas de los atributos de
	 * tipo Minim
	 */
	public void cargarMusicaDeFondo() {
		musicaDeFondo = minim.loadFile("musicaFondo.mp3");
		balaUser = minim.loadSample("disparoUsuario.wav");
		balaEnemigo = minim.loadSample("disparoEnemigo.wav");
		musicaWin = minim.loadFile("win.wav");

		if (pantalla == 4) {
			musicaWin.play();
		} else {
			musicaDeFondo.play();

		}
	}

	/**
	 * Metodo crearNiveles que agrega nuevos niveles a la lista de niveles para asi
	 * jugar los niveles
	 */
	public void crearNiveles() {
		// inicio
		niveles.add(new NivelUno(app));
		// instrucciones
		niveles.add(new NivelDos(app));
		// historia
		niveles.add(new NivelTres(app));
		// juego nivel 1
		niveles.add(new NivelCuatro(app));
		// juego nivel 2
		niveles.add(new NivelCinco(app));

	}

	/**
	 * Metodo crearPersonajes que agrega personajes a la lista de Personajes  
	 */
	public void crearPersonajes() {
		personajes.add(new Rey(app, app.width / 2, app.height / 2));
		personajes.add(new Finn(app, app.width / 2, app.height / 2));
		personajes.add(new HalconMilenario(app, (app.width / 2) - 300, app.height / 2,
				((NivelCuatro) niveles.get(3)).getPosY()));
		personajes.add(new HalconMilenario2(app, (app.width / 2) + 300, app.height / 2,
				((NivelCuatro) niveles.get(3)).getPosY()));
		for (int i = 0; i < 10; i++) {
			NaveEnemiga n = new NaveEnemiga(app, (i * 250) + 75, 60, 1, 3, 130);

			personajes.add(n);

		}

	}

	/**
	 * Metodo setDisparoJugado2 que cambia el booleano de falso a positivo tras detectar una accion en leapmotion que activa los disparos
	 * @param jugador2 tipo boolean que dara valor a la variable booleana disparoJugado2
	 */
	public void setDisparoJugado2(boolean jugador2) {
		disparoJugado2 = jugador2;
	}

	/**
	 * Metodo setPosX que cambia la posicion de la nave 2 a la de la mano detectada por el leapmotion
	 * @param x tipo float que sera la posicion x entrante de la mano 
	 */
	public void setPosX(float x) {
		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i) instanceof HalconMilenario2) {
				((HalconMilenario2) personajes.get(i)).setPosX(x);
			}
		}
	}

	/**
	 * Metodo pintarNaveEnemiga que pinta y levanta el hilo de la nave enemiga para asi moverla dentro del lienzo
	 */
	public void pintarNaveEnemiga() {
		int balasUsuario;
		balasUsuario = (int) app.random(0, 10);

		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i) instanceof NaveEnemiga) {
				personajes.get(i).pintar();
				personajes.get(i).animar();
				if (app.frameCount % 20 == 0 && i == balasUsuario) {
					BalaEnemigo b = new BalaEnemigo(app, personajes.get(i).getPosX(), personajes.get(i).getPosY(), 5);
					balaEnemigo.trigger();
					balasE.add(b);
					b.start();
				}
			}
		}

		for (int i = 0; i < balasE.size(); i++) {
			balasE.get(i).pintar();
			balasE.get(i).mover();
		}
	}

	/**
	 * Metod eventosMouse que valida los clics del usuario dentro de la interfaz
	 */
	public void eventosMouse() {
		if (pantalla == 0) {
			if (app.mouseX > 90 && app.mouseX < 142 && app.mouseY > 992 && app.mouseY < 1033) {
				musicaDeFondo.mute();
				((NivelUno) niveles.get(0)).mutear();
			} else if (app.mouseX > 840 && app.mouseX < 1073 && app.mouseY > 721 && app.mouseY < 782) {
				pantalla = 3;
			} else if (app.mouseX > 782 && app.mouseX < 1139 && app.mouseY > 891 && app.mouseY < 952) {
				pantalla = 1;
			} else if (app.mouseX > 782 && app.mouseX < 1139 && app.mouseY > 806 && app.mouseY < 868) {
				pantalla = 2;
			}
		}
		if (pantalla == 1) {
			if (app.mouseX > 1602 && app.mouseX < 1740 && app.mouseY > 871 && app.mouseY < 951) {
				((NivelDos) niveles.get(1)).eventoMouse();
			}
			if (app.mouseX > 212 && app.mouseX < 358 && app.mouseY > 871 && app.mouseY < 951) {
				pantalla = 0;
			}

		}

		if (pantalla == 2) {
			((NivelTres) niveles.get(2)).eventoMouse();
			if (app.mouseX > 65 && app.mouseX < 234 && app.mouseY > 43 && app.mouseY < 113) {
				pantalla = 0;
			}
		}

		if (pantalla == 4) {
			((NivelCinco) niveles.get(4)).eventoMouse();
			if (app.mouseX > 713 && app.mouseX < 1205 && app.mouseY > 654 && app.mouseY < 747) {
				app.exit();
			}
		}

	}

	/**
	 * Metodo validarAtaqueAJugador que valida el ataque al jugador proveniente de un enemigo 
	 */
	public void validarAtaqueAJugador() {
		if (pantalla == 3) {
			if (balasE.size() >= 1) {
				for (int i = 0; i < balasE.size(); i++) {
					for (int j = 0; j < personajes.size(); j++) {
						if (personajes.get(j) instanceof HalconMilenario) {
							if (PApplet.dist(balasE.get(i).getPosX(), balasE.get(i).getPosY(),
									personajes.get(j).getPosX() + 150, personajes.get(j).getPosY() - 100) < 70
									|| PApplet.dist(balasE.get(i).getPosX(), balasE.get(i).getPosY(),
											personajes.get(j).getPosX() + -150,
											personajes.get(j).getPosY() + 100) < 70) {
								((HalconMilenario) personajes.get(j)).bajarVida(20);

								balasE.remove(i);
							}
						} /*
							 * else if (personajes.get(j) instanceof HalconMilenario2) { if
							 * (PApplet.dist(balasE.get(i).getPosX(), balasE.get(i).getPosY(),
							 * personajes.get(j).getPosX() + 150, personajes.get(j).getPosY() - 100) < 70 ||
							 * PApplet.dist(balasE.get(i).getPosX(), balasE.get(i).getPosY(),
							 * personajes.get(3).getPosX() + -150, personajes.get(3).getPosY() + 100) < 70)
							 * { ((HalconMilenario2) personajes.get(j)).bajarVida(20); balasE.remove(i); } }
							 */
					}

				}
			}
		}
	}

	/**
	 * Metodo validarAtaqueANaveEnemiga que valida si el disparo del usuario llega a la nave enemiga y si le acierta, interrumpe el hilo y la borra de la lista
	 */
	
	public void validarAtaqueANaveEnemiga() {
		for (int i = 0; i < balasU.size(); i++) {
			boolean choco = false;
			for (int j = 0; j < personajes.size() && !choco; j++) {
				if (personajes.get(j) instanceof NaveEnemiga) {
					if (PApplet.dist(balasU.get(i).getPosX(), balasU.get(i).getPosY(), personajes.get(j).getPosX(),
							personajes.get(j).getPosY()) < 50) {
						choco = true;
						((NaveEnemiga) personajes.get(j)).quitarVida();

						// Puntaje que me dará cada invasor
						if (personajes.get(j) instanceof NaveEnemiga) {
							((NivelCuatro) niveles.get(3)).sumarPuntaje1();
						}

						// Condición de que sí la vida de un invasor llega 0, entonces que lo remueva
						// del ArrayList

						if (((NaveEnemiga) personajes.get(j)).getVida() == 0) {
							personajes.remove(j);
						}
						balasU.remove(i);

						// sonido.reproducirColisionEnemigo();

					}
				}
			}
		}
	}

	/**
	 * Metodo pintarNivel10 que pinta la pantalla de inicio
	 */
	public void pintarNivel0() {
		niveles.get(0).pintar();

	}

	/**
	 * Metodo pintarNivel1 que pinta la pantalla de historia
	 */
	public void pintarNivel1() {
		niveles.get(1).pintar();
	}

	/**
	 * Metodo pintarNivel2 que pinta la pantalla de instrucciones
	 */
	public void pintarNivel2() {
		niveles.get(2).pintar();
	}

	/**
	 * Metodo pintarNivel3 que pinta la pantalla de juego 
	 */
	public void pintarNivel3() {
		niveles.get(3).pintar();
		personajes.get(2).pintar();
	}

	/**
	 * Metodo pintarNivel4 que pinta la pantalla de win
	 */
	public void pintarNivel4() {
		niveles.get(4).pintar();

	}

	/**
	 * 	Metodo pintarPersonajes que pinta a mis personajes 
	 */
	public void pintarPersonajes() {
		for (int i = 0; i < personajes.size(); i++) {
			if (pantalla == 3 && (personajes.get(i) instanceof HalconMilenario)) {
				// Pinta la halcon milenario
				personajes.get(i).pintar();
				personajes.get(3).pintar();
				// pintan las balas del usuario

			}
			if (pantalla == 4 && (personajes.get(i) instanceof Rey || personajes.get(i) instanceof Finn
					|| personajes.get(i) instanceof NaveEnemiga2)) {
				personajes.get(i).pintar();
			}

		}
		for (int i = 0; i < personajes.size(); i++) {

		}
	}

	/**
	 * Metodo pintarBalasHalcon que pinta las balas del halcon y las remueve si se salen del lienzo
	 */
	public void pintarBalasHalcon() {
		for (int j = 0; j < balasU.size(); j++) {
			balasU.get(j).pintar();
			if (balasU.get(j).getPosY() < -1) {
				balasU.remove(j);
				return;
			}
		}
	}

	/**
	 * Metodo validarPasoANivel2 que valida el paso de los usuarios a la pantalla de win
	 */
	public void validarPasoANivel2() {
		if ((((HalconMilenario) personajes.get(2)).getPaso() == true)
				&& (((HalconMilenario2) personajes.get(3)).getPaso() == true)) {
			pantalla = 4;
		}
		if (((HalconMilenario) personajes.get(2)).getPaso() == true) {
			pantalla = 4;
		}
		int nave = 0;
		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i) instanceof NaveEnemiga) {
				nave += 1;
			}

		}

		if (nave == 0) {
			pantalla = 4;
		}
	}

	/**
	 * Metodo reproducirSonidoDisparoUsuario que reproduce el sonido del disparo del usuario
	 */
	public void reproducirSonidoDisparoUsuario() {

		balaUser.trigger();

	}

	/**
	 * Metodo eventosDelTeclado que recorre el arreglo de personajes y llama a sus metodos de teclado
	 */
	public void eventosDelTeclado() {

		for (int i = 0; i < personajes.size(); i++) {
			if (personajes.get(i) instanceof Rey) {
				((Rey) personajes.get(i)).accionesTeclas();
			} else if (personajes.get(i) instanceof Finn) {
				((Finn) personajes.get(i)).accionesTeclas();
			} else if (personajes.get(i) instanceof HalconMilenario) {
				((HalconMilenario) personajes.get(i)).accionesTeclas();

			}
			if (personajes.get(i) instanceof HalconMilenario2) {
				((HalconMilenario2) personajes.get(i)).accionesTeclas();
			}
		}
System.out.println(app.keyCode);
		if (pantalla == 3) {
			if (app.keyCode == 32) {
				if (balasU.size() < 4) {
					balasU.add(new BalaUsuario(app, personajes.get(2).getPosX() + 125, personajes.get(2).getPosY(), 3));
					reproducirSonidoDisparoUsuario();
					// sonido.reproducirDisparo();
				}
			} 
			if(app.keyCode==112) {
				setDisparoJugado2(true);
			}

		}
	}

	/**
	 * Metodo pintar de la clase Logica que pinta los elementos que habran en el lienzo mediante un switch de pantalla
	 */
	public void pintar() {

		switch (pantalla) {
		// inicio
		case 0:
			pintarNivel0();
			break;
		// historia
		case 1:
			pintarNivel1();
			break;
		// instrucciones
		case 2:
			pintarNivel2();
			break;
		// juego nivel 1
		case 3:
			pintarNivel3();
			pintarNaveEnemiga();
			validarAtaqueAJugador();
			pintarBalasHalcon();
			validarAtaqueANaveEnemiga();
			validarPasoANivel2();

			if (disparoJugado2 == true) {
				if (balasU.size() < 4) {
					balasU.add(new BalaUsuario(app, personajes.get(3).getPosX() + 125, personajes.get(3).getPosY(), 3));
					reproducirSonidoDisparoUsuario();
					// sonido.reproducirDisparo();
				}
			}
			break;

		// juego nivel 2
		case 4:
			pintarNivel4();
			break;
		}

		pintarPersonajes();

	}

}
