import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Text {
    private static ArrayList<String> words = new ArrayList<>();// massiv slov
    public static void main(String[] args) {

        TextMass("Entext.txt");//chitaem file i ubiraem vse lishnee

        Map<String, Integer> map = countWords(words);// poisk odinakovych slov i sortirovka po znachenii

        Map<String, Integer> mapsort = new TreeMap<>(map);//sortirovka po klih

        for (Map.Entry<String, Integer> pair : mapsort.entrySet())//print slova otsortirovann
        { System.out.println(pair.getKey()); }
        map.entrySet().forEach(System.out::println);//print karta otsortir slova=kol-vo
    }

    private static void TextMass(String file){

        try {                                           //chtu file
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()){
                words.add(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No found file.");
        }

        //ochistka slova
        for (int i = 0; i < words.size(); i++) {
           words.set(i, words.get(i).toLowerCase().replaceAll("\\p{Punct}","").replaceAll("[0-9]","")); }
        words.removeIf(String::isEmpty);  //remove pustie


    }

    private static Map<String, Integer> countWords(ArrayList<String> list)
    {
        Map<String, Integer> result = new HashMap<>();

        for (String s : list) {

            result.put(s, result.containsKey(s) ? result.get(s) + 1 : 1);//prostovli kol-vo
        }

        Map<String,Integer> resultsort = new LinkedHashMap<>();

        result.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(e ->resultsort.put(e.getKey(),e.getValue()));//sortiruem po znacheniu.

        return resultsort;
    }

}
