
var req = createRequestObject();
function js_logIn(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                //open("home.jsp?user="+req.responseText,"_self");
                jAlert('Bienvenido', 'Sistema Personal', function(r) {
                    if( r )  location="home.jsp?user="+req.responseText;//js_login_abrirHome(req.responseText);
                });
            }
            else{
                jAlert("Nombre de usuario o contraseña Incorrecta","Sistema Personal");
            }
            ocultarEspera();
        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("POST", "logInServlet?segurityOption=login&userName="+document.getElementById("user").value+"&pass="+document.getElementById("password").value, true);
    req.send(null);

    return (true);
}

function js_logOff(){
    req.onreadystatechange = function () {
        if ( req.readyState == 4){
            ocultarEspera();
            jAlert("Cerrando sesi&oacuten","Sistema Personal", function(r){
                if(req.status != 200) {
                    alert("Error al cerrar la sesi&oacuten \nPuede que no se haya inicado con exito la session");
                }
                window.location="index.jsp";
            });
            

        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };
    req.open("POST", "logInServlet?segurityOption=logoff", true);
    req.send(null);

    return (true);
}
function js_login_abrirHome(usuario){
    var param = "user="+usuario;
    var ajax = createRequestObject();
    ajax.onreadystatechange = function () {
        if (ajax.readyState==4){
            if (ajax.status==200){
                alert(ajax.responseText);
            }else{
                jAlert("Error al recibir la información!","Error de Sistema");
            }
        }
    };
    ajax.open("POST","home.jsp",true);
    ajax.send(param);
}

function js_cambiar_pass(){
    req.onreadystatechange()= function(){
        if ( req.readyState == 4){
            if(req.status == 200 || window.location.href.indexOf ("http")==- 1) {
                ocultarEspera();
                js_confirm_operacion(true);
            }
            else{
                jAlert(req.responseText, "Error de Sistema" );
            }

        } else {
            if(req.readyState==1){
                mostrarEspera();
            }
        }
    };

    req.open("GET","cambiarPassServlet?actual="+document.getElementById("passActual").value+"&nuevo="+document.getElementById("passNuevo").value+"&confirma="+document.getElementById("passConfirm").value);
    req.send(null);
}





