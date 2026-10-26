package chapter04.Algorithm_Analysis;

public class DisjointSet {

    /** Returns true if the is no element common to all three arrays.
     * Three sets A,B,C, stored in three different integer arrays, assuming that
     * no individual set contains duplicates value. */

    /** The three-way set disjointness problem is to determine if the intersection
     * of the three sets is empty, namely, that there is no element x such that
     *  x belongs to A, x belongs to B and x belongs to C. Code Fragment 4.5*/
    // time complexity cubic - O(n^3)
    public static boolean disjoint1(int [] groupA, int[] groupB, int[] groupC) {
         for (int a: groupA) {
             for(int b: groupB) {
                 for(int c: groupC) {
                     if((a == b ) && (b == c)) {
                         return false;                      // we found a common value
                     }
                 }
             }
         }
         return true;                                       // if we reach this, sets are disjoint
    }

    /** Returns true if there is no element common to all three arrays. */
    // improved version with time complexity - quadratic O(n^2)
    public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
        for(int a: groupA) {
            for(int b : groupB) {
                if (a == b) {                        // only check C when we find match from a and B
                    for(int c: groupC) {
                        if(a == c) {                  // and thus b==c as well
                            return false;             // we found a common value
                        }
                    }
                }
            }
        }
        return true;                                  // if we reach this, sets are disjoint
    }

    // main
    public static void main(String[] args) {

        // first function disjoint1
        int[] A = {1, 2, 3};
        int[] B = {2, 5, 8};
        int[] C = {4, 9, 2};

        // second function disjoint2
        int[] groupA = { 9, 7,5};
        int[] groupB = {4, 13, 12};
        int[] groupC = {100, 102, 103};

        boolean result = disjoint1(A,B, C);
        System.out.println("Sets A, B, C are not disjoint: " + result);

        boolean result2 = disjoint2(groupA, groupB, groupC);
        System.out.println("Sets groupA, groupB, groupC are disjoint: " + result2);
    }
}
