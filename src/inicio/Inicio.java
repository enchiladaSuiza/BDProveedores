package inicio;

import javafx.application.Application;
import javafx.stage.Stage;

public class Inicio extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {
		EncargadoVistas encargadoVistas = new EncargadoVistas();
		encargadoVistas.abrirVistaPrincipal();
	}

}
