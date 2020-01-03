function searchSth(){
	var searchText=$('#searchText').val();
	console.log(searchText);
/*	$.ajax({
		url:"/searchSomething",
		type:"POST",
		data:{'searchText':searchText},
		dataType:'json',
		success:function(data){
			console.log(data);
			 window.location.href =
		}
	})*/
	//拼接url，用window.location.href实现跳转+传参
	var url="searchSomething/"+searchText;
	console.log(url);
	window.location.href=url;
}
//$('#search').click(searchSth());