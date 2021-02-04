console.log("Start");
let promiseObj = new Promise((resolve, reject) => {
    let xHttp = new XMLHttpRequest();
    xHttp.onload = function () {
        if (this.status == 200) {
            resolve(xHttp.responseText);
        }
        else {
            reject(xHttp.statusText);
        }
    };
    xHttp.open("GET", 'https://api.github.com/search/repositories?q=angular');
    xHttp.send();
});
promiseObj.then(value => {
    console.log("OK");
    console.log(value);
    console.log("End");
}, reason => {
    console.log("NG");
    console.log(reason);
});
