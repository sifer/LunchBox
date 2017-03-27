
var geocoder;
var map;

//initMap körs automatiskt när sidan laddas med hjälp av "async defer" i .html
function initMap() {
    var uluru = {lat: 59.3293235, lng: 18.0685808};
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: uluru
    });
    var marker = new google.maps.Marker({
        position: uluru,
        map: map
    });

    var markerCluster = new MarkerClusterer(map, markers, {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
    

    document.getElementById('submit').addEventListener('click', function() {
        codeAddress(geocoder, map);
    });

}

//Funktion som letar upp koordinater för addressen som anges i textrutan och sätter ut pin
function codeAddress() {
    geocoder = new google.maps.Geocoder();

    var address = document.getElementById('address').value;
    geocoder.geocode( {"address": address}, function(results, status) {

        if(status == "OK") {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
            //Om ingen träff på addressen
        } else {
            alert("Geocode not successful because: " + status);
        }
    });
}