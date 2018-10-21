$(function() {
	var editor;
	
      editor = editormd("editorDiv", {
          width   : "100%",
          height  : 700,
          toolbarIcons: function () {
                    return ["bold", "del", "italic", "quote", "|", "h1", "h2", "h3", "h4", "h5", "|", "list-ul", "list-ol", "hr", "pagebreak", "|", "link", "reference-link", "image", "file", "video", "|", "preformatted-text", "code-block", "table", "emoji", "|", "watch", "fullscreen", "copyPreviewHtml", "|", "help"]
                },
                toolbarCustomIcons: {
                    file: '<a href="javascript:;" id="fileDialog"  title="添加附件" unselectable="on"><i class="fa fa-paperclip" unselectable="on"></i></a>',
                    video: '<a href="javascript:;" id="videoDialog"  title="添加视频" unselectable="on"><i class="fa fa-file-video-o" unselectable="on"></i></a>',
                    copyPreviewHtml: '<a href="javascript:;" id="copPreviewHtmlToClipboard"  title="拷贝" unselectable="on"><i class="fa fa-clipboard" unselectable="on"></i></a>'
                },
          syncScrolling : "single",
          //你的lib目录的路径
          path: "markdown/lib/",
          //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
          saveHTMLToTextarea : true,//开启保存HTML文件
          tex: true,                   // 开启科学公式TeX语言支持，默认关闭
          flowChart: true,             // 开启流程图支持，默认关闭
          sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
          dialogMaskOpacity: 0,    // 设置透明遮罩层的透明度，全局通用，默认值为0.1
          dialogMaskBgColor: "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff
          //图片上传
          imageUpload : true,
          imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
          imageUploadURL : "./php/upload.php?test=dfdf",
          
          onload: function () {
//	            $("#content").val(editor.getPreviewedHTML());
	            $("#fileDialog").on("click", function () {
	                editor.executePlugin("fileDialog", "../plugins/file-dialog/file-dialog");
	            });
	            $("#videoDialog").on("click", function () {
	                editor.executePlugin("videoDialog", "../plugins/video-dialog/video-dialog");
	            });
//	            $(".CodeMirror-gutters").height($(".CodeMirror-scroll").height() + 20);
	        },
      });
      
      
      $(document).ready(function () {
          //default
         var elem = Array.prototype.slice.call(document.querySelectorAll(".js-switch"));
			 elem.forEach(function(html){
		 		var switchery = new Switchery(html,{
//				 			color: '#64bd63'
		 		});
			 });

      });
      
      /*图片上传模块*/
     var drEvent = $('#input-file-events').dropify();
     drEvent.on('dropify.beforeClear', function(event, element) {
            return confirm("确定删除 \"" + element.file.name + "\" ?");
     });

    drEvent.on('dropify.afterClear', function(event, element) {
        layer.msg('删除成功');
    });
  });