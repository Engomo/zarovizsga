package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog dog : dogs) {
            if(dog.getName().equals(name)) {
                return dog;
            }
        }throw new IllegalArgumentException("Cannot find this dog!");
    }

    public void playWith(String name, int hours) {
       Dog dog = findByName(name);
        dog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> result = new ArrayList<>();
        for (Dog dog : dogs) {
            if (dog.getHappiness() > minHappiness) {
                result.add(dog.getName());
            }
        }
        return result;
    }

    public List<Dog> getDogs() {
        return dogs;
    }
}
