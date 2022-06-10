import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BloomFilter<T> {

    private byte[] bitMap;
    private int setSize, size;
    private List<MessageDigest> messageDigestList = new ArrayList<MessageDigest>();

    Logger logger = Logger.getLogger(BloomFilter.class.getName());

    /* Constructor */
    public BloomFilter(int capacity, List<String> messageDigestList) {
        setSize = capacity;
        bitMap = new byte[setSize];
        size = 0;
        try {
            if (messageDigestList == null || messageDigestList.isEmpty()) {
                logger.info("Algorithm list can not be Empty");
                throw new Exception(" Algorithm list can not be Empty");
            } else {
                for (String algo : messageDigestList) {
                    this.messageDigestList.add(MessageDigest.getInstance(algo));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            logger.info("Error : Algorithm can not be identified");
            throw new IllegalArgumentException("Error : Algorithm can not be identified");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmpty() {
        bitMap = new byte[setSize];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private int getIndex(T value, MessageDigest messageDigest) {
        messageDigest.reset();
        byte[] bytes = ByteBuffer.allocate(4).putInt(value.hashCode()).array();
        messageDigest.update(bytes, 0, bytes.length);
        return Math.abs(new BigInteger(1, messageDigest.digest()).intValue()) % (bitMap.length);
        // Use folding on a string, summed 4 bytes at a time
    }

    public void add(T value) {
        int[] tempSet = getPositivePlacesInArray(value);
        for (int i : tempSet) {
            bitMap[i] = 1;
        }
        size++;
    }

    /* Function to check is an object is present */
    public boolean mightContain(T value) {
        int[] tempSet = getPositivePlacesInArray(value);
        for (int i : tempSet) {
            if (bitMap[i] != 1)
                return false;
        }
        return true;
    }

    private int[] getPositivePlacesInArray(T obj) {
        int[] tempSet = new int[this.messageDigestList.size()];

        for (int i = 0; i < messageDigestList.size(); i++) {
            tempSet[i] = getIndex(obj, messageDigestList.get(i));
        }
        return tempSet;
    }
}
