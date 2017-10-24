$(function() {
	
	$.ajax({
		url:"SexController/getAllSex.do",
		type : "post",
		dataType : "json",
		success : function(data) {
			var str = "";
			
			var sexname=$("#sexname").val();
			console.debug(sexname);
			var addCheck="";
			for(var i = 0;i <data.data.length;i++){
				x=data.data[i];
				
				if(sexname===x.sexname)
					addCheck="checked";
				else addCheck="";
				
				if(i===0){
					str="<div class='radio-box'>"+
						"<input type='radio' id='sex-"+i+"' name='sex' datatype='*'"+
							"nullmsg='请选择性别！' value='"+x.sexname+"' "+addCheck+">"+
						"<label for='sex-"+i+"'>"+x.sexname+"</label>"+
					"</div>";
				}else{
					str="<div class='radio-box'>"+
					"<input type='radio' id='sex-"+i+"' name='sex' "+
						" value='"+x.sexname+"' "+addCheck+">"+
					"<label for='sex-"+i+"'>"+x.sexname+"</label>"+
				"</div>";
				}
				
				$(".skin-minimal").append(str);
			}
			
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});
			
			$("#form-member-add").Validform({
				tiptype : 2,
			});
		}
	});
	
	
});
function addUser() {
	var user = $("#form-member-add").toJson();
	console.debug(JSON.stringify(user));
	$.ajax({
		url : "UserController/addUser.do",
		type : "post",
		dataType : "json",
		data : {
			user : JSON.stringify(user)
		},
		success : function(data) {
			//console.debug(data.data.id);
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