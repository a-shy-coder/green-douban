package team.sdguys.test;

import team.sdguys.util.MD5Util;

/**
 * 测试 MD5 工具类
 */
public class MD5EncodingTest {
    public static void main(String[] args) {
        String str = "1285929172shy";
        String result = MD5Util.MD5Encode(str,"UTF-8",true);
        System.out.println(result);

        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        System.out.println(s);
    }
}
