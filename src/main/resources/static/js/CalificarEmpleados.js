window.onload = function(){
    loadQualify();
}

async function loadQualify() {
    const request = await fetch('/api/employees', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const employeetListList = await request.json();
    let listClientHTML = '';

    for (let employee of employeetList) {
        let clientHTML =
            '<tr>\n' +
            '<td name="doc_field" class="text-center">' + employee.doc + '</td>\n' +
            '<td name="name_field" class="text-center">' + employee.name + '</td>\n' +
            '<td>\n' +
            '      <select name="qualification" class="browser-default">\n' +
            '          <option value="" disabled selected>Seleccione</option>\n' +
            '          <option value="1">1</option>\n' +
            '          <option value="2">2</option>\n' +
            '          <option value="3">3</option>\n' +
            '          <option value="4">4</option>\n' +
            '          <option value="5">5</option>\n' +
            '      </select>\n' +
            '</td>\n'+
            '<td>\n' +
            '      <div class="input-field col s12">\n' +
            '           <textarea name="comment" id="textarea2" class="materialize-textarea" data-length="100"></textarea>\n' +
            '\n' +
            '       </div>\n' +
            '</td>'+
            '<td>' +

            '<a class="waves-effect waves-light btn-small deep-orange lighten-2" onclick="qualifyEmployee(' + employee.doc + ')">' +
            '<i class="material-icons right">send</i>Enviar' +
            '</a>\n' +
            '</td>\n' +
            '</tr>';
        listClientHTML += clientHTML;
    }
    document.querySelector('#dataEmployeesTable tbody').outerHTML = listClientHTML;
}

async function qualifyEmployee(id){
    if(confirm('Desea calificar al empleado?')){
        const request = await fetch('/api/employees/' + id, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
    }else{
        return;
    }
    location.reload();
}