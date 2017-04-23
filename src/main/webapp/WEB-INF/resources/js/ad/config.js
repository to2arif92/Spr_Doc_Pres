/**
 * Created by ArIF on 04-Jan-17.
 */


/* maintain User related dropdown based on User's login status */

if (Modernizr.localstorage){
    var loginFlag = localStorage.getItem("userActiveFlag");
    console.log("userActiveFlag (client): "+ loginFlag);
    if (loginFlag === "true"){
        // hide 'login', 'signup' & unhide 'logout'
        $(document).ready(function() {  // here, ready state is included because it wont work, as <script> is loaded before target Elements
            $("#dropdownUser li[name=dropdownLogin]").hide();
            $("#dropdownLogout").removeAttr("hidden");
        });
    } else {
        console.log("No active user found !");
    }
} else {
    console.log("Alert: Local Storage is not supported by the browser");
}

/* Replace login form, giving a message that 'you are already logged in, redirecting you to home (timeout)' */




/* Cart.html */
/* Increment or decrement item's Quantity */

