// Ajax
function l_ajax(type, dataType, url, data, callback, error) {
  try {
    $.ajax({
      cache: false, type: type, dataType: dataType,
      url: url, data : data,
      success : function(result) {
        callback(result);
      },
      error: function(xhr, textStatus, errorThrown) {
        if( error != null ) { error(); }
      }
    });
  } catch(e) {
    if( error != null ) { error(); }
  }
}

//이미지 업로드
function uploadImage(category) {
  var data = new FormData(document.getElementById('imageForm'));
  // ajax
  $.ajax({
    url:'/api/manage/file/'+category,
    type:'POST',
    data:data,
    async:false,
    cache:false,
    contentType:false,
    processData:false
  }).done(function(response){
    location.reload();
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
