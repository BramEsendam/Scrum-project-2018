<?php 
include '../Layout/IncludeHeader.php';
 ?>

<!DOCTYPE html>
<html>
<head>
	<title>Kruiswoord puzzel</title>
	
	<link rel="stylesheet" type="text/css" href="../../ScrumProjectEscapeRoom%20-%20kopie/css/Kruiswoordpuzzel.css">
</head>
<body>
	<div id="container">

		<div id="kruiswoordPuzzelBlokken">
			<div id="kruiswoordMain">

		<!-- rij 1 -->
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="s" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="t" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="u" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="r" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="n" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="m" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="o" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="o" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="n" disabled="disabled">

		<!-- rij 2 -->
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="u" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="r" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="o" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="r" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">

		<!-- rij 3 -->
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="n" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" placeholder="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="b" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="s" disabled="disabled">


		<!-- rij 4 -->
		<input onkeydown="KeyCode(event)" class="buttonsBlack" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhiteWord"  type="text" maxlength="1" placeholder="2/3">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" >
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="n" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhiteWord"  type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhiteWord"  type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="i" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">

		<!-- rij 5 -->
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="u" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" >
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="t" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">

		<!-- rij 6 -->
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="p" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhiteWord"  type="text" maxlength="1" value="a" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="r" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="s" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="e" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="c" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="s" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhiteWord"  type="text" maxlength="1" placeholder="4">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="p" disabled="disabled">

		<!-- rij 7 -->
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="-" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="l" disabled="disabled">

		<!-- rij 8 -->
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="k" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="i" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="l" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="o" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="s" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="t" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="r" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">

		<!-- rij 9 -->
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" >
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="o" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" >
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="n" disabled="disabled">

		<!-- rij 10 -->
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhiteWord"  type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="f" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="l" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="y" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="b" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="y" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="e" disabled="disabled">

		<!-- rij 11 -->
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="t" disabled="disabled">

		<!-- rij 12 -->
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="l" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="u" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="n" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="r" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack"  type="text" maxlength="1" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsBlack" disabled="disabled" type="text" maxlength="1">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="m" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="a" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="s" disabled="disabled">
		<input onkeydown="KeyCode(event)" class="buttonsWhite"  type="text" maxlength="1" value="s" disabled="disabled">

		
		</div>
<div id="inputVeldKruiswoord">

		<form method="post">
			<b>The word is: </b><input type="text" name="inputText"> 
			<input type="submit" value="submit" name="submit" onclick="cijferAlert">
		</form>



</div>
		
<div id="kruiswoordTekst">
	<p> <span id="textPurple">Fill in the words starting at the blue numbers</span> <br><br>
		1. What is the red planet called? (Vertical) <br><br>
		2. If this isn't around, you can float through the sky (Vertical) <br><br>
		3. An officer in the highest, second, or third highest rank, as one ranking immediately below a field marshal in the British army. (Horizontal) <br><br>
		4. Used in medicine as a diagnostic aid as parts of the body, such as bones (vertical)<br><br>
		<span id="textPurple">The purple boxes make a word. Put the word in the textbox</span></p>
</div>

<div id="if">
<?php 

		$word = '';

		if(!empty($_POST['inputText'])){
    		$word = $_POST['inputText'];
    		
    		if ($word == 'galaxy' || $word == 'Galaxy') {
    			?>
					<p><?php  echo "You're answer was right! The next number is 56"?></p>
    			<?php
    		} elseif ($word == null ) {
    			?>
					<p><?php  echo "Try again"?></p>
    			<?php
    		} else {
    			?>
					<p><?php  echo "Try again"?></p>
    			<?php
    		}
		}
?>
</div>
</div>
	</div>
<script>

function hint1 ()
{
    alert("1. is Mars")
    clearInterval(hint1);
}
function hint2 ()
{
    alert("2. is gravity")
    clearInterval(hint2);
}
function hint3 ()
{
    alert("3. is general")
    clearInterval(hint3);
}
function hint4 ()
{
    alert("4. is x-ray")
    clearInterval(hint4);
}
var hint1 = setInterval(hint1, 120000);
var hint2 = setInterval(hint2, 240000);
var hint3 = setInterval(hint3, 360000);
var hint4 = setInterval(hint4, 480000);




</script>


</body>
</html>

<?php
    include('../Layout/IncludeFooter.php') ;
?>