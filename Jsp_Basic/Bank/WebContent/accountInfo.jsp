<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            margin: 0 auto;
            width: 280px;
        }

        .container {
            padding: 10px;
            border: 1px solid;
        }

        .header {
            height: 40px;
        }

        .row {
            height: 30px;
        }

        .title {
            width: 70px;
            float: left;
            font-weight: bold;
        }

        .input {
            float: left;
        }

        input[type='submit'] {
            font-weight: bold;
            width: 120px;
            background-color: lightgrey;
        }
    </style>
</head>

<body>
    <center>
        <div class="header">
            <h3>계좌조회</h3>
        </div>
        <div class="container" id='query'>
            <form id='form' action = "accountinfo" method = "post">
                <div class="row">
                    <div class="title">계좌번호</div>
                    <div class="input"><input type="text" name="id"></div>
                </div>
                <div class="button">
                    <input type="submit" value="조 회">
                </div>
            </form>
        </div>
        <div class="container" id='result' hidden>
            <div class="row">
                <div class="title">계좌번호</div>
                <div class="input"><input type="text" name="id" id='id' disabled></div>
            </div>
            <div class="row">
                <div class="title">이름</div>
                <div class="input"><input type="text" name="name" id='name' disabled></div>
            </div>
            <div class="row">
                <div class="title">입금액</div>
                <div class="input"><input type="text" name="money" id='money' disabled></div>
            </div>
           <!-- <div class="row">
                <div class="title">종류</div>
                <div class="input"><input type="text" name="type" id='type' disabled></div>
            </div>
            <div class="row">
                <div class="title">등급</div>
                <div class="input"><input type="text" name="grade" id='grade' disabled></div>
            </div>-->
        </div>
    </center>
</body>

</html>