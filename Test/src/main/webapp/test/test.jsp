<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
        }

        * {
            box-sizing: border-box;
        }

        input[type=text],
        select,
        textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=button] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=button]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
    <script src="https://cdn.ckeditor.com/ckeditor5/35.4.0/classic/ckeditor.js"></script>
    <script>
        window.addEventListener("load", function(){
            ClassicEditor.create(document.querySelector( '#content' )).catch( error => {
            console.error( error );
        } );

            let bt=document.querySelector("input[type=button]");

            bt.addEventListener("click", function(){
                console.log("ëë ì´");

                let form=document.querySelector("form");

                form.submit();
            });

        });
    </script>
</head>

<body>

    <h3>Contact Form</h3>

    <div class="container">
        <form method="post" action="/notice/regist">
            <label for="fname">제목</label>
            <input type="text" id="fname" name="title" placeholder="Your name..">

            <label for="lname">작성자</label>
            <input type="text" id="lname" name="writer" placeholder="Your last name..">

            <label for="subject">내용</label>
            <textarea id="content" name="content" placeholder="Write something.." style="height:200px"></textarea>

            <input type="button" value="Submit">
        </form>
    </div>

</body>

</html>