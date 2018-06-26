<?php
include '../Layout/IncludeHeader.php';
?>
<!-- function-->

<script>
    function myFunction(text) {
        document.getElementById("demo").innerHTML += text;
    }
</script>

<div id="ITContainer">
    <div id="top">
        <table>
            <tr>
                <td><img src="../Images/ItOpdracht/Colijnlaan.JPG"><button onclick="myFunction('i'); this.style.display = 'none'" id="btn1"></button><button onclick="myFunction('a');this.style.display = 'none'" id="btn2"></button></td>
                <td><img src="../Images/ItOpdracht/DonkerCuriuslaan.JPG"><button onclick="myFunction('s'); this.style.display = 'none'" id="btn3"></button></td>
                <td><img src="../Images/ItOpdracht/HetStraatje.JPG"><button onclick="myFunction('e'); this.style.display = 'none'" id="btn4"></button></td>
                <td><img src="../Images/ItOpdracht/Mackaylaan.JPG"><button onclick="myFunction('c'); this.style.display = 'none'" id="btn5"></button></td>
                <td><img src="../Images/ItOpdracht/Meesterstraat.JPG"><button onclick="myFunction('t'); this.style.display = 'none'" id="btn6"></button></td>

            </tr>
            <tr>
                <td><img src="../Images/ItOpdracht/Passtraat.JPG"><button onclick="myFunction('t'); this.style.display = 'none'" id="btn7"></button></td>
                <td><img src="../Images/ItOpdracht/Piersonlaan.JPG"><button onclick="myFunction('p'); this.style.display = 'none'" id="btn8"></button><button onclick="myFunction('o'); this.style.display = 'none'" id="btn9"></button></td>
                <td><img src="../Images/ItOpdracht/Slingelaan.JPG"><button onclick="myFunction('l'); this.style.display = 'none'" id="btn10"></button></td>
                <td><img src="../Images/ItOpdracht/VanHall-Laan.JPG"><button onclick="myFunction('l'); this.style.display = 'none'" id="btn11"></button></td>
                <td><img src="../Images/ItOpdracht/WillemdeZwijgerstraat.JPG"><button onclick="myFunction('e'); this.style.display = 'none'" id="btn12"></button></td>
            </tr>
        </table>
    </div>
    <div id="bot">
        <p>You have found a couple of street names were we have hidden some secret buttons that will help you getting acces to the letters<br>
        if you find the secret word in it you can get your escape number.<br></p>
        <p id="demo">This are the letters you found so far: </p>
        <form method="post">
            <p>The word is: ...... ....... </p><input type="text" name="inputText">
            <input type="submit" value="Submit" name="submit">
        </form>

        <?php

        if(!empty($_POST['inputText'])){
            $word = $_POST['inputText'];

            if ($word == 'total eclipse' OR $word == 'Total eclipse' OR $word == 'total Eclipse' OR $word == 'Total Eclipse') {
                ?><p><?php  echo "Well done! The numbers are 71<br> Write the number down you might need it later on "?></p><?php
            } else {
                ?><p><?php  echo "Wrong answer"?></p><?php
            }
        }
        ?>
    </div>
</div>
<?php
include '../Layout/IncludeFooter.php';
?>

