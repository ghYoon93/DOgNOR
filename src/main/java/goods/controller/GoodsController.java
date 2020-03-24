package goods.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import goods.bean.GoodsDTO;
import goods.service.GoodsService;

@Controller
@RequestMapping(value="goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="goodsList", method=RequestMethod.GET)
	public String goodsList(@RequestParam(required=false, defaultValue="1") String pg, Model model) {
		model.addAttribute("pg", pg);
		return "/goods/goodsList";
	}
	

	@RequestMapping(value="getGoodsList", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getGoodsList(@RequestParam(required=false, defaultValue="1") String pg){

		List<GoodsDTO> list = goodsService.getGoodsList(pg);
		System.out.println(list.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("pg", pg);
		mav.setViewName("jsonView");
		return mav;
	}
	
	@RequestMapping(value="goodsDetail", method=RequestMethod.GET)
	public String goodsDetail() {
		return "/goods/goodsDetail";
	}
	
	@RequestMapping(value="getGoodsDetail", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView getGoodsDetail(@RequestParam String goods_id){
		GoodsDTO goodsDTO = goodsService.getGoodsDetail(goods_id);
		System.out.println(goodsDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("goodsDTO", goodsDTO);
		mav.setViewName("jsonView");
		return mav;
	}


}
