function checkForm(){
	var isTrue=true;
	//验证姓氏
	var firstname=document.getElementById("firstname");
	var firstnamefeedback=document.getElementById("firstname-feedback");
	console.log(firstname.value);
	var nameChineseReg=/^[\u0391-\uFFE5]+$/;
	var nameEnglishReg=/^[a-zA-Z]+$/;
	//清除可能的非法状态
	firstnamefeedback.innerHTML="";
	firstname.classList.remove("is-invalid");
	if(firstname.value==""||firstname.value.length>30){
		firstnamefeedback.innerHTML="姓氏不能为空且不能大于30字符";
		firstname.classList.remove("is-valid");//清除合法状态
		firstname.classList.add("is-invalid");//添加非法状态
        isTrue=false;
	}else if(!(nameChineseReg.test(firstname.value)||nameEnglishReg.test(firstname.value))){
		firstnamefeedback.innerHTML="姓氏不能为非中英文字符";
		firstname.classList.remove("is-valid");//清除合法状态
		firstname.classList.add("is-invalid");//添加非法状态
        isTrue=false;
	}
	
	//验证名字
	var lastname=document.getElementById("lastname");
	var lastnamefeedback=document.getElementById("lastname-feedback");
	console.log(lastname.value);
	var nameChineseReg=/^[\u0391-\uFFE5]+$/;
	var nameEnglishReg=/^[a-zA-Z]+$/;
	//清除可能的非法状态
	lastnamefeedback.innerHTML="";
	lastname.classList.remove("is-invalid");
	if(lastname.value==""||lastname.value.length>30){
		lastnamefeedback.innerHTML="名字不能为空且不能大于30字符";
		lastname.classList.remove("is-valid");//清除合法状态
		lastname.classList.add("is-invalid");//添加非法状态
		isTrue=false;
	}else if(!(nameChineseReg.test(lastname.value)||nameEnglishReg.test(lastname.value))){
		lastnamefeedback.innerHTML="名字不能为非中英文字符";
		lastname.classList.remove("is-valid");//清除合法状态
		lastname.classList.add("is-invalid");//添加非法状态
        isTrue=false;
	}
	
	//验证邮箱
	var email=document.getElementById("email");
	var emailfeedback=document.getElementById("email-feedback");
	console.log(email.value);
	//清除可能的非法状态
	emailfeedback.innerHTML="";
	email.classList.remove("is-invalid");
	var emailReg=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/
	if(!emailReg.test(email.value)){
		emailfeedback.innerHTML="邮箱格式错误";
		email.classList.remove("is-valid");//清除合法状态
		email.classList.add("is-invalid");//添加非法状态
		isTrue=false;
	}
	
	//验证用户名
	var username=document.getElementById("username");
	var usernamefeedback=document.getElementById("username-feedback");
	var judgeUsername=true;
	console.log(username.value);
	//清除可能的非法状态
	usernamefeedback.innerHTML="";
	username.classList.remove("is-invalid");
	if(username.value.length<5||username.value.length>16){
		usernamefeedback.innerHTML="用户名需要5~16个字符";
		username.classList.remove("is-valid");//清除合法状态
		username.classList.add("is-invalid");//添加非法状态
		isTrue=false;
	}else{
		$.ajax({
			url:'/judgeUsername',
			type: 'POST',
			contentType : 'application/json;charset=utf-8',
			dataType : 'json',
			data: JSON.stringify({"username":username.value}),
			async:true,
			success:function(data){
					console.log(data.haveSameUsername);
					judgeUsername=data.haveSameUsername;
					if(judgeUsername==true){
						console.log(judgeUsername);
						usernamefeedback.innerHTML="用户名需要唯一";
						username.classList.remove("is-valid");//清除合法状态
						username.classList.add("is-invalid");//添加非法状态
						isTrue=false;
					}
				}
			})
	}
	
	//验证密码
	var password=document.getElementById("mima");
	var passwordfeedback=document.getElementById("password-feedback");
	console.log(password.value);
	//清除可能的非法状态
	passwordfeedback.innerHTML="";
	password.classList.remove("is-invalid");
	if(password.value.length<5||password.value.length>25){
		passwordfeedback.innerHTML="密码需要5~25个字符";
		password.classList.remove("is-valid");//清除合法状态
		password.classList.add("is-invalid");//添加非法状态
		isTrue=false;
	}
	
	return isTrue;
}