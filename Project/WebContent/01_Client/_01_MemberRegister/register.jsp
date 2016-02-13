<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InsertMemberForm</title>
<style>
	.st1 {
		width: 450px;
		margin: 3px;
		border-bottom: 1px solid #000000;
		padding-bottom: 2px;
		margin:3px auto;
	}
	#but1 {
		width: 300px;
		text-align: center;
		margin:0 auto;
	}
	.lab1{
		float: left;
		text-align: right;	
		padding-right:5px;
	}
	.fis1{
		width: 500px;
		margin:5px auto;
	}
	.em1{
		color: red;
	}
</style>
</head>
<body>
	<form action="#" method="post" style="margin: 0 auto;">
		<fieldset class="fis1">
			<legend>個人資料</legend>
			<div class="st1">
				<label class="lab1" for="n1">姓名:</label> <input type="text"
					size="10" id="n1" autocomplete="off" autofocus
					placeholder="insert here" required />
			</div>
			<div class="st1">
				<label class="lab1" for="p1">密碼:</label> <input type="password" size="10" id="p1" />
			</div>
			<div class="st1">
				<label class="lab1">性別:</label> 
					<input type="radio" name="gender" value="male">男 
					<input type="radio" name="gender" value="female">女
				<div class="st1">
					<label class="lab1">生日:</label> <input type="date" value="day" />
				</div>
				<div class="st1">
					<label class="lab1">身分證字號:</label> <input type="text" name="" />
				</div>
			</div>
			<div class="st1">
				<label class="lab1">興趣:</label> <input type="checkbox" name="sport"
					id="sp1"/ ><label for="sp1">運動</label> <input
					type="checkbox" name="movie" id="m1" /><label for="m1">電影</label>
				<input type="checkbox" name="game" id="g1" /><label for="g1">遊戲</label>
				<input type="checkbox" name="sing" id-"i1"/><label for="si">唱歌</label>
			</div>
		</fieldset>
		<fieldset class="fis1">
			<legend>
				地址<em class="em1">(必填)</em>
			</legend>
			<div class="st1">
				<label class="lab1">縣市</label> <select name="add1">
					<option value="1">台北市</option>
					<option value="1">新北市</option>
					<option value="1">桃園市</option>
					<option value="1">台中市</option>
					<option value="1">高雄市</option>
				</select>
			</div>
			<div class="st1">
				<label class="lab1">地址:</label> <input type="text" name="add2"
					size="20">
			</div>
		</fieldset>
		<fieldset class="fis1">
			<legend>
				個人資料2<em class="em1">(非必填)</em>
			</legend>
			<div class="st1">
				<label class="lab1">email:</label> <input type="email" />
			</div>
			<div class="st1">
				<label class="lab1">phone:</label> <input type="email" />
			</div>
			<div class="st1">
				<label class="lab1">net:</label> <input type="url" name="url1"
					list="li">
				<datalist id="li">
				<option value="http://www.google.com">
				<option value="http://www.iiiedu.org.tw">
				<option value="http://docs.oracle.com/javase/8/docs/api/">
				</datalist>
			</div>
			<div class="st1">
				<label class="lab1">照片:</label> <input type="file" name="photo"
					multiple="" />
			</div>
			<div class="st1">
				<label class="lab1" for="c1">意見:</label>
				<textarea cols="40" rows="5" id="c1"></textarea>
			</div>
			<div id="but1">
				<input type="submit" name="send" value="送出"> <input
					type="reset" name="清除" value="清除">
			</div>
		</fieldset>
	</form>
</body>
</html>