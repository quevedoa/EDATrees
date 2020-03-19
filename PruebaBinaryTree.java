package binaryTree;

public class PruebaBinaryTree {

	public static void main(String[] args) {
		
		AVLTree<Integer> tree = new AVLTree<Integer>();
		
		tree.inserta(1);
		tree.inserta(13);
		tree.inserta(7);
		tree.inserta(63);
		tree.inserta(21);
		tree.inserta(25);
		tree.inserta(30);
		tree.inserta(0);
		tree.inserta(2);
		
		//tree.borra(2);
		
		NodoBin<Integer>[] arregloNodos = new NodoBin[10];
	
		arregloNodos[0] = tree.busca(1);
		arregloNodos[1] = tree.busca(13);
		arregloNodos[2] = tree.busca(7);
		arregloNodos[3] = tree.busca(63);
		arregloNodos[4] = tree.busca(21);
		arregloNodos[5] = tree.busca(25);
		arregloNodos[6] = tree.busca(30);
		arregloNodos[7] = tree.busca(0);
		arregloNodos[8] = tree.busca(2);
		
		for (int i = 0; i < tree.cont; i++) {
			if(arregloNodos[i] == null) {
				System.out.println();
				System.out.println("NULL");
			} else {
				System.out.println();	
				System.out.println(arregloNodos[i]);
				System.out.println("FE: " + arregloNodos[i].getFe());
				System.out.println("  " + arregloNodos[i].getPapa().getElem());
				System.out.println("  |");
				System.out.println("  " + arregloNodos[i].getElem());
				System.out.println(" / \\ ");
				if(arregloNodos[i].getIzq() != null)
					System.out.print(arregloNodos[i].getIzq().getElem());
				else
					System.out.print("N");
				
				
				if (arregloNodos[i].getDer() != null)
					System.out.println("   " + arregloNodos[i].getDer().getElem());
				else
					System.out.println("   N");
					
			}
			
		}
		
		//System.out.println(tree.printTree());
		
		
	}

}
