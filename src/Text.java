import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Text {
    private static ArrayList<String> words = new ArrayList<>();
    public static void main(String[] args) {

        TextMass("Entext.txt");

        Map<String, Integer> map = countWords(words); //запуск метода подсчета слов

        for (Map.Entry<String, Integer> pair : map.entrySet()) //печатаем готовую карту
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    private static void TextMass(String file){

        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNext()){
                words.add(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No found file.");
        }

           //word.replaceAll("[^a-z^A-Z]", "");

        for (int i = 0; i < words.size(); i++) {
           words.set(i, words.get(i).toLowerCase().replaceAll("\\p{Punct}",""));


        }


    }

    private static Map<String, Integer> countWords(ArrayList<String> list) //метод подсчета
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>(); //создаем карту результата

        /*for (int i = 0; i < list.size() ; i++) //запускаем бег по массиву
        {
            String s1 = list.get(i); //берем значение массива
            int count = 0; //ставим счетчик в 0
            for (int j = 0; j <list.size(); j++) //бежим опять по массиву и считаем это же количество слов
            {
                String s2 = list.get(j);
                if (s1.equals(s2)) count++; //если совпадает, то счетчик +1
            }
            result.put(s1, count); //готовый результат записываем в таблицу
        }*/
        for (String s : list) {
            /*if (!result.containsKey(s)) {
                result.put(s, 1);
            } else {
                result.put(s, result.get(s) + 1);
            }*/
            result.put(s, result.containsKey(s) ? result.get(s) + 1 : 1);
        }


        return result;
    }

}
