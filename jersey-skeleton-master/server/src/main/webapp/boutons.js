function getInscription() {
    var x = document.getElementById('container');
    if(x.style.display === 'none') {
        x.style.display = 'block';
        $("#recruteur").hide();
        $("#etudiant").hide();
    } else {
        x.style.display = 'none';
    }
}

function getInscriptionRecruteur() {
    var x = document.getElementById('container_recruteur');
    if(x.style.display === 'none') {
        x.style.display = 'block';
        $("#recruteur").hide();
        $("#etudiant").hide();
    } else {
        x.style.display = 'none';
    }
}

function getIdentificationEtudiant() {
    var x = document.getElementById('profil');
    if(x.style.display === 'none') {
        x.style.display = 'block';
        $("#container").hide();
    } else {
        x.style.display = 'none';
    }
}

function getCandidats() {
    var x = document.getElementById('candidats');
    if(x.style.display === 'none') {
        x.style.display = 'block';
        $("#div_offres").hide();
    } else {
        x.style.display = 'none';
    }
}

function getCandidatsProfil() {
    var x = document.getElementById('profil');
    if(x.style.display === 'none') {
        x.style.display = 'block';
        $("#div_offres").hide();
    } else {
        x.style.display = 'none';
    }
}


/*function getRetour() {
    var x = document.getElementById('container');
    if(x.style.display === 'none') {
        x.style.display = 'block';
        $("#recruteur").show();
        $("#etudiant").show();
    } else {
        x.style.display = 'none';
    }
}*/