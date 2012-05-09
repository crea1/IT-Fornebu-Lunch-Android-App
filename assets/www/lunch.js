var json = '';
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
        alert(e.toString());
    }
    // Use jQuery to populate menu
    $('div.monday').replaceWith('<div class="monday dish">' + meny.Monday+ '</div>');
    $('div.tuesday').replaceWith('<div class="tuesday dish">' + meny.Tuesday+ '</div>');
    $('div.wednesday').replaceWith('<div class="wednesday dish">' + meny.Wednesday+ '</div>');
    $('div.thursday').replaceWith('<div class="thursday dish">' + meny.Thursday+ '</div>');
    $('div.friday').replaceWith('<div class="friday dish">' + meny.Friday+ '</div>');

    $('div#menu').removeClass('hidden');
    $('div#controls').removeClass('hidden');
    $('div#spinner').addClass('hidden');
}

/**
 * This method sends a request to the callJson
 * method in the jsinterface.
 */
function callJson() {
    $('div#menu').addClass('hidden');
    $('div#controls').addClass('hidden');
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
$(document).ready(function() {
    callJson();
});

