package poly.service;

import java.util.List;

import poly.dto.BoardDTO;

public interface IBoardService {
	// 게시판 등록 
	int setBoardList(BoardDTO pDTO) throws Exception;
	// 게시판 등록
	List<BoardDTO> getBoardList() throws Exception;
	// 게시판 상세 보기
	BoardDTO boardDetail(BoardDTO pDTO) throws Exception;
	// 게시판 삭제
	int boardDelete(String user_id, String no) throws Exception;
	// 게시판 수정
	int boardUpdate(BoardDTO pDTO) throws Exception;

}
