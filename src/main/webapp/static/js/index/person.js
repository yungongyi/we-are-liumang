/**
 * get all person
 */
//初始化获取person用户表数据
function initPerson() {
	
	$.ajax({
		url : "/commonweal/personCenter/getPerson",
		type : "GET",
		dataType : "JSON",
		success : function(data) {
			$("#usertable tr:not(:first)").empty("");
			$.each(JSON.parse(data),function(idx,obj) {
						var sex=null;
						if(obj.sex==0){
							sex="男"
						}
						if(obj.sex==1){
							sex="女"
						}
						alert(obj.region.regionName);
						$("#usertable")								
						.append(																		
								"<tr><th><span>"
								+ obj.personid
								+ "</span></th><th><span>"
								+ obj.iphone
								+ "</span></th><th><span>"
								+ obj.name
								+ "</span></th><th><span>"
								+ getMyDate(obj.personCreateDate)
								+ "</span></th><th><span>"
								+ sex
								+ "</span></th><th><span>"
								+ obj.region.regionName
								+ "</span></th><th><span>"
								+ obj.state.stateName
								+ "</span></th><th><span>"
								+ obj.type.typeName
								+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>" 
								+"<a class='manage getUser'  value='"+obj.personid+"'>查看</a></span></th></tr>");
					});
		}
	});
}
//初始化
$(document).ready(function() {

	// 将ajax获取的时间戳(获取过来它自动转换为时间戳)转换成时间(年:月:日 时:分:秒)
	function getMyDate(str) {
		var oDate = new Date(str), oYear = oDate.getFullYear(), oMonth = oDate
		.getMonth() + 1, oDay = oDate.getDate(), oHour = oDate
		.getHours(), oMin = oDate.getMinutes(), oSen = oDate
		.getSeconds(), oTime = oYear + '-'
		+ getzf(oMonth) + '-' + getzf(oDay) + ' '
		+ getzf(oHour) + ':' + getzf(oMin) + ':'
		+ getzf(oSen);
		return oTime;
	}
	;
	// 补0操作
	function getzf(num) {
		if (parseInt(num) < 10) {
			num = '0' + num;
		}
		return num;
	}
	/**
	 * get person by iphone
	 *//*
	// 根据用户手机号查询用户信息
	$("button[name='serachuser']")
	.click(
			function() {
				$("#usertable tr:not(:first)").empty(
				"");					
				var iphone = $("input[name='iphone']")
				.val();
				$
				.ajax({			
					url : "/commonweal/personCenter/getPersonByiphone",
					type : "GET",
					data : "iphone=" + iphone,
					dataType : "JSON",
					success : function(result) {
						$.each(JSON.parse(result),function(idx,obj) {
									var sex=null;
									if(obj.sex==0){
										sex="男"
									}
									if(obj.sex==1){
										sex="女"
									}
									$(
									"#usertable")
									.append(
											"<tr><th><span>"
											+ obj.personid
											+ "</span></th><th><span>"
											+ obj.iphone
											+ "</span></th><th><span>"
											+ obj.name
											+ "</span></th><th><span>"
											+ getMyDate(result[index].personCreateDate)
											+ "</span></th><th><span>"
											+ sex
											+ "</span></th><th><span>"
											+ obj.region.regionName
											+ "</span></th><th><span>"
											+ obj.state.stateName
											+ "</span></th><th><span>"
											+ obj.type.typeName
											+ "</span></th><th><span class='col-xs-6' style='width: 50%;'>" 
											+"<a class='manage getUser'  value='"+obj.personid+"'>查看</a></span></th></tr>");
								});
					}
				});
			});*/

	//点击查看按钮查看一条用户信息
	$(".getUser").live("click",function() {
		$(".userul").show();
		$("#usertable").hide();
		var id = $(this).attr("value");		
		var stateId;
		$.ajax({
			url : "/commonweal/personCenter/getPersonBypersonid/?id=" + id,
			type : "GET",
			async : false,
			dataType : "json",
			success : function(result) {

				$(".userul").empty("");
				$
				.each(
						result,
						function(
								index) {
							var sex=null;
							if(result[index].sex==0){
								sex="男"
							}
							if(result[index].sex==1){
								sex="女"
							}
							stateId=result[index].state.stateId;
							$(".userul").append(
									"<li><span>用户ID：</span> <span>"
									+result[index].personid
									+"</span></li>"
									+"<li><span>手机号：</span> <span>" 
									+result[index].iphone
									+"</span></li>"
									+"<li><span>昵称：</span> <span>" 
									+result[index].name
									+"</span></li>"
									+"<li><span>密码：</span> <span>" 
									+result[index].password
									+"</span></li>"
									+"<li><span>创建时间：</span> <span>" 
									+getMyDate(result[index].personCreateDate)
									+"</span></li>"
									+"<li><span>性别：</span> <span>" 
									+sex
									+"</span></li>"										
									+"<li><span>地址：</span> <span>" 
									+result[index].areaId
									+"</span></li>"
									+"<li><span>照片：</span> <img"
									+"src='<%=basePath%>/static/image/avatar1_small.jpg'></li>"
									+"<li><span>用户类型：</span> <span>" 
									+result[index].type.typeName
									+"</span></li>"
									+"	<li><span>状态：</span> <select id='state_Id'>"
									+	"	<option value='16'>正常</option>"
									+	"	<option value='17'>封号2小时</option>"
									+	"	<option value='18'>封号1天</option>"
									+	"	<option value='19'>封号3天</option>"
									+	"	<option value='20'>封号1周</option>"
									+	"	<option value='21'>永久封号</option>"
									+	"	<option value='22'>长期未登录</option>"
									+	"</select></li>"
									+	"<li>"
									+	"<button class='userreturn' value='"+result[index].personid+"'>修改</button>"
									+   "<button class='returnUser'>返回</button>"
									+	"</li>" );

						});				      
				$("#state_Id option[value='"+stateId+"']").attr("selected","selected");
			}

		});

	});

	//点击返回返回至初始化页面
	$(".returnUser").live("click",function(){
		$(".usertable").show();
		$(".userul").hide();
	});

	//修改用户状态
	$(".userreturn").live("click",function() {
		var id = $(this).attr("value");
		var stateId=$("#state_Id").val();
		alert(id);
		alert(stateId);
		$.ajax({
			url : "/commonweal/personCenter/updatePersonBystate",
			data : {"id":id,"stateId":stateId},
			type : "GET",
			dataType : "json",
			success : function() {
				alert("修改成功！");
				//initPerson();
				$(".usertable").show();
				$(".userul").hide();
			}
		});
	});

});