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
        $('div#monday').html(meny.Monday);
        $('div#tuesday').html(meny.Tuesday);
        $('div#wednesday').html(meny.Wednesday);
        $('div#thursday').html(meny.Thursday);
        $('div#friday').html(meny.Friday);
        highlightToday(parseInt(meny.DayOfWeek));
        $('div#menu').removeClass('hidden');
        $('div#spinner').addClass('hidden');
        $('div#timestamp').removeClass('hidden')
        $('div#timestamp').replaceWith('<div id="timestamp">Meny hentet: ' + meny.Timestamp+ '</div>');

    } else {
        $('div#info').empty()
        $('div#info').removeClass('hidden');

        intervalID = setInterval(flashText, 1000);
    }
}

function highlightToday(today) {
    switch(today) {
        case 2:
            $('div#mcontainer').addClass('today');
            break;
        case 3:
            $('div#tcontainer').addClass('today');
            break;
        case 4:
            $('div#wcontainer').addClass('today');
            break;
        case 5:
            $('div#thcontainer').addClass('today');
            break;
        case 6:
            $('div#fcontainer').addClass('today');
            break;
    }
}


/**
 * This function displays text if menu can't be found.
 */
function flashText() {
    flashTextCounter++;
    if (flashTextCounter == 1) {
        $('div#info').append('<p>Kunne ikke laste ned lunsj.</p>');
    } else if (flashTextCounter == 2) {
        $('div#info').append('<p>Trykk Oppdater for å prøve igjen</p>');
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

