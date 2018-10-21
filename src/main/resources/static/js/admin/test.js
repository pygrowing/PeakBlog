alert("js存在");
function ajaxSubmit(){
	alert("点击");
}


$("#fabiao").click(function() {
	alert("进来了");
	
//	$('#form1').ajaxSubmit({      //ajax方式提交表单
//		url: 'admin/saveblog',
//		type: 'post',
//		dataType: 'json',
//		beforeSubmit: function () {},
//		success: function (data) {
//			if (data.success) {
//				alert(data.message); 
//			} else {
//				alert(data.message); 
//			}
//		},
//		clearForm: false,//禁止清楚表单
//		resetForm: false //禁止重置表单
//	}); 
	
	  $.ajax({
	    //几个参数需要注意一下
	        type: "POST",//方法类型
	        dataType: "json",//预期服务器返回的数据类型
	        url: "/admin/saveblog",//url
	        data: $('#form1').serialize(),
	        success: function (result) {
	            console.log(result);//打印服务端返回的数据(调试用)
	            if (result.success)) {
	                alert(result.message);
	            }
	        },
	        error : function() {
	            alert("异常！");
	        }
	    });
	
});



//$(function(){
	/** 验证文件是否导入成功  */
	
//	$("#fabiao").click(function(){
//		var imageData = $(".dropify").val();
//		if(imageData==""|| str == undefined || str == null){
//			alert("图片不能为空");
//			return false;
//		}else{
//			$("#form1").ajaxForm(function(data){  
//				if(data.success){
//					alert(data.message);   
//				}
//			});
//		}
//		 
//	});
	
	
	 
//	
//	$("#form1").ajaxForm(function(data){  
//		if(data.success){
//			alert(data.message);   
//		}
//	});
	
	
//});
		