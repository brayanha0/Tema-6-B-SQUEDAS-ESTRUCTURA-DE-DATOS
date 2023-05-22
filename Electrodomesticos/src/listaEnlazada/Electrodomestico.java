package listaEnlazada;

public class Electrodomestico {
    public static int folio = 100;
    private String tipo;
    protected String marca;
    protected double potencia;

    
    
    public Electrodomestico(String tipo, String marca, double potencia) {
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
        folio++;
    }
    public Electrodomestico() {
        this.tipo = "";
        this.marca = "";
        this.potencia = 0.0;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public static int getFolio() {
        return folio;
    }

    public String toString() {
        return "Folio: " + folio + ", Tipo: " + tipo + ", Marca: " + marca + ", Potencia: " + potencia;
    }

    public double calcularConsumo(int horas) {
        return potencia * horas;
    }

    public double calcularCosteConsumo(int horas, double costeHora) {
        return potencia * horas * costeHora;
    }
}