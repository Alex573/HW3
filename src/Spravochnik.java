import java.util.*;

public class Spravochnik {
    static Map<Person, List<Tel>> personMap = new HashMap<>();
    public static void main(String[] args) {

        add("Sidorov",79333333,79333334,79333335);
        add("Sidorov2",79333336,79333337);
        add("Sidorov3",79333339);
        add("Sidorov2",79333336,79333337,79333331);
        get("Sidorov2");
        get("Sidorov");

        /*personMap.put(new Person("Petrov2"), Arrays.asList(new Tel(79000000), new Tel(79000001)));
        personMap.put(new Person("Petrov3"), Arrays.asList(new Tel(79111111), new Tel(79111112)));
        personMap.put(new Person("Petrov4"), Arrays.asList(new Tel(79222222), new Tel(79222223), new Tel(79222224)));*/



        /*for(Person person : personMap.keySet()){
            System.out.println(person.surname + " имеет");
            for (Tel tel : personMap.get(person)){
                System.out.println("  " + tel.number);
            }
        }*/
    }



    private static class Person{
        private String surname;

        private Person(String surname) {
            this.surname=surname;
        }


    }
    private static class Tel{
        private Integer number;

        private Tel(Integer number) {
            this.number=number;
        }
    }

    private static void add(String surname, int tel1,int tel2,int tel3){
        personMap.put(new Person(surname),  Arrays.asList(new Tel(tel1), new Tel(tel2), new Tel(tel3)));

    }
    private static void add(String surname, int tel1,int tel2){
        personMap.put(new Person(surname),  Arrays.asList(new Tel(tel1), new Tel(tel2)));

    }
    private static void add(String surname, int tel1){
        personMap.put(new Person(surname),  Arrays.asList(new Tel(tel1)));

    }
    private static void get(String name){
        for (Person person : personMap.keySet()) {
            if (name.equals(person.surname)) {
                System.out.println(person.surname + " имеет");
                for (Tel tel : personMap.get(person)){
                    System.out.println("  " + tel.number);
                }

            }else {
                System.out.println("Нет такой фамилии в справочнике");
            }


        }
    }
}
