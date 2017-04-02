
var geocoder;
var map;

//initMap körs automatiskt när sidan laddas med hjälp av "async defer" i .html
function initMap() {
    var stockholm = {lat: 59.3293235, lng: 18.0685808};
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: stockholm,
        styles: mapStyle
    });

    document.querySelector('.newLoc').addEventListener('click', function() {
        codeAddress(geocoder, map);
    });
    function createMarker(pos) {
        var icon = {url: 'icon/standard.jpg', scaledSize: new google.maps.Size(48, 48)};
        if(pos.vego){
            icon.url = 'icon/vego.png';
        };
        if(pos.vegan){
            icon.url = 'icon/vegan.png';
        };
        if(pos.kyckling){
            icon.url = 'icon/kyckling.png';
        };
        if(pos.nöt){
            icon.url = 'icon/kött.png';
        };
        if(pos.fläsk){
            icon.url = 'icon/fläsk.png';
        };
        if(pos.fisk){
            icon.url = 'icon/fisk.png';
        };
        var marker = new google.maps.Marker({
            position: {lat: pos.latitud, lng: pos.longitud},
            map: map,  // google.maps.Map
            title: pos.description,
            icon: icon
        });

        var infowindow = new google.maps.InfoWindow({
            content: '<div>'+pos.description+'</div>'
        });
        marker.addListener('click', function() {
            infowindow.open(map, marker);
        });
        return marker;
    }
    function createMarkers() {
        for (var i = 0; i < lunchBoxes.length; i++) {
            createMarker(lunchBoxes[i]);
        }
    }
    createMarkers();
    console.log(lunchBox);
}

//Funktion som letar upp koordinater för addressen som anges i textrutan och sätter ut pin
function codeAddress() {
    geocoder = new google.maps.Geocoder();

    var address = document.querySelector('.address').value;
    geocoder.geocode( {"address": address}, function(results, status) {

        if(status == "OK") {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location,


            });

            //Om ingen träff på addressen
        } else {
            alert("Geocode not successful because: " + status);
        }
    });
}
//Hämta nuvarande position
var options = {
    enableHighAccuracy: true,
    timeout: 5000,
    maximumAge: 30000
};
function success(pos) {
    var crd = pos.coords;
    uluru = { lat: crd.latitude, lng: crd.longitude };
    map.setCenter(uluru);
    console.log('Your current position is:');
    console.log('Latitude: '+crd.latitude);
    console.log('Longitude: '+crd.longitude);
    console.log('More or less '+crd.accuracy+' meters.');
};

function error(err) {
    console.warn('ERROR(${err.code}): ${err.message}');
};
navigator.geolocation.getCurrentPosition(success, error, options);
