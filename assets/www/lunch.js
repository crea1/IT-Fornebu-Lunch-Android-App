var json = '';
var intervalID;
var flashTextCounter=0;
/**
 * This method retrieves the json object from the jsinterface
 */
function getJSONMenu() {
    json = jsinterface.loadMenu();

    callUpdate();
}


/**
 * This method parses the json object and updates the html
 */
function updateThis() {
    try {
        var meny = JSON.parse(json);
    } catch(e) {
        alert("Something went wrong when parsing lunch json. \n"+e.toString());
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

        displayTimestamp();
    } else {
        $('div#info').empty()
        $('div#info').append('<p>Kunne ikke koble til Skynet...</p>');
        $('div#info').removeClass('hidden');

        intervalID = setInterval(flashText, 1000);
    }
}



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


function displayTimestamp() {
    $('div#timestamp').removeClass('hidden')
    var d = new Date();
    // adding 0 if number is less than 10
    var hours =   ((d.getHours()   < 10 ? '0' : '') + d.getHours().toString());
    var minutes = ((d.getMinutes() < 10 ? '0' : '') + d.getMinutes().toString());
    var seconds = ((d.getSeconds() < 10 ? '0' : '') + d.getSeconds().toString());

    $('div#timestamp').empty()
    $('div#timestamp').append('Meny hentet: ' + d.getDate() + '.'
        + (d.getMonth()+1) + '.' + d.getFullYear() + ' '
        + hours + ':' + minutes + ':' + seconds);
}


/**
 * This method sends a request to the callJson
 * method in the jsinterface.
 */
function callJavaForLunchUpdate() {
    $('div#info').addClass('hidden');
    $('div#timestamp').addClass('hidden');
    $('div#spinner').removeClass('hidden');
    window.jsinterface.callJson();
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

