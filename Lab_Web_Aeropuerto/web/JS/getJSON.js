
function getJSON(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.json();
    }).then(callback);

}


function getJSONConfirmacion(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: data
    }).then((result) => {
        return result.text();
    }).then(callback);

}

function getJSONC(url, data, callback) {
    fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        contentType: "application/json"
    }).then((result) => {
        return result.json();
    }).then(callback);

}


function setJSON(url, data) {
    fetch(url, {
        method: 'GET',
        body: data
    });
}
