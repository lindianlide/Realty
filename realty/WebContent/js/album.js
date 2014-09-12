function showPic (whichpic) { 	
 if (document.getElementById) { 		
    document.getElementById('placeholder').src = whichpic.href; 
    document.getElementById('ShowLightBox').href = whichpic.href;
  	return false; 	
  } else { 		
    return true; 	
  } 
}