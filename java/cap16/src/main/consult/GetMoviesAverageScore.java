package main.consult;

import infra.DAO;
import model.consult.MovieScore;

public class GetMoviesAverageScore {
  public static void main(String[] args) {

    DAO<MovieScore> dao = new DAO<>(MovieScore.class);
    MovieScore score = dao.consultOne("getMoviesAverageScore");

    System.out.println(score.getAverage());

    dao.close();
  }
}
