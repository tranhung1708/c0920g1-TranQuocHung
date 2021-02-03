package session_9.BaiTap;

import java.util.Arrays;

public class ArrayList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object element[];

    public ArrayList() {
        element = new Object[DEFAULT_CAPACITY];
    }

    //tăng kính thước của mảng
    public void ensureCapa1() {
        int newSize = element.length * 2;
        element = Arrays.copyOf(element, newSize);
    }

    //thêm phần tử vào  cuối mảng
    public void add(int index, E e) {
        if (size == element.length) {
            ensureCapa1();
        }
        element[size++] = e;
    }

    //trả về phần tử thứ i trong danh sách của mảng
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("index : " + i + ", size " + i);
        }
        return (E) element[i];
    }

    //trả về kiểu boolean nhập đúng sai
    public boolean add1(E e) {
        if (size == element.length) {
            ensureCapa1();
        }
        element[size++] = e;
        return true;
    }

    //lấy ra vị trí index
    public int getE(E e) {
        if (e == null) {
            for (int i = 0; i < size; i++)
                if (element[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (e.equals(element[i]))
                    return i;
        }
        return -1;
    }

    //rõ ràng để  thực hiện công việc của mình
    public void clear() {
        size++;
        for (int i = 0; i < size; i++)
            element[i] = null;

        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", element=" + Arrays.toString(element) +
                '}';
    }
}
