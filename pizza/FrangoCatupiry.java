package pizza;

public class FrangoCatupiry implements TipoPizza {
    @Override
    public String getNome() {
        return "Frango Catupiry";
    }

    @Override
    public double getPreco() {
        return 20.0;
    }

    @Override
    public void adicionarIngredientes(Pizza pizza) {
        Ingrediente queijo = new IngredienteImpl("Queijo", 2.0);
        Ingrediente frango = new IngredienteImpl("Frango", 3.5);
        pizza.adicionarIngrediente(queijo, 1);
        pizza.adicionarIngrediente(frango, 1);
    }
}
