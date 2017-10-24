var dataTableParam = {};

$(function() {
	initDataTable();
	$("#search").click(
			function() {

				if($("#grade :selected").val()=="nul" && $("#grade :selected").val()=="nul" ){
					return false;
				}
				
				var grade = $("#grade :selected").val();
				$.ajax({
					"type" : "post",
					"url" : Global.contentPath
							+ '/MarkController/getSubjectByGrade.do',
					"dataType" : "json",
					"data" : {
						"grade" : grade,
					},
					"success" : function(data) {
						$.each(data.data, function(key, value) {
							$("#" + key).html(value);
						})
					}
				});
				dataTableParam = $("#query").toJson();
				dataTableParam.key = $("#grade :selected").val() + ","
						 + ","
						+ dataTableParam.key;

				table.fnDraw(true);

			});
})
/* 用户-添加 */
function member_add(title, url, w, h) {
	layer_show(title, url, w, h);
}

function member_edit(data) {
	layer_show("修改用户", "MarkController/editMarkJSP.do?id=" + data, "", 510);
}

function setStatus(data) {
	layer_show("激活用户", "UserController/setStatusJSP.do?id=" + data, "300",
			"200");
}

/* 设置角色 */
function setRole(data) {
	layer_show("设置角色", "user-setRole.jsp?id=" + data, "300", "200");
}

function setPassword(data) {
	layer_show("修改密码", "UserController/setPasswordJSP.do?id=" + data, "350",
			"250");
}

/* 用户-查看 */
function member_show(data) {
	layer_show("查看学生", "StudentController/viewStudent.do?id=" + data, 400, 600);
}
/* 用户-停用 */
function member_stop(obj, id) {
	layer
			.confirm(
					'确认要停用吗？',
					function(index) {
						$(obj)
								.parents("tr")
								.find(".td-manage")
								.prepend(
										'<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
						$(obj)
								.parents("tr")
								.find(".td-status")
								.html(
										'<span class="label label-defaunt radius">已停用</span>');
						$(obj).remove();
						layer.msg('已停用!', {
							icon : 5,
							time : 1000
						});
					});
}

/* 用户-启用 */
function member_start(obj, id) {
	layer
			.confirm(
					'确认要启用吗？',
					function(index) {
						$(obj)
								.parents("tr")
								.find(".td-manage")
								.prepend(
										'<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
						$(obj)
								.parents("tr")
								.find(".td-status")
								.html(
										'<span class="label label-success radius">已启用</span>');
						$(obj).remove();
						layer.msg('已启用!', {
							icon : 6,
							time : 1000
						});
					});
}
/* 密码-修改 */
function change_password(title, url, id, w, h) {
	layer_show(title, url, w, h);
}

/* 删除 */
function del(id) {
	layer.confirm('确认要删除吗？', function(index) {
		$.ajax({
			"type" : 'get',
			"url" : Global.contextPath + '/UserController/deleteUser.do',
			"dataType" : "json",
			"data" : {
				"ids" : id
			},
			"success" : function(data) {
				// console.log(data);
				if (data.code == '001') {
					table.fnDraw(false);// 刷新表格数据false为当前页数，true为刷新到第一页
					layer.msg('已删除!', {
						icon : 1,
						time : 1000
					});
				} else {
					layer.msg('操作失败!', {
						icon : 1,
						time : 1000
					});
				}
			}
		});

	});
}
/* 批量删除 */
function datasDelete() {
	var obj = $("input[name^='checkbox_']:checked");
	if (obj.length == 0) {
		layer.msg('请最少选择一条记录！', {
			icon : 1,
			time : 1000
		});
		return;
	}
	var values = [];
	for (var i = 0; i < obj.length; i++) {
		// console.log(obj[i]);
		values.push(obj[i].value);
	}
	var ids = values.join(",");
	$.ajax({
		"type" : 'post',
		"url" : Global.contextPath + '/StudentController/deleteStudent.do',
		"dataType" : "json",
		"data" : {
			"ids" : ids
		},
		"success" : function(data) {
			if (data.code == '001') {
				table.fnDraw(false);// 刷新表格数据false为当前页数，true为刷新到第一页
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			} else {
				layer.msg('操作失败!', {
					icon : 1,
					time : 1000
				});
			}
		}
	});
}

function initDataTable() {
	// var classs = $("#class :selected").val();

	table = $('.table-sort').dataTable(
			{
				"bPaginate" : true,// 分页按钮
				"bFilter" : true,// 搜索栏
				"bLengthChange" : true,// 每行显示记录数
				"iDisplayLength" : 10,// 每页显示行数
				"bProcessing" : true,
				"bSort" : true,// 排序
				"sPaginationType" : "full_numbers", // 分页，一共两种样式
				// 另一种为two_button //
				// 是datatables默认
				"bServerSide" : true,// 服务端传分页table参数

				"aoColumns" : [// 表格数据填充
				{
					"mDataProp" : "grade",
					"sClass" : "text-c",
					"bSortable" : false,
				}, {
					"mDataProp" : "class",
					"sClass" : "text-c",
					"bSortable" : false,
				}, {
					"mDataProp" : "sum_1",
					"sClass" : "text-c",

				}, {
					"mDataProp" : "sum_2",
					"sClass" : "text-c",

				}, {
					"mDataProp" : "sum_3",
					"sClass" : "text-c",

				}, {
					"mDataProp" : "sum_4",
					"sClass" : "text-c",

				}, {
					"mDataProp" : "sum_5",
					"sClass" : "text-c",

				}, {
					"mDataProp" : "sum_6",
					"sClass" : "text-c",

				},{
					"mDataProp" : "sum_sum",
					"sClass" : "text-c",
				},{
					"mDataProp" : "sum_avg",
					"sClass" : "text-c",
				} ],
				"sAjaxSource" : Global.contextPath
						+ '/DataTableController/getData.do',
				"fnServerData" : function(sSource, aoData, fnCallback) {
					$.dataTableService('MarkService$getAllClassMarkByPage',
							aoData, dataTableParam, fnCallback);
				}

			});

}
