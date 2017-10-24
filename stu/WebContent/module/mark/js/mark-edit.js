function updateMark() {
	var check = true;
	var blank = false;
	
	var mark = $("#form-member-add").toJson();

	$.each(mark, function(key, obj) {
		if (obj == "") {
			blank = true;
		}
		console.debug("key:"+key);
		
//		if(key=="subject1_mark"){
//			alert(obj)
//		}
		if ((key == "subject1_mark" | key == "subject2_mark" | key == "subject3_mark" | key == "subject4_mark" | key == "subject5_mark" | key == "subject6_mark")
				&& (parseFloat(obj).toFixed(2) < 0 || parseFloat(obj).toFixed(2) > 100)) {
			console.debug("mark:" + parseFloat(obj).toFixed(2))
			alert("成绩区间(0,100)");
			check = false;
		}
	})

	console.debug("stringify" + JSON.stringify(mark));

	
	
	if (check & !blank ) {
		$.ajax({
			url : "MarkController/updateMark.do",
			type : "post",
			dataType : "json",
			data : {
				mark : JSON.stringify(mark)
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
				} else {
					layer.alert("更新失败", {
						icon : 2,
						shade : 0.5,
						time : 3000
					});
				}
			},
			error : function(data) {
				layer.alert("更新失败", {
					icon : 2,
					shade : 0.5,
					time : 3000
				});
			}
		});
	} else if(blank){
		alert("不能留空");
	}
	
	return false;
}
/*
 * $(document).ready(function() { $("#id").blur(function(){ if($(this).val() ===
 * null){ $(this).parent.html("不能为空"); } }); });
 */


function num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,""); //清除"数字"和"."以外的字符
	obj.value = obj.value.replace(/^\./g,""); //验证第一个字符是数字
	obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个, 清除多余的
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d).*$/,'$1$2.$3'); //只能输入两个小数
	//------------------------------------------\d表示一个小数
	//------------------------------------------/[\d]/g代表数字
}