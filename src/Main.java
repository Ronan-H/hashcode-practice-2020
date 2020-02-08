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

//        String fileName = "./input/d_quite_big.in";
        String fileName = "./input/d_quite_big.in";

        var arr = getPizzas(fileName);
        var target = Files.newBufferedReader(Paths.get(fileName))
                .lines()
                .limit(1)
                .map(it -> it.split(" "))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .findFirst()
                .orElseGet(() ->0);
//        System.out.println(Arrays.toString(arr));

        var total = Arrays.stream(arr).sum();
        System.out.println(total);

        var solver = new DivideAndConquer(target, arr, 10).getSolution();

        System.out.println("Need: "+ target +" : "+ Arrays.stream(solver).sum());

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
