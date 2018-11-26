package com.mlamp.cotto;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.*;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.net.QCodec;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

public class CryptoTest {

    @Test
    public void test() {
        String input = "123456";
        String key = "1234567";
        long beginTime = System.currentTimeMillis();
        String s = HmacUtils.hmacMd5Hex(key, input);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - beginTime));
        System.out.println(s);
    }

    @Test
    public void test2() throws Exception {
        String str = "你好";
        String key = "key";
        URLCodec urlCodec = new URLCodec();
        String code = urlCodec.encode(str, CharEncoding.UTF_8);
        System.out.println(code);
        String data = urlCodec.decode(code, CharEncoding.UTF_8);
        System.out.println(data);

        QCodec qcodec = new QCodec();
        code = qcodec.encode(str, CharEncoding.UTF_8);
        System.out.println(code);
        data = qcodec.decode(code);
        System.out.println(data);

        BCodec bcodec = new BCodec();
        code = bcodec.encode(str, CharEncoding.UTF_8);
        System.out.println(code);
        data = bcodec.decode(code);
        System.out.println(data);


        System.out.println(DigestUtils.md5Hex(str));
        System.out.println(DigestUtils.md2Hex(str));
        System.out.println(DigestUtils.sha1Hex(str));
        System.out.println(DigestUtils.sha256Hex(str));
        System.out.println(DigestUtils.sha384Hex(str));
        System.out.println(DigestUtils.sha512Hex(str));
        System.out.println(DigestUtils.shaHex(str));


        System.out.println(Sha2Crypt.sha512Crypt(str.getBytes()));
        System.out.println(Sha2Crypt.sha512Crypt(str.getBytes()));
        System.out.println(Md5Crypt.md5Crypt(str.getBytes()));
        System.out.println(UnixCrypt.crypt(str.getBytes()));

        System.out.println(HmacUtils.hmacMd5Hex(key, str));
        System.out.println(HmacUtils.hmacSha1Hex(key, str));
        System.out.println(HmacUtils.hmacSha256Hex(key, str));
        System.out.println(HmacUtils.hmacSha384Hex(key, str));
        System.out.println(HmacUtils.hmacSha512Hex(key, str));

        System.out.println(Md5Crypt.apr1Crypt(str));
        System.out.println(Crypt.crypt(str));


        code = Base64.encodeBase64String(str.getBytes());
        System.out.println(Base64.isBase64(code));
        System.out.println(StringUtils.newStringUtf8(Base64.decodeBase64(code)));

        char[] chs = Hex.encodeHex(str.getBytes());
        System.out.println(chs);
        System.out.println(StringUtils.newStringUtf8(Hex.decodeHex(chs)));
        System.out.println("Hello World!");

    }
}
