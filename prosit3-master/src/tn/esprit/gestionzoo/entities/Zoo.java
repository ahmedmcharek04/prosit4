package tn.esprit.gestionzoo.entities;

import java.util.Objects;

public class Zoo {

    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages = 25;
    private int nbrAnimals;

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.animals = new Animal[nbrCages];
        this.nbrAnimals = 0;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Le nom du zoo ne doit pas être vide.");
        } else {
            this.name = name;
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    public int searchAnimal(Animal animal) {
        if (animal == null) {
            return -1;
        }
        for (int i = 0; i < nbrAnimals; i++) {
            if (Objects.equals(animals[i].getName(), animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean addAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("Un animal valide est nécessaire.");
            return false;
        }
        if (animal.getName() == null || animal.getName().trim().isEmpty()) {
            System.out.println("L'animal doit avoir un nom valide.");
            return false;
        }
        if (isZooFull()) {
            System.out.println("Le zoo est plein !");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("Cet animal existe déjà dans le zoo !");
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Animaux dans le zoo " + name + " :");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println("- " + animals[i]);
        }
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) {
            return z2;
        }
        if (z2 == null) {
            return z1;
        }
        if (z1.nbrAnimals > z2.nbrAnimals) {
            return z1;
        } else if (z2.nbrAnimals > z1.nbrAnimals) {
            return z2;
        } else {
            return null;
        }
    }

    public void displayZoo() {
        System.out.println("Zoo: " + name + ", Ville: " + city + ", Cages: " + nbrCages + ", Animaux: " + nbrAnimals);
    }

    @Override
    public String toString() {
        return "Zoo [Nom: " + name + ", Ville: " + city + ", Cages: " + nbrCages + ", Animaux: " + nbrAnimals + "]";
    }
}