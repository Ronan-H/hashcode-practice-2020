import java.util.ArrayDeque;
import java.util.Deque;

public class BruteForce extends Solver {
    public BruteForce(int target, int[] pizzas) {
        super(target, pizzas);
    }

    @Override
    public int[] getSolution() {
        long totalPerms = (long) Math.pow(2, getPizzas().length);
        Deque<Integer> best = null;
        int mostSlices = -1;

        outer:
        for (int i = 0; i < totalPerms; i++) {
            char[] s = Long.toBinaryString(i).toCharArray();
            Deque<Integer> usedSlices = new ArrayDeque<>();
            int pizzaCounter = 0;
            int slices = 0;

            for (int j = s.length - 1; j >= 0; j--) {
                if (s[j] == '1') {
                    slices += getPizzas()[pizzaCounter];

                    if (slices > getTarget()) continue outer;

                    usedSlices.push(pizzaCounter);
                }

                pizzaCounter++;
            }

            if (slices > mostSlices) {
                best = usedSlices;
                mostSlices = slices;
            }
        }

        int index = 0;
        int[] sol = new int[best.size()];
        while (!best.isEmpty()) {
            sol[index++] = best.pop();
        }

        return sol;
    }
}
