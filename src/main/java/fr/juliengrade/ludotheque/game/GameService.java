package fr.juliengrade.ludotheque.game;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameService {
    private final GameRepository repository;

    public GameService(GameRepository repository) {
    this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<GameResponse> all() {
        return repository.findAll().stream().map(GameResponse::from).toList();
    }
    
    @Transactional(readOnly = true)
    public GameResponse one(Long id) {
        return GameResponse.from(find(id));
    }

    @Transactional
    public GameResponse create(GameRequest request) {
        checkPlayers(request);
        Game game = new Game(
            request.title(), request.genre(),
            request.minPlayers(), request.maxPlayers()
            );
            return GameResponse.from(repository.save(game));
        }

    @Transactional
    public GameResponse update(Long id, GameRequest request) {
        checkPlayers(request);
        Game game = find(id);
        game.update(
            request.title(), request.genre(),
            request.minPlayers(), request.maxPlayers()
        );
        return GameResponse.from(game);
    }
    
    @Transactional
    public void delete(Long id) {
        repository.delete(find(id));
    }

    private Game find(Long id) {
        return repository.findById(id).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Jeu introuvable")
        );
    }

    private void checkPlayers(GameRequest request) {
        if (request.minPlayers() > request.maxPlayers()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "minPlayers doit être inférieur ou égal à maxPlayers"
            );
        }
    }
}