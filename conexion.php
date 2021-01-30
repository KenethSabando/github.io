<?php  
// crear conexion con oracle
$con = oci_connect("admin", "Ken12000", "awspis.cgkpaoueaeni.us-east-1.rds.amazonaws.com/ORCL"); 
 
if (!$con) {    
  $m = oci_error();    
  echo $m['message'], "n";    
  exit; 
} else {    
	//echo "Conexión con éxito a Oracle!"; 
} 
?>
