<?php 
include 'conexion.php';

//8edaa2d7dd241b28

//$v_equipo = $_GET['equipo'];
$v_equipo = $_POST['equipo'];


$stid = oci_parse($con , 'SELECT equipo FROM empleados WHERE equipo = :equipo_bd');

if (!$stid) {
    $e = oci_error($con);
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
}


oci_bind_by_name($stid, ':equipo_bd', $v_equipo);

$r = oci_execute($stid);

if (!$r) {
    $e = oci_error($stid);
    trigger_error(htmlentities($e['message'], ENT_QUOTES), E_USER_ERROR);
}

$arr = $row = oci_fetch_array($stid, OCI_BOTH);

echo json_encode($arr);
//json_encode($arr);
 
oci_free_statement($stid);
oci_close($con);
?>