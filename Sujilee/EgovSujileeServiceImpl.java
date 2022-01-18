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
package egovframework.sujilee.service.impl;

import java.util.List;

import  egovframework.sujilee.service.EgovSujileeService;
import egovframework.sujilee.service.SujileeDefaultVO;
import egovframework.sujilee.service.SujileeVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovSujileeServiceImpl.java
 * @Description : Sujilee Business Implement Class
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

@Service("sujileeService")
public class EgovSujileeServiceImpl extends EgovAbstractServiceImpl implements EgovSujileeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSujileeServiceImpl.class);

	/** SujileeDAO */
	// TODO ibatis 사용
	@Resource(name = "sujileeDAO")
	private SujileeDAO sujileeDAO;
	// TODO mybatis 사용
	//  @Resource(name="sujileeMapper")
	//	private SujileeMapper sujileeDAO;

	/**
	 * 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SujileeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public String insertSujilee(SujileeVO vo) throws Exception {
		LOGGER.debug(vo.toString());
		//기존 여기에 있던 id="1" 고정값을 삭제해버림

		return sujileeDAO.insertSujilee(vo);
	
	}

	/**
	 * 글을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SujileeVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void updateSujilee(SujileeVO vo) throws Exception {
		sujileeDAO.updateSujilee(vo);
	}

	/**
	 * 글을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SujileeVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void deleteSujilee(SujileeVO vo) throws Exception {
		sujileeDAO.deleteSujilee(vo);
	}

	/**
	 * 글을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SujileeVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	@Override
	public SujileeVO selectSujilee(SujileeVO vo) throws Exception {
		SujileeVO resultVO = sujileeDAO.selectSujilee(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	@Override
	public List<?> selectSujileeList(SujileeDefaultVO searchVO) throws Exception {
		return sujileeDAO.selectSujileeList(searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception
	 */
	@Override
	public int selectSujileeListTotCnt(SujileeDefaultVO searchVO) {
		return sujileeDAO.selectSujileeListTotCnt(searchVO);
	}

}