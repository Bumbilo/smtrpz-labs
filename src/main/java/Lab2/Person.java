package Lab2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

public class Person {
    private final int age;
    private final int height;
    private final int weight;
    private final String name;

    public Person(int age, int height, int weight, String name) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj) return true;

        if (!(obj instanceof Person)) return false;

        Person person = (Person)obj;
        return age == person.getAge() &&
                height == person.getHeight() &&
                weight == person.getWeight() &&
                (name != null ? name.equals(person.getName()) : person.getName() == null);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(age, height, weight, name);
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public Person fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }
}
