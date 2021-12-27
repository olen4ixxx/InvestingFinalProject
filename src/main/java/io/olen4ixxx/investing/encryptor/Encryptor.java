package io.olen4ixxx.investing.encryptor;

public class Encryptor { // TODO: 22.12.2021  
    public static int encryptPassword(String password) {
        return password.hashCode();
    }
}
