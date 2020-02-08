public abstract class Solver {
    private int target;
    private int[] pizzas;

    public Solver(int target, int[] pizzas) {
        this.target = target;
        this.pizzas = pizzas;
    }

    public abstract int[] getSolution();

    public int getTarget() {
        return target;
    }

    public int[] getPizzas() {
        return pizzas;
    }

    public int numPizzas() {
        return getPizzas().length;
    }
}
