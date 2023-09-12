package pizza;

import java.util.*;
import pagamento.*;

public class SistemaPedidoPizza {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<Integer, Pizza> cardapio = new HashMap<>();

    Ingrediente queijo = new IngredienteImpl("Queijo", 2.0);
    Ingrediente tomate = new IngredienteImpl("Tomate", 1.0);
    Ingrediente calabresa = new IngredienteImpl("Calabresa", 3.0);
    Ingrediente frango = new IngredienteImpl("Frango", 3.5);

    Pizza margerita = new Pizza("Margerita", 15.0);
    margerita.adicionarIngrediente(queijo, 1);
    margerita.adicionarIngrediente(tomate, 1);

    Pizza calabresaPizza = new Pizza("Calabresa", 18.0);
    calabresaPizza.adicionarIngrediente(queijo, 1);
    calabresaPizza.adicionarIngrediente(calabresa, 1);

    Pizza frangoCatupiry = new Pizza("Frango Catupiry", 20.0);
    frangoCatupiry.adicionarIngrediente(queijo, 1);
    frangoCatupiry.adicionarIngrediente(frango, 1);

    cardapio.put(1, margerita);
    cardapio.put(2, calabresaPizza);
    cardapio.put(3, frangoCatupiry);

    Pizza pizzaSelecionada = null;
    boolean escolhaValida = false;

    System.out.println("Bem-vindo ao Sistema de Pedido de Pizza!");

    while (!escolhaValida) {
      System.out.println("Cardápio:");
      for (Map.Entry<Integer, Pizza> entry : cardapio.entrySet()) {
        int numeroPizza = entry.getKey();
        Pizza pizzaCardapio = entry.getValue();
        System.out.println(numeroPizza + ". " + pizzaCardapio.getNome() + " (R$" + pizzaCardapio.calcularPreco() + ")");
      }

      System.out.println("Escolha uma pizza pelo número: ");
      int escolhaPizza = scanner.nextInt();

      if (cardapio.containsKey(escolhaPizza)) {
        pizzaSelecionada = cardapio.get(escolhaPizza);
        escolhaValida = true;
      } else {
        System.out.println("Número de pizza não existe no cardápio, refaça sua escolha.");
      }
    }

    System.out.println("\nPizza selecionada: " + pizzaSelecionada.getNome());
    System.out.println("Ingredientes iniciais:");
    pizzaSelecionada.mostrarIngredientes();

    boolean continuarModificando = true;

    while (continuarModificando) {
      System.out.println("\nEscolha uma ação:");
      System.out.println("1 - Adicionar ingrediente");
      System.out.println("2 - Remover ingrediente");
      System.out.println("3 - Finalizar pedido");

      int escolhaAcao = scanner.nextInt();
      scanner.nextLine(); // Consumir a nova linha

      switch (escolhaAcao) {
        case 1:
          System.out.println("Ingredientes disponíveis:");
          System.out.println("1 - Queijo");
          System.out.println("2 - Tomate");
          System.out.println("3 - Calabresa");
          System.out.println("4 - Frango");
          int escolhaIngrediente = scanner.nextInt();
          scanner.nextLine(); // Consumir a nova linha

          Ingrediente ingredienteEscolhido = null;

          switch (escolhaIngrediente) {
            case 1:
              ingredienteEscolhido = queijo;
              break;
            case 2:
              ingredienteEscolhido = tomate;
              break;
            case 3:
              ingredienteEscolhido = calabresa;
              break;
            case 4:
              ingredienteEscolhido = frango;
              break;
            default:
              System.out.println("Ingrediente não existe.");
              break;
          }

          if (ingredienteEscolhido != null) {
            pizzaSelecionada.adicionarIngrediente(ingredienteEscolhido, 1);
            System.out.println(ingredienteEscolhido.getNome() + " adicionado à pizza.");
          }
          break;
        case 2:
          System.out.println("Ingredientes atuais:");
          pizzaSelecionada.mostrarIngredientes();
          System.out.println("Escolha o ingrediente a remover (pelo número):");
          int numeroIngrediente = scanner.nextInt();
          scanner.nextLine(); // Consumir a nova linha

          Ingrediente ingredienteARemover = null;

          for (Map.Entry<Ingrediente, Integer> entry : pizzaSelecionada.ingredientes.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            if (pizzaSelecionada.ingredientes.get(ingrediente) > 1 && numeroIngrediente > 1) {
              numeroIngrediente--;
            } else if (numeroIngrediente == 1) {
              ingredienteARemover = ingrediente;
              break;
            }
          }

          if (ingredienteARemover != null) {
            pizzaSelecionada.removerIngrediente(ingredienteARemover, 1);
            System.out.println(ingredienteARemover.getNome() + " removido da pizza.");
          } else {
            System.out.println("Ingrediente não encontrado na pizza.");
          }
          break;
        case 3:
          continuarModificando = false;
          break;
        default:
          System.out.println("Ação inválida.");
          break;
      }
    }

    System.out.println("\nResumo do pedido:");
    System.out.println("Pizza selecionada: " + pizzaSelecionada.getNome());
    System.out.println("Ingredientes finais:");
    pizzaSelecionada.mostrarIngredientes();
    System.out.println("Preço total: R$" + pizzaSelecionada.calcularPreco());

    // Escolha de forma de pagamento
    FormaPagamento formaPagamento = null;
    boolean escolhaValidaPagamento = false;

    while (!escolhaValidaPagamento) {
      System.out.println(
          "\nEscolha a forma de pagamento: \n1-Cartão de Crédito \n2-Dinheiro" +
              "\n3-Pix \n4-Vale Refeição");
      int escolhaPagamento = scanner.nextInt();
      scanner.nextLine();

      switch (escolhaPagamento) {
        case 1:
          formaPagamento = new CartaoCredito();
          escolhaValidaPagamento = true;
          break;
        case 2:
          formaPagamento = new Dinheiro();
          escolhaValidaPagamento = true;
          break;
        case 3:
          formaPagamento = new Pix();
          escolhaValidaPagamento = true;
          break;
        case 4:
          formaPagamento = new ValeRefeicao();
          escolhaValidaPagamento = true;
          break;
        default:
          System.out.println("A forma de pagamento selecionada não existe. Por favor, escolha novamente.");
          break;
      }
    }

    System.out.println("\n---- OBRIGADO POR UTILIZAR NOSSOS SERVIÇOS, VOLTE SEMPRE! ----");
  }
}
