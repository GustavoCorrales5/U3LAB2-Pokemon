package mundo;

import processing.core.PApplet;
import processing.core.PImage;

public class NivelUno extends Nivel{
	
	/**
	 * Atributos de la clase nivel 1
	 * PImage fondo fondo de la interfaz de inicio 
	 * PImage[] botones botones de la interfaz
	 * boolean  muted que mutea el sonido del nivel
	 */
	private PImage fondo; 
	private PImage[] botones; 
	private boolean muted;

	/**
	 * Constructor de la clase NivelUno que inicializa los atributos de la clase
	 * @param app de tipo PApplet es la relacion con la libreria PApplet 
	 */
	public NivelUno(PApplet app) {
		super(app);
		
		crearImagen();
		muted=false;
	}
	
	
	
	@Override
	public void crearImagen() {
		fondo= app.loadImage("p0fondoP.png");
		botones=new PImage[9];
		
		botones[0]=app.loadImage("p0historiaP.png");
		botones[1]=app.loadImage("p0historia1P.png");
		botones[2]=app.loadImage("p0instruccionesP.png");
		botones[3]=app.loadImage("p0instrucciones1P.png");
		botones[4]=app.loadImage("p0jugarP.png");
		botones[5]=app.loadImage("p0jugar1P.png");
		botones[6]=app.loadImage("p0sonidoP.png");
		botones[7]=app.loadImage("p0sonido1P.png");
		botones[8]=app.loadImage("p0sonidomP.png");		
	}
	@Override
	public void pintarimagen() {
		app.image(fondo, 0, 0);
		app.imageMode(PApplet.CENTER);
		//boton jugar
		if(app.mouseX>840 && app.mouseX<1073 && app.mouseY>721 && app.mouseY<782) {
			app.image(botones[5],956,752);
		} else{
			app.image(botones[4],956,752);
		} 
		
		//boton instrucciones
		if(app.mouseX>782 && app.mouseX<1139 && app.mouseY>806 && app.mouseY<868) {
			app.image(botones[3],960,837);
		} else{
			app.image(botones[2],960,837);
		} 
		
		//boton historia
		if(app.mouseX>782 && app.mouseX<1139 && app.mouseY>891 && app.mouseY<952) {
			app.image(botones[1],956,921);
		} else{
			app.image(botones[0],956,921);
		} 
		
		//boton sonido
		if(app.mouseX>90 && app.mouseX<142 && app.mouseY>992 && app.mouseY<1033) {
			app.image(botones[7],116,1011);
		}  else if(muted==true) {
			app.image(botones[8],116,1011);
		}else{
			app.image(botones[6],116,1011);
		}
		
		app.imageMode(PApplet.CORNER);
	}
	
	/**
	 * Metodo mutear que cambia el valor de la variable booleana muted a true para mutear el sonido
	 */
	public void mutear() {
		muted=true;
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
