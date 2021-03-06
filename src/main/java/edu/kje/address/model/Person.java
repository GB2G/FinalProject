package edu.kje.address.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import edu.kje.address.util.LocalDateAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model CLass for a person.
 * 
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final StringProperty phoneNum;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;

    /**
     * Default constructor
     */

     public Person(){
         this(null, null);
     }

     /**
      * Constructor with some initial data
      */

      public Person(String fistName, String lastName){
          this.firstName = new SimpleStringProperty(fistName);
          this.lastName = new SimpleStringProperty(lastName);

          //Some initial dummy data, just for convenient testing
          this.street = new SimpleStringProperty("some street");
          this.phoneNum = new SimpleStringProperty("(613)-123-4567");
          this.city = new SimpleStringProperty("some city");
          this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999,2,21));

      }
    
        public String getFirstName(){
            return firstName.get();
        }

        public void setFirstName(String firstName){
            this.firstName.set(firstName);
        }

        public StringProperty firstNameProperty() {
            return firstName;
        }
    
        public String getLastName() {
            return lastName.get();
        }
    
        public void setLastName(String lastName) {
            this.lastName.set(lastName);
        }
        
        public StringProperty lastNameProperty() {
            return lastName;
        }
    
        public String getStreet() {
            return street.get();
        }
    
        public void setStreet(String street) {
            this.street.set(street);
        }
        
        public StringProperty streetProperty() {
            return street;
        }
    
        public String getPhoneNum() {
            return phoneNum.get();
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum.set(phoneNum);
        }
        
        public StringProperty phoneNumProperty() {
            return phoneNum;
        }
    
        public String getCity() {
            return city.get();
        }
    
        public void setCity(String city) {
            this.city.set(city);
        }
        
        public StringProperty cityProperty() {
            return city;
        }
    
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        public LocalDate getBirthday() {
            return birthday.get();
        }
    
        public void setBirthday(LocalDate birthday) {
            this.birthday.set(birthday);
        }
        
        public ObjectProperty<LocalDate> birthdayProperty() {
            return birthday;
        }
}
