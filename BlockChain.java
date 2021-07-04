package blockchain;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * BlockChain 메인 클래스
 *
 * @author akageun
 */
public class BlockChain {

   public static List<Block> BLOCK_CHAIN = new LinkedList<>();

   public static int DIFFICULTY = 5; // 00000

   public static void main(String[] args) {

      BLOCK_CHAIN.add(new Block("Genesis Block", "0"));
      BLOCK_CHAIN.get(0).mineBlock();

      BLOCK_CHAIN.add(new Block("2nd", BLOCK_CHAIN.get(BLOCK_CHAIN.size() - 1).getHash()));
      BLOCK_CHAIN.get(1).mineBlock();

      BLOCK_CHAIN.add(new Block("3rd", BLOCK_CHAIN.get(BLOCK_CHAIN.size() - 1).getHash()));
      BLOCK_CHAIN.get(2).mineBlock();

      for (Block block : BLOCK_CHAIN) {
         System.out.println("nonce : " + block.getNonce());
         System.out.println("Data : " + block.getData());
         System.out.println("hash : " + block.getHash());
         System.out.println("previousHash : " + block.getPreviousHash());
         System.out.println();
      }
   }
}
