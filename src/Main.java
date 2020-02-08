import java.io.BufferedReader;
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

        var arr = Files.newBufferedReader(Paths.get(fileName))
                .lines()
                .skip(1)
                .map(it -> it.split(" "))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::valueOf)
                .toArray();


        System.out.println(Arrays.toString(arr));

    }
}
