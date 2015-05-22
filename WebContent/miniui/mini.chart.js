mini.Chart = function () {
    mini.Chart.superclass.constructor.call(this);
    this.el.className += ' mini-chart';
}

mini.extend(mini.Chart, mini.ValidatorBase, {
    uiCls: "mini-chart",
    _InputType: "text",
    url : "",
    ajaxData : null,
    _attrs : null,
    
    _create: function () {
		this.el = document.createElement("div");
    },
    
    _doLoad: function (params) {
        try {
            var url = eval(this.url);
            if (url != undefined) {
                this.url = url;
            }
        } catch (e) { }
        var url = this.url;
        var ajaxMethod = "get";


        var e = {
            url: this.url,
            async: false,
            type: this.ajaxType ? this.ajaxType : ajaxMethod,
            data: params,
            params: params,
            cache: false,
            cancel: false
        };
        if (e.data != e.params && e.params != params) {
            e.data = e.params;
        }
        var sf = this;
        var url = e.url;
        mini.copyTo(e, {
            success: function (text) {
                var data = null;
                try {
                    data = mini.decode(text);
                } catch (ex) {
                    data = []
                    if (mini_debugger == true) {
                        alert(url + "\njson is error.");
                    }
                }
                if (sf.dataField) {
                    data = mini._getMap(sf.dataField, data);
                }
                if (!data) data = [];
                var ex = { data: data, cancel: false }
                sf.fire("preload", ex);
                if (ex.cancel == true) return;

                sf.setData(ex.data);

                sf.fire("load");

                setTimeout(function () {
                    sf.doLayout();
                }, 100);

            },
            error: function (jqXHR, textStatus, errorThrown) {
                var e = {
                    xmlHttp: jqXHR,
                    errorMsg: jqXHR.responseText,
                    errorCode: jqXHR.status
                };
                if (mini_debugger == true) {
                    alert(url + "\n" + e.errorCode + "\n" + e.errorMsg);
                }
                sf.fire("loaderror", e);
            }
        });
        if (url.indexOf(".txt") != -1 || url.indexOf(".json") != -1 || url.indexOf(".xml") != -1) {
        	this.ajaxData = mini.ajax(e).responseText;
        } else {
        	this.ajaxData= eval("(" + mini.ajax(e).responseText +")");
        }
        return this.ajaxData;
    },
    
    setUrl: function (value) {
   	    this.url = value;
    },
    
    getUrl: function () {
        return this.url;
    }, 
    
    setAttrs: function (value) {
   	    this._attrs = value;
    },
    
    getAttrs: function () {
        return this._attrs;
    },
    
    setAjaxData: function (value) {
   	    this.ajaxData = value;
    },
    
    getAjaxData: function () {
        return this.ajaxData;
    }, 
    
    getAttrs: function (el) {
        var attrs = mini.Chart.superclass.getAttrs.call(this, el);

        return attrs;
    },
    
    
    destroy: function (removeEl) {
    	if(this._valueEl != null){
    		this._valueEl.destroy();
    	}
    	mini.Chart.superclass.destroy.call(this, removeEl);
    }
});
mini.regClass(mini.Chart, 'chart');

// //////////////////////////////////////////////
//
// Bar2D
//
// //////////////////////////////////////////////
mini.Bar2D = function () {
	mini.Bar2D.superclass.constructor.call(this);
}

mini.extend(mini.Bar2D, mini.Chart, {
    uiCls: "mini-bar2d",
    _InputType: "text",
    _attrs : null,
    url : "",
    ajaxData : null,
    width : 800,
    height : 600,
    
    _create: function () {
		this.el = document.createElement("div");
    },

    initChart: function (id, jsonData) {
    	this.el.id = id;
    	var chart = echarts.init(document.getElementById(id));  
    	setTimeout(function (){
			window.onresize = function () {
				chart.resize();
			}
		},200)		
    	if (typeof jsonData == "string"){
    		var jsonDataObject = JSON.parse(jsonData);
    		chart.setOption(jsonDataObject); 
    	}else{
    		chart.setOption(jsonData); 
    	}
    },
    
    setUrl: function (value) {
    	mini.Bar2D.superclass.setUrl(value);
   	    if(!(value === null || value === undefined)){
   	    	this.load(value);
   	    }
    },
    
    getUrl: function () {
        return mini.Bar2D.superclass.getUrl();
    }, 
    
    setWidth: function (value) {
   	    this.width = value;
    },
    
    getWidth: function () {
        return this.width;
    }, 
    
    setHeight: function (value) {
   	    this.height = value;
    },
    
    getHeight: function () {
        return this.height;
    },

    load: function (url) {
    	mini.Bar2D.superclass.setUrl(url);
    	this.ajaxData = mini.Bar2D.superclass._doLoad({});
    	this.initChart(this.id, this.ajaxData);
    },
    
    getAttrs: function (el) {
    	mini.Bar2D.superclass.setAttrs(el.attributes);
        var attrs = mini.Bar2D.superclass.getAttrs.call(this, el);
        var jq = jQuery(el);

        mini._ParseString(el, attrs,
            ["width","height","url"]
        );

        return attrs;
    },
    
   
    destroy: function (removeEl) {
    	if(this._valueEl != null){
    		this._valueEl.destroy();
    	}
        mini.Bar2D.superclass.destroy.call(this, removeEl);
    }
});
mini.regClass(mini.Bar2D, 'bar2d');

