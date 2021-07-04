package blockchain;

import java.util.Arrays;

import java.util.Arrays;

public class Block {

   private String hash;
   private String previousHash;
   private String data;
   private int nonce;

   public String getPreviousHash() {
	   return previousHash;
   }
   
   public String getHash() {
	   return hash;
   }
   
   public String getData() {
	   return data;
   }
   
   public int getNonce() {
	   return nonce;
   }

   private Block() {

   }

   public Block(String data, String previousHash) {
      this.data = data;
      this.previousHash = previousHash;

      this.hash = calculateHash();
   }

   public String calculateHash() {
      return utils.generateHash(previousHash, Integer.toString(nonce), data);
   }

   public void mineBlock() {
      char[] targetChar = new char[BlockChain.DIFFICULTY];
      Arrays.fill(targetChar, '0');
      String target = String.valueOf(targetChar);

      while (hash.substring(0, BlockChain.DIFFICULTY).equals(target) == false) { // 00000���� �����ϴ��� �˻� 
         nonce++; // 00000���� ���� ���ϸ� nonce�� ���ϰ�
         hash = calculateHash(); // �ٽ� �ؽ�
      }
   }
}
