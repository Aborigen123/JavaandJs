<?php

require_once 'bd.php';

$connect = mysqli_connect(DB_SERVER, DB_USER, DB_PASS, DB_NAME);

if (!$connect) {
	echo "Error: Unable to connect to MySQL." . PHP_EOL;
	echo "<br>Debugging error number: " . mysqli_connect_errno() . PHP_EOL;
	echo "<br>Debugging error message: " . mysqli_connect_error() . PHP_EOL;
	exit;
}

echo "Success: A proper connection to MySQL was made! The my_db database is great." . PHP_EOL;
echo "Host information: " . mysqli_get_host_info($connect) . PHP_EOL;

mysqli_close($connect);

?>