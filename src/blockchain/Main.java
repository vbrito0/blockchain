package blockchain;

/**
 * Classe principal para testar a blockchain.
 */
public class Main {

    public static void main(String[] args) {
        // Cria uma nova blockchain.
        Blockchain blockchain = new Blockchain();

        // Adiciona novos blocos à cadeia.
        blockchain.addBlock("Transação 1: Victor pagou 10 moedas para João");
        blockchain.addBlock("Transação 2: João pagou 5 moedas para Maria");

        // Imprime os dados da blockchain.
        System.out.println("Blockchain:");
        for (Block block : blockchain.getChain()) {
            System.out.println("-------------------");
            System.out.println("Hash: " + block.getHash());
            System.out.println("Hash Anterior: " + block.getPreviousHash());
            System.out.println("Dados: " + block.getData());
            System.out.println("Timestamp: " + block.getTimeStamp());
        }

        // Verifica se a cadeia é válida.
        System.out.println("\nA blockchain é válida? " + blockchain.isChainValid());
    }
}
