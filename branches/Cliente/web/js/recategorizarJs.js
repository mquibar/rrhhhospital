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

function js_lista_Tramo(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("tramo").innerHTML = req.responseText;
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "recategorizarServlet?operacion=tramo&agrupamiento="+document.getElementById("agrupamiento") , true);
    req.send(null);
    return (true);
}

function js_cat_posibles(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("agrupamiento").innerHTML = req.responseText;
            document.getElementById("btnListAll").style.display="none";
            ocultarEspera();
        } else {
            if(req.readyState==1){
               mostrarEspera();
            }
        }
    };
    req.open("GET", "recategorizarServlet?operacion=categoria_posible&tramo="+document.getElementById("tramo")+"empleado="+document.getElementById("empleado") , true);
    req.send(null);
    return (true);
}

function js_cat_all(){
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
    req.open("GET", "recategorizarServlet?operacion=categoria_todo&tramo="+document.getElementById("tramo") , true);
    req.send(null);
    return (true);
}