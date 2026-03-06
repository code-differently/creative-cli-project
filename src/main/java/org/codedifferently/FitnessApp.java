package org.codedifferently;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FitnessApp {
    public static void startApp(Scanner sc) {

    }

    public static Person getMaxKey(Map<Person, Integer> map) {
        int maxExercises = -1;
        Person maxPerson = null;

        for (Person person : map.keySet()) {
            if (map.get(person) > maxExercises) {
                maxExercises = map.get(person);
                maxPerson = person;
            }
        }

        return maxPerson;
    }

    public static ArrayList<Person> buildLeaderboard(Map<Person, Integer> map) {
        ArrayList<Person> leaderboard = new ArrayList<>();

        while (!map.isEmpty()) {
            Person maxPerson = getMaxKey(map);
            leaderboard.add(maxPerson);
            map.remove(maxPerson);
        }

        return leaderboard;
    }

    public static int countExercises(Person person) {
        int count = 0;

        for (Workout workout : person.getWorkouts()) {
            count += workout.getExercises().size();
        }

        return count;
    }

    public void displayLeaderboard(ArrayList<Person> people) {

        Map<Person, Integer> map = new LinkedHashMap<>();

        for (Person person : people) {
            int totalExercises = countExercises(person);
            map.put(person, totalExercises);
        }

        Map<Person, Integer> copy = new LinkedHashMap<>(map);

        ArrayList<Person> leaderboard = buildLeaderboard(copy);

        int rank = 1;

        for (Person person : leaderboard) {
            System.out.println(rank + ". " + person.getName() +
                    " completed " + map.get(person) + " exercises");
            rank++;
        }
    }
}
