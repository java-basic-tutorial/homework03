package com.softserveinc.task03;

import com.softserveinc.task02.City;

/**
     1. Create a public class named `Country` in this package
     2. Class should have the private fields:
     - name (String type),
     - continent (String type),
     - code (String type),
     - capital (*City* type),
     - cities (array of type City)
     3. Create public accessor methods (getter and setter) for each field.
     4. Create the one public constructors with no parameters and one with four parameters (except cities).
     5. Override the method toString() to return string that represent a city.
     6. Add the method addCity to append new city into array cities.
     7. Add the method getInhabitants witch return count all inhabitants of all cities in country.
     8. Check your solution by running the unit tests.
 */
public class Main {
    public static void main(String[] args) {
        // TODO: Test your class Country here
        City kyiv = new City("Kyiv", "Kyivska", "Ukraine", 2_884_000);
        Country ukraine = new Country("Ukraine", "Eurasia", "UA", kyiv);

        City dnipro = new City("Dnipro", "Dnipropetrovskaya", "Ukraine", 966_400);
        City lviv = new City("Lviv", "Lvivska", "Ukraine", 721_301);

        ukraine.addCity(dnipro);
        ukraine.addCity(lviv);

        System.out.println(kyiv);
    }
}
