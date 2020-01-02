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
	window.location.href="/searchSomething";
}
//$('#search').click(searchSth());