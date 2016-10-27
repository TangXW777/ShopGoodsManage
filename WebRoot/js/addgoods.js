var flag = false;

$(function(){

	// 编号，正整数
	$('input[name=goodsno]').blur(function(){
		var reg = /^[1-9][0-9]*$/;
		if(reg.test($(this).val())){
			flag = true;
			$(this).next('span').css('color','red').html('');
		}else{
			flag = false;
			$(this).next('span').css('color','red').html('must be positive integer or repetitive No');
		}
	});

	// 商品名，不为空
	$('input[name=goodsname]').blur(function(){
		if($(this).val() == ''){
			flag = false;
			$(this).next('span').css('color','red').html('not empty');
		}else{
			flag = true;
			$(this).next('span').css('color','red').html('');
		}
	});

	// 价格，小数点两位
	$('input[name=goodsprice]').blur(function(){
		var reg = /^(([1-9]\d*)|0)(\.\d{2})$/;
		if(reg.test($(this).val())){
			flag = true;
			$(this).next('span').css('color','red').html('');
		}else{
			flag = false;
			$(this).next('span').css('color','red').html('two decimal places');
		}
	});

	// 生产日期，xxxx-MM-yy,使用ajax在java中验证
	$('input[name=goodsdate]').blur(function(){
		var reg = /^([1-9]\d{3})\-(([0[1-9])|(1[0-2]))\-((0[1-9])|([1-2][0-9])|(3[0-1]))$/;
		if(reg.test($(this).val())){
			flag = true;
			$(this).next('span').css('color','red').html('');
		}else{
			flag = false;
			$(this).next('span').css('color','red').html('format for xxxx-MM-yy');
		}
	});

	// 保质期，正整数
	$('input[name=goodswarranty]').blur(function(){
		var reg = /^[0-9]*$/;
		if(reg.test($(this).val())){
			flag = true;
			$(this).next('span').css('color','red').html('');
		}else{
			flag = false;
			$(this).next('span').css('color','red').html('must be positive integer');
		}
	});
	
});

function checkForm(){
	$.ajax({
		async : false,
		type : 'post',
		url : '/ShopGoodsManage/servlet/StartAddGoodsServlet',
		data : $('form').serialize(),
		success : function(response, status, xhr){
			if(response == 'empty'){
				$('input[type=reset]').next('span').css('color','red').html('not empty');
				flag = false;
			}else if(response == 'errordate'){
				$('input[name=goodsdate]').next('span').css('color','red').html('error date');
				flag = false;
			}else if(response == 'success'){
				$('input[type=reset]').next('span').css('color','red').html('success');
				flag = true;
			}else{
				$('input[type=reset]').next('span').css('color','red').html('failue');
				flag = false;
			}
		}
	});
	return flag;
}

