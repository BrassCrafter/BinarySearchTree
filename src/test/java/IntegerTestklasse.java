import com.sun.source.tree.Tree;
import de.tillmannrohlfing.binaryTrees.BinarySearchTree;
import de.tillmannrohlfing.util.Number;
import de.tillmannrohlfing.util.List;
import de.tillmannrohlfing.util.Patient;
import de.tillmannrohlfing.util.TreeDrawer;

public class IntegerTestklasse {
    BinarySearchTree<Number> baum;
    List<Number> tiefstesElement;
    public static void main(String[] args) {
        IntegerTestklasse test = new IntegerTestklasse();
    }


    public IntegerTestklasse() {
        fuellen(100);
        System.out.println("Preorder: " + preorder(baum));
        System.out.println("Inorder: " + inorder(baum));
        System.out.println("Postorder: " + postorder(baum));
        System.out.println("Tiefe: " + depth(baum));
        System.out.println("Balance: " + getBalanceFactor(baum));
        System.out.println("AveragePathLength: " + getAveragePathLength(baum));

        TreeDrawer.drawTreeInWindow(baum);
        //System.out.println("Anzahl: " + count(baum));

    }
    private void fuellen(int n){
        baum = new BinarySearchTree<>();
        for (int i = 0; i<n ;i++ ){
            Integer randomInt = (int)(Math.random()*10000);
            baum.insert(new Number(randomInt));
        }
    }

    public void fillSearchTree() {
        baum = new BinarySearchTree<>();
        Integer[] zahlen = {49, 23, 12, 38, 76, 65, 101, 130, 138, 133, 85, 58, 72, 42, 46, 32, 6, 44, 43, 45, 19};
        for (int i = 0; i < zahlen.length; i++)
            baum.insert(new Number(zahlen[i]));
    }
    public void printList(){

    }

    private String preorder(BinarySearchTree<Number> pBaum) {
        if (pBaum.isEmpty() || null == pBaum) return "";
        String number = pBaum.getContent().toString() + " ";
        String left = preorder(pBaum.getLeftTree());
        String right = preorder(pBaum.getRightTree());
        return number + left + right;
    }

    private String inorder(BinarySearchTree<Number> pBaum) {
        if (pBaum.isEmpty() || null == pBaum) return "";
        String number = pBaum.getContent().toString() + " ";
        String left = inorder(pBaum.getLeftTree());
        String right = inorder(pBaum.getRightTree());
        return left + number + right;
    }

    private String postorder(BinarySearchTree<Number> pBaum) {
        if (pBaum.isEmpty() || null == pBaum) return "";
        String number = pBaum.getContent().toString() + " ";
        String left = postorder(pBaum.getLeftTree());
        String right = postorder(pBaum.getRightTree());
        return left + right + number;
    }

    private int depth(BinarySearchTree<Number> pBaum) {
        if (pBaum.isEmpty() || null == pBaum) return -1;
        int left = depth(pBaum.getLeftTree()) + 1;
        int right = depth(pBaum.getRightTree()) + 1;
        if (left >= right) return left;
        return right;
    }
    public List<Number> getElementsOfLayer(int pLayer, BinarySearchTree<Number> pBaum){
        if(pBaum.isEmpty())
            return new List<>();
        if(0 == pLayer && !pBaum.isEmpty()){
            List<Number> element = new List<>();
            element.append(pBaum.getContent());
            return element;
        }
        List<Number> left = getElementsOfLayer(pLayer - 1, pBaum.getLeftTree());
        List<Number> right = getElementsOfLayer(pLayer - 1, pBaum.getRightTree());
        left.concat(right);
        return left;
    }
    public int getBalanceFactor(BinarySearchTree<Number> pTree){
        if(pTree.isEmpty())
            return 0;
        return depth(pTree.getRightTree()) - depth(pTree.getLeftTree());
    }
    public int getPathLengths(BinarySearchTree<Number> pTree, int layer){
        if(pTree.isEmpty())
            return 0;
        return getPathLengths(pTree.getLeftTree(), layer + 1) + getPathLengths(pTree.getRightTree(), layer + 1) + layer;
    }
    public int getSumOfNotes(BinarySearchTree<Number> pTree){
        if(pTree.isEmpty())
            return 0;
        return getSumOfNotes(pTree.getLeftTree()) + getSumOfNotes(pTree.getRightTree()) + 1;
    }
    public int getAveragePathLength(BinarySearchTree<Number> pTree){
        int pathLengths = getPathLengths(pTree, 0);
        int getSumOfNotes = getSumOfNotes(pTree);
        return pathLengths / getSumOfNotes;
    }

}
