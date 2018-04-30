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
	<title>新規ユーザー登録確認画面</title>
</head>
<body>
	<h1>新規ユーザー登録確認</h1>
	<p>登録する内容は以下でよろしいでしょうか？</p>
	<s:form action="UserCreateCompleteAction">
		<table>
			<tr>
				<th>ユーザーID</th>
				<td><s:property value="userId"/></td>
			</tr>

			<tr>
				<th>パスワード</th>
				<td><s:property value="passCon"/></td>
			</tr>

			<tr>
				<th>お名前（姓）</th>
				<td><s:property value="familyName"/></td>
			</tr>

			<tr>
				<th>お名前（名）</th>
				<td><s:property value="firstName"/></td>
			</tr>

			<tr>
				<th>ふりがな（せい）</th>
				<td><s:property value="familyNameKana"/></td>
			</tr>

			<tr>
				<th>ふりがな（めい）</th>
				<td><s:property value="firstNameKana"/></td>
			</tr>

			<tr>
				<th>性別</th>
				<td><s:if test="sex==1">男性</s:if>
					<s:else>女性</s:else></td>
			</tr>

			<tr>
				<th>メールアドレス</th>
				<td><s:property value="email"/></td>
			</tr>
		</table>


		<input type="hidden" name="userId" value='<s:property value="userId"/>'>
		<input type="hidden" name="password" value='<s:property value="password"/>'>
		<input type="hidden" name="familyName" value='<s:property value="familyName"/>'>
		<input type="hidden" name="firstName" value='<s:property value="firstName"/>'>
		<input type="hidden" name="familyNameKana" value='<s:property value="familyNameKana"/>'>
		<input type="hidden" name="firstNameKana" value='<s:property value="firstNameKana"/>'>
		<input type="hidden" name="sex" value='<s:property value="sex"/>'>
		<input type="hidden" name="email" value='<s:property value="email"/>'>
		<s:submit value="登録" />
	</s:form>
	ホームに戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
</body>
</html>