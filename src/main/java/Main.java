import segmenttree.StackOverflowSegmentTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kot on 07.11.14.
 */
public class Main {

    public Main() {

    }

    public static void main(String[] str) throws IOException, InterruptedException {

        int[] A = {1, 2, 3, 4, 5, 6, 7};

        StackOverflowSegmentTree.STNode tree = StackOverflowSegmentTree.constructSegmentTree(A, 0, A.length - 1);

        System.out.println(StackOverflowSegmentTree.getSum(tree, 1, 5));

//        DataInputStream a = new DataInputStream(new FileInputStream("asdfas"));

        MyAlgorithm my = MyAlgorithm.fromDataStorage(new File("/home/kot/datastorage"));

        Result rs = my.getSum(new Date(), new Date(), new ArrayList<>(), 100);





    }

    private static long doReallyLongThing(int times) {

        long y = 0;

        for (int i=0; i< times; i++) {
            y += i;
        }
        return y;

    }


    static class PrefixTree {

        private Node root = null;

        private class Node {

            private char key;
            private int value;

            private Node nextSibling = null;
            private Node child = null;

            public Node(char key, int value) {
                this.key = key;
                this.value = value;
            }
        }


        public void addString(String s) {

            Node _parent = this.root;




            if (this.root == null) {

            }

            for (int i=0; i < s.length(); i++ ) {

                while (_parent != null || _parent.key != s.charAt(i)) {
                    _parent = root.nextSibling;
                }
                if (_parent == null) {

                }



                System.out.println(s.charAt(i));
            }
        }


    }







}


