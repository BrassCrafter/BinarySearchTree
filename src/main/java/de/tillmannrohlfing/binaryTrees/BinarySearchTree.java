
package de.tillmannrohlfing.binaryTrees;

public class BinarySearchTree<ContentType extends ComparableContent<ContentType>> {
    private class BSTNode<CT extends ComparableContent<CT>> {

        private CT content;
        private BinarySearchTree<CT> left, right;

        public BSTNode(CT pContent) {
            this.content = pContent;
            left = new BinarySearchTree<CT>();
            right = new BinarySearchTree<CT>();
        }

    }

    private BSTNode<ContentType> node;

    public BinarySearchTree() {
        this.node = null;
    }

    public boolean isEmpty() {
        return this.node == null;
    }

    public ComparableContent<Integer> insert(ContentType pContent) {
        if (pContent != null) {
            if (isEmpty()) {
                this.node = new BSTNode<ContentType>(pContent);
            } else if (pContent.isLess(this.node.content)) {
                this.node.left.insert(pContent);
            } else if (pContent.isGreater(this.node.content)) {
                this.node.right.insert(pContent);
            }
        }
        return null;
    }

    public BinarySearchTree<ContentType> getLeftTree() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.node.left;
        }
    }

    public ContentType getContent() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.node.content;
        }
    }

    public BinarySearchTree<ContentType> getRightTree() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.node.right;
        }
    }

    public void remove(ContentType pContent) {
        if (isEmpty()) {
            return;
        }
        if (pContent.isLess(node.content)) {
            node.left.remove(pContent);
        } else if (pContent.isGreater(node.content)) {
            node.right.remove(pContent);
        } else {
            if (node.left.isEmpty()) {
                if (node.right.isEmpty()) {
                    node = null;
                } else {
                    node = getRightNode();
                }
            } else if (node.right.isEmpty()) {
                node = getLeftNode();
            } else {
                if (getRightNode().left.isEmpty()) {
                    node.content = getRightNode().content;
                    node.right = getRightNode().right;
                } else {
                    BinarySearchTree<ContentType> previous = node.right.ancestorOfSmallRight();
                    BinarySearchTree<ContentType> smallest = previous.node.left;
                    this.node.content = smallest.node.content;
                    previous.remove(smallest.node.content);
                }
            }
        }
    }

    public ContentType search(ContentType pContent) {
        if (this.isEmpty() || pContent == null) {
            return null;
        } else {
            ContentType content = this.getContent();
            if (pContent.isLess(content)) {
                return this.getLeftTree().search(pContent);
            } else if (pContent.isGreater(content)) {
                return this.getRightTree().search(pContent);
            } else if (pContent.isEqual(content)) {
                return content;
            } else {
                return null;
            }
        }
    }

    private BinarySearchTree<ContentType> ancestorOfSmallRight() {
        if (getLeftNode().left.isEmpty()) {
            return this;
        } else {
            return node.left.ancestorOfSmallRight();
        }
    }

    private BSTNode<ContentType> getLeftNode() {
        return node.left.node;
    }

    private BSTNode<ContentType> getRightNode() {
        return node.right.node;
    }
}
