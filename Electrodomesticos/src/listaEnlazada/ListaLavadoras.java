package listaEnlazada;

import javax.swing.JOptionPane;

import EntradaSalida.Nodo;
import EntradaSalida.Tools;


public class ListaLavadoras implements OperTDA<Lavadora> {
    private Nodo<Lavadora> first;
    private Nodo<Lavadora> last;

    public ListaLavadoras() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean isListaVacia() {
        return first == null;
    }

    @Override
    public void inserFrente(Lavadora dato) {
        Nodo<Lavadora> nod = new Nodo<>(dato);
        if (isListaVacia()) {
            first = nod;
            last = nod;
        } else {
            nod.setSig(first);
            first = nod;
        }
    }

    @Override
    public void inserFinal(Lavadora dato) {
        Nodo<Lavadora> nod = new Nodo<>(dato);
        if (isListaVacia()) {
            first = nod;
            last = nod;
        } else {
            last.setSig(nod);
            last = nod;
        }
    }

    @Override
    public void eliminaLista(Nodo pos) {
        if (pos == first) {
            first = first.getSig();
            if (first == null) {
                last = null;
            }
        } else {
            Nodo<Lavadora> prev = dirAntes(pos);
            prev.setSig(pos.getSig());
            if (pos == last) {
                last = prev;
            }
        }
    }

    @Override
    public Nodo<Lavadora> busSecuencial(int folio) {
        Nodo<Lavadora> currNode = first;
        System.out.println("Informacion del Nodo"+currNode.getInfo() +"Inf de FOLIO\n"+Electrodomestico.getFolio());
        while (currNode != null && first.getInfo().folio!= folio) {
            currNode = currNode.getSig();
        }
        return currNode;
    }

    @Override
    public String imprimeLista() {
        String listaStr = "";
        Nodo<Lavadora> currNode = first;
        while (currNode != null) {
            listaStr += currNode.getInfo().toString() + " --> ";
            currNode = currNode.getSig();
        }
        listaStr += "null";
        return listaStr;
    }

    @Override
    public void vaciarLista() {
        first = null;
        last = null;
    }
    public void modificaLavadora(int folio) {
        Nodo<Lavadora> nodo = busSecuencial(folio);
        if (nodo == null) {
            Tools.imprimeMsje("No se encontró una lavadora con el folio " + folio);
            return;
        }

        Lavadora lavadora = nodo.getInfo();
        boolean salir = false;
        do {
            int opcion = Tools.leerInt("Elige una opción:\n" +
                    "1. Modificar marca (actual: " + lavadora.getMarca() + ")\n" +
                    "2. Modificar potencia (actual: " + lavadora.getPotencia() + ")\n" +
                    "3. Modificar precio (actual: " + lavadora.getPrecio() + ")\n" +
                    "4. Modificar agua caliente (actual: " + lavadora.isAguaCaliente() + ")\n" +
                    "5. Salir");

            switch (opcion) {
                case 1:
                    String nuevaMarca = Tools.leerString("Nueva marca: ");
                    lavadora.setMarca(nuevaMarca);
                    break;
                case 2:
                    double nuevaPotencia = Tools.leerDouble("Nueva potencia: ");
                    lavadora.setPotencia(nuevaPotencia);
                    break;
                case 3:
                    double nuevoPrecio = Tools.leerDouble("Nuevo precio: ");
                    lavadora.setPrecio(nuevoPrecio);
                    break;
                case 4:
                    boolean nuevoAguaCaliente = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "Tiene agua caliente?", Boolean.toString(lavadora.isAguaCaliente())));
                    lavadora.setAguaCaliente(nuevoAguaCaliente);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    Tools.imprimeMsje("Opción inválida");
                    break;
            }
        } while (!salir);

        Tools.imprimeMsje("La lavadora con folio " + folio + " ha sido modificada.");
    }




    private Nodo<Lavadora> dirAntes(Nodo<Lavadora> pos) {
        Nodo<Lavadora> currNode = first;
        while (currNode != null && currNode.getSig() != pos) {
            currNode = currNode.getSig();
        }
        return currNode;
    }
}
