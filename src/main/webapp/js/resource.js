
var local = (window.location+'').split('/');  
var basePath = local[0]+'//'+local[2]+'/'+local[3]+"/";
var staticPath=null;
var oAjax=window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");	

oAjax.onreadystatechange=function(){
    if(oAjax.readyState==4){
        if(oAjax.status==200){
        	staticPath=oAjax.responseText;//读取a.txt文件成功就弹出成功。后面加上oAjax.responseText会输出a.txt文本的内容
        }
    }
};

oAjax.open("GET",basePath+"common/staticpath",false);
//3.发送请求
oAjax.send();

document.write("<link rel='stylesheet' href='"+staticPath+"lib/bootstrap/css/bootstrap.min.css'>");
document.write("<link rel='stylesheet' href='"+staticPath+"lib/font-awesome/css/font-awesome.css'>");
document.write("<link rel='stylesheet' href='"+staticPath+"lib/easyui/themes/material/easyui.css'>");
document.write("<link rel='stylesheet' href='"+staticPath+"business/mainframe/css/index-dialog.css'>");
document.write("<link rel='stylesheet' href='"+staticPath+"business/component/css/component.css'>");
document.write("<link rel='stylesheet' href='"+staticPath+"business/common.css'>");

document.write("<script src='"+staticPath+"lib/jquery/jquery.min.js'><\/script>");

document.write("<script src='"+staticPath+"lib/jquery/jquery.json-2.2.js'><\/script>"); 
document.write("<script src='"+staticPath+"lib/bootstrap/js/bootstrap.min.js'><\/script>"); 
document.write("<script src='"+staticPath+"lib/easyui/jquery.easyui.min.js'><\/script>"); 
document.write("<script src='"+staticPath+"lib/easyui/locale/easyui-lang-zh_CN.js'><\/script>"); 
document.write("<script src='"+staticPath+"lib/vue/vue.min.js'><\/script>"); 
document.write("<script src='"+staticPath+"lib/echarts/echarts.min.js'><\/script>"); 
document.write("<script src='"+staticPath+"dist/summer-vue.min.js'><\/script>");
document.write("<script src='"+staticPath+"business/market-vue.min.js'><\/script>"); 
document.write("<script src='"+staticPath+"business/common.min.js'><\/script>"); 
document.write("<script src='"+staticPath+"business/mainframe/js/mainframe-util.js'><\/script>");
document.write("<script src='"+staticPath+"business/mainframe/js/index-dialog.js'><\/script>");
document.write("<script src='"+basePath+"js/util.js'><\/script>");


