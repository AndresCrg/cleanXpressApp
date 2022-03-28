window.onload = function(){
    loadListEmployees();
}

async function loadListEmployees() {
    const request = await fetch('/api/employees', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const employeeList = await request.json();
    let listClientHTML = '';

    for (let employee of employeeList) {
        let clientHTML =
            '<tr>\n' +
            '<td name="doc_field" class="text-center">' + employee.doc + '</td>\n' +
            '<td name="name_field" class="text-center">' + employee.name + '</td>\n' +
            '<td name="name_field" class="text-center">' + promedio + '</td>\n' +
            '<td name="name_field" class="text-center">' + employee.state + '</td>\n' +
            '</tr>';
        listClientHTML += clientHTML;
    }
    document.querySelector('#dataEmployeesListTable tbody').outerHTML = listClientHTML;
}
/*
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
 */