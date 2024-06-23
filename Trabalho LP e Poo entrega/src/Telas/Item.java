package Telas;

public class Item {
    private String nome;
    private int valor;
    private int quantidade;

    public Item(String nome, int valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
