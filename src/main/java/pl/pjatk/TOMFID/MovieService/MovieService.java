package pl.pjatk.TOMFID.MovieService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public void newMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByName(movie.getName());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("FILM SIE POWTARZA!");
        } else {
            movieRepository.save(movie);
        }
    }

    public void delMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("ID numer (" + movieId + ") nie istnieje");
        } else {
            movieRepository.deleteById(movieId);
        }
    }

    @Transactional
    public void updateMovie(Long movieId, String name, Category category) {
        Movie movie = movieRepository.findMovieByID(movieId).orElseThrow(
                () -> new IllegalStateException("ID numer (" + movieId + ") nie istnieje"));

        if (name != null && name.length() > 0 && !Objects.equals(movie.getName(), name)) {
            movie.setName(name);
        }

        if (category != null && !Objects.equals(movie.getCategory(), category)) {
            movie.setCategory(category);
        }

    }


//    public List<Movie> getAllMovies() {
//        return List.of(
//                new Movie("Batman", Category.ACTION),
//                new Movie("The ring", Category.HORROR),
//                new Movie("Avatar", Category.SCIFI)
//        );
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void allMyMovies() {
//        Movie movie1 = new Movie("Batman", Category.ACTION);
//        Movie movie2 = new Movie("Avatar", Category.SCIFI);
//        movieRepository.save(movie1);
//        movieRepository.save(movie2);
//    }
}
