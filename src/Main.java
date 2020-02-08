import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");

        String fileName = "./input/d_quite_big.in";

        var arr = getPizzas(fileName);
//        System.out.println(Arrays.toString(arr));

        var solver = new Greedy(1_000_000_000, arr).getSolution();

        writeToFile("output", solver);

    }

    // read file get pizzas
    private static int[] getPizzas(String fileName) throws IOException {
        return Files.newBufferedReader(Paths.get(fileName))
                .lines()
                .skip(1)
                .map(it -> it.split(" "))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static void writeToFile(String filename, int[] arr) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));
        writer.write(arr.length +"\n");

        for(var s : arr){
            writer.write(s +" ");
        }

        writer.close();
    }
}
