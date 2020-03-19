package binaryTree;

public class MinHeap<T extends Comparable<T>>{
	
    int cont;
    Comparable[] datos;
	
    public MinHeap() {
	datos = new Comparable[10];
	int cont = 0;
    }
	
    public void inserta(T elem) {
	if (cont+1 > datos.length) {
	    expand();
	}
	cont = cont + 1;
        datos[indInserta] = elem;
        int actual = cont;
	int papa = cont>>1;
	while(datos[actual] < datos[papa] && papa >= 1) {
	    T temp = datos[papa];
            datos[papa] = datos[actual];
            datos[actual] = temp;
            papa = actual>>1;                
        }
    }

    public void borraMin() {
        int actual;
        T temp, res;
        res = datos[1];
        datos[1] = datos[cont];
        datos[cont] = null;
        actual = 1;
       
        // Hay que checar cual es el minimo entre el hijo derecho y el hijo izquierdo 
        while(actual<<1 < cont) {
            temp = datos[actual];
            if(datos[actual].compareTo(datos[actual<<1)>0) {
                datos[actual] = datos[act<<1];
                datos[actual<<1] = temp;
                actual = actual<<1;
            } else {
                datos[actual] = datos[act<<1+1];
                datos[actual<<1+1] = temp;
                actual = actual<<1;
            }
        }
    }
}
