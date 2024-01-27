<?php

$inc=include("db.php");

if($inc){
    $consulta="SELECT * FROM producto";
    $resultado=mysqli_query($conexion,$consulta);

    if($resultado==true){
        while($row=$resultado->fetch_array()){
            $nombre=$row['nombre'];
            $precioVenta=$row['precioVentaUnitario'];
            $stock=$row['stock'];

            ?>

            <tr>
                <td><?php echo $nombre; ?></td>
                <td><?php echo $precioVenta; ?></td>
                <td><?php echo $stock; ?></td>

            </tr>

            <?php

        }
    }
}

?>