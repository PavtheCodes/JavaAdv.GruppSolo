import java.util.Arrays;

public class ArrayList<T> {
    private int size = 0;
    private int capacity = 10;
    private T[] elements;

    public ArrayList() {
        elements = (T[]) new Object[capacity];
    }
    public void add(T element) {
        if (size == capacity) {
            moreCapacity();
        }
        elements[size++] = element;
    }
    private void moreCapacity() {
        capacity *= 2;
        elements = Arrays.copyOf(elements, capacity);
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index != size - 1) {
            elements[index] = elements[--size];
        }
        elements[size] = null;
    }
    public int size() {
        return size;
    }

    public T get (int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }
}

class ArrayListExample {
    public static void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Dimitrov");
        list.add("Mihael");
        list.add("Humanoid");


        // Listar ut hur många items i Arrayen 1/4
        System.out.println("List of Items: " + list.size());

        // Här listas alla items i Arrayen 2/4
        System.out.println("Elements in the ArrayList:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\nRemove element of index 1: ");
        list.remove(1);

        System.out.println("Display elements after removal: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\nNow clearing the ArrayList... ");
        list.clear();
        System.out.println("List after the clear: " + list.size());
    }
}


