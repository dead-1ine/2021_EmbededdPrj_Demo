package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.UserDTO;
import poly.service.IKakaoService;
import poly.service.IUserService;
import poly.service.impl.kakaoService;
import poly.util.CmmUtil;

/*
 * 예외처리를 컨트롤러로 모아서 처리하는 방식을 많이 사용한다고 한다.
 * 각 메서드 단위에서 try catch를 하는 방법이 가장 쉽고 일반적인 방법이나, 가독성이 떨어진다.
 * 컨트롤러 단에서 @ExceptionHandler 로 처리하는 방법도 있다.=> 앱 규모가 큰 곳에서는 사용하지 않는다고 함
 * 아래는 예외처리 예시를 보여 준 것으로 개인 개발할 때는 내가 예외를 잡지 않으니, thorws Exception하나로 
 * */ 
@Controller
public class UserController {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Resource(name = "UserService")
	private IUserService userService;
	@Resource(name = "kakaoSerivce")
	private IKakaoService kakaoService;
	
	// 도메인 입력하였을 때 기본으로 보여줄 페이지 
	@RequestMapping(value="index")
	public String Index() throws Exception{
		log.info(this.getClass().getName() +  "index Start!!");
		
		log.info(this.getClass().getName() + "index Start!!");
		
		return "/index";
	}
	// 로그인 화면 보여주는 페이지
	@RequestMapping(value="user/userLogin")
	public String userLogin(HttpServletRequest request, ModelMap model) throws Exception{
		
		log.info(this.getClass() + "user/userLogin start!!");
		
		log.info(this.getClass() + "user/userLogin end!!");
		
		return "/user/userLogin";
	}
	// 로그인 처리를 하는 처리 기능
	@RequestMapping(value="user/userLoginProc.do")
	public String userLoginProc(HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		log.info(this.getClass() + "user/userLoginProc start!!");
		
		String id = CmmUtil.nvl(request.getParameter("id"));
		log.info("id: " + id); // 데이터는 잘 받아온다.
		
		String pwd = CmmUtil.nvl(request.getParameter("pwd"));
		log.info("pwd: " + pwd); // 뭐가 문제냐
		
		UserDTO uDTO;
		uDTO = new UserDTO(); // DTO 메모리 올리고
		
		uDTO.setId(id);
		uDTO.setPwd(pwd);
		
		uDTO = userService.getLoginInfo(uDTO); //               
		
		log.info("uDTO null?" + (uDTO == null)); // null 발생? 20년 2월 27일 -> commit 안되서 에러 생김
		
		String msg = "";
		String url = "";
		
		if(uDTO == null) {
			msg = "로그인 실패";
			url = "/";
		} else {
			log.info("uDTO ID : " + uDTO.getId());
			log.info("uDTO PWD : " + uDTO.getPwd());
			log.info("uDTO NAME : " + uDTO.getName());
			
			msg = "로그인 성공";
			url = "/main/index.do";
			
			session.setAttribute("id", uDTO.getId());
			session.setAttribute("name", uDTO.getName());
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass() + "user/userLoginProc end!!");
		
		return "/user/redirect";
	}
	
	// 로그아웃 메서드
	@RequestMapping(value="user/logOut.do")
	public String logOut(HttpSession session, Model model) throws Exception{
		log.info(this.getClass() + "user/logOut start!!");

		String msg = "";
		String url = "";
		
		String accessToken = (String) session.getAttribute("kakaoToken");

		int res = kakaoService.kakaoLogOut(accessToken);
		log.info("accessToken : " + accessToken);
		
		if (res == 1) {
			log.info("res : " + res);
			
			msg = "로그아웃 성공";
			url = "/user/userLogin.do";
			session.invalidate(); // 세션 정보 초기화

			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
		} else {
			msg = "로그아웃 실패";
			url = "/";
		}
		log.info(this.getClass() + "user/loginOut end!!");
		
		return "/user/redirect";
	}
	// 로그인 성공 후 메인 페이지 보여주는 메서드
	@RequestMapping(value="main/index")
	public String mainIndex(HttpServletRequest request, ModelMap model) throws Exception{
		
		log.info(this.getClass() + "main/mainPage start!!");
		
		log.info(this.getClass() + "main/mainPage end!!");
		
		return "/main/index";
	}

}
