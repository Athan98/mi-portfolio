

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, initial-scale=1.0, maximum-scale=1.0,minimum-scale=1.0,user-scalable=no">
    <title>Quantum-Sys: Negocios</title>

 <!--DATA TABLE CSS-->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.5.0/css/responsive.bootstrap5.min.css">
<link rel="stylesheet" href="css/estilo.css">

<link rel="shorcut icon" href="icons/QS_favicon.ico">
</head>

<body>

<script>alert('Si está en un teléfono móvil, habilite la rotación de pantalla. Si ya se encuentra habilitada coloque el teléfono en posicion horizontal para una mejor visualización')</script>

<header>
    <h1>LISTA DE PRECIOS</h1>

    <h2>QuantumScript</h2>

</header>

        <div class="container">
            <table id="example" class="table table-striped nowrap" style="width:100%">
            <thead>
                <tr>

                    <th>NOMBRE</th>
                    <th>PRECIO VENTA UNITARIO</th>
                    <th>STOCK</th>
                </tr>
                </thead>
                <tbody>
                <?php
                include("mostrar.php");
                ?>
                </tbody>
            </table>
            </div>

    <footer>
        <p>QuantumScript-Roldan Nicolas-2024. Todos los derechos reservados</p>
    </footer>

    <!--DATATABLE JS-->
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.5.0/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.5.0/js/responsive.bootstrap5.min.js"></script>

    <!--CUSTOM JS-->
<script src="script.js"></script>

</body>

</html>