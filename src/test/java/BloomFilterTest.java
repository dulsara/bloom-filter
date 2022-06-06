import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class BloomFilterTest {

    @Test
    void setEmpty() {
        List<String> algoList = Arrays.asList("MD5");
        BloomFilter<String> bloomFilter = new BloomFilter<>(100, algoList);
        bloomFilter.setEmpty();
        Assertions.assertEquals(0, bloomFilter.getSize(), "make Empty function test pass");
    }

    @Test
    void isEmpty() {
        List<String> algoList = Arrays.asList("MD5");
        BloomFilter<String> bloomFilter = new BloomFilter<>(100, algoList);
        Assertions.assertEquals(true, bloomFilter.isEmpty(), "Is Empty function test pass");
    }

    @Test
    void getSize() {
        List<String> algoList = Arrays.asList("MD5");
        BloomFilter<String> bloomFilter = new BloomFilter<>(100, algoList);
        bloomFilter.add("test");
        Assertions.assertEquals(1, bloomFilter.getSize(), "Get Size function test pass");
    }

    @Test
    void add() {
        List<String> algoList = Arrays.asList("MD5");
        BloomFilter<String> bloomFilter = new BloomFilter<>(100, algoList);
        bloomFilter.add("test");
        bloomFilter.add("test2");
        Assertions.assertEquals(2, bloomFilter.getSize(), "Add function test pass");
    }

    @Test
    void mightContain() {
        List<String> algoList = Arrays.asList("MD5");
        BloomFilter<String> bloomFilter = new BloomFilter<>(100, algoList);
        bloomFilter.add("test");
        bloomFilter.add("test2");
        Assertions.assertEquals(true, bloomFilter.mightContain("test"), "Might contain function test pass");
    }
}