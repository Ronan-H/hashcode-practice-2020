public abstract class Solver {
    private int target;
    private int[] pizzas;

    public Solver(int target, int[] pizzas) {
        this.target = target;
        this.pizzas = pizzas;
    }

    public abstract int[] getSolution();
}
