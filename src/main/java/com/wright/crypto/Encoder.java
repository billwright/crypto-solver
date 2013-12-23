package com.wright.crypto;

/**
 * @author Danny
 * @date 12/23/13 11:26 AM
 */
public class Encoder {

    public static String rotation(String plainText, int rotationNum) {
        String cipherText = "";
        plainText = plainText.toUpperCase();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (c < 'A' || c > 'Z') cipherText += c;
            else cipherText += (char) ((c + rotationNum - 'A') % ('Z' - 'A' + 1) + 'A');
        }

        return cipherText;
    }

}
