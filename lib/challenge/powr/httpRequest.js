const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

const coolNumsSum = 70601040511;

const url = "http://166.78.22.78/dev/open-sesame.php";
let str;

const params = {
  code: coolNumsSum
};

const xhr = new XMLHttpRequest();
xhr.open("POST", url, false);
xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
xhr.onreadystatechange = function() {
  const res = xhr.responseText;
  str = res;
  console.log(str);
}
xhr.send(JSON.stringify(params));
// cheeese!
// Not working with raw params, works with Postman
