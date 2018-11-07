$("#draft").click(function(){
	var drafts = '0';
	saveBlog(drafts);
});

$("#publish").click(function(){
	var drafts = '1';
	saveBlog(drafts);
});

function onblurs(){ 
	var number = /^[0-9]*$/;
	var blank = /\s/;
	var post = $("#blogPost").val();
	
	if(post != ""){
		if (number.test(post)) {
		　　　spop({template: '请不要将POST设置为纯数字,防止与id重合',position  : 'top-center',style: 'error',autoclose: 4000});
		　　　return false;
		}
		if(blank.test(post)){
			spop({template: '请不要在POST中输入包含空格在内的等非法字符',position  : 'top-center',style: 'error',autoclose: 4000});
			return false;
		}
	}
} 


function saveBlog(drafts){
	var blogTitle=$('#blogTitle').val();
	var blogContent=$('#blogContent').val();
	var tags=$('#tagsinput').val();
	var imageFile = $('#input-file-events').val();
	var id = $('#blogId').val();
	if(blogTitle =='' ||blogTitle==null ||blogTitle==undefined){
		spop({template: '文章标题不能为空',position  : 'top-center',style: 'error',autoclose: 4000});
		return false;
	}
	if(blogContent =='' ||blogContent==null ||blogContent==undefined){
		spop({template: '文章内容不能为空',position  : 'top-center',style: 'error',autoclose: 4000});
		return false;
	} 
	if(imageFile =='' ||imageFile==null ||imageFile==undefined){
		if(id == '' ||id ==null ||id ==undefined){
			spop({template: '请选择上传一张图片用于文章封面',position  : 'top-center',style: 'error',autoclose: 4000});
			return false;
		}else{
			alert("修改");
		}
	}
	if(tags =='' ||tags==null ||tags==undefined){
		spop({template: '请选择至少一个文章标签',position  : 'top-center',style: 'error',autoclose: 4000});
		return false;
	}
	
	onblurs();
	
	// 获取 CSRF Token 
	var csrfToken = $("meta[name='_csrf']").attr("content");
	var csrfHeader = $("meta[name='_csrf_header']").attr("content");
	
	var form = new FormData(document.getElementById("form1"));
	form.append("drafts",drafts);
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
//				 alert(data.body.blogId);
				 var file = document.getElementById("input-file-events");
		         // for IE, Opera, Safari, Chrome
		         if (file.outerHTML) {
		             file.outerHTML = file.outerHTML;
		         } else { 
		             file.value = "";
		         }
				 $('#blogId').val(data.body.blogId);
				 $('#input-file-events').attr('data-default-file',data.body.MutiImage);
			 } else {
				 spop({template: data.message,position  : 'top-right',style: 'error',autoclose: 4000});
			 }
			 
	     },
	     error : function() {
	    	 spop({template: '请求发生错误',position  : 'top-right',style: 'error',autoclose: 4000});
	     }
	})
}
