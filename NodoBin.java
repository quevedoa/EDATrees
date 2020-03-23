package binaryTree;

public class NodoBin <T extends Comparable<T>> {
	T elem;
	int factorEquilibrio;
	NodoBin<T> izq, der, papa;
	
	public NodoBin(T elem) {
		this.elem = elem;
		this.factorEquilibrio = 0;
		izq = null;
		der = null;
		papa = null;
	}
	
	public int numDescendiente() {
		int count = 0;
		if (izq != null) 
			count = izq.numDescendiente() + 1;
		if (der != null) 
			count += der.numDescendiente() + 1;
		return count;
	}

	public void cuelga(NodoBin<T> nodo) {
		if (nodo == null)
			return;
		if (getElem() == null) 
			this.setDer(nodo);
		else if (nodo.getElem().compareTo(getElem()) < 0) 
			this.setIzq(nodo);
		else
			this.setDer(nodo);
		nodo.setPapa(this);
	}
	
	public NodoBin<T> borraNodo() {
		if (getPapa().getIzq().equals(this))
			setIzq(null);
		else
			papa.setDer(null);
		papa.setPapa(null);
		return this;
	}
	
	public void setIzq(NodoBin<T> nodo) {
		this.izq = nodo;
	}
	public void setDer(NodoBin<T> nodo) {
		this.der = nodo;
	}
	public void setPapa(NodoBin<T> nodo) {
		this.papa = nodo;
	}
	public NodoBin<T> getIzq() {
		return this.izq;
	}
	public NodoBin<T> getDer() {
		return this.der;
	}
	public NodoBin<T> getPapa() {
		return this.papa;
	}
	public int getFe() {
		return this.factorEquilibrio;
	}
	public void setFe(int cambio) {
		this.factorEquilibrio += cambio;
	}
	public T getElem() {
		return this.elem;
	}

}
