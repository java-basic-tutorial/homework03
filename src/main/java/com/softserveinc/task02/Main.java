package com.softserveinc.task02;

/**
     1. Create a public class named `City` in this package
     2. Class should have the private fields:
     - name (String type)
     - region (String type)
     - country (String type)
     - inhabitants (int type)
     3. Create public accessor methods (getter and setter) for each field.
     4. Create the one public constructors with no parameters and one with four parameters.
     5. Override the method toString() to return string that represent a city.
     6. Check your solution by running the unit tests
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Test your class City here
        City dnipro = new City("Dnipro", "Dnipropetrovskaya", "Ukraine", 966_400);
        System.out.println(dnipro);
    }
}
