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

function getIdentification() {
    var x = document.getElementById('div_offres');
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