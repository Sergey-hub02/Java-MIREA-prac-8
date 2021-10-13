package ru.mirea.classes;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import ru.mirea.interfaces.IWaitList;

public class WaitList<E> implements IWaitList<E> {
  protected ConcurrentLinkedQueue<E> content;

  /**
   * Конструктор по умолчанию, создающий пустой список ожидания
   */
  public WaitList() {
    this.content = new ConcurrentLinkedQueue<E>();
  }

  /**
   * Создаёт список ожидания из переданной коллекции
   * @param c               коллекция, из которой будет создан список ожидания
   */
  public WaitList(Collection<E> c) {
    this.content = new ConcurrentLinkedQueue<E>(c);
  }

  /**
   * Объединяет информацию об объекте в одну строку
   * @return                общая информация об объекте
   */
  @Override
  public String toString() {
    var queue = this.content.toArray();
    StringBuilder strQueue = new StringBuilder("WaitList: ");

    strQueue.append("[").append(queue[0].toString());
    for (int i = 1; i < queue.length; ++i) {
      strQueue.append(", ").append(queue[i].toString());
    }
    strQueue.append("]");

    return strQueue.toString();
  }

  /**
   * Добавляет элемент в конец списка ожидания
   * @param element         добавляемый элемент
   */
  public void add(E element) {
    this.content.add(element);
  }

  /**
   * Возвращает и удаляет элемент из начала списка ожидания
   * @return                первый элемент списка ожидания
   */
  public E remove() {
    return this.content.poll();
  }

  /**
   * Проверяет, есть ли в списке заданный элемент
   * @param element         элемент, который нужно найти
   * @return                признак успешного/безуспешного поиска
   */
  public boolean contains(E element) {
    return this.content.contains(element);
  }

  /**
   * Проверяет, содержит ли список все элементы из заданной коллекции
   * @param c               элементы коллекции, которые нужно найти
   * @return                признак успешного/безуспешного поиска
   */
  public boolean containsAll(Collection<E> c) {
    return this.content.containsAll(c);
  }

  /**
   * Проверяет, является ли список пустым
   * @return                true - список пуст, false - в списке есть хотя бы 1 элемент
   */
  public boolean isEmpty() {
    return this.content.isEmpty();
  }
}
