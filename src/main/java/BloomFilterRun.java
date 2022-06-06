import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class BloomFilterRun {
    public static void main(String[] args)
    {

        List<String> algoList = Arrays.asList("MD5","SHA-512","SHA","SHA-512/224","MD2","SHA-256");
        BloomFilter<String> bloomFilter = new BloomFilter<>(1500000,algoList);

        String fileName = "src/main/resources/dictionary.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(s-> bloomFilter.add(s));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bloomFilter.getSize());
        System.out.println(bloomFilter.mightContain("Dulsara Manupriyal"));
    }
}
