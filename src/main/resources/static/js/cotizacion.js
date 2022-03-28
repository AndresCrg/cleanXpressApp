function resultCheckBox() {
    if (document.getElementById('priority').checked == true) {
        return 1
    }
    return 0
}

async function registerService(){
    let dataService = {
        workingDay: document.getElementById('working-day').value,
        frequency: document.getElementById('frecuency').value,
        date: document.getElementById('date').value,
        priority: resultCheckBox(),
        stateService:'cotizado',
        clientId:{
            id:localStorage.getItem('document_client'),
            password: localStorage.getItem('password_client')
        }
    }
    const request = await fetch('/api/services', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dataService)
    });
}


async function deleteClient(id){
    if(confirm('Desea eliminar cliente?')){
        const request = await fetch('/api/clients/' + id, {
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


