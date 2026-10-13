package fr.juliengrade.ludotheque.game;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GameRequest(
    @NotBlank @Size(max = 120) String title,
    @NotBlank @Size(max = 80) String genre,
    @Min(1) @Max(20) int minPlayers,
    @Min(1) @Max(20) int maxPlayers
) {
}