package Model;

import strategies.botPlayingStrategy.SimpleBotPlayingStrategy;

public class BotPlayer extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy playingStrategy;
    public BotPlayer(String name, Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = BotDifficultyLevel.EASY;
        this.playingStrategy = new SimpleBotPlayingStrategy();
        this.botDifficultyLevel = botDifficultyLevel;

    }
    @Override
    public Move makeMove(Board board) {
        return playingStrategy.makeMove(board, this);
    }

}
