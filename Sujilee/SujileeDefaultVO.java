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
package egovframework.sujilee.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : SujileeDefaultVO.java
 * @Description : SujileeDefaultVO Class
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
public class SujileeDefaultVO implements Serializable {

	/**
	 *  serialVersion UID
	 */
	private static final long serialVersionUID = -858838578081269359L;

	/** 검색조건 */
	private String searchCondition = "";

	/** 검색Keyword */
	private String searchKeyword = "";

	/** 검색사용여부 */
	private String searchUseYn = "";

	/** 현재페이지 */
	private int pageIndex = 1;

	/** 페이지갯수 */
	private int pageUnit = 10;

	/** 페이지사이즈 */
	private int pageSize = 5;

	/** firstIndex */
	private int firstIndex = 1;

	/** lastIndex */
	private int lastIndex = 1;

	/** recordCountPerPage */
	private int recordCountPerPage = 10;

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	
//	
//	 /**여기는 필드(attribute)선언 */
//
//    //현재 페이지 번호 - get/set
//    private int pageIdx;
//
//    //페이지 블럭의 시작 번호
//    private int firstIdx;
//
//    //페이지 블럭의 끝 번호
//    private int lastIdx;
//
//    //페이지 블럭의 범위  - get/set
//    private int blockSize = 5;
//    
//    //페이지 블럭의 인덱스 - get/set
//    private int blockIdx;
//
//    //한 페이지에 나열할 데이터 row의 개수
//    private int listSize = 10; //listPerPage
//
//    //총 게시물 row 개수
//    private int totListCnt;
//
//    //총 페이지 개수 - 수식으로 구함
//    private int totPageCnt;
//    
//	//다음 페이지블럭 여부
//	private boolean next;
//	
//	//이전 페이지블럭 여부 
//	private boolean prev;
//
//
//    /**여기는 메소드(게터 세터) 선언 */
//
//	//현재 페이지 번호
//	public int getPageIdx() {
//	    return pageIdx;
//	}
//	public void setPageIdx(int page) {
//	    this.pageIdx = page;
//	}
//	
//	//페이지 블럭의 범위
//	public int getBlockSize() {
//	    return blockSize;
//	}
//	public void setBlockSize(int blockSize) {
//		this.blockSize = blockSize;
//	}
//	
//	//페이지 블럭의 인덱스
//	public int getBlockIdx() {
//	    return blockIdx;
//	}
//	public void setBlockIdx(int blockIdx) {
//	    this.blockIdx = blockIdx;
//	}
//
//	//페이지 블럭의 시작 번호
//	public int getFirstIdx() {
//	    return firstIdx;
//	}
//	public void setFirstIdx(int firstIdx) {
//	    this.firstIdx = firstIdx;
//	}
//	
//	//페이지 블럭의 끝 번호
//	public int getLastIdx() {
//	    return lastIdx;
//	}
//	public void setLastIdx(int endIdx) {
//	    this.lastIdx = endIdx;
//	}
//
//	//이전 페이지 여부
//	public boolean isPrev() {
//	    return prev;
//	}
//	public void setPrev(boolean prev) {
//	    this.prev = prev;
//	}
//	
//	//다음 페이지 여부
//	public boolean isNext() {
//	    return next;
//	}
//	public void setNext(boolean next) {
//	    this.next = next;
//	}
//
//	//한 페이지 당 보여질 row 개수
//	public int getListSize() {
//	    return listSize;
//	}
//	public void setListSize(int listSize) {
//	    this.listSize = listSize;
//	}
//
//	//총  row 개수
//	public int getTotListCnt() {
//	    return totListCnt;
//	}
//	public void setTotListCnt(int totListCnt) {
//	    this.totListCnt = totListCnt;
//	}
//	
//	
//	/**그외 추가 메소드*/
//	//전체 페이지 수
//	public void pageInfo(int pageIdx, int blockIdx, int totListCnt) {
//		
//		this.pageIdx = pageIdx;
//		this.blockIdx = blockIdx;
//		this.totListCnt = totListCnt;
//		
//		//총 페이지 수 : ex) 7 = ceil(66/10)
//		this.totPageCnt = (int)Math.ceil(totListCnt/listSize);
//		
//		//시작 페이지
//		this.firstIdx = (blockIdx - 1) * blockSize + 1;
//		
//		//끝 페이지
//		this.lastIdx = blockIdx * blockSize;
//		//여기서 만약 총 페이지 개수가 blockSize의 배수가 아닐 경우도 고려해야함
//		
//		//이전 버튼
//		this.prev = blockIdx == 1 ? false : true;
//		
//		//다음 버튼
//		this.next = lastIdx > totPageCnt ? false : true;
//		if (this.lastIdx > this.totPageCnt) {
//			this.lastIdx = this.totPageCnt;
//			this.next = false;
//		}		
//	}
//
//	
//	
//	
	
}
