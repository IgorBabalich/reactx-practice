package app.a1;

import java.util.ArrayList;
import java.util.Scanner;

interface Observer {
    void update(String event);
}


public class ObserverDemo{

    final ArrayList<Observer> observers = new ArrayList<>();

    void subscribe(Observer observer) {
        observers.add(observer);
    }

    void notify(String event) {
        observers.forEach( observer -> observer.update(event));
    }

    public static void main(String[] args) {
        System.out.println("--> ObserverDemo.main()...");

        ObserverDemo app = new ObserverDemo();
        app.subscribe(event -> { System.out.println("> Obsever1: "+event);  });
        app.subscribe(event -> { System.out.println("> Obsever2: "+event);  });
        app.subscribe(event -> { System.out.println("> Obsever3: "+event);  });

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            app.notify(line);
        }
    }
}
