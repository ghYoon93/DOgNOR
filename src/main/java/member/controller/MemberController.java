package member.controller;

import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.regexp.internal.recompile;

import member.bean.MemberDTO;
import member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Inject
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@RequestMapping(value = "/sign_up/step1", method = RequestMethod.GET)
	public String step1(Model model) {
		model.addAttribute("step1");
		return "step1";
	}

	@RequestMapping(value = "/sign_up/emailYn", method = RequestMethod.GET)
	@ResponseBody
	public void emailYn(@RequestParam String email_Yn, HttpSession session) {
		System.out.println(email_Yn);
		if (email_Yn.equals("true")) {
			session.setAttribute("email_Yn", "Y");
		} else {
			session.setAttribute("email_Yn", "N");
		}
	}

	@RequestMapping(value = "/sign_up/step2", method = RequestMethod.GET)
	public ModelAndView step2() {
		ModelAndView mav = new ModelAndView();
		int random = new Random().nextInt(900000) + 100000;
		System.out.println("to step2 random = " + random);
		mav.addObject("random", random);
		mav.setViewName("step2");

		return mav;
	}

	@RequestMapping(value = "/sign_up/checkEmail", method = RequestMethod.POST)
	public @ResponseBody String checkEmail(@RequestParam String email, HttpSession session) {
		session.setAttribute("email", email);
		return memberService.checkEmail(email);
	}

	@RequestMapping(value = "/sign_up/authEmail", method = RequestMethod.GET)
	public @ResponseBody String authEmail(@RequestParam String authCode, @RequestParam String random,
			HttpSession session) {
		String originalJoinCode = (String) session.getAttribute("authCode");
		String originalRandom = String.valueOf(session.getAttribute("random"));
		if (originalJoinCode.equals(authCode) && originalRandom.equals(random))
			return "complete";
		else
			return "false";
	}

	@RequestMapping(value = "/sign_up/step3")
	public @ResponseBody ModelAndView step3(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("email", session.getAttribute("email"));
		mav.setViewName("step3");

		return mav;
	}

	@RequestMapping(value = "/sign_up/chkNickName", method = RequestMethod.POST)
	public @ResponseBody String chkNickName(@RequestParam String nickName) {
		String exist = memberService.chkNickName(nickName);
		return exist;
	}

	@RequestMapping(value = "/sign_up/sign", method = RequestMethod.POST)
	public @ResponseBody String sign(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		String encPwd = bcryptPasswordEncoder.encode(memberDTO.getPwd());
		memberDTO.setPwd(encPwd);

		memberDTO.setEmail_Yn((String) session.getAttribute("email_Yn"));

		System.out.println(memberDTO);
		String exist = memberService.sign(memberDTO);
		return exist;
	}

	@RequestMapping(value = "/sign_up/step4", method = RequestMethod.GET)
	public String step4(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("step4");
		return "step4";
	}

	@RequestMapping(value = "/login/login", method = RequestMethod.GET)
	public String loginform(Model model) {
		model.addAttribute("login");
		return "login";
	}

	@RequestMapping(value = "/login/log", method = RequestMethod.POST)
	public @ResponseBody String log(@RequestParam Map<String, String> map, MemberDTO memberDTO, HttpSession session) {
		String email = map.get("email");
		memberDTO = memberService.getMember(email);
		System.out.println(memberDTO);
		boolean chkPwd = bcryptPasswordEncoder.matches(map.get("pwd"), memberDTO.getPwd());
		System.out.println(chkPwd);
		if (chkPwd) {
			session.setAttribute("memEmail", email);
			return "true";
		} else {
			return "false";
		}
	}
	
	@RequestMapping(value = "/logout/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "../main/index";
	}
}
