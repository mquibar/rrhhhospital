/* 
 * Funciones para la incorporacion de ajax en las pantallas del empleados
 *
 */

var req = createRequestObject();

/*Carga los empleados para ser modificados*/
function loadPersonas(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("empleados").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletModificarPersonal?operacion=load" , true);
    req.send(null);

    return (true);
}

/*Carga los paises*/
function loadPais(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("pais").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "servletConsultarDomicilio?tipo=pais" , true);
    req.send(null);

    return (true);
}

/*Carga la pagina para modificar los datos de un empleado*/
function loadNuevaPagina(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("noticias_2").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletModificarPersonal?operacion=nuevo&valor="+ document.getElementById("empleados").value, true);
    req.send(null);

    return (true);
}

/*Realiza la carga de las provincias*/
function loadProvincia(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("provincia").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "servletConsultarDomicilio?", true);
    req.send(null);

    return (true);
}

/*Realiza la carga de las localidades de una determinada provincia*/
function loadLocalidad(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("localidad").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "servletConsultarDomicilio?tipo="+document.getElementById("provincia").value, true);
    req.send(null);

    return (true);
}

/*Inicia la consulta del empleado*/
function consultarEmpleado() {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("empleados").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletConsultarPersonal?nombre="+document.getElementById("nombre").value+"&apellido="+document.getElementById("apellido").value, true);
    req.send(null);

    return (true);

}

/*Responde con la informacion del empleado*/
function responderEmpleado() {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("datos").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletConsultarPersonal?empleado="+document.getElementById("empleados").value, true);
    req.send(null);

    return (true);

}

/*Inicia la baja de un Empleado*/
function iniciaBaja() {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("empleados").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletBajaPersonal?", true);
    req.send(null);

    return (true);

}

/*Muestra los datos del empleado a ser dado de baja*/
function mostrarDatosParaDarBaja() {
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("datos").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletBajaPersonal?mostrardatos="+document.getElementById("empleados").value, true);
    req.send(null);

    return (true);


}

/*Da de baja al empleado seleccionado*/
function darBaja () {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("datos").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletBajaPersonal?darbaja="+document.getElementById("empleados").value, true);
    req.send(null);

    return (true);

}

/*Guarda las modificaciones de un empleado*/
function guardarModificacionEmpleado () {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 ) {
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                alert("Actualizo");
                location="PanelNoticias.html";
                
            }else {
                alert("Error");
                location="modificar_personal_ajax.jsp";
            }
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletModificarPersonal?operacion=guardaremp&"+
                           "nombre="+document.getElementById("nombre").value+"&"+
                           "apellido="+document.getElementById("apellido").value+"&"+
                           "dni="+document.getElementById("dni").value+"&"+
                           "fechaNacimiento="+document.getElementById("fechaNacimiento").value+"&"+
                           "telefono="+document.getElementById("telefono").value+"&"+
                           "barrio="+document.getElementById("barrio").value+"&"+
                           "calle="+document.getElementById("calle").value+"&"+
                           "numero="+document.getElementById("numero").value+"&"+
                           "piso="+document.getElementById("piso").value+"&"+
                           "departamento="+document.getElementById("departamento").value+"&"+
                           "pais="+document.getElementById("pais").value+"&"+
                           "localidad="+document.getElementById("localidad").value+"&"+
                           "provincia="+document.getElementById("provincia").value+"&"+
                           "sexo="+document.getElementById("sexo").value+"&"+
                           "cuil="+document.getElementById("cuil").value, true);
    req.send(null);

    return (true);

}

