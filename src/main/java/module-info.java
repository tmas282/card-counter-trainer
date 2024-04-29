module com.tmas282.cardcountertrainer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.tmas282.cardcountertrainer to javafx.fxml;
    exports com.tmas282.cardcountertrainer;
    exports com.tmas282.cardcountertrainer.cards;
    opens com.tmas282.cardcountertrainer.cards to javafx.fxml;
}