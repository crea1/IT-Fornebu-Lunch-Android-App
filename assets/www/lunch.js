var json = '';
var intervalID;
var flashTextCounter=0;
/**
 * This method retrieves the json object from the jsinterface
 */
/*function getJSONMenu() {
    json = jsinterface.loadMenu();
    updateHTMLWithMenu();
}*/


/**
 * This method parses the json object and updates the html
 */
function updateHTMLWithMenu() {
     json = jsinterface.loadMenu();
    try {
        var meny = JSON.parse(json);
    } catch(e) {
        alert("Something went wrong when parsing lunch json. \n"+e.toString() + json);
    }
    // Check the response and use jQuery to fill up menu
    if (!(meny.Monday == "null")) {
        $('div.monday').replaceWith('<div class="monday dish">' + meny.Monday+ '</div>');
        $('div.tuesday').replaceWith('<div class="tuesday dish">' + meny.Tuesday+ '</div>');
        $('div.wednesday').replaceWith('<div class="wednesday dish">' + meny.Wednesday+ '</div>');
        $('div.thursday').replaceWith('<div class="thursday dish">' + meny.Thursday+ '</div>');
        $('div.friday').replaceWith('<div class="friday dish">' + meny.Friday+ '</div>');

        $('div#menu').removeClass('hidden');
        $('div#spinner').addClass('hidden');
        $('div#timestamp').removeClass('hidden')
        $('div#timestamp').replaceWith('<div id="timestamp">Meny hentet: ' + meny.Timestamp+ '</div>');

    } else {
        $('div#info').empty()
        $('div#info').append('<p>Kunne ikke koble til Skynet...</p>');
        $('div#info').removeClass('hidden');

        intervalID = setInterval(flashText, 1000);
    }
}


/**
 * This function displays text if menu can't be found.
 */
function flashText() {
    flashTextCounter++;
    if (flashTextCounter == 1) {
        $('div#info').append('<p>Kunne ikke koble til Skynet...</p>');
    } else if (flashTextCounter == 2) {
        $('div#info').append('<p>Vennligst kontakt Cyberdyne Systems.</p>');
    } else {
        intervalID=window.clearInterval(intervalID);
        flashTextCounter=0;
    }

}

/**
 * This method sends a request to the callJson
 * method in the jsinterface.
 */
function callJavaForLunchUpdate() {
    $('div#info').addClass('hidden');
    $('div#timestamp').addClass('hidden');
    $('div#spinner').removeClass('hidden');
    //window.jsinterface.fetchLunch();
    updateHTMLWithMenu();
}

function callUpdate() {
    window.jsinterface.callUpdate();
}



/**
 * This method sends a request to the getWeekdayNumber
 * method in the jsinterface.
 */
function callWeekday() {
    var i = window.jsinterface.getWeekdayNumber();

}


/**
 * When document is loaded.
 */
$(document).ready(function() {
    $('div#info').addClass('hidden');
    $('div#timestamp').addClass('hidden');
    $('div#spinner').removeClass('hidden');
    callJavaForLunchUpdate();
});

