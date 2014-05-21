// ==UserScript==
// @name          AutoMaraLogin
// @author        vlad.dima
// @namespace     http://www.metrosystems.net
// @description   Autocomplete login screen for MARA applications
// @include       *ApplicationModule*
// ==/UserScript==

//=============== ENTER USERNAME AND PASSWORD HERE ===============
var USERNAME = 'vdima';
var PASSWORD = 'vdima345';

//=============== DO NOT MODIFY BELOW THIS LINE ===============
// create an observer instance
var observer = new MutationObserver(function(mutations) {
  mutations.forEach(function(mutation) {
      //When the login form is appended to the DOM populate the username and password fields
      if(mutation.addedNodes[0].getAttribute('id')=='x-auto-2') {
        document.getElementById('x-auto-17-input').value=USERNAME;
        document.getElementById('x-auto-18-input').value=PASSWORD;
        //Stop observing
	  	observer.disconnect();
      }
  });    
});
  
// configuration of the observer:
var config = { attributes: true, childList: true, characterData: true, subtree : true };

// pass in the target node, as well as the observer options
observer.observe(document.body, config);