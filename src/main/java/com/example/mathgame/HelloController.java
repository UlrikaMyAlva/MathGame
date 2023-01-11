package com.example.mathgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public TextField answer;

    public int svar;
    public Label answerLabel;
    public Label pointsLabel;
    public Label levelLabel;

    public Image image;
    public ImageView imageView;
    @FXML
    private Label equation;

    @FXML
    private MathProblems math;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       math = new MathProblems();
       image = new Image("C:\\Users\\Ulrik\\IdeaProjects\\MathGame\\src\\main\\java\\com\\example\\mathgame\\images\\Egg1.png");
       imageView.setImage(image);
    }

    @FXML
    protected void onPlayButtonClick() {

        answer.clear();

        int choice = math.returnRandomChoice();

        int a, b, c, d, e;

        switch (choice) {
            case 1:
                a = math.returnRandomOneDigit();
                b = math.returnRandomOneDigit();

                svar = a + b;

                equation.setText(a + " + " + b);
                break;

            case 2:
                a = math.returnRandomOneDigit();
                b = math.returnRandomOneDigit();

                if (a < b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                svar = a - b;

                equation.setText(a + " - " + b);
                break;

            default:
                System.out.println("No proper choice.");
                break;
        }



    }

    @FXML
    protected void onEnterClick(ActionEvent e) throws InterruptedException {
        int calculation = Integer.parseInt(answer.getText());

        if (svar == calculation) {
            answerLabel.setText("Right answer! +1 point!");
            math.addPoints();
        }
        else {
            answerLabel.setText("Wrong answer! -1 point! (Right answer was " + svar + ").");
            math.losePoints();
        }

        changePointsLabel();
        //Thread.sleep(2000);
        onPlayButtonClick();
    }

    @FXML
    protected void changePointsLabel() {
        pointsLabel.setText(String.valueOf("Points: " + math.getPoints()));
        levelLabel.setText(String.valueOf("Level: " + math.getLevel()));
        changeEgg();
    }

    @FXML
    protected void changeEgg() {
        if (math.getPoints() <= 5) {
            image = new Image("C:\\Users\\Ulrik\\IdeaProjects\\MathGame\\src\\main\\java\\com\\example\\mathgame\\images\\Egg1.png");
            imageView.setImage(image);
        }
        if (math.getPoints() > 5 && math.getPoints() <=10) {
            image = new Image("C:\\Users\\Ulrik\\IdeaProjects\\MathGame\\src\\main\\java\\com\\example\\mathgame\\images\\Egg2.png");
            imageView.setImage(image);
        }
        if (math.getPoints() > 10 && math.getPoints() <=20) {
            image = new Image("C:\\Users\\Ulrik\\IdeaProjects\\MathGame\\src\\main\\java\\com\\example\\mathgame\\images\\Egg3.png");
            imageView.setImage(image);
        }
        if (math.getPoints() > 20 && math.getPoints() <=28) {
            image = new Image("C:\\Users\\Ulrik\\IdeaProjects\\MathGame\\src\\main\\java\\com\\example\\mathgame\\images\\Egg4.png");
            imageView.setImage(image);
        }
        if (math.getPoints() > 28 && math.getPoints() <=35) {
            image = new Image("C:\\Users\\Ulrik\\IdeaProjects\\MathGame\\src\\main\\java\\com\\example\\mathgame\\images\\Egg5.png");
            imageView.setImage(image);
        }
        if (math.getPoints() > 35) {
            image = new Image("C:\\Users\\Ulrik\\IdeaProjects\\MathGame\\src\\main\\java\\com\\example\\mathgame\\images\\Monster.png");
            imageView.setImage(image);
        }
    }
}