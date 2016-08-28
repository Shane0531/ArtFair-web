// 범용 파일 업로드 다이얼로그
function l_showFileUploadDialog(category, path, forceFileName,callback) {
  Dropzone.autoDiscover=false;
  var html = "";
  html += '<div id="fileUploadDialog" class="dialog">용량이 너무 큰파일들을 동시에 올릴 경우 실패 할 수 있습니다(이럴땐 조금씩 올려주세요)<br>파일이름은 반드시 영문자, 숫자,-_등으로만 이루어져야합니다';
  html += '  <form name="fileDropZone" class="dropzone" id="fileDropZone" enctype="multipart/form-data" method="post">';
  html += '<input type="hidden" name="path" value="'+path+'" />';
  if(forceFileName != null){
    html += '<input type="hidden" name="forceFileName" value="'+forceFileName+'" />';
  }
  html += '</form>';
  html += '</div>';
  $(html).appendTo(document.body);
  var fileDropZone = new Dropzone("#fileDropZone", {
    url: "/api/manage/file/"+category,
    //paramName: "files",
    maxFilesize: 20, // MB
    autoProcessQueue: false,
    uploadMultiple: true,
    maxFiles: 10,
    parallelUploads: 10,
    successmultiple: function(){
      alert("업로드 성공");
      $("#fileUploadDialog").dialog("close");
      if(callback!=null)callback();
    },
    errormultiple: function(){
      alert("업로드 중 에러발생");
    }
  });

  $("#fileUploadDialog").dialog({
    modal : true, closeOnEscape: false, width : "auto",  height : "auto", title: "파일 업로드",
    buttons: {
      Save : function() {
        fileDropZone.processQueue();
      },
      Cancel : function() { $(this).dialog("close"); }
    },
    close: function() {
      $("#fileUploadDialog").remove();
    }
  });

}
function l_closeFileUploadDialog() {
  $("#fileUploadDialog").dialog("close");
}

function l_selectFile(evt_obj, target_id, category, path) {
  $("#image_selector").remove();
  l_ajax("get", "html", "/api/manage/file/"+category+"/selector?path="+path,null, function(html) {
    $(evt_obj).after(html);
    $("#file_selector").data("target_id", target_id);
  });
}
