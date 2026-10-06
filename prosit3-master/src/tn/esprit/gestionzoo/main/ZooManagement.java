package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class ZooManagement {
    public static void main(String[] args) {
        Animal lion = new Animal("Félins", "Simba", 5, true);
        Animal tiger = new Animal("Félins", "Sher Khan", 4, true);

        Zoo myZoo = new Zoo("Belvedere", "Tunis");
        Zoo otherZoo = new Zoo("Friguia", "Bouficha");

        myZoo.addAnimal(lion);
        myZoo.addAnimal(tiger);
        myZoo.addAnimal(lion);

        myZoo.displayAnimals();

        System.out.println("Position de Simba : " + myZoo.searchAnimal(lion));

        myZoo.removeAnimal(lion);
        System.out.println("Après suppression :");
        myZoo.displayAnimals();

        Zoo maxZoo = Zoo.comparerZoo(myZoo, otherZoo);
        if (maxZoo != null) {
            System.out.println("Le zoo avec le plus d'animaux est : " + maxZoo.getName());
        } else {
            System.out.println("Les deux zoos ont le même nombre d'animaux.");
        }

        lion.setAge(-3);
        System.out.println("Âge du lion : " + lion.getAge());

        myZoo.setName("   ");
        System.out.println("Nom du zoo : " + myZoo.getName());

        for (int i = 1; i <= 30; i++) {
            myZoo.addAnimal(new Animal("Félins", "Chat" + i, 1, true));
        }
        System.out.println(myZoo);
        System.out.println("Zoo plein ? " + myZoo.isZooFull());
    }
}