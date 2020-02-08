import java.util.ArrayDeque;
import java.util.Deque;

public class DivideAndConquer extends Solver {
    private int chunkLinit;
    private int[] mapping;

    public DivideAndConquer(int target, int[] pizzas, int[] mapping, int chunkLimit) {
        super(target, pizzas);
        this.chunkLinit = chunkLimit;
        this.mapping = mapping;
    }

    public DivideAndConquer(int target, int[] pizzas, int chunkLimit) {
        super(target, pizzas);
        this.chunkLinit = chunkLimit;

        mapping = new int[pizzas.length];

        for (int i = 0; i < pizzas.length; i++) {
            mapping[i] = i;
        }
    }

    @Override
    public int[] getSolution() {
        if (numPizzas() > chunkLinit) {
            // divide
            int[][] subArrs = {
                    new int[(int) Math.ceil(numPizzas() / 2.0)],
                    new int[numPizzas() / 2],
            };

            int[][] mappings =  {
                    new int[(int) Math.ceil(numPizzas() / 2.0)],
                    new int[numPizzas() / 2],
            };

            for (int i = 0; i < numPizzas(); i++) {
                subArrs[i % 2][i / 2] = getPizzas()[i];
                mappings[i % 2][i / 2] = i;
            }

            int aTarget = (int) Math.ceil(getTarget() / 2.0);
            int bTarget = getTarget() / 2;

            DivideAndConquer[] divs = {
                    new DivideAndConquer(aTarget, subArrs[0], mappings[0], chunkLinit),
                    new DivideAndConquer(bTarget, subArrs[1], mappings[1],  chunkLinit)
            };

            int[][] sols = {
                    divs[0].getSolution(),
                    divs[1].getSolution(),
            };

            int[] slices = new int[sols[0].length + sols[1].length];

            int counter = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < sols[i].length; j++) {
                    slices[counter++] = divs[i].getMapping()[sols[i][j]];
                }
            }

            return slices;
        }
        else {
            return new Greedy(getTarget(), getPizzas()).getSolution();
        }
    }

    public int[] getMapping() {
        return mapping;
    }
}
