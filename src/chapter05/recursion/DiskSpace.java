package chapter05.recursion;

import java.io.File;
import java.util.Scanner;

public class DiskSpace {

    /**
     * Calculates the total disk usage (in bytes) of the portion of the file system rooted
     * at given path, while printing a summary akin to the standard 'du' Unix tool.
     * @param root designates a location in the file system
     * @return total number of bytes used by the designated portion of the file system
     *
     * A recursive method for reporting disk usage of a file system. Code Fragment 5.5
     */

    public static long diskUsage(File root) {
        long total = root.length();                       // start with direct disk usage
        if(root.isDirectory()) {                          // and if this a directory,
            for(String childname : root.list()) {         // then for each child
                File child = new File(root, childname);   // compose full path to child
                total += diskUsage(child);                // add child's usage to total
            }
        }
        System.out.println(total + "\t" + root);          // descriptive output
        return total;                                     // return the grand total
    }

    // main
    public static void main(String[] args) {
        String start;
        if(args.length > 0) {
            start = args[0];
        } else {
            System.out.println("Enter the starting location: ");
            start = new Scanner(System.in).next();
        }
        diskUsage(new File(start));
    }
}
