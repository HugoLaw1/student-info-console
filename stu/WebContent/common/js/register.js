function registerFunc() {
/*	var user = $("#registerform").toJson();
	if (user.username == "" || user.password == "") {
		layer.alert("账号或者密码不可以为空！", {
			icon : 5
		});
		return false;
	} else {
		return true;
	}
*/
	console.debug("aaa");
	var sellerid = $("#sellerid").val();
	var username = $("#username").val().trim();
	var password = $("#password").val().trim();
	$.ajax({
		url : "RegisterController/register.do",
		type : "post",
		dataType : "json",
		data : {
			sellerid : sellerid,
			username : username,
			password : password
		},
		success : function(data) {
			console.debug(data);
		},
		error : function(data) {
			layer.alert("网络不给力", {
				icon : 2,
				shade : 0.5,
				time : 3000
			});
		}
	});
	return false;
}