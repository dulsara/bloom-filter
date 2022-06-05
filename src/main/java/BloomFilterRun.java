import java.util.*;

public class BloomFilterRun {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bloom Filter Test\n");

        System.out.println("Enter set capacity and key size");

        List<String> algoList = Arrays.asList("MD5","SHA-512","SHA","SHA-512/224","MD2","SHA-256");
        BloomFilter<String> bloomFilter = new BloomFilter<>(1000,algoList);
//        bloomFilterNew.add("Dulsara");
//        bloomFilterNew.showArray();
//        bloomFilterNew.add("Manupriyal");
//        bloomFilterNew.showArray();
//        bloomFilterNew.add("Prinsi");
//        bloomFilterNew.showArray();
//        bloomFilterNew.add("Prabodha");
//        bloomFilterNew.showArray();
        bloomFilter.add("Prinsi Prabodha");
        bloomFilter.showArray();
//
//        ;

//        String fileName = "src/main/resources/dictionary.txt";
//        Calendar t = Calendar.getInstance();
//        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
//
//            stream.forEach(s-> bloomFilterNew.add(s));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Calendar t2 = Calendar.getInstance();
//
//        System.out.println("Start Time " + t.getTime());
//        System.out.println("End Time " + t2.getTime());
//        System.out.println("Size of the filter  " + bloomFilterNew.getSize());


//        bloomFilterNew.showArray();
        System.out.println(bloomFilter.mightContain("Dulsara Manupriyal"));
        System.out.println( bloomFilter.mightContain("Prinsi Prabodha"));

    }
}
