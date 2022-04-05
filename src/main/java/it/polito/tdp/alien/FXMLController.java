/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private List<String> aliene = new LinkedList<>();
	private List<String> tradotte = new LinkedList<>();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // fx:id="btnTraduttore"
    private Button btnTraduttore; // Value injected by FXMLLoader

    @FXML // fx:id="txtArea"
    private TextArea txtArea; // Value injected by FXMLLoader

    @FXML // fx:id="txtField"
    private TextField txtField; // Value injected by FXMLLoader

    @FXML
    void doClear(ActionEvent event) {
    	aliene.clear();
    	tradotte.clear();
    	txtField.clear();
    	txtArea.clear();
    	btnClear.setDisable(true);
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	btnClear.setDisable(false);
    	String s = txtField.getText();
    	String[] array = s.toLowerCase().split(" ");
    	int i = 0;
    	String tr;
    	if(array.length == 2) {
    	String aliena = array[0];
    	String umana = array[1];
    	aliene.add(aliena);
    	tradotte.add(umana);
    	txtArea.setText("Traduzione aggiunta con successo!");
    	return;
    	}else if (array.length == 1) {
    		if(aliene.contains(array[0])){
    			i = aliene.indexOf(array[0]);
    			tr = tradotte.get(i);
    			txtArea.setText(tr);
    			return;
    		}else {
    			txtArea.setText("Traduzione non ancora aggiunta!");
    		}
    	}else {
    		txtArea.setText("Errore!");
    	}
    	}

    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraduttore != null : "fx:id=\"btnTraduttore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
