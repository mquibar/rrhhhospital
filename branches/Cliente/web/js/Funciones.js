/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
document.write("<script type='text/javascript' src='./js/esperar.js'></script>");
function sleep(delay) {
     mostrarEspera();
     var start = new Date().getTime();
     while (new Date().getTime() < start + delay);
     ocultarEspera();

 }

function gtramo() {

    var obj = false;
    
    if (window.XMLHttpRequest) {
        //Cuidado aqui, el objeto XMLHttpRequest no esta disponible en versiones previas a IE7
        obj = new XMLHttpRequest();
    } else {
        return false;
    }
    obj.onreadystatechange = function () {

        if ( obj.readyState == 4 && (obj.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("tramo").innerHTML = obj.responseText;
            //sleep(2000);
            ocultarEspera();
            
        } else {
            if(obj.readyState == 1) {
                mostrarEspera();

            }
    }
    };
    obj.open("GET", "ServeltTramo?agrupamiento=" + document.getElementById("agrupamiento").value, true);
    obj.send(null);

    return (true);
}

function ecategoria() {

    var obj = false;
    
    if (window.XMLHttpRequest) {
        //Cuidado aqui, el objeto XMLHttpRequest no esta disponible en versiones previas a IE7
        obj = new XMLHttpRequest();
    } else {
        return false;
    }
    obj.onreadystatechange = function () {
        if ( obj.readyState == 4 && (obj.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("categoria").innerHTML = obj.responseText;
            
            //sleep(3000);
            ocultarEspera();
            
        } else {
            if(obj.readyState == 1) {
                mostrarEspera();

            }
    //procesando...
    }
    };
    obj.open("GET", "ServeltTramo?tramo=" + document.getElementById("tramo").value, true);
    obj.send(null);

    return (true);
}

function agre() {

    var obj = false;
    
    if (window.XMLHttpRequest) {
        //Cuidado aqui, el objeto XMLHttpRequest no esta disponible en versiones previas a IE7
        obj = new XMLHttpRequest();
    } else {
        return false;
    }
    obj.onreadystatechange = function () {
        if ( obj.readyState == 4 && (obj.status == 200 || window.location.href.indexOf ("http")==- 1)) {
            document.getElementById("agrupamiento").innerHTML = obj.responseText;
            
            //sleep(4000);
            ocultarEspera();
            
        } else {
            if(obj.readyState == 1) {
                mostrarEspera();

            }
    }
    };
    obj.open("GET", "ServeltTramo?empleado=" + document.getElementById("empleado").value, true);
    obj.send(null);

    return (true);
}

