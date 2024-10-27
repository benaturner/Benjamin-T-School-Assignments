package analyzer;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Benjamin Turner and Jack Skywalker
 * - I have not discussed the source code in my program with anyone other than my instructor’s approved human sources (i.e. programming partner).
 *
 * - I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
 *
 * - If any source code or documentation used in my program was obtained from another source, such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
 *
 * - I have not knowingly designed this program in such a way as to defeat or interfere with the normal operation of any machine it is graded on or to produce apparently correct results when in fact it does not.
 */
public class Analyzer extends Application
{
    TextArea ta;        // for text to be analyzed
    TextArea results;   // for displaying stats
    Button stats;       // button for calculating stats
    Button open;        // button for opening text file
    GridPane gp;        // layout manager
    Stage stage;        // display

    /**
     * Event Handler for Statistics Calculation
     */
    EventHandler<ActionEvent> statsEvent = new EventHandler<ActionEvent>()
    {
        public void handle(ActionEvent evt)
        {
            String data = ta.getText();
            int words = TextAnalysis.getWordCount(data);
            int syllables = TextAnalysis.getSyllableCount(data, false);
            int sentences = TextAnalysis.getSentenceCount(data);
            String out = "Words: " + words + "\n"
                + "Syllables: " + syllables + "\n"
                + "Average Syllables: " + TextAnalysis.getAverageSyllables(data)
                + "\nSentences: " + sentences + "\n"
                + "Average Sentence Length: "
                + TextAnalysis.getAverageSentenceLength(data) + "\n"
                + "Flesch Reading Ease: "
                + TextAnalysis.getReadingEaseText(words, sentences, syllables)
                + "\n" + "Gunning Fog Index: " + TextAnalysis.gunningDescription(data)
                + "\n";
            results.setText(out);
        }
    };

    /**
     * Event Handler for Open Button
     */
    EventHandler<ActionEvent> openEvent = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent evt)
        {
            // create a file chooser for the user to select a file
            JFileChooser chooser = new JFileChooser();
            // filter the file chooser to only handle txt files
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Text files", "txt");
            chooser.setFileFilter(filter);
            // creates a jframe to open the dialog
            JFrame parent = new JFrame();
            // opens a file chooser dialog and sets returnVal to the chosen file
            int returnVal = chooser.showOpenDialog(parent);
            // checks if the user made a valid choice
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                try {
                    // creates a file variable for the selected file
                    File selectedFile = chooser.getSelectedFile();
                    // creates a list of string from all the lines in the txt file
                    List<String> lines = Files.readAllLines(Paths.get(selectedFile.getAbsolutePath()));
                    // creates a stringBuilder
                    StringBuilder stringBuilder = new StringBuilder();
                    // appends each line in the list to the stringBuilder
                    for (String line : lines) {
                        stringBuilder.append(line).append(" ");
                    }
                    // assigns the stringBuilder to a fileContent variable
                    String fileContent = stringBuilder.toString();
                    // output the file content to the ui
                    ta.setText(fileContent);
                    // output the file content to the console
                    System.out.println("File content: \n" + fileContent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        String buttonStyle = "-fx-background-radius: 5em; "
            + "-fx-min-width: 60px; "
            + "-fx-min-height: 60px; "
            + "-fx-max-width: 60px; "
            + "-fx-max-height: 60px;"
            + "-fx-font-weight: bold;";

        this.stage = primaryStage;
        primaryStage.setTitle("LU Text Analyzer");
        gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);
        gp.setPadding(new Insets(5, 5, 5, 5));
        ta = new TextArea();
        ta.setPrefWidth(800);
        ta.setWrapText(true);
        results = new TextArea();
        results.setPrefWidth(800);
        stats = new Button();
        stats.setPadding(new Insets(10, 10, 10, 10));
        stats.setText("Stats");
        stats.setTextFill(Color.RED);
        stats.setOnAction(statsEvent);
        stats.setShape(new Circle(30));
        stats.setStyle(buttonStyle);

        open = new Button();
        open.setText("Open");
        open.setTextFill(Color.GREEN);
        open.setOnAction(openEvent);
        open.setPadding(new Insets(10, 10, 10, 10));
        open.setShape(new Circle(30));
        open.setStyle(buttonStyle);
        gp.add(ta, 0, 0, 2, 1);
        gp.add(results, 0, 1, 2, 1);
        gp.add(stats, 0, 2, 1, 1);
        gp.add(open, 1, 2, 1, 1);

        RowConstraints rc = new RowConstraints();
        rc.setPercentHeight(65);
        gp.getRowConstraints().add(rc);

        rc = new RowConstraints();
        rc.setPercentHeight(25);
        gp.getRowConstraints().add(rc);

        rc = new RowConstraints();
        rc.setPercentHeight(10);
        gp.getRowConstraints().add(rc);

        double w = 800;
        double h = 600;

        primaryStage.setResizable(false);
        Scene scene = new Scene(gp, w, h);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // OS Entry Point
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
