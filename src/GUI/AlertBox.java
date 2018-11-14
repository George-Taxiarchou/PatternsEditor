package GUI;

import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class AlertBox {

    public static void display(String title, String message){
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setOpacity(0.6);
        window.setTitle(title);

        Label label1=new Label(message);
        label1.setWrapText(true);
        label1.setPadding(new Insets(5,10,5,10));
        label1.setId("AlertMessage");
        Button closeButton=new Button("    OK    ");
        closeButton.setId("classic_buttons");
        closeButton.setOnAction(e -> window.close());
        VBox layout=new VBox();
        layout.setSpacing(15);
        layout.setId("AlertBox");
        layout.getChildren().addAll(label1,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene=new Scene(layout,500,100);

        scene.getStylesheets().add("GUI/Minimal.css");
        window.setScene(scene);
        window.showAndWait();
    }

    public static void finishMessage(String msg){
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.setOpacity(0.5);
        HBox layout=new HBox();
        layout.setId("AlertBox");
        layout.setAlignment(Pos.CENTER);
        Label message=new Label(msg);
        message.setId("AlertMessage");

        message.setWrapText(true);


        layout.getChildren().add(message);
        Scene scene=new Scene(layout,250,60);

        //scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add("GUI/Minimal.css");
        window.setScene(scene);
        window.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(1.5));
        delay.setOnFinished( e -> window.close() );
        delay.play();



    }
}