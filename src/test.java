import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class test {
    @Test
    public void test()
    {
        String str = "oper01";
        try {
            //MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
            //信息摘要是安全的单向哈希函数，它接收 任意大小的数据，并输出固定长度的哈希值。
            //MessageDigest 对象开始被初始化。
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            //通过使用 update 方法处理数据
            //
            mDigest.update(str.getBytes());
            //调用 digest 方法之一完成哈希计算同时将Byte数组转换成16进制
            System.out.println(mDigest.digest().toString());
            System.out.println(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
