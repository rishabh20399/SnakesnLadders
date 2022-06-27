package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Arc;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

//import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

public class Controller {
    @FXML
    private Scene scene;
    private Stage stage;
    private Parent root;
    private SecureRandom rand;
    private int blueNow = 0;
    private int redNow = 0;
    private int bluePrev,redPrev,number;
    private double coordinateX,coordinateY;
    private int count = 0;
    private boolean blueVisible = false;
    private boolean redVisible = false;

    Random random= new Random();

    @FXML
    private ImageView diceFace;
    @FXML
    private ImageView blue;
    @FXML
    private ImageView red;
   // @FXML
   // private ImageView diceRoll;
    @FXML
    private Button rollDice;
    @FXML
    void roll(ActionEvent event) {
//        red.setVisible(false);
//        blue.setVisible(false);
        rollDice.setDisable(true);
        System.out.println("1");

        Thread thread = new Thread(() -> {
            System.out.println("Thread Running");
            try {
                for (int i = 0; i < 15; i++){
                    int x = random.nextInt(6)+1;
                    File file = new File("E:\\AP\\AP_Ass5\\src\\Dices\\Dice" + x +".jpg");
                    diceFace.setImage(new Image(file.toURI().toString()));
                    Thread.sleep(100);
                    number=x;
                    System.out.println("2");
                }
                rollDice.setDisable(false);
//                count+=1;
                System.out.println("4");
                move(event);

            }catch (InterruptedException e){
            }
            System.out.println("3");
        });
        thread.start();
//        handleButton(count);
    }

    public void default_move(int now, int prev, ImageView token){
        System.out.println("7");
        if(blueNow==1 || redNow==1){
            token.setVisible(blueVisible);
            token.setX(-34.0);
            coordinateX=-34.0;
            token.setY(434.0);
            coordinateY=377.0;
        }

        for(int i = 0; i <= now-prev; i++){
            if(now>=1 && now<=10 || now>=21 && now<=30 || now>=41 && now<=50 || now>=61 && now<=70 || now>=81 && now<=90) {
                coordinateX += 30;
                token.setX(coordinateX);
            }
            else if(now>=11 && now<=20 || now>=31 && now<=40 || now>=51 && now<=60 || now>=71 && now<=80 ||  now>=91 && now<=100){
                coordinateX -= 30;
                token.setX(coordinateX);
            }
            if(now%10==1) {
                coordinateY += 43;
                token.setY(coordinateY);
            }
            try{
                Thread.sleep(200);
            } catch (InterruptedException interruptedException) {
            }
        }
    }

