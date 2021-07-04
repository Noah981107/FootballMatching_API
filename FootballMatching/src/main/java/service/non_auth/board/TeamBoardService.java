package service.non_auth.board;

import domain.board.TeamBoard;

import java.util.List;

public interface TeamBoardService {
    List<TeamBoard> list();
    List<TeamBoard> findName(String teamName);
    List<TeamBoard> findWriter(String writer);
}
