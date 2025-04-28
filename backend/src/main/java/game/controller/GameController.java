package game.controller;

import org.springframework.web.bind.annotation.*;
import game.dto.GuessRequest;
import game.dto.GameResponse;
import org.springframework.http.ResponseEntity;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/game")
public class GameController {
    private final Random random = new Random();
    private int numberToGuess = random.nextInt(100) + 1;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Bienvenue dans le jeu de devinettes!");
    }

    @PostMapping("/verify")
    public ResponseEntity<GameResponse> verifyGuess(@RequestBody GuessRequest request) {
        int guess = request.getGuess();
        String message;
        boolean isCorrect = false;

        if (guess == numberToGuess) {
            message = "Bravo ! Vous avez trouvé !";
            isCorrect = true;
            numberToGuess = random.nextInt(100) + 1;
        } else if (guess < numberToGuess) {
            message = "C'est plus grand !";
        } else {
            message = "C'est plus petit !";
        }

        return ResponseEntity.ok(new GameResponse(message, isCorrect));
    }
}