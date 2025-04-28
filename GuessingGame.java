import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        
        System.out.println("Bienvenue dans le jeu de devinettes !");
        System.out.println("Devinez un nombre entre 1 et 100");
        
        while (true) {
            System.out.print("Votre proposition : ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess == numberToGuess) {
                System.out.println("Bravo ! Vous avez trouvé en " + attempts + " essais !");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("C'est plus grand !");
            } else {
                System.out.println("C'est plus petit !");
            }
        }
        scanner.close();
    }
}