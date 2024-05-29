package de.tillmannrohlfing.util;

import java.awt.*;
import javax.swing.*;
import de.tillmannrohlfing.binaryTrees.BinarySearchTree;



public class TreeDrawer {


         /**
  * Zeichnet den angegebenen Binärbaum rekursiv.
  *
  * @param tree Der zu zeichnende Binärbaum.
  * @param x Die X-Koordinate des Wurzelknotens.
  * @param y Die Y-Koordinate des Wurzelknotens.
  * @param g Die Zeichengrafik.
  */
         public static void drawTree(BinarySearchTree<Number> tree, int x, int y, int level, Graphics g) {
         if (tree.isEmpty()) {
         return;
         }

         // Zeichne den Knoten
         g.drawOval(x - 20, y - 15, 40, 30);
 g.drawString(tree.getContent().toString(), x - 10, y);

         // Berechne die Breite des aktuellen Subbaums
         int leftSubtreeWidth = calculateWidth(tree.getLeftTree());
         int rightSubtreeWidth = calculateWidth(tree.getRightTree());
         int totalWidth = leftSubtreeWidth + rightSubtreeWidth + 40; // Knotenbreite berücksichtigen

         // Berechne den horizontalen Abstand
         int offset = totalWidth / 2; // Mittenpositionierung

         // Zeichne die Verbindung zum linken Kind
         if (!tree.getLeftTree().isEmpty()) {
         g.drawLine(x, y, x - offset, y + 50);
 drawTree(tree.getLeftTree(), x - offset, y + 50, level + 1, g);
         }

         // Zeichne die Verbindung zum rechten Kind
         if (!tree.getRightTree().isEmpty()) {
         g.drawLine(x, y, x + offset, y + 50);
 drawTree(tree.getRightTree(), x + offset, y + 50, level + 1, g);
         }
         }


         // Hilfsfunktion zur Berechnung der Breite eines Subbaums
         private static int calculateWidth(BinarySearchTree<Number> tree) {
         if (tree.isEmpty()) {
         return 0;
         }

         return calculateWidth(tree.getLeftTree()) + calculateWidth(tree.getRightTree()) + 20; // Knotenbreite berücksichtigen
         }

         /**
  * Zeichnet den angegebenen Binärbaum in einem neuen Fenster.
  *
  * @param tree Der zu zeichnende Binärbaum.
  */
         public static void drawTreeInWindow(BinarySearchTree<Number> tree) {
         JFrame frame = new JFrame("Binärbaum");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Zeichne den Baum in einem Panel
         JPanel panel = new JPanel() {
         @Override
 protected void paintComponent(Graphics g) {
         super.paintComponent(g);
 drawTree(tree, getWidth() / 2, 50, 1, g);
         }
         };

         frame.add(panel);
 frame.pack();
 frame.setVisible(true);
 frame.setSize(1200, 800);
 }


         // Beispiel zur Verwendung
         public static void main(String[] args) {



         }
        }