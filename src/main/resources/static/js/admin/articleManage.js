layui.use('table', function(){
	var table = layui.table;
	
	table.render({
	    elem: '#bligList'
	    ,url:'/admins/showBlog'
	    ,limits : [10,15,20,25]
	    ,limit : 10
//	    ,height: 515
	    ,toolbar: '#toolbarDemo'
	    ,defaultToolbar: ['filter']
	    ,page:true
	    ,cols: [[
	    	{type: 'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: 'ID', sort: true, fixed: 'left'}
	      ,{field:'title', title: '标题',minWidth: 150}
	      ,{field:'tags', width:150, title: '关键字'}
	      ,{field:'type', width:100, title: '分类'}
	      ,{field:'readSize', title: '浏览量', width:95, sort: true}
	      ,{field:'drafts', width:95, title: '是否草稿',templet: function(d){
	    	  return d.drafts == 0?"否":"是";
	      }}
	      ,{field:'createTime', width:130, title: '创建时间',templet: function(d){
	    	  if(d.createTime == null || d.createTime=="" ||d.createTime ==undefined){
	    		  return "";
	    	  }else{
	    		  var date =  new Date(d.createTime);
		    	  var mon = date.getMonth() + 1;
		    	  var day = date.getDate();
		    	  var mydate = date.getFullYear() + "-" + (mon<10?"0"+mon:mon) + "-" +(day<10?"0"+day:day);
		    	  return mydate;
	    	  }
	    	 
	      }}
	      ,{fixed: 'right', title:'操作',width: 165, align:'center', toolbar: '#barDemo'}
	    ]]
	    
	  });
	
	
	//监听表格复选框选择
	  table.on('checkbox(bligList)', function(obj){
	    console.log(obj)
	  });
	
	  
	//监听工具条
	  table.on('tool(bligList)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'detail'){
	      layer.msg('ID：'+ data.id + ' 的查看操作');
	    } else if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        obj.del();
	        layer.close(index);
	      });
	    } else if(obj.event === 'edit'){
	      layer.alert('编辑行：<br>'+ JSON.stringify(data))
	    }
	  });
	  
	  //头工具栏事件
	  table.on('toolbar(bligList)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    if(obj.event == 'getCheckData'){
	    	 var data = checkStatus.data;
	    	 var datas =JSON.stringify(data);
	    	 var jsondata = JSON.parse(datas);
	    	 if(jsondata.length == 0){
//	    		 var index = $(".layui-laypage-skip").find("input").val();
//	    		 alert(index);
	    		 layer.alert("请勾选至少一条数据！");
	    	 }else{
	    		 layer.confirm('真的删除选中数据吗', function(){
	    			 var ids= new Array();
			    	 for (var i = 0; i < jsondata.length; i++) {
			 			ids[i] = jsondata[i].id;
			 		}
			    	 layer.alert(ids.toString());
	    		 });
	    	 }
	    }
	  });
	  
	  
	  
	  
});