<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : top.jsp
  * @Description : 공통 jsp
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
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/com/com.css'/>"/>
    <%-- <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/> --%>
    <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/jquery.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/common.js'/>" ></script>
    <script type="text/javascript" src="<c:url value='/js/egovframework/com/cmm/notiflix.js'/>" ></script>
    <script type="text/javascript" src="/js/egovframework/com/cmm/fms/EgovMultiFiles.js" ></script><!-- 파일관리 -->
    <script type="text/javascript" src="<c:url value='/js/egovframework/kws/top.js'/>" ></script>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/notiflix.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/edu/edustyle.css'/>"/>
</head>

<form id="loginUserVO">
	<!--아이디 ,이름, 사용자구분, 부서ID, 부서명, 고유아이디, GPKI인증DN -->
	<input type="hidden" id="loginUserId" name="loginUserId" value='${sessionScope.loginVO.id}' />
	<input type="hidden" id="loginUserName" name="loginUserName" value='${sessionScope.loginVO.name}' />
	<input type="hidden" id="loginUserUserSe" name="loginUserUserSe"  value='${sessionScope.loginVO.userSe}' />
	<input type="hidden" id="loginUserOrgnztId" name="loginUserOrgnztId" value='${sessionScope.loginVO.orgnztId}' />
	<input type="hidden" id="loginUserOrgnztNm" name="loginUserOrgnztNm" value='${sessionScope.loginVO.orgnztNm}' />
	<input type="hidden" id="loginUserUniqId" name="loginUserUniqId" value='${sessionScope.loginVO.uniqId}' />
	<input type="hidden" id="loginUserDn" name="loginUserDn" value='${sessionScope.loginVO.dn}' />
</form>

</html>
