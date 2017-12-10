
$(document).ready(function(){
    document.getElementById("txtNUA").value = '';
});

function openModal(){
    var modal = document.getElementById("myModal");
    modal.style.display = "block";
}

function validateEntrada(){
    var nua = document.getElementById("formulario:txtNUA");

    if(  nua.value !== "" )
        PF("entrar").show();
}

function limpiarTxtNUA(){
    document.getElementById("formulario:txtNUA").value = '';
}

function validateSalida(){
    var nua = document.getElementById("formulario:txtNUA");

    if(  nua.value !== "" )
        PF("salir").show();
}

function openWelcomeModal(){
    var modal = document.getElementById("welcomeModal");
    modal.style.display = "block";
}

function closeWelcomeModal(){
    var modal = document.getElementById("welcomeModal");
    modal.style.display = "none";
}

function openWelcome(){
    var modal = document.getElementById("welcome");
    modal.style.display = "block";
    closeWelcomeModal();
}

function closeWelcome(){
    var modal = document.getElementById("welcome");
    modal.style.display = "none";
    document.getElementById("formulario:txtNUA").value = '';
}

function openSkillsModal(){
    var modal = document.getElementById("skillsModal");

    modal.style.display = "block";
    closeVerifyBook();
    closeRegisterBook();
}

function closeSkillsModal(){
    var modal = document.getElementById("skillsModal");
    modal.style.display = "none";

    document.getElementById("formulario:txtNUA").value = '';
}

function openVerifyBook(){
    var modal = document.getElementById("verifyBook");

    modal.style.display = "block";
}

function closeVerifyBook(){
    var modal = document.getElementById("verifyBook");
    modal.style.display = "none";
    openRegisterBook();
}

function openRegisterBook(){
    var modal = document.getElementById("registerBook");

    modal.style.display = "block";
}

function closeRegisterBook(){
    var modal = document.getElementById("registerBook");
    modal.style.display = "none";

    document.getElementById("formulario:txtNUA").value = '';
    openSkillsModal();
}

function notUser(){
    document.getElementById("txtNUA").value = '';
    alert('No eres un usuario registrado');
}
