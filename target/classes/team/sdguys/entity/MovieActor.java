package team.sdguys.entity;

/**
 * 电影演员实体类
 */
public class MovieActor {
    // 电影编号
    private int MovieId;
    // 演员编号
    private int ActorId;

    public MovieActor(int MovieId,int ActorId){
        this.ActorId = ActorId;
        this.MovieId = MovieId;

    }

    public int getMovieId() {
        return MovieId;
    }

    public void setMovieId(int movieId) {
        MovieId = movieId;
    }

    public int getActorId() {
        return ActorId;
    }

    public void setActorId(int actorId) {
        ActorId = actorId;
    }
}
