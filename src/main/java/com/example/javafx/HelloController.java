package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.simple.JSONObject;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        APIConnector apiConnector = new APIConnector();

        JSONObject jsonObject = apiConnector.getJSONFromAPI();
        System.out.println(jsonObject.get("message"));
    }
}