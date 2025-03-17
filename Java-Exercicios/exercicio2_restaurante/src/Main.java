import java.util.ArrayList;

class Prato {
    private String nome;
    private double preco;
    private String descricao;

    public Prato(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}

class Pedido {
    private int numeroPedido;
    private String cliente;
    private ArrayList<Prato> listaDePratos;
    private double total;

    public Pedido(int numeroPedido, String cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.listaDePratos = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarPrato(Prato prato) {
        listaDePratos.add(prato);
        total += prato.getPreco();
    }

    public void visualizarPedido() {
        System.out.println("Pedido #" + numeroPedido + " - Cliente: " + cliente);
        System.out.println("Pratos no pedido:");
        for (Prato prato : listaDePratos) {
            System.out.println("- " + prato.getNome() + " (" + prato.getDescricao() + ") - R$ " + prato.getPreco());
        }
        System.out.println("Total: R$ " + total);
    }
}

class Restaurante {
    private ArrayList<Prato> cardapio;

    public Restaurante() {
        this.cardapio = new ArrayList<>();
    }

    public void adicionarPratoAoCardapio(Prato prato) {
        cardapio.add(prato);
        System.out.println("Prato adicionado ao cardápio: " + prato.getNome());
    }

    public void removerPratoDoCardapio(Prato prato) {
        cardapio.remove(prato);
        System.out.println("Prato removido do cardápio: " + prato.getNome());
    }

    public void exibirCardapio() {
        System.out.println("\n--- Cardápio ---");
        for (Prato prato : cardapio) {
            System.out.println(prato.getNome() + " - R$ " + prato.getPreco() + " (" + prato.getDescricao() + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Pedidos do Restaurante rodando!");

        Restaurante restaurante = new Restaurante();

        // Criando pratos
        Prato prato1 = new Prato("Pizza", 40.0, "Pizza de queijo com borda recheada");
        Prato prato2 = new Prato("Hambúrguer", 25.0, "Hambúrguer artesanal com batatas");
        Prato prato3 = new Prato("Lasanha", 30.0, "Lasanha de carne com molho especial");

        // Adicionando pratos ao cardápio
        restaurante.adicionarPratoAoCardapio(prato1);
        restaurante.adicionarPratoAoCardapio(prato2);
        restaurante.adicionarPratoAoCardapio(prato3);

        // Exibindo o cardápio
        restaurante.exibirCardapio();

        // Criando um pedido
        Pedido pedido1 = new Pedido(1, "Carlos Silva");
        pedido1.adicionarPrato(prato1);
        pedido1.adicionarPrato(prato3);

        // Exibir pedido
        System.out.println("\n--- Pedido Criado ---");
        pedido1.visualizarPedido();
    }
}
