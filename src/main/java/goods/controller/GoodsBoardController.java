package goods.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import goods.bean.QnaDTO;
import goods.service.GoodsService;

@Controller
@RequestMapping(value="goods")
public class GoodsBoardController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping(value="qna", method=RequestMethod.GET)
	public String goodsDetail(@RequestParam String goods_id, Model model) {
		model.addAttribute("goods_id", goods_id);
		return "/goods/qna";
	}

	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String qnaWrite(@RequestParam Map<String, String> map, Model model) {
		//System.out.println(map);
		goodsService.qnaWrite(map);
		model.addAttribute("goods_id", map.get("goods_id"));
		return "/goods/goodsDetail";
	}
	

	@RequestMapping(value="getGoodsQnaList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getGoodsQnaList(@RequestParam String goods_id){
		List<QnaDTO> list = goodsService.getGoodsQnaList(goods_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="review", method=RequestMethod.GET)
	public String review(@RequestParam String goods_id, Model model, HttpSession session) {
		model.addAttribute("goods_id", goods_id);
		model.addAttribute("memEmail", session.getAttribute("memEmail"));
		return "/goods/review";
	}
	
	@RequestMapping(value="reviewWriteWin", method=RequestMethod.GET)
	public String reviewWrite(@RequestParam String goods_id, Model model) {
		model.addAttribute("goods_id", goods_id);
		System.out.println(goods_id);
		return "/goods/reviewWriteWin";
	}
	
	//드래그 해서 한번에 여러개의 파일을 선택
	@RequestMapping(value="reviewWrite", method=RequestMethod.POST)
	@ResponseBody
	public void reviewWrite(@ModelAttribute QnaDTO qnaDTO, @RequestParam("img[]") List<MultipartFile> list, HttpSession session) {
	//public void reviewWrite(@RequestParam Map<String, Integer> map, @RequestParam("img[]") List<MultipartFile> list) {
		
		//String filePath = "C:\\dev\\DOgNOR\\src\\main\\webapp\\image\\goods_board";
		String filePath = "C:\\Users\\bitcamp\\Desktop\\DOgNOR\\src\\main\\webapp\\image\\goods_board";

		for(MultipartFile img : list) {
			String fileName = img.getOriginalFilename(); //실제 파일명
			File file = new File(filePath, fileName);
			
			//2) 파일 복사
			try {
				FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file)); //copy(in, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//3) 디비 저장을 위해 파일명을 DTO에  넘겨줌
			qnaDTO.setImage(fileName);
		}//for
			
		qnaDTO.setEmail((String) session.getAttribute("memEmail"));
		System.out.println(qnaDTO);
		goodsService.reviewWrite(qnaDTO);
	
	}
	
	
	@RequestMapping(value="getGoodsReviewList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getGoodsReviewList(@RequestParam String goods_id){
		List<QnaDTO> list = goodsService.getGoodsReviewList(goods_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="writeReply", method=RequestMethod.POST)
	@ResponseBody
	public String writeReply(@RequestBody Map<String, String> map){
		goodsService.writeReply(map);
		System.out.println(map.get("goods_id"));
		return "/goods/qnaWrite";
	}
	
	@RequestMapping(value="replyList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView replyList(@RequestParam String bo_seq){
		List<QnaDTO> list = goodsService.replyList(bo_seq);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="reviewWin", method=RequestMethod.GET)
	public String reviewWin(@RequestParam String bo_seq, Model model) {
		model.addAttribute("bo_seq", bo_seq);
		return "/goods/reviewWin";
	}
	
	@RequestMapping(value="reviewView", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView reviewView(@RequestParam String bo_seq) {
		QnaDTO qnaDTO = goodsService.reviewView(bo_seq);
		ModelAndView mav = new ModelAndView();
		mav.addObject("qnaDTO", qnaDTO);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
}