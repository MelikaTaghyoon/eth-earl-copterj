
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;
	private BorderPane mainLayout;
	@Override
	public void start(Stage primaryStage){		 
        try {
        	this.primaryStage = primaryStage;
        	this.primaryStage.setTitle("aapp");
        	
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(Main.class.getResource("mainForm.fxml"));
        	mainLayout = loader.load();
        	Scene scene = new Scene(mainLayout);
        	primaryStage.setScene(scene);
        	primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
