
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.swing.*;

public class Kontrolki extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start (Stage primaryStage) {
        Font font = Font.font("Times New Roman", FontWeight.BOLD, 16);

        System.out.println(Font.getFamilies());
        Color color =Color.web("#FF55FF");
        //Label
        Label label = new Label("My first label");
        label.setLayoutX(10);
        label.setLayoutY(35);
        //label.setFont(new Font(20));
        label.setFont(font);

       // label.setTextFill(Color.RED);
        label.setTextFill(color);


        label.setMaxWidth(80);
        label.setWrapText(true);
        label.setRotate(15);

        //ImageView
        Image image = new Image ("appstore.png");
        ImageView imageView = new ImageView(image);
        //label.setGraphic(imageView);
       // Label labelWithImage = new Label("Label with image", imageView);
        imageView.setX(250);
        imageView.setY(20);

        imageView.setFitHeight(100);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);//rownomiernie skaluje




        //Button
        Button button = new Button("My first button");
        button.setText("Clickable button with a different text");
        button.setLayoutX(20);
        button.setLayoutY(100);
        button.setTextFill(Color.GREEN);
       // button.setGraphic(imageView);
        button.setDisable(false);
        button.setMaxWidth(500);
        button.setWrapText(true);


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println ("I clicked!");
                String text = button.getText() + " I clicked";
                button.setText(text);


            }
        });


        //TextField
        TextField textField = new TextField();
        //textField.setText("text");
        textField.setPromptText("Write your email");
        textField.setPrefColumnCount(20);
        textField.setLayoutX(20);
        textField.setLayoutY(140);

        //Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPrefColumnCount(20);
        passwordField.setLayoutX(20);
        passwordField.setLayoutY(180);

        //Text area

        TextArea textArea = new TextArea();
        textArea.setLayoutX(20);
        textArea.setLayoutY(220);
        textArea.setPromptText("Write sth");
        textArea.setMaxWidth(300);


        //CheckBox

        CheckBox checkBox = new CheckBox("Press the button");
        checkBox.setLayoutX(400);
        checkBox.setLayoutY(20);
        checkBox.setSelected(true);
        checkBox.isSelected();

        //RadioButton

        RadioButton radioButton = new RadioButton("Choice one");
        radioButton.setLayoutX(400);
        radioButton.setLayoutY(50);

        RadioButton radioButton2 = new RadioButton("Choice two");
        radioButton2.setLayoutX(400);
        radioButton2.setLayoutY(70);

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            @Override
            public void changed(ObservableValue<? extends Toggle>observable, Toggle oldValue, Toggle newValue) {
                RadioButton chosen = (RadioButton) newValue;
                System.out.println("Chosen: " + chosen.getText());
            }
});


        //ChoiceBox
        String[] choiceList = {"First", "Second", "Third", "Fourth"};
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.setLayoutX(400);
        choiceBox.setLayoutY(100);
        choiceBox.getItems().addAll(choiceList);

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //System.out.println("Value: " + newValue.intValue());

                String choice = choiceList[newValue.intValue()];
                System.out.println("Chosen from the choicebox: " + choice);
            }
        });

        //ListView
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll(choiceList);
        listView.setLayoutX(400);
        listView.setLayoutY(140);
        listView.setMaxHeight(70);

        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {


            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                String chosenElement = choiceList[newValue.intValue()];
                System.out.println("Chosen from listView: " + chosenElement);
            }

        });


        //ProgressBar

        ProgressBar progressBar = new ProgressBar();
        progressBar.setLayoutX(400);
        progressBar.setLayoutY(220);
        //progressBar.setProgress(0.8); 80% progressu

        //ProgressIndicator

        ProgressIndicator progressIndicator= new ProgressIndicator();
        //ProgressIndicator progressIndicator= new ProgressIndicator(0.1);
        progressIndicator.setLayoutX(400);
        progressIndicator.setLayoutY(260);
        //progressIndicator.setProgress(0.5);//50%
        //progressIndicator.setProgress(1.0); //100% -done


        //Slider
        Slider slider = new Slider(0, 100, 30);
        slider.setLayoutX(400);
        slider.setLayoutY(320);
        slider.setPrefWidth((300));

        /*slider.setMin(0);
        slider.setMax(100);
        slider.setValue(0);*/

        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(25);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {


                System.out.println("slider: " + newValue.intValue());

               // System.out.println("slider: " + newValue.doubleValue());// 0.1, 0.8 etc


                /* to follow progress:
                double valuePercent = newValue.doubleValue() / 100.0; //podzielic na 100

                progressBar.setProgress(valuePercent);
                progressIndicator.setProgress(valuePercent);*/


                //if progress reaches 100%:

                if(newValue.intValue() == 100) {
                   progressBar.setVisible(false); //hide
                    progressIndicator.setVisible(false);

                }else {

                    progressBar.setVisible(true); //show
                    progressIndicator.setVisible(true);
                    double valuePercent = newValue.doubleValue() / 100.0;
                    progressBar.setProgress(valuePercent);
                    progressIndicator.setProgress(valuePercent);
                }

            }

        });



        //////////////////////////////////////////
        Group group = new Group();
        group.getChildren().add(label);
        group.getChildren().add(imageView);
       // group.getChildren().add(labelWithImage);
        group.getChildren().add(button);
        group.getChildren().add(textField);
        group.getChildren().add(passwordField);
        group.getChildren().add(textArea);
        group.getChildren().add(checkBox);
        group.getChildren().add(radioButton);
        group.getChildren().add(radioButton2);
        group.getChildren().add(choiceBox);
        group.getChildren().add(listView);
        group.getChildren().add(progressBar);
        group.getChildren().add(progressIndicator);
        group.getChildren().add(slider);

        Scene scene = new Scene(group, 800, 600, Color.SLATEGREY);

        primaryStage.setScene((scene));
        primaryStage.setTitle("Aplikacja kontrolki");
        primaryStage.show();
    }


}
