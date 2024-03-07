module com.github.accieterr.tictactoeFX {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.github.accieterr.tictactoeFX to javafx.fxml;
    exports com.github.accieterr.tictactoeFX;
}
