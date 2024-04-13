package Model;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    public BotPlayer(String name, Symbol symbol) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = BotDifficultyLevel.EASY;
    }

}
