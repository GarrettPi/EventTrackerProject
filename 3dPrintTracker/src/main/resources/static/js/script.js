var init = function(e){
	console.log('page loaded');
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/prints');
	xhr.onreadystatechange = function(){
		if(xhr.status < 400 && xhr.readyState === 4){
			var data = JSON.parse(xhr.responseText);
			console.log(data);
			displayAllPrints(data);
		}
		else if (xhr.readyState === 4 && xhr.status >= 400) {
			console.log('******************some Error*********************');
		}
	};
	xhr.send(null);
};

window.addEventListener('load', init);

var listItems = document.getElementsByClassName('lr');
var singleResult = document.getElementById('singleResult');
var newPrintForm = document.newPrintForm;
console.log(newPrintForm);

var addPrint = function(e){
	e.preventDefault();
	console.log('clicked');
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/prints/');
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && (xhr.status == 200 || xhr.status === 201)){
			var data = JSON.parse(xhr.responseText);
			console.log('ambiguous log');
			console.log(data);
			if(alert('New Print Created Successfully!')){}
			else window.location.reload();
		}
		else if(xhr.readyState === 4 && xhr.status >= 400) {
			console.log('creation failed bruv');
		}
	};

	var newPrint = {
		"name": newPrintForm.name.value,
		"duration": newPrintForm.duration.value,
		"materialConsumed": newPrintForm.materialConsumed.value,
		"photoUrl": newPrintForm.photoUrl.value,
		"printer": {
				"id": 1,
				"printerType": {
						"id": 1,
				}
		},
		"source": {
				"id": 1
		},
		"material": {
				"id": 1,
				"materialType": {
						"id": 1,
				}
		}
	};
	var newPrintJson = JSON.stringify(newPrint);
	console.log(newPrint);
	xhr.send(newPrintJson);
};

var itemClick = function(e){
	let detail = document.getElementById('singleResult');
	while(detail.firstElementChild){
		detail.removeChild(detail.firstElementChild);
	}
	let detailHeader = document.createElement('h3');
	detailHeader.textContent = this.firstElementChild.nextElementSibling.textContent;
	let form = document.createElement('form');
	form.name = 'editPrint';
	form.id = 'editPrintForm'

	let input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('name', 'id');
	input.setAttribute('readonly', true);
	input.setAttribute('value', this.firstElementChild.textContent);
	form.appendChild(input);

	input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('name', 'name');
	input.setAttribute('value', this.firstElementChild.nextElementSibling.nextElementSibling.textContent);
	form.appendChild(input);

	input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('name', 'photoUrl');
	input.setAttribute('value', this.firstElementChild.nextElementSibling.firstElementChild.src);
	form.appendChild(input);

	input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('name', 'materialConsumed');
	input.setAttribute('value', this.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.textContent);
	form.appendChild(input);

	input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('name', 'duration');
	input.setAttribute('value', this.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.textContent);
	form.appendChild(input);

	input = document.createElement('input');
	input.setAttribute('type', 'submit');
	input.setAttribute('name', 'submit');
	input.setAttribute('value', 'Edit');

	input.addEventListener('click', function(e){
		e.preventDefault();
		console.log('clicked');
		let form = document.getElementById('editPrintForm');
		var xhr = new XMLHttpRequest();
		xhr.open('PUT', 'api/prints/'+form.id.value);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && (xhr.status == 200 || xhr.status === 201)){
				var data = JSON.parse(xhr.responseText);
				console.log('ambiguous log');
				console.log(data);
				if(alert('Print '+form.id.value + ' updated successfully!')){}
				else window.location.reload();
			}
			else if(xhr.readyState === 4 && xhr.status >= 400) {
				console.log('edit failed bruv');
			}
		};
		var editedPrint = {
    	"id": form.id.value,
    	"name": form.name.value,
    	"duration": form.duration.value,
    	"materialConsumed": form.materialConsumed.value,
    	"photoUrl": form.photoUrl.value,
    	"printer": {
        	"id": 1,
        	"printerType": {
            	"id": 1,
        	}
    	},
    	"source": {
        	"id": 1
    	},
    	"material": {
        	"id": 1,
        	"materialType": {
            	"id": 1,
        	}
    	}
		};
		var printJson = JSON.stringify(editedPrint);
		console.log(editedPrint);
		xhr.send(printJson);
	});

	form.appendChild(input);

	input = document.createElement('input');
	input.setAttribute('type', 'submit');
	input.setAttribute('name', 'submit');
	input.setAttribute('value', 'Delete');

	input.addEventListener('click', function(e){
		e.preventDefault();
		let form = document.getElementById('editPrintForm');
		var xhr = new XMLHttpRequest();
		xhr.open('DELETE', 'api/prints/'+form.id.value);
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status < 400){
				if(alert('Print '+form.id.value + ' deleted successfully!')){}
				else window.location.reload();
			}
		};
		xhr.send(null);
	});

	form.appendChild(input);
	singleResult.appendChild(form);

	for(let row of listItems){
		row.style.backgroundColor = 'white';
	}
	this.style.backgroundColor = 'rgb(220, 220, 220)';
};

function displayAllPrints(data){
	var resultsDiv = document.getElementById('printsResults');
	let table = document.createElement('table');
	let row = document.createElement('tr');
	let h = document.createElement('th');
	h.textContent = 'Id';
	row.appendChild(h);
	h = document.createElement('th');
	h.textContent = 'Image';
	row.appendChild(h);
	h = document.createElement('th');
	h.textContent = 'Name';
	row.appendChild(h);
	h = document.createElement('th');
	h.textContent = "Material Used";
	row.appendChild(h);
	h = document.createElement('th');
	h.textContent = 'Print Duration';
	row.appendChild(h);
	h = document.createElement('th');
	h.textContent = 'Cost of Material';
	row.appendChild(h);
	row.className = 'lr';
	table.appendChild(row);
	for(let item of data){
		row = document.createElement('tr');
		let d = document.createElement('td');
		d.textContent = item.id;
		row.appendChild(d);
		d = document.createElement('td');
		let img = document.createElement('img');
		img.style.height = '100px';
		img.src = item.photoUrl;
		d.appendChild(img);
		row.appendChild(d);
		d = document.createElement('td');
		d.textContent = item.name;
		row.appendChild(d);
		d = document.createElement('td');
		d.textContent = item.materialConsumed;
		row.appendChild(d);
		d = document.createElement('td');
		d.textContent = item.duration;
		row.appendChild(d);
		d = document.createElement('td');
		d.textContent = '$' + Math.round((item.materialConsumed * item.material.cost) * 100) /100;
		row.appendChild(d);
		row.addEventListener('click', itemClick);
		row.className = 'lr';
		table.appendChild(row);
	}
	resultsDiv.appendChild(table);
}

newPrintForm.submit.addEventListener('click', addPrint);
