var flag1 = false;

$(document).ready(function(){
    var txtBox = document.getElementById("txtNUA");
});

function check(nua){
    if(( nua.value == 810243 )  && ( !flag1 )){
        openWelcomeModal();
        flag1 = true;
    }
    else if ( nua.value == 810243 ){
        openSkillsModal();
        flag1 = false;
    }
    else{
        notUser();
    }
}

function onfocus(){
    var err1 = document.getElementById("errMessage1");
    var err2 = document.getElementById("errMessage2");

    err1.style.display = 'none';
    err2.style.display = 'none';
}


function validateEntrada(){
    var nua = document.getElementById("formulario:txtNUA");

    if(  nua.value !== "" )
        PF("entrar").show();
}


function validateSalida(){
    var nua = document.getElementById("formulario:txtNUA");

    if(  nua.value !== "" )
        PF("salir").show();
    }


function skill(value){

    if( value == 'Grammar'){
        closeSkillsModal();
        alert('Habilidad: Grammar');
    }else if( value == 'Listening'){
        closeSkillsModal();
        alert('Habilidad: Listening');
    }else if( value == 'Reading'){
        closeSkillsModal();
        alert('Habilidad: Reading');
    }else if( value == 'Speaking'){
        closeSkillsModal();
        alert('Habilidad: Speaking');
    }

    document.getElementById("txtNUA").value = '';
}

function openWelcomeModal(){
    var modal = document.getElementById("welcomeModal");

    modal.style.display = "block";
}

function closeWelcomeModal(){
    var modal = document.getElementById("welcomeModal");
    modal.style.display = "none";
    document.getElementById("txtNUA").value = '';
}

function openSkillsModal(){
    var modal = document.getElementById("skillsModal");

    modal.style.display = "block";
}

function closeSkillsModal(){
    var modal = document.getElementById("skillsModal");
    modal.style.display = "none";

    document.getElementById("txtNUA").value = '';
}

window.onclick = function(event) {
    var modal = document.getElementById("welcomeModal");
    
    if (event.target === modal ) {
        modal.style.display = "none";
    }

    document.getElementById("txtNUA").value = '';
}

function notUser(){
    document.getElementById("txtNUA").value = '';
    alert('No eres un usuario registrado');
}