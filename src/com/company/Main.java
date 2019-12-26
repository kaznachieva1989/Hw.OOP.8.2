package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap();
        dictionary.put("красивый", new String[]{"прекрасный", "чудесный", "великолепный", "симпотичный"});
        dictionary.put("дом", new String[]{"квартира", "жилище", "дом2", "хижина"});
        dictionary.put("человек", new String[]{"личность", "персона", "хомосапиенс", "индивидум"});

        HashMap<String, String[]> mainDictionary = new HashMap<>();
        //HashMap<String, String[]> mainDictionary = new HashMap<>(dictionary);

        Set<String> keys = dictionary.keySet();
        Iterator iterator = keys.iterator();

        while (iterator.hasNext()){
            String key = iterator.next().toString();


            mainDictionary.putAll(dictionary);
            String[] values =mainDictionary.get(key);

            for (int i = 0; i <values.length ; i++) {
                String newKeys = values[i];
                ArrayList<String> stringArray = new ArrayList<>();
                stringArray.addAll(Arrays.asList(values));
                stringArray.remove(newKeys);
                stringArray.add(key);
                String[] newValues = new String[stringArray.size()];
                newValues = stringArray.toArray(newValues);
                mainDictionary.put(newKeys, newValues);

            }
        }
        System.out.println("Введите слово или несколько слов");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        String[] words = sentence.split(" ");
        Random r = new Random();

        for (String word : words) {
            String[] synonyms = mainDictionary.get(word);
            if (synonyms != null) {
                System.out.printf(synonyms[r.nextInt(synonyms.length)] + " ");
            } else {
                System.out.println("Такого слова в словаре нет");
            }
        }


    }
}