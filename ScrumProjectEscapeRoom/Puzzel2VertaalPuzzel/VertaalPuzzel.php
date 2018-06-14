<?php

include '../Layout/IncludeHeader.php';


?>
<div id="puzzel2Vertaal">
    <div id="left">
        <p>Hello stranger.<Br>
            You have found the translation of the space alphabet to your alphabet.<br>
            Now you need to translate the word and send it to the pc.<br>
            The pc will tell you if you are right.<br>
            Good luck with translating.</p>
        <p>ՐՊҶխՇԠҶՐԹխԘ ՐӪԹՇ ՐԐճՐ ՇԒӃՋՇ</p>
        <form method="post">
            <p>The word is: </p><input type="text" name="inputText">
            <input type="submit" value="Submit" name="submit">
        </form>
        <?php

        if(!empty($_POST['inputText'])){
            $word = $_POST['inputText'];

            if ($word == 'translating this text sucks') { ?>
                <p><?php  echo "Well done!<br> This is your number that you will need to escape: 2"?></p>
                <form action="../Puzzel3KruiswoordPuzzel/Kruiswoordpuzzel.php" method="get"> <input type="submit" value="NextPuzzle" name="next"></form> <?php

            } else { ?>
                <p><?php  echo "Wrong answer"?></p> <?php
            }
        }

        ?>
    </div>
    <div id="right">
        <table>
            <tr>
                <td>a = Ҷ</td>
                <td>b = Ӂ</td>
                <td>c = Ӄ</td>
            </tr>
            <tr>
                <td>d = Ԉ</td>
                <td>e = Ԑ</td>
                <td>f = Ԕ</td>
            </tr>
            <tr>
                <td>g = Ԙ</td>
                <td>h = Ӫ</td>
                <td>i = Թ</td>
            </tr>
            <tr>
                <td>j = Ԫ</td>
                <td>k = Ջ</td>
                <td>l = Ԡ</td>
            </tr>
            <tr>
                <td>m = Ԭ</td>
                <td>n = խ</td>
                <td>o = Յ</td>
            </tr>
            <tr>
                <td>p = Ք</td>
                <td>q = Ց</td>
                <td>r = Պ</td>
            </tr>
            <tr>
                <td>s = Շ</td>
                <td>t = Ր</td>
                <td>u = Ԓ</td>
            </tr>
            <tr>
                <td>v = Ֆ</td>
                <td>w = բ</td>
                <td>x = ճ</td>
            </tr>
            <tr>
                <td>y = Ԣ</td>
                <td>z = Ӹ</td>
                <td></td>
            </tr>
        </table>
    </div>
    <body>
  
</body>
</div>
<script>

function hint1 ()
{
    alert("The last word is sucks")
    clearInterval(hint1);
}
function hint2 ()
{
    alert("The third word is text")
    clearInterval(hint2);
}
function hint3 ()
{
    alert("The second word is this")
    clearInterval(hint3);
}
var hint1 = setInterval(hint1, 120000);
var hint2 = setInterval(hint2, 240000);
var hint3 = setInterval(hint3, 360000);




</script>
<?php
include '../Layout/IncludeFooter.php';
?>
