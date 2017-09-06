package MathBit;

/**
 * Created by Lenovo on 2017/9/5.
 */
public class HashFunction {

    public int hashCode(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0) return -1;

        long hashSum = 0;
        for (int i = 0; i < key.length; i++) {
            hashSum += key[i] * modPow(33, key.length - i - 1, HASH_SIZE);
            hashSum %= HASH_SIZE;
        }

        return (int)hashSum;
    }

    private long modPow(int base, int n, int mod) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return base % mod;
        } else if (n % 2 == 0) {
            long temp = modPow(base, n / 2, mod);
            return (temp % mod) * (temp % mod) % mod;
        } else {
            return (base % mod) * modPow(base, n - 1, mod) % mod;
        }
    }

    public int hashCode2(char[] key,int HASH_SIZE) {
        if (key == null || key.length == 0) return -1;

        long hashSum = 0;
        for (int i = 0; i < key.length; i++) {
            hashSum = 33 * hashSum + key[i];
            hashSum %= HASH_SIZE;
        }

        return (int)hashSum;
    }
}
