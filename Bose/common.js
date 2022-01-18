function setAreaParamData(params, areaId){
    var tmpMap = new Map();
    var $area;
    if(areaId){
        $area = $('#'+areaId);
    }else{
        $area = $('body');
    }

    $area.find(":text,:password").each(function(){
        var obj = this;
        var value = obj.value;
        var id = obj.getAttribute("id");
        if($("#"+obj.id).filter('.num').length > 0){
            var rgx1 = /\D/g;
            value = value.replace(rgx1,"");
            tmpMap.set(id, value);
        }else{
            tmpMap.set(id, value);
        }
    });

    $area.find("[type='hidden']").each(function(){
        var obj = this;
        var id = obj.getAttribute("id");
        tmpMap.set(id, obj.value);
    });

    $area.find("[type='date']").each(function(){
        var obj = this;
        var id = obj.getAttribute("id");
        tmpMap.set(id, obj.value);
    });

    $area.find("[type='time']").each(function(){
        var obj = this;
        var id = obj.getAttribute("id");
        tmpMap.set(id, obj.value);
    });

    $area.find(":checkbox").each(function(){
        var obj = this;
        if(obj.checked == true){
            var id = obj.getAttribute("id");
            tmpMap.set(id, obj.value);
        }
    });
    $area.find(":radio").each(function(){
        var obj = this;
        if(obj.checked == true){
//				var id = changeIdName(obj.getAttribute("name"));
            var id = obj.getAttribute("name");
            tmpMap.set(id, obj.value);
        }
    });
    $area.find("select").each(function(){
        var obj = this;
        var id = obj.getAttribute("id");
        tmpMap.set(id, obj.value);
    });
    $area.find("textarea").each(function(){
        var obj = this;
        var id = obj.getAttribute("id");
        tmpMap.set(id, obj.value);	// \n 특수기호 처리해야함

    });

    //alert(JSON.stringify(tmpMap));
    
    createPaths(tmpMap, 'paths.aliases.server.entry', 'src/test');
    createPaths(tmpMap, 'paths.aliases.dist.entry', 'dist/test');
    
    tmpMap.forEach((value, key) => {
        var keys = key.split('.'),
            last = keys.pop();
        keys.reduce((r, a) => r[a] = r[a] || {}, params)[last] = value;
    });


    return params;
}

function createPaths(aliases, propName, path) {
       aliases.set(propName, path);
}


//////////페이징 커스터마이징///////////////
var pageIndex = 1;  //현재 페이지 시작은 언제나 1
var totalCnt = $("#totalCnt").val();  // 총 게시글 갯수
var pageCount = 10;  //한페이지에 표시할 게시글 수
var totalPageSize = Math.ceil(totalCnt /pageCount );  //총 페이지 갯수 = 올림(총 게시글 갯수 / 한페이지에 표시할 게시글 수) - 소수로 나오면 한페이지로 인식해야함


//파라미터 객체ID(pagenation ID, 페이징 관련 데이터 , 조회할 함수 이름)
var createPagination = function(objId,data,fnName) {

    document.getElementById(objId).innerHTML = "";// 페이지 번호 지우기
    pageIndex = data.paginationInfo.currentPageNo; // 현재 페이지번호 = 입력받은 파라미터 값
     totalCnt = data.paginationInfo.totalRecordCount; //총 게시글 수 가져오기 (새로 추가된 게시글이 있을 수 있으니 매번 가져옴)
    
    totalPageSize = Math.ceil(totalCnt /pageCount ); //총 게시글 수를 매번 가져오니까 총 페이지 수도 매번 계산해야함
    var tag = '<ul>';
   if(totalPageSize > 1){ //총 페이지 수가 1보다 크면 이전, 맨앞 버튼 생성
      tag += '<li class="first" fnName="'+fnName+'"><a href="#">첫  페이지</a></li>';
      tag += '<li class="prev" fnName="'+fnName+'"><a href="#">이전 페이지로</a></li>';
   }
   //tag += '</div> <div class="num_area">'
   var showPageCount = 5; // 한번에 표시할 페이지 숫자 갯수
   
   if(showPageCount > totalPageSize)  // 총페이지가 5개 미만일경우
   {
      showPageCount = totalPageSize;
   }
   
   var pageGroup = Math.ceil(pageIndex / showPageCount); //시작과 끝 페이지 계산(ex> 1그룹 1~5, 2그룹 6~10)
   
   for(var i = 1 ; i < showPageCount+1 ; i ++){ //표시할 페이지 까지만 번호 부여해서 표시
      var pageNum = parseInt(pageGroup-1)*5+parseInt(i);
      if(pageNum > totalPageSize) break; // 표시할 페이지가 총 페이지를 넘어가면 멈춤
      if(pageNum == pageIndex ){
         tag += '<li class="current" fnName="'+fnName+'"><a href="#">'+pageNum+'</a></li>'; //현재 페이지면 번호에 on 부여
      }else{
         tag += '<li class="num" fnName="'+fnName+'"><a href="#" >'+pageNum+'</a></li>';  //현재 페이지가 아니면 그냥 번호 생성
      }
   }
   
   //tag += '</div> <div class="direction">'
   if(totalPageSize > 1){  //총 페이지가 1보다 크면 다음,맨끝 버튼 생성
      tag += '<li class="next" fnName="'+fnName+'"><a href="#">다음 페이지로</a>'; 
      tag += '<li class="last" fnName="'+fnName+'"><a href="#">마지막 페이지로</a></li>';   
   }
   tag += '</ul>'
   $('#'+objId).append(tag); //생성한 태그들 append 시키기
}


