package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONObject;

public class Controller {

    @FXML
    ImageView myImageView;
    Button myButton;

    public void changeImage() {

        APIConnector apiConnector = new APIConnector();
        JSONObject jsonObject = apiConnector.getJSONFromAPI();
        System.out.println(jsonObject.get("message"));

        Image newImage = new Image(jsonObject.get("message").toString());
        myImageView.setImage(newImage);
    }
}
