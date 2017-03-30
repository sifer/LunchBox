/**
 * Created by Administrator on 2017-03-29.
 */
function ready(fn) {
    if (document.readyState != 'loading') {
        fn();
    }else{
        document.addEventListener('DOMContentLoaded', fn)
    }
}
function fn() {
    var element =  document.querySelector("#annons");
    element.style.visibility = 'visible';
 /*   var element2 =  document.querySelector("#black_overlay");
    element2.style.visibility = 'visible';*/
}


function hej(fa) {
    if (document.readyState != 'loading') {
        fa();
    } else {
        document.addEventListener('DOMContentLoaded', fa)
    }
}

function fa() {
    var elementt =  document.querySelector("#bg");
    elementt.style.visibility = 'visible';
    var elementt2 =  document.querySelector("#black_overlay");
    elementt2.style.visibility = 'visible';
}


function closeFn(){
    var element =  document.querySelector("#annons");
    element.style.visibility = 'hidden';
}
function closeFa(){
    var element =  document.querySelector("#bg");
    element.style.visibility = 'hidden';
}