package binaryTree;

public class AVLTree<T extends Comparable<T>> extends LinkedBinarySearchTree<T> {
	
	public AVLTree() {
		super();
	}

    public NodoBin<T> inserta(T elem) {
        NodoBin<T> actual = super.inserta(elem);
        
        boolean termino = false;
    	NodoBin<T> papa;
    	
        // Empieza a actualizar factor equilibrio
    	while(!termino) {
    	    papa = actual.getPapa();
    	    if(papa.equals(raiz))
    	    	termino = true;
    	    else {
    	    	if(actual.equals(papa.getIzq())) 
    	    		papa.setFe(-1);
    	    	else 
    	    		papa.setFe(1);
    			
    	    	if (papa.getFe() == 0) {
    	    		termino = true;
    	    		return actual;
    	    	} else if (papa.getFe() > 1 || papa.getFe() < -1) {
    	    		
    	    		// Rotaciones
    	    		rotacion(papa);
    	    		termino = true;
    	    	}
    	    	actual = papa;
    	    }
        }
    	return actual;
    }
    
    public NodoBin<T> borra(T elem) {
    	NodoBin<T> porBorrar = busca(elem);
    	NodoBin<T> comienzo; // Comienzo es el nodo donde empieza a actualizar factores de equilibrio
    	
    	if (porBorrar.getDer() != null && porBorrar.getIzq() != null) { // Caso en el que el nodo por borrar tiene dos hijos
    		comienzo = buscaMin(porBorrar.getDer());
    		if (!comienzo.getPapa().equals(porBorrar)) // Caso en el que el sucesorInOrden es también el hijo
    			comienzo = comienzo.getPapa();
    	} else {
    		comienzo = porBorrar.getPapa();
    	}
    	NodoBin<T> nodoBorrado = super.borra(elem);
        NodoBin<T> papa;
        boolean termino = false;
        
        comienzo.setFe(altura(comienzo.getDer())-altura(comienzo.getIzq()) - comienzo.getFe());
        
        while(!termino) {
        	papa = comienzo.getPapa();
        	if (papa.equals(raiz)) {
        		termino = true;
        	} else if (comienzo.getFe() == 1 || comienzo.getFe() == -1) {
        		termino = true;
        	} else {
        		if (comienzo.getFe() > 1 || comienzo.getFe() < -1) 
        			rotacion(comienzo);
        		papa.setFe(altura(papa.getDer())-altura(papa.getIzq()) - papa.getFe());
        	}
        	comienzo = papa;
        }
       
        return nodoBorrado;
    }
   
    public void rotacion(NodoBin<T> nodo) {
        if (nodo.getFe() > 0) {
            NodoBin<T> nodoHijo = nodo.getDer();
            if (nodo.getDer().getFe() > 0) {
                //Rotacion derecha-derecha
                rotacionIzq(nodo);
            } else {
                //Rotacion derecha-izquierda
                rotacionDer(nodoHijo);
                rotacionIzq(nodo);
            }
        } else {
            NodoBin<T> nodoHijo = nodo.getIzq();
            if (nodo.getIzq().getFe() < 0) {
                //Rotacion izquierda-izquierda
                rotacionDer(nodo);
            } else {
                //Rotacion izquierda-derecha
                rotacionIzq(nodoHijo);
                rotacionDer(nodo);
            } 
        }
    }

    public void rotacionIzq(NodoBin<T> nodo) {
        // Rotar
        NodoBin<T> nodoHijo = nodo.getDer();
        nodo.setDer(null);
        nodo.getPapa().cuelga(nodoHijo);
        if (nodoHijo.getIzq() != null)
        	nodo.cuelga(nodoHijo.getIzq());
        nodoHijo.cuelga(nodo);
        // Actualizar Factores Equilibrio
        nodo.setFe(altura(nodo.getDer())-altura(nodo.getIzq()) - nodo.getFe());
        nodoHijo.setFe(altura(nodoHijo.getDer())-altura(nodoHijo.getIzq()) - nodoHijo.getFe());
    }
    
    public void rotacionDer(NodoBin<T> nodo) {
        // Rotar
        NodoBin<T> nodoHijo = nodo.getIzq();
        nodo.setIzq(null);
        nodo.getPapa().cuelga(nodoHijo);
        if (nodoHijo.getDer() != null)
        	nodo.cuelga(nodoHijo.getDer());
        nodoHijo.cuelga(nodo);
        // Actualiar Factores Equilibrio
        nodo.setFe(altura(nodo.getDer())-altura(nodo.getIzq()) - nodo.getFe());
        nodoHijo.setFe(altura(nodoHijo.getDer())-altura(nodoHijo.getIzq()) - nodoHijo.getFe());
    }
    
}
