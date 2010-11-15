var delay=2500 //pausa (en milisegundos)
var fcontent=new Array()
begintag='<font face="Verdana" size=2>' //tag que abre los mensajes
fcontent[0]="<b>Ejemplo...</b><br><br>Este script es muy practico para hacer una rapida presentación de tu sitio web."
fcontent[1]="Un sitio Web bien presentado puede conseguir visitas mas adaptada a tus contenidos."
fcontent[2]="La continua actualizacion de un sitio web es uno de los mejores incentivos para el visitante."
closetag='</font>'

var fwidth=150 //ancho
var fheight=150 //alto

///No editar/////////////////

var ie4=document.all&&!document.getElementById
var ns4=document.layers
var DOM2=document.getElementById
var faderdelay=0
var index=0

if (DOM2)
    faderdelay=2000

//function to change content
function changecontent(){
    if (index >= fcontent.length)
        index=0;
    if (DOM2){
        document.getElementById("panel").style.color="rgb(255,255,255)";
        document.getElementById("panel").innerHTML=begintag+fcontent[index]+closetag;
        colorfade();
    }
    else if (ie4)
        document.all.fscroller.innerHTML=begintag+fcontent[index]+closetag
    else if (ns4){
        document.fscrollerns.document.fscrollerns_sub.document.write(begintag+fcontent[index]+closetag)
        document.fscrollerns.document.fscrollerns_sub.document.close()
    }

    index++
    setTimeout("changecontent()",delay+faderdelay)
}
frame=20;
hex=255  // Initial color value.

function colorfade() {
    // 20 frames fading process
    if(frame>0) {
        hex-=12; // increase color value
        document.getElementById("panel").style.color="rgb("+hex+","+hex+","+hex+")"; // Set color value.
        frame--;
        setTimeout("colorfade()",20);
    }
    else{
        document.getElementById("panel").style.color="rgb(0,0,0)";
        frame=20;
        hex=255
    }
}