// //////////////////////////////////////////////
// END
// //////////////////////////////////////////////


// //////////////////////////////////////////////
//
// 统一处理图形
//
// //////////////////////////////////////////////

mini.Eompechart = function () {
	mini.Eompechart.superclass.constructor.call(this);
}

mini.extend(mini.Eompechart, mini.Chart, {
    uiCls: "mini-eompechart",
    _InputType: "text",
    _attrs : null,
    url : "",
    ajaxData : null,
    width : 800,
    height : 600,
    titletext : "",
    resizeable : true,
    chart : null,
    values : null,
    
    _create: function () {
		this.el = document.createElement("div");
    },

    initChart: function (id) {
    	this.el.id = id;
    	chart = echarts.init(document.getElementById(id));  
        	setTimeout(function (){
    			window.onresize = function () {
    				chart.resize();
    			}
    		},200)	
    	return chart;
    },
    
    setUrl: function (value) {
    	mini.Eompechart.superclass.setUrl(value);
   	    if(!(value === null || value === undefined)){
   	    	this.load(value);
   	    }
    },
    
    getUrl: function () {
        return mini.Eompechart.superclass.getUrl();
    }, 
    
    setWidth: function (value) {
   	    this.width = value;
    },
    
    getWidth: function () {
        return this.width;
    }, 
    
    setHeight: function (value) {
   	    this.height = value;
    },
    
    getHeight: function () {
        return this.height;
    },
    
    setTitletext: function (value) {
    	this.titletext = value;
    },
    
    getTitletext: function () {
        return this.titletext;
    },
    
    setTitlesubtext: function (value) {
    	this.titlesubtext = value;
    },
    
    getTitlesubtext: function () {
        return this.titlesubtext;
    },
    
    
    setTitlexposition: function (value) {
    	this.titlexposition = value;
    },
    
    getTitlexposition: function () {
        return this.titlexposition;
    },
    
    
    setTitleyposition: function (value) {
    	this.titleyposition = value;
    },
    
    getTitleyposition: function () {
        return this.titleyposition;
    },
    
    
    setTitlelink: function (value) {
    	this.titlelink = value;
    },
    
    getTitlelink: function () {
        return this.titlelink;
    },
    
    setResizeable: function (value) {
        this.resizeable = value;
    },
    
    getResizeable: function () {
        return this.resizeable;
    },
    
    load: function (url) {
    	mini.Eompechart.superclass.setUrl(url);
    	this.ajaxData = mini.Eompechart.superclass._doLoad({});
    	this.initChart(this.id);
    	this.setOptionData();
    },
    
    
    setOptionData : function (){
    	this.setTitle();
    	chart.setOption(this.ajaxData); 
    },
    
    
    setTitle : function(){
    	if (values.titletext != null && values.titletext != undefined && values.titletext != ''){
    		this.ajaxData.title.text = values.titletext;}
		if (values.titlesubtext != null && values.titlesubtext != undefined && values.titlesubtext != ''){
			this.ajaxData.title.subtext = values.titlesubtext;}		
		if (values.titlexposition != null && values.titlexposition != undefined && values.titlexposition != ''){
			this.ajaxData.title.x = values.titlexposition;}
		if (values.titleyposition != null && values.titleyposition != undefined && values.titleyposition != ''){
			this.ajaxData.title.y = values.titleyposition;}
		if (values.titlelink != null && values.titlelink != undefined && values.titlelink != ''){
			this.ajaxData.title.link = values.titlelink;}
		
    },
    
    
    
    getAttrs: function (el) {
    	mini.Eompechart.superclass.setAttrs(el.attributes);
        var attrs = mini.Eompechart.superclass.getAttrs.call(this, el);
        var jq = jQuery(el);
        mini._ParseString(el, attrs,
            ["width","height","url","titletext","titlesubtext","titlexposition","titleyposition","titlelink"]
        );
        mini._ParseBool(el, attrs,
                ["resizeable"]
            );
        values = attrs;
        return attrs;
    },
    
    
   
    destroy: function (removeEl) {
    	if(this._valueEl != null){
    		this._valueEl.destroy();
    	}
        mini.Eompechart.superclass.destroy.call(this, removeEl);
    }
});
mini.regClass(mini.Eompechart, 'eompechart');









