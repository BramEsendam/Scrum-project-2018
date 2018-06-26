<?php

    function fetchWordArray($wordFile){
        $file = fopen($wordFile,'r');
        if($file){
            $random_line = null;
            $line = null;
            $count = 0;
            while(($line = fgets($file)) !=false){
                $count++;
                if(rand()%$count==0){
                    $random_line = trim($line);
                }
            }
            if(!feof($file)){
                fclose($file);
                return null;
            }
            else{
                fclose($file);
            }
        }
        $answer = str_split($random_line);
        return $answer;
    }

    function hideCharacters($answer){
        $noOfHiddenChars = floor(sizeof($answer) /2) +1);
        $count = 0;
        $hidden = $answer;
        while($count < noOfHiddenChars){
            $rand_element = rand(0, sizeof($answer) -2);
        }
    }