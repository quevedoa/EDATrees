package binaryTree;

public class PruebaBinaryTree {

	public static void main(String[] args) {
		
		// Prueba del árbol AVL
		AVLTree<Integer> tree = new AVLTree<Integer>();
		
		tree.inserta(1);
		tree.inserta(13);
		tree.inserta(7);
		tree.inserta(63);
		tree.inserta(21);
		tree.inserta(25);
		tree.inserta(30);
		tree.inserta(0);
		tree.inserta(16);
		tree.inserta(24);
		
		System.out.println("Árbol después de inserciones\n\n" + tree.printTree());
		
		tree.borra(30);
		
		System.out.println("Árbol despues de borrar el 30\n\n" + tree.printTree());
		
	}

}
