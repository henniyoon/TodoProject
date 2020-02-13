function checkForm() {
    var obj_title = document.querySelector('input[name="title"');
	var obj_deadline = document.querySelector('input[name="deadline"');
	var obj_no_dead = document.querySelector('input[name="deadline_check"');
	
	if(obj_title.value.length <= 0) {
		obj_title.classList.add('is-invalid');
		return false;
	} else {
		obj_title.classList.remove('is-invalid');
		
		obj_deadline.classList.remove('is-invalid');
		
		// CheckBox 체크 안했을 때
		if(!obj_no_dead.checked) {
			obj_deadline.disabled = false; // input date able
			// input date 날짜 지정 했을 때
			if(obj_deadline.value.length > 0) {
				obj_no_dead.disabled = true; // CheckBox disable
			// input date 날짜 지정 안했을 때
			} else {
				obj_no_dead.disabled = false; // CheckBox able
				obj_deadline.classList.add('is-invalid');
				return false;
			}
		// CheckBox 체크 했을 때	
		} else {
			obj_deadline.disabled = true; // input date disable
		}
	}
	return true;
}