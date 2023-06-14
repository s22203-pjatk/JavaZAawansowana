package pl.pjatk.TOMFID.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Pobierz wszystkie filmy")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found films",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Movie.class)) }),
            @ApiResponse(responseCode = "404", description = "Films not found",
                    content = @Content) })
    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> movies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @Operation(summary = "Dodaj nowy film")
    @PostMapping("/newMovie")
    public void newMovie(@RequestBody Movie movie) {
        movieService.newMovie(movie);
    }

    @Operation(summary = "Usuń film")
    @DeleteMapping("/delMovie/{movieId}")
    public void delMovie(@PathVariable("movieId") Long movieId) {
        movieService.delMovie(movieId);
    }

    @Operation(summary = "Zmień nazwę filmu lub kategorię")
    @PutMapping("/updateMovie/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMovie(
            @PathVariable("movieId") Long movieId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Category category) {
        movieService.updateMovie(movieId, name, category);
    }
}
