$(function() {

	
	$.ajax({
		url:"RoleController/getAllRole.do",
		type : "post",
		dataType : "json",
		success : function(data) {
			var str = "<option value='primary'>primary</option>";
			$("#select").append(str);
			
			for(var i = 0;i <data.data.length;i++){
				x=data.data[i];
				if(x.rolename==="primary")return;
				str="<option value='"+x.rolename+"'>"+x.rolename+"</option>";
				$("#select").append(str);
			}
		}
	});

});
function setRole() {
	var role = $(":selected").val();
	var id = $("#id").val();
	//console.debug(user);
	//console.debug(id);
	
	$.ajax({
		url : "UserController/setRole.do",
		type : "post",
		dataType : "json",
		data : {
			role : role,
			id   : id
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
	return true;
}