package fr.juliengrade.ludotheque.game;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 80)
    private String genre;

    @Column(nullable = false)
    private int minPlayers;

    @Column(nullable = false)
    private int maxPlayers;
        
    protected Game() {
    }

    public Game(String title, String genre, int minPlayers, int maxPlayers) {
    update(title, genre, minPlayers, maxPlayers);
    }

    public void update(String title, String genre, int minPlayers, int maxPlayers) {
        this.title = title;
        this.genre = genre;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }

    public Long getId() {
        return id;}

    public String getTitle() {
    return title;
    }

    public String getGenre() {
    return genre;
    }

    public int getMinPlayers() {
    return minPlayers;
    }
    
    public int getMaxPlayers() {
    return maxPlayers;
    }
    }