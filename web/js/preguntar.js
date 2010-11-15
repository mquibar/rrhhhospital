document.write("<script type='text/javascript' src='./js/esperar.js'></script>");
var obj = createRequestObject();

function iniciar(){
    obj.onreadystatechange = function () {
        if ( obj.readyState == 4 && (obj.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("agrupamiento").innerHTML = obj.responseText;
            document.getElementById("te").value= "Combo Cargado";
            ocultarEspera();
        } else {
            if(obj.readyState==1){
                document.getElementById("te").value= "Se esta cargando el combo de Agrupamiento";
                mostrarEspera();
            }
        }
    };
    obj.open("GET", "testAgrupamiento?tipo=agrupamiento" , true);
    obj.send(null);

    return (true);
}

function listarTramo(){
    obj.onreadystatechange = function () {
        if ( obj.readyState == 4 && (obj.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("tramo").innerHTML = obj.responseText;
            document.getElementById("te").value= "Combo Cargado";
            ocultarEspera();
        } else {
            if(obj.readyState==1){
                document.getElementById("te").value= "Se esta cargando el combo de tramo";
                ocultarEspera();
            }
        }
    };
    obj.open("GET", "testAgrupamiento?tipo=tramo&agrupamiento=" + document.getElementById("agrupamiento").value , true);
    obj.send(null);

    return (true);
}

function generarReporte(){
    obj.onreadystatechange = function () {
        if ( obj.readyState == 4 && (obj.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("Reporte").innerHTML = obj.responseText;
            ocultarEspera();
        } else {
            if(obj.readyState==1){
                ocultarEspera();
}
        }
    };
    obj.open("GET", "reporteRequest", true);
    obj.send(null);

    return (true);
}
