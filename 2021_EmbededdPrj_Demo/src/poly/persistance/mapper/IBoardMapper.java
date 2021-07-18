package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BoardDTO;

@Mapper("BoardMapper")
public interface IBoardMapper {
	// 매퍼에 게시판 넣기
	int setBoardList(BoardDTO pDTO) throws Exception;
	// 게시판 조회
	List<BoardDTO> getBoardList() throws Exception;
	// 게시판 상세 조회
	BoardDTO boardDetail(BoardDTO pDTO) throws Exception;
	// 게시판 삭제
	int boardDelete(BoardDTO pDTO) throws Exception;
	// 게시판 수정
	int boardUpdate(BoardDTO pDTO) throws Exception;
	
}
