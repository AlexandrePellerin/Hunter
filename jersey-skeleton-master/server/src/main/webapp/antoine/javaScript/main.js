// progressbar.js@1.0.0 version is used
// Docs: http://progressbarjs.readthedocs.org/en/1.0.0/




var Display_PB_1 = new ProgressBar.Circle(PB_1, {
  color: '#000',
  // This has to be the same size as the maximum width to
  // prevent clipping
  strokeWidth: 4,
  trailWidth: 3,
  easing: 'easeInOut',
  duration: 1400,
  text: {
    autoStyleContainer: false
  },
  from: { width: 3 },
  to: {  width: 3 },
  // Set default step function for all animate calls

  step: function(state, circle) {

    var line = new ProgressBar.Line('#PB_1');
    var path = document.querySelector('#PB_1 > svg > path:last-child');
    var value = Math.round(circle.value() * 100);
    if(value<50){
        path.setAttribute("stroke", "rgba(300, "+(value*6)+", 0, 1)"); //decoloration du rouge au jaune
    }else{
        path.setAttribute("stroke", "rgba("+(600-(value*6))+", 300, 0, 1)"); //decoloration du jaune au vert
    }

    if (value === 0) {
      circle.setText('');
    } else {
      circle.setText("<span class=\"PB_valeur\">"+value+"</span><span class=\"PB_unite\">%</span><br><span class=\"PB_text\">Product</span");
    }

  }     
});

Display_PB_1.animate(0.27);



var Display_PB_2 = new ProgressBar.Circle(PB_2, {
  color: '#000',
  // This has to be the same size as the maximum width to
  // prevent clipping
  strokeWidth: 4,
  trailWidth: 3,
  easing: 'easeInOut',
  duration: 1400,
  text: {
    autoStyleContainer: false
  },
  from: { color: '#ff0000', width: 3 },
  to: { color: '#00ff00', width: 3 },
  // Set default step function for all animate calls
  step: function(state, circle) {

    var line = new ProgressBar.Line('#PB_2');
    var path = document.querySelector('#PB_2 > svg > path:last-child');
    var value = Math.round(circle.value() * 20);


    if(value<10){
        path.setAttribute("stroke", "rgba(300, "+(value*30)+", 0, 1)"); //decoloration du rouge au jaune
    }else{
        path.setAttribute("stroke", "rgba("+(600-(value*30))+", 300, 0, 1)"); //decoloration du jaune au vert
    }
    if (value === 0) {
      circle.setText('');
    } else {
      circle.setText("<span class=\"PB_valeur\">"+value+"</span><span class=\"PB_unite\">months</span><br><span class=\"PB_text\">Runway</span");
    }

  }     
});

Display_PB_2.animate(3/20);



var Display_PB_3 = new ProgressBar.Circle(PB_3, {
  color: '#000',
  // This has to be the same size as the maximum width to
  // prevent clipping
  strokeWidth: 4,
  trailWidth: 3,
  easing: 'easeInOut',
  duration: 1400,
  text: {
    autoStyleContainer: false
  },
  from: { width: 3 },
  to: { width: 3 },
  // Set default step function for all animate calls
  step: function(state, circle) {


    var line = new ProgressBar.Line('#PB_3');
    var path = document.querySelector('#PB_3 > svg > path:last-child');
    var value = Math.round(circle.value() * 100);
    if(value<50){
        path.setAttribute("stroke", "rgba(300, "+(value*6)+", 0, 1)"); //decoloration du rouge au jaune
    }else{
        path.setAttribute("stroke", "rgba("+(600-(value*6))+", 300, 0, 1)"); //decoloration du jaune au vert
    }

    if (value === 0) {
      circle.setText('');
    } else {
      circle.setText("<span class=\"PB_valeur\">"+value+"</span><span class=\"PB_unite\">%</span><br><span class=\"PB_text\">Conversion</span");
    }

  }     
});

Display_PB_3.animate(0.24);




var Display_PB_4 = new ProgressBar.Circle(PB_4, {
  color: '#000',
  // This has to be the same size as the maximum width to
  // prevent clipping
  strokeWidth: 4,
  trailWidth: 3,
  easing: 'easeInOut',
  duration: 1400,
  text: {
    autoStyleContainer: false
  },
  from: {width: 3 },
  to: {width: 3 },
  // Set default step function for all animate calls
  step: function(state, circle) {

var line = new ProgressBar.Line('#PB_4');
    var path = document.querySelector('#PB_4 > svg > path:last-child');
    var value = Math.round(circle.value() * 100);

    if(value<50){
        path.setAttribute("stroke", "rgba(300, "+(value*6)+", 0, 1)"); //decoloration du rouge au jaune
    }else{
        path.setAttribute("stroke", "rgba("+(600-(value*6))+", 300, 0, 1)"); //decoloration du jaune au vert
    }

    if (value === 0) {
      circle.setText('');
    } else {
      circle.setText("<span class=\"PB_valeur\">"+value+"</span><span class=\"PB_unite\">%</span><br><span class=\"PB_text\">Engagment</span");
    }

  }     
});

Display_PB_4.animate(1);

