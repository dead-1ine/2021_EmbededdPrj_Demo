package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MailDTO;
import poly.service.IMailService;
import poly.util.CmmUtil;

@Controller
public class MailController {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Resource(name="MailService")
	IMailService mailService;
	
	// 메일 작성 페이지
	@RequestMapping(value="mail/mailPage")
	public String mailPage() throws Exception{
		log.info(this.getClass().getName() + "mailPage Start!!");
		log.info(this.getClass().getName() + "mailPage end!!");
		return "/mail/mailPage";
	}
	// 메일 전송 프로세스
	@RequestMapping(value="mail/sendMailProc")
	public String sendMailProc(HttpServletRequest request, ModelMap model) {
		log.info(this.getClass().getName() + "send Mail Proc Start!!");
		String title = CmmUtil.nvl(request.getParameter("title"));
		String email = CmmUtil.nvl(request.getParameter("email"));
		String contents = CmmUtil.nvl(request.getParameter("contents"));
		String msg = "";
		String url = "";
		
		log.info("title : " + title);
		log.info("email : " + email);
		log.info("contents : " + contents);
		
		MailDTO pDTO = new MailDTO();
		pDTO.setTitle(title);
		pDTO.setToMail(email);
		pDTO.setContents(contents);;
		
		int res = mailService.doSendMail(pDTO);
		pDTO = null;
		
		if(res == 1) {
			msg = "메일 발송 성공";
			url = "/main/index.do";
		} else {
			msg = "메일 발송 실패";
			url = "/mail/mailPage.do";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass().getName() + "send Mail Proc end!!");
		return "/user/redirect";
	}
	

}
