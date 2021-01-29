<?php  
// crear conexion con oracle
$con = oci_connect("admbdpis", "7894", "localhost/xe"); 
 
if (!$con) {    
  $m = oci_error();    
  echo $m['message'], "n";    
  exit; 
} else {    
	//echo "Conexión con éxito a Oracle!"; 
} 
?>