package Metodos;

public interface BusquedasTDA {
	
	public boolean arrayVacio();
	public boolean espacioArray();
	public void vaciarArray();
	public void almacenaAleatorios();
	public String impresionDatos();
    //D
    public int busquedaSecuencial(int[] arreglo, int elemento);
    public boolean busquedaKMP(String texto, String patron);
    //O
    public int busquedaBinaria(int[] memoria, int elemento);
    public int busquedaInterpolacion(int[] arreglo, int elemento);
    public int busquedaExponencial(int[] arreglo, int elemento);
    public int busquedaFibonacci(int[] arreglo, int elemento);
    public int saltoBusqueda(int[] arreglo, int elemento);
}