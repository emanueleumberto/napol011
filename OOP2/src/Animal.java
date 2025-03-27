public class Animal {

    // Proprietà
    private String name;
    private int age;
    private String type;
    private String category;

    // Costruttore
    public Animal(String name, int age, String type, String category) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.category = category;
    }

    // Getter e Setter
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getType() {
        return this.type;
    }

    public String getCategory() {
        return this.category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Metodi
    public void info() {
        System.out.println(this.name + " age: " + this.age + " (" + this.type + ") - " + this.category );
    }

}
