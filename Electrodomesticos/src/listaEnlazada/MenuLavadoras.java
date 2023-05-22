package listaEnlazada;

import javax.swing.JOptionPane;

import EntradaSalida.Nodo;
import EntradaSalida.Tools;

import javax.swing.JOptionPane;

public class MenuLavadoras {
    public static void main(String[] args) {
    	
        ListaLavadoras lista = new ListaLavadoras();

        int opcion;
        do {
            opcion = Tools.leerInt("Elige una opción:\n" +
                    "1. Inserta frente\n" +
                    "2. Inserta final\n" +
                    "3. Eliminar\n" +
                    "4. Modificar\n" +
                    "5. Consulta individual\n" +
                    "6. Salir");

            switch (opcion) {
                case 1:
                    Lavadora lavadoraFrente = crearLavadora();
                    lista.inserFrente(lavadoraFrente);
                    Tools.imprimeMsje("Lavadora insertada al frente");
                    break;
                case 2:
                    Lavadora lavadoraFinal = crearLavadora();
                    lista.inserFinal(lavadoraFinal);
                    Tools.imprimeMsje("Lavadora insertada al final");
                    break;
                case 3:
                	int folioEliminar = Tools.leerInt("Ingresa el folio de la lavadora a eliminar:");
                	Nodo<Lavadora> nodoEliminar = lista.busSecuencial(folioEliminar);

                	if (nodoEliminar != null) {
                	    lista.eliminaLista(nodoEliminar);
                	    	Tools.imprimeMsje("La lavadora con folio " + folioEliminar + " ha sido eliminada.");
                	} else {
                	    Tools.imprimeMsje("No se encontró ninguna lavadora con el folio " + folioEliminar + ".");
                	}
                    break;
                case 4:
                	 if (lista.isListaVacia()) {
                	        Tools.imprimeMsje("Lista vacía");
                	    } else {
                	        int folio = Tools.leerInt("Folio de la lavadora a modificar: ");
                	        lista.modificaLavadora(folio);
                	    }
                	    break;

                case 5:
                	if (lista.isListaVacia()) {
                	    Tools.imprimeMsje("La lista está vacía.");
                	} else {
                	    int folioBuscar = Tools.leerInt("Ingrese el folio de la lavadora a buscar: ");
                	    Nodo<Lavadora> nodoLavadora = lista.busSecuencial(folioBuscar);
                	    if (nodoLavadora == null) {
                	        Tools.imprimeMsje("No se encontró ninguna lavadora con el folio " + folioBuscar);
                	    } else {
                	        Lavadora lavadora = nodoLavadora.getInfo();
                	        String mensaje = "Datos de la lavadora:\n" +
                	                         "Folio: " + lavadora.getFolio() + "\n" +
                	                         "Marca: " + lavadora.getMarca() + "\n" +
                	                         "Potencia: " + lavadora.getPotencia() + "\n" +
                	                         "Precio: " + lavadora.getPrecio() + "\n" +
                	                         "Agua caliente: " + (lavadora.isAguaCaliente() ? "Sí" : "No");
                	        Tools.imprimeMsje(mensaje);
                	    }
                	}

                    break;
            }
        } while (opcion != 6);}
    

    public static Lavadora crearLavadora() {
        String marca = Tools.leerString("Ingrese la marca de la lavadora:");
        double potencia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la potencia de la lavadora:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de la lavadora:"));
        boolean aguaCaliente = Boolean.parseBoolean(JOptionPane.showInputDialog("¿La lavadora funciona con agua caliente? (true/false)"));
        Lavadora lavadora = new Lavadora(marca, potencia, precio);
        lavadora.setAguaCaliente(aguaCaliente);

        return lavadora;
    }
}