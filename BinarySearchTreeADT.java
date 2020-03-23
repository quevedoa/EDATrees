package binaryTree;

public interface BinarySearchTreeADT<T extends Comparable<T>> extends BinaryTreeADT<T> {
	public NodoBin<T>  inserta(T elem);
	public NodoBin<T> borra(T elem);
	public T borraMin(NodoBin<T> nodo);
	public T borraMax(NodoBin<T> nodo);
	public NodoBin<T> buscaMin(NodoBin<T> nodo);
	public NodoBin<T> buscaMax(NodoBin<T> nodo);
}
