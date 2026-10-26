package chapter01.javaprimer;

import java.util.ArrayList;
import java.util.List;

/** A demonstration of java's wrapper types.
 *  Autoboxing and Unboxing: definition
 *  Autoboxing is the automatic conversion that Java compiler makes between the primitive types and their
 *  corresponding object wrapper classes. For example, converting an int to an Integer object,
 *  a double to a Double object, and so on. If the conversion goes the other way, this is called unboxing.
 *  The simples example of autoboxing: Character ch = 'a'; */

public class WrapperDemo {

    public static int sumEven(List<Integer> li) {
        int sum = 0;
        for (Integer i: li)
            // unboxing, operator % works only with primitive types, Integer -> int (unboxing) in run-time
            if (i.intValue() % 2 == 0)
                // unboxing, assignment operators(+=) works only with primitive types, in run-time
                sum += i.intValue();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("1.Boxing and unboxing classic way.");
        int primitiveValue = 10;

        // Manually boxing: int -> Integer
        Integer wrapperValue = Integer.valueOf(primitiveValue);

        // Manually unboxing: Integer -> int
        int result = wrapperValue.intValue();

        System.out.println("Primitive value: " + primitiveValue);
        System.out.println("Integer object : " + wrapperValue);
        System.out.println("After unboxing: " + result);

        System.out.println("\n2.Automatic conversion: Autoboxing si auto-boxing.");

        // autoboxing: int -> Integer
        Integer wrapperValue1 = 20;

        // auto-boxing: Integer -> int
        int primitiveValue1 = wrapperValue1;
        System.out.println("Object Integer: " + wrapperValue1);
        System.out.println("Int value: " + primitiveValue);

        System.out.println("\n3. List autoboxing.");

        List<Integer> li = new ArrayList<>();
        for(int i = 1; i < 50; i += 2) {

            // Autoboxing
            // li.add(Integer.valueOf(i));
            li.add(i);
        }
        System.out.println("List: " + li);

        /**
         *  Converting a primitive value (an int, for example) into an object of the corresponding wrapper class (Integer)
         * is called autoboxing. The Java compiler applies autoboxing when a primitive value is:
         Passed as a parameter to a method that expects an object of the corresponding wrapper class.
         Assigned to a variable of the corresponding wrapper class.*/

        System.out.println("\n4. Null problem.");

        Integer number = null;

        try {
            // Compiler is trying to convert int result = number.intValue(); (intValue is default)
            // result2 => NullPointerException at run-time
            int result2 = number;
            System.out.println(result2);
        } catch (NullPointerException e) {
            System.out.println("You cannot make an unboxing with an Integer that have value of null.");
        }
    }
}
