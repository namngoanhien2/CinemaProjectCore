package Service;

import Repo.RepoSeat;

public class SeatFindByShowTimeService {
    public String findByShowTime(int time){
        RepoSeat repoSeat = new RepoSeat();
        return repoSeat.FindBySeat(time);
    }
}