//맨앞, 이전, 맨끝, 다음, 현재 페이지 버튼 함수
$(document).on("click",".pagination .first",function(){ 
 if(pageIndex==1){return;}  
    window[this.attributes.fnname.value]("1")
 });
$(document).on("click",".pagination .prev",function(){
 if(pageIndex==1){return;}
 
 if(pageIndex <= 1){
     window[this.attributes.fnname.value]("1")	        		 
 } else {
     window[this.attributes.fnname.value](parseInt(pageIndex - 1)+""); 
 }
 });
$(document).on("click",".pagination .last",function(){ 
//		debugger;
 if(pageIndex == totalPageSize){return;}
     window[this.attributes.fnname.value](parseInt(Math.ceil(parseInt(totalCnt) /parseInt(pageCount) ))+"");
 });
$(document).on("click",".pagination .next",function(){ 
 if(pageIndex == totalPageSize){return;}
     window[this.attributes.fnname.value](parseInt(pageIndex*1 + 1)+"");
 });
$(document).on("click",".pagination .num",function(){ 
    window[this.attributes.fnname.value](this.children[0].innerText);
 });

/////공통코드 관리
//param : 태그 ID, 공통코드
var createCommonSelectBox = function(objId,commonCode) {
    $.ajax({
    url:'/sym/ccm/cde/selectCmmnDetailCodeListCommon.do',
    dataType:"json",
    data :  {"clCode":commonCode},
    traditional : true,
    method:"POST",
    async:false,
       success:function( data ) {
           var optionStr ="<option selected= value=''>선택하세요</option>";
           $('#'+objId).append(optionStr);
           for(var i = 0 ; i < data.resultList.length;i++){
               optionStr = "<option value='"+data.resultList[i].code+"'>"+data.resultList[i].codeNm+"</option>"
               $('#'+objId).append(optionStr);
           }
       },
       error : function( jqXHR, textStatus, errorThrown ) {
        //alert( jqXHR.responseText );
        console.log("ajax error statusText : " + jqXHR.statusText);
        console.log("ajax error responseText : " + jqXHR.responseText);
        console.log("ajax error readyState : " + jqXHR.readyState);
        console.log("ajax error textStatus : " + textStatus);
        console.log("ajax error errorThrown : " + errorThrown);
    }
    });
}

////첨부파일
//param : 첨부파일
var createSaveFileIds = function(objId,fileIds,callBackId,callbackParam) {
    var formData = new FormData($('#'+objId)[0]);
     $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/kws/common/saveFileTest.do",
        data: formData,
        processData: false,
        contentType: false,
        //cache: false,
        success: function (data) {
            var result = JSON.parse(data);
            if(result.result == "success"){
                $("#"+fileIds).val(JSON.parse(data).key);
                window[callBackId](callbackParam);
                
                
                
            }else{
                alert("파일업로드 실패");
            }
        },
        error: function (e) {
        }
    });
}

/*
* pop up 창 만들어 주는 객체
* 
* url : url String
* windowName : pop up창의 이름, type: string
* windowFeatureObject 예시
* let	windowFeature = {
        height: 500,
        width: 520,
        top: 50,
        left: 20,
        scrolls: 'no',
        resizable: 'no'
}
*/
var	fncCreatePopUpWindow = function (url, windowName, windowFeatureObject) {
// 설정 String 만들기
windowFeatureObject.toString = function () {
    let	result = "";
    let	obj = this;
    let	keys = Object.keys(obj);
    let	ArrayLength = keys.length;
    keys.forEach(function(key, index) {
            if (index < ArrayLength -1) {
                result += key + "=" + obj[key];
                if (index != ArrayLength -2) {
                    result += ", ";
                }
            }
        })
    return result;
}
window.open(url, windowName, windowFeatureObject.toString());
}

