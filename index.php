<!DOCTYPE html>
    <html lang="en">
        <head>
            <title>login with Facebook using JavaScript SDK by CodexWorld</title>
 <script>
 window.fbAsyncInit = function() {
    // FB JavaScript SDK configuration and setup
    FB.init ({
        appId  : '171653193432643', //FB App ID
        cookie :  true,
        xfbml  :  true,
        version:  'v2.8'    
    });
    // Check whether the user already logged in
      FB.getLoginStatus(function(response)){
        // display data user
        getFbUserData();
      }
 });
 };
 
 // load the javaScript SDK asynchronously
 (function(d, s, id)) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementBy(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/adk.js";
    fjs.parentNode.insertBefore(js, fjs);
 } (document, 'script', 'facebook-jssdk'));
 
 //Facebook login with JavaScript SDK
   function fblogin(){
       if (response.authResponse){
           //Get and display the user profile data
           getFbUserData();
       } else {
            document.getElementsById('status').innerHTLM = 'User cancelled login or did not fully authorize.';
       }
    }, (scope: 'email'});
   }
   // fetch the user profile data facebook
   function getFbUserData(){
    FB.api('/me', {local: 'en_US', fields: 'id,first_name,last_name,email,link,gender,local,picture'}),
    function(response) {
        document.getElementById('fblink').setAttribute("onclik","fblogout()");
        document.getElementById('fblink').innerHTML = 'Logout from Facebook';
        document.getElementById('status').innerHTML = 'Thanks for logging in, '+ response.first_name + '!';
        document.getElementById('userData').innerHTML("onclik","fblogout()");
        
        
    }
   }
 </script>
        </head>
    </html> 