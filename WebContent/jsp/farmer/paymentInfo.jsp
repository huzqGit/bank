<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/miniui/jquery-1.6.2.min.js" type="text/javascript"></script>
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
     .line {
         background-color: darkblue;
     }

 </style>
</head>
<body>
<table cellpadding="0" cellspacing="0">
    <tr>
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/basicInfo.jsp">农户基本信息</a></td>
        <td width="1px" class="line"></td>
        <td width="200px" class="active" align="center">农户收支信息</td>
        <td width="1px" class="line"></td>
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/loanInfo.jsp">农户信贷信息</a></td>
        <td width="1px" class="line"></td>
        <td width="200px" class="inactive" align="center"><a href="/bank/jsp/farmer/creditInfo.jsp">农户信用信息</a></td>
    </tr>
</table>

<div id="form1" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input name="id" class="mini-hidden" />
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户小微收入信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">家庭收入来源:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="incomeType" class="mini-combobox" required="true"
                                               requiredErrorText="家庭收入来源不能为空" style="width:90%"
                                               url="/bank/dic/IncomeType.txt" emptyText="请选择..."/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">农作物或项目名称:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="incomeName" class="mini-textarea" required="true"
                                               requiredErrorText="名称不能为空"  style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">净收入:</label></td>
                                    <td style="width:40%">
                                        <input id="sp1" name=netIncome" class="mini-spinner"  minValue="0"
                                               maxValue="10000" format="n" style="width:90%"/>
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
<div id="form2" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input type="hidden" name="payId"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户支出情况信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">生产支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="productPay" class="mini-textbox" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">生活支出:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="livingPay" class="mini-textbox" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">医疗支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="medicalPay" class="mini-textbox" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">教育支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="educatePay" class="mini-textbox" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">参保支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="insuredPay" class="mini-textbox" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">其他支出:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="otherPay" class="mini-textbox" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>家庭年度支出总合计:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="totalPay" class="mini-textbox" style="width:90%"/>
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
<div id="form3" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input name="id" class="mini-hidden" />
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户房产基本信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>房产性质:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="houseProperty" class="mini-textbox" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>房屋类型:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="houseType" class="mini-combobox" style="width:90%"
                                               url="/bank/dic/HouseType.txt" emptyText="请选择..."/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>房屋地址:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="houseAddress" class="mini-textbox" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>建筑面积:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="buildArea" class="mini-textbox" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>购建年份:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="buildDate" class="mini-datepicker" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>购建价格:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="buildPrice" class="mini-textbox" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>占地面积:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="floorArea" class="mini-textbox" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>当前评估价格:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="assessPrice" class="mini-textbox" style="width:90%"/>
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
<div id="form4" style="width:90%;margin:auto auto">
    <form action="/bank/company/save.do" method="POST">
        <input type="hidden" name="forestId"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户林权情况基本信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">林权证编号:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="cardNum" class="mini-textbox" required="true"
                                               requiredErrorText="林权证编号不能为空"style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">林权字号:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="wordNum" class="mini-textbox" required="true"
                                               requiredErrorText="林权字号不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">林权使用人:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="user" class="mini-textbox" required="true"
                                               requiredErrorText="林权使用人不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">林权使用种类:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="useType" class="mini-textbox" required="true"
                                               requiredErrorText="林权使用种类不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">面积(亩):</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="area" class="mini-textbox" required="true"
                                               requiredErrorText="面积不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">蓄积量:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="storeNum" class="mini-textbox" required="true"
                                               requiredErrorText="蓄积量不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">使用权期限:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="timeLimit" class="mini-textbox" required="true"
                                               requiredErrorText="使用权期限不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox1$text">当前评估价格:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="assessPrice" class="mini-textbox" required="true"
                                               requiredErrorText="当前评估价格不能为空" style="width:90%"/>
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