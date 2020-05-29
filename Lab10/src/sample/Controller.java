package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller {
    @FXML
    private TextFlow text;

    @FXML
    private Spinner<Integer> num;

    private SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 9);

    @FXML
    void initialize() {
        valueFactory.setValue(9);

        num.setValueFactory(valueFactory);

        num.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    text.getChildren().clear();
                    text.getChildren().add(generateText(newValue));
                });

        text.getChildren().add(generateText(num.getValue()));
    }

    Text generateText(Integer number) {
        StringBuilder string = new StringBuilder();

        while(number >= 1){
            for(int j = 1; j <= number; j++) {
                string.append(5);
            }
            number = number - 2;
            string.append("\n");
        }
        return new Text(string.toString());
    }
}