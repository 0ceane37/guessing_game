package game.dto;

public class GuessRequest {
    private int guess;

    public GuessRequest() {}

    public GuessRequest(int guess) {
        this.guess = guess;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }
}