package pagamento;

// Classe de adaptador para pagamento com Cartão de Crédito
public class CartaoCredito implements FormaPagamento {
  public void pagar() {
    System.out.println("Pagamento com Cartão de Crédito.");
  }
}
