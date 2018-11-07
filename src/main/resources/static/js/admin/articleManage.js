layui.use('table', function(){
	var table = layui.table;
	
	table.render({
	    elem: '#bligList'
	    ,url:'/admins/showBlog'
	    ,limits : [10,15,20,25]
	    ,limit : 10
	    ,height: 470
	    ,page:true
	    ,cols: [[
	    	{type: 'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: 'ID', sort: true, fixed: 'left'}
	      ,{field:'title', title: '标题',minWidth: 150}
	      ,{field:'tags', width:150, title: '关键字'}
	      ,{field:'type', width:100, title: '分类'}
	      ,{field:'readSize', title: '浏览量', width:95, sort: true}
	      ,{field:'drafts', width:95, title: '是否草稿'}
	      ,{field:'createTime', width:180, title: '创建时间'}
	      ,{fixed: 'right', title:'操作',width: 165, align:'center', toolbar: '#barDemo'}
	    ]]
	    
	  });
	
});