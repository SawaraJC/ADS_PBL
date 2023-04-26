package graphs;

import java.util.*;

class Graph {
    private final int V;
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph(int V) {
        this.V = V;
        adjacencyList = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public List<Integer> getFriends(int u) {
        return adjacencyList.get(u);
    }
}

class User {
    private final int id;
    private final String name;
    private final int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Ads {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        User u1 = new User(1, "Alice", 25);
        User u2 = new User(2, "Bob", 30);
        User u3 = new User(3, "Charlie", 35);
        User u4 = new User(4, "Dave", 40);
        User u5 = new User(5, "Eve", 45);

        List<Integer> aliceFriends = graph.getFriends(u1.getId());
        System.out.println(u1.getName() + "'s friends:");
        for (int friendId : aliceFriends) {
            User friend = getUserById(friendId);
            System.out.println(friend.getName() + ", " + friend.getAge() + " years old");
        }
    }

    public static User getUserById(int id) {
        switch (id) {
            case 1:
                return new User(1, "Alice", 25);
            case 2:
                return new User(2, "Bob", 30);
            case 3:
                return new User(3, "Charlie", 35);
            case 4:
                return new User(4, "Dave", 40);
            case 5:
                return new User(5, "Eve", 45);
            default:
                throw new IllegalArgumentException("Invalid user id");
        }
    }
}
