import de.tillmannrohlfing.util.Patient;
import de.tillmannrohlfing.binaryTrees.BinarySearchTree;


public class Testklasse {


  BinarySearchTree<Patient> baum;
  
  public Testklasse(int n)  {
    baum = new BinarySearchTree<Patient>();
    fuellen(n);
    System.out.println("Preorder: " + preorder(baum));
    System.out.println("Inorder: " + inorder(baum));
    System.out.println("Postorder: " + postorder(baum));
    System.out.println("Tiefe: " + depth(baum));
    System.out.println("Anzahl: " + count(baum));
  }
  
  private void fuellen(int n){
    char zeichen = 'A';
    for (int i = 0; i<n ;i++ )
      baum.insert(new Patient ((int)(Math.random()*100) , "Patient"+(zeichen++)) );
  }
  
  private String preorder(BinarySearchTree<Patient> pBaum) {
    if(pBaum.isEmpty() || null == pBaum)return "";
    String patient = pBaum.getContent().toString();
    String left = preorder(pBaum.getLeftTree());
    String right = preorder(pBaum.getRightTree());
    return patient + left + right;
  }
  
  private String inorder(BinarySearchTree<Patient> pBaum) {
    if(pBaum.isEmpty() || null == pBaum)return "";
    String patient = pBaum.getContent().toString();
    String left = inorder(pBaum.getLeftTree());
    String right = inorder(pBaum.getRightTree());
    return left + patient + right;
  }
  
  private String postorder(BinarySearchTree<Patient> pBaum) {
    if(pBaum.isEmpty() || null == pBaum)return "";
    String patient = pBaum.getContent().toString();
    String left = postorder(pBaum.getLeftTree());
    String right = postorder(pBaum.getRightTree());
    return left + right + patient;
  }
  
  private int depth (BinarySearchTree<Patient> pBaum) {
    if(pBaum.isEmpty() || null == pBaum)return -1;
    int left  = depth(pBaum.getLeftTree()) + 1;
    int right = depth(pBaum.getRightTree()) + 1;
    if(left>= right)return left;
    return right;
  }
  
  private int count (BinarySearchTree<Patient> pBaum) {
    if(pBaum.isEmpty() || null == pBaum)return 0;
    return 1 + count(pBaum.getLeftTree()) + count(pBaum.getRightTree());
  }

}

