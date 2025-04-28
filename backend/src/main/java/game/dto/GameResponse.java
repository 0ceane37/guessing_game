package game.dto;

public class GameResponse {
    private String message;
    private boolean isCorrect;

    public GameResponse() {}

    public GameResponse(String message, boolean isCorrect) {
        this.message = message;
        this.isCorrect = isCorrect;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}