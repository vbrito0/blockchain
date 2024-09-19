# Blockchain em Java

Este é um projeto simples de blockchain implementado em Java para fins educacionais. Ele demonstra como uma blockchain funciona, com funcionalidades como adicionar blocos, verificar a integridade da cadeia e calcular hashes para garantir a imutabilidade dos dados.

## Funcionalidades

- **Criação de uma Blockchain**: Implementa uma blockchain básica com blocos encadeados.
- **Adição de novos blocos**: Blocos podem ser adicionados contendo dados transacionais.
- **Validação da cadeia**: Verifica se a blockchain é válida, garantindo que os hashes de cada bloco estejam corretos.
- **Cálculo de Hash**: Utiliza o algoritmo SHA-256 para gerar um hash único para cada bloco.

## Estrutura do Projeto

O projeto é composto por três classes principais:

- `Main.java`: Ponto de entrada da aplicação. Aqui você cria a blockchain e testa suas funcionalidades.
- `Blockchain.java`: Implementa a lógica da blockchain, incluindo a adição de blocos e a verificação da validade da cadeia.
- `Block.java`: Representa um bloco individual na cadeia, armazenando informações como hash, hash anterior, dados e timestamp.

## Como Funciona

### 1. Criação da Blockchain

A blockchain é iniciada com a criação do "bloco gênesis", que é o primeiro bloco da cadeia. Este bloco tem um hash anterior definido como `0`, pois não há blocos anteriores.


```java
chain.add(createGenesisBlock());
````

### 2. Adição de Novos Blocos

Você pode adicionar blocos à blockchain passando dados (como transações). Cada novo bloco tem um hash único, que é calculado com base em seus dados e no hash do bloco anterior.

blockchain.addBlock("Transação 1: Victor pagou 10 moedas para João");

### 3. Cálculo de Hash

O hash de cada bloco é gerado usando o algoritmo SHA-256. O hash é um valor criptográfico único que depende dos dados do bloco e do hash do bloco anterior. Isso garante que, se qualquer dado for alterado, o hash também será, tornando a cadeia imutável.

```java
public String calculateHash() {
    String input = previousHash.concat(timeStamp.toString()).concat(data);
    return applySha256(input);
}
````

### 4. Verificação da Blockchain

A função isChainValid() percorre todos os blocos da blockchain e verifica se:

O hash de cada bloco é válido.
O hash anterior de cada bloco corresponde ao hash do bloco anterior.

```java
public boolean isChainValid() {
    for (int i = 1; i < chain.size(); i++) {
        // Verifica se o hash atual corresponde ao hash calculado
        if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
            return false;
        }
        // Verifica se o hash anterior está correto
        if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
            return false;
        }
    }
    return true;
}
````

Estrutura dos Blocos

Cada bloco contém os seguintes elementos:

**Hash**: Um identificador único gerado pelo algoritmo SHA-256.
**Hash Anterior**: O hash do bloco anterior na cadeia.
**Dados**: Informações transacionais (ou qualquer outro tipo de dado).
**Timestamp**: Data e hora em que o bloco foi criado.

Exemplo de criação de bloco:

```java
public Block(String data, String previousHash) {
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = LocalDateTime.now();
    this.hash = calculateHash(); // Calcula o hash baseado nos dados
}
````

Como Executar

Clonar o repositório:

```java
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
````

Compilar o projeto: Compile os arquivos Java utilizando sua IDE ou a linha de comando:

```java
javac blockchain/*.java
````

Executar a aplicação: Execute o arquivo Main.java para testar a blockchain:

```java
java blockchain.Main
````

Você verá a blockchain sendo impressa no console, com os hashes e dados de cada bloco.

Exemplo de Saída
yaml
Copy code
Blockchain:
-------------------
Hash: a3b1c3...
Hash Anterior: 0
Dados: Bloco Gênesis
Timestamp: 2024-09-14T14:05:55.123

-------------------
Hash: 8f2a1e...
Hash Anterior: a3b1c3...
Dados: Transação 1: Victor pagou 10 moedas para João
Timestamp: 2024-09-14T14:06:00.456

-------------------
Hash: 7d2f7b...
Hash Anterior: 8f2a1e...
Dados: Transação 2: João pagou 5 moedas para Maria
Timestamp: 2024-09-14T14:06:05.789

A blockchain é válida? true

Licença

Este projeto é de código aberto e está licenciado sob a MIT License.

perl

Este formato está pronto para ser utilizado como um arquivo `README.md` no GitHub, oferecendo uma estrutura clara e informativa sobre o projeto de blockchain em Java.
