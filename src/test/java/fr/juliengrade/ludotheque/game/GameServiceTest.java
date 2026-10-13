package fr.juliengrade.ludotheque.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

class GameServiceTest {
    @Test
    void refusesInvertedPlayerRange() {
        GameRepository repository = mock(GameRepository.class);
        GameService service = new GameService(repository);
        GameRequest request = new GameRequest("Azul", "Stratégie", 5, 2);
        ResponseStatusException error = assertThrows(
                ResponseStatusException.class,
                () -> service.create(request));
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatusCode());
    }
}