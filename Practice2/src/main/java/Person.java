public class Person implements Comparable<Person> {
    private int age;
    private String name;
    private String surname;

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public String toString() {
        try {
            return String.format(
                    "%s[%s:%s, %s:%s, %s:%s]\n",
                    Person.class.getName(), Person.class.getDeclaredField("name"), getName(), Person.class.getDeclaredField("surname"), getSurname(), Person.class.getDeclaredField("age"), getAge()
            );
        } catch (NoSuchFieldException exception) {
            exception.printStackTrace();
        }
        return "";
    }

    public int compareTo(Person object) {
        return age - object.age;
    }
}
