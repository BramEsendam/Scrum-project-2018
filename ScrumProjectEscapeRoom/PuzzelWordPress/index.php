<?php
include '../Layout/IncludeHeader.php';
session_start();
?>

<html>
    <head>
        <title>Hangman</title>
    </head>

    <body>
    <div id="hangman">
        <h2>Hangman</h2>
            <?php
                include 'config.php';
                include 'funtions.php';
                if (isset($_POST['newWord'])) unset($_SESSION['answer']);
                if(!isset($_SESSION['answer']))
                {
                    $_SESSION['attempts']=0;
                    $answer = fetchWordArray($WORDLISTFILE);
                    $_SESSION['answer'] = $answer;
                    $_SESSION['hidden'] = hideCharacters($answer);
                    ?> <p> <?php echo 'Attempts Remaining: '.($MAX_ATTEMPTS-$_SESSION['attempts']).'<br>' ?> <p> <?php ;
                }
                else
                {
                    if(isset($_POST['userInput']))
                    {
                        $userInput = $_POST['userInput'];
                        $_SESSION['hidden'] = checkAndReplace(strtolower($userInput),
                        $_SESSION['hidden'], $_SESSION['answer']);
                        checkGameOver($MAX_ATTEMPTS, $_SESSION['attempts']);
                        checkGameWon($_SESSION['answer'], $_SESSION['hidden']);
                    }
                    $_SESSION['attempts'] = $_SESSION['attempts']+1;
                    ?> <p> <?php echo 'Attempts Remaining: '.($MAX_ATTEMPTS-$_SESSION['attempts']).'<br>' ?> <p> <?php ;
                }
                $hidden = $_SESSION['hidden'];
                ?> <p> <?php foreach($hidden as $char)  echo $char."  " ?> <p> <?php ;
                ?>

            <script type="application/javascript">
                function validateInput()
                {
                    var x = document.forms["inputForm"]["userInput"].value;
                    if(x=="" || x==" ")
                    {
                        alert("Please enter a character");
                        return false;
                    }
                    if(!isNan(x))
                    {
                        alert("Please enter a character");
                        return false;
                    }
                }
            </script>

            <form name="inputForm" action="" method="post">
                <p> You Guess: <input name="userInput" type="text" size="1" maxlength="1">
                <input type="submit" value="Check" onclick="return validateInput();">
                <input type="submit" value="Try Another Word" name="newWord"></p>
            </form>
        </div>
    </body>
</html>


<?php
include '../Layout/IncludeFooter.php';
?>