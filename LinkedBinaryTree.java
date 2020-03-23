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
	
	public Iterator<NodoBin<T>> nivelOrden() {
		ArrayList<NodoBin<T>> lista = new ArrayList<NodoBin<T>>();
		Queue<NodoBin<T>> queue = new LinkedList<NodoBin<T>>(); 
        queue.add(raiz.getDer()); 
        while (!queue.isEmpty()) { 
  
            NodoBin<T> tempNode = queue.poll(); 
            lista.add(tempNode);

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
		String res = "    Print del Árbol AVL\n\n"
				+ " ----- POR NIVEL -----\n\n"
				+ "Nivel 1: ";
		int count = 0, nivel = 2, mult = 1, ind = 0;
		NodoBin<T>[] arregloNodos = new NodoBin[cont];
		Iterator<NodoBin<T>> iter = nivelOrden();
		
		while(iter.hasNext()) {
			NodoBin<T> actual = iter.next();
			arregloNodos[ind] = actual;
			ind++;
			res += actual.getElem() + "(" + actual.getFe() + ")   ";
			if (count % mult == 0) {
				res += "\nNivel " + nivel + ": ";
				mult *= 2;
				count = 0;
				nivel++; 
			}
			count++;
		}
		
		res += "\n\n----- POR JERARQUÍA -----\n";
		
		for (int i = 0; i < cont; i++) {
			if(arregloNodos[i] == null) {
				res += "\nNULL";
			} else {
				res += "\n" + arregloNodos[i] + "\n";	
				res += "FE: " + arregloNodos[i].getFe() + "\n";
				res += ("  " + arregloNodos[i].getPapa().getElem()) + "\n";
				res += ("  |") + "\n";
				res += ("  " + arregloNodos[i].getElem()) + "\n";
				res += (" / \\ ") + "\n";
				if(arregloNodos[i].getIzq() != null)
					res += (arregloNodos[i].getIzq().getElem());
				else
					res += ("N");
				
				
				if (arregloNodos[i].getDer() != null)
					res += ("   " + arregloNodos[i].getDer().getElem()) + "\n";
				else
					res += ("   N") + "\n";
					
			}
			
		}
		return res;
	}

	public boolean isEmpty() {
		return cont == 0;
	}

	public int size() {
		return cont;
	}
}
