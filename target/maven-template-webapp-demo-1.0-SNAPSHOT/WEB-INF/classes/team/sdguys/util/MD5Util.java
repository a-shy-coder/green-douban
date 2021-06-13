package team.sdguys.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类,
 */
public class MD5Util {
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 对 source 字符串进行MD5加密, 加密成32为字符串
     * @param source 待加密的字符串
     * @param encoding 字符串的编码类型, 如UTF-8
     * @param uppercase 是否转换为大写字符串
     * @return 加密后的MD5字符串
     */
    public static String MD5Encode(String source, String encoding, boolean uppercase){
        try {
            // 获取 MD5 摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // 将待转换的字符串source, 使用指定字符集转换为字节数组, 并更新摘要信息
            messageDigest.update(source.getBytes(encoding));
            // messageDigest.digest() 进行 MD5 加密
            // 将 加密后的 字节数组 转换为 16进制字符串
            source = byteArrayToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return uppercase ? source.toUpperCase() : source;
    }


    /**
     * 将  转化为16进制字符串
     * @param bytes
     * @return 对应的16进制字符串
     */
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte i : bytes) {
            stringBuilder.append(byteToHexString(i));
        }
        return stringBuilder.toString();
    }

    /**
     * 将 byte类型的数字 转换为 16进制
     *
     * @param b 待转换的数字
     * @return 转换后的16进制数字
     */
    public static String byteToHexString(byte b) {
        int num = b;
        if (num < 0) {
            num += 256;
        }
        int d1 = num / 16;
        int d2 = num % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
