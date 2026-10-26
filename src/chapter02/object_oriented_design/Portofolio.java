package chapter02.object_oriented_design;

/** Generics and Arrays */
public class Portofolio<T> {

    T[] data;

      public Portofolio(int capacity) {
          //this.data = new T[capacity];    // illegal, compile error
          this.data = (T[]) new Object[capacity];    // legal, but compile warning
      }

      public T get(int index) {
          return this.data[index];
      }

      public void set(int index, T element) {
          this.data[index] = element;
      }
}
