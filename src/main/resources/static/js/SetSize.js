var height=window.innerHeight*0.8;//获取窗口高度
var row=document.getElementsByClassName("row")[0];//获取row class的元素
$(row).css({"height":height});
console.log(row.style.height);
window.addEventListener("resize", function () {
	height=window.innerHeight*0.8;
	row=document.getElementsByClassName("row")[0];
	$(row).css({"height":height});
});