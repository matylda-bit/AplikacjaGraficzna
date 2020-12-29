
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AplikacjaGraficzna extends Application {
    public static void main (String[] args) {
        launch(args);}

    @Override
    public void start(Stage primaryStage) {
   // primaryStage.show();


        //Stage => Scene => StackPane=> Text


        //Controls/kontrolki
    Text text = new Text("Text from my first application");
    Button button  = new Button("My first button");
    Text textDrugi = new Text("Another text");

    //StackPane stackPane = new StackPane(); //root
    //    stackPane.getChildren().add(text);

        //scene
        //Scene scene = new Scene(stackPane);

        //root
        //StackPane root = new StackPane();//jedno na drugim
        //HBox root = new HBox(); //horizontal box
        VBox root = new VBox(); //vertical box
        root.getChildren().add(textDrugi);
        root.getChildren().add(button);
        root.getChildren().add(text);

        //scene
        Scene scene = new Scene(root);

            //stage
        primaryStage.setScene(scene);

        primaryStage.setTitle("My application");

        primaryStage.setX(500);
        primaryStage.setY(500);

        primaryStage.setWidth(800);
        primaryStage.setHeight(900);


       // primaryStage.initStyle(StageStyle.DECORATED);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
       // primaryStage.initStyle(StageStyle.UTILITY);
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
       // primaryStage.initStyle(StageStyle.UNIFIED);

        primaryStage.setFullScreen(false);

        primaryStage.show();
    }

}
