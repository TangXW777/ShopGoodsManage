$(function(){
	$('#addSort').click(function(){
		$('#add').show();
	});
	
	
	
	
	$('input[type=text]').blur(function(e){
		if($(this).val() == ''){
			
		}else{
			$('input[type=button]').click(function(){
				var flag = false;
				alert($('input[type=text]').val());
				$.ajax({
					type : 'post',
					url : '/ShopGoodsManage/servlet/AddCategoryServlet',
					date : {
						'sort' : $('input[type=text]').val()
					},
					success : function(response, status, xhr){  // ���շ��ص�����
						if(response != 'false'){
							alert('true');
							flag = true;
						}alert('false')
					}			
				});
				if(flag){
					$('form').submit();
				}
			});
		}
	});
	
	/*
	
	var flag = function(){
		$('input[name=sort]').blur(function(){ // ʧȥ�����ʱ��
			if($(this).val() != ''){ // ��Ϊ��
				$.ajax({
					type : 'post',
					url : '/ShopGoodsManage/servlet/AddCategoryServlet',
					date : {
						sort : $('input[type=text]').val()
					},
					success : function(response, status, xhr){  // ���շ��ص�����
						if(response == 'false'){
							return false;
						}
					}			
				});

				return true;
				
			}else{
				alert('��');
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

