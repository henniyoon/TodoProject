function checkForm() {
	var obj_todoList = document.querySelector('input[name="title"]');
	if(obj_todoList.value.length <= 0) {
//		document.getElementById("plan").className = "form-control form-control-sm fieldError";
//		obj_todoList.classList.remove('is-valid');
		obj_todoList.classList.add('is-invalid');
		return false;
	}
	obj_todoList.classList.remove('is-invalid');
//	obj_todoList.classList.add('is-valid');
	return true;
}