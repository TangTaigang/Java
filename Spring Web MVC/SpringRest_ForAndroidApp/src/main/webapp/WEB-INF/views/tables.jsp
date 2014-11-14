<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>List </title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="resources/css/plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
  	<div id="wrapper">
		<jsp:include page="navbar.jsp" />
		<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">List food -  <c:out value="${data.name}"/> restaurant</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            List food in database
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table id="dataTables-example" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%"></table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
<input type="hidden" value="<c:out value="${data.name}"/>" id="res_name">
    <!-- jQuery Version 1.11.0 -->
    <script src="resources/js/jquery-1.11.0.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/js/plugins/metisMenu/metisMenu.min.js"></script>
    <!-- DataTables JavaScript -->
    <script src="resources/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="resources/js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="resources/js/sb-admin-2.js"></script>
    <script>
    var res_name=$("#res_name").val();
    $(document).ready(function() {
    	$.getJSON("http://localhost:8080/app/rest/store/Restaurant",function(result){
            var data = [];
           	$.each(result, function() {
           		var element = [];
           		console.log(this);
           		for (var property in this) {
           		    if (this.hasOwnProperty(property)) {
               			if(property=="createDate" || property=="updateDate"){
               				var dateTime=new Date(this[property]);
               				this[property]=dateTime.toString();
               			}
           		        element.push(this[property]);
           		    }
           		}
           		data.push(element);
           	});
        var table=$('#dataTables-example').dataTable({
            "data": data,
            "columns": [
                { "title": "Id" },
                { "title": "Name","class": "center" },
                { "title": "Restaurant Name" },
                { "title": "Create Date", "class": "center" },
                { "title": "Update Date", "class": "center" },
                { "title": "Price", "class": "center" },
                { "title": "Status", "class": "center" },
            ],
            "columnDefs":[
                {"targets":[0],"visible":false,"searchable":false}
            ]
        });
 	    var add=$('#dataTables-example').DataTable();
 	    $('#dataTables-example tbody').on('click','tr',function(){
 	    	alert(add.row(this).data());
 	    });
//        for (var i = 0; i < 8; i++) {
//			add.row.add([
//			          'a',
//			          'b',
//			          'c',
//			          'd',
//			          'e',
//			          'g',
//			          'h'
//			]).draw();
//		}
      
        $('#dataTables-example tbody').on('click', 'tr', function () {
            var id = this.id;
            var index = $.inArray(id, selected);
            if ( index === -1 ) {
                selected.push( id );
            } else {
                selected.splice( index, 1 );
            }
            $(this).toggleClass('selected');
        } );
    	});
    });

    </script>

</body>

</html>
