var dataTableParam = {};
$(function() {
	initDataTable();
	$("#search").click(function(){
		dataTableParam = $("#query").toJson();
		table.fnDraw(true);
	});
})
/* 用户-添加 */
function member_add(title, url, w, h) {
	layer_show(title, url, w, h);
}
function member_edit(data) {
	member_add("修改角色", "RoleController/addOrEditRole.do?id=" + data, "700","300");
}
/* 用户-查看 */
function member_show(data) {
	layer_show("新增角色", "RoleController/viewRole.do?id=" + data, 700, 400);
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
			"url" : Global.contextPath + '/RoleController/deleteRole.do',
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
		"type" : 'get',
		"url" : Global.contextPath + '/RoleController/deleteRole.do',
		"dataType" : "json",
		"data" : {
			"ids" : ids
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
}
function initDataTable() {
	table = $('.table-sort')
			.dataTable(
					{
						"bPaginate" : true,// 分页按钮
						"bFilter" : true,// 搜索栏
						"bLengthChange" : true,// 每行显示记录数
						"iDisplayLength" : 10,// 每页显示行数
						"bProcessing" : true,
						"bSort" : false,// 排序
						"sPaginationType" : "full_numbers", // 分页，一共两种样式
						// 另一种为two_button //
						// 是datatables默认
						"bServerSide" : true,// 服务端传分页table参数
						"aoColumns" : [// 表格数据填充
								{
									"mDataProp" : "id",
									"sClass" : "text-c",
									"mRender" : function(data, type, full) {
										var html = '<input type="checkbox" value="'
												+ data
												+ '" title="'
												+ data
												+ '" id="checkbox_'
												+ data
												+ '" name="checkbox_'
												+ data
												+ '" />';
										return html;
									}

								}, {
									"mDataProp" : "rolename",
									"sClass" : "text-c",
								}, {
									"mDataProp" : "context",
									"sClass" : "text-c",
									"mRender":function(data, type, full){
										var s ="";
										console.debug(data);
										if(!data)return s;
										data=data.split(",");
										for(var o in data){
											if(data[o]==="1")s+="<a class='btn btn-primary'>角色列表</a> ";
											if(data[o]==="2")s+="<a class='btn btn-primary'>分配角色</a> ";
											if(data[o]==="3")s+="<a class='btn btn-primary'>激活按钮</a> ";
											if(data[o]==="4")s+="<a class='btn btn-primary'>删除用户按钮</a> ";
											if(data[o]==="5")s+="<a class='btn btn-primary'>添加用户按钮</a> ";
											if(data[o]==="6")s+="<a class='btn btn-primary'>性别字典</a> ";
											if(data[o]==="7")s+="<a class='btn btn-primary'>日志</a> ";
										};
										return s;
									}
								}

						],
						"columnDefs" : [// 后加载填充自定义列内容
						{
							"targets" : [ 3 ],
							"data" : "id",
							"sClass" : "text-c",
							"mRender" : function(data, type, full) {
								var html = '';
								html += '<a style="text-decoration: none" onClick="member_show(\''
										+ data
										+ '\')" href="javascript:;" title="查看">';
								html += '<i class="Hui-iconfont">&#xe626;</i></a>';
								html += '<a style="text-decoration: none" onClick="member_edit(\''
										+ data
										+ '\')" href="javascript:;" title="编辑">';
								html += '<i class="Hui-iconfont">&#xe6df;</i></a>';
	                 			html += '<a style="text-decoration: none" class="ml-5" onClick="del(\''+data+'\')" href="javascript:;" title="删除">';
	                 			html += '<i class="Hui-iconfont">&#xe6e2;</i></a>';
								return html;
							}
						}

						],
						"sAjaxSource" : Global.contextPath
								+ '/DataTableController/getData.do',
						"fnServerData" : function(sSource, aoData, fnCallback) {
							$.dataTableService('RoleService$getAllRoleByPage',
									aoData, dataTableParam, fnCallback);
						}
					});
}