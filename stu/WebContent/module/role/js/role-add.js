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
function addRole() {
	var role = $("#form-member-add").toJson();
	//console.debug(JSON.stringify(role));
	$.ajax({
		url : "RoleController/addRole.do",
		type : "post",
		dataType : "json",
		data : {
			role : JSON.stringify(role)
		},
		success : function(data) {
			//console.debug(data.message);
			//$("#id").val(data.data.id);
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