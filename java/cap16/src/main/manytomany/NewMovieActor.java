package main.manytomany;

import infra.DAO;
import model.manytomany.Actor;
import model.manytomany.Movie;

public class NewMovieActor {
  public static void main(String[] args) {

    Movie movieA = new Movie("Star Wars", 8.9);
    Movie movieB = new Movie("Spider Man", 8.1);

    Actor actorA = new Actor("Harrison Ford");
    Actor actorB = new Actor("Carrie Fisher");

    movieA.addActor(actorA);
    movieA.addActor(actorB);

    movieB.addActor(actorA);

    DAO<Movie> dao = new DAO<>();
    dao.atomicPersist(movieA);
  }
}
