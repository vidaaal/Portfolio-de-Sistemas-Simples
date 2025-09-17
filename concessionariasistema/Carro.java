package garagem;

public class Carro {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private double valor;
    private double desconto; 

    public Carro(String marca, String modelo, int ano, double valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    public Carro(int id, String marca, String modelo, int ano, double valor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }

    public int getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public double getValor() { return valor; }

    public void setId(int id) { this.id = id; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAno(int ano) { this.ano = ano; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return id + ": " + marca + " " + modelo + " (" + ano + ") - Valor: R$ " + valor;
    }
}
