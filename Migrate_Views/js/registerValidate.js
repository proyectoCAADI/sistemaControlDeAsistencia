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

function validate(){
    var nua = document.getElementById("txtNUA");
    var err1 = document.getElementById("errMessage1");
    var err2 = document.getElementById("errMessage2");
    var digits = nua.value.split("");

    if( isNaN(nua.value) ){
        err1.style.display = 'block';
        err2.style.display = 'none';
        nua.value = '';
    }else if( nua.value == "" ){
            err1.style.display = 'none';
            err2.style.display = 'none';
    }else{
        err1.style.display = 'none';

        if( digits.length != 6 ){
            err2.style.display = "block";
            nua.value = '';
        }else{
            err2.style.display = "none";
            check(nua);
        }
    }
}

function skill(value){
    if( value == 'Grammar')  
        confirmar();
    else if( value == 'Listening')
        confirmar();
    else if( value == 'Reading')
        confirmar();
    else if( value == 'Speaking')
        confirmar();


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

function isNotTheRightUser(){
    var obj = document.getElementById("btnModalCancelar");
    if (obj === null) {
        openWelcomeModal();
        flag1 = true;
    }
    else if ( obj !== null ){
        closeWelcomeModal();
        flag1 = false;   
    }
    document.getElementById("txtNUA").value = '';
    alert('Ingresa de manera correcta tu NUA');
}
function confirmar(){
    var opcion = confirm("¿Estás seguro que esa es la actividad?");
    if(opcion === true)
        closeSkillsModal();
    else
        openSkillsModal();
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
