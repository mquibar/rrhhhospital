var req = createRequestObject();

function js_recategor(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("empleado").innerHTML = req.responseText;
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
    req.open("GET", "recategorizarServlet?operacion=iniciar" , true);
    req.send(null);
    return (true);
}

function js_lista_Agrupamiento(){
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
    req.open("GET", "recategorizarServlet?operacion=agrupamiento" , true);
    req.send(null);
    return (true);
}

function js_lista_tramo(){
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
    req.open("GET", "recategorizarServlet?operacion=tramo&agrupamiento="+document.getElementById("agrupamiento").value , true);
    req.send(null);
    return (true);
}

function js_lista_catPosible(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("categoria").innerHTML = req.responseText;
            document.getElementById("btnListAll").style.display="block";
            document.getElementById("clase").innerHTML="";
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "recategorizarServlet?operacion=categoria_posible&tramo="+document.getElementById("tramo").value+"&empleado="+document.getElementById("empleado").value , true);
    req.send(null);
    return (true);
}

function js_lista_catAll(){
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
    req.open("GET", "recategorizarServlet?operacion=categoria_todo&tramo="+document.getElementById("tramo").value , true);
    req.send(null);
    return (true);
}

function js_lista_clase(){
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
    req.open("GET", "recategorizarServlet?operacion=clase&categoria="+document.getElementById("categoria").value , true);
    req.send(null);
    return (true);
}

function js_save_recat(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            ocultarEspera();
            if (req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                jAlert("Operacion realizada con exito","Sistema Personal", function(){
                    jConfirm("Continuar para volver al inicio", "Sistema Personal", function(r){
                       if(r)location="underContruction.html";
                    });
                });
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
    req.open("GET", "recategorizarServlet?operacion=guardar&categoria="+document.getElementById("categoria").value+"&clase="+document.getElementById("clase").value , true);
    req.send(null);
    return (true);
}

function js_cancel_recat(){
    alert("Operacion cancelada por el usuario");
    open("underContruction.html","_self");
}


