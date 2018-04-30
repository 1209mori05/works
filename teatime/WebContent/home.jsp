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
	<title>Home画面</title>
</head>
<body>
	<h1>HOME</h1>
	<s:if test="#session.loginFlg">
		<p>ようこそ！<s:property value="#session.userId"/>さん</p>
	</s:if>
	<s:else>
		<p>各機能を利用する場合は、新規登録またはログインをお願いします。</p>
	</s:else>

	<a href='<s:url action="UserCreateAction" />'>新規登録</a><br>
	<a href='<s:url action="GoLoginAction" />'>ログイン</a><br>
	商品購入<br>
	<a href='<s:url action="MyPageAction" />'>マイページ</a><br>
	購入履歴<br>
	<a href='<s:url action="LogoutAction" />'>ログアウト</a><br>
</body>
</html>