import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main
{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        int n = A.length();

        int minCompressedLength = Integer.MAX_VALUE;

        for (int shiftCount = 0; shiftCount < n; shiftCount++) {
            int compressedLength = minCompressedLengthAfterShift(A, shiftCount);
            minCompressedLength = Math.min(minCompressedLength, compressedLength);
        }

        System.out.print(minCompressedLength);

        br.close();
    }
    public static int getCompressedLength(String str) {
        int compressedLength = 0;
        char prevChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == prevChar) {
                count++;
            } else {
                compressedLength += 1 + String.valueOf(count).length();
                prevChar = str.charAt(i);
                count = 1;
            }
        }
        compressedLength += 1 + String.valueOf(count).length();

        return compressedLength;
    }
    public static String rightShift(String str, int shiftCount) {
        int n = str.length();
        shiftCount %= n;
        str += str;
        return str.substring(n - shiftCount, 2 * n - shiftCount);
    }

    public static int minCompressedLengthAfterShift(String str, int shiftCount) {
        String shiftedStr = rightShift(str, shiftCount);
        return getCompressedLength(shiftedStr);
    }

}