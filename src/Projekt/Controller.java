package Projekt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private int number = 0;

    private ObservableList<String> pizzaChoiceBox1List = FXCollections.observableArrayList("margarita","salami","prosciutto","wiejska");
    private ObservableList<String> rozmiarList = FXCollections.observableArrayList("mała","średnia","duża");
    private ObservableList<String> napojeChoiceBoxList = FXCollections.observableArrayList("cola","fanta","sprite","woda");
    private ObservableList<String> dodatkiChoiceBoxList = FXCollections.observableArrayList("Frytki","Zapiekanka","Sos - ketchup","Sos - czosnek");

    @FXML
    public TextField cenaTextFiled;

    @FXML
    private AnchorPane pizzaPanel, napojePanel, dodatkiPanel;

    @FXML
    private Button pizzaButton, napojeButton, dodatkiButton;

    @FXML
    private ObservableList<Zamowienie> zamowienieList = FXCollections.observableArrayList();

    @FXML
    private Zamowienie newZamowienie = new Zamowienie();

    @FXML
    private ChoiceBox<String> pizzaChoiceBox1, rozmiarP, napojeChoiceBox, dodatkiChoiceBox,rozmiarN, rozmiarD;

    @FXML
    private TableView<Zamowienie> tabelaZamowienie;
    @FXML
    private TableColumn<Zamowienie, String> rodzajColumn;
    @FXML
    private TableColumn<Zamowienie, String> wielkoscColumn;
    @FXML
    private TableColumn<Zamowienie, Double> cenaColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pizzaChoiceBox1.setItems(pizzaChoiceBox1List);
        rozmiarP.setItems(rozmiarList);
        rozmiarN.setItems(rozmiarList);
        rozmiarD.setItems(rozmiarList);
        napojeChoiceBox.setItems(napojeChoiceBoxList);
        dodatkiChoiceBox.setItems(dodatkiChoiceBoxList);
        tabelaZamowienie.setItems(zamowienieList);

        rodzajColumn.setCellValueFactory(new PropertyValueFactory<>("Rodzaj"));
        wielkoscColumn.setCellValueFactory(new PropertyValueFactory<>("Wielkosc"));
        cenaColumn.setCellValueFactory(new PropertyValueFactory<>("Cena"));

    }
    @FXML
    private void addZamowieniePizza(ActionEvent event){
        newZamowienie.setRodzaj(pizzaChoiceBox1.getValue());
        newZamowienie.setWielkosc(rozmiarP.getValue());
        double cena;
        switch (pizzaChoiceBox1.getValue()) {
            case "margarita":
                cena = 20;
                break;
            case "salami":
                cena = 22;
                break;
            case "prosciutto":
                cena = 24;
                break;
            default:
                cena = 26;
                break;
        }

        switch (rozmiarP.getValue()) {
            case "mała":
                cena = cena * 0.8;
                break;
            case "duża":
                cena = cena * 1.2;
                break;
            default:

                break;
        }
        double cenas = Math.round(cena*100.0)/100.0;
        newZamowienie.setCena(cenas);
        zamowienieList.add(new Zamowienie(newZamowienie.getRodzaj(), newZamowienie.getWielkosc(), newZamowienie.getCena()) );
    }
    @FXML
    private void addZamowienieDodatki(ActionEvent event) {
        newZamowienie.setRodzaj(dodatkiChoiceBox.getValue());
        newZamowienie.setWielkosc(rozmiarD.getValue());
        double cena;
        switch (dodatkiChoiceBox.getValue()) {
            case "Zapiekanka":
                cena = 12;
                break;
            case "Frytki":
                cena = 10;
                break;
            default:
                cena = 4;
                break;
        }
        switch (rozmiarD.getValue()) {
            case "mała":
                cena = cena * 0.8;
                break;
            case "duża":
                cena = cena * 1.2;
                break;
            default:
                break;
        }
        double cenas = Math.round(cena*100.0)/100.0;
        newZamowienie.setCena(cenas);
        zamowienieList.add(new Zamowienie(newZamowienie.getRodzaj(), newZamowienie.getWielkosc(), newZamowienie.getCena()) );
    }
    @FXML
    private void addZamowienieNapoje(ActionEvent event) {
        newZamowienie.setRodzaj(napojeChoiceBox.getValue());
        newZamowienie.setWielkosc(rozmiarN.getValue());
        double cena;
        switch (napojeChoiceBox.getValue()) {
            case "cola":
                cena = 12;
                break;
            case "fanta":
                cena = 10;
                break;
            case "sprite":
                cena = 8;
                break;
            default:
                cena = 6;
                break;
        }

        switch (rozmiarN.getValue()) {
            case "mała":
                cena = cena * 0.8;
                break;
            case "duża":
                cena = cena * 1.2;
                break;
            default:
                break;
        }
        double cenas = Math.round(cena*100.0)/100.0;
        newZamowienie.setCena(cenas);
        zamowienieList.add(new Zamowienie(newZamowienie.getRodzaj(), newZamowienie.getWielkosc(), newZamowienie.getCena()) );
    }
    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == pizzaButton){
            pizzaPanel.toFront();
        }else if (event.getSource() == napojeButton){
            napojePanel.toFront();
        }else if (event.getSource() == dodatkiButton){
            dodatkiPanel.toFront();
        }
    }
    @FXML
    private void deleteRowAction(ActionEvent event){
        tabelaZamowienie.getItems().removeAll(tabelaZamowienie.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void countZamowienie(ActionEvent event){
        double cena = 0.0;
        for (int i = 0; i < tabelaZamowienie.getItems().size(); i++) {
            newZamowienie = tabelaZamowienie.getItems().get(i);
            cena += newZamowienie.getCena();
        }
        double cenas = Math.round(cena*100.0)/100.0;
        cenaTextFiled.setText((cenas+" zł"));
    }
    @FXML
    private void recipt(ActionEvent event) throws Exception{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
            Parent root1 = loader.load();
            Controller2 controller2 = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1, 100, 100));
            stage.setTitle("Numer Zamówienia");
            stage.setResizable(false);
            stage.show();
            number++;
            controller2.showInformation(number);
            System.out.println(number);
            for (Zamowienie bean:zamowienieList) {
                System.out.println(bean.getRodzaj()+" "+bean.getWielkosc()+" "+bean.getCena());
            }
            zamowienieList.clear();
    }
}