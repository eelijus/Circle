/****** 주화면 클래스 ******/
var sujilee = {
    /****** 주화면 초기화 메소드 ******/
    init : function() {
        /******  ******/
        var self = this;
        var tdata = {};
        tdata = setAreaParamData(tdata, "table");
        
        $("#btnList").click(function() {
            window.location.href='/egovSujileeList.do';
        });
        
        if (!tdata.id) {
            $("#btnSave").click(function() {
                createDB();
            });
        }
        else {
            selectDB(tdata.id);
            $("#btnSave").click(function() {
                updateDB();
            });
            $("#btnDelete").click(function() {
                deleteDB();
            });
        }
        
    }
};

var selectDB = function() {
        /******  ******/
        var parameter = $("#divToGetId").text();
        console.log(parameter);
        // var p_data ={};
        // p_data = setAreaParamData(p_data, "SearchArea");
        $.ajax({
        url:'/updateSujileeViewAjax.do',
        dataType:"json",
        data : {"id": parameter},
        type:"GET",
        async:false,
           success:function( data ) {
          $("#id").val(data.sujileeVO.id);
          $("#name").val( data.sujileeVO.name);
          $("#description").val(data.sujileeVO.description);
          $("#regUser").val(data.sujileeVO.regUser);

          
          
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
        
};

var createDB = function() {
var idValue = new Date().getTime().toString();
var nameValue = $("#name").val();
var descriptionValue = $("#description").val();
var useYnValue = $("#useYn").val();
var regUserValue = $("#regUser").val();

console.log("createDB method in");

$.ajax({
    url:'/addSujileeAjax.do',
    dataType:"json",
    data : {"id": idValue,
            "name": nameValue,
            "description": descriptionValue,
            "useYn": useYnValue,
            "regUser": regUserValue},
    type:"POST",
    async:false,
       success:function( data ) {
      
               if ( data.result = "success" ) {
                window.location.href='/egovSujileeList.do';
            }
        console.log("post for creating record has been successfully done");  
          console.log(data);
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

var updateDB = function() {
        var s_data = {id:$("#id").val(), name:$("#name").val(), useYn:$("#useYn").val(), description:$("#description").val(), regUser:$("#regUser").val()};
        //console.log(s_data);
        $.ajax({
        url:'/updateSujileeAjax.do',
        dataType:"json",
        data : s_data,
        type:"POST",
        async:false,
           success:function( data ) {
               if ( data.result = "success" ) {
                window.location.href='/egovSujileeList.do';
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

var deleteDB = function() {
        var s_data = {id:$("#id").val(), name:$("#name").val(), useYn:$("#useYn").val(), description:$("#description").val(), regUser:$("#regUser").val()};
        console.log(s_data);
        $.ajax({
        url:'/deleteSujileeAjax.do',
        dataType:"json",
        data : s_data,
        type:"POST",
        async:false,
           success:function( data ) {
               if ( data.result = "success" ) {
                window.location.href='/egovSujileeList.do';
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
sujilee.init();
});