package pizza;

public class Margherita implements TipoPizza {
    @Override
    public String getNome() {
        return "Margherita";
    }

    @Override
    public double getPreco() {
        return 16.0;
    }

    @Override
    public void adicionarIngredientes(Pizza pizza) {
        Ingrediente queijo = new IngredienteImpl("Queijo", 2.0);
        Ingrediente tomate = new IngredienteImpl("Tomate", 1.0);
        pizza.adicionarIngrediente(queijo, 1);
        pizza.adicionarIngrediente(tomate, 1);
    }
}
