<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"      uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring"    uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : boseRegister.jsp
  * @Description : Bose Register 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2009.02.01            최초 생성
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
    <c:set var="registerFlag" value="${empty boseVO.id ? 'create' : 'modify'}"/>
	
<%-- 	<c:import url="/WEB-INF/jsp/egovframework/kws/top.jsp"></c:import> --%>
	
	
	<title>Bose <c:if test="${registerFlag == 'create'}">생성
	</c:if> <c:if test="${registerFlag == 'modify'}">수정
	</c:if>
	</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>
    
    <!--For Commons Validator Client Side-->
   
    <script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script>
    <script type="text/javascript"
	src="<c:url value='/js/egovframework/com/cmm/jquery.js'/>"></script>
	<script type="text/javascript"
	src="<c:url value='/js/egovframework/com/cmm/common.js'/>"></script>
	<script type="text/javascript"
	src="<c:url value='/js/egovframework/bose/boseRegister.js'/>"></script>
    <validator:javascript formName="boseVO" staticJavascript="false" xhtml="true" cdata="false"/>
    
    <script type="text/javaScript" language="javascript" defer="defer">
        /* 글 목록 화면 function */

        
 
    </script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">

<div id="divToGetId" style="display: hidden">${ boseVO.id }</div>

<form:form commandName="boseVO" id="detailForm" name="detailForm">
    <div id="content_pop">
    	<!-- 타이틀 -->
    	<div id="title">
    		<ul>
    			<li><img src="<c:url value='/images/egovframework/example/title_dot.gif'/>" alt=""/>
                    <c:if test="${registerFlag == 'create'}"></c:if>
                    <c:if test="${registerFlag == 'modify'}"></c:if>
                </li>
    		</ul>
    	</div>
    	<!-- // 타이틀 -->
    	
     	<!-- // 상세화면 -->   	
    	<div id="table">
    	<table width="100%" border="1" cellpadding="0" cellspacing="0" style="bordercolor:#D3E2EC; bordercolordark:#FFFFFF; BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
    		<colgroup>
    			<col width="150"/>
    			<col width="?"/>
    		</colgroup>
    		<c:if test="${registerFlag == 'modify'}">
        		<tr>
        			<td class="tbtd_caption"><label for="id">아이디</label></td>
        			<td class="tbtd_content">
        				<form:input path="id" cssClass="essentiality" maxlength="10" readonly="true" />
        			</td>
        		</tr>
    		</c:if>
    		<tr>
   			<td class="tbtd_caption"><label for="userName">회원명</label></td>
   			<td class="tbtd_content">
                   <c:if test="${registerFlag == 'modify'}">
       				<form:input path="userName" maxlength="10" cssClass="essentiality" readonly="true" />
       				&nbsp;<form:errors path="userName" /></td>
                   </c:if>
                   <c:if test="${registerFlag != 'modify'}">
       				<form:input path="userName" maxlength="10" cssClass="txt"  />
       				&nbsp;<form:errors path="userName" /></td>
                   </c:if>
   			</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="residentNum">주민등록번호</label></td>
    			<td class="tbtd_content">
                    <c:if test="${registerFlag == 'modify'}">
        				<form:input path="residentNum" maxlength="10" cssClass="essentiality" readonly="true" />
        				&nbsp;<form:errors path="residentNum" /></td>
                    </c:if>
                    <c:if test="${registerFlag != 'modify'}">
        				<form:input path="residentNum" maxlength="10" cssClass="txt"  />
        				&nbsp;<form:errors path="residentNum" /></td>
                    </c:if>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="phoneHome">전화(자택)</label></td>
    			<td class="tbtd_content">
    				<form:input path="phoneHome" maxlength="30" cssClass="txt"/>
    				&nbsp;<form:errors path="phoneHome" />
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="phoneWork">전화(직장)</label></td>
    			<td class="tbtd_content">
    				<form:input path="phoneWork" maxlength="30" cssClass="txt"/>
    				&nbsp;<form:errors path="phoneWork" />
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="phoneMobile">휴대폰</label></td>
    			<td class="tbtd_content">
    				<form:input path="phoneMobile" maxlength="30" cssClass="txt"/>
    				&nbsp;<form:errors path="phoneMobile" />
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="regDate">최초가입일</label></td>
    			<td class="tbtd_content">
    				<form:input path="regDate" maxlength="30" cssClass="txt"/>
    				&nbsp;<form:errors path="regDate" />
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="mail">E-mail</label></td>
    			<td class="tbtd_content">
    				<form:input path="mail" maxlength="30" cssClass="txt"/>
    				&nbsp;<form:errors path="mail" />
    			</td>
    		</tr>
    		<tr>
    			<td class="tbtd_caption"><label for="userNote">회원참고사항</label></td>
    			<td class="tbtd_content">
    				<form:input path="userNote" maxlength="30" cssClass="txt"/>
    				&nbsp;<form:errors path="userNote" />
    			</td>
    		</tr>
    	</table>
      </div>
   			<div id="sysbtn">
				<ul>
					<li><span class="btn_blue_l" id="btnList"> <a href="#">목록</a>
							<img
							src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
							style="margin-left: 6px;" alt="" />
					</span></li>
					
					<li><span class="btn_blue_l" id="btnSave">
								<c:if test="${registerFlag == 'create'}">생성</c:if> 
								<c:if test="${registerFlag == 'modify'}">수정</c:if>
						</a> <img
							src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
							style="margin-left: 6px;" alt="" />
					</span></li>
					
					<c:if test="${registerFlag == 'modify'}">
						<li><span class="btn_blue_l" id="btnDelete"> <a href="#">삭제</a>
								<img
								src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
								style="margin-left: 6px;" alt="" />
						</span></li>
					</c:if>
					
					<li><span class="btn_blue_l"> <a
							href="javascript:document.detailForm.reset();">초기화</a>
							<img
							src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>"
							style="margin-left: 6px;" alt="" />
					</span></li>
				</ul>
			</div>
		</div>
    </div>
    </div>
    <!-- 검색조건 유지 -->
    <input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
    <input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
    <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>