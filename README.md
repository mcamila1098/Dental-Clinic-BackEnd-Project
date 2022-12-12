Hola! Este es mi progreso en mi trabajo integrador de la materia Back End I 🚀

## Sistema de reserva de turnos 🖥

Se desea implementar un sistema que permita administrar la reserva de turnos para una clínica odontológica. Este debe cumplir con los siguientes requerimientos: <br>
<ul>
  <li><b>Administración de datos de odontólogos</b>: listar, agregar, modificar y eliminar odontólogos. Registrar apellido, nombre y matrícula de los mismos.</li>
  <li><b>Administración de datos de los pacientes</b>: listar, agregar, modificar y eliminar pacientes. De cada uno se almacenan: nombre, apellido, domicilio, DNI y fecha de alta.</li>
  <li><b>Registrar turno</b>: se tiene que poder permitir asignar a un paciente un turno con un odontólogo a una determinada fecha y hora.</li>
  <li><b>Login</b>: validar el ingreso al sistema mediante un login con usuario y password. Se debe permitir a cualquier usuario logueado (ROLE_USER) registrar un turno, pero solo a quienes tengan un rol de administración (ROLE_ADMIN) poder gestionar odontólogos y pacientes. Un usuario podrá tener un único rol y los mismos se ingresarán directamente en la base de datos.</li>