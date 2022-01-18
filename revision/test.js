<td align="center" class="listtd"><a href="javascript:selectDetail('<c:out value="${result.id}"/>')"><c:out value="${result.id}"/></a></td>

html = html + '<td align="center" class="listtd"><a href="javascript:selectDetail('+data.resultList[tmp].id+')">' + data.resultList[tmp].id + '</a></td>';

<td align="center" class="listtd"><c:out value="${paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count)}"/></td>

html += '<td align="center' class="listtd">' + data.resultList[tmp].paginationInfo.totalRecordCount+1 - ((searchVO.pageIndex-1) * searchVO.pageSize + status.count) +   '</td>';