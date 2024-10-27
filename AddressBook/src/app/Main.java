/* CSIS312 - Assignment 4: Address Book Program
 ** By Ben Turner & Jack Skywalker (Baijun Jiang)
 **
 */

package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("AddressBook.fxml"));
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(new Scene(root, 598, 402));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
