/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
 * Java program from a Hackerrank problem.
*/

import java.io.*;
import java.util.InputMismatchException;

public class MaximumPalindromes {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        palindromes solver = new palindromes();
        solver.solve(1, in, out);
        out.close();
    }

    static class palindromes {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String s = in.readString();
            int[][] qty = new int[s.length() + 1][26];
            for (int i = 0; i < s.length(); i++) {
                System.arraycopy(qty[i], 0, qty[i + 1], 0, 26);
                qty[i + 1][s.charAt(i) - 'a']++;
            }
            Combinations c = new Combinations(s.length() + 1, MiscUtils.MOD7);
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                int l = in.readInt() - 1;
                int r = in.readInt();
                int odd = 0;
                int total = 0;
                long answer = 1;
                for (int j = 0; j < 26; j++) {
                    int num = qty[r][j] - qty[l][j];
                    total += num >> 1;
                    answer *= c.c(total, num >> 1);
                    answer %= MiscUtils.MOD7;
                    odd += num & 1;
                }
                answer *= Math.max(1, odd);
                answer %= MiscUtils.MOD7;
                out.printLine(answer);
            }
        }

    }

    static class MiscUtils {
        public static final int MOD7 = (int) (1e9 + 7);

    }

    static class Combinations {
        private final long mod;
        private final long[] factorial;
        private final long[] reverseFactorial;

        public Combinations(int length, long mod) {
            this.mod = mod;
            factorial = IntegerUtils.generateFactorial(length, mod);
            reverseFactorial = IntegerUtils.generateReverseFactorials(length, mod);
        }

        public long c(int n, int k) {
            if (k < 0 || k > n) {
                return 0;
            }
            return factorial[n] * reverseFactorial[k] % mod * reverseFactorial[n - k] % mod;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void printLine(long i) {
            writer.println(i);
        }

    }

    static class IntegerUtils {
        public static long[] generateFactorial(int count, long module) {
            long[] result = new long[count];
            if (module == -1) {
                if (count != 0) {
                    result[0] = 1;
                }
                for (int i = 1; i < count; i++) {
                    result[i] = result[i - 1] * i;
                }
            } else {
                if (count != 0) {
                    result[0] = 1 % module;
                }
                for (int i = 1; i < count; i++) {
                    result[i] = (result[i - 1] * i) % module;
                }
            }
            return result;
        }

        public static long[] generateReverse(int upTo, long module) {
            long[] result = new long[upTo];
            if (upTo > 1) {
                result[1] = 1;
            }
            for (int i = 2; i < upTo; i++) {
                result[i] = (module - module / i * result[((int) (module % i))] % module) % module;
            }
            return result;
        }

        public static long[] generateReverseFactorials(int upTo, long module) {
            long[] result = generateReverse(upTo, module);
            if (upTo > 0) {
                result[0] = 1;
            }
            for (int i = 1; i < upTo; i++) {
                result[i] = result[i] * result[i - 1] % module;
            }
            return result;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

