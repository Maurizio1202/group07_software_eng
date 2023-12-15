/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
* group_07
*/
package scientificCalculator;

import calculatorExceptions.DivideByZeroException;
import calculatorExceptions.NotEnoughElementException;
import calculatorExceptions.EmptyStackException;
import calculatorExceptions.NullArgumentsException;
import calculatorExceptions.ScientificCalculatorException;
import calculatorExceptions.VarOutOfRangeException;
import calculatorExceptions.WrongArgumentLogException;
import java.net.URL;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * FXML Controller class
 *
 * @author Utente
 */
public class CalculatorControllerFX implements Initializable {
    
    private Deque<ComplexNumber> stack;
    private ObservableList<ComplexNumber> stackObs;
    private ObservableList<Character> variablesObs;
    private ScientificCalculator parser;
    private Alert alert;

    @FXML
    private ListView<ComplexNumber> stackView;
    @FXML
    private TextField displayField;
    @FXML
    private ComboBox<Character> variablesList;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        alert = new Alert(Alert.AlertType.ERROR);

        stack = new LinkedList<>();

        stackObs = FXCollections.observableArrayList();

        parser = new ScientificCalculator(stack);

        stackView.setItems(stackObs);
        stackView.setCellFactory(lv -> {
            ListCell<ComplexNumber> cell = new ListCell<ComplexNumber>() {
                
                @Override
                protected void updateItem(ComplexNumber c, boolean empty) {
                    super.updateItem(c, empty);
                    if (empty) {
                        setText(null);
                        setStyle("");
                    } else {
                        double re =  round(c.getRealPart());
                        double img =  round(c.getImgPart());

                        if(re == 0 && img == 0)
                            setText("0.0+0.0j");
                        else if(re == 0 && img > 0)
                            setText("0.0+" + img + "j");
                        else if(re == 0 && img < 0)
                            setText("0.0" + img + "j");
                        else if(re > 0 && img == 0)
                            setText(re + "+0.0j");
                        else if(re > 0 && img > 0)
                            setText(re + "+" + img + "j");
                        else if(re > 0 && img < 0)
                            setText(re + "" + img + "j");
                        else if(re < 0 && img == 0)
                            setText(re + "+0.0j");
                        else if(re < 0 && img > 0)
                            setText(re + "+" + img + "j");
                        else
                            setText(re + "" + img + "j");
                    }
                }
            };
            cell.setAlignment(Pos.CENTER);
            cell.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
            return cell;
        });
        
        ImageView sendicon = new ImageView(new Image("scientificCalculator/sendicon.png"));
          
        variablesObs = FXCollections.observableArrayList();

        for (int i = 0; i < 26; i++) {
            variablesObs.add((char) (i + 97));
        }

        variablesList.setItems(variablesObs);
        variablesList.setValue('a');
        variablesList.setStyle("-fx-font: 20px \"Helvetica\";" + "-fx-font-weight: bold;");


