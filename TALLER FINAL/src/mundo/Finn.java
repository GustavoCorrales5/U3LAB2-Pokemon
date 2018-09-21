package mundo;

import processing.core.PApplet;

public class Finn extends PersonajePrincipal {

	public Finn(PApplet app, int x, int y) {
		super(app, x, y);
	}

	@Override
	public void cargarAnimacion() {
		// TODO Auto-generated method stub

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

	public void accionesTeclas() {
		System.out.println(app.keyCode);

		if (app.keyCode== 68) {
			posX += 4;
		} else if (app.key == 'a') {
			posX -= 4;
		} else if (app.keyCode == 87) {
			posY -= 4;
		} else if (app.key == 's') {
			posY += 4;
		}
	}

	@Override
	public void pintar() {
		app.fill(0, 255, 0);
		app.ellipse(posX, posY, 20, 20);
	}

}