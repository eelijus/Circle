/** **** 주화면 클래스 ***** */
var bose = {
    /** **** 주화면 초기화 메소드 ***** */
    init : function() {
        /** **** ***** */
        var self = this;
        
        console.log("▶▶▶▶ bose.js in");
    
        selectList(); //selectList(1);
        
        createCommonSelectBox("searchUseYn", "COM045");
        
        $("#btnSearch").click(function(){
            selectList();
        });
        
    }
};




/** **** id 상세페이지 이동 ***** */
//id 클릭 시 이벤트
var	selectDetail = function(id) {

console.log("selectDetail");

document.listForm.selectedId.value = id;
document.listForm.action = '/updateBoseView.do';
document.listForm.method = "POST";
document.listForm.submit();
}

/** **** 새 글 등록 페이지 이동 ***** */
//신규 등록 버튼 클릭 시 이벤트
var createDetail = function(){

console.log("createDetail");

document.listForm.action = '/addBoseView.do';
document.listForm.method = "POST";
document.listForm.submit();
}


/** **** ajax 통신을 담당하고 있는 함수 ***** */
let	callAjax = function(url, data, type, successFunction) {

console.log("AJAXCALLED");

$.ajax({
    url : url,
    dataType : "json",
    data : data,
    type : type,
    async : false,
    success : successFunction,
    error : function(jqXHR, textStatus, errorThrown) {
        console.log("ajax error statusText : " + jqXHR.statusText);
        console.log("ajax error responseText : " + jqXHR.responseText);
        console.log("ajax error readyState : " + jqXHR.readyState);
        console.log("ajax error textStatus : " + textStatus);
        console.log("ajax error errorThrown : " + errorThrown);
    }
});
}


/** **** 글 목록 조회 ***** */
//초기화면, 검색 결과 화면
var selectList = function(currentPageNo) {
        /** **** ***** */
    
console.log("selectList");
//●●ajax 통신을 통해 보낼 data
var p_data ={};
p_data = setAreaParamData(p_data, "SearchArea");

//●●ajax 통신을 통해 보낼 url
let url = '/boseListAjax.do';

//searchKeyword로 사용자가 입력한 값을 p_data.searchId로 넣어줌 -> DefaultVO
if($("#searchCondition").val() == 0)
    p_data.searchId = $("#searchKeyword").val()*1;

//정신차려라...DefaultVO에 pageIndex만 있지 currentPageNo이 어딨냐...
if(currentPageNo != ""){
    p_data.pageIndex = currentPageNo;
}else{
    p_data.pageIndex = 1;
}

//●●ajax 통신 성공 시 실행할 함수
let successFunction = function(data) {
       totalRecordCount = data.paginationInfo.totalRecordCount;
       console.log(data);
      var html = ""; 
      for(tmp in data.resultList){

        html = html + "<tr>"; 
          html = html + '<td align="center" class="listtd">'+(tmp+1)+'</td>';
          html = html + '<td align="center" class="listtd"><a href="javascript:selectDetail('+data.resultList[tmp].id+')">'+data.resultList[tmp].id+'</a></td>';
          html = html +'<td align="left" class="listtd">'+data.resultList[tmp].userName+'&nbsp;</td>';
          html = html +'<td align="center" class="listtd">'+data.resultList[tmp].birthDate+'&nbsp;</td>';
          html = html +'<td align="center" class="listtd">'+data.resultList[tmp].gender+'&nbsp;</td>';
          html = html +'<td align="center" class="listtd">'+data.resultList[tmp].phoneMobile+'&nbsp;</td>';
          html = html +'<td align="center" class="listtd">'+data.resultList[tmp].regDate+'&nbsp;</td>';
          html = html +'<td align="center" class="listtd">'+data.resultList[tmp].mail+'&nbsp;</td>';
          html = html +'<td align="center" class="listtd">'+data.resultList[tmp].userNote+'&nbsp;</td>';
        html = html + '</tr>';		                 
    }
    $("#tdata").html(html);
    
    /** **** 페이지네이션 ***** */
    //import from common.js 매개변수 : html id, 페이징 관련된 데이터, 조회할 함수
    createPagination("pagination",data,"selectList");
    console.log("pagination");
}

callAjax(url, p_data, "POST", successFunction);

};

$(document).ready(function() {
bose.init();
});