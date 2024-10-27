

package app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Instance Variables
    PdfMaker pdfMaker;

    @FXML
    private TextArea txtBoxContent;

    @FXML
    private Button generateButton;

    @FXML
    private TextField txtFileName;

    @FXML
    private Button btnClear;

    @FXML
    void evtClearButton(ActionEvent event) {
        txtBoxContent.clear();
    }

    @FXML
    void evtGeneratePdf(ActionEvent event) {
        pdfMaker.createPdf(txtFileName.getText(), txtBoxContent.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pdfMaker = new PdfMaker();
    }
}
