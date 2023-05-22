package listaEnlazada;

import EntradaSalida.Nodo;

public interface OperTDA<T> {

	public boolean isListaVacia();
	public void inserFrente(T dato);
	public void inserFinal(T dato);
	public void eliminaLista(Nodo pos);
	public Nodo<T> busSecuencial(int folio);
	public String imprimeLista();
	public void vaciarLista();
	
}
