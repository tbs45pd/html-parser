<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Html Parser</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px;">
				<form method="get" action="/html/parsingUrl">
					<h3 style="text-align: center">HTML PARSER</h3>
					<div class="form-group">
						URL : <input type="text" class="form-control" placeholder="URL"
							name="inputUrl" mexlength="20">
					</div>

					<div class="form-group">
						��¹�������(�ڿ���) : <input type="text" class="form-control"
							placeholder="100" name="displayGroupingNum" mexlength="20">
					</div>

					<div class="form-group">
						Type : <select name="htmlTagYn">
							<option value="N" selected>HTML �±�����</option>
							<option value="Y">Text ��ü</option>
						</select>
					</div>
					
					<div class="form-group">
						�� : ${outputText}
					</div>
					<div class="form-group">
						������ : ${remainder}
					</div>
					<input type="submit" class="btn btn-primary form-control" value="���">
				</form>
			</div>
		</div>
	</div>

</body>
</html>