$(function(){
	$('#addSort').click(function(){
		$('#add').show();
	});
	
	
	$('input[type=button]').click(function(){
		var error = '';
		var flag = false;
		if($('input[type=text]').val() == ''){
			error = 'not empty';
		}else{
			$.ajax({
				async : false,  // 同步
				type : 'post',
				url : '/ShopGoodsManage/servlet/AddCategoryServlet',
				data : {
					'sort' : $('input[type=text]').val()
				},
				success : function(response, status, xhr){  // 接收返回的数据
					//alert(response);
					if(response == 'true'){
						error = 'success';
						flag = true;
					}else{
						error = 'repetitive sort';
					}
				}
			});
		}
		$('span.error').html(error);
		if(flag){
			$('form').submit();
		}
	});
/*	
	$('input[type=text]').blur(function(e){
		var error = '';
		if($(this).val() == ''){
			error = 'not empty';
			
		}else{
			$('input[type=button]').click(function(){
				var flag = false;
				$.ajax({
					async : false,
					type : 'post',
					url : '/ShopGoodsManage/servlet/AddCategoryServlet',
					data : {
						'sort' : $('input[type=text]').val()
					},
					success : function(response, status, xhr){  // 接收返回的数据
						//alert(response);
						if(response == 'true'){
							error = 'success';
							flag = true;
						}else{
							error = 'repetition sort';
						}
					}			
				});
				//$('span.error').html(error);
				alert(error+'1');
				if(flag){
					$('form').submit();
				}
			});
		}
		alert(error+'2');
		$('span.error').html(error);
	});
	*/
	/*
	
	var flag = function(){
		$('input[name=sort]').blur(function(){ // 失去焦点的时候
			if($(this).val() != ''){ // 不为空
				$.ajax({
					type : 'post',
					url : '/ShopGoodsManage/servlet/AddCategoryServlet',
					date : {
						sort : $('input[type=text]').val()
					},
					success : function(response, status, xhr){  // 接收返回的数据
						if(response == 'false'){
							return false;
						}
					}			
				});

				return true;
				
			}else{
				alert('空');
				return false;
			}
		})
	};
	
	$('input[type=button]').click(function(){
		alert('flag');
		alert(flag());
		if(flag()){
			alert(flag());
			alert('dsf');
			$('form').submit();
		}else{
			alert('sf');
		}
	});
	*/
});

