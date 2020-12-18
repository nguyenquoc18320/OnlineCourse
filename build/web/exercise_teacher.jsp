<%-- 
    Document   : exercise_teacher
    Created on : Nov 27, 2020, 4:10:12 AM
    Author     : A556U
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercise</title>
        <link rel="stylesheet" href="exercise_teacher_css.css">
        <!--<!-<script src="https://kit.fontawesome.com/a076d05399.js"></script>-->
    </head>
    <body>
        <div class = 'div_menu'> 
            <div class='div_logo'>
                <img id='image_logo'href='#' src ="logo.png" >
            </div>
            <div id ='div_CourseName'>
                <label id="label_courseName">Hiển thị tên khóa học</label>
            </div>
            <div id='div_account'>
                <label id='label_account'>Name  <i class='fas fa-caret-down'></i></label>               
            </div>
        </div>
        <div id="container">
            <h1 id='label_chapName_partName'>Hiển thị tên chương, bài</h1>
            <div id='div_all_exercises'>
                <div class='div_exercise' id='div_exercise1'>
                    <textarea class ='textarea_question' id='question1' name ='question1' placeholder="Nhập câu hỏi"></textarea>
                    <input type='text' class='input_answer' id='answer1_A' name='answer1_A' placeholder='Đáp án A'>
                    <input type='text' class='input_answer' id='answer1_B' name='answer1_B' placeholder='Đáp án B'>
                    <input type='text' class='input_answer' id='answer1_C' name='answer1_C' placeholder='Đáp án C'>
                    <input type='text' class='input_answer' id='answer1_D' name='answer1_D' placeholder='Đáp án D'>
                    <label class='label_correctAnswer'>Đáp án đúng:</label>
                    <select class = 'radio_correctAnswer' name ='correctAnswer1' >
                        <option value='A'>A</option>
                        <option value='B'> B</option>
                        <option value='C'> C </option>
                        <option value ='D' >D </option>
                    </select>
                </div>           
            </div>
            <input type="button" id ='button_add_exercise' value='Thêm' onclick='AddExercise()'>
        </div>

    </body>
    <script>
        var totalExercises = 30;
        var exerciseList = [];
        exerciseList[1]=1;
        for (var i = 0; i <= totalExercises; i++)
        {
            exerciseList.push(0);
        }

        function AddExercise()
        {
            var emptyPosition = 0;
            for (var i = 1; i <= totalExercises; i++)
            {
                if (exerciseList[i] === 0)
                {
                    emptyPosition = i;
                    break;
                }
            }

            if (emptyPosition === 0)
            {
                alert("Bạn chỉ được tối đa 30 câu hỏi!");
                return;
            }

            //Create textarea to enter a question
            var newExerciseDiv = document.createElement('div');
            newExerciseDiv.setAttribute('class', 'div_exercise');
            newExerciseDiv.setAttribute('id', 'div_exercise' + emptyPosition);

            var allExerciseDiv = document.getElementById('div_all_exercises');
            allExerciseDiv.appendChild(newExerciseDiv);

            var newQuestionTextarea = document.createElement('textarea');
            newQuestionTextarea.setAttribute('class', 'textarea_question');
            newQuestionTextarea.setAttribute('id', 'question' + emptyPosition);
            newQuestionTextarea.setAttribute('name', 'question' + emptyPosition);
            newQuestionTextarea.setAttribute('placeholder', 'Nhập câu hỏi');
            newExerciseDiv.appendChild(newQuestionTextarea);


            var name = ['A', 'B', 'C', 'D'];
            for (var i = 0; i < 4; i++)
            {
                var newAnswer = document.createElement('input');
                newAnswer.setAttribute('class', 'input_answer');
                newAnswer.setAttribute('id', 'answer' + emptyPosition + '_' + name[i]);
                newAnswer.setAttribute('name', 'answer' + emptyPosition + '_' + name[i]);
                newAnswer.setAttribute('placeholder', 'Đáp án ' + name[i]);
                
                newExerciseDiv.appendChild(newAnswer);
            }
            
            var label = document.createElement('label');
            label.setAttribute('class','label_correctAnswer');
            label.innerHTML='Đáp án đúng: ';
            newExerciseDiv.appendChild(label);
            
            //Create a selection for the answer
            var newSelect = document.createElement('select');
            newSelect.setAttribute('class', 'radio_correctAnswer');
            newSelect.setAttribute('name', 'correctAnswer'+ emptyPosition);
            newExerciseDiv.appendChild(newSelect);
                       
            for( var i=0; i<4; i++)
            {
                var newoption = document.createElement("option");
                newoption.setAttribute('value', name[i]);
                newoption.innerHTML= name[i];
                newSelect.appendChild(newoption);
            }
            
            exerciseList[emptyPosition] = 1;
        }
    </script>
</html>
