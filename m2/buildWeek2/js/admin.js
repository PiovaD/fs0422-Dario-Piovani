Swal.fire({
    title: 'Password',
    input: 'password',
    inputAttributes: {
      autocapitalize: 'off'
    },
    showCancelButton: true,
    confirmButtonText: 'Entra',
    
  }).then((result) => {
    if (result.isConfirmed) {

        if (result.value == 'Admin000'){

            fetch(userAPI)
            .then(res => res.json())
            .then(data => {
                let table = new Table("#target-table", data)
            })

        }else{

            Swal.fire({
                position: 'top',
                icon: 'error',
                title: 'Password errata',
                showConfirmButton: false,
                timer: 2000
            }).then(() => location.href = 'index.html')

        }        
    
    }else{
        location.href = 'index.html'
    }
  })


