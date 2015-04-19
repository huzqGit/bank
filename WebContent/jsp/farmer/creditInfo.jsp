<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<title></title>
    <style type="text/css">
     *{
            text-decoration:none
     }
     .active{
         border-bottom: 8px solid darkblue;
         font-size: 15px;
         font-family: YouYuan;
         font-weight: bold;
     }
     .inactive{
         border-bottom: 1px solid darkblue;
     }
     .line{
        background-color: darkblue;
     }

    </style>
</head>
<body>
<table cellpadding="0" cellspacing="0">
    <tr>
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/basicInfo.jsp">农户基本信息</a></td>
        <td width="1px" class="line"></td>
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/paymentInfo.jsp">农户收支信息</a></td>
        <td width="1px" class="line"></td>
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/loanInfo.jsp">农户信贷信息</a></td>
        <td width="1px" class="line"></td>
        <td width="200px" class="active" align="center">农户信用信息</td>
    </tr>
</table>
<div id="form1" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input name="id" class="mini-hidden"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>村民委员会对农户家庭评价情况基本信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">  人品综合评价:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="personality" class="mini-textarea" required="true"
                                               requiredErrorText="人品综合评价不能为空"style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">  家庭和睦情况:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="harmonyStatus" class="mini-textarea" required="true"
                                               requiredErrorText="家庭和睦情况不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">  敬老爱幼情况:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="respectStatus" class="mini-textarea" required="true"
                                               requiredErrorText="保险金额不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">  邻里团结情况:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="neighborStatus" class="mini-textarea" required="true"
                                               requiredErrorText="邻里团结情况不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>是否遵纪守法:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="legalStatus" class="mini-combobox" required="true"
                                               requiredErrorText="是否遵纪守法不能为空" style="width:90%"
                                               url="dic/YesOrNoStatus.txt" emptyText="请选择..."/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text"> 对公益事业关心程度:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="welfareStatus" class="mini-textarea" required="true"
                                               requiredErrorText="对公益事业关心程度不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>是否诚实守信:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="honestStatus" class="mini-combobox" required="true"
                                               requiredErrorText="是否遵纪守法不能为空" style="width:90%"
                                               url="dic/YesOrNoStatus.txt" emptyText="请选择..."/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">  其他:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="otherStatus" class="mini-textarea" required="true"
                                               requiredErrorText="对公益事业关心程度不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="form2" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input name="id" class="mini-hidden"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户受表彰与处罚情况基本信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">表彰或处罚部门:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="organ" class="mini-textbox" required="true"
                                               requiredErrorText="信用户评定时间不能为空"style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">表彰或处罚内容:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="detail" class="mini-textarea" required="true"
                                               requiredErrorText="表彰或处罚内容不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">表彰或处罚时间:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="occurTime" class="mini-datepicker" required="true"
                                               requiredErrorText="彰或处罚时间不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>
                </td>
            </tr>
            <tr>
                <td align="center"><button>新增</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>