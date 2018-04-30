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
	<title>新規ユーザー登録画面</title>
</head>
<body>
	<h1>新規ユーザー登録</h1>
	<p>すべて入力必須項目です。</p>
	<s:form action="UserCreateConfirmAction">

		<!-- エラーメッセージ -->
		<p><s:if test="errorUserId!=null">
			<s:property value="errorUserId" />
		</s:if></p>

		<p><s:if test="errorPassword!=null">
			<s:property value="errorPassword" />
		</s:if></p>

		<p><s:if test="errorName!=null">
			<s:property value="errorName" />
		</s:if></p>

		<p><s:if test="errorNameKana!=null">
			<s:property value="errorNameKana" />
		</s:if></p>

		<p><s:if test="errorEmail!=null">
			<s:property value="errorEmail" />
		</s:if></p>
		<!-- ここまで -->

		<table>
			<tr>
				<th>ユーザーID</th>
				<td><span><input type="text" name="userId">※12文字以内</span></td>
			</tr>

			<tr>
				<th>パスワード</th>
				<td><span><input type="password" name="password">※12文字以内</span></td>
			</tr>

			<tr>
				<th>お名前（姓）</th>
				<td><span><input type="text" name="familyName" placeholder="姓">※20文字以内</span></td>
			<tr>

			<tr>
				<th>お名前（名）</th>
				<td><span><input type="text" name="firstName" placeholder="名">※20文字以内</span></td>
			</tr>

			<tr>
				<th>ふりがな（せい）</th>
				<td><span><input type="text" name="familyNameKana" placeholder="せい">※20文字以内</span></td>
			</tr>

			<tr>
				<th>ふりがな（めい）</th>
				<td><span><input type="text" name="firstNameKana" placeholder="めい">※20文字以内</span></td>
			</tr>

			<tr>
				<th>性別</th>
				<td><span><label><input type="radio" name="sex" value="1" checked="checked">男性</label>
					<label><input type="radio" name="sex" value="2">女性</label> ※選択してください</span></td>
			</tr>

			<tr>
				<th>メールアドレス</th>
				<td><input type="text" size="35" name="email" placeholder="xxxx@xxx,com"></td>
			</tr>
		</table>
		<s:submit value="確認へ"/>
	</s:form>
	ホームに戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a>
</body>
</html>