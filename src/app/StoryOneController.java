package app;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StoryOneController implements Initializable {
    private ICrossingStrategy crossingStrategy;


    Farmer farmer1 = new Farmer(10);
    boolean isBoatOnLeftBank;
    int numberOfSails;

    ArrayList<ICrosser> boatRiders = new ArrayList<ICrosser>();
    ArrayList<ICrosser> leftBankCrossers = new ArrayList<ICrosser>();
    ArrayList<ICrosser> rightBankCrossers = new ArrayList<ICrosser>();

    public StoryOneController(/*ICrossingStrategy crossingStrategy,
                              ArrayList<ICrosser> boatRiders, ArrayList<ICrosser> leftBankCrossers,
                              ArrayList<ICrosser> rightBankCrossers*/) {
        crossersOnLeft.add(shalabyGroup);
        crossersOnLeft.add(oshbGroup);
        crossersOnLeft.add(farmerGroup);
        crossersOnLeft.add(chickenGroup);
        boatOnLeft = true;
        isBoatOnLeftBank = true;
        crossingStrategy = new StoryOneCrossingStrategy();
    }
    @FXML
    private ImageView boat;
    @FXML
    private ImageView chicken;
    @FXML
    private ImageView farmer;
    @FXML
    private ImageView shalaby;
    @FXML
    private Group shalabyGroup;
    @FXML
    private Group oshbGroup;
    @FXML
    private Group farmerGroup;
    @FXML
    private Group chickenGroup;
    @FXML
    private Button go;
    @FXML
    private Button reset;
    @FXML
    private Button back;

    private ArrayList<Group> crossersOnBoat = new ArrayList();
    private ArrayList<Group> crossersOnLeft = new ArrayList();
    private ArrayList<Group> crossersOnRight = new ArrayList();

    private boolean boatOnLeft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        crossersOnLeft.add(shalabyGroup);
        crossersOnLeft.add(oshbGroup);
        crossersOnLeft.add(farmerGroup);
        crossersOnLeft.add(chickenGroup);
        boatOnLeft = true;



        Image image1  = SwingFXUtils.toFXImage(farmer1.getImages()[0], null);
        //Image image2 = new Image("/Farmer.png");
        farmer.setImage(image1);

        Farmer fam = new Farmer(10);
        Carnivore mon = new Carnivore(10);
        Herbivore sheep = new Herbivore(10);
        Stage stage = new Stage();
        ImageView imv = new ImageView();
        ImageView imv2 = new ImageView();
        ImageView imv3 = new ImageView();
        /*Image image = SwingFXUtils.toFXImage(fam.getImages()[0], null);
        Image image3 = SwingFXUtils.toFXImage(mon.getImages()[0], null);
        Image image2 = SwingFXUtils.toFXImage(sheep.getImages()[0], null);
        farmer.setImage(image);*/
       // imv2.setImage(image2);
       // imv3.setImage(image3);
    }

    @FXML
    private void farmerClick(){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setNode(farmerGroup);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setNode(farmerGroup);

        if(crossersOnLeft.contains(farmerGroup) && boatOnLeft){
            if(crossersOnBoat.size()<2){
                translateTransition.setByX(180);
                translateTransition.setByY(-20);
                rotateTransition.setByAngle(360);
                translateTransition.play();
                rotateTransition.play();

                crossersOnBoat.add(farmerGroup);
                crossersOnLeft.remove(farmerGroup);
            }
            else
                System.out.println("tb only 2 at a time tb");
        }

        else if (crossersOnBoat.contains(farmerGroup)){
          if(boatOnLeft){
              translateTransition.setByX(-180);
              translateTransition.setByY(20);
              rotateTransition.setByAngle(-360);
              translateTransition.play();
              rotateTransition.play();

              crossersOnBoat.remove(farmerGroup);
              crossersOnLeft.add(farmerGroup);
          }
          else{
              translateTransition.setByX(250);
              translateTransition.setByY(60);
              rotateTransition.setByAngle(360);
              translateTransition.play();
              rotateTransition.play();
              farmer.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
              crossersOnBoat.remove(farmerGroup);
              crossersOnRight.add(farmerGroup);
          }
        }
       else if(crossersOnRight.contains(farmerGroup)){
            if(crossersOnBoat.size()<2){
                translateTransition.setByX(-250);
                translateTransition.setByY(-60);
                translateTransition.play();
                rotateTransition.setByAngle(-360);
                rotateTransition.play();
                farmer.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                crossersOnBoat.add(farmerGroup);
                crossersOnRight.remove(farmerGroup);
            }
        }
        else{
            System.out.println("tb");
        }
    }
    @FXML
    private void oshbClick(){
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setNode(oshbGroup);
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setNode(oshbGroup);

        if(crossersOnLeft.contains(oshbGroup) && boatOnLeft) {
            if(crossersOnBoat.size()<2){
            translateTransition.setByX(200);
            translateTransition.setByY(-5);
            rotateTransition.setByAngle(360);
            translateTransition.play();
            rotateTransition.play();

            crossersOnBoat.add(oshbGroup);
            crossersOnLeft.remove(oshbGroup);
            }
             else
            System.out.println("tb only 2 at a time tb");
        }
        else if(crossersOnBoat.contains(oshbGroup)){
            if(boatOnLeft){
                translateTransition.setByX(-200);
                translateTransition.setByY(5);
                rotateTransition.setByAngle(-360);
                translateTransition.play();
                rotateTransition.play();

                crossersOnBoat.remove(oshbGroup);
                crossersOnLeft.add(oshbGroup);
            }
           else{
                translateTransition.setByX(130);
                translateTransition.setByY(20);
                rotateTransition.setByAngle(360);
                translateTransition.play();
                rotateTransition.play();

                crossersOnBoat.remove(oshbGroup);
                crossersOnRight.add(oshbGroup);
            }
        }
        else if(crossersOnRight.contains(oshbGroup)){
            if(crossersOnBoat.size()<2) {
                translateTransition.setByX(-130);
                translateTransition.setByY(-20);
                rotateTransition.setByAngle(-360);
                translateTransition.play();
                rotateTransition.play();

                crossersOnBoat.add(oshbGroup);
                crossersOnRight.remove(oshbGroup);
            }
             else
            System.out.println("tb only 2 at a time tb");
        }
        else{
            System.out.println("tb");
        }
    }
    @FXML
    private void chickenClick(){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setNode(chickenGroup);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setNode(chickenGroup);
        if(crossersOnLeft.contains(chickenGroup) && boatOnLeft){
            if(crossersOnBoat.size()<2) {
                translateTransition.setByX(80);
                translateTransition.setByY(20);
                rotateTransition.setByAngle(360);
                translateTransition.play();
                rotateTransition.play();

                crossersOnBoat.add(chickenGroup);
                crossersOnLeft.remove(chickenGroup);
            }
             else
            System.out.println("tb only 2 at a time tb");
        }
        else if(crossersOnBoat.contains(chickenGroup)){
            if(boatOnLeft){
                translateTransition.setByX(-90);
                translateTransition.setByY(-20);
                rotateTransition.setByAngle(-360);
                translateTransition.play();
                rotateTransition.play();

                crossersOnBoat.remove(chickenGroup);
                crossersOnLeft.add(chickenGroup);
            }
            else{
                translateTransition.setByX(150);
                translateTransition.setByY(-30);
                rotateTransition.setByAngle(360);
                translateTransition.play();
                rotateTransition.play();
                chicken.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                crossersOnBoat.remove(chickenGroup);
                crossersOnRight.add(chickenGroup);
            }
        }
        else if(crossersOnRight.contains(chickenGroup) && !boatOnLeft){
            if(crossersOnBoat.size()<2) {
                translateTransition.setByX(-150);
                translateTransition.setByY(30);
                rotateTransition.setByAngle(-360);
                translateTransition.play();
                rotateTransition.play();
                chicken.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                crossersOnBoat.add(chickenGroup);
                crossersOnRight.remove(chickenGroup);
            }
             else
            System.out.println("tb only 2 at a time tb");
        }
        else{
            System.out.println("tb");
        }
    }
    @FXML
    private void shalabyClick(){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.seconds(1));
        translateTransition.setNode(shalabyGroup);
        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setNode(shalabyGroup);

        if(crossersOnLeft.contains(shalabyGroup) && boatOnLeft){
            if(crossersOnBoat.size()<2) {
                translateTransition.setByX(20);
                translateTransition.setByY(15);
                rotateTransition.setByAngle(360);
                translateTransition.play();
                rotateTransition.play();
                crossersOnBoat.add(shalabyGroup);
                crossersOnLeft.remove(shalabyGroup);
            }
             else
            System.out.println("tb only 2 at a time tb");
        }
        else if(crossersOnBoat.contains(shalabyGroup)){
            if(boatOnLeft){
                translateTransition.setByX(-20);
                translateTransition.setByY(-15);
                rotateTransition.setByAngle(-360);
                translateTransition.play();
                rotateTransition.play();

                crossersOnBoat.remove(shalabyGroup);
                crossersOnLeft.add(shalabyGroup);
            }
            else{
                translateTransition.setByX(60);
                translateTransition.setByY(-30);
                rotateTransition.setByAngle(360);
                translateTransition.play();
                rotateTransition.play();
                shalaby.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                crossersOnBoat.remove(shalabyGroup);
                crossersOnRight.add(shalabyGroup);
            }
        }
        else if(crossersOnRight.contains(shalabyGroup)){
            if(crossersOnBoat.size()<2) {
                translateTransition.setByX(-60);
                translateTransition.setByY(30);
                rotateTransition.setByAngle(-360);
                translateTransition.play();
                rotateTransition.play();
                shalaby.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                crossersOnBoat.add(shalabyGroup);
                crossersOnRight.remove(shalabyGroup);
            }
             else
            System.out.println("tb only 2 at a time tb");
        }
        else{
            System.out.println("tb");
        }
    }
     @FXML
    private void goAction(){
        if(crossersOnBoat.contains(farmerGroup)){
            TranslateTransition translateTransition = new TranslateTransition();
            translateTransition.setDuration(Duration.seconds(1));
            translateTransition.setNode(boat);

            if(boatOnLeft){
                translateTransition.setByX(200);
                translateTransition.play();
                for(int i= 0; i<crossersOnBoat.size(); i++){
                    TranslateTransition translateTransition1 = new TranslateTransition();
                    translateTransition1.setDuration(Duration.seconds(1));
                    translateTransition1.setNode(crossersOnBoat.get(i));
                    translateTransition1.setByX(200);
                    translateTransition1.play();
                }
                boatOnLeft = false;
            }
            else if(!boatOnLeft){
                translateTransition.setByX(-200);
                translateTransition.play();
                for(int i= 0; i<crossersOnBoat.size(); i++){
                    TranslateTransition translateTransition1 = new TranslateTransition();
                    translateTransition1.setDuration(Duration.seconds(1));
                    translateTransition1.setNode(crossersOnBoat.get(i));
                    translateTransition1.setByX(-200);
                    translateTransition1.play();
                }
                boatOnLeft = true;
            }
        }
         else{
            System.out.println("farmer must be on the boat");
        }
    }
   @FXML
    private void resetAction(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("Story1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
   @FXML
    private void backAction(ActionEvent event) throws IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("NewGame.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }
    public void newGame(ICrossingStrategy gameStrategy) {
        crossingStrategy = gameStrategy;
        leftBankCrossers = (ArrayList<ICrosser>) gameStrategy.getInitialCrossers();
    }

    /*@Override
    public void resetGame() {
        numberOfSails = 0;
        rightBankCrossers.clear();
        boatRiders.clear();
        leftBankCrossers = (ArrayList<ICrosser>) crossingStrategy.getInitialCrossers();
    }

    @Override
    public String[] getInstructions() {

        return crossingStrategy.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightBankCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return leftBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return isBoatOnLeftBank;
    }

    @Override
    public int getNumberOfSails() {
        return numberOfSails;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

        if(fromLeftToRightBank) {
            for(ICrosser x : crossers) {
                leftBankCrossers.remove(x);
            }
        }
        else {
            for(ICrosser x : crossers) {
                rightBankCrossers.remove(x);
            }
        }
        for(ICrosser x : crossers) {
            boatRiders.add(x);
        }

        if(!crossingStrategy.isValid(rightBankCrossers, leftBankCrossers, boatRiders)) {
            if(fromLeftToRightBank) {
                for(ICrosser x : crossers) {
                    leftBankCrossers.add(x);
                }
            }
            else {
                for(ICrosser x : crossers) {
                    rightBankCrossers.add(x);
                }
            }
            for(ICrosser x : crossers) {
                boatRiders.remove(x);
            }
            return false;
        }
        else return true;
    }

    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        for(ICrosser x : crossers) {
            if(fromLeftToRightBank) {
                rightBankCrossers.add(x);
            }
            else leftBankCrossers.add(x);
        }
        numberOfSails++;
    }

    public boolean canUndo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canRedo() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public void loadGame() {
        // TODO Auto-generated method stub
    }

    @Override
    public List<List<ICrosser>> solveGame() {
        // TODO Auto-generated method stub
        return null;
    }

    public ICrossingStrategy getCrossingStrategy() {
        return crossingStrategy;
    }

    public void setCrossingStrategy(ICrossingStrategy crossingStrategy) {
        this.crossingStrategy = crossingStrategy;
    }*/
}