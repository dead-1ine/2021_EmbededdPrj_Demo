package poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import poly.dto.BoardDTO;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService {

	private Logger log = Logger.getLogger(getClass());

	@Resource(name = "BoardMapper")
	private IBoardMapper boardMapper;

	// 게시판 등록
	@Override
	public int setBoardList(BoardDTO pDTO) throws Exception {
		log.info(this.getClass().getName() + "setBoardList Start!!");
		int res = 0;

		if (pDTO == null) {
			BoardDTO rDTO = new BoardDTO();
			log.info("DTO에 값이 없어 메모리에 강제로 올렸습니다." + rDTO);
			res = 0;
		} else {
			log.info("DTO 값 잘 넘오옴");
			res = boardMapper.setBoardList(pDTO);
			log.info("BoardList Mapper로 넘김");
		}
		log.info("DTO 작업 완료");

		log.info(this.getClass().getName() + "setBoardList END!!");
		return res;
	}

	// 게시판 조회
	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		log.info(this.getClass().getName() + "Service.getBoardList Start!!");

		List<BoardDTO> rList = new ArrayList<BoardDTO>();
		rList = boardMapper.getBoardList();

		if (rList == null) {
			rList = new ArrayList<BoardDTO>();
		} else {
			log.info("데이터베이스에서 이상없이 넘어옴");
		}

		log.info("게시판 불러오기 성공");

		log.info(this.getClass().getName() + "Service.getBoardList END!!");

		return rList;
	}

	// 게시판 상세 보기
	@Override
	public BoardDTO boardDetail(BoardDTO pDTO) throws Exception {
		log.info(this.getClass().getName() + "boardDetail Start!");
		BoardDTO rDTO = new BoardDTO();
		rDTO = boardMapper.boardDetail(pDTO);
		
		if(rDTO == null) {
			log.info("rDTO is null");
			rDTO = new BoardDTO();	
		}
		log.info(this.getClass().getName() + "boardDetail End!");

		return rDTO;
	}
	// 게시판 삭제
	@Override
	public int boardDelete(String user_id, String no) throws Exception {
		log.info(this.getClass().getName() + "boardDelete Start!");
		BoardDTO pDTO = new BoardDTO();
		pDTO.setReg_id(user_id); // 게시판 등록자와 현재 사용자를 비교허기 위해 현재 사용자 이이디를 넣음
		pDTO.setNo(no);
		int res = 0;
		
		res = boardMapper.boardDelete(pDTO);
		pDTO = null;
		
		if(res == 1) {
			log.info("게시판 삭제 성공");
		} else {
			log.info("게시판 삭제 실패");
		}
		
		log.info(this.getClass().getName() + "boardDelete End!");
		return res;
	}
	// 게시판 수정
	@Override
	public int boardUpdate(BoardDTO pDTO) throws Exception {
		log.info(this.getClass().getName() + "boardUpdate Start!!");
		int res = boardMapper.boardUpdate(pDTO);
		log.info("res : " + res);
		log.info(this.getClass().getName() + "boardUpdate End!!");
		return res;
	}

}
