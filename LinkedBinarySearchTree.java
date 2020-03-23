package binaryTree;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedBinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {
	
	public LinkedBinarySearchTree() {
		super();
	}

	public NodoBin<T> inserta(T elem) {
		NodoBin<T> nuevoNodo = new NodoBin(elem);
		if (cont == 0) {
			raiz.setDer(nuevoNodo);
			nuevoNodo.setPapa(raiz);
			cont++;
			return nuevoNodo;
		} else {
			NodoBin<T> actual = raiz.getDer();
			NodoBin<T> papa = actual;
			while(actual != null) {
				papa = actual;
				if(elem.compareTo(actual.getElem()) < 0)
					actual = actual.getIzq();
				else
					actual = actual.getDer();
			}
			papa.cuelga(nuevoNodo);
			cont++;
			return nuevoNodo;
		}
	}
	
	public NodoBin<T> borra(T elem) {
		NodoBin<T> actual = busca(elem);
		if (actual == null) // Caso árbol vacío
			return null;
		
		if (actual.getDer() == null && actual.getIzq() == null) { // Caso en que el nodo es una hoja
			NodoBin<T> papa = actual.getPapa();
			if (actual.equals(papa.getIzq()))
				papa.setIzq(null);
			else
				papa.setDer(null);
			cont--;
			return actual;
		} else if (actual.getDer() == null || actual.getIzq() == null) { // Caso solo un hijo
			NodoBin<T> hijo;
			if(actual.getDer() != null) {
				hijo = actual.getDer();
			} else {
				hijo = actual.getIzq();
			}
			actual.getPapa().cuelga(hijo);
			cont--;
			return hijo;
		} else { // Caso donde hay dos hijos
			NodoBin<T> sucesorInOrden = buscaMin(actual.getDer());
			if (!sucesorInOrden.getPapa().equals(actual)) {
				if (sucesorInOrden.getDer() != null) {
					sucesorInOrden.getPapa().cuelga(sucesorInOrden.getDer());
				} else {
					sucesorInOrden.getPapa().setIzq(null);
				}
				actual.getPapa().cuelga(sucesorInOrden);
				sucesorInOrden.cuelga(actual.getIzq());
				sucesorInOrden.cuelga(actual.getDer());
			} else {
				actual.getPapa().cuelga(sucesorInOrden);
				sucesorInOrden.cuelga(actual.getIzq());
			}
			cont--;
			return sucesorInOrden;
		}
	}
	
	public T borraMin(NodoBin<T> nodo) {
		NodoBin<T> actual = nodo;
		while(actual.getIzq() != null)
			actual = actual.getIzq();
		return actual.borraNodo().getElem();
	}
	
	public T borraMax(NodoBin<T> nodo) {
		NodoBin<T> actual = nodo;
		while(actual.getDer() != null)
			actual = actual.getDer();
		return actual.borraNodo().getElem();
	}
	
	public NodoBin<T> buscaMin(NodoBin<T> nodo) {
		NodoBin<T> actual = nodo;
		while(actual.getIzq() != null)
			actual = actual.getIzq();
		return actual;
	}
	
	public NodoBin<T> buscaMax(NodoBin<T> nodo) {
		NodoBin<T> actual = nodo;
		while(actual.getDer() != null)
			actual = actual.getDer();
		return actual;
	}
	
	public NodoBin<T> busca(T elem) {
		NodoBin<T> actual = raiz.getDer();
		NodoBin<T> papa = actual;
		while(actual != null && !actual.getElem().equals(elem)) {
			papa = actual;
			if(elem.compareTo(actual.getElem()) < 0) 
				actual = actual.getIzq();
			else
				actual = actual.getDer();
		}
		
		if (actual == null) 
			return null;
		else
			return actual;
	}
	
	public int altura(NodoBin<T> actual) {
		if (actual == null)
			return 0;
		
		int contIzq = altura(actual.getIzq());
		int contDer = altura(actual.getDer());
		
		if (contIzq > contDer) 
			return contIzq + 1;
		else 
			return contDer + 1;
	}
	
	private void inOrden(NodoBin<T> actual, ArrayList<T> list) {
		if (actual == null) 
			return;
		inOrden(actual.getIzq(), list);
		list.add(actual.getElem());
		inOrden(actual.getDer(), list);
	}
	
	// contador no sirve (hacer contador global o que la funcion regrese el count)
	public NodoBin<T> buscaMediana(NodoBin<T> actual, int count) { // count empieza en 0
		if (actual == null)
			return null;
		if(count != cont/2) {
			buscaMediana(actual.getIzq(), count);
			count = count + 1;
			buscaMediana(actual.getDer(), count);
		}
		return actual;
	}

}
