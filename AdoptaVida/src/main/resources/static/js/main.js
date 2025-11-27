const button = document.getElementById("btnEditar");
const fields = document.querySelectorAll(".editable-field");

button.addEventListener("click", () => {
	const isEditing = button.innerText === "Editar";

	if (isEditing) {
		button.innerText = "Guardar";
		button.classList.remove("btn-primary");
		button.classList.add("btn-success");

		fields.forEach(input => input.disabled = false);
	} else {

		button.innerText = "Editar";
		button.classList.remove("btn-success");
		button.classList.add("btn-primary");

		fields.forEach(input => input.disabled = true);

	}
});


