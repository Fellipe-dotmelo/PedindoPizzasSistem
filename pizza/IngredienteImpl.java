package pizza;

// Classe para representar um ingrediente
public class IngredienteImpl implements Ingrediente {
  private final String nome;
  private final double preco;

  public IngredienteImpl(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public double getPreco() {
    return preco;
  }
}
