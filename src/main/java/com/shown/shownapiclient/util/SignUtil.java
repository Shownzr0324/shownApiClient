package com.shown.shownapiclient.util;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtil {
    public static String genSign(String body,String secretKey){
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        return body + "." + digester.digestHex(secretKey);
    }
}
