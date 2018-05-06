/**
 * 
 */
function addselct(){
	var input= document.createElement('input');
	var d2=document.getElementById("f1");
	input.type="text";
	input.setAttribute("name", "question.valueList");
	input.value="请填入输入的问题选项";
	input.setAttribute("onfocus","javascript:if(this.value=='请填入输入的问题选项')this.value='';");
	d2.appendChild(input);
}