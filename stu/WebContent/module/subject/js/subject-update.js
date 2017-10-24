function updateSubject() {
	var check = true;

	var subject = $("#form-member-add").toJson();

	$.each(subject, function(key, obj) {
		if (obj == "" && key != "sub_remark") {
			check = false;
		}
		console.debug("key:"+key);
		if (key == "sub_hours" && (parseFloat(obj).toFixed(2) < 0
				|| parseFloat(obj).toFixed(2) > 100)) {
			console.debug("hours" + parseFloat(obj).toFixed(2))
			alert("学时数值区间(0,100)");
			check = false;
		}
		if (key == "sub_weight" &&( parseFloat(obj).toFixed(2) < 0
				|| parseFloat(obj).toFixed(2) > 10)) {
			console.debug("weight" + parseFloat(obj).toFixed(2))
			alert("学分数值区间(0,10)");
			check = false;
		}
	})

	console.debug("stringify" + JSON.stringify(subject));

	if (check) {
		$.ajax({
			url : "SubjectController/updateSubject.do",
			type : "post",
			dataType : "json",
			data : {
				subject : JSON.stringify(subject)
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
				}else {
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
	} else {
		alert("不能存在空");
	}

	return false;
}
/*
 * $(document).ready(function() { $("#id").blur(function(){ if($(this).val() ===
 * null){ $(this).parent.html("不能为空"); } }); });
 */

function num(obj) {
	obj.value = obj.value.replace(/[^\d.]/g, ""); // 清除"数字"和"."以外的字符
	obj.value = obj.value.replace(/^\./g, ""); // 验证第一个字符是数字
	obj.value = obj.value.replace(/\.{2,}/g, "."); // 只保留第一个, 清除多余的
	obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$",
			".");
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'); // 只能输入两个小数
}