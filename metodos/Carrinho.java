package metodos;

public class Carrinho {
    private int id;
    private char nome;
    private double preco;
    private int quantidade;


    public Carrinho(int id, char nome, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public char getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularValorItem() {
        return preco * quantidade;
    }
}

class CarrinhoComDesconto extends Carrinho {
    private double desconto;

    public CarrinhoComDesconto(int id, char nome, double preco, int quantidade, double desconto) {
        super(id, nome, preco, quantidade);
        this.desconto = desconto;
    }

    public double calcularValorItem() {
        int quantidade = 0;
        float preco = 319.99F;
        return (preco - (preco * desconto / 100)) * quantidade;
    }
}

class SistemaCompras {
    public double calcularTotalCarrinho(Carrinho[] carrinho) {
        double total = 0;
        for (Carrinho item : carrinho) {
            total += item.calcularValorItem(); // Polimorfismo em ação
        }
        return total;
    }
}

