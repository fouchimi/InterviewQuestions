/**
 * Created by ousmane on 12/26/16.
 */
public class Person {
    public String name;
    public  int weight;
    public boolean visited = false;

    Person(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.weight+") ";
    }
}
