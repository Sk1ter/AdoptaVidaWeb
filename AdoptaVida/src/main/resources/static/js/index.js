document.addEventListener("DOMContentLoaded", () => {
    const navbar = document.getElementById("navbarScroll");

    window.addEventListener("scroll", () => {
        if (window.scrollY > 30) {
            navbar.classList.add("navbar-transparent");
        } else {
            navbar.classList.remove("navbar-transparent");
        }
    });
});


document.getElementById("registerForm").addEventListener("submit", async function (e) {
            e.preventDefault();

            const data = {
                nombres: document.getElementById("nombres").value,
                apellido: document.getElementById("apellido").value,
                email: document.getElementById("email").value,
                dni: document.getElementById("dni").value,
                telefono: document.getElementById("telefono").value,
                password: document.getElementById("password").value
            };

            console.log("JSON enviado:");
            console.log(JSON.stringify(data, null, 2));

            const response = await fetch("/api/auth/register", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
            });

            if (response.ok) {
                alert("Usuario registrado correctamente");
            } else {
                alert("Error al registrar usuario");
            }
        });