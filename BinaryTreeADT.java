package binaryTree;

import java.util.Iterator;

public interface BinaryTreeADT <T>{
	
    public boolean isEmpty();
    public int size();
    public Iterator<T> inOrden();
    public Iterator<T> posOrden();
    public Iterator<T> preOrden();
}


