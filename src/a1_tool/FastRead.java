package a1_tool;

import java.io.*;
import java.util.StringTokenizer;

public class FastRead {
    // ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
    // ░░░░░░░░░░░░ FastReader 终极版 ░░░░░░░░░░░░
    // ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
    static class FastReader {
        BufferedReader br;    // 缓冲流，比Scanner快
        StringTokenizer st;   // 分割字符串工具

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine()); // 按行读取
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            return st.nextToken(); // 返回下一个token
        }

        int nextInt() { return Integer.parseInt(next()); }  // 自动转型
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }

        // 读取整行（适用于含空格的字符串输入）
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return str;
        }
    }
    // ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        long n = fr.nextLong();
        System.out.println(n);
    }

}
