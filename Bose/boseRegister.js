
/****** 주화면 클래스 ******/
var bose = {
    /****** 주화면 초기화 메소드 ******/
    init : function() {
        /******  ******/
        var self = this;
        
        console.log("▶▶▶▶ boseRegister.js in");
        
        var tdata = {};
        tdata = setAreaParamData(tdata, "table");
        
        //목록 화면으로 돌아감 - 목록 버튼 클릭 시 이벤트
        $("#btnList").click(function() {
            window.location.href="/boseList.do";
        });
        
        
        console.log(tdata.id);
        if (!tdata.id) {
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


/******  ******/
var createDB = function() {

	var userNameValue = $("#userName").val();
	var residentNumValue = $("#residentNum").val();
	var phoneHomeValue = $("#phoneHome").val();
	var phoneWorkValue = $("#phoneWork").val();
	var phoneMobileValue = $("#phoneMobile").val();
	var regDateValue = $("#regDate").val();
	var mailValue = $("#mail").val();
	var userNoteValue = $("#userNote").val();
	
	console.log("#userName", userNameValue); // 값 print
	console.log("#residentNum", residentNumValue); // 값 print
	console.log("#userName", phoneHomeValue); // 값 print
	console.log("#userName", phoneWorkValue); // 값 print
	console.log("#userName", phoneMobileValue); // 값 print
	console.log("#userName", regDateValue); // 값 print
	console.log("#userName", mailValue); // 값 print
	console.log("#userName", userNoteValue); // 값 print
	
	$.ajax({
		url:'/addBoseAjax.do',
		dataType:"json",
		data : {
		        "userName": userNameValue,
		        "residentNum": residentNumValue,
		        "phoneHome": phoneHomeValue,
		        "phoneWork": phoneWorkValue,
		        "phoneMobile": phoneMobileValue,
		        "regDate": regDateValue,
		        "mail": mailValue,
		        "userNote": userNoteValue},
		type:"POST",
		async:false,
		   success:function( data ) {
		       console.log(data)
		       if ( data.result = "success" ) {
		        window.location.href='/boseList.do';
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

/******  ******/
var updateDB = function() {
	
	var s_data = {
	        id:$("#id").val(), 
	        userName:$("#userName").val(), 
	        phoneHome:$("#phoneHome").val(), 
	        residentNum:$("#residentNum").val(), 
	        phoneWork:$("#phoneWork").val(),
	        phoneMobile:$("#phoneMobile").val(),
	        regDate:$("#regDate").val(),
	        mail:$("#mail").val(),
	        userNote:$("#userNote").val()
	        };
	console.log(s_data);
	$.ajax({
		url:'/updateBoseAjax.do',
		dataType:"json",
		data : s_data,
		type:"POST",
		async:false,
		   success:function( data ) {
		       if ( data.result = "success" ) {
		        window.location.href='/boseList.do';
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

/******  ******/
var deleteDB = function() {
	
	var s_data = {
	        id:$("#id").val(), 
	        userName:$("#userName").val(), 
	        phoneHome:$("#phoneHome").val(), 
	        dresidentNum:$("#residentNum").val(), 
	        phoneWork:$("#phoneWork").val(),
	        phoneMobile:$("#phoneMobile").val(),
	        regDate:$("#regDate").val(),
	        mail:$("#mail").val(),
	        userNote:$("#userNote").val()
	        };
	console.log(s_data);
	$.ajax({
		url:'/deleteBoseAjax.do',
		dataType:"json",
		data : s_data,
		type:"POST",
		async:false,
		   success:function( data ) {
		       if ( data.result = "success" ) {
		        window.location.href='/boseList.do';
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







$(document).ready(function() {
bose.init();
});
