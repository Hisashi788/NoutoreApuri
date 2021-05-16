<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="">

<head>
  <meta charset="utf-8">
  <title></title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta property="og:title" content="">
  <meta property="og:type" content="">
  <meta property="og:url" content="">
  <meta property="og:image" content="">

  <link rel="manifest" href="site.webmanifest">
  <link rel="apple-touch-icon" href="icon.png">
  <!-- Place favicon.ico in the root directory -->

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

  <meta name="theme-color" content="#fafafa">
</head>

<body>
 <div class="position-relative">
	  <div class="position-absolute top-50 start-50">
		<div class="d-flex justify-content-center">
			 <form action="/NoutoreApuri/LoginServlet" name="form3" onSubmit="return check()" method="post">
				  <div class="mb-3">
				    <label for="exampleInputName1" class="form-label">NAME</label>
				    <input type="text" class="form-control" name="Name" id="name" aria-describedby="namelHelp">
				    <div id="nameHelp" class="form-text">We'll never share your name with anyone else.</div>
				  </div>
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Password</label>
				    <input type="password" class="form-control" name="Pass" id="exampleInputPassword1">
				  </div>
				  <button type="submit" class="btn btn-primary">ログイン</button>
			 </form>
	　　</div>
 	</div>
</div>
		 <script>

				    function check(){

				    	var flag = 0;


				    	// 設定開始（必須にする項目を設定してください）

				    	if(document.form3.Name.value == ""){ // 「お名前」の入力をチェック

				    		flag = 1;

				    	}

				    	else if(document.form3.Pass.value == ""){ // 「パスワード」の入力をチェック

				    		flag = 1;

				    	}

				    	// 設定終了


				    	if(flag){

				    		window.alert('必須項目に未入力がありました');  // 入力漏れがあれば警告ダイアログを表示
				    		return false; // 送信を中止

				    	}
				    	else{

				    		return true; // 送信を実行

				    	}

				    }
			</script>

</body>
</html>
