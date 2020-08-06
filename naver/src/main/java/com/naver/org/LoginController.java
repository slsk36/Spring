package com.naver.org;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.naver.org.login.JsonParser;
import com.naver.org.login.NaverLoginBO;

@Controller
public class LoginController {
	
//	https://beam307.github.io/2017/11/28/naverlogin/
	
	@Autowired
	NaverLoginBO naverLoginBO;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView login(HttpSession session) {
//
//		return new ModelAndView("login/login", "key", "value");
//	}
	
	@RequestMapping(value = "/naverLogin", method = RequestMethod.GET)
	public ModelAndView naverLogin(HttpSession session) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		return new ModelAndView("login/naverLogin", "url", naverAuthUrl);
	}

	@RequestMapping(value = "/login/callback", method = RequestMethod.GET)
	public String callback(@RequestParam String code, @RequestParam String state, HttpSession session, Model model,
			UserVO vo) throws Exception {
		logger.info("naver login............");
		JsonParser json = new JsonParser();

		OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
		String apiResult = naverLoginBO.getUserProfile(oauthToken);
		vo = json.changeJson(apiResult); // vo�뿉 userEmail, userGender, userNaver ���옣

//		if (service.selectNaver(vo) > 0) { // �꽭�뀡留뚮뱾湲�
			session.setAttribute("login", vo);
//		} else {
//			service.insertNaver(vo);
//			session.setAttribute("login", vo);
//		}

		return "/login/callback";
	}
}
