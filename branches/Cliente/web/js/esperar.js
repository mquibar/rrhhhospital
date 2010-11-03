document.write("<div ID='waitDiv' style='position:absolute;visibility:hidden;width:100%; height:100%'>\n\
                    <table width='100%' height='100%'>\n\
                        <tr valign='middle' align='center'>\n\
                            <td align='center' ><img src='img/cargando9.gif'></td>\n\
                        </tr>\n\
                    </table> \n\
                </div>");

var DHTML = (document.getElementById || document.all || document.layers);
function ap_getObj(name) {
    if (document.getElementById)
    {
        return document.getElementById(name).style; 
    }
    else if (document.all)
    {
        return document.all[name].style;
    }
    else if (document.layers)
    {
        return document.layers[name];
    }
}
function ap_showWaitMessage(div,flag) {
    if (!DHTML) return;
    var x = ap_getObj(div);
    x.visibility = (flag) ? "visible":"hidden"
    if(! document.getElementById)
        if(document.layers) x.left=280/2;
    return true;
}
function mostrarEspera(){
    ap_showWaitMessage('waitDiv', 3);
}
function ocultarEspera(){
    ap_showWaitMessage('waitDiv', 0);
}