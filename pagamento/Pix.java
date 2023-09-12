package pagamento;

// Classe de adaptador para pagamento por meio de PIX
public class Pix implements FormaPagamento {
  public void pagar() {
    System.out.println("Pagamento por meio de PIX.");
  }
}
