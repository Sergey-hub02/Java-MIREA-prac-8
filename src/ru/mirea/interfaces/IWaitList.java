package ru.mirea.interfaces;

import java.util.Collection;

public interface IWaitList<E> {
  /**
   * Добавляет элемент в конец списка ожидания
   * @param element         добавляемый элемент
   */
  void add(E element);

  /**
   * Возвращает и удаляет элемент из начала списка ожидания
   * @return                первый элемент списка ожидания
   */
  E remove();

  /**
   * Проверяет, есть ли в списке заданный элемент
   * @param element         элемент, который нужно найти
   * @return                признак успешного/безуспешного поиска
   */
  boolean contains(E element);

  /**
   * Проверяет, содержит ли список все элементы из заданной коллекции
   * @param c               элементы коллекции, которые нужно найти
   * @return                признак успешного/безуспешного поиска
   */
  boolean containsAll(Collection<E> c);

  /**
   * Проверяет, является ли список пустым
   * @return          true - список пуст, false - в списке есть хотя бы 1 элемент
   */
  boolean isEmpty();
}
