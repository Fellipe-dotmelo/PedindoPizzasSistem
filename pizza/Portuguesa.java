package pizza;

public class Portuguesa extends Pizza {
    public Portuguesa() {
        super("Portuguesa", 19.0);
    }

    // Implementação dos métodos específicos da pizza Portuguesa
    public void adicionarPresunto() {
        Ingrediente presunto = new IngredienteImpl("Presunto", 2.5);
        adicionarIngrediente(presunto, 1);
    }

    public void adicionarOvos() {
        Ingrediente ovos = new IngredienteImpl("Ovos", 2.0);
        adicionarIngrediente(ovos, 2); // Vamos adicionar 2 ovos
    }

    public void adicionarAzeitonas() {
        Ingrediente azeitonas = new IngredienteImpl("Azeitonas", 1.0);
        adicionarIngrediente(azeitonas, 10); // Vamos adicionar 10 azeitonas
    }

    // Outros métodos específicos da pizza Portuguesa, se necessário
}

