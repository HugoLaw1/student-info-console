function addStudent() {
	var check = true;
	
	var student = $("#form-member-add").toJson();

	$.each(student,function(key,obj){
		if(obj === "" && key!="remark"){
			alert(key+"不能为空");
			check = false;
		}
/*		if(obj === "" && (key=="grade" || key=="class")){
			obj="1";
		}*/
	})
	
	console.debug("stringify"+JSON.stringify(student));

	if(check){
	$.ajax({
		url : "StudentController/addStudent.do",
		type : "post",
		dataType : "json",
		data : {
			student : JSON.stringify(student)
		},
		success : function(data) {
			// console.debug(data.data.id);
			// $("#id").val(data.data.id);
			parent.window.table.fnDraw(false);
			if (data.code === "001") {
				layer.alert(data.message, {
					icon : 1,
					shade : 0.5,
					time : 3000
				});
			} else if (data.code === "002") {
				layer.alert(data.message, {
					icon : 2,
					shade : 0.5,
					time : 3000
				});
			} else {
				layer.alert(data.message, {
					icon : 2,
					shade : 0.5,
					time : 3000
				});
			}
		},
		error : function(data) {
			layer.alert(data.message, {
				icon : 2,
				shade : 0.5,
				time : 3000
			});
		}
	});
	}else{
		layer.alert("不能存在空", {
			icon : 2,
			shade : 0.5,
			time : 3000
		});
	}

	
	return false;
}

function onlyNum(obj){
	obj.value = obj.value.replace(/[^\d]/g, ''); //
}