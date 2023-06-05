package com.linuxea.covariant;

import java.util.List;

public class AnimalConsolePrinter implements Printer<Animal> {

    @Override
    public void print(List<? extends Animal> animals) {
        animals.forEach(Animal::say);
    }
}
