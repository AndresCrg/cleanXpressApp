async function registerEmployee(){
    let dataEmployee = {
        id: document.getElementById('doc').value,
        name: document.getElementById('name').value,
        address: document.getElementById('address').value,
        phoneNumber: document.getElementById('phone').value,
        email: document.getElementById('email').value,
        state: 'DIS',
    }
    console.log(dataEmployee)
    const request = await fetch('/api/employees', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dataEmployee)
    });
}