package mundo;

import processing.core.PApplet;

public class Rey extends PersonajePrincipal {

	public Rey(PApplet app, int x, int y) {
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

		if (app.keyCode == app.RIGHT) {
			posX += 4;
		} else if (app.keyCode == app.LEFT) {
			posX -= 4;
		} else if (app.keyCode == app.UP) {
			posY -= 4;
		} else if (app.keyCode == app.DOWN) {
			posY += 4;
		}
	}

	@Override
	public void pintar() {
		app.fill(0, 0, 255);
		app.ellipse(posX, posY, 20, 20);
	}

}
