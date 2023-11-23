package es.ciudadescolar.propiedades;

import javafx.beans.binding.Bindings;
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

    private static final int PASSWORD_MIN_LENGTH = 5;
    @FXML
    public TextField password;
    @FXML
    public TextField retype;

    private final StringProperty _password;

    private final StringProperty _retype;

    private final BooleanProperty _disabled;

    public HelloController(){

        _password = new SimpleStringProperty();
        _retype = new SimpleStringProperty();
        _disabled = new SimpleBooleanProperty(true);

    }

    public void initialize() {
        /* usando la API fluida */
        _disabled.bind(
                password.textProperty().isEmpty()
                        .or(password.textProperty().length().lessThan(PASSWORD_MIN_LENGTH))
                        .or(retype.textProperty().isNotEqualTo(password.textProperty())));

        /*Otra forma de hacerlo, sin usar API fluida*/
//        _disabled.bind(Bindings.createBooleanBinding(() -> {
//                    String p = password.getText();
//                    String r = retype.getText();
//                    return p == null || p.isBlank() || p.length() < PASSWORD_MIN_LENGTH || !r.equals(p);
//                },
//                password.textProperty(), retype.textProperty()));

        /*Añade esto a la cadena de bindings si quieres impedir contraseñas que comiencen por "a"*/
//        Bindings.createBooleanBinding(() -> password.getText().startsWith("a"),
//                password.textProperty());

        /* Otra forma de hacerlo, extendiendo BooleanBinding */
//        BooleanBinding passwordStartsWithA = new BooleanBinding() {
//            {
//                super.bind(password.textProperty());
//            }
//
//            @Override
//            protected boolean computeValue() {
//                return password.getText().startsWith("a");
//            }
//        };
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