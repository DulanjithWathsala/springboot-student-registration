console.log("Connected");


function register() {
    let firstName = document.getElementById("first-name").value;
    let lastName = document.getElementById("last-name").value;
    let province = document.getElementById("opt-province").value;

    let requestBody = {
        "firstName": firstName,
        "lastName": lastName,
        "province": province
    };

    fetch("http://localhost:8080/register-student",
        {
            method: "POST",
            body: JSON.stringify(requestBody),
            headers: {
                "Content-type": "application/json"
            },
        })
        .then((res) => res.json())
        .then((data) => {
            console.log(data);

            const toastLiveExample = document.getElementById('liveToast');
            const toastBootstrap = bootstrap.Toast.getOrCreateInstance(toastLiveExample);
            toastBootstrap.show();
        })
}
