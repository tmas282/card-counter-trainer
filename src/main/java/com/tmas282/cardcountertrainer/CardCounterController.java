package com.tmas282.cardcountertrainer;

import com.tmas282.cardcountertrainer.cards.Card;
import com.tmas282.cardcountertrainer.cards.Dealer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class CardCounterController {
    private static final int START_TIME = 0;
    private Timeline timeline;
    private final DoubleProperty timeSeconds = new SimpleDoubleProperty(START_TIME);
    private Dealer dealer;

    @FXML
    private ImageView imgCard;
    @FXML
    private Spinner<Integer> spinnerBpm;
    @FXML
    private Button btnMain;

    @FXML
    private void onClickBtn() throws FileNotFoundException {
        btnMain.setText("Restart!");
        startTimer();
        dealer = new Dealer();
    }

    public void startTimer() {
        btnMain.setDisable(true); // prevent starting multiple times
        timeline = new Timeline(new KeyFrame(Duration.seconds(calculateTimerPeriod()), evt -> {
            try {
                updateTimer();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE); // repeat over and over again
        timeSeconds.set(START_TIME);
        timeline.play();
    }
    private void updateTimer() throws FileNotFoundException {
        double seconds = timeSeconds.get();
        timeSeconds.set(seconds+calculateTimerPeriod());
        if(dealer.checkIfDeckIsOver()){
            btnMain.setDisable(false);
            timeline.stop();
        }
        else {
            Card card = dealer.getACard();
            imgCard.setImage(card.getImg());
        }
    }
    private double calculateTimerPeriod(){
        double bpm = (double) spinnerBpm.getValue();
        return 60.0/bpm;
    }
}