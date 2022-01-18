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
package egovframework.sujilee.web;

import java.util.List;

import egovframework.sujilee.service.EgovSujileeService;
import egovframework.sujilee.service.SujileeDefaultVO;
import egovframework.sujilee.service.SujileeVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import egovframework.sujilee.service.SujileeDefaultVO;
import egovframework.sujilee.service.SujileeVO;
import egovframework.sujilee.service.SujileeVO;

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
 * @Class Name : EgovSujileeController.java
 * @Description : EgovSujilee Controller Class
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
public class EgovSujileeController {

	/** EgovSujileeService */
	@Resource(name = "sujileeService")
	private EgovSujileeService sujileeService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 SujileeDefaultVO
	 * @param model
	 * @return "egovSujileeList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/egovSujileeList.do")
	public ModelAndView selectSujileeList(@ModelAttribute("searchVO") SujileeDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.sujilee */
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

		List<?> sujileeList = sujileeService.selectSujileeList(searchVO);
		model.addAttribute("resultList", sujileeList);

		int totCnt = sujileeService.selectSujileeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		ModelAndView mv = new ModelAndView("egovframework/sujilee/egovSujileeList");
		return mv;
	}

	
	@RequestMapping(value = "/egovSujileeListAjax.do")
	public ModelAndView selectSujileeListAjax(@ModelAttribute("data") SujileeDefaultVO searchVO, ModelMap model) throws Exception {

		/** EgovPropertyService.sujilee */
		//총 페이지 개수
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		//페이지블럭의 크기
		searchVO.setPageSize(propertiesService.getInt("pageSize"));
		

		/** pageing setting */
		//paginationInfo객체 생성
		PaginationInfo paginationInfo = new PaginationInfo();
		//현재 페이지
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		//한 페이지당 row 개수
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		//페이지블럭의 크기
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		
		System.out.println(paginationInfo.getPageSize());
		
		
		//
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		//
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		//한 페이지 당 row개수
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> sujileeList = sujileeService.selectSujileeList(searchVO);
		model.addAttribute("resultList", sujileeList);
		
		//row의 총 개수
		int totCnt = sujileeService.selectSujileeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		ModelAndView mv = new ModelAndView("egovframework/sujilee/egovSujileeList");
		mv.setViewName("jsonView");
		return mv;
	}
	
	
	/**
	 * 글을 조회한다.
	 * @param sujileeVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("sujileeVO") - 조회한 정보
	 * @exception Exception
	 */
	public SujileeVO selectSujilee(SujileeVO sujileeVO, @ModelAttribute("param") SujileeDefaultVO searchVO) throws Exception {
		return sujileeService.selectSujilee(sujileeVO);
	}
	
	

	
	/**
	 * 글 등록 화면을 조회한다.
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "egovSampleRegister"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addSujileeView.do", method = RequestMethod.POST)
	public String addSampleView(@ModelAttribute("searchVO") SujileeDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("sujileeVO", new SujileeVO());
		return "egovframework/sujilee/egovSujileeRegister";
	}

	/**
	 * 글을 등록한다.
	 * @param sujileekVO - 등록할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addSujilee.do", method = RequestMethod.POST)
	public String addSample(@ModelAttribute("searchVO") SujileeDefaultVO searchVO, SujileeVO sujileeVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		// Server-Side Validation
		beanValidator.validate(sujileeVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("sujileeVO", sujileeVO);
			return "egovframework/sujilee/egovframeRegister";
		}

		sujileeService.insertSujilee(sujileeVO);
		status.setComplete();
		return "forward:/egovSujileeList.do";
	}
	
    /**위 메소드를 위한 ajax 통신 */
	//js파일의 ajax함수에서 url자리로 매핑경로가 들어감
	@RequestMapping(value = "/addSujileeAjax.do", method = RequestMethod.POST)
	public ModelAndView addSampleAjax(@ModelAttribute("searchVO") SujileeDefaultVO searchVO, SujileeVO sujileeVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(sujileeVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("sujileeVO", sujileeVO);
			ModelAndView mv = new ModelAndView();
			mv.addObject(sujileeVO);
			mv.setViewName("jsonView");
			return mv;
		}

		sujileeService.insertSujilee(sujileeVO);
		status.setComplete();
		ModelAndView mv = new ModelAndView();
		mv.addObject(sujileeVO);
//		mv.addObject("result", "success");
		mv.setViewName("jsonView");
		return mv; //update가 되면 그 결과를 list 뷰에 뿌려주는?
	}

