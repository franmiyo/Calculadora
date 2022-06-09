package Vista;

import Controlador.EventsHandler;

public class MainWindow {

	public static void main(String[] args) {

		// Arrancamos la app (Ventana principal)
		VistaCalculadora mainWindow = new VistaCalculadora();
		EventsHandler handler = new EventsHandler(mainWindow);
		mainWindow.setHandler(handler);

	}

}
