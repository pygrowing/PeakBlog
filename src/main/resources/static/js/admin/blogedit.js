function ajaxSubmit(){
	alert("点击");
		
}

$("#fabiao").click(function(){
	var blogTitle=$('#blogTitle').val();
	var blogContent=$('#blogContent').val();
	var tags=$('#tagsinput').val();
//	var imageFile = $('#input-file-events').val();
	if(blogTitle =='' ||blogTitle==null ||blogTitle==undefined){
		spop({template: '文章标题不能为空',position  : 'top-center',style: 'error',autoclose: 4000});
		return false;
	}
	if(blogContent =='' ||blogContent==null ||blogContent==undefined){
		spop({template: '文章内容不能为空',position  : 'top-center',style: 'error',autoclose: 4000});
		return false;
	}
//	if(imageFile =='' ||imageFile==null ||imageFile==undefined){
//		spop({template: '请选择上传一张图片用于文章封面',position  : 'top-center',style: 'error',autoclose: 4000});
//		return false;
//	}
	if(tags =='' ||tags==null ||tags==undefined){
		spop({template: '请选择至少一个文章标签',position  : 'top-center',style: 'error',autoclose: 4000});
		return false;
	}
	
	// 获取 CSRF Token 
	var csrfToken = $("meta[name='_csrf']").attr("content");
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	
	var form = new FormData(document.getElementById("form1"));
	alert(form);
	$.ajax({
	    url: "/admins/saveblog",
	    type: "POST",
	    dataType: "json",
	    async: false,  
		cache: false,
		data:form,
		processData:false,  //不处理数据
        contentType:false,  //不设置内容类型
		beforeSend: function(request) {
			 request.setRequestHeader(csrfHeader, csrfToken); // 添加  CSRF Token 
		},
		 success: function(data){
			 if (data.success) {
				 spop({template: data.message,position  : 'top-right',style: 'success',autoclose: 4000});
			 } else {
				 spop({template: data.message,position  : 'top-right',style: 'error',autoclose: 4000});
			 }
			 
	     },
	     error : function() {
	    	 spop({template: '请求发生错误',position  : 'top-right',style: 'error',autoclose: 4000});
	     }
	})
});