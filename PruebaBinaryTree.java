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
		tree.inserta(16);
		tree.inserta(24);
		
		NodoBin<Integer>[] arregloNodos = new NodoBin[tree.cont];
	
		arregloNodos[0] = tree.busca(1);
		arregloNodos[1] = tree.busca(13);
		arregloNodos[2] = tree.busca(7);
		arregloNodos[3] = tree.busca(63);
		arregloNodos[4] = tree.busca(21);
		arregloNodos[5] = tree.busca(25);
		arregloNodos[6] = tree.busca(30);
		arregloNodos[7] = tree.busca(0);
		arregloNodos[8] = tree.busca(16);
		arregloNodos[9] = tree.busca(24);
	
		for(int i = 0; i < arregloNodos.length; i++) {
			//System.out.println(arregloNodos[i]);
		}
		
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
		
		System.out.println("\n\n PRUEBA BORRAR \n\n ");
		tree.borra(21);
		
		NodoBin<Integer>[] arregloNodos1 = new NodoBin[tree.cont+1];
		
	
		arregloNodos1[0] = tree.busca(1);
		arregloNodos1[1] = tree.busca(13);
		arregloNodos1[2] = tree.busca(7);
		arregloNodos1[3] = tree.busca(63);
		arregloNodos1[4] = tree.busca(21);
		arregloNodos1[5] = tree.busca(25);
		arregloNodos1[6] = tree.busca(30);
		arregloNodos1[7] = tree.busca(0);
		arregloNodos1[8] = tree.busca(16);
		arregloNodos1[9] = tree.busca(24);
	
		for(int i = 0; i < arregloNodos1.length; i++) {
			//System.out.println(arregloNodos1[i]);
		}
		
		for (int i = 0; i <= tree.cont; i++) {
			if(arregloNodos1[i] == null) {
				System.out.println();
				System.out.println("NULL");
			} else {
				System.out.println();	
				System.out.println(arregloNodos1[i]);
				System.out.println("FE: " + arregloNodos1[i].getFe());
				System.out.println("  " + arregloNodos1[i].getPapa().getElem());
				System.out.println("  |");
				System.out.println("  " + arregloNodos1[i].getElem());
				System.out.println(" / \\ ");
				if(arregloNodos1[i].getIzq() != null)
					System.out.print(arregloNodos1[i].getIzq().getElem());
				else
					System.out.print("N");
				
				
				if (arregloNodos1[i].getDer() != null)
					System.out.println("   " + arregloNodos1[i].getDer().getElem());
				else
					System.out.println("   N");
					
			}
			
		}
		
		
	}

}
