
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
        }else
            err2.style.display = "none";
    }
}
