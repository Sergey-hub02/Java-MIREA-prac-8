package ru.mirea.classes;

public class UnfairWaitList<E> extends WaitList<E> {
   /**
   * Конструктор по умолчанию, создающий пустой список ожидания
   */
  public UnfairWaitList() {
    super();
  }

  /**
   * Удаляет элемент, не являющийся первым в очереди
   * @param element           удаляемый элемент
   */
  public void remove(E element) {
    this.content.remove(element);
  }

  /**
   * Отправляет первый элемент списка в конец очереди
   * @param element           бедный элемент
   */
  public void moveToBack(E element) {
    if (this.contains(element)) {
      /* если элемент существует, то его можно сначала добавить в конец, а затем удалить */
      super.add(element);
      this.remove(element);
    }
  }
}
