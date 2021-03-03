package Home3_2_Dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
    private Scanner sc;
    private HashMap<String, HashSet<String>>setmap;

    public Dictionary() {
        setmap = new HashMap<>();
        sc = new Scanner(System.in);
    }

    //добавляем слово и перевод в словарь
    public void Add() {
        System.out.println("Введите слово");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toLowerCase();
        System.out.println("Введите перевод");
        String translate = sc.nextLine().toLowerCase();
        try{
            if(setmap.containsKey(word)&&!(setmap.get(word).contains(translate))){
                setmap.get(word).add(translate);
                return;
            }

            else if(setmap.containsKey(word)&&setmap.get(word).contains(translate)) {
                System.out.println("Такое слово и такой перевод уже есть в словаре!");
                return;
            }
            setmap.put(word, new HashSet<String>());
            setmap.get(word).add(translate);
            System.out.println("Новое слово и перевод добавлены в словарь!");
        }catch (Exception ex){
            throw(ex);
        }
    }
    //изменить слово
    public boolean changeWord(){
        System.out.println("Введите слово которое хотитезаменить:");

        String oldWord = sc.nextLine().toLowerCase();
        if(setmap.containsKey(oldWord)){
            System.out.println("ВВедите новое слово для замены: ");
            String newWord = sc.nextLine().toLowerCase();
            HashSet<String> old = setmap.get(oldWord);
            setmap.remove(oldWord);
            setmap.put(newWord,old);
            System.out.println("Слово "+ oldWord + " изменено на " + newWord);
            return true;
        }
        else{
            System.out.println("Такого слова нет в вашем словаре");
            return false;
        }
    }

    //выводим все слова и их переводы из словаря
    public void show() {
        for(HashMap.Entry<String,HashSet<String>> item:setmap.entrySet()) {
            System.out.println(item.getKey()+item.getValue());
            System.out.println();
        }
    }

    //отобразим слово и его переводы
    public void showConcreateWord() {
        System.out.println("Введите слово перевод которого хотите увидеть");
        String word = sc.nextLine().toLowerCase();
        if(setmap.containsKey(word)){
            System.out.println("Все переводы слова "+word);
            System.out.println(setmap.get(word));
        }
        else{
            System.out.println("Такого слова нет в словаре");
        }

    }

    //удаляем слово
    public boolean deleteWord(){
        System.out.println("Введите слово перевод которого хотите увидеть");
        String word = sc.nextLine().toLowerCase();
        if(setmap.containsKey(word)){
            setmap.remove(word);
            System.out.println("Слово "+ word + " удалено из словаря");
            return true;
        }
        else{
            System.out.println("Такого слова нет в словаре");
            return false;
        }
    }

    //удаляем перевод слова
    public boolean deleteTranslate() {
        System.out.println("Введите слово перевод которого хотите удалить");
        String word = sc.nextLine();
        System.out.println("Введите перевод который нужно удалить");
        String translate = sc.nextLine();
        if(setmap.containsKey(word)&&setmap.get(word).contains(translate)){
            setmap.get(word).remove(translate);
            if(setmap.get(word).isEmpty()){
                System.out.println("перевод успешно удален!");
                setmap.remove(word);
            }
            return true;
        }
        else{
            System.out.println("Такого слова нет в словаре");
            return false;
        }
    }

    //заменяем перевод слова
    public boolean changeTranslate() {
        System.out.println("Введите слово перевод которого хотите заменить");
        String word = sc.nextLine().toLowerCase();
        System.out.println("Введите слово перевод который хотите заменить");
        String translate = sc.nextLine().toLowerCase();
        if(setmap.containsKey(word)&&setmap.get(word).contains(translate)){
            setmap.get(word).remove(translate);
            System.out.println("Введите новый вариант перевода этого слова");
            String newTranslate = sc.nextLine();
            setmap.get(word).add(newTranslate);
            System.out.println("перевод " + translate + " изменен на "+ newTranslate);
            return true;
        }
        else{
            System.out.println("Такого слова нет в словаре");
            return false;
        }

    }

}
