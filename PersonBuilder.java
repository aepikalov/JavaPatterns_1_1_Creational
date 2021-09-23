package JavaPatterns_1_1_Creational;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("No name specified");
        } else this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("No surname specified");
        } else this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("The age cannot be negative");
        } else this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null)
            throw new IllegalStateException("The first or last name is not specified");
        if (age < 0) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}
