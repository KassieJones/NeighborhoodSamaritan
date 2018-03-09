<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="//d2t45z63lq9zlh.cloudfront.net/panda-v0.0.5.min.js"></script>

<form id="panda_cc_form">
  <div>
    <label>First Name</label>
    <input data-panda="first_name" type="text">
  </div>

  <div>
    <label>Last Name</label>
    <input data-panda="last_name" type="text">
  </div>

  <div>
    <label>Credit Card Number</label>
    <input data-panda="credit_card" type="text">
  </div>

  <div>
    <label>Expiration</label>
    <input data-panda="expiration" type="text">
  </div>

  <div>
    <label>CVV</label>
    <input data-panda="cvv" type="text">
  </div>

  <div id="tokenize">
    <button type="submit">Enter Payment</button>
  </div>
</form>

<script>
  // Call Panda.init() with your Panda Publishable Key and the DOM id of the
  // credit card-related form element

  Panda.init('pk_test_KxtUsfH6KZPB9KvM3GFr5g', 'panda_cc_form');

  Panda.on('success', function(cardToken) {
    // You now have a token you can use to refer to that credit card later.
    // This token is used in PandaPay API calls for creating donations and grants
    // so that you don't have to worry about security concerns with dealing with
    // credit card data.
  });

  Panda.on('error', function(errors) {
    // errors is a human-readable list of things that went wrong
    //  (invalid card number, missing last name, etc.)
  });
</script>
</body>
</html>