//	@RequestMapping(value = "/addSujileeAjax.do", method = RequestMethod.POST)
//	public ModelAndView addSampleAjax(@ModelAttribute("searchVO") SujileeDefaultVO searchVO, SujileeVO sujileeVO, BindingResult bindingResult, Model model, SessionStatus status)
//			throws Exception {
//
//		// Server-Side Validation
//		beanValidator.validate(sujileeVO, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("sujileeVO", sujileeVO);
//			ModelAndView mv = new ModelAndView("egovframework/sujilee/egovSujileeRegister");
//			mv.addObject(sujileeVO);
//			mv.setViewName("jsonView");
//			return mv;
//		}
//
//		sujileeService.insertSujilee(sujileeVO);
//		status.setComplete();
//		ModelAndView mav = new ModelAndView("egovframework/sujilee/egovSujileeList");
//		mav.addObject(sujileeVO);
//		mav.setViewName("jsonView");
//		return mav;
//	}
//	
	
	
	/**
	 * 글 수정화면을 조회한다. - 즉, id를 클릭했을 시 볼 수 있는 상세화면 조회를 위한 메소드
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "egovSujileeRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateSujileeView.do")
	public String updateSujileeView(@RequestParam("selectedId") String id, @ModelAttribute("searchVO") SujileeDefaultVO searchVO, Model model) throws Exception {
		SujileeVO sujileeVO = new SujileeVO();
		sujileeVO.setId(id);
		// 변수명은 CoC 에 따라 sujileeVO
		//sujileeVO라는 키에 sujileeVO와 searchVO를 벨류로 담아 View(jsp)에 넘겨줌 -> ${sujileeVO} 이렇게 쓰일것?
		model.addAttribute("sujileeVO", selectSujilee(sujileeVO, searchVO));
		return "egovframework/sujilee/egovSujileeRegister";
	}
	
	/**
	 * 글 수정화면을 조회한다. 
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "egovSujileeRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateSujileeViewAjax.do")
	public ModelAndView updateSujileeViewAjax(@RequestParam("selectedId") String id, @ModelAttribute("searchVO") SujileeDefaultVO searchVO, Model model) throws Exception {
		
		SujileeVO sujileeVO = new SujileeVO();
		sujileeVO.setId(id);
		
		sujileeService.updateSujilee(sujileeVO);
		ModelAndView mv = new ModelAndView("egovframework/sujilee/sujileeRegister");
		mv.addObject("sujileeVO",selectSujilee(sujileeVO, searchVO));
		mv.setViewName("jsonView");
		return mv;
	}
	
	/**
	 * 글을 수정한다. - 말그대로 수정 작업의 틀 메소드라고 생각하면 되려나? 수정하고, 뿌려주고.
	 * @param sujileeVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSujileeList.do"
	 * @exception Exception
	 */
	@RequestMapping("/updateSujilee.do")
	public String updateSujilee(@ModelAttribute("searchVO") SujileeDefaultVO searchVO, SujileeVO sujileeVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(sujileeVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("sujileeVO", sujileeVO);
			return "egovframework/sujilee/egovSujileeRegister";
		}

		sujileeService.updateSujilee(sujileeVO);
		status.setComplete();
		return "forward:/egovSujileeList.do"; //update가 되면 그 결과를 list 뷰에 뿌려주는?
	
	}
    /**위 메소드를 위한 ajax 통신 */
	//js파일의 ajax함수에서 url자리로 매핑경로가 들어감
	@RequestMapping("/updateSujileeAjax.do")
	public ModelAndView updateSujileeAjax(@ModelAttribute("searchVO") SujileeDefaultVO searchVO, SujileeVO sujileeVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(sujileeVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("sujileeVO", sujileeVO);
			ModelAndView mv = new ModelAndView();    //("/egovframework/sujilee/sujileeRegister");
			mv.addObject(sujileeVO);
			mv.setViewName("jsonView");
			return mv;
		}

		sujileeService.updateSujilee(sujileeVO);
		status.setComplete();
		ModelAndView mv = new ModelAndView();   //("/egovframework/sujilee/sujilee");
		mv.addObject(sujileeVO);
//		mv.addObject("result", "success");
		mv.setViewName("jsonView");
		return mv; //update가 되면 그 결과를 list 뷰에 뿌려주는?
	
	}



	/**
	 * 글을 삭제한다.
	 * @param sujileeVO - 삭제할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/egovSujileeList.do"
	 * @exception Exception
	 */
	@RequestMapping("/deleteSujilee.do")
	public String deleteSujilee(SujileeVO sujileeVO, @ModelAttribute("searchVO") SujileeDefaultVO searchVO, SessionStatus status) throws Exception {
		sujileeService.deleteSujilee(sujileeVO);
		status.setComplete();
		return "forward:/egovSujileeList.do";
	}
	
    /**위 메소드를 위한 ajax 통신 */
	//js파일의 ajax함수에서 url자리로 매핑경로가 들어감
	@RequestMapping("/deleteSujileeAjax.do")
	public ModelAndView deleteSujileeAjax(SujileeVO sujileeVO, @ModelAttribute("searchVO") SujileeDefaultVO searchVO, SessionStatus status) throws Exception {
		sujileeService.deleteSujilee(sujileeVO);
		status.setComplete();
		ModelAndView mv = new ModelAndView("egovframework/Sujilee/SujileeList");
		mv.addObject(sujileeVO);
//		mv.addObject("result", "success");
		mv.setViewName("jsonView");
		return mv;
	}

}