/**
 *
 */
alert("Hello World!");


function checkData(){
  var str = document.getElementById("dat1").value;
  if(str.trim().length > 0){
    alert("入力OKです！");
  }else{
    alert("入力して下さい！");
  }
}
const h1 = document.getElementById("text");
let count = 0;

const timer = setInterval(() => {
    h1.style.fontSize = count + `px`;
    count++;

    if (count >= 100) clearInterval(timer);
}, 10);


function check1(){

	var flag1 = 0;


	// 設定開始（チェックする項目を設定してください）

	if(document.form1.answer1.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer2.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer3.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer4.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer5.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer6.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer7.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer8.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer9.value.match(/[^0-9]+/)){

		flag1 = 1;

	}
	else if(document.form1.answer10.value.match(/[^0-9]+/)){

		flag1 = 1;

	}

	// 設定終了


	if(flag1){

		window.alert('数字以外が入力されています'); // 数字以外が入力された場合は警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}
