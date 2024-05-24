// {
//     "from": "TIARA",
//     "to": "2547XXXXXXXX",
//     "message": "Test SMS",
//     "refId": "09wiwu088e"
// }

// Sample JSON Send SMS Response (HTTP code 200):

// {
//     "cost": "KES 0.6",
//     "mnc": "02",
//     "balance": "KES 3137.5598",
//     "msgId: "0bc5be98-5322-4cf3-ac02-303165997da5"
//     "to": "2547XXXXXXXX"
//     "mcc": "639"
//     "desc": "Success"
//     "status": "SUCCESS"
//     "statusCode": "0"
// }

// Sample JSON Send SMS Response (Error):

// {
//     "timestamp": "2021-05-28T10:20:00.335+00:00",
//     "status": "403",
//     "error": "Forbidden",
//     "message: ""
//     "path": "/api/messaging/sendsms"
// }

let form = document.querySelector("form");

form.addEventListener("submit", function (e) {
  e.preventDefault();

  let from = document.getElementById("fromId").value;
  let to = document.getElementById("toId").value;
  let message = document.getElementById("messageId").value;

  let URI = "https://api.tiaraconnect.io/api/messaging/sendsms";
  let API_KEY =
    "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzMzgiLCJvaWQiOjMzOCwidWlkIjoiMGJmMTc3NTItZDNlMC00MTk4LThkODQtODFiOTU4YzFhOWYxIiwiYXBpZCI6Mjk0LCJpYXQiOjE3MTY1NDE1NDcsImV4cCI6MjA1NjU0MTU0N30.xmOJus2msTeRal-NK9fWSFehrEngJxmMcgfk6X5y2Ib61NUehzo4Y_fT4-Y9dO-IMIPODAsD3t7ts2KyVRY4cQ";

  let request = {
    from: from,
    to: to,
    message: message,
  };
  let requestString = JSON.stringify(request);

  var xhttp = new XMLHttpRequest();

  xhttp.open("POST", URI);
  xhttp.setRequestHeader("Content-Type", "application/json");
  xhttp.setRequestHeader("Authorization", `Bearer ${API_KEY}`);
  xhttp.send(requestString);

  xhttp.onload = function () {
    if (xhttp.status === 200) {
      let data = JSON.parse(xhttp.responseText);

      alert(
        `Message sent successfully to ${data.to}. SMS cost is ${data.cost}. New Balance is ${data.balance}`
      );

      document.getElementById("fromId").value = "";
      document.getElementById("toId").value = "";
      document.getElementById("messageId").value = "";
    } else {
      console.error("Request failed:", xhttp.responseText);
    }
  };
});
