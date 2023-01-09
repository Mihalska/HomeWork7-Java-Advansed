package task2;

import java.io.Serializable;

        public class Animal implements Serializable {
            public int weight = 5;
            private int age = 2;
            String colour = "black";

            public Animal() {
            }

            @Override
            public String toString() {
                return "Animal{" +
                        "weight=" + weight +
                        ", age=" + age +
                        ", colour='" + colour + '\'' +
                        '}';
            }

    }

