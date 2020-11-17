function pow(event) {
    element = event.currentTarget;
    element.style.backgroundColor="green";
    alert(element.id);
}

//anonymous function
window.onload = function () {
    //                               useCapute/Evnet Propogation   false-   Bubblihng target to Root
    //                                                             true- capturing, root to target
    this.document.getElementById("A").addEventListener("click",pow,false);
    this.document.getElementById("B").addEventListener("click",pow,false);
    this.document.getElementById("C").addEventListener("click",pow,false);
    this.document.getElementById("D").addEventListener("click",pow,false);
}