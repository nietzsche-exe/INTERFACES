package es.ciudadescolar.propiedades;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    public TextField password;
    @FXML
    public TextField retype;

    private final StringProperty _password;

    private final StringProperty _retype;

    private final BooleanProperty _disable;

    public HelloController(){

        _password = new SimpleStringProperty();
        _retype = new SimpleStringProperty();
        _disable = new SimpleBooleanProperty(true);

    }

    public void initialize(){
        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.printf("password changed from %s to %s%n", oldValue, newValue);
                setDisable(mustDisable());
            }
        });
        retype.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.printf("retype changed from %s to %s%n", oldValue, newValue);
                setDisable(mustDisable());
            }
        });
    }

    private boolean mustDisable(){
        String pass = password.getText();
        String rety = retype.getText();
        return  !(pass != null && pass.equals(rety));
    }

    public  StringProperty passwordProperty(){
        return _password;
    }
    public void setPassword(String value){
        _password.setValue(value);
    }

    public String getPassword(){
        return _password.getValue();
    }

    public  BooleanProperty disableProperty(){
        return _disable;
    }

    public void setDisable(Boolean value){
        _disable.setValue(value);
    }

    public Boolean getDisable(){
        return _disable.getValue();
    }

    public  StringProperty retypeProperty(){
        return _retype;
    }
    public void setRetype(String value){
        _retype.setValue(value);
    }

    public String getRetype(){
        return _retype.getValue();
    }

}