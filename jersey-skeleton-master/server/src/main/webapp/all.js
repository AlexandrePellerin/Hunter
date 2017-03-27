function getUserBdd(name) {
	getUserGeneric(name, "v1/user/");
}

function getUserGeneric(name, url) {
	$.getJSON(url + name, function(data) {
		afficheUser(data);
	});
}

function getForAll() {
	getSecure("v1/secure/who");
}

//Au clic du bouton Profil candidat affiche la page avec la liste des candidats
function getProfilCandidat() {
     $.ajax
     ({
       type: "GET",
       url: "v1/user",
       dataType: 'json',
       success: function (data) {
    	 getCandidats();
       },
       error : function(jqXHR, textStatus, errorThrown) {
       			alert('error: ' + textStatus);
       		}
     });
}

//Vérifie si les champs login et mot de passe ne sont pas vides
 function getSecure(url) {
 if(($("#userlogin").val() != "") && ($("#passwdlogin").val() != "")) {
     console.log($("#passwdlogin").val());
     console.log($("#userlogin").val());
     $.ajax
     ({
       type: "GET",
       url: url,
       dataType: 'json',
       beforeSend : function(req) {
        req.setRequestHeader("Authorization", "Basic " + btoa($("#userlogin").val() + ":" + $("#passwdlogin").val()));
       },
       success: function (data) {
           console.log(data);
           if(data.id != -1) {
               getIdentification();
           
           } else {
               alert('Le login ou le mot de passe a été mal saisi')
           }
           
       },
       error : function(jqXHR, textStatus, errorThrown) {
       			alert('error: ' + textStatus);
       		}
     });
     } else {
         alert('Le login ou le mot de passe a été mal saisi');
     $.getJSON(url, function(data) {
     	    afficheUser(data);
        });
 }
 }

function postUserBdd(name, alias, email, pwd) {
    postUserGeneric(name, alias, email, pwd, "v1/user/");
}

function postUserGeneric(name, alias, email, pwd, url) {
	console.log("postUserGeneric " + url)
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : url,
		dataType : "json",
		data : JSON.stringify({
			"name" : name,
			"alias" : alias,
			"email" : email,
			"password" : pwd,
			"id" : 0
		}),
		success : function(data, textStatus, jqXHR) {
			afficheUser(data);
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log('postUser error: ' + textStatus);
		}
	});
}

function listUsersBdd() {
    listUsersGeneric("v1/user/");
}

function listUsersGeneric(url) {
	$.getJSON(url, function(data) {
		afficheListUsers(data)
	});
}

function afficheUser(data) {
	console.log(data);
	$("#reponse").html(data.id + " : <b>" + data.alias + "</b> (" + data.name + ")");
}

//Affiche la liste des utilisateurs
function afficheListUsers(data) {
	var html = '<ul>';
	var index = 0;
	for (index = 0; index < data.length; ++index) {
		html = html + "<li>"+ data[index].name + "</li>";
	}
	html = html + "</ul>";
	$("#reponse").html(html);
}

function listEtudiantsBdd() {
    listEtudiantsGeneric("v1/Etu/");
}

function listEtudiantsGeneric(url) {
    $.getJSON(url, function(data){
        afficheListEtudiants(data);          
    });
}

//Affiche la liste des étudiants
function afficheListEtudiants(data) {
    var html = '<ul>';
    var i = 0;
    for(i = 0; i < data.length; ++i) {
        html = html + "<li>" + data[index].nom + "</li>";
    }
    html = html + "</ul>";
    $("#reponse").html(html);
}

//Affiche la page d'authentification pour le recruteur
function getAuthRecruteur() {
   $.ajax
     ({
       type: "GET",
       url: "v1/user",
       dataType: 'json',
       success: function (data) {
    	 document.location.href="index.html";
       },
       error : function(jqXHR, textStatus, errorThrown) {
       			alert('error: ' + textStatus);
       		}
     }); 
}