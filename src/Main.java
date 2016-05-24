import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Gson g = new Gson();

        Person person = g.fromJson("{\"name\": \"John\"}", Person.class);
        System.out.println(person.name); //John

        System.out.println(g.toJson(person)); // {"name":"John"}
        System.out.println("Hello World!");

        Client.run();
    }

    private class Person {
        public String name;
        public Person(String name) {
            this.name = name;
        }
    }
}
