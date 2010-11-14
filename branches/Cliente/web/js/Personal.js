/* 
 * Funciones para la incorporacion de ajax en las pantallas del empleados
 *
 */

var req = createRequestObject();

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
    req.open("GET", "ServletModificarPersonal?" , true);
    req.send(null);

    return (true);
}

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
    req.open("GET", "ServletModificarPersonal?tipo=persona&valor="+ document.getElementById("empleados").value, true);
    req.send(null);

    return (true);
}

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

function responderEmpleado () {

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