import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.w3c.dom.Text;


public class UkladWidoku extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    //layout

        //HBox (horizontal box)
        Button menuButton = new Button("Menu");
        Button contactButton = new Button("Contact");
        Button orderButton = new Button ("Order");

        HBox hbox = new HBox();
       /* hbox.getChildren().add(menuButton);
        hbox.getChildren().add(contactButton);
        hbox.getChildren().add(orderButton);*/
        hbox.getChildren().addAll(contactButton, menuButton, orderButton);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10,5,10,5));
        hbox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        //VBox/vertical box
        ImageView pizzaImageView = new ImageView(new Image("obrazki/ikony/pizza.png"));
        Label pizzaLabel = new Label("Pizza", pizzaImageView);

        ImageView hamburgerImageView = new ImageView(new Image("obrazki/ikony/hamburger.png"));
        Label hamburgerLabel = new Label("Hamburger", hamburgerImageView);

        ImageView drinksImageView = new ImageView (new Image("obrazki/ikony/napoje.png"));
        Label drinksLabel = new Label("Drinks", drinksImageView);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(pizzaLabel, hamburgerLabel, drinksLabel);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        //StackPane
        ImageView pizzaDuzaImageView = new ImageView(new Image("obrazki/pizza/pizza-cztery-sery-duza.png"));
        Label opisLabel = new Label("Pizza quattro formaggio - mozzarella, ricotta, feta, edamski");
        opisLabel.setTextFill(Color.WHITE);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(pizzaDuzaImageView, opisLabel);
        stackPane.setAlignment(Pos.CENTER);
        stackPane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));


        //FlowPane
        ImageView pizzaCzterySeryImageView = new ImageView(new Image("obrazki/pizza/pizza-cztery-sery.png"));
        ImageView pizzaFunghiImageView = new ImageView(new Image("obrazki/pizza/pizza-funghi.png"));
        ImageView pizzaMargarittaImageView = new ImageView(new Image("obrazki/pizza/pizza-margaritta.png"));
        ImageView pizzaMexicanaImageView = new ImageView(new Image("obrazki/pizza/pizza-mexicana.png"));
        ImageView pizzaPepperoniImageView = new ImageView(new Image("obrazki/pizza/pizza-pepperoni.png"));
        ImageView pizzaSalamiImageView = new ImageView(new Image("obrazki/pizza/pizza-salami.png"));

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().addAll(
                pizzaCzterySeryImageView,
                pizzaFunghiImageView,
                pizzaMargarittaImageView,
                pizzaMexicanaImageView,
                pizzaPepperoniImageView,
                pizzaSalamiImageView
        );

            flowPane.setOrientation(Orientation.HORIZONTAL);
            flowPane.setMaxWidth(150);
            flowPane.setHgap(5);//horizontally
            flowPane.setVgap(10);//vertically
            flowPane.setPadding(new Insets(3));


            //GridPane
        Button minusButton = new Button("-");
        minusButton.setPrefSize(30,30);
        Button plusButton = new Button("+");
        plusButton.setPrefSize(30, 30);
        Label iloscLabel = new Label("1");
        iloscLabel.setPadding(new Insets(0,10,0,10));

        Button okButton =new Button("OK");
        Button cancelButton = new Button("Cancel");

        Pane pane = new Pane();//pusty obszar
        pane.setPrefWidth(50);

        GridPane gridPane = new GridPane();
        gridPane.add(minusButton, 0,0);//1 kolumna, 1 wiersz
        gridPane.add(iloscLabel, 1, 0);//2 kolumna, 1 wiersz
        gridPane.add(plusButton, 2,0);//3 kolumna, 1 wiersz
        gridPane.add(pane, 3, 1);//4 kolumna, 2 wiersz
        gridPane.add(okButton, 4, 1);//5 kolumna, 2 wiersz
        gridPane.add(cancelButton, 5, 1);//6 kolumna, 2 wiersz


        //ScrollPane
        for(int i =0; i<10; i++) {
            ImageView kopiaPizzaImageView = new ImageView(new Image("obrazki/pizza/pizza-cztery-sery.png"));
            flowPane.getChildren().add(kopiaPizzaImageView);
        }

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(flowPane);
        scrollPane.setMaxWidth(150);

        //BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setLeft(vbox);
        borderPane.setCenter(stackPane);
        //borderPane.setRight(flowPane);
        borderPane.setRight(scrollPane);
        borderPane.setBottom(gridPane);

        /*
        TextField textFieldTop = new TextField("top");
        borderPane.setTop(textFieldTop);

        TextField textFieldBottom = new TextField("bottom");
        borderPane.setBottom(textFieldBottom);

        TextField textFieldMiddle = new TextField("middle");
        borderPane.setCenter(textFieldMiddle);

        TextField textFieldLeft = new TextField("left");
        borderPane.setLeft(textFieldLeft);

        TextField textFieldRight = new TextField("right");
        borderPane.setRight(textFieldRight);*/


        Scene scene = new Scene(borderPane, 800, 680);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Uklad elementow widoku");
        primaryStage.show();
    }
}
