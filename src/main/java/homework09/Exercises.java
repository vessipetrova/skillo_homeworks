package homework09;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        Person person = new Person("Vessi", "female", "orthodox", "Bulgarian", true, "Bulgarian","8103245060","Bulgaria");
        Italian italian = new Italian("Francesca", "female", "catholic", true, "7605108945", "Italy");
        Bulgarian bulgarian = new Bulgarian("Ivan", "male", "orthodox", true, "9112239583","Bulgaria");
        American american = new American("James", "male", "catholic", true, "6811125584","USA");
        Child child = new Child("Teodor", "male", "orthodox", "Bulgarian", "Bulgaria", "9912239583", "Bulgaria");

        //Common actions
        executePersonActions(person);
        executePersonActions(italian);
        executePersonActions(bulgarian);
        executePersonActions(american);
        executePersonActions(child);

        //Individual actions
        italian.makePizza(Arrays.asList("Cheese", "Mushrooms", "Olives"));
        bulgarian.danceHoro();
        american.celebrateThanksgiving();
        child.play("Ball");
    }

    private static void executePersonActions(Person person) {
        System.out.println("Execute actions for class " + person.getClass().getSimpleName());
        person.celebrateEaster();
        person.sayHello();
        person.canTakeLoan();
        person.isAdult();
    }
}
