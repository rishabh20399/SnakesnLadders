package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Main extends Application {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Alert confirmation= new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Snakes & Ladders");
            confirmation.setHeaderText("Confirm the type of game ");

            Stage box = (Stage) confirmation.getDialogPane().getScene().getWindow();
            box.getIcons().add(new Image("E:\\AP\\AP_Ass5\\src\\img.png"));
            ImageView icon = new ImageView(new Image("E:\\AP\\AP_Ass5\\src\\Snakes_and_Ladders.jpeg"));
            icon.setFitWidth(300);
            icon.setFitHeight(150);
            confirmation.setGraphic(icon);
            box.setOnCloseRequest(c -> {
                    Platform.exit();
            });


            Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        stage.setTitle("Hello World");
//        stage.setScene(new Scene(root, 300, 275));
//        Group root = new Group();
            Scene scene = new Scene(root1, Color.DARKGOLDENROD);
            stage.setTitle("Snakes & Ladders");
            Image identity = new Image("E:\\AP\\AP_Ass5\\src\\img.png");

            stage.getIcons().add(identity);
            stage.setScene(scene);
            stage.show();

            ButtonType playWithAFriend = new ButtonType("Play with a Friend");
            confirmation.getButtonTypes().setAll(playWithAFriend);

            try {
                Optional<ButtonType> confirm = confirmation.showAndWait();
                if (confirm.get() == playWithAFriend){
                    stage = playWithFriendStage();
                    stage.show();
                }
            } catch (Exception e){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Stage playWithFriendStage() throws Exception {
        Stage dualPlayerStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        dualPlayerStage.setScene(scene);
        dualPlayerStage.setTitle("Snakes and Ladder : Play with a Friend");
        dualPlayerStage.setResizable(false);
        dualPlayerStage.getIcons().add(new Image(""));
        return dualPlayerStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}


