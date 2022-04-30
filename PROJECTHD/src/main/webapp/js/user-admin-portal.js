var params = new URLSearchParams(window.location.search);
var username = params.get("username");
window.localStorage.setItem("username", username);