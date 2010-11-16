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
                open("/underContruction.html","_self");
            }else {
                alert("Error");
            }
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletBajaPersonal?operacion=guardar&"+
                           document.getElementById("nombre")+"&"+
                           document.getElementById("apellido")+"&"+
                           document.getElementById("dni")+"&"+
                           document.getElementById("fechaNacimiento")+"&"+
                           document.getElementById("telefono")+"&"+
                           document.getElementById("cuil")+"&"+
                           document.getElementById("calle")+"&"+
                           document.getElementById("numero")+"&"+
                           document.getElementById("barrio")+"&"+
                           document.getElementById("piso")+"&"+
                           document.getElementById("departamento")+"&"+
                           document.getElementById("pais")+"&"+
                           document.getElementById("localidad")+"&"+
                           document.getElementById("provincia"), true);
    req.send(null);

    return (true);

}

function guardarModificacionProfesional () {

    req.onreadystatechange = function () {
        if ( req.readyState == 4 ) {
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                alert("Actualizo");
                open("/underContruction.html","_self");
            }else {
                alert("Error");
            }
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "ServletBajaPersonal?operacion=guardar&"+
                           document.getElementById("nombre")+"&"+
                           document.getElementById("apellido")+"&"+
                           document.getElementById("dni")+"&"+
                           document.getElementById("fechaNacimiento")+"&"+
                           document.getElementById("telefono")+"&"+
                           document.getElementById("titulo")+"&"+
                           document.getElementById("matricula")+"&"+
                           document.getElementById("cuil")+"&"+
                           document.getElementById("calle")+"&"+
                           document.getElementById("numero")+"&"+
                           document.getElementById("barrio")+"&"+
                           document.getElementById("piso")+"&"+
                           document.getElementById("departamento")+"&"+
                           document.getElementById("pais")+"&"+
                           document.getElementById("localidad")+"&"+
                           document.getElementById("provincia"), true);
    req.send(null);

    return (true);

}
