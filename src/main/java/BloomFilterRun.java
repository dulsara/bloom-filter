import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BloomFilterRun {

    static Logger logger = Logger.getLogger(BloomFilterRun.class.getName());

    public static void main(String[] args)
    {

        List<String> algoList = Arrays.asList("MD5","SHA-512","SHA","SHA-256");
        BloomFilter<String> bloomFilter = new BloomFilter<>(1000000,algoList);

        String fileName = "src/main/resources/dictionary.txt";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(s-> bloomFilter.add(s));

        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info(" Words count " + bloomFilter.getSize());
        logger.info(" check the availability Contain word Dulsara: " + bloomFilter.mightContain("Dulsara"));
        logger.info(" check the availability Contain word zygosphene (word in dic) : " + bloomFilter.mightContain("zygosphene"));


    }
}