/*Guarda las modificaciones de un profesional*/
function guardarModificacionProfesional () {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 ) {
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                alert("Actualizo");
                location="PanelNoticias.html";
            }else {
                alert("Error");
                location="modificar_personal_ajax.jsp";
            }
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletModificarPersonal?operacion=guardarprof&"+
                           "nombre="+document.getElementById("nombre").value+"&"+
                           "apellido="+document.getElementById("apellido").value+"&"+
                           "dni="+document.getElementById("dni").value+"&"+
                           "fechaNacimiento="+document.getElementById("fechaNacimiento").value+"&"+
                           "telefono="+document.getElementById("telefono").value+"&"+
                           "barrio="+document.getElementById("barrio").value+"&"+
                           "calle="+document.getElementById("calle").value+"&"+
                           "numero="+document.getElementById("numero").value+"&"+
                           "piso="+document.getElementById("piso").value+"&"+
                           "departamento="+document.getElementById("departamento").value+"&"+
                           "pais="+document.getElementById("pais").value+"&"+
                           "localidad="+document.getElementById("localidad").value+"&"+
                           "provincia="+document.getElementById("provincia").value+"&"+
                           "sexo="+document.getElementById("sexo").value+"&"+
                           "cuil="+document.getElementById("cuil").value+"&"+
                           "matricula="+document.getElementById("matricula").value+"&"+
                           "titulo="+document.getElementById("titulo").value, true);
    req.send(null);

    return (true);

}

/*Inicia el alta del personal, llenando el combo de tipos, con los datos correspondientes*/
function iniciarAltaPersonal () {
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("tipoEmpleado").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletAltaPersonal?operacion=load" , true);
    req.send(null);

    return (true);


}

function altaEspecifica () {
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("noticias_2").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletAltaPersonal?operacion=especifica&valor="+ document.getElementById("tipoEmpleado").value, true);
    req.send(null);

    return (true);

}

function altaProfesional () {
    if(!validarFormularioProfesional()) {
        return (false);
    }
    req.onreadystatechange = function () {
        if ( req.readyState == 4 ) {
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                alert("Guardo");
                location="PanelNoticias.html";
            }else {
                alert("Error");
                location="alta_personal.jsp";
            }
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletAltaPersonal?operacion=altaprofesional&"+
                           "nombre="+document.getElementById("nombre").value+"&"+
                           "apellido="+document.getElementById("apellido").value+"&"+
                           "dni="+document.getElementById("dni").value+"&"+
                           "fechaNacimiento="+document.getElementById("DPC_edit1").value+"&"+
                           "telefono="+document.getElementById("telefono").value+"&"+
                           "barrio="+document.getElementById("barrio").value+"&"+
                           "calle="+document.getElementById("calle").value+"&"+
                           "numero="+document.getElementById("numero").value+"&"+
                           "piso="+document.getElementById("piso").value+"&"+
                           "departamento="+document.getElementById("departamento").value+"&"+
                           "pais="+document.getElementById("pais").value+"&"+
                           "localidad="+document.getElementById("localidad").value+"&"+
                           "provincia="+document.getElementById("provincia").value+"&"+
                           "cuil="+document.getElementById("cuil").value+"&"+
                           "sexo="+document.getElementById("sexo").value+"&"+
                           "matricula="+document.getElementById("matricula").value+"&"+
                           "titulo="+document.getElementById("titulo").value+"&"+
                           "tarjeta="+document.getElementById("ntarjeta").value, true);
    req.send(null);

    return (true);

}

function altaEmpleado () {
    if(!validarFormularioEmpleado()) {
        return (false);
    }
    req.onreadystatechange = function () {
        if ( req.readyState == 4 ) {
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                alert("Guardo");
                location="PanelNoticias.html";

            }else {
                alert("Error");
                location="alta_personal.jsp";
            }
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletAltaPersonal?operacion=altaempleado&"+
                           "nombre="+document.getElementById("nombre").value+"&"+
                           "apellido="+document.getElementById("apellido").value+"&"+
                           "dni="+document.getElementById("dni").value+"&"+
                           "fechaNacimiento="+document.getElementById("DPC_edit1").value+"&"+
                           "telefono="+document.getElementById("telefono").value+"&"+
                           "barrio="+document.getElementById("barrio").value+"&"+
                           "calle="+document.getElementById("calle").value+"&"+
                           "numero="+document.getElementById("numero").value+"&"+
                           "piso="+document.getElementById("piso").value+"&"+
                           "departamento="+document.getElementById("departamento").value+"&"+
                           "pais="+document.getElementById("pais").value+"&"+
                           "localidad="+document.getElementById("localidad").value+"&"+
                           "provincia="+document.getElementById("provincia").value+"&"+
                           "sexo="+document.getElementById("sexo").value+"&"+
                           "tarjeta="+document.getElementById("ntarjeta").value+"&"+
                           "cuil="+document.getElementById("cuil").value, true);
    req.send(null);

    return (true);

}
