package pagamento;

// Classe de adaptador para pagamento em Vale Refeição
public class ValeRefeicao implements FormaPagamento {
  public void pagar() {
    System.out.println("Pagamento em Vale Refeição.");
  }
}
