<?php

include '../Layout/IncludeHeader.php';

?>
<div id="puzzel2Vertaal">
    <div id="right">
        <h2>puzzle2: Translate</h2>
        <p>Use the Alphabet to translate the text</p>
        <p>ՇՔҶӃԐՇӪԹՔ</p>
        <form method="post">
            The word is: <input type="text" name="inputText">
            <input type="submit" value="sumbit" name="submit">
        </form>
        <?php

        if(!empty($_POST['inputText'])){
            $word = $_POST['inputText'];

            if ($word == 'spaceship' || $word == 'Galaxy') {
                ?>
                <p><?php  echo "Goedzo"?></p>
                <?php
            } else {
                ?>
                <p><?php  echo "probeer het opnieuw"?></p>
                <?php
            }
        }
        ?>
    </div>
    <div id="left">
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
</div>

<?php
    include '../Layout/IncludeFooter.php';
?>