        displayField.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                displayField.end();
            }
        });
    }    

    @FXML
    private void keyPressedTextField(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            showDialogAndCallParse();
        }
    }

    @FXML
    private void sumAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "+");
    }

    @FXML
    private void subAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "-");
    }

    @FXML
    private void productAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "x");
    }

    @FXML
    private void signReversalAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "(-)");
    }

    @FXML
    private void divisionAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "÷");
    }

    @FXML
    private void squareRootAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "√");
    }

    @FXML
    private void clearAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "clear");
    }

    @FXML
    private void dropAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "drop");
    }

    @FXML
    private void dupAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "dup");
    }

    @FXML
    private void swapAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "swap");
    }

    @FXML
    private void overAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "over");
    }

    @FXML
    private void cancAction(ActionEvent event) {
        String text = displayField.getText();
        int index = text.lastIndexOf(" ");

        if (index != -1) {
            displayField.setText(text.substring(0, index));
        } else {
            displayField.setText("");
        }
    }

    @FXML
    private void copyFromVarAction(ActionEvent event) {
        displayField.setText(displayField.getText() + ">" + variablesList.getValue());
    }

    @FXML
    private void assignToVarAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "<" + variablesList.getValue());
    }

    @FXML
    private void subToVarAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "-" + variablesList.getValue());
    }

    @FXML
    private void sumToVarAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "+" + variablesList.getValue());
    }

    @FXML
    private void jAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "j");
    }

    @FXML
    private void logAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "log");
    }

    @FXML
    private void expAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "exp");
    }

    @FXML
    private void tanAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "tan");
    }

    @FXML
    private void cosAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "cos");
    }

    @FXML
    private void lnAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "ln");
    }

    @FXML
    private void pointAction(ActionEvent event) {
        displayField.setText(displayField.getText() + ".");
    }

    @FXML
    private void twoAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "2");
    }

    @FXML
    private void threeAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "3");
    }

    @FXML
    private void sixAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "6");
    }

    @FXML
    private void fiveAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "5");
    }

    @FXML
    private void zeroAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "0");
    }

    @FXML
    private void oneAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "1");
    }

    @FXML
    private void fourAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "4");
    }

    @FXML
    private void nineAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "9");
    }

    @FXML
    private void eightAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "8");
    }

    @FXML
    private void sevenAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "7");
    }

    @FXML
    private void sinAction(ActionEvent event) {
        displayField.setText(displayField.getText() + "sin");
    }
    
    @FXML
    private void enterAction(ActionEvent event) {
        showDialogAndCallParse();
    }

    @FXML
    private void delAction(ActionEvent event) {
        String text = displayField.getText();

        if (!text.isEmpty()) {
        text = text.substring(0, text.length() - 1);
        displayField.setText(text);
        }
    }
    
    @FXML
    private void offAction(ActionEvent event) {
        displayField.clear();
        stackObs.clear();
    }
    
    @FXML
    private void onAction(ActionEvent event) {
        informationDialog("The calculator is ready to be used!" , "Try it!");
    }

    
    
        /**
     * The showDialogAndCallParse method is used to execute the sequence of the operations
     * inserted on the text field. It shows an error dialog according to the
     * exception
     */
    private void showDialogAndCallParse() {
        
        String input = displayField.getText().replaceAll("\\s","");
        
        if (input.length() != 0) {

            try {
                parser.parse(input);
            } catch (ScientificCalculatorException ex) {
                errorDialog("Wrong command/s", "You inserted wrong command/s.\nEnter the operations to be performed again.");
            } catch (NotEnoughElementException ex) {
                errorDialog("Not enough operands", "There are not enough operands.\nEnter the operations to be performed again.");
            } catch (DivideByZeroException ex) {
                errorDialog("Division by 0", "Division Error.");
            } catch (VarOutOfRangeException ex) {
                errorDialog("Variable out of range", "The inserted variable doesn't exist.");
            } catch (NullArgumentsException ex) {
                errorDialog("Variable Value Error", "The inserted variable hasn't a value.");
            } catch (WrongArgumentLogException ex){
                errorDialog("Wrong operand for log", "Logarithm of 0 is undefined.");
            } catch (EmptyStackException ex){
                errorDialog("Stack is empty", "Make sure you fill it properly.");
            } finally {
                stackObs.setAll(stack);
            }
        } else {
            warningDialog("Insert one or more operations", "You must insert one or more operations");
        }
        displayField.setText("");
    }
    

        /**
     * The errorDialog method is used to show an error dialog 
     */
    private void errorDialog(String header, String content){
        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    

    
        /**
     * The warningDialog method is used to show a warning dialog
     */
    private void warningDialog(String header, String content){
        alert.setAlertType(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
        /**
     * The informationDialog method is used to show an information dialog 
     */
    private void informationDialog(String header, String content){
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    
    
    private double round(double n) {
        
        double scaledNumber = n * 1e8;
        long roundedValue = Math.round(scaledNumber);
        return roundedValue / 1e8;
    }

    
    
}
