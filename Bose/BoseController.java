/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.bose.web;

import java.util.List;

import egovframework.bose.service.BoseService;
import egovframework.bose.service.BoseDefaultVO;
import egovframework.bose.service.BoseVO;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.dsjdf.jdf.Logger;

/**
 * @Class Name : BoseController.java
 * @Description : Bose Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class BoseController {

	/** BoseService */
	@Resource(name = "boseService")
	private BoseService boseService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 BoseDefaultVO
	 * @param model
	 * @return "boseList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/boseList.do")
	public ModelAndView selectBoseList(@ModelAttribute("searchVO") BoseDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.bose */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> boseList = boseService.selectBoseList(searchVO);
		model.addAttribute("resultList", boseList);

		int totCnt = boseService.selectBoseListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		ModelAndView mv = new ModelAndView("egovframework/bose/boseList");
		return mv;
	}

	
	@RequestMapping(value = "/boseListAjax.do")
	public ModelAndView selectBoseListAjax(@ModelAttribute("data") BoseDefaultVO searchVO, ModelMap model) throws Exception {

		
		
		searchVO.setSearchId(searchVO.getSearchId()); // getter로 searchId값을 받아와서, 사용자가 입력한 값을 searchID로?



		
		/** EgovPropertyService.bose */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> boseList = boseService.selectBoseList(searchVO);
		model.addAttribute("resultList", boseList);

		int totCnt = boseService.selectBoseListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		ModelAndView mv = new ModelAndView("egovframework/bose/boseList");
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	
	/**
	 * 글을 조회한다.
	 * @param boseVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("boseVO") - 조회한 정보
	 * @exception Exception
	 */
	public BoseVO selectBose(BoseVO boseVO, @ModelAttribute("param") BoseDefaultVO searchVO) throws Exception {
		return boseService.selectBose(boseVO);
	}
	
	
	
	/**
	 * 글 수정화면을 조회한다.
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "boseRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateBoseView.do")
	public String updateBoseView(@RequestParam("selectedId") int id, @ModelAttribute("searchVO") BoseDefaultVO searchVO, Model model) throws Exception {
		BoseVO boseVO = new BoseVO();
		boseVO.setId(id);
		// 변수명은 CoC 에 따라 boseVO
		model.addAttribute(selectBose(boseVO, searchVO));
		return "egovframework/bose/boseRegister";
	}
	
	/**
	 * 글 수정화면을 조회한다.
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "boseRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateBoseViewAjax.do")
	public ModelAndView updateBoseViewAjax(@RequestParam("selectedId") int id, @ModelAttribute("searchVO") BoseDefaultVO searchVO, Model model) throws Exception {
		BoseVO boseVO = new BoseVO();
		boseVO.setId(id);
		
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("boseVO",selectBose(boseVO, searchVO));
		return mv;
	}
	
	
	
	/**
	 * 글을 수정한다.
	 * @param boseVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/boseList.do"
	 * @exception Exception
	 */
	@RequestMapping("/updateBose.do")
	public String updateBose(@ModelAttribute("searchVO") BoseDefaultVO searchVO, BoseVO boseVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(boseVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("boseVO", boseVO);
			return "egovframework/bose/boseRegister";
		}

		boseService.updateBose(boseVO);
		status.setComplete();
		return "forward:/boseList.do";
	}
	
	@RequestMapping("/updateBoseAjax.do")
	public ModelAndView updateBoseAjax(@ModelAttribute("searchVO") BoseDefaultVO searchVO, BoseVO boseVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(boseVO, bindingResult);

		if (bindingResult.hasErrors()) {
			
			ModelAndView mv = new ModelAndView("egovframework/bose/boseRegister");
			mv.addObject(boseVO);
			mv.setViewName("jsonView");
			return mv;

		}

		boseService.updateBose(boseVO);
		status.setComplete();
		ModelAndView mv = new ModelAndView("egovframework/bose/boseList");
		mv.addObject(boseVO);
		mv.setViewName("jsonView");
		return mv;
	}

	
	
	/**
	 * 글 등록 화면을 조회한다.
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "boseRegister"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addBoseView.do", method = RequestMethod.POST)
	public String addBoseView(@ModelAttribute("searchVO") BoseDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("boseVO", new BoseVO());
		return "egovframework/bose/boseRegister";
	}

	/**
	 * 글을 등록한다.
	 * @param boseVO - 등록할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/boseList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addBose.do", method = RequestMethod.POST)
	public String addBose(@ModelAttribute("searchVO") BoseDefaultVO searchVO, BoseVO boseVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		// Server-Side Validation
		beanValidator.validate(boseVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("boseVO", boseVO);
			return "egovframework/bose/boseRegister";
		}

		boseService.insertBose(boseVO);
		status.setComplete();
		return "forward:/boseList.do";
	}
	
	@RequestMapping(value = "/addBoseAjax.do", method = RequestMethod.POST)
	public ModelAndView addBoseAjax(@ModelAttribute("searchVO") BoseDefaultVO searchVO, BoseVO boseVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		// Server-Side Validation
		beanValidator.validate(boseVO, bindingResult);

		if (bindingResult.hasErrors()) {
			ModelAndView mv = new ModelAndView("egovframework/bose/boseRegister");
			mv.addObject(boseVO);
			mv.setViewName("jsonView");
			
			return mv;
		}

		boseService.insertBose(boseVO);
		status.setComplete();
		ModelAndView mv = new ModelAndView("egovframework/bose/boseList");
		mv.addObject(boseVO);
		mv.setViewName("jsonView");
		return mv;
	}






	/**
	 * 글을 삭제한다.
	 * @param boseVO - 삭제할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/boseList.do"
	 * @exception Exception
	 */
	@RequestMapping("/deleteBose.do")
	public String deleteBose(BoseVO boseVO, @ModelAttribute("searchVO") BoseDefaultVO searchVO, SessionStatus status) throws Exception {
		boseService.deleteBose(boseVO);
		status.setComplete();
		return "forward:/boseList.do";
	}
	
	@RequestMapping("/deleteBoseAjax.do")
	public ModelAndView deleteBoseAjax(BoseVO boseVO, @ModelAttribute("searchVO") BoseDefaultVO searchVO, SessionStatus status) throws Exception {
		boseService.deleteBose(boseVO);
		status.setComplete();
		
//		ModelAndView mv = new ModelAndView("jsonView");	
		ModelAndView mv = new ModelAndView("egovframework/bose/boseList");
		mv.addObject(boseVO);

		mv.setViewName("jsonView");
		return mv;
	}

}
