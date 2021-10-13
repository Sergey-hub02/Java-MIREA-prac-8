package ru.mirea.classes;

public class BoundedWaitList<E> extends WaitList<E> {
  private int capacity;

  /**
   * Создаёт список ожидания с ограниченной ёмкостью
   * @param capacity        ёмкость списка ожидания
   */
  public BoundedWaitList(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Добавляет элемент в конец списка ожидания, если это позволяет ёмкость
   * @param element         добавляемый элемент
   */
  @Override
  public void add(E element) {
    if (this.content.size() == this.capacity) {
      System.out.println("[WARNING]: Нельзя добавить больше, чем " + this.capacity + " элементов!");
      return;
    }

    super.add(element);
  }

  /**
   * Объединяет информацию об объекте в одну строку
   * @return                общая информация об объекте
   */
  @Override
  public String toString() {
    if (this.content.size() == 0) {
      return WaitList.class.getName() + ": []";
    }

    var queue = this.content.toArray();
    StringBuilder strQueue = new StringBuilder("BoundedWaitList: ");

    strQueue.append("[").append(queue[0].toString());
    for (int i = 1; i < queue.length; ++i) {
      strQueue.append(", ").append(queue[i].toString());
    }
    strQueue.append("]");

    return strQueue.toString();
  }

  /**
   * Геттер для поля capacity
   * @return                ёмкость списка ожидания
   */
  public int getCapacity() {
    return this.capacity;
  }
}
