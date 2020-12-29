import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class KontrolkiZadanie extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label infoLabel = new Label("Progress Bar");
        Label finishedLabel = new Label ("Finished");
        Button startButton = new Button("Start");
        Button restartButton = new Button("Restart");
        ProgressBar progressBar = new ProgressBar();

        infoLabel.setLayoutY(10);
        progressBar.setLayoutY(30);
        finishedLabel.setLayoutY(50);
        startButton.setLayoutY(70);
        restartButton.setLayoutY(70);
        restartButton.setLayoutX(50);


        finishedLabel.setVisible(false);
        restartButton.setDisable(true);

        Runnable runnable = (new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<=100; i++){
                    double progressValue = 0.01 * i;

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run () {
                            progressBar.setProgress(progressValue);
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        finishedLabel.setVisible(true);
                        restartButton.setDisable(false);
                    }
                });

            }

        });
                startButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        startButton.setDisable(true);
                        new Thread(runnable).start();


                    }
                });



                restartButton.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        progressBar.setProgress(0);
                        finishedLabel.setVisible(false);
                        startButton.setDisable(false);
                        restartButton.setDisable(true);
                    }
                                          }
                        );
        Group group = new Group();
        group.getChildren().add(infoLabel);
        group.getChildren().add(finishedLabel);
        group.getChildren().add(startButton);
        group.getChildren().add(restartButton);
        group.getChildren().add(progressBar);

        Scene scene = new Scene(group, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Kontrolki zadanie");
        primaryStage.setX(2500);
        primaryStage.setY(300);

        primaryStage.show();
    }
}
