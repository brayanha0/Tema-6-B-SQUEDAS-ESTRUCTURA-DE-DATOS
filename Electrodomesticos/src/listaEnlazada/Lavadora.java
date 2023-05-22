package listaEnlazada;

public class Lavadora extends Electrodomestico {
    private double precio;
    private boolean aguaCaliente;
    																								

    public Lavadora(String marca, double potencia) {
        super("Electrodomestico", marca, potencia);
        this.aguaCaliente = false;
    }

    public Lavadora(String marca, double precio, double potencia, boolean aguaCaliente) {
        super("Electrodomestico", marca, potencia);
        this.precio = precio;
        this.aguaCaliente = aguaCaliente;
    }

    public Lavadora(String marca, double potencia, double precio) {
        super("Electrodomestico", marca, potencia);
        this.precio = precio;
        this.aguaCaliente = false;
    }



    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isAguaCaliente() {
        return aguaCaliente;
    }

    public void setAguaCaliente(boolean aguaCaliente) {
        this.aguaCaliente = aguaCaliente;
    }

    @Override
    public double calcularConsumo(int horas) {
        if (aguaCaliente) {
            return horas * (getPotencia() + (getPotencia() * 0.20));
        } else {
            return horas * getPotencia();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Precio: " + precio + " Agua caliente: " + aguaCaliente;
    }
}

