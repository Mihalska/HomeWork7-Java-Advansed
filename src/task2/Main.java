package task2;


import java.io.*;

public class Main {
    public static void main(String[] args)  {
     File f = new File("C:\\Users\\Public\\Homework4.7\\src\\task2\\file.txt");
     Animal animal = new Animal();

    try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f) );
        ObjectInputStream ios = new ObjectInputStream(new FileInputStream(f));
        oos.writeObject(animal ) ;
        oos.flush() ;
        oos.close() ;
        Animal animal1 = (Animal)  ios.readObject() ;
        System.out.println(animal1 );
        ios.close() ;


    } catch (Exception e) {
        e.printStackTrace() ;
    }

    }
}
