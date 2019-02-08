<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="lists.BigTypeList,javabeans.BigType" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ajax二级联动</title>
    <script src="jquery/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
<table>
    <tr>
        <td colspan="2" style="text-align: center">二级联动</td>
    </tr>
    <tr>
        <td>大类</td>
        <td>
            <%--单元格里放入一个select元素--%>
            <select id="big">
                <option value="0">选择大类</option>
                <%
                    BigTypeList dao = new BigTypeList();
                    List<BigType> list = dao.queryAll();
                    for (BigType bt : list) {
                %>
                <option value="<%=bt.getBigTypeId()%>"><%=bt.getBigTypeName()%>
                </option>
                <%
                    }
                %>
            </select>
        </td>
    </tr>
    <tr>
        <td>小类</td>
        <td>
            <select id="small">
                <option>选择小类</option>
            </select>
        </td>
    </tr>

    <%--接下来是jQuery阶段哈--%>
    <script>
        $(function () {
            $("#big").change(function () {
                var a = $(this).val()
                if (a == 0) {

                }
                $.ajax({
                    url:"/testspring2/check",
                    type:"get",
                    data:{bigId:a},
                    dataType:"json",
                    success:function (json) {
                        console.log(json)
                        $("#small>option~option").remove();
                        // $("#small").append("<option>选择小类</option>")
                        for(let i = 0;i<json.length;i++){
                            $("#small").append("<option value='"+ json[i].smallTyped+"'>"+
                                json[i].smallTypeName+"</option>")
                        }

                    }
                })
            })
        })
    </script>
</table>
</body>
</html>
