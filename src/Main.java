import Home3_2_Dictionary.Dictionary;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //задача 2 - раскоментировать
        Dictionary dict = new Dictionary();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.Добавить новое слово и перевод");
            System.out.println("2.Удалить перевод слова определенного слова");
            System.out.println("3.Заменить перевод слова определенного слова");
            System.out.println("4.Удалить определенное слово");
            System.out.println("5.Изменить определенное слово в словаре");
            System.out.println("6.Показать все слова и их переводы");
            System.out.println("7.Показать конкретное слово и его переводы");
            try {
                int a = Integer.parseInt(sc.nextLine());

                switch (a) {
                    case 1:
                        dict.Add();
                        break;
                    case 2:
                        dict.deleteTranslate();
                        break;
                    case 3:
                        dict.changeTranslate();
                        break;
                    case 4:
                        dict.deleteWord();
                        break;
                    case 5:
                        dict.changeWord();
                        break;
                    case 6:
                        dict.show();
                        break;
                    case 7:
                        dict.showConcreateWord();
                        break;
                    default:
                        System.out.println("Вы ввели некорректный вариант");
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }
}

