<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
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
     .display{
     	display:block;
     }
     .hidden{
     	display:none;
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
        <td width="200px" id="guid1" class="active" align="center" onclick="linkUrl(1)">农户基本信息</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid2" class="inactive" align="center" onclick="linkUrl(2)">农户收支信息</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid3" class="inactive" align="center" onclick="linkUrl(3)">农户信贷信息</td>
        <td width="1px" class="line"></td>
        <td width="200px" id="guid4"  class="inactive" align="center" onclick="linkUrl(4)">农户信用信息</td>        
        <td width="1px" class="line"></td>
        <td width="200px" id="guid4"  class="inactive" align="center" ><button onclick="save()">保存</button></td>
    </tr>
</table>
<div id="tab1" class="display">
<div id="farmer" style="width:90%;margin:auto auto">
<form method="POST">
		<input name="id" class="mini-hidden" />
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
           <tr>
                <td colspan="4" style="width:100%">
                    <fieldset id="fd2" style="width:100%;margin:auto auto">
                        <legend><label>农户基本概况信息</label></legend>
                        <div class="fieldset-body">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="farmerName$text"><font color="red">*</font>户主姓名:</label></td>
                                    <td style="width:40%">
                                        <input id="farmerName"  name="farmerName" class="mini-textbox" required="true"
                                               requiredErrorText="户主姓名不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>户主身份证号:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="farmerIdnum" class="mini-textbox" required="true"
                                               requiredErrorText="户主身份证号不能为空"  style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>政治面貌:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="politicStatus" class="mini-combobox" required="true"
                                               requiredErrorText="政治面貌不能为空" style="width:90%"
                                               url="/bank/dic/PoliticStatus.txt" emptyText="请选择..."/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>家庭人数:</label></td>
                                    <td style="width:40%" >
                                        <input id="sp1" name=familyNum" class="mini-spinner"  minValue="1"
                                               maxValue="10" style="width:90%"/>

                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>联系电话:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="phone" class="mini-textbox" required="true"
                                               requiredErrorText="联系电话不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>现住址:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="address" class="mini-textarea" required="true"
                                               requiredErrorText="现住址不能为空"  style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"> 婚姻状况:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="marryStatus" class="mini-combobox" required="true"
                                               requiredErrorText="婚姻状况不能为空" style="width:90%"
                                               url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"> 劳动力人数:</label></td>
                                    <td style="width:40%" >
                                        <input  name="laborNum" class="mini-spinner"  minValue="1"
                                               maxValue="10" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"> 邮政编码:</label></td>
                                    <td style="width:40%">
                                        <input id="sp1" name=postCode" class="mini-spinner"  minValue="100000"
                                               maxValue="99999"  style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"> 主要农作物年度净收入合计:</label></td>
                                    <td style="width:40%" >
                                        <input id="sp1" name=nyNetincome" class="mini-spinner"  minValue="200"
                                               maxValue="250" format="n" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"> 林、牧、副、渔业年度净收入合计:</label></td>
                                    <td style="width:40%">
                                        <input id="sp1" name=fnNetincome" class="mini-spinner"  minValue="200"
                                                maxValue="250" format="n" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"> 家庭工商业年度净收入合计:</label></td>
                                    <td style="width:40%" >
                                        <input id="sp1" name=gsNetincome" class="mini-spinner"  minValue="200"
                                               maxValue="250" format="n" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"> 外出务工年度净收入合计:</label></td>
                                    <td style="width:40%">
                                        <input id="sp1" name=dgNetincome" class="mini-spinner"  minValue="200"
                                               maxValue="250" format="n" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"> 其他收入年度净收入合计:</label></td>
                                    <td style="width:40%">
                                        <input id="sp1" name=qtNetincome" class="mini-spinner"  minValue="200"
                                               maxValue="250" format="n" style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"> 家庭年度总收入合计:</label></td>
                                    <td style="width:40%">
                                        <input id="sp1" name=allNetincome" class="mini-spinner"  minValue="200"
                                               maxValue="250" format="n" style="width:90%"/>
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
<div id="farmerMember" style="width:90%;margin:auto auto">
<fieldset id="fd2" style="width:100%;margin:auto auto">
<legend><label>家庭成员基本情况</label></legend>
<div class="fieldset-body">
<table width="100%">
<tr>
<td>
    <div id="farmerMember1">
    <form action="/bank/company/save.do" method="POST">
        <input type="hidden" name="id"/>
        <input name="recorder" class="mini-hidden" value="管理员"/>
        <input name="recordTime" class="mini-hidden" value="${currentTime}"/>
        <table border="0" cellpadding="1" cellspacing="15" width="100%" >
            <tr>
                <td colspan="4" style="width:100%">
                            <table width="100%">
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>家庭成员姓名:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="name" class="mini-textbox" required="true"
                                               requiredErrorText="家庭成员姓名不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>与户主关系:</label></td>
                                    <td style="width:40%" >
                                        <input id="relation"  name="relation" class="mini-combobox" required="true"
                                               requiredErrorText="与户主关系不能为空"  style="width:90%"
                                               url="${pageContext.request.contextPath}/dic/Relation.txt" emptyText="请选择..."/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"><font color="red">*</font>身份证号:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="idNum" class="mini-textbox" required="true"
                                               requiredErrorText="身份证号不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text"><font color="red">*</font>文化程度:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="education" class="mini-combobox" required="true"
                                               requiredErrorText="文化程度不能为空"  style="width:90%"
                                               url="/bank/dic/Education.txt" emptyText="请选择..."/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">  婚姻状况:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="marryStatus" class="mini-combobox" required="true"
                                               requiredErrorText="婚姻状况不能为空" style="width:90%"
                                               url="/bank/dic/MarryStatus.txt" emptyText="请选择..."/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">  职业:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="occupation" class="mini-textbox" required="true"
                                               requiredErrorText="职业不能为空"  style="width:90%"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text"> 职务:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="job" class="mini-textbox" required="true"
                                               requiredErrorText="职务不能为空" style="width:90%"/>
                                    </td>
                                    <td style="width:10%"><label for="textbox2$text">  性别:</label></td>
                                    <td style="width:40%" >
                                        <input id="textbox2"  name="sex" class="mini-combobox" required="true"
                                               requiredErrorText="性别不能为空" style="width:90%"
                                               url="/bank/dic/Sex.txt" emptyText="请选择..."/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:10%"><label for="textbox1$text">  联系电话:</label></td>
                                    <td style="width:40%">
                                        <input id="textbox1"  name="phone" class="mini-textbox" required="true"
                                               requiredErrorText="联系电话不能为空" style="width:90%"/>
                                    </td>
                                </tr>
                            </table>
                </td>
            </tr>
        </table>
    </form>
   </div>
    </td>
</tr>
<tr>
   <td align="center" >
       <button onclick="addMember()">新增</button>
   </td>
</tr>
</table>
        </div>
    </fieldset>
</div>
</div>
<div id="tab2" class="hidden">
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
</div>
<div id="tab3" class="hidden">
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
</div>
<div id="tab4" class="hidden">
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
</div>
<script type="text/javascript">
	mini.parse();
	var farmer =new mini.Form("#farmer");
    function save(){
    
    	var farmerMember = new mini.Form("farmerMember");
	    var formData = farmer.getData();      //获取表单多个控件的数据
	    var farmerMemberData=farmerMember.getData();
	    var farmerMemberJson = mini.encode(farmerMemberData);   //序列化成JSON
	    alert(farmerMemberJson);
	   // $.ajax({
	    //    url: "${pageContext.request.contextPath}/farmer/saveFarmer.do",
	    //    type: "post",
	    //    data: { formData: json},
	    //    contentType: "application/x-www-form-urlencoded; charset=utf-8",
	    //    success: function (text) {
	    //    	var data = mini.decode(text);   //反序列化成对象
		//        if(data.farmerId!=null){
		//        	farmer.setData(data);  
		//        }
	   //     	 mini.alert('保存成功！');
	    //    },
	   //     error: function (jqXHR, textStatus, errorThrown) {
	   //         mini.alert('系统异常！');
	    //    }
  		//});
    }
  function addMember(){
	  $("#farmerMember").clone(true).insertAfter($("#farmerMember"));
	 
	
  }
  function linkUrl(index){
	  var tab="tab"+index;
	  var guid="#guid"+index;
	  if($(".display")[0].id!=tab){
		  tab="#"+tab;
		  $(".display").addClass("hidden");
		  $(".display").removeClass("display");
		  $(".active").removeClass("active");
		  $(".active").addClass("inactive");
		  $(tab).addClass("display");
		  $(tab).removeClass("hidden");
		  $(guid).addClass("active");
		  $(guid).removeClass("inactive");
	  }
  }

</script>
</body>
</html>