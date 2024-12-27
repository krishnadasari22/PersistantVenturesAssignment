package com.demo;

import java.util.ArrayList;
import java.util.List;

class User {
    String name;
    List<String> interests;

    User(String name, List<String> interests) {
        this.name = name;
        this.interests = interests;
    }
}

class Matchmaking {
    // Method to find the best match based on common interests
    public User findBestMatch(User user, List<User> potentialMatches) {
        User bestMatch = null;
        int maxCommonInterests = 0;

        for (User potentialMatch : potentialMatches) {
            int commonInterests = countCommonInterests(user.interests, potentialMatch.interests);
            if (commonInterests > maxCommonInterests) {
                maxCommonInterests = commonInterests;
                bestMatch = potentialMatch;
            }
        }

        return bestMatch;
    }

    // Helper method to count common interests
    private int countCommonInterests(List<String> interests1, List<String> interests2) {
        int count = 0;
        for (String interest : interests1) {
            if (interests2.contains(interest)) {
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> interests1 = new ArrayList<>();
        interests1.add("Music");
        interests1.add("Movies");
        interests1.add("Reading");

        List<String> interests2 = new ArrayList<>();
        interests2.add("Sports");
        interests2.add("Movies");
        interests2.add("Traveling");

        List<String> interests3 = new ArrayList<>();
        interests3.add("Reading");
        interests3.add("Cooking");
        interests3.add("Traveling");

        User user1 = new User("Alice", interests1);
        User user2 = new User("Bob", interests2);
        User user3 = new User("Charlie", interests3);

        List<User> potentialMatches = new ArrayList<>();
        potentialMatches.add(user2);
        potentialMatches.add(user3);

        Matchmaking matchmaking = new Matchmaking();
        User bestMatch = matchmaking.findBestMatch(user1, potentialMatches);

        if (bestMatch != null) {
            System.out.println("Best match for " + user1.name + " is " + bestMatch.name);
        } else {
            System.out.println("No suitable match found for " + user1.name);
        }
    }
}
