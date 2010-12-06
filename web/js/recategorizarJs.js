var req = createRequestObject();

function js_cargarNoticias_recat(menu){
    req.onreadystatechange = function () {
        if ( req.readyState == 4 && (req.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("noticias").innerHTML = req.responseText;
            js_recategor();
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("GET", "menuServlet?opMenu="+menu , true);
    req.send(null);

    return (true);
}
function js_recategor(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("empleado").innerHTML = req.responseText;
                document.getElementById("agrupamiento").innerHTML="";
                document.getElementById("tramo").innerHTML="";
                document.getElementById("categoria").innerHTML="";
                document.getElementById("clase").innerHTML="";
            }
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
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("agrupamiento").innerHTML = req.responseText;
                document.getElementById("tramo").innerHTML="";
                document.getElementById("categoria").innerHTML="";
                document.getElementById("clase").innerHTML="";
            }
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
        if ( req.readyState == 4 ){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("tramo").innerHTML = req.responseText;
                document.getElementById("categoria").innerHTML="";
                document.getElementById("clase").innerHTML="";
            }
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
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("categoria").innerHTML = req.responseText;
                document.getElementById("btnListAll").style.display="block";
                document.getElementById("clase").innerHTML="";
            }
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
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("categoria").innerHTML = req.responseText;
                document.getElementById("clase").innerHTML=""
            }
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
        if ( req.readyState == 4 ){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                document.getElementById("clase").innerHTML = req.responseText;
            }
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
                js_confirm_operacion(true);
            }
            else{
                js_confirm_operacion(false)
                alert("ERROR: " + req.statusText);
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
    loadMenuFunction("gohome");
}


