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
	<title>マイページ画面</title>
</head>
<body>

	<h1>マイページ</h1>
	<h2>ユーザー情報</h2>

	<table><s:iterator value="myPageList">
		<tr>
			<th>ユーザーID</th>
			<td><s:property value="userId" escape="false" /></td>
		</tr>

		<tr>
			<th>パスワード</th>
			<td><s:property value="passCon" escape="false" /></td>
		</tr>

		<tr>
			<th>お名前</th>
			<td><s:property value="familyName" escape="false" /><s:property value="firstName" escape="false" /></td>
		</tr>

		<tr>
			<th>ふりがな</th>
			<td><s:property value="familyNameKana" escape="false" /><s:property value="firstNameKana" escape="false" /></td>
		</tr>

		<tr>
			<th>性別</th>
			<td><s:if test="sex==1">男性</s:if>
				<s:else>女性</s:else></td>
		</tr>

		<tr>
			<th>メールアドレス</th>
			<td><s:property value="email" escape="false" /></td>
		</tr>
	</s:iterator></table>
	ホームに戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>

</body>
</html>