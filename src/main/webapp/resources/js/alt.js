/*
var Alt=new _alert({		//预定义
	ttl:'a' ,		//标题
	cnt:'<a href="#">12</a>' ,		//正文，对窗体内定义文本及html
	ft:'<input type="button" class="yes_btn" value="ok">' ,		//页脚，主要是确定、取消等功能性按钮的独立区域，默认提供class为yes_btn与no_btn的样式
	overlay:true ,		//遮罩层
	showFn:function(obj){		//弹窗效果，默认为无效果弹出，此例为传入jquery淡入效果的用法
		$(obj).fadeIn(150);
	}
});
$("#alt").click(function(){
	Alt.build();		//执行弹窗
	$(Alt.alt).css({ 'width' :'400px' , 'margin-left' :'-200px' });		//此例展示通过配置oAddAlt.alt对弹窗样式重新定义的方法
});
$("#cls").click(function(){
	Alt.del();		//关闭弹窗
});

1、本插件使用预定义（极小开销），之后单独触发的分步进行方式；
2、实例化 _alert() 函数，并传入配置项，配置项对象包含以下属性：ttl（标题）、cnt（正文）、ft（脚部）、showFn（弹窗效果）、overlay（遮罩层）
3、实例化后得到的对象包含以下方法\属性：build()（弹窗）、del()（删除窗口）、alt（窗口对象）

*/
function _alert(opt){
	var dft={
		ttl : opt.ttl||'&nbsp;',
		cnt : opt.cnt||'',
		ft : opt.ft||'',
		overlay : opt.overlay||false,
		showFn : opt.showFn||function(obj){obj.style.display='block';}
	}
	var obj={};
	obj.build=build;
	obj.del=new Function();
	return obj;
	function build(){
		if(!obj.obj){
			var oAlt=document.createElement("ul");
			oAlt.className='_alert';
			oAlt.innerHTML='<li class="hd">'+dft.ttl+'<a class="cl_btn">&#215;</a></li><li class="cnt">'+dft.cnt+'</li><li class="ft">'+dft.ft+'</li>';
			function del(){
				oAlt.parentNode.removeChild(oAlt);
				if(dft.overlay){
					oOverlay.parentNode.removeChild(oOverlay);
					obj.overlay=null;
					oAlt.overlay=null;
				}
				obj.obj=null;
				obj.del=new Function();
				oAlt.del=new Function();
			};
			oAlt.getElementsByTagName("li")[0].getElementsByTagName("a")[0].onclick=del;
			if(dft.overlay){
				var oOverlay=document.createElement("div");
				oOverlay.className='_overlay';
				document.getElementsByTagName("body")[0].appendChild(oOverlay);
				obj.overlay=oOverlay;
				oAlt.overlay=oOverlay;
			}
			document.getElementsByTagName("body")[0].appendChild(oAlt);
			dft.showFn(oAlt);
			obj.obj=oAlt;
			obj.del=del;
			oAlt.del=del;
			return oAlt;
		}
	}
}
function _msg(opt){
	var dft={
		cnt : opt.cnt||'',
		showFn : opt.showFn||function(obj){obj.style.display='block';}
	}
	var obj={};
	obj.build=build;
	obj.del=new Function();
	return obj;
	function build(){
		if(!obj.obj){
			var oMsg=document.createElement("div");
			oMsg.className='_msg';
			oMsg.innerHTML='<p class="box"><span class="cnt">'+dft.cnt+'</span></p>';
			document.getElementsByTagName("body")[0].appendChild(oMsg);
			dft.showFn(oMsg);
			function del(){
				oMsg.parentNode.removeChild(oMsg);
				obj.obj=null;
				obj.del=new Function();
				oMsg.del=new Function();
			};
			obj.obj=oMsg;
			obj.del=del;
			oMsg.del=del;
			var time=dft.cnt.length<5?1000:dft.cnt.length*1000/5;
			setTimeout(del,time);
			return oMsg;
		}
	}
}
function _loading(){
	var obj={};
	obj.build=build;
	obj.del=new Function();
	return obj;
	function build(){
		if(!obj.obj){
			var oLd=document.createElement("div");
			oLd.className='_loading';
			oLd.innerHTML='<p class="box"></p>';
			document.getElementsByTagName("body")[0].appendChild(oLd);
			obj.obj=oLd;
			function del(){
				oLd.parentNode.removeChild(oLd);
				obj.obj=null;
				obj.del=new Function();
				oLd.del=new Function();
			};
			obj.del=del;
			oLd.del=del;
			return oLd;
		}
	}
}