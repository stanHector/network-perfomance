<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="assets/bootstrap-4.5.2-dist/css/bootstrap.min.css">
<script src="assets/bootstrap-4.5.2-dist/js/jquery.min.js"></script>
<script src="assets/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>

<script src="assets/dist/viewer.js"></script>
<link rel="stylesheet" href="assets/dist/viewer.css">

</head>

<script>
	var scpt_tb_col_nm = [ "sid", "sname", "scity", "sphoto" ];
	var scpt_tb_disp_col_nm = [ "Student Id", "Student Name", "City", "Photo" ];
	var totalStudent = "${totalStudent}";

	function fetchData(display_Start) {
		var data;
		$.ajax({
					type : "POST",
					url : "student/" + (display_Start - 1) + "/10",
					success : function(htmldata) {
						data = htmldata;

						var Table = document.getElementById("data_table");
						Table.innerHTML = "";
						tr = $('<tr>');
						for (var i = 0; i < scpt_tb_col_nm.length; i++) {
							$('#data_table').append(
									"<th>" + scpt_tb_disp_col_nm[i] + "</th>");
						}
						$('#data_table').append("<th>Delete</th>");

						tr.append("</tr>");
						$('#data_table').append(tr);
	for (var i = 0; i < data.length; i++) {
		tr = $('<tr>');

		tr.append("<td><button type=' button' class='btn btn-info' onclick='viewData("
						+ data[i].sid
						+ ",\""
						+ data[i].sname
						+ "\",\""
						+ data[i].scity
						+ "\")'>"
						+ data[i].sid + "</button></td>");
		tr.append("<td>" + data[i].sname + "</td>");
		tr.append("<td>" + data[i].scity + "</td>");

		tr.append("<td><img onclick=getTooltip('/imagedata/" + data[i].sphoto + 
				"') src='/imagedata/" + data[i].sphoto + "' style='width:50px;'></td>");
		
		tr.append("<td><button type='button' class='btn btn-danger' onclick='deleteStudent("
						+ data[i].sid
						+ ")' >Delete</button></td>");

		tr.append("</tr>");
		$('#data_table').append(tr);

	}
					},
					error : function(errorThrown) {
						alert("something went wrong");
					}
				});
	}

	function viewData(sid, sname, scity) {
		$('#sid').val(sid);
		$('#sname').val(sname);
		$('#scity').val(scity);
	}

	function deleteStudent(sid) {
		if(confirm('Do you want to delete?')){
			$.ajax({
				type : "POST",
				url : "	?sid=" + sid,
				success : function(htmldata) {
					alert("Delete Successfully !")
					fetchData(1);
				},
				error : function(errorThrown) {
					alert("something went wrong");
				}
			});
		}
	}

	function getTooltip(path1) {
		var image = new Image();
		image.src = path1;
		var viewer = new Viewer(image, {
			hidden : function() {
				viewer.destroy();
			},
			toolbar : {
				zoomIn : true,
				zoomOut : true,
				oneToOne : false,
				reset : true,
				prev : false,
				play : false,
				next : false,
				rotateLeft : true,
				rotateRight : true,
				flipHorizontal : false,
				flipVertical : false,
			},
		});
		viewer.show();
	}

	function addStudent(){
		if (confirm('Do you want to Save?')) {
			var obj = $("#frmStudent");
			var formData = new FormData();
			
			$.each($(obj).find("input[type='file']"), function(i, tag) {
				$.each($(tag)[0].files, function(i, file) {
					formData.append(tag.name, file);
					//alert(tag.name);
				});
			});
			var params = $(obj).serializeArray();
			$.each(params, function(i, val) {
				formData.append(val.name, val.value);
			});
			$.ajax({
				type : "POST",
				url : "addStudent",
				contentType : false,
				processData : false,
				cache : false,
				data : formData,
				success : function(htmldata) {
					alert(htmldata);
					fetchData(1);
					viewData('', '', '');
				},
				error : function(e) {
					alert('Error: ' + e.message);
				},
			});
		}
		
	}
</script>

<style>
.pagination>li>a, .pagination>li>span {
	position: relative;
	float: left;
	padding: 6px 12px;
	line-height: 1.42857143;
	text-decoration: none;
	color: #337ab7;
	border: 1px solid #ddd;
	margin-left: -1px;
}
</style>

<body>

	<div class="text-center">
		<h1>Student Registration Form</h1>
		<p>XYZ College</p>
	</div>

	<div class="container">
		<form id="frmStudent" name="frmStudent">
			<div class="form-group">
				<label>Student ID</label> <input type="text" class="form-control"
					id="sid" name="sid" placeholder="Student Id">
			</div>
			<div class="form-group">
				<label>Student Name</label> <input type="text" class="form-control"
					id="sname" name="sname" placeholder="Student Name">
			</div>
			<div class="form-group">
				<label>Student City</label> <input type="text" class="form-control"
					id="scity" name="scity" placeholder="Student City">
			</div>
			<div class="form-group">
				<label>Student Photo</label> <input type="file" class="form-control"
					id="img" name="img" >
			</div>
			<button type="button" class="btn btn-primary" onclick="addStudent()">Save</button>
			<button type="button" class="btn btn-primary"
				onclick="viewData('','','')">Cancel</button>
		</form>


		<div class="row"
			style="overflow: auto; margin-right: 10px; margin-left: 10px">
			<table id="data_table" class="table">

			</table>
		</div>

		<div class="row" style="margin-right: 10px; margin-left: 10px">
			<p class="demo demo4_bottom"></p>
		</div>

	</div>

</body>

<script type="text/javascript"
	src="assets/paging/js/jquery.bootpag.min.js"></script>

<script>
	$(document).ready(function() {
		set_paging(Math.ceil(totalStudent / 10));
		fetchData(1);
	});

	$('.demo4_bottom').bootpag({
		total : Math.ceil(totalStudent / 10),
		maxVisible : 5,
		page : 1
	});

	function set_paging(total_pages) {
		$('.demo4_bottom').html('');
		$('.demo4_bottom').bootpag({
			total : total_pages,
			page : 1,
			maxVisible : 5,
			leaps : true,
			firstLastUse : true,
			first : '<span aria-hidden="true">&larr;</span>',
			last : '<span aria-hidden="true">&rarr;</span>',
			wrapClass : 'pagination',
			activeClass : 'active',
			disabledClass : 'disabled',
			nextClass : 'next',
			prevClass : 'prev',
			lastClass : 'last',
			firstClass : 'first'
		}).on("page", function(event, num) {
			display_Start = num;
			fetchData(display_Start);
		}).find('.pagination');
	}
</script>
</html>
