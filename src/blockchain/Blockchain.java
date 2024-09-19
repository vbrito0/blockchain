package blockchain;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa a blockchain.
 */
public class Blockchain {

    private List<Block> chain;

    /**
     * Construtor da blockchain, que cria o bloco gênesis.
     */
    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock()); // Adiciona o primeiro bloco.
    }

    /**
     * Cria o primeiro bloco da cadeia, chamado de bloco gênesis.
     * @return O bloco gênesis.
     */
    private Block createGenesisBlock() {
        return new Block("Bloco Gênesis", "0"); // O primeiro bloco tem o hash anterior como "0".
    }

    /**
     * Obtém o último bloco da blockchain.
     * @return O último bloco.
     */
    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    /**
     * Adiciona um novo bloco à cadeia.
     * @param data - os dados do novo bloco.
     */
    public void addBlock(String data) {
        Block previousBlock = getLatestBlock();
        Block newBlock = new Block(data, previousBlock.getHash());
        chain.add(newBlock);
    }

    /**
     * Verifica se a blockchain é válida, comparando os hashes.
     * @return True se for válida, False caso contrário.
     */
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            // Verifica se o hash do bloco foi alterado.
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Bloco " + i + " teve seu hash alterado!");
                return false;
            }

            // Verifica se o hash do bloco anterior está correto.
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Bloco " + i + " está ligado ao bloco errado!");
                return false;
            }
        }
        return true;
    }

    public List<Block> getChain() {
        return chain;
    }
}
