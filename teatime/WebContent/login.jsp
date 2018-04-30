<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>ログイン画面</title>
</head>
<body>
	<h1>LOGIN</h1>
	<s:form action="LoginAction">
		<s:if test="errorMessage">
			<s:property value="errorMessage" />
		</s:if>

		<s:property value="errorMessage" />
		<table>
			<tr>
				<th><label>ユーザーID</label></th>
				<td><s:textfield name="LoginUserId" /></td>
			</tr>

			<tr>
				<th><label>パスワード</label></th>
				<td><s:password name="loginPassword" /></td>
			</tr>
		</table>
		<s:submit value="ログイン" />
	</s:form>
	<p>新規登録は<a href='<s:url action="UserCreateAction" />'>こちら</a></p>
	<p>ホームに戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>

</body>
</html>