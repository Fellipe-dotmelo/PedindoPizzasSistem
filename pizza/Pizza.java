package pizza;

import java.util.*;

// Classe para representar uma pizza
public class Pizza {
  protected Map<Ingrediente, Integer> ingredientes;
  protected double precoBase;
  protected String nome;
  protected pagamento.FormaPagamento formaPagamento; // Adicione a relação com FormaPagamento

  public Pizza(String nome, double precoBase) {
    this.nome = nome;
    this.precoBase = precoBase;
    ingredientes = new HashMap<>();
  }

  public void adicionarIngrediente(Ingrediente ingrediente, int quantidade) {
    int quantidadeAtual = ingredientes.getOrDefault(ingrediente, 0);
    ingredientes.put(ingrediente, quantidadeAtual + quantidade);
  }

  public void removerIngrediente(Ingrediente ingrediente, int quantidade) {
    int quantidadeAtual = ingredientes.getOrDefault(ingrediente, 0);
    if (quantidadeAtual >= quantidade) {
      ingredientes.put(ingrediente, quantidadeAtual - quantidade);
    }
  }

  public void mostrarIngredientes() {
    System.out.println("Ingredientes da pizza " + nome + ":");
    for (Map.Entry<Ingrediente, Integer> entry : ingredientes.entrySet()) {
      Ingrediente ingrediente = entry.getKey();
      int quantidade = entry.getValue();
      System.out.println(ingrediente.getNome() + ": " + quantidade);
    }
  }

  public double calcularPreco() {
    double precoTotal = precoBase;
    for (Map.Entry<Ingrediente, Integer> entry : ingredientes.entrySet()) {
      Ingrediente ingrediente = entry.getKey();
      int quantidade = entry.getValue();
      precoTotal += ingrediente.getPreco() * quantidade;
    }
    return precoTotal;
  }

  public String getNome() {
    return nome;
  }

  public void setFormaPagamento(pagamento.FormaPagamento formaPagamento) {
    this.formaPagamento = formaPagamento;
  }

  public void pagar() {
    if (formaPagamento != null) {
      formaPagamento.pagar();
    } else {
      System.out.println("Nenhuma forma de pagamento selecionada.");
    }
  }
}
