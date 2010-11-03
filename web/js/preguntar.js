document.write("<script type='text/javascript' src='./js/esperar.js'></script>");
var obj = createRequestObject();
function createRequestObject(){
    var req; try {
        // Firefox, Opera, Safari
        req = new XMLHttpRequest();
    } catch (e) {
        // Internet Explorer
        try {
            //For IE 6
            req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                //For IE 5
                req = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert('Your browser is not IE 5 or higher, or Firefox or Safari or Opera');
            }
        }
    }
    return req;
}

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
    obj.open("GET", "testLocalidades?tipo=agrupamiento" , true);
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
    obj.open("GET", "testLocalidades?tipo=tramo&agrupamiento=" + document.getElementById("agrupamiento").value , true);
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