function addItem(id) {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/addItemCart?id=' + id, true);
    xhr.send();
}

function showResult(str) {
    if (str.length==0) {
        document.getElementById("livesearch").innerHTML="";
        document.getElementById("livesearch").style.border="0px";
        return;
    }

    var xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function() {
        if (this.readyState==4 && this.status==200) {
            console.log(this.responseText);
            displayResult(JSON.parse(this.responseText));
        }
    }
    xhr.open("GET","/liveSearch?q=" + str,true);
    xhr.send();
}

function displayResult(results) {
    var searchResults = document.getElementById('livesearch');
    searchResults.innerHTML = '';

    searchResults.style.border = "0.5px solid black";
    results.forEach((result) => {
        console.log(result.name);
        var div = document.createElement('div');
        div.textContent = result.name;
        div.style.color = "black";
        div.style.fontSize = "10px";
        searchResults.appendChild(div);
    });
}