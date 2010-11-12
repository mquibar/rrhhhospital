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