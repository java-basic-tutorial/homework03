# Static methods. OOP

## Task 01

1. Create a public class named `Human` in package [com.softserveinc.task01](src/main/java/com/softserveinc/task01).
2. Class should have the private fields:
    - firstName (String type)
    - lastName (String type)
    - Date of birth (String type)
    - Phone (String type)
3. Create public accessor methods (getter and setter) for each field.
4. Create the one public constructors with no parameters and one with four parameters.
5. Override the method toString() to return string that represent a human.
6. Check your solution by running the unit tests

## Task 02

1. Create a public class named `City` in package [com.softserveinc.task02](src/main/java/com/softserveinc/task02).
2. Class should have the private fields:
    - name (String type)
    - region (String type)
    - country (String type)
    - inhabitants (int type)
3. Create public accessor methods (getter and setter) for each field.
4. Create the one public constructors with no parameters and one with four parameters.
5. Override the method toString() to return string that represent a city.
6. Check your solution by running the unit tests

## Task 03

1. Create a public class named `Country` in package [com.softserveinc.task03](src/main/java/com/softserveinc/task03).
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
