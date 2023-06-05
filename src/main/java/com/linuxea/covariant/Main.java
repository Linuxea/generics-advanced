package com.linuxea.covariant;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Printer<Animal> animalConsolePrinter = new AnimalConsolePrinter();
        List<Dog> dogs = List.of(new Dog());
        animalConsolePrinter.print(dogs);

        List<Cat> cats = List.of(new Cat());
        animalConsolePrinter.print(cats);

    }
}