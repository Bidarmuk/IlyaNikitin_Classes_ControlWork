import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер масссива: ");
        int c = in.nextInt();  //размер массива
        List list = new List(c);
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < c; i++)
        {
            int numb = in.nextInt();
            list.insert(numb);
        }
        list.printArray();
        
        System.out.println("Введите позицию элемента, который нужно удалить: ");
        int n = in.nextInt();
        list.delete(n-1);
        System.out.printf("Массив после удаления элемента на %d позиции: ", n);
        list.printArray();
        
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        System.out.println("Извлеченный элемент из стека: " + stack.pop());
        
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Извлеченный элемент из очереди: " + queue.dequeue());
    }
}

class List {
    private int[] array;
    private int size;

    public List(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insert(int element) {
        if (size < array.length) {
            array[size] = element;
            size++;
        } else {
            System.out.println("Список полон, невозможно добавить элемент.");
        }
    }

    public void delete(int index) {
        if (index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        } else {
            System.out.println("Индекс за пределами списка, невозможно удалить элемент.");
        }
    }

    public int getSize() {
        return size;
    }

    public int getElement(int index) {
        return array[index];
    }

    public void printArray() {
        System.out.print("Массив: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

class Stack extends List {
    public Stack(int capacity) {
        super(capacity);
    }

    public void push(int element) {
        insert(element);
    }

    public int pop() {
        int element = getElement(getSize() - 1);
        delete(getSize() - 1);
        return element;
    }
}

class Queue extends List {
    public Queue(int capacity) {
        super(capacity);
    }

    public void enqueue(int element) {
        insert(element);
    }

    public int dequeue() {
        int element = getElement(0);
        delete(0);
        return element;
    }
}


