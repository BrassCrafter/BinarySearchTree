import de.tillmannrohlfing.binaryTrees.BinarySearchTree;
import de.tillmannrohlfing.util.Number;
import de.tillmannrohlfing.util.List;

public class IntegerTestklasse {
    BinarySearchTree<Number> baum;
    List<Number> tiefstesElement;
    public static void main(String[] args) {
        IntegerTestklasse test = new IntegerTestklasse();

    }

    public IntegerTestklasse() {
        fillSearchTree();
        System.out.println("Preorder: " + preorder(baum));
        System.out.println("Inorder: " + inorder(baum));
        System.out.println("Postorder: " + postorder(baum));
        System.out.println("Tiefe: " + depth(baum));
        //System.out.println("Anzahl: " + count(baum));

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
}
