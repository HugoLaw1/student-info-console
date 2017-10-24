$(function() {
	
	$("#form-member-add").Validform({
		tiptype : 2,
	});

});

function checkOp() {
	var id = $("#id").val();
	var oldp = $("#oldp").val().trim();
	console.debug(id);
	console.debug(oldp);
	$.ajax({
		url : "UserController/checkOp.do",
		type : "post",
		dataType : "json",
		data : {
			id : id,
			oldp : oldp
		},
		success : function(data) {
			console.debug("验证码："+data.code);
			$("#append").html(data.message);
			$("#append").css('color','red');
				
		},
		error : function(data) {
			layer.alert(data.message, {
				icon : 2,
				shade : 0.5,
				time : 3000
			});		}
	});
	return false;
}

function setStatus() {
	var oldp = $("#oldp").val();
	var newp = $("#newp").val();
	var id = $("#id").val();
	//console.debug(user);
	//console.debug(id);
	
	$.ajax({
		url : "UserController/setPassword.do",
		type : "post",
		dataType : "json",
		data : {
			oldp: oldp,
			newp: newp,
			id  : id
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