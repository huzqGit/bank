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
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/paymentInfo.jsp"> 农户收支信息</a></td>
        <td width="1px" class="line"></td>
        <td width="200px" class="active" align="center">农户信贷信息</td>
        <td width="1px" class="line"></td>
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/creditInfo.jsp">农户信用信息</a></td>
    </tr>
</table>
<div id="form1" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input type="hidden" name="deviceId"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户当前未结清信贷基本情况</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">贷款金融机构:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="bank" class="mini-textbox" required="true"
                                               requiredErrorText="贷款金融机构不能为空"style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">业务类别:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="businessType" class="mini-textbox" required="true"
                                               requiredErrorText="业务类别不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">贷款用途:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="loanUse" class="mini-textbox" required="true"
                                               requiredErrorText="贷款用途不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">贷款方式:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="loanWay" class="mini-combobox" required="true"
                                               requiredErrorText="贷款方式不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">贷款余额(万元):</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="loanBalance" class="mini-textbox" required="true"
                                               requiredErrorText="当前评估价格不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">贷款发放时间:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="provideTime" class="mini-datepicker" required="true"
                                               requiredErrorText="贷款发放时间不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">贷款到期时间:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="limitTime" class="mini-datepicker" required="true"
                                               requiredErrorText="贷款到期时间不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>
                </td>
            </tr>
            <tr align="center"><td><button>新增</button></td></tr>
        </table>
    </form>
</div>
<div id="form2" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input type="hidden" name="badloanId"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户不良贷款情况基本信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">贷款金融机构:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="bank" class="mini-textbox" required="true"
                                               requiredErrorText="贷款金融机构不能为空"style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">不良贷款余额:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="balance" class="mini-textbox" required="true"
                                               requiredErrorText="不良贷款余额不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">不良贷款偿还日期:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="paymentTime" class="mini-datepicker" required="true"
                                               requiredErrorText="不良贷款偿还日期" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>
                </td>
            </tr>
            <tr align="center"><td><button>新增</button></button></td></tr>
        </table>
    </form>
</div>
<div id="form3" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input name="id" class="mini-hidden"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户对外担保基本情况</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">被担保人姓名:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="name" class="mini-textbox" required="true"
                                               requiredErrorText="被担保人姓名不能为空"style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">被担保人身份证号:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="idNum" class="mini-textbox" required="true"
                                               requiredErrorText="被担保人身份证号不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">未结清担保到期日:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="limitTime" class="mini-textbox" required="true"
                                               requiredErrorText="未结清担保到期日能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">未结清担保金:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="deposit" class="mini-textarea" required="true"
                                               requiredErrorText="未结清担保金不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">未结清担保金合计:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="depositAll" class="mini-combobox" required="true"
                                               requiredErrorText="未结清担保金合计不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>
                </td>
            </tr>
            <tr align="center"><td><button>新增</button></td></tr>
        </table>
    </form>
</div>
<div id="form4" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input name="id" class="mini-hidden"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户对外担保情况基本信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">参保人姓名:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="name" class="mini-textbox" required="true"
                                               requiredErrorText="参保人姓名不能为空"style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">参加保险种类:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="type" class="mini-combobox" required="true"
                                               requiredErrorText="参加保险种类不能为空" style="width:90%"
                                               url="/bank/dic/InsuredType.txt" emptyText="请选择..."/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">保险金额:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="amount" class="mini-textbox" required="true"
                                               requiredErrorText="保险金额不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">参保时间:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="insureTime" class="mini-datepicker" required="true"
                                               requiredErrorText="保险金额不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">参保到期日:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="limitTime" class="mini-datepicker" required="true"
                                               requiredErrorText="参保到期日不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </fieldset>
                </td>
            </tr>
            <tr align="center"><td><button>新增</button></td></tr>
        </table>
    </form>
</div>
</body>
</html>