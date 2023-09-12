package pizza;

public class Calabresa implements TipoPizza {
    @Override
    public String getNome() {
        return "Calabresa";
    }

    @Override
    public double getPreco() {
        return 18.0;
    }

    @Override
    public void adicionarIngredientes(Pizza pizza) {
        Ingrediente queijo = new IngredienteImpl("Queijo", 2.0);
        Ingrediente calabresa = new IngredienteImpl("Calabresa", 3.0);
        pizza.adicionarIngrediente(queijo, 1);
        pizza.adicionarIngrediente(calabresa, 1);
    }
}
