package binaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue; 

public class LinkedBinaryTree <T extends Comparable<T>> implements BinaryTreeADT<T> {
	
	public NodoBin<T> raiz;
	public int cont;
	
	public LinkedBinaryTree() {
		raiz = new NodoBin(null);
		cont = 0;
	}
	
	public Iterator<T> inOrden() {
		ArrayList<T> lista = new ArrayList<T>();
		inOrden(raiz, lista);
		return lista.iterator();
	}
	
	private void inOrden(NodoBin<T> actual, ArrayList<T> list) {
		if (actual == null) 
			return;
		inOrden(actual.getIzq(), list);
		list.add(actual.getElem());
		inOrden(actual.getDer(), list);
	}
	public Iterator<T> preOrden() {
		ArrayList<T> lista = new ArrayList<T>();
		preOrden(raiz, lista);
		return lista.iterator();
	}
	public void preOrden(NodoBin<T> actual, ArrayList<T> list) {
		if (actual == null)
			return;
		list.add(actual.getElem());
		preOrden(actual.getIzq(), list);
		preOrden(actual.getDer(), list);
	}
	public Iterator<T> posOrden() {
		ArrayList<T> lista = new ArrayList<T>();
		posOrden(raiz, lista);
		return lista.iterator();
	}
	public void posOrden(NodoBin<T> actual, ArrayList<T> list) {
		if (actual == null)
			return;
		posOrden(actual.getIzq(), list);
		posOrden(actual.getDer(), list);
		list.add(actual.getElem());
	}
	
	// POR NIVEL
	public Iterator<T> nivelOrden() {
		ArrayList<T> lista = new ArrayList<T>();
		Queue<NodoBin<T>> queue = new LinkedList<NodoBin<T>>(); 
        queue.add(raiz.getDer()); 
        while (!queue.isEmpty()) { 
  
            NodoBin<T> tempNode = queue.poll(); 
            lista.add(tempNode.getElem());

            if (tempNode.getIzq() != null) { 
                queue.add(tempNode.getIzq()); 
            } 
  
            if (tempNode.getDer() != null) { 
                queue.add(tempNode.getDer()); 
            } 
        } 
        return lista.iterator();
	}
	
	public String printTree() {
		String res = "";
		Iterator<T> iter = nivelOrden();
		int size = size();
		int space = ((size-1)/2)-1;
		int cont = 1;
		
		while(iter.hasNext()) {
			for (int j = 0; j < cont; j++) {
				for (int i = 0; i < space; i++) 
					res += " ";
				if(iter.hasNext())
					res += iter.next();
			}
			cont *= 2;
			res += "\n";
		}
		return res;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return cont == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return cont;
	}

	@Override
	public boolean contains(T elem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(T elem) {
		// TODO Auto-generated method stub
		return null;
	}
}
