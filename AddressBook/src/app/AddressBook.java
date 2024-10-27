/* CSIS312 - Assignment 4: Address Book Program
** By Ben Turner & Jack Skywalker (Baijun Jiang)
**
*/

package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddressBook {

    String firstName;
    String lastName;
    String birthday;
    String address;
    String city;
    String state;
    int zip;

    public AddressBook(String firstName, String lastName, String birthday, String address, String city, String state, int zip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    // Validate first name (only alpha letters)
    public boolean validateFirstName(String firstName) {
        return firstName.matches("[a-zA-Z]+");
    }

    // Validate last name (only alpha letters)
    public boolean validateLastName(String lastName) {
        return lastName.matches("[a-zA-Z]+");
    }

    // Validate state (two letter abbreviation)
    public boolean validateState(String state) {
        return state.matches("[a-zA-Z]{2}");
    }

    // Validate ZIP code (five digit integer)
    public boolean validateZip(int zip) {
        return String.valueOf(zip).matches("\\d{5}");
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }
}
