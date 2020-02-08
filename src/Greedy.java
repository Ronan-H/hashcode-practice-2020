import java.util.ArrayDeque;
import java.util.Deque;

public class Greedy extends Solver {
    public Greedy(int target, int[] pizzas) {
        super(target, pizzas);
    }

    @Override
    public int[] getSolution() {
        int slices = 0;
        Deque<Integer> usedSlices = new ArrayDeque<Integer>();

        for (int i = getPizzas().length - 1; i >= 0; i--) {
            int slice = getPizzas()[i];
            if (slices + slice <= getTarget()) {
                slices += slice;
                usedSlices.push(i);
            }
        }

        int[] usedSlicesArr = new int[usedSlices.size()];

        int index = 0;
        while (!usedSlices.isEmpty()) {
            usedSlicesArr[index++] = usedSlices.pop();
        }

        return usedSlicesArr;
    }
}
