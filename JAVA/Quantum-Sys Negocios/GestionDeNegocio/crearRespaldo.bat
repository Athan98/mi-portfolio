@echo off
setlocal

set "mysql_user=root"
set "mysql_password="
set "database_name=negociobd"
set "output_file_path=C:\Users\Usuario\Documents\GitHub\mi-portfolio\GestionDeNegocio\GestionDeNegocio\negociobd.sql"

C:\xampp\mysql\bin\mysqldump -u %mysql_user% -p%mysql_password% %database_name% > %output_file_path%

echo Backup completado. Presiona cualquier tecla para salir.
pause