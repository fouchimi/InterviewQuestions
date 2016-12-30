import java.util.*;
import java.util.LinkedList;

/**
 * Created by ousmane on 12/26/16.
 */
public class FindNames {

    public HashMap<Person, List<Person>> map = new HashMap<>();

    public List<Person> findRealNames(List<Person> personList, List<Synonyms> synonymsList){

        for(Person person : personList){
            if(!person.visited){
                person.visited = true;
                List<Person> newPersonList = new ArrayList<>();
                for(Synonyms synonyms: synonymsList){
                    if(synonyms.first != person && person.name.equals(synonyms.second.name)){
                        synonyms.first.visited = true;
                        newPersonList.add(synonyms.first);
                    }else if(synonyms.second != person && person.name.equals(synonyms.first.name)) {
                        synonyms.second.visited = true;
                        newPersonList.add(synonyms.second);
                    }else if(newPersonList.contains(synonyms.first) && !synonyms.second.visited){
                        synonyms.second.visited = true;
                        newPersonList.add(synonyms.second);
                    }else if(newPersonList.contains(synonyms.second) && !synonyms.first.visited){
                        synonyms.first.visited = true;
                        newPersonList.add(synonyms.first);
                    }
                }
                map.put(person, newPersonList);
            }
        }

        Iterator itr = map.entrySet().iterator();
        List<Person> resultList = new ArrayList<>();
        while (itr.hasNext()){
            Map.Entry<Person, List<Person>> pair = (Map.Entry<Person, List<Person>>) itr.next();
            int sumWeight = 0;
            for(Person person: pair.getValue()){
                sumWeight += person.weight;
            }
            sumWeight += pair.getKey().weight;
            pair.getKey().weight = sumWeight;
            resultList.add(pair.getKey());

        }

        return resultList;
    }

    public static void main(String[] args){
        List<Person> personList = new ArrayList<>();
        List<Synonyms> synonymsList = new ArrayList<>();
        Person john = new Person("John", 15);
        Person jon = new Person("Jon", 12);
        Person kris = new Person("Kris", 4);
        Person chris = new Person("Chris", 13);
        Person christopher =new Person("Christopher", 19);
        Person johnny  =new Person("Johnny", 0);
        personList.add(john);
        personList.add(jon);
        personList.add(kris);
        personList.add(chris);
        personList.add(christopher);
        personList.add(johnny);
        Synonyms first = new Synonyms(jon, john);
        Synonyms second = new Synonyms(john, johnny);
        Synonyms third = new Synonyms(chris, kris);
        Synonyms fourth = new Synonyms(chris, christopher);
        synonymsList.add(first);
        synonymsList.add(second);
        synonymsList.add(third);
        synonymsList.add(fourth);
        FindNames findNames = new FindNames();
        List<Person> list = findNames.findRealNames(personList, synonymsList);
        for(Person person : list){
            System.out.print(person + " ");
        }
    }
}
