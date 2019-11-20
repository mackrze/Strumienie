package kart_1;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException { //start main
        sum_1(10);
        int total = 0;
        //string pipeline tworzy strumien liczb od 1 do 10 i potem sum sumuje
        total = IntStream.rangeClosed(1, 10)
                .sum(); //redukcja, zamiana ciagu liczb na 1 wartosc, metoda terminalna, czyli konczy przetwarzanie
        total = IntStream
                .rangeClosed(1, 10)
                .map((x) -> {
                    return 2 * x;
                })
                .sum(); // redukcja, zamiana ciagu liczb na 1 wartosc
        int evenSum = IntStream
                .rangeClosed(1, 10)
                .filter(x -> x % 2 == 0)
                .sum();

        //inne metody
        //distinct
        //limit
        //sorted
        //foreach
        //average
        //reduce
        //min,max

        int[] data_1 = {6, 4, 3, 6, 2, 4, 11, 31, -5, 1, 1};
        double mean = IntStream
                .of(data_1)
                .average()
                .getAsDouble();
        int minValue = Arrays
                .stream(data_1)
                .min()
                .getAsInt();

        Arrays
                .stream(data_1)
                .forEach(System.out::println);//referencja do metody


        Integer[] data_2 = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        List<Integer> distinctValues = Arrays
                .stream(data_2)
                .distinct()
                .collect(Collectors.toList());

        Student[] students = {
                new Student("Adam", "Mucha", 4.5),
                new Student("Barbara", "Kosz", 3.5),
                new Student("Marek", "Tkacz", 3.8)
        };

        //wybrac studentow z ocenami w przedziale 3-4 i posortowac po nazwikach
        Arrays
                .stream(students)
                .filter(student -> student.getGpa() < 4 && student.getGpa() > 3)
                .sorted(Comparator.comparing(Student::getLastName))
                .forEach(System.out::println);


//zadanie_1 wyswietl tenisitow od 10 do 20 i sortuj po krjau

        ArrayList<TennisPlayer> players = new ArrayList<>(); //list of players
        BufferedReader Reader = new BufferedReader(new //reader
                FileReader("Tennis.txt"));
        String row;
        while ((row = Reader.readLine()) != null) { //while row in not empty
            String[] data = row.split("\t"); //split data
            int position = Integer.valueOf(data[0]);
            String[] nameAndSurname = data[2].split("\\s"); // name and surname
            String name = nameAndSurname[0];
            String surname = nameAndSurname[1];
            int age = Integer.valueOf(data[3]);
            int points = Integer.valueOf(data[4]);
            int championships = Integer.valueOf(data[5]);
            TennisPlayer tennisPlayer = new TennisPlayer(position, data[1], name,
                    surname, age, points, championships); //constructor
            players.add(tennisPlayer); //add to list
        }
        players
                .stream()
                .filter(e -> e.getPoints() >= 10 && e.getPosition() <= 20)
                .sorted(Comparator.comparing(TennisPlayer::getCountry))
                .forEach(System.out::println);

        SecureRandom secureRandom = new SecureRandom();
        secureRandom
                .ints(10, 1, 8)
                .forEach(System.out::println);
        String numbers = secureRandom
                .ints(5, 1, 8)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
// zadanie_2 zmierzyc czas wykonania 60 000 000 rzutow kostka za pomoca klasy securerandom i java.time instant i duration do zapamietania czasu przed i po uruchomieniu
        Instant instant_1=Instant.now();
     secureRandom
                .ints(60000000,1,8).average();
        System.out.println("czas");
        Instant instant_2=Instant.now();
        System.out.println(Duration.between(instant_1,instant_2).toNanos());



    } //end main

    public static int sum_1(int n) {//start sum_1
        int sum = 0;
        for (int i = 0; i <= n; i++)
            sum += i;
        return sum;
    }//end sum_1
}
