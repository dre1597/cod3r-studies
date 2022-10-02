package model.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double score;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "actors_movies",
      joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
  )
  private List<Actor> actors;

  public Movie() {

  }

  public Movie(String name, Double score) {
    this.name = name;
    this.score = score;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public List<Actor> getActors() {
    if (actors == null) {
      actors = new ArrayList<>();
    }
    return actors;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }

  public void addActor(Actor actor) {
    if (actor != null && !getActors().contains(actor)) {
      getActors().add(actor);

      if (!actor.getMovies().contains(this)) {
        actor.getMovies().add(this);
      }
    }
  }
}
