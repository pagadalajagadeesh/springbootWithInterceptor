var getUrl = window.location;
var baseUrl = getUrl.protocol + "//" + getUrl.host + "/"
		+ getUrl.pathname.split('/')[1];

var validationKey = new URLSearchParams(window.location.search)
.get('validationKey');

