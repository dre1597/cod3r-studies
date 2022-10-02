package main.consult;

import infra.DAO;
import model.manytomany.Actor;
import model.manytomany.Movie;

import java.util.List;

public class GetMovies {
  public static void main(String[] args) {
    DAO<Movie> dao = new DAO<>(Movie.class);
    List<Movie> movies = dao.consult("getMoviesByScore", "score", 8.5);

    for (Movie movie : movies) {
      System.out.println(movie.getName()
          + " => " + movie.getScore());

      for (Actor actor : movie.getActors()) {
        System.out.println(actor.getName());
      }
    }
  }
}
