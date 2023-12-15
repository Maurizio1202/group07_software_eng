package scientificCalculator;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author group_07
 */
public class ScientificCalculator_07 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("CalculatorView.fxml"));
        stage.getIcons().add(new Image("/scientificCalculator/calculator_icon.png"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Scientific Calculator");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
