
/****** 주화면 클래스 ******/
var bose = {
    /****** 주화면 초기화 메소드 ******/
    init : function() {
        /******  ******/
        var self = this;
        
        console.log("▶▶▶▶ boseRegister.js in");
        
        //목록 화면으로 돌아감 - 목록 버튼 클릭 시 이벤트
        $("#btnList").click(function() {
            window.location.href="/boseList.do";
        });
  
    	var	r_data = {};
    	r_data = setAreaParamData(r_data, "table");        
        
        console.log("id.val() : ",r_data.id);
        if (!r_data.id) {
            $("#btnSave").click(function() {
            	console.log("createDB");
                createDB();
            });
        }
        else {
            $("#btnSave").click(function() {
            	console.log("updateDB");
                updateDB();
            });
            $("#btnDelete").click(function() {
            	console.log("deleteDB");
                deleteDB();
            });
        }
        
        
    }
};


/** **** ajax 통신을 담당하고 있는 함수 ***** */
//나는 이제 기존 함수에서 url, data, successFunciton만 정의해주면 된다.
let	useAjax = function(url, data, type, successFunction) {
	
	console.log("REGISTER AJAXCALLED");
	
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
	}).done(function() {
		data = null;
		//데이터 비워주기 작업
	})
}



/****** 새 글 등록 ******/
var createDB = function() {
	
	//●●ajax 통신을 통해 보낼 data
	let	r_data = {};
	r_data = setAreaParamData(r_data, "table");
	
	//●●ajax 통신을 통해 보낼 url
	let url = '/addBoseAjax.do';
	
	//●●ajax 통신 성공 시 실행할 함수
	let successFunction = function(data) {
		console.log(data);
		if ( data.result = "success" ) {
			window.location.href='/boseList.do';
		}
	 }
	useAjax(url, r_data, "POST", successFunction);
};
	

/****** 기존 글 수정 ******/
var updateDB = function() {

	//●●ajax 통신을 통해 보낼 data
	let	r_data = {};
	r_data = setAreaParamData(r_data, "table");
	
	//●●ajax 통신을 통해 보낼 url
	let url = '/updateBoseAjax.do';
	
	//●●ajax 통신 성공 시 실행할 함수
	let successFunction = function(data) {
			console.log(data);
			window.location.href='/boseList.do';

	 }
	useAjax(url, r_data, "POST", successFunction);
};	


/****** 기존 글 삭제 ******/
var deleteDB = function() {

	//●●ajax 통신을 통해 보낼 data
	let	r_data = {};
	r_data = setAreaParamData(r_data, "table");
	
	//●●ajax 통신을 통해 보낼 url
	let url = '/deleteBoseAjax.do';
	
	//●●ajax 통신 성공 시 실행할 함수
	let successFunction = function(data) {
		console.log(data);
		window.location.href='/boseList.do';
	 }
	useAjax(url, r_data, "POST", successFunction);
};







$(document).ready(function() {
bose.init();
});
