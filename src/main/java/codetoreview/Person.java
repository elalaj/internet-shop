package codetoreview;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {

    private static final long serialVersionUID = -4238320309780264419L;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm/DD/yyyy");// if date will be shown to user using Locale.class might be useful

    //make class attributes private and use getter for better encapsulation. Changing someone this personal data is not common usecase
    public String name;
    public Date birthDate; 
    public boolean gender;
    public Person father; 
    public Person mother; 

    public Person(String name, Date birthdate, boolean gender, Person father, Person mother) { //Use builder for easy code reading
        //validation of mandatory name, birthday, gender might be required
        this.name = name;
        this.birthDate = birthdate; //typo error birthdate
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isGender() {
        return gender; //use different approach for gender. What does it mean gender=true?
    }

    public String getFormattedDateOfBirth() {
        try {
            return DATE_FORMAT.format(birthDate);
        } catch (Throwable t) {
            t.printStackTrace(); //use logger instead of printing so output can go in log files
            throw new RuntimeException(t);
        }
    }

    public int age() {
        //Convert birthDate to LocalDate and use Period.between()
        //Method can easily give wrong result when year is 366 days
        //dividing now/birthday can return a double. Casting might not give correct info. Ex: 10/6=1.66 -> (int)1.66=1
        long now = System.currentTimeMillis();
        return (int) ((now - birthDate.getTime()) / 365 / 24 / 60 / 1000);
    }

    public boolean isAncestorOf(Person person) { // function can be simplified as 4 consecutive condition return true
        //Recursive call that from implementation can be cases that goes infinite loop but in real life would be difficult to have such a chain
        //Father and mother should be checked for null values
        if (person != null) {
            if (equals(person.father)) {
                return true;
            }
            if (isAncestorOf(person.father)) { //recursive call, may end in infinite loop
                return true;
            }
            if (equals(person.mother)) {
                return true;
            }
            if (isAncestorOf(person.mother)) { //recursive call, may end in infinite loop
                return true;
            }
        }
        return false;
    }

    //In general overriding only equals without hashCode can lead to errors on some cases.
    //Consider putting if storing into a map is needed. equals() is used to check for equals keys and hashCode() considered on which bucket map should put the element
    //Can be case where map will put into different bucket even though equals() is true.
    @Override
    public boolean equals(Object o) {
        if (o == this) {  //you can just call super.equals(o);
            return true;
        }
        if (o instanceof Person) {
            return ((Person) o).name == name // string should compare with .equals(). == must be used to compare reference and not object state
                    && ((Person) o).birthDate == birthDate;  // date should compare with .equals(). == must be used to compare reference and not object state
        }
        return false;
    }

    public String toString() {
        return getName();
    } //only name as part of toString() might not give essential info for the object
}