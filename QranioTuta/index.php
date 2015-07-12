<?php

/**
 * File to handle all API requests
 * Accepts GET and POST
 * 
 * Each request will be identified by TAG
 * Response will be JSON data

  /**
 * check for POST request 
 */
if (isset($_REQUEST['tag']) && $_REQUEST['tag'] != '') {
    // get tag
    $tag = $_REQUEST['tag'];
	
    // include db handler
    require_once 'include/DB_Functions.php';
    $db = new DB_Functions();

    // response Array
    $response = array("tag" => $tag, "success" => 0, "error" => 0);
	$passaValor = array();

    // check for tag type
    if ($tag == 'login') {
        // Request type is check Login
        $email = $_REQUEST['email'];
		
        $password = $_REQUEST['password'];
		

        // check for user
        $user = $db->getUserByEmailAndPassword($email, $password);
        if ($user != false) {
            // user found
            // echo json with success = 1
            $response["success"] = 1;
            $response["uid"] = $user["uid"];
            $response["user"]["name"] = $user["name"];
            $response["user"]["email"] = $user["email"];
            //$response["user"]["created_at"] = $user["created_at"];
            //$response["user"]["updated_at"] = $user["updated_at"];
            echo json_encode($response);
        } else {
            // user not found
            // echo json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "Incorrect email or password!";
            echo json_encode($response);
        }
    } else if ($tag == 'register') {
        // Request type is Register new user
        $name = $_REQUEST['name'];
        $email = $_REQUEST['email'];
        $password = $_REQUEST['password'];

        // check if user is already existed
        if ($db->isUserExisted($email)) {
            // user is already existed - error response
            $response["error"] = 2;
            $response["error_msg"] = "User already existed";
            echo json_encode($response);
        } else {
            // store user
            $user = $db->storeUser($name, $email, $password);
            if ($user) {
                // user stored successfully
                $response["success"] = 1;
                $response["uid"] = $user["uid"];
                $response["user"]["name"] = $user["name"];
                $response["user"]["email"] = $user["email"];
                //$response["user"]["created_at"] = $user["created_at"];
                //$response["user"]["updated_at"] = $user["updated_at"];
                echo json_encode($response);
            } else {
                // user failed to store
                $response["error"] = 1;
                $response["error_msg"] = "Error occured in Registartion";
                echo json_encode($response);
            }
        }
	} else if ($tag == 'display') {
        // Request type is display new user
        $email = $_REQUEST['email'];
        
        // check if user is already existed
            // store user
            $user = $db->displayUser($email);
            if ($user) {
                // user stored successfully
                $response["success"] = 1;
                $response["uid"] = $user["uid"];
                $response["user"]["name"] = $user["name"];
                $response["user"]["email"] = $user["email"];
                //$response["user"]["created_at"] = $user["created_at"];
                //$response["user"]["updated_at"] = $user["updated_at"];
                echo json_encode($response);
            } else {
                // user failed to store
                $response["error"] = 1;
                $response["error_msg"] = "Error occured in Registartion";
                echo json_encode($response);
            }
	} else if ($tag == 'disciplina') {
        // Request type is display new user
        $id = $_REQUEST['id'];
        
        // check if user is already existed
            // store user
            $disc = $db->disciplinaUser($id);
			
            if ($disc) {
                // user stored successfully
                $response["success"] = 1;
				$response["nome"] = "";
				//print_r($disc);
				//echo count($disc);
				for($i=0; $i < count($disc); $i++){ 
					$response["nome"] .= $disc[$i]."#";
				}
				/*$response["nota"] = $disc["nota"];
				$response["nota2"] = $disc["nota2"];
				$response["nota3"] = $disc["nota3"];
				*/
                echo json_encode($response);
            } else {
                // user failed to store
                $response["error"] = 1;
                $response["error_msg"] = "Error occured in display disciplinas";
                echo json_encode($response);
            }
    }else if ($tag == 'notaDisciplina') {
        // Request type is display new user
        $id = $_REQUEST['id'];
        $nomeDisciplina = $_REQUEST['disciplina'];
        // check if user is already existed
            // store user
            $nota = $db->notaUser($id, $nomeDisciplina);
			
            if ($nota) {
                // user stored successfully
                $response["success"] = 1;
				
				$response["nota"] = $nota["nota"];
				$response["nota2"] = $nota["nota2"];
				$response["nota3"] = $nota["nota3"];
				
                echo json_encode($response);
            } else {
                // user failed to store
                $response["error"] = 1;
                $response["error_msg"] = "Error occured in display disciplinas";
                echo json_encode($response);
            }
    } else {
        echo "Invalid Request";
    }
} else {
    echo "Access Denied";
}
?>
