
window.onload = function(){
    loadClients();
}

async function loadClients() {
    const request = await fetch('/api/clients', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const clientList = await request.json();
    let listClientHTML = '';

    for (let client of clientList) {
        let clientHTML = '<tr>\n' +
            '<td name="id_field" class="text-center">' + client.id + '</td>\n' +
            '<td name="name_field" class="text-center">' + client.name + '</td>\n' +
            '<td name="address_field" class="text-center">' + client.address + '</td>\n' +
            '<td name="phoneNumber_field" class="text-center">' + client.phoneNumber + '</td>\n' +
            '<td name="email_field" class="text-center">' + client.email + '</td>\n' +
            '<td name="clientType_field" class="text-center">' + client.clientType + '</td>\n' +
            '<td name="password_field" class="text-center">' + client.password + '</td>\n' +
            '<td>' +
            '<div class="d-grid gap-2 d-md-block">\n' +
            '<a class="btn btn-danger btn-circle btn-sm" onclick="deleteClient(' + client.id + ')" type="button">Eliminar</a>\n' +
            '</div>' +
            '</td>\n' +
            '</tr>';
        listClientHTML += clientHTML;
    }
    document.querySelector('#dataClientsTable tbody').outerHTML = listClientHTML;
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


