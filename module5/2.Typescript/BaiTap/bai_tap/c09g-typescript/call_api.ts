console.log("Start");

let xHttp = new XMLHttpRequest();
xHttp.onload = function() {
    if (this.status == 200) {
        console.log(xHttp.responseText);
    }
};
xHttp.open("GET", 'https://api.github.com/search/repositories?q=angular');
xHttp.send();

console.log("End");

