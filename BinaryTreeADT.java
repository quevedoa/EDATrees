package binaryTree;

import java.util.Iterator;

public interface BinaryTreeADT <T>{
	
    public boolean isEmpty();
    public int size();
    public boolean contains(T elem);
    public T find(T elem);
    public Iterator<T> inOrden();
    public Iterator<T> posOrden();
    public Iterator<T> preOrden();
    public Iterator<T> nivelOrden();
	
}


