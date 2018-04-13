import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MainController implements Initializable {
	//temp values
	private int rows = 10;
	private int cols = 10;
	

	@FXML
	private BorderPane root;
	@FXML
	private GridPane gridView;
	@FXML
	private Button ButtonDraw;
/*	@FXML
	private ScrollBar heightScroll;
	@FXML
	private ScrollBar widthScroll;
	@FXML 
	private Button increment;*/
	@FXML
	private Button clear;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML public void initialize() {


	}
	
	/**
	 * @param event
	 */
	public void drawGrids(ActionEvent event) {
		
		test();
		
	}
	
	private void test() {
        for (int i = 0; i < cols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / cols);
            gridView.getColumnConstraints().add(colConst);
            colConst.setHgrow(Priority.ALWAYS);
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints rowConst = new RowConstraints();
            //rowConst.setPercentHeight(100.0 / rows);
            rowConst.setPercentHeight(100.0 / cols);
            gridView.getRowConstraints().add(rowConst); 
            rowConst.setVgrow(Priority.ALWAYS);
        }
	}
	
	public void clearButton(ActionEvent event) {
		ColumnConstraints colConst = new ColumnConstraints();
		RowConstraints rowConst = new RowConstraints();
		gridView.getChildren().removeAll();
		
	}
	
}
