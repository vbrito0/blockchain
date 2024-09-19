package blockchain;

import java.security.MessageDigest;
import java.time.LocalDateTime;

/**
 * Classe que representa um bloco na blockchain.
 */
public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private LocalDateTime timeStamp;

    /**
     * Construtor para criar um bloco.
     * @param data - dados que o bloco contém.
     * @param previousHash - hash do bloco anterior.
     */
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = LocalDateTime.now();
        this.hash = calculateHash(); // Calcula o hash baseado nos dados.
    }

    /**
     * Calcula o hash do bloco usando SHA-256.
     * @return O hash calculado.
     */
    public String calculateHash() {
        String input = previousHash.concat(timeStamp.toString()).concat(data);
        return applySha256(input);
    }

    /**
     * Método para aplicar o algoritmo SHA-256 para gerar o hash.
     * @param input - os dados para os quais o hash será gerado.
     * @return O hash gerado como string.
     */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b)); // Converte bytes para string hexadecimal.
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
