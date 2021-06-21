package Projekt;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    @FXML
    private Text numerZamowienia;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void showInformation(int number){
        String numberS = "";
        if (number<10){
          numberS =("00"+number);
        }else if (10<number || number<100){
            numberS =("0"+number);
        }else if (100<number||number<1000){
            numberS = String.valueOf(number);
        }else if (number>1000){
            number=1;
            numberS ="00"+number;
        }
        numerZamowienia.setText(numberS);
    }
}