import java.util.*;

interface Observable {
    public void addObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyObserver();
}

class RockstarGames implements Observable {

    public String releaseGame;

    private List<Observer> observers = new LinkedList<>();

    public void release(String game) {
        this.releaseGame = game;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(releaseGame);
        }
    }
}

interface Observer {
    public void update(String game);
}

class Gamer implements Observer {

    private String name;
    private String reaction;

    private Set<String> games = new HashSet<>();

    public Gamer(String name, String reaction) {
        this.reaction = reaction;
        this.name = name;
    }



    public void buyGame(String game) {
        games.add(game);
        System.out.println(name+" says: "+reaction);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void update(String game) {
        System.out.println("Inform message to : " + name);
        buyGame(game);
    }
}

/**
 * Main Class
 */

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        String game = null;


        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose", "I want to pre-order");
        Gamer peter = new Gamer("Peter Johnston", "Pinch me...");
        Gamer helen = new Gamer("Helen Jack", "Jesus, it's new game from Rockstar!");


        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);


        game = scanner.nextLine();
        System.out.println("It's happened! RockstarGames releases new game - " + game + "!");

        rockstarGames.release(game);

        scanner.close();
    }
}