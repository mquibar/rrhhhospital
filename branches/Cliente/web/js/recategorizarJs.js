var req = createRequestObject();

function js_recategor(){
     req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("empleado").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "recategorizarServlet?operacion=iniciar" , true);
    req.send(null);
    return (true);
}

function js_lista_Agrupamiento(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("agrupamiento").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "recategorizarServlet?operacion=agrupamiento" , true);
    req.send(null);
    return (true);
}

