package ru.mirea;

import java.util.ArrayList;

import ru.mirea.classes.*;
import ru.mirea.interfaces.IWaitList;


public class App {
  public static void main(String[] args) {
    /*========== ТЕСТ КЛАССА WaitList ==========*/
    WaitList<Integer> wl = new WaitList<>();

    wl.add(1);
    wl.add(2);
    wl.add(3);
    wl.add(4);

    System.out.println(wl);
    System.out.println();

    System.out.println("WaitList содержит 2: " + wl.contains(2));
    System.out.println("WaitList содержит 10: " + wl.contains(10));

    var col1 = new ArrayList<Integer>();
    col1.add(2);
    col1.add(3);

    var col2 = new ArrayList<Integer>();
    col2.add(4);
    col2.add(5);

    System.out.println();

    System.out.println("WaitList содержит 2, 3: " + wl.containsAll(col1));
    System.out.println("WaitList содержит 4, 5: " + wl.containsAll(col2));

    System.out.println();

    System.out.println("[MSG]: Удаление начального элемента!");
    System.out.println("[MSG]: Удаление начального элемента!");

    wl.remove();
    wl.remove();

    System.out.println();
    System.out.println(wl);

    System.out.println();

    System.out.println("[MSG]: Удаление начального элемента!");
    System.out.println("[MSG]: Удаление начального элемента!");

    wl.remove();
    wl.remove();

    System.out.println();

    System.out.println("WaitList пустой: " + wl.isEmpty());
    System.out.println(wl);

    System.out.println("=========================================");

    /*========== ТЕСТ КЛАССА BoundedWaitList ==========*/
    BoundedWaitList<String> bwl = new BoundedWaitList<>(3);

    System.out.println("BoundedWaitList расчитан на " + bwl.getCapacity() + " элементов!");

    bwl.add("One");
    bwl.add("Two");
    bwl.add("Three");

    System.out.println(bwl);
    System.out.println();

    bwl.add("Four");
    System.out.println(bwl);

    System.out.println("=========================================");

    /*========== ТЕСТ КЛАССА UnfairWaitList ==========*/
    UnfairWaitList<String> uwl = new UnfairWaitList<>();
    uwl.add("First");
    uwl.add("Second");
    uwl.add("Third");
    uwl.add("Fifth");

    System.out.println(uwl);

    System.out.println();
    System.out.println("[MSG]: Из UnfairWaitList удаляется элемент \"First\"!");

    uwl.remove("First");
    System.out.println(uwl);

    System.out.println();
    System.out.println("[MSG]: Попытка удалить из UnfairWaitList элемент \"Fourth\"!");

    uwl.remove("Fourth");
    System.out.println(uwl);

    System.out.println();
    System.out.println("[MSG]: В UnfairWaitList элемент \"Third\" отправляется в конец!");

    uwl.moveToBack("Third");
    System.out.println(uwl);

    System.out.println();
    System.out.println("[MSG]: Попытка отправить в конец элемент \"Fourth\"!");

    uwl.moveToBack("Fourth");
    System.out.println(uwl);
  }
}
