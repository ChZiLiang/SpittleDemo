//判断用户是否登录，控制显示导航栏中的登陆登出按钮显示
function cookie(){    
   var cookieArray=document.cookie.split("; "); //得到分割的cookie名值对    
   var cookie=new Object();
   var haveUsername=false;
   for (var i=0;i<cookieArray.length;i++){    
      var arr=cookieArray[i].split("=");       //将名和值分开    
      if(arr[0]=="username"){
    	   haveUsername=true;
    	   break;
      }
   } 
   if(haveUsername==true){
	   $('#re').hide();
	   $('#lo').hide();
	   $('#so').show();
	   console.log("true:"+haveUsername);
   }else{
	   document.getElementById("re").style.display="inline";
	   document.getElementById("lo").style.display="inline";
	   document.getElementById("so").style.display="none";
   }
} 
cookie();