package inicio;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import vistas.Controlador;

public class EncargadoVistas {
	private final String archivoPrincipal = "/fxml/Main.fxml";
	private final String archivoEstilos = "/css/estilos.css";
	private Controlador controlador;
	
	private void abrirVista(String vista) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(vista));
        Parent raiz = loader.load();
        Stage escenario = new Stage();
        Scene escena = new Scene(raiz);
        controlador = loader.getController();
        
        escena.getStylesheets().add(getClass().getResource(archivoEstilos).toExternalForm());
        escenario.setTitle("Base de Datos de Proveedores");
        escenario.setScene(escena);
        // escenario.setMinWidth(600);
        // escenario.setMinHeight(400);
        escenario.setMinWidth(400);
        escenario.setMinHeight(300);
        escenario.show();
	}
	
	public void abrirVistaPrincipal() throws Exception {
		abrirVista(archivoPrincipal);
		controlador.init();
	}
}
