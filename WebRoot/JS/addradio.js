/**
 * 
 */
function addradio(){
	var li1 = document.createElement('li'); //1、创建元素
	var li2 = document.createElement('li'); //1、创建元素
	var ul = document.createElement('ul');//
	var d2=document.getElementById('d2');
	 d2.appendChild(ul);
	 ul.appendChild(li1);
	 ul.appendChild(li2);
	var input1= document.createElement('input');
	input1.type="text";
	input1.setAttribute("name", "question.title");
	input1.value="请填入输入的问题";
	input1.setAttribute("onfocus","javascript:if(this.value=='请填入输入的问题')this.value='';");
	li1.appendChild(input1);
	var input2= document.createElement('input');
	input2.type="text";
	input2.value="请填入你的问题选项";
	input2.setAttribute("name", "str");
	input2.setAttribute("onfocus","javascript:if(this.value=='请填入你的问题选项')this.value='';");
	li2.appendChild(input2);
	var input3= document.createElement('input');
	input3.type="button";
	input3.value="+";
	li2.appendChild(input3);
	var input4= document.createElement('input');
	input4.type="button";
	input4.value="--";
	li2.appendChild(input4);
	input4.onclick=function() {
		ul.removeChild(li1);
		ul.removeChild(li2);
	};
	input3.onclick=function() {
		var input= document.createElement('input');
		input.type="text";
		input.setAttribute("name", "str");
		input.value="请填入你的问题选项";
		input.setAttribute("onfocus","javascript:if(this.value=='请填入你的问题选项')this.value='';");
		var input4= document.createElement('input');
		input4.type="button";
		input4.value="-";
		 ul.appendChild(li2);	
		li2.appendChild(input);
		li2.appendChild(input4)
		input4.onclick=function() {
			li2.removeChild(input);
			li2.removeChild(input4);
		};
    };  
}
