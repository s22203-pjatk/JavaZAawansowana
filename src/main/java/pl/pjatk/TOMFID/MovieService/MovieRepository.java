package pl.pjatk.TOMFID.MovieService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByName(String name);

    Optional<Movie> findMovieByID(Long ID);
}