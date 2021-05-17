package com.hotelapp.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public int v1 = 10;
}

class TestChild extends Test{
    public int v1 = 30;
    public static void main(String[] args){
        TestChild tc = new TestChild();
        System.out.println("Child ref "+tc.v1);
        Test t = new TestChild();
        System.out.println("Parent ref "+t.v1);
    }
}

class TestStream{
    public static void main(String[] args) {
        /**/
        List<String> wordList = List.of("one", "two", "three", "four", "five", "six");
        String wordOutput1 = wordList.stream()
                .filter(word -> word.charAt(0) == 't')
                .collect(Collectors.joining(","));
        System.out.println(wordOutput1);
        List<String> mappedWords = wordList.stream()
                .map(word -> word + "Mapped")
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(mappedWords.toArray()));
        /**/
        List<Integer> list2 = List.of(1, 2, 2, 33, 1, 7_1, 90, 34, 1, 2, 6,44, 55, 33, 20, 93, 99, 45 );
        List<Integer> list3 = list2.stream()
                .distinct()
                .sorted()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(list3.toArray()));
        /**///java.util.function
        Predicate<String> predicate = word -> word.charAt(0) !='t';

        Predicate<String> predicate1 = String ->{
            return true;
        };

        System.out.println(predicate1.test("hello"));

        String wordOutput2 = wordList.stream()
                .filter(predicate)
                .collect(Collectors.joining(","));
        System.out.println(wordOutput2);

        Function<String, String> function = string -> string+"_f&m";

        Function<String, String> function1 = (string)->{
            return string;
        };

        System.out.println(function1.apply("hello world"));

        List<String> mappedWords2 = wordList.stream()
                .map(function)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(mappedWords2.toArray()));

    }
}

class Test3{

    public void method1(String firstName, String lastName, Consumer<String> callback){
        if(firstName != null && lastName != null)
            System.out.println(firstName+" "+lastName);
        else{
            callback.accept("Please provide all details");
        }
    }

    public static void main(String[] args) {
        Test3 t3 = new Test3();
        t3.method1("varun", null, word ->
                System.out.println("****Alert**** " +word));

    }
}

class Test4{
    public static void main(String[] args) {

        Test4 t4 = new Test4();
        Optional<String> word = Optional.ofNullable(t4.myMethod());
        word.ifPresentOrElse(System.out::println, ()-> System.out.println("world"));
    }

    public String myMethod(){
        return "Hello";
    }
}