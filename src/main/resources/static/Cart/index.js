function delItem(id) {
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange=function() {
        if (this.readyState==4 && this.status==200) {
            location.reload();
        }
    }

    xhr.open('GET', '/delItemCart?id=' + id, true);
    xhr.send();
}

function increaseItem(id, num) {
    setTimeout(function (){
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange=function() {
            if (this.readyState==4 && this.status==200) {
                location.reload();
            }
        }

        xhr.open('GET', '/increaseItemCart?id=' + id + '&num=' + num, true);
        xhr.send();
        }, 1000);

}