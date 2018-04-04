// Java code for serialization and deserialization
// of a Java object

package serialization;
import java.io.*;

class Emp {
    static String name;

    // Default constructor
    Emp(String name, int age, int a, int b)
    {
        this.name = name;
    }

}

class EmpChild extends Emp {

    EmpChild(String name, int age, int a, int b) {
        super(name, age, a, b);
    }
}

public class SerialExample {
    private static void printdata(Emp object1)
    {

        System.out.println("name = " + object1.name);
//        System.out.println("age = " + object1.age);
//        System.out.println("a = " + object1.a);
//        System.out.println("b = " + Emp.b);
    }

    public static void main(String[] args)
    {
        Emp object = new Emp("ab", 20, 2, 1000);
        String filename = "hirendra.txt";

        // Serialization
        try {

            // Saving of object in a file
            FileOutputStream file = new FileOutputStream
                    (filename);
            ObjectOutputStream out = new ObjectOutputStream
                    (file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printdata(object);

            // value of static variable changed
            //Emp.b = 2000;
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        object = null;

        // Deserialization
        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream
                    (filename);
            ObjectInputStream in = new ObjectInputStream
                    (file);

            // Method for deserialization of object
            object = (Emp)in.readObject();

            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printdata(object);

            // System.out.println("z = " + object1.z);
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }
}