    @FXML
    public void move(ActionEvent e){
        count+=1;
        if(count%2==0) {
            System.out.println("5");
            if ((number == 1 && blueNow==0) || (blueNow!=0)) {
//                default_move(blueNow,bluePrev);
//                blueVisible = true;
//                blue.setVisible(blueVisible);
//                blue.setX(-4.0);
//                coordinateX=-4.0;
//                blue.setY(377.0);
//                coordinateY=377.0;

                if (blueVisible == true && blueNow > 100) {
                    blueNow = bluePrev;
                    return;
                }
                bluePrev=blueNow;
                blueNow+=number;
                switch (blueNow) {
                    default:
                        default_move(blueNow, bluePrev, blue);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;

                    case 4:            //ladder
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 4);
                        blue.setY(377 + 2 * 43);
                        blueNow = 25;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 8:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 9);
                        blue.setY(377 + 3 * 43);
                        blueNow = 31;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 28:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 5);
                        blue.setY(377 + 43 * 4);
                        blueNow = 46;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 21:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4);
                        blue.setY(377 + 43 * 2);
                        blueNow = 60;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 32:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 7);
                        blue.setY(377 + 43 * 4);
                        blueNow = 48;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 42:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4);
                        blue.setY(377 + 43 * 7);
                        blueNow = 80;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 58:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 3);
                        blue.setY(377 + 43 * 7);
                        blueNow = 77;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 69:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 8);
                        blue.setY(377 + 43 * 6);
                        blueNow = 93;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 84:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 2);
                        blue.setY(377 + 43 * 9);
                        blueNow = 98;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 11:        //snake
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 8);
                        blue.setY(377);
                        blueNow = 9;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 36:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 6);
                        blue.setY(377 + 43);
                        blueNow = 14;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 43:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30);
                        blue.setY(377 + 43 * 2);
                        blueNow = 22;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 56:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 2);
                        blue.setY(377 + 43);
                        blueNow = 18;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 75:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 6);
                        blue.setY(377 + 43 * 5);
                        blueNow = 54;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 81:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 2);
                        blue.setY(377 + 43 * 6);
                        blueNow = 63;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 90:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 9);
                        blue.setY(377 + 43 * 4);
                        blueNow = 50;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 94:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 7);
                        blue.setY(377 + 43 * 5);
                        blueNow = 53;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 96:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 4);
                        blue.setY(377 + 43 * 6);
                        blueNow = 65;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 99:
                        default_move(blueNow, bluePrev, blue);
                        blue.setX(-4 + 30 * 2);
                        blue.setY(377 + 43 * 7);
                        blueNow = 78;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                }
            }
        }

        else{
            System.out.println("6");
            if ((number == 1 && redNow==0) || (redNow!=0)) {
//                redVisible = true;
//                red.setVisible(redVisible);
//                red.setX(-4.0);
//                coordinateX=-4.0;
//                red.setY(377.0);
//                coordinateY=377.0;
//                redNow = 1;

                if (redVisible == true && redNow > 100) {
                    redNow = redPrev;
                    return;
                }
                redPrev=redNow;
                redNow+=number;
                switch (redNow) {
                    default:
                        default_move(redNow, redPrev, red);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 4:            //ladder
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 4);
                        red.setY(377 + 2 * 43);
                        redNow = 25;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 8:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 9);
                        red.setY(377 + 3 * 43);
                        redNow = 31;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 28:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 5);
                        red.setY(377 + 43 * 4);
                        redNow = 46;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 21:
                        default_move(redNow, redPrev, red);
                        red.setX(-4);
                        red.setY(377 + 43 * 2);
                        redNow = 60;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 32:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 7);
                        red.setY(377 + 43 * 4);
                        redNow = 48;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 42:
                        default_move(redNow, redPrev, red);
                        red.setX(-4);
                        red.setY(377 + 43 * 7);
                        redNow = 80;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 58:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 3);
                        red.setY(377 + 43 * 7);
                        redNow = 77;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 69:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 8);
                        red.setY(377 + 43 * 6);
                        redNow = 93;
                        try {
                            Thread.sleep(200);
                        }
                        catch (InterruptedException ex) {
                        }
                        break;
                    case 84:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 2);
                        red.setY(377 + 43 * 9);
                        redNow = 98;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 11:        //snake
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 8);
                        red.setY(377);
                        redNow = 9;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 36:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 6);
                        red.setY(377 + 43);
                        redNow = 14;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 43:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30);
                        red.setY(377 + 43 * 2);
                        redNow = 22;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 56:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 2);
                        red.setY(377 + 43);
                        redNow = 18;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 75:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 6);
                        red.setY(377 + 43 * 5);
                        redNow = 54;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 81:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 2);
                        red.setY(377 + 43 * 6);
                        redNow = 63;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;

                    case 90:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 9);
                        red.setY(377 + 43 * 4);
                        redNow = 50;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 94:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 7);
                        red.setY(377 + 43 * 5);
                        redNow = 53;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 96:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 4);
                        red.setY(377 + 43 * 6);
                        redNow = 65;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                    case 99:
                        default_move(redNow, redPrev, red);
                        red.setX(-4 + 30 * 2);
                        red.setY(377 + 43 * 7);
                        redNow = 78;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException ex) {
                        }
                        break;
                }
            }

        }
//        System.out.println("UP");
    }

//    private void msg(final String str){
//        Platform.runLater(()-> {
//            Alert declareWinner = new Alert(Alert.AlertType.INFORMATION);
//            Stage box = (Stage) declareWinner.getDialogPane().getScene().getWindow();
//            box.getIcons().add(new Image("E:\\AP\\AP_Ass5\\src\\img.png"));
//            ImageView icon = new ImageView(new Image("E:\\AP\\AP_Ass5\\src\\fireWorks.gif"));
//            icon.setFitHeight(100);
//            icon.setFitWidth(200);
//            declareWinner.setGraphic(icon);
//            declareWinner.setHeaderText("CONGRATULATIONS...!!");
//            declareWinner.setContentText(str);
//            declareWinner.showAndWait();
//
//        });
//    }

//    public void showBoard(ActionEvent event)  throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        stage= (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    @FXML
//    private void handleTokens(ImageView token){
//        count +=1;
//        new Thread(){
//            public void go(){
//                number = 1 + rand.nextInt(6);
//                diceRoll.setVisible(true);
//                try {
//                    Thread.sleep(500);
//                }catch (InterruptedException ex) {
//                }
//                diceRoll.setVisible(false);
//                diceFace.setImage(new Image("E:\\AP\\AP_Ass5\\src\\Dices\\Dice" + number +".jpg"));
//
//            }
//        }.start();
//        handleButton();
////        return count;
//    }
//
//    @FXML
//    private void handleButton(){
//        if (count%2==0){
//            handleTokens(blue);
//        }
//        else {
//            handleTokens(red);
//        }
//    }
}