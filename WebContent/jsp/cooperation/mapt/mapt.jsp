<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/miniui/boot.js" type="text/javascript"></script>
<style type="text/css">
html,body
{
    padding:0;
    margin:0;
    border:0;     
    width:100%;
    height:100%;
    overflow:hidden;   
}
</style>

</head>
<body>
    <div class="mini-toolbar" style="text-align:center;line-height:30px;" 
        borderStyle="border-left:0;border-top:0;border-right:0;">
          <label >是否包含手动录入的数据</label>
          <input type="checkbox" onclick="containsSD()" id="containsSD" />
          <label style="padding-left:10px">名称：</label>
          <input id="key" class="mini-textbox" style="width:150px;" onenter="onKeyEnter"/>
          <a class="mini-button" style="width:60px;" onclick="search()">查询</a>
    </div>
    <div class="mini-fit">
        <ul id="tree1" class="mini-tree" style="width:100%;height:100%;" 
        	  url="${pageContext.request.contextPath}/economy/tMap/getMapTree.do"
            showTreeIcon="true" textField="text" idField="id" parentField="pid" resultAsTree="false"  
            expandOnLoad="true" onnodedblclick="onNodeDblClick" expandOnDblClick="false">
        </ul>
    
    </div>                
    <div class="mini-toolbar" style="text-align:center;padding-top:8px;padding-bottom:8px;" 
        borderStyle="border-left:0;border-bottom:0;border-right:0;">
        <a class="mini-button" style="width:60px;" onclick="onOk()">确定</a>
        <span style="display:inline-block;width:25px;"></span>
        <a class="mini-button" style="width:60px;" onclick="onCancel()">取消</a>
    </div>
 
</body>
</html>
<script type="text/javascript"> 
    mini.parse();
 
    var tree = mini.get("tree1");
    tree.load();
    function containsSD(){
	var url = '';
	    	if($('#containsSD').is(':checked')) {
	    		url = "/bank/economy/tMap/getMapTree.do?t='sourcecode_sourcename','sourcecode_sourcename_sd'";
	    		tree.setUrl(url);
	    		tree.load();
	    	}else{
	    		url = "/bank/economy/tMap/getMapTree.do";
	    		tree.setUrl(url);
	    		tree.load();
	    	}
    }
    function GetData() {
        var node = tree.getSelectedNode();
        return node;
    }
    function search() {
        var key = mini.get("key").getValue();
        if(key == ""){
            tree.clearFilter();
        }else{
            key = key.toLowerCase();
            tree.filter(function (node) {
                var text = node.text ? node.text.toLowerCase() : "";
                if (text.indexOf(key) != -1) {
                    return true;
                }
            });
        }
    }
    function onKeyEnter(e) {
        search();
    }
    function onNodeDblClick(e) {
        onOk();
    }
    //////////////////////////////////
    function CloseWindow(action) {
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
    }
 
    function onOk() {
        var node = tree.getSelectedNode();
        if (node && tree.isLeaf(node) == false) {
            //alert("不能选中父节点");
            return;
        }
 
        CloseWindow("ok");        
    }
    function onCancel() {
        CloseWindow("cancel");
    }
 
    
</script>