$(function() {
	$('.skin-minimal input').iCheck({
		checkboxClass : 'icheckbox-blue',
		radioClass : 'iradio-blue',
		increaseArea : '20%'
	});

	$("#form-member-add").Validform({
		tiptype : 2,
	});

});
function setStatus() {
	var status = $(":checked").val();
	var id = $("#id").val();
	console.debug(status);
	console.debug(id);
	
	$.ajax({
		url : "UserController/setStatus.do",
		type : "post",
		dataType : "json",
		data : {
			status : status,
			id     : id
		},
		success:function(data){
			parent.window.table.fnDraw(false);
			if(data.code==="001"){
				layer.alert(data.message, {
					icon : 1,
					shade : 0.5,
					time : 3000
				});
			}else{
				layer.alert(data.message, {
					icon : 2,
					shade : 0.5,
					time : 3000
				});
			}
		},
		error : function() {
			layer.alert(data.message, {
				icon : 2,
				shade : 0.5,
				time : 3000
			});
		}
	});
	return false;
}