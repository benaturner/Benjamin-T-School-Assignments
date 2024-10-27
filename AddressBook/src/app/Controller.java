/* CSIS312 - Assignment 4: Address Book Program
 ** By Ben Turner & Jack Skywalker (Baijun Jiang)
 ** Resources:
 ** https://www.youtube.com/watch?v=FeTrcNBVWtg
 ** https://www.youtube.com/watch?v=A5fQbsJ-iF8
 ** https://www.youtube.com/watch?v=qmY0pbFFH_Y
 ** https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html
 ** https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableColumn.html
 ** https://stackoverflow.com/questions/34857007/how-to-delete-row-from-table-column-javafx
 */

package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;


public class Controller implements Initializable {

    // Output File
    ObjectOutputStream output;

    {
        try {
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("contacts.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Implement ObservableArrayList
    ObservableList<AddressBook>dataModel = FXCollections.observableArrayList();

    public Controller() throws FileNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Link column to AddressBook class
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<AddressBook, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<AddressBook, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<AddressBook, String>("birthday"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<AddressBook, String>("address"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<AddressBook, String>("city"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<AddressBook, String>("state"));
        zipColumn.setCellValueFactory(new PropertyValueFactory<AddressBook, Integer>("zip"));

        // Link table data
        addressBookTable.setItems(dataModel);
    }


    // Action Elements

    @FXML
    void clearEntry(ActionEvent event) {
        // Clear all input field data
        firstNameInputField.clear();
        lastNameInputField.clear();
        birthdayInputField.clear();
        addressInputField.clear();
        cityInputField.clear();
        stateInputField.clear();
        zipInputField.clear();
    }

    @FXML
    void deleteEntry(ActionEvent event) throws IOException {
        // Delete selected item from table
        addressBookTable.setItems(dataModel);
        AddressBook selectedItem = addressBookTable.getSelectionModel().getSelectedItem();

        File tempFile = new File("tempFile.txt");
        BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while((currentLine = reader.readLine()) != null) {
            if(currentLine.contains(selectedItem.getFirstName() + " " +
                    selectedItem.getLastName() + " " +
                    selectedItem.getBirthday() + " " +
                    selectedItem.getAddress() + " " +
                    selectedItem.getCity() + " " +
                    selectedItem.getState() + " " +
                    selectedItem.getZip())) continue;
            writer.write(currentLine);
        }
        writer.close();
        boolean successful = tempFile.renameTo(new File("contacts.txt"));
        addressBookTable.getItems().remove(selectedItem);
    }

    @FXML
    void findEntry(ActionEvent event) {
        // Wrap the ObservableList in a FilteredList (initially display all data)
        FilteredList<AddressBook> filteredData = new FilteredList<>(dataModel, b -> true);

        // Set the filter Predicate whenever the filter changes
        lastNameInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(contact -> {
                // If filter text is empty, display all persons
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text
                String lowerCaseFilter = newValue.toLowerCase();

                // Filter matches last name.
                return contact.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1;
            });
        });

        //Wrap the FilteredList in a SortedList
        SortedList<AddressBook> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator
        sortedData.comparatorProperty().bind(addressBookTable.comparatorProperty());

        // Add sorted (and filtered) data to the table
        addressBookTable.setItems(sortedData);
    }

    @FXML
    void updateEntry(ActionEvent event) throws IOException {
        // Validate input before adding to the table
        String firstName = firstNameInputField.getText();
        String lastName = lastNameInputField.getText();
        String birthday = birthdayInputField.getText();
        String address = addressInputField.getText();
        String city = cityInputField.getText();
        String state = stateInputField.getText();
        String zipText = zipInputField.getText();

        // Regular expressions for validation
        String nameRegex = "[a-zA-Z]+";
        String stateRegex = "[a-zA-Z]{2}";
        String zipRegex = "\\d{5}";

        if (!firstName.matches(nameRegex)) {
            System.out.println("Invalid first name format");
            return; // Stop execution if validation fails
        }

        if (!lastName.matches(nameRegex)) {
            System.out.println("Invalid last name format");
            return; // Stop execution if validation fails
        }

        if (!state.matches(stateRegex)) {
            System.out.println("Invalid state format");
            return; // Stop execution if validation fails
        }

        if (!zipText.matches(zipRegex)) {
            System.out.println("Invalid ZIP code format");
            return; // Stop execution if validation fails
        }

        int zip = Integer.parseInt(zipText);

        // Add validated entry to the table
        AddressBook row = new AddressBook(firstName, lastName, birthday, address, city, state, zip);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contacts.txt", true))) {
            bw.newLine();
            bw.write(row.getFirstName() + " " +
                    row.getLastName() + " " +
                    row.getBirthday() + " " +
                    row.getAddress() + " " +
                    row.getCity() + " " +
                    row.getState() + " " +
                    row.getZip());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataModel.add(row);
}

    // Table Content Elements

    @FXML
    private TableView<AddressBook> addressBookTable;

    @FXML
    private TableColumn<AddressBook, String> firstNameColumn;

    @FXML
    private TableColumn<AddressBook, String> lastNameColumn;

    @FXML
    private TableColumn<AddressBook, String> birthdayColumn;

    @FXML
    private TableColumn<AddressBook, String> addressColumn;

    @FXML
    private TableColumn<AddressBook, String> cityColumn;

    @FXML
    private TableColumn<AddressBook, String> stateColumn;

    @FXML
    private TableColumn<AddressBook, Integer> zipColumn;

    // Entry Input Elements

    @FXML
    private TextField firstNameInputField;

    @FXML
    private TextField lastNameInputField;

    @FXML
    private TextField birthdayInputField;

    @FXML
    private TextField addressInputField;

    @FXML
    private TextField cityInputField;

    @FXML
    private TextField stateInputField;

    @FXML
    private TextField zipInputField;

    // Button Elements

    @FXML
    private Button clearButton;

    @FXML
    private Button findButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

}

