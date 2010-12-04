var req = createRequestObject();
function js_begin_asignar(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("empleados").innerHTML = req.responseText;
            document.getElementById("agrupamiento").innerHTML="";
            document.getElementById("tramo").innerHTML="";
            document.getElementById("categoria").innerHTML="";
            document.getElementById("clase").innerHTML="";
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "asignarLegServlet?operacion=begin" , true);
    req.send(null);
    return (true);
}

function js_agrupamiento_alegajo(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("agrupamiento").innerHTML = req.responseText;
            document.getElementById("tramo").innerHTML="";
            document.getElementById("categoria").innerHTML="";
            document.getElementById("clase").innerHTML="";
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "asignarLegServlet?operacion=agrupamiento" , true);
    req.send(null);
    return (true);
}

function js_tramo_alegajo(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("tramo").innerHTML = req.responseText;

            document.getElementById("categoria").innerHTML="";
            document.getElementById("clase").innerHTML="";
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "asignarLegServlet?operacion=tramo&agrupamiento="+document.getElementById("agrupamiento").value , true);
    req.send(null);
    return (true);
}

function js_categoria_alegajo(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("categoria").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "asignarLegServlet?operacion=categoria_todo&tramo="+document.getElementById("tramo").value , true);
    req.send(null);
    return (true);
}

function js_clase_alegajo(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("clase").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "asignarLegServlet?operacion=clase&categoria="+document.getElementById("categoria").value , true);
    req.send(null);
    return (true);
}

function js_save_alegajo(){
    if(!validarFormularioAsignarLegajo()) {
        return (false);
    }
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                alert("Operacion realizada con exito");
                open("underContruction.html","_self");
            }
            else{
                alert("No se pudo realizar la operacion \n ERROR: " + req.responseText);
            }
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "asignarLegServlet?operacion=save&empleado="+document.getElementById("empleado").value+"categoria="+document.getElementById("categoria").value+"&clase="+document.getElementById("clase").value+"&legajo="+document.getElementById("legajo").value , true);
    req.send(null);
    return (true);
}

function js_cancel_alegajo(){
    alert("Operacion cancelada por el usuario");
    open("PanelNoticias.html","_self");
}

