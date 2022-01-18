<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : boseList.jsp
  * @Description : Bose List 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2009.02.01            최초 생성
  *  2021.10.21				이수지       
  *
  * author 실행환경 개발팀
  * since 2009.02.01
  *
  * Copyright (C) 2009 by MOPAS  All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   
    <c:import url="/WEB-INF/jsp/egovframework/kws/top.jsp"></c:import>
    
    <title>bose</title>
    
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bose.css'/>"/>
    
    <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/common.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/js/egovframework/bose/boseList.js'/>" ></script>
    <script type="text/javaScript" language="javascript" defer="defer">

    </script>
</head>

<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
    <form:form commandName="searchVO" id="listForm" name="listForm" method="post">
        <input type="hidden" name="selectedId" />
        <div id="content_pop">
        	<!-- 타이틀 -->
        	<div id="title">
        		<ul>
        			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>bose리스트</li>
        		</ul>
        	</div>
        	<!-- // 타이틀 --> 
        	<div id="SearchArea">
        		<ul>
   			    	<li>
   			    		<label for="searchUseYn">사용여부</label>
   			    		<input type="checkbox" id="searchUseYn" name="searchUseYn" class="txt"></input>
   			    	</li>
   			    	
          			<li>
        			    <label for="searchCondition">조회 조건 : </label>
        				<form:select path="searchCondition" cssClass="use">
        					<form:option value="0" label="ID" />
        					<form:option value="1" label="회원명" />
        				</form:select>
        			</li>

        			<li><label for="searchKeyword" style="visibility:hidden;display:none;">검색어</label>
                        <form:input path="searchKeyword" cssClass="txt"/>
                    </li>

        			<li>
        	            <span class="btn_blue_l" id="btnSearch">
        	                <a href="#">검색</a>
        	                <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
        	            </span>
        	        </li>
                </ul>
        	</div>
        	<!-- List -->
        	<div id="table">
        		<table width="100%" border="0" cellpadding="0" cellspacing="0" summary="카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블" id="dataArea">
        			<caption style="visibility:hidden">카테고리ID, 케테고리명, 사용여부, Description, 등록자 표시하는 테이블</caption>
        			<colgroup>
        				<col width="500"/>
        				<col width="500"/>
        				<col width="500"/>
        				<col width="500"/>
        				<col width="500"/>
        				<col width="500"/>
        				<col width="500"/>
        				<col width="500"/>
        				<col width="1000"/>
        			</colgroup>
        			<thead>
        			<tr>
        				    <th align="center">No</th>
	           				<th align="center">id</th>
	        				<th align="center">회원명</th>
	        				<th align="center">생년월일</th>
	        				<th align="center">성별</th>
	        				<th align="center">휴대폰</th>
	        				<th align="center">등록일</th>
	        				<th align="center">E-mail</th>
        					<th align="center">회원참고사항</th>   
        			</tr>
        			</thead>
        			<tbody id="tdata"></tbody>
        		</table>
        	</div>
        	<!-- /List -->

			<div id="pagination" class="pagination">
<!-- 				<ul> -->
<%-- 					<c:if test="${paginationInfo.totalPageCount > 1}"> --%>
<!-- 						<li class="first" fnName="selectList"> -->
<!-- 							<a href="#">첫 페이지</a> -->
<!-- 						</li> -->
<!-- 						<li class="prev" fnName="selectList"> -->
<!-- 							<a href="#">이전	페이지</a> -->
<!-- 						</li> -->
<%-- 					</c:if> --%>
<%-- 					<ui:pagination paginationInfo="${paginationInfo}" --%>
<%-- 						type="image" /> --%>
<%-- 					<c:if test="${paginationInfo.totalPageCount > 1}"> --%>
<!-- 						<li class="next" fnName="selectList"> -->
<!-- 							<a href="#">다음	페이지</a> -->
<!-- 						</li> -->
<!-- 						<li class="last" fnName="selectList"> -->
<!-- 							<a href="#">마지막 페이지</a> -->
<!-- 						</li> -->
<%-- 					</c:if> --%>
<!-- 				</ul>			 -->
			</div>
        	
        	<div id="sysbtn">
        	  <ul>
        	      <li>
        	          <span id = "btnCreate" class="btn_blue_l">
        	              <a href="javascript:createDetail();">신규 등록</a>
                          <img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;" alt=""/>
                      </span>
                  </li>
              </ul>
        	</div>
        </div>
    </form:form>
</body>
</html>