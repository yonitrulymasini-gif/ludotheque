package fr.juliengrade.ludotheque.game;

public record GameResponse(
    Long id,
    String title,
    String genre,
    int minPlayers,
    int maxPlayers
) {

    public static GameResponse from(Game game) {
        return new GameResponse(
            game.getId(),
            game.getTitle(),
            game.getGenre(),
            game.getMinPlayers(),
            game.getMaxPlayers()
        );
    }
}