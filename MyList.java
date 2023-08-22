package assignment2;

import java.util.List;

public interface MyList<E> extends Iterable<E> {
    public int getSize();
    public boolean isEmpty();
    public boolean add(E element);
    public void clear();
    public E remove();







}
