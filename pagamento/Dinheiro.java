package pagamento;

// Classe de adaptador para pagamento em Dinheiro
public class Dinheiro implements FormaPagamento {
  public void pagar() {
    System.out.println("Pagamento em Dinheiro.");
  }
}
