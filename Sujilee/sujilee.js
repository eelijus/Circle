/** **** 주화면 클래스 ***** */
var sujilee = {
    /** **** 주화면 초기화 메소드 ***** */
    init : function() {
        /** **** ***** */
        var self = this;
    
        $("#btnSearch").click(function(){
            selectList();
        });

        $("#btnCreate").click(function(){
            window.location.href='/addSujileeView.do';
        });
        
    }
};

var totalRecordCount = 0; 

var selectList = function(currentPageNo) {
        /** **** ***** */
        
        var p_data ={};
        p_data = setAreaParamData(p_data, "SearchArea");
        
//			var queryParams = '?'
//				+ 'searchCondition='
//				+ $('#searchCondition').val()
//				+ '&'
//				+ 'searchKeyword='
//				+ $('#searchKeyword').val()

        if(currentPageNo != ""){
            p_data.currentPageNo = currentPageNo;
        }else{
            p_data.currentPageNo = 1;
        }
        $.ajax({
//			url:'/egovSujileeListAjax.do' + queryParams,
        url:'/egovSujileeListAjax.do',
        dataType:"json",
        data : p_data,
        type:"POST",
        async:false,
           success:function( data ) {
               totalRecordCount = data.paginationInfo.totalRecordCount;
          console.log(data);
                  var html = ""; 
          for(tmp in data.resultList){
                          html = html + "<tr>"; 
                          html = html + '<td align="center" class="listtd">'+(tmp+1)+'</td>';
                        html = html + '<td align="center" class="listtd"><a href="javascript:fn_egov_select('+data.resultList[tmp].id+')">'+data.resultList[tmp].id+'</a></td>';
                        html = html +'<td align="left" class="listtd">'+data.resultList[tmp].name+'&nbsp;</td>';
                        html = html +'<td align="center" class="listtd">'+data.resultList[tmp].useYn+'&nbsp;</td>';
                        html = html +'<td align="center" class="listtd">'+data.resultList[tmp].description+'&nbsp;</td>';
                        html = html +'<td align="center" class="listtd">'+data.resultList[tmp].regUser+'&nbsp;</td>';
                          html = html + '</tr>';
                          
          }
          $("#tdata").html(html);
          
            var html = "";
            for (var pIndex = 0; pIndex * 10 < totalRecordCount; pIndex++) {
                html = html + '<li>';
                html = html + '<a href="?pageIndex=' + (pIndex + 1).toString() 
                if ($('#searchKeyword').val() != "") { 
                    html = html + '&' + 'searchKeyword=' + $('#searchKeyword').val()
                    html = html + '&' + 'searchCondition=' + $('#searchCondition').val()
                }  
                html = html + '">'
                html = html + (pIndex + 1).toString()
                html = html + '</a></li>'
            }	
                
            $("#paging").html(html);			  
          
          
           },
           error : function( jqXHR, textStatus, errorThrown ) {
            // alert( jqXHR.responseText );
            console.log("ajax error statusText : " + jqXHR.statusText);
            console.log("ajax error responseText : " + jqXHR.responseText);
            console.log("ajax error readyState : " + jqXHR.readyState);
            console.log("ajax error textStatus : " + textStatus);
            console.log("ajax error errorThrown : " + errorThrown);
        }
           
           
        });
        
};

$(document).ready(function() {
sujilee.init();
});