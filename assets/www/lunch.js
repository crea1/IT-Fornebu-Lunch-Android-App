var json = '';
var intervalID;
var flashTextCounter=0;

/**
 * This method parses the json object and updates the html
 */
function updateHTMLWithMenu() {
    // Calling the Java Interface to load the lunch menu.
    json = jsinterface.loadMenu();
    try {
        // Parse the json object to a object.
        var meny = JSON.parse(json);
    } catch(e) {
        alert("Something went wrong while parsing JSON. \n"+e.toString() + json);
    }
    // Check the response and use jQuery to fill up menu
    if (!(meny.Monday == "null")) {
        $('div.monday').replaceWith('<div class="monday dish">' + meny.Monday + '</div>');
        $('div.tuesday').replaceWith('<div class="tuesday dish">' + meny.Tuesday + '</div>');
        $('div.wednesday').replaceWith('<div class="wednesday dish">' + meny.Wednesday + '</div>');
        $('div.thursday').replaceWith('<div class="thursday dish">' + meny.Thursday + '</div>');
        $('div.friday').replaceWith('<div class="friday dish">' + meny.Friday + '</div>');
        highlightToday(parseInt(meny.DayOfWeek));
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

function highlightToday(today) {
    switch(today) {
        case 2:
            $('div.mondaycontainer').addClass('today');
            break;
        case 3:
            $('div.tuesdaycontainer').addClass('today');
            break;
        case 4:
            $('div.wednesdaycontainer').addClass('today');
            break;
        case 5:
            $('div.thursdaycontainer').addClass('today');
            break;
        case 6:
            $('div.fridaycontainer').addClass('today');
            break;
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

/**
 * When document is loaded.
 * We try to access the java for retriving lunch.
 */
$(document).ready(function() {
    callJavaForLunchUpdate();
});

