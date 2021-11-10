package com.example.faculty.cipher;

public class MainCipher {

    // a123 f123
    //aaa mar
    private final static String PASSWORD = "Hi Grandma,\n" +
            "I am writing this letter to thank you for the chocolate chip cookies you sent\n" +
            "me. I got them this morning and I have already eaten half of the box! They\n" +
            "are absolutely delicious!\n" +
            "I wish you all the best. Love,\n" +
            "Your cookie-eater grandchild.";
    private final static String SECRETKEY = "fifi!fifi!!";

    public static String encryptMessage() {

        String encryptedString = AES.encrypt(PASSWORD, SECRETKEY);
        System.out.println("Original unique message is: " + PASSWORD);
        System.out.println("Encrypted unique message is: " + encryptedString);

        return encryptedString;

    }

    public static String decryptMessage() {

        String passwordToDecrypt = encryptMessage();
        String decryptedString = AES.decrypt(passwordToDecrypt, SECRETKEY);
        System.out.println("Decrypted unique message is: " + decryptedString);

        return decryptedString;

    }


    public static void main(String[] args) {
        encryptMessage();
        decryptMessage();
    }
